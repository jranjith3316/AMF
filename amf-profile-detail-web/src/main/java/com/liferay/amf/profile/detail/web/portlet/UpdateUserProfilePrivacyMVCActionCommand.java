package com.liferay.amf.profile.detail.web.portlet;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalService;
import com.liferay.amf.profile.detail.web.constants.AmfProfileDetailWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfProfileDetailWebPortletKeys.AMFPROFILEDETAILWEB,
		"mvc.command.name=updatePrivacy", "service.ranking:Integer=1000" }, service = MVCActionCommand.class)

public class UpdateUserProfilePrivacyMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String screenName = ParamUtil.getString(actionRequest,"screenName");
		if(!screenName.isEmpty()) {
			int privacy = ParamUtil.getInteger(actionRequest,"privacy");
			User user = userLocalService.getUserByScreenName(themeDisplay.getCompanyId(), screenName);
			if(Validator.isNotNull(user)) {
				ProfileDetail profileDetail = profileDetailLocalService.getProfileDetailByUserId(themeDisplay.getCompanyId(), user.getUserId());
				if(Validator.isNotNull(profileDetail)) {
					profileDetail.setModifiedDate(new Date());
					profileDetail.setPrivacy(privacy);
				}else {
					profileDetail = profileDetailLocalService.createProfileDetail(
	                        CounterLocalServiceUtil.increment(ProfileDetail.class.getName()));
					profileDetail.setUserId(user.getUserId());
					profileDetail.setUserName(user.getScreenName());
					profileDetail.setCreateDate(new Date());
					profileDetail.setModifiedDate(new Date());
					profileDetail.setPrivacy(privacy);
				}
				profileDetailLocalService.updateProfileDetail(profileDetail);

			}
		}
	}
	
		
	@Reference
	UserLocalService userLocalService;
	
	@Reference
	ProfileDetailLocalService profileDetailLocalService;


	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

}
