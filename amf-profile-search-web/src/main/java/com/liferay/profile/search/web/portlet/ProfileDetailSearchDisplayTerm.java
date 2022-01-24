package com.liferay.profile.search.web.portlet;


import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class ProfileDetailSearchDisplayTerm extends DisplayTerms {

	public static final String STATUS = "status";

	public static final String[] VALID_TERMS = { STATUS };

	public ProfileDetailSearchDisplayTerm(PortletRequest portletRequest) {
		super(portletRequest);

		_status = ParamUtil.getString(portletRequest, STATUS);

	}

	private final String _status;

	public String get_status() {
		return _status;
	}
}
