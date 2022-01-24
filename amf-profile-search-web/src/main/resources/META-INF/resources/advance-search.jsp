<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@ include file="/init.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%
 	long portletLayoutId = 0;
	Layout viewProfileLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), Boolean.FALSE, "/member");
	if(Validator.isNotNull(viewProfileLayout)){
		portletLayoutId = viewProfileLayout.getPlid();
	} 
 %>
<portlet:actionURL name="advanceSearchProfile" var="advanceSearchURL" >
	<portlet:param name="tag" value="advanceSearch" />
</portlet:actionURL>
<aui:form action="${advanceSearchURL}" method="post"
	 name="advanceSearchForm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Advance Search">
			<aui:row>
				<aui:col width="60">
					<aui:input inlineLabel="left" label="" id="keyword" name="keyword"
					value="${searchKeyword}" placeholder="search-entries" size="256" />
				</aui:col>
				<aui:col width="30">

					<aui:button type="button" value="search" onclick="submitForm()" />
				</aui:col>
			</aui:row>
			
			<aui:row>

				<c:forEach var="advanceSearchCheckId"
					items="${advanceSearchCheckIds}" varStatus="loop">
					<aui:col width="40">
						<aui:input id="check${loop.index}"
							name="${advanceSearchCheckId.key}"
							label="${advanceSearchCheckId.key}" type="checkbox"
							checked='${advanceSearchCheckId.value}'	value="${advanceSearchCheckId.value}"></aui:input>
					</aui:col>
				</c:forEach>
			</aui:row>
			<aui:row>
				<aui:col width="40">
					<aui:select label="Favorite Genre" id="favoriteGenre" name="favoriteGenre">
						<aui:option value="">None</aui:option>
						<c:forEach var="favoriteGenreVal" items="${favoriteGenreList}">
							<aui:option selected='${favoriteGenreVal eq searchFavoriteGenre ? true : false}' value="${favoriteGenreVal}">${favoriteGenreVal}</aui:option>
						</c:forEach>
					</aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				
				<aui:col width="40">
					<aui:input cssClass="dateOfBirth" name="birthDateFrom"
						id="datepickerFrom" type="text" value="${searchFromBirthDate}" label="Birthday Range From">
					</aui:input>
				</aui:col>
				<aui:col width="40">
					<aui:input cssClass="dateOfBirth" name="birthDateTo"
						id="datepickerTo" type="text" value="${searchToBirthDate}" label="Birthday Range To">
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="30">
					<aui:input name="criteria" type="radio" value="any"
						checked='${searchCriteria == "all" ? false : true}'
						label="Use Any Criteria" />
				</aui:col>
				<aui:col width="30">
					<aui:input name="criteria" type="radio" value="all"
						checked='${searchCriteria == "all" ? true : false}'
						label="Use ALL Criteria" />
				</aui:col>
				<aui:col width="30">
					<aui:button type="button" onclick="resetDateRange()" value="Reset" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>

<h4> Search Result:</h4>
<liferay-ui:search-container
	delta="4" searchContainer="${profileDetailSearchContainer}">

	<liferay-ui:search-container-results
		results="${profileDetailSearchContainer.results}" />
	<liferay-ui:search-container-row cssClass="badge-sec"
		className="amf.com.liferay.profile.detail.common.model.ProfileDetailDTO"
		keyProperty="profileDetailId" modelVar="profileDetailModel">
		<liferay-portlet:renderURL var="renderUrl"
			plid="<%=portletLayoutId%>"
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
			name="About Me" value="${fn:substring(profileDetailModel.aboutMe, 0, 80)}">
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		searchContainer="${profileDetailSearchContainer}" markupView="lexicon" />
</liferay-ui:search-container>

<script>
function resetDateRange(){
	$('#<portlet:namespace />datepickerFrom').val("");
	$('#<portlet:namespace />datepickerTo').val("");
}

function submitForm(){
	
//	var advanceSearchCheckIdMap = '${advanceSearchCheckIds}';
	//var map = new Map(JSON.parse(advanceSearchCheckIdMap))
	var counter = ${advanceSearchCheckIdCount};
	var isChecked = false;
	for(var i=0; i<=counter;i++){
		var isChecked= $('#<portlet:namespace/>check'+i).is(':checked');
		if(isChecked && ($('#<portlet:namespace/>keyword').val()!=null && $('#<portlet:namespace/>keyword').val()!=undefined && $('#<portlet:namespace/>keyword').val()!="") ){
			$('#<portlet:namespace/>advanceSearchForm').submit();
		}else if(!isChecked && ($("#<portlet:namespace/>favoriteGenre option:selected").val()!=null && $("#<portlet:namespace/>favoriteGenre option:selected").val()!=undefined && $("#<portlet:namespace/>favoriteGenre option:selected").val()!="")){
			$('#<portlet:namespace/>advanceSearchForm').submit();
		}
	}
	if(!isChecked){
		var fromBirthDate = $('#<portlet:namespace />datepickerFrom').val();
		var toBirthDate = $('#<portlet:namespace />datepickerTo').val();
		var from = new Date(fromBirthDate).getTime(); // gives 1486492200000
		var to = new Date(toBirthDate).getTime();
		if(from<to && (fromBirthDate!= null || toBirthDate!=null)){
			$('#<portlet:namespace/>advanceSearchForm').submit();
		}

	}
}
</script>
<aui:script>
AUI().use('aui-datepicker', function(A) {
	  new A.DatePicker({
	 	 trigger : '#<portlet:namespace />datepickerTo',
   		appendOrder: ['m', 'd', 'y'],
        calendar: {
        dateFormat: 'dd/MM/yyyy'
         
        },popover : {
	 		 			zIndex : 1
			 		},
      
    })
    });
    
AUI().use('aui-datepicker', function(A) {
	  new A.DatePicker({
	 	 trigger : '#<portlet:namespace />datepickerFrom',
   		appendOrder: ['m', 'd', 'y'],
        calendar: {
        dateFormat: 'dd/MM/yyyy'
         
        },popover : {
	 		 			zIndex : 1
			 		},
      
    })
    });    

</aui:script>