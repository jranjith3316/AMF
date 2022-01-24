package com.liferay.amf.profile.detail.web.portlet;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalService;
import com.liferay.amf.profile.detail.web.constants.AmfProfileDetailWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfProfileDetailWebPortletKeys.AMFPROFILEDETAILWEB,
		"mvc.command.name=updateProfile", "service.ranking:Integer=1000" }, service = MVCActionCommand.class)

public class UpdateUserProfileMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String screenName = ParamUtil.getString(actionRequest,"screenName");
		if(!screenName.isEmpty()) {
			User user = userLocalService.getUserByScreenName(themeDisplay.getCompanyId(), screenName);
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			boolean male = ParamUtil.getBoolean(actionRequest, "gender");
			String birthDate = ParamUtil.getString(actionRequest,"birthDate");
			
			if(Validator.isNotNull(user)) {
				user.setFirstName(firstName);
				user.setLastName(lastName);
				userLocalService.updateUser(user);
			}
			
			Contact contact = findByEntryNameContct(user.getUserId());

			if(Validator.isNotNull(contact)) {
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setBirthday(convertDate(birthDate));
				contact.setMale(male);
				contactLocalService.updateContact(contact);
			}
			
			ProfileDetail profileDetail=profileDetailLocalService.getProfileDetailByUserId(themeDisplay.getCompanyId(), user.getUserId());
			if(Validator.isNotNull(profileDetail)) {
				profileDetail.setUserName(screenName);
			}else {

				profileDetail = profileDetailLocalService
						.createProfileDetail(CounterLocalServiceUtil.increment(ProfileDetail.class.getName()));
				profileDetail.setUserId(user.getUserId());
				profileDetail.setUserName(screenName);
				profileDetail.setCreateDate(new Date());
			}
			profileDetail = setProfileDetails(profileDetail, actionRequest, themeDisplay);
			profileDetailLocalService.updateProfileDetail(profileDetail);

		}
	}
	
		
	public ProfileDetail setProfileDetails(ProfileDetail profileDetail, ActionRequest actionRequest, ThemeDisplay themeDisplay){
		String favoriteMovie = ParamUtil.getString(actionRequest, "favoriteMovie");
		String favoriteQuotes = ParamUtil.getString(actionRequest, "favoriteQuotes");
		String aboutMe = ParamUtil.getString(actionRequest, "aboutMe");
		String leastFavMovie = ParamUtil.getString(actionRequest, "leastFavMovie");
		String favoriteGenre = ParamUtil.getString(actionRequest, "favoriteGenre");
		String favoriteActor = ParamUtil.getString(actionRequest, "favoriteActor");

		profileDetail.setGroupId(themeDisplay.getScopeGroupId());
		profileDetail.setCompanyId(themeDisplay.getCompanyId());
		profileDetail.setAboutMe(aboutMe);
		profileDetail.setFavoriteQuotes(favoriteQuotes);
		profileDetail.setFavoriteGenre(favoriteGenre);
		profileDetail.setFavoriteMovie(favoriteMovie);
		profileDetail.setFavoriteActor(favoriteActor);
		profileDetail.setLeastFavMovie(leastFavMovie);
		profileDetail.setModifiedDate(new Date());
		return profileDetail;	
	}
	
		public Contact findByEntryNameContct(long userId) {

		    try {

		        ClassLoader classLoader = getClass().getClassLoader();

		        DynamicQuery contactQuery = DynamicQueryFactoryUtil.forClass(Contact.class, classLoader)
		            .add(RestrictionsFactoryUtil.eq("classPK", userId));


		        return (Contact) contactLocalService.dynamicQuery(contactQuery).get(0);
		    }
		    catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		        	log.error("Errors occurs in findByEntryNameContct", se);
		        }
		    }
			return null;
		   

		
	}
	
		 public Date convertDate(String birthDate) {
		        Date date = null;
		        SimpleDateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");
	            try {
	            	date = dateFormate.parse(birthDate);
		        } catch (ParseException e) {
		            log.error("Error while converting string to date :",e);
		        }
		        return date;
		    }
	@Reference
	UserLocalService userLocalService;
	
	@Reference
	ContactLocalService contactLocalService;
	
	@Reference
	ProfileDetailLocalService profileDetailLocalService;
	
	@Reference
	Portal portal;

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

}
