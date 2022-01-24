package com.liferay.amf.profile.detail.web.portlet;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalService;
import com.liferay.amf.profile.detail.web.constants.AmfProfileDetailWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import amf.com.liferay.common.util.ProfileDetailPermissionCheckUtil;


/**
 * @author Argil DX
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfProfileDetailWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfProfileDetailWebPortletKeys.AMFPROFILEDETAILWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=screenName",
		"javax.portlet.supported-public-render-parameter=mvcRenderCommandName",
		"javax.portlet.supported-public-render-parameter=tag",
	},
	service = Portlet.class
)
public class AmfProfileDetailWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String screenName = ParamUtil.getString(renderRequest,"screenName");
		String tag = ParamUtil.getString(renderRequest,"tag");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if(screenName.isEmpty()) {
			OrderByComparator comparator = OrderByComparatorFactoryUtil.create("User", "userId", true);
			List<User> users=new ArrayList(Arrays.asList());
			List<User> allUsers=userLocalService.getUsers(themeDisplay.getCompanyId(), false, 0, -1, -1, comparator);
			if (!allUsers.isEmpty()) {
				for (User user : allUsers) {
					ProfileDetail profileDetail = profileDetailLocalService
							.getProfileDetailByUserId(themeDisplay.getCompanyId(), user.getUserId());
					boolean hasUserPermission = ProfileDetailPermissionCheckUtil.checkResourcePermission(renderRequest, user,
							profileDetail, themeDisplay);

					if (hasUserPermission) {
						users.add(user);
					}

				}
			}
			renderRequest.setAttribute("users", users);
		} 
		if("privacy".equalsIgnoreCase(tag)) {
			renderRequest.setAttribute("screenName", screenName);
			try {
			User user = userLocalService.getUserByScreenName(themeDisplay.getCompanyId(), screenName);
			ProfileDetail profileDetail = profileDetailLocalService.getProfileDetailByUserId(themeDisplay.getCompanyId(), user.getUserId());
			int privacyId = 0;
			if(Validator.isNotNull(profileDetail)) {
				privacyId = profileDetail.getPrivacy();
			}
			renderRequest.setAttribute("privacyId", privacyId);
			boolean hasEditPrivacyPermission = ProfileDetailPermissionCheckUtil.checkResourcePermission(renderRequest, user, profileDetail, themeDisplay);
			renderRequest.setAttribute("privacyId", privacyId);
			renderRequest.setAttribute("hasEditPrivacyPermission", hasEditPrivacyPermission);
			}catch (Exception e) {
				log.error("Error occur while redirecting on privacy setting");
			}
			include("/privacy-form.jsp", renderRequest, renderResponse);
		}
		
		else {
			super.render(renderRequest, renderResponse);
		}
	}
	
	
	
	@Reference
	UserLocalService userLocalService;
	
	
	@Reference 
	ProfileDetailLocalService profileDetailLocalService;
	 
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());


}