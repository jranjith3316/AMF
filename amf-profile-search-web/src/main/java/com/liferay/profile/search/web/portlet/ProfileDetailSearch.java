package com.liferay.profile.search.web.portlet;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class ProfileDetailSearch extends SearchContainer<ProfileDetail> {

	public static final String EMPTY_RESULTS_MESSAGE = "No Entries were found.";

	private static final Log _log = LogFactoryUtil.getLog(ProfileDetailSearch.class);

	private static final List<String> _headerNames = Arrays.asList("userName", "aboutMe");
	private static final Map<String, String> _orderableHeaders = new LinkedHashMap<String, String>() {
		{
			put("userName", "userName");
			put("aboutMe", "aboutMe");
		}
	};

	public ProfileDetailSearch(PortletRequest portletRequest, PortletURL iteratorURL) {

		super(portletRequest, new DisplayTerms(portletRequest), new DisplayTerms(portletRequest), "cur", DEFAULT_DELTA,
				iteratorURL, _headerNames, EMPTY_RESULTS_MESSAGE);

		try {
			setOrderableHeaders(_orderableHeaders);
		} catch (Exception e) {
			_log.error("Unable to initialize search", e);
		}
	}
}
