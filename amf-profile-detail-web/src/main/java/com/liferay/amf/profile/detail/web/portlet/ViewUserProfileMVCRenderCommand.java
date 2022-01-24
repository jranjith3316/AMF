package com.liferay.amf.profile.detail.web.portlet;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalService;
import com.liferay.amf.profile.detail.web.constants.AmfProfileDetailWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import amf.com.liferay.common.util.ProfileDetailPermissionCheckUtil;
import amf.com.liferay.profile.detail.common.model.ProfileDetailDTO;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AmfProfileDetailWebPortletKeys.AMFPROFILEDETAILWEB, 
		"mvc.command.name=/profile/view"
		}, service = MVCRenderCommand.class)

public class ViewUserProfileMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
		String tag = ParamUtil.getString(renderRequest,"tag");

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String screenName = ParamUtil.getString(renderRequest, "screenName");
			ProfileDetailDTO profileDetailModel = new ProfileDetailDTO();
			User user = userLocalService.getUserByScreenName(themeDisplay.getCompanyId(), screenName);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			if (Validator.isNotNull(user)) {
				
				ProfileDetail profileDetail = profileDetailLocalService
						.getProfileDetailByUserId(themeDisplay.getCompanyId(), user.getUserId());
				profileDetailModel.setUserId(user.getUserId());
				profileDetailModel.setScreenName(user.getScreenName());
				profileDetailModel.setFirstName(user.getFirstName());
				profileDetailModel.setLastName(user.getLastName());
				if (Validator.isNotNull(user.getBirthday())) {
					String dateOfbirth = sdf.format(user.getBirthday());
					profileDetailModel.setBirthDate(dateOfbirth);
				}
				profileDetailModel.setMale(user.isMale());
				profileDetailModel.setFavoriteGenreList(AmfProfileDetailWebPortletKeys.FAVORITE_GENRE_LIST);

				if (Validator.isNotNull(profileDetail)) {
					profileDetailModel.setAboutMe(profileDetail.getAboutMe());
					profileDetailModel.setFavoriteQuotes(profileDetail.getFavoriteQuotes());

					profileDetailModel.setFavoriteGenre(profileDetail.getFavoriteGenre());
					profileDetailModel.setFavoriteMovie(profileDetail.getFavoriteMovie());
					profileDetailModel.setLeastFavoriteMovie(profileDetail.getLeastFavMovie());
					profileDetailModel.setFavoriteActor(profileDetail.getFavoriteActor());
				}
			}

			renderRequest.setAttribute("profileDetail", profileDetailModel);
			boolean hasUserProfileEditPermission = ProfileDetailPermissionCheckUtil.checkPrivatePermission(themeDisplay,renderRequest, user);
			ProfileDetail profileDetail = profileDetailLocalService.getProfileDetailByUserId(themeDisplay.getCompanyId(), user.getUserId());
			boolean hasUserProfileViewPermission = ProfileDetailPermissionCheckUtil.checkResourcePermission(renderRequest, user, profileDetail, themeDisplay);
			if ("view".equals(tag)) {
				renderRequest.setAttribute("isReadonly", true);
				renderRequest.setAttribute("hideUpdate", true);
				renderRequest.setAttribute("hideEdit", false);
			} else {
				renderRequest.setAttribute("isReadonly", false);
				renderRequest.setAttribute("hideUpdate", false);
				renderRequest.setAttribute("hideEdit", true);
			}
			renderRequest.setAttribute("hasUserProfileEditPermission", hasUserProfileEditPermission);
			renderRequest.setAttribute("hasUserProfileViewPermission", hasUserProfileViewPermission);
			renderRequest.setAttribute("profileDetail", profileDetailModel);

			
			return "/view-profile-detail.jsp";

		 }catch (Exception e) {
			log.error("Exception Occured in MVC Render Class" + e.getMessage(), e);
		}
		return null;
	}

	
	@Reference
	UserLocalService userLocalService;
	
	@Reference
	ProfileDetailLocalService profileDetailLocalService;
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());


	
}
