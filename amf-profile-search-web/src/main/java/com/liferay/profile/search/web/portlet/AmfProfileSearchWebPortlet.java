package com.liferay.profile.search.web.portlet;

import com.liferay.amf.profile.detail.model.ProfileDetail;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalService;
import com.liferay.amf.profile.detail.service.ProfileDetailLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.profile.search.web.constants.AmfProfileSearchWebPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import amf.com.liferay.common.util.ProfileDetailPermissionCheckUtil;
import amf.com.liferay.profile.detail.common.model.ProfileDetailDTO;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfProfileSearchWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfProfileSearchWebPortletKeys.AMFPROFILESEARCHWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AmfProfileSearchWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("favoriteGenreList", AmfProfileSearchWebPortletKeys.FAVORITE_GENRE_LIST);
		renderRequest.setAttribute("advanceSearchCheckIdCount",
				AmfProfileSearchWebPortletKeys.advanceSearchCheckBoxesMap.size());
		String keyword = renderRequest.getParameter("searchKeyword");
		String subQuery = renderRequest.getParameter("searchSubQuery");
		String toBirthDate = renderRequest.getParameter("searchToBirthDate");
		String fromBirthDate = renderRequest.getParameter("searchFromBirthDate");
		String criteria = renderRequest.getParameter("searchCriteria");
		if (Validator.isNotNull(keyword) || Validator.isNotNull(subQuery) || Validator.isNotNull(toBirthDate)
				|| Validator.isNotNull(fromBirthDate) || Validator.isNotNull(criteria)) {

			String[] checkedValues = renderRequest.getParameterValues("searchCheckedValues");
			buildSearchContainer(renderRequest, renderResponse, checkedValues, keyword, subQuery, toBirthDate, fromBirthDate, criteria);

			renderRequest.setAttribute("searchKeyword", keyword);
			renderRequest.setAttribute("searchFavoriteGenre", renderRequest.getParameter("searchFavoriteGenre"));
			renderRequest.setAttribute("searchToBirthDate", toBirthDate);
			renderRequest.setAttribute("searchFromBirthDate", fromBirthDate);
			renderRequest.setAttribute("searchCriteria", criteria);
			renderRequest.setAttribute("advanceSearchCheckIds",
					AmfProfileSearchWebPortletKeys.advanceSearchCheckBoxesMap);

			include("/advance-search.jsp", renderRequest, renderResponse);
		} else {
			Map checkedIds = AmfProfileSearchWebPortletKeys.advanceSearchCheckBoxesMap;

			if(Validator.isNotNull(renderRequest.getParameter("keyword"))) {
			List<String> checkedValues = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			sb.append("where");

			 String searchTerm = renderRequest.getParameter("keyword");
			checkedIds.forEach((key, value) -> {
				checkedValues.add(key.toString());
				sb.append(!"where".equalsIgnoreCase(sb.toString()) ?  "OR" 
						: StringPool.BLANK);
				sb.append(" pd." + key.toString() + " like ? ");
			});
			
			sb.append("OR pd.favoriteGenre like '%" + searchTerm + "%' ");				
			buildSearchContainer(renderRequest, renderResponse, checkedValues.toArray(new String[checkedValues.size()]), searchTerm, sb.toString(), toBirthDate, fromBirthDate, criteria);
			}
			renderRequest.setAttribute("advanceSearchCheckIds",
					checkedIds);
			super.render(renderRequest, renderResponse);
		}
	}

	public void buildSearchContainer(RenderRequest renderRequest, RenderResponse renderResponse, String[] checkedValues, String keyword, String subQuery, String toBirthDate, String fromBirthDate, String criteria ) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
		User user = userLocalService.getUser(themeDisplay.getUserId());
		SearchContainer<ProfileDetailDTO> searchContainer = null;
		PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		searchContainer = new SearchContainer<>(renderRequest, iteratorURL, null, "emptyResultsMessage");
		searchContainer.setEmptyResultsMessage("No Data Found");
		List<Object[]> objects = profileDetailLocalService.getProfileDetailSearchResult(checkedValues, keyword,
				subQuery, toBirthDate, fromBirthDate, criteria, searchContainer.getStart(),
				searchContainer.getEnd());
		int total = profileDetailLocalService.getProfileDetailSearchResult(checkedValues, keyword, subQuery,
				toBirthDate, fromBirthDate, criteria, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
		searchContainer.setDeltaConfigurable(true);
		searchContainer.setTotal(total);

		List<ProfileDetailDTO> profileDetailDTOs = new ArrayList<>();
		if (!objects.isEmpty()) {
			if (Validator.isNotNull(objects)) {
				ProfileDetailDTO profileDetailDTO = null;
				for (Object[] obj : objects) {
					Object[] data = (Object[]) obj;
					profileDetailDTO = new ProfileDetailDTO();
					ProfileDetail profileDetail = ProfileDetailLocalServiceUtil.getProfileDetail(
							Validator.isNotNull(data[0]) ? Long.parseLong(String.valueOf(data[0])) : 0);
					if (ProfileDetailPermissionCheckUtil.checkResourcePermission(renderRequest, user,
							profileDetail, themeDisplay)) {
						profileDetailDTO.setProfileDetailId(
								Validator.isNotNull(data[0]) ? Long.parseLong(String.valueOf(data[0])) : 0);
						profileDetailDTO.setScreenName(
								Validator.isNotNull(data[1]) ? (String) data[1] : StringPool.BLANK);
						profileDetailDTO
								.setAboutMe(Validator.isNotNull(data[2]) ? (String) data[2] : StringPool.BLANK);
						profileDetailDTO.setPrivacy(
								Validator.isNotNull(data[3]) ? Integer.parseInt(String.valueOf(data[3])) : 0);
						profileDetailDTOs.add(profileDetailDTO);
					}

				}
			}

		}
		searchContainer.setResults(profileDetailDTOs);
		renderRequest.setAttribute("profileDetailSearchContainer", searchContainer);

		}catch (Exception e) {
			log.error("Error occure while getting search result ", e);
		}
	}
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		Map checkedIds = AmfProfileSearchWebPortletKeys.advanceSearchCheckBoxesMap;
		List<String> checkedValues = new ArrayList<>();

		if(Validator.isNull(ParamUtil.getString(actionRequest, "searchTerm"))&&Validator.isNotNull(ParamUtil.getString(actionRequest, "criteria"))) {
		String keyword = ParamUtil.getString(actionRequest, "keyword");
		String favoriteGenre = ParamUtil.getString(actionRequest, "favoriteGenre");
		String toBirthDate = ParamUtil.getString(actionRequest, "birthDateTo");
		String fromBirthDate = ParamUtil.getString(actionRequest, "birthDateFrom");
		String criteria = ParamUtil.getString(actionRequest, "criteria");
		StringBuilder sb = new StringBuilder();
		sb.append("where");
		if (!favoriteGenre.isEmpty()) {
			sb.append(!"where".equalsIgnoreCase(sb.toString()) ? criteria.equalsIgnoreCase("any") ? "OR" : "AND"
					: StringPool.BLANK);
			sb.append(" pd.favoriteGenre like '%" + favoriteGenre + "%' ");
		}
		checkedIds.forEach((key, value) -> {
			if (ParamUtil.getBoolean(actionRequest, key.toString())) {
				checkedValues.add(key.toString());
				sb.append(!"where".equalsIgnoreCase(sb.toString()) ? criteria.equalsIgnoreCase("any") ? "OR" : "AND"
						: StringPool.BLANK);
				sb.append(" pd." + key.toString() + " like ? ");
				AmfProfileSearchWebPortletKeys.advanceSearchCheckBoxesMap.replace(key.toString(), true);
			} else {
				AmfProfileSearchWebPortletKeys.advanceSearchCheckBoxesMap.replace(key.toString(), false);
			}
		});
		actionResponse.setRenderParameter("searchKeyword", keyword);
		actionResponse.setRenderParameter("searchFavoriteGenre", favoriteGenre);
		actionResponse.setRenderParameter("searchToBirthDate", toBirthDate);
		actionResponse.setRenderParameter("searchFromBirthDate", fromBirthDate);
		actionResponse.setRenderParameter("searchCriteria", criteria);
		actionResponse.setRenderParameter("searchCheckedValues",
				checkedValues.toArray(new String[checkedValues.size()]));
		actionResponse.setRenderParameter("searchSubQuery", sb.toString());
		}else {
			String searchTerm = ParamUtil.getString(actionRequest, "searchTerm");
			actionResponse.setRenderParameter("keyword", searchTerm);
		}

	}

	@Reference
	ProfileDetailLocalService profileDetailLocalService;

	@Reference
	UserLocalService userLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

}