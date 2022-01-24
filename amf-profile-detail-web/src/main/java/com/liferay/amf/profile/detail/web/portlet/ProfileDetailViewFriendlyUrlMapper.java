
package com.liferay.amf.profile.detail.web.portlet;

import com.liferay.amf.profile.detail.web.constants.AmfProfileDetailWebPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

@Component(property = { "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		"javax.portlet.name=" + AmfProfileDetailWebPortletKeys.AMFPROFILEDETAILWEB}, service = FriendlyURLMapper.class)

public class ProfileDetailViewFriendlyUrlMapper extends DefaultFriendlyURLMapper {

	private static final String MAPPING = "profile";

	@Override
	public String getMapping() {
		
		return MAPPING;
	}

}
