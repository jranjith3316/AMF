package amf.com.liferay.common.util;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;

public class ProfileDetailPermissionCheckUtil {
	
	public static final int PRIVATE_PERMISSION = 1; 
	public static final int PROTECTED_PERMISSION = 2; 


	public static boolean checkPrivatePermission(ThemeDisplay themeDisplay, RenderRequest request, User user) {
		try {
			User currentUser = PortalUtil.getUser(request);
			if(Validator.isNotNull(currentUser)) {
		        Role adminRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Administrator");
				if(currentUser.getUserId() == user.getUserId()||currentUser.getRoles().contains(adminRole)) {
					return true;
				}
			}
		}catch (Exception e) {
			log.error("Error occurs while checking PrivatePermission",e);
		}
		return false;		
	}
	
	public static boolean checkProtectedPermission(RenderRequest request, User user, ThemeDisplay themeDisplay) {
		try {
			String siteName = themeDisplay.getScopeGroup().getName(Locale.US);
			Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), siteName);
			User currentUser = PortalUtil.getUser(request);
			if(Validator.isNotNull(currentUser)) {
				List<Group> groups= currentUser.getGroups() ;
				if(currentUser.getUserId() == user.getUserId() || groups.contains(group)) {
					return true;
				}
			}
		}catch (Exception e) {
			log.error("Error occurs while checking ProtectedPermission",e);
		}
		return false;		
	}
	
	public static boolean checkPublicPermission(RenderRequest request, User user){
		return true;		
	}
	
	public static boolean checkResourcePermission(RenderRequest renderRequest, User user, ProfileDetail profileDetail, ThemeDisplay themeDisplay){
		boolean hasUserPermission = Boolean.FALSE;
		if(Validator.isNotNull(profileDetail)) {
			if(profileDetail.getPrivacy()== PRIVATE_PERMISSION) {
				hasUserPermission = checkPrivatePermission(themeDisplay, renderRequest, user);
			}else if(profileDetail.getPrivacy()==PROTECTED_PERMISSION) {
				hasUserPermission = checkProtectedPermission(renderRequest, user, themeDisplay);
			}else {
				hasUserPermission = checkPublicPermission(renderRequest, user);
			}						
			}else {
				hasUserPermission = checkPublicPermission(renderRequest, user);
			}
		return hasUserPermission;
	}
	
	private static Log log = LogFactoryUtil.getLog(ProfileDetailPermissionCheckUtil.class);

	
}
