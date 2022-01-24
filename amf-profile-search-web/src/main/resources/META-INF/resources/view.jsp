<%@page import="com.liferay.profile.search.web.portlet.ProfileDetailDisplayContext"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@ include file="/init.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%
	long portletLayoutId = 0;
	Layout viewProfileLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
			Boolean.FALSE, "/member");
	if (Validator.isNotNull(viewProfileLayout)) {
		portletLayoutId = viewProfileLayout.getPlid();
	}
%>
<portlet:renderURL var="advanceSearchURL">
	<portlet:param name="mvcPath" value="/advance-search.jsp" />
</portlet:renderURL>

<portlet:actionURL name="searchProfile" var="searchURL">
</portlet:actionURL>


<%-- <aui:form action="${searchURL}" name="fm">
	<div class="row">
		<div class="col-md-8">
			<aui:input inlineLabel="left" label="" name="searchTerm"
				placeholder="search-entries" size="256" />
		</div>

		<div class="col-md-4">
			<aui:button type="submit" value="search" />
			<aui:button type="button" href="${advanceSearchURL}"
				value="AdvanceSearch" />

		</div>
	</div>
</aui:form>
--%>

<% ProfileDetailDisplayContext profileDetailDisplayContext = new ProfileDetailDisplayContext(renderResponse,renderRequest,request);%>
 <clay:management-toolbar
		clearResultsURL="<%= profileDetailDisplayContext.getClearResultsURL() %>"
		componentId="profileDetailManagementToolbar"
		namespace="<%= renderResponse.getNamespace() %>"
		searchActionURL="<%= profileDetailDisplayContext.getSearchActionURL() %>"
		searchContainerId="<%= profileDetailDisplayContext.getSearchContainerId() %>"
		searchFormName="fm1"
		itemsTotal="<%= profileDetailDisplayContext.getTotalItems() %>"
		selectable="<%=true %>"
		showSearch="<%=true %>"
	 />
<liferay-ui:search-container
		id="<%=profileDetailDisplayContext.getSearchContainerId()%>"
		searchContainer="<%=profileDetailDisplayContext.getSearch()%>">
		<liferay-ui:search-container-row
			className="com.liferay.amf.profile.detail.model.ProfileDetail"
			cssClass="entry-display-style" keyProperty="profileDetailId"
			modelVar="profileDetailModel" indexVar="index">
			 <liferay-ui:search-container-column-text property="screenName" >
                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text property="aboutMe"/>
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator searchContainer="<%=profileDetailDisplayContext.getSearch()%>" markupView="lexicon" />
</liferay-ui:search-container>

<%--
<h4> Search Result:</h4>
<liferay-ui:search-container delta="10"
	searchContainer="${profileDetailSearchContainer}">

	<liferay-ui:search-container-results
		results="${profileDetailSearchContainer.results}" />

	<liferay-ui:search-container-row cssClass="badge-sec"
		className="amf.com.liferay.profile.detail.common.model.ProfileDetailDTO"
		keyProperty="profileDetailId" modelVar="profileDetailModel">
		<liferay-portlet:renderURL var="renderUrl" plid="<%=portletLayoutId%>"
			portletName="com_liferay_amf_profile_detail_web_AmfProfileDetailWebPortlet">
			<portlet:param name="screenName"
				value="${profileDetailModel.screenName}" />
			<portlet:param name="mvcRenderCommandName" value="/profile/view" />
			<portlet:param name="tag" value="view" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container-column-text href="${renderUrl}"
			cssClass="table-cell-expand table-title" name="Full Name"
			value="${profileDetailModel.screenName}">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text cssClass="table-cell-expand"
			name="About Me"
			value="${fn:substring(profileDetailModel.aboutMe, 0, 80)}">
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		searchContainer="${profileDetailSearchContainer}" markupView="lexicon" />
</liferay-ui:search-container>
--%>