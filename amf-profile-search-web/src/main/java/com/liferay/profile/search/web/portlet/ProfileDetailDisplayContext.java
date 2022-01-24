package com.liferay.profile.search.web.portlet;
import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

public class ProfileDetailDisplayContext {

	public ProfileDetailDisplayContext(RenderResponse renderResponse, RenderRequest renderRequest,
			HttpServletRequest request) {
		_renderResponse = renderResponse;
		_renderRequest = renderRequest;
		_httpServletRequest = request;

			_themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
	}

	/**
	 * Method to get portletURL
	 * 
	 * @return
	 */
	public PortletURL getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/view.jsp");
		portletURL.setParameter("groupId", String.valueOf(getScopeGroupId()));

		String delta = ParamUtil.getString(_renderRequest, "delta");

		if (Validator.isNotNull(delta)) {
			portletURL.setParameter("delta", delta);
		}

		String keywords = getKeywords();

		if (Validator.isNotNull(keywords)) {
			portletURL.setParameter("keywords", keywords);
		}

		return portletURL;
	}

	public long getScopeGroupId() {
		return _themeDisplay.getScopeGroupId();
	}

	protected String getKeywords() {
		if(Validator.isNotNull(ParamUtil.getString(_renderRequest, "keywords"))){
			return ParamUtil.getString(_renderRequest, "keywords");
		}
		return StringPool.BLANK;
	}

	protected int getStatus() {
		return ParamUtil.getInteger(_renderRequest, "status");
	}

	public String getSearchContainerId() {
		return "profileDetailSearchContainerId";
	}

	public String getSearchActionURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/view.jsp");
		portletURL.setParameter("groupId", String.valueOf(getScopeGroupId()));

		return portletURL.toString();
	}

	/**
	 * Method to get user submission list to show in search container format
	 * 
	 * @return
	 */
	public SearchContainer<?> getSearch() {
		PortletURL portletURL = getPortletURL();
		ProfileDetailSearch profileDetailSearch = new ProfileDetailSearch((PortletRequest) _renderRequest, portletURL);
		profileDetailSearch.setEmptyResultsMessage("No Data Found.");

		OrderByComparator<ProfileDetail> orderByComparator = OrderByComparatorFactoryUtil.create("ProfileDetail",
				"createDate", "desc");


		String keywords = getKeywords();
		
		LinkedHashMap<String, Object> params = new LinkedHashMap<>();
		params.put(Field.GROUP_ID, _themeDisplay.getSiteGroupId());



		List<ProfileDetail> profileDetails = null;
		profileDetails = ProfileDetailLocalServiceUtil.search(_themeDisplay.getCompanyId(), keywords, 0, params, profileDetailSearch.getStart(), profileDetailSearch.getEnd(), orderByComparator);
		profileDetailSearch.setResults(profileDetails);
		List<ProfileDetail> profileDetailForCount  = ProfileDetailLocalServiceUtil.search(_themeDisplay.getCompanyId(), keywords, 0, params, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);


		int size = Validator.isNotNull(profileDetailForCount) ? profileDetailForCount.size() : 0;
		profileDetailSearch.setTotal(size);
		return profileDetailSearch;
	}

	public int getTotalItems() {
		SearchContainer<?> searchContainer = getSearch();

		return searchContainer.getTotal();
	}

	
	
	public String getClearResultsURL() throws PortletException {
		PortletURL clearResultsURL = _renderResponse.createRenderURL();

		clearResultsURL.setParameter("mvcPath", "/view.jsp");
		clearResultsURL.setParameter("groupId", String.valueOf(getScopeGroupId()));
		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	protected boolean orderByStatus(String string) {
		if (Validator.isNull(getSelectedOrder()) && string.equalsIgnoreCase("asc")) {
			return true;
		} else if (string.equalsIgnoreCase(getSelectedOrder())) {
			return true;
		}
		return false;
	}

	public String getSelectedOrder() {
		return ParamUtil.getString(_renderRequest, "order");
	}

	
	private RenderResponse _renderResponse;
	private RenderRequest _renderRequest;
	private HttpServletRequest _httpServletRequest;
	private ThemeDisplay _themeDisplay;

	private Log _log = LogFactoryUtil.getLog(ProfileDetailDisplayContext.class);

}
