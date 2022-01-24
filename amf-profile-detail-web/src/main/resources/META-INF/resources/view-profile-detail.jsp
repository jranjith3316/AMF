<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<portlet:renderURL var="editProfileURL" >
	<portlet:param name="mvcRenderCommandName" value="/profile/view" />
	<portlet:param name="screenName" value="${profileDetail.screenName}" />
	<portlet:param name="tag" value="edit" />
</portlet:renderURL>
<portlet:actionURL name="updateProfile" var="updateActionURL" >
	<portlet:param name="<%=Constants.CMD%>" value="update" />
	<portlet:param name="screenName" value="${profileDetail.screenName}" />
</portlet:actionURL>
<portlet:renderURL var="privacyURL" >
	<portlet:param name="mvcRenderCommandName" value="/profile/privacy" />
	<portlet:param name="screenName" value="${profileDetail.screenName}" />
	<portlet:param name="tag" value="privacy" />
</portlet:renderURL>
<c:if test="${(isReadonly && hasUserProfileViewPermission) || hasUserProfileEditPermission}">
<aui:form name="fm" method="post" action="${updateActionURL}">
	<aui:button-row>  
		<aui:button hidden="${hideEdit}" disabled="${!hasUserProfileEditPermission}" class="btn btn-primary btn-lg btn-default px-2 py-1" name="Edit" type="button" value="Edit" href="${editProfileURL.toString()}"  />
	</aui:button-row>  
	<aui:button-row>  
		<aui:button hidden="${hideEdit}" disabled="${!hasUserProfileEditPermission}" class="btn btn-primary btn-lg btn-default px-2 py-1" name="Open Privacy" type="button" value="openPrivacy" href="${privacyURL.toString()}"  />
	</aui:button-row>  
 	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Basic Info">
			<aui:row>
				<aui:col width="30">
					<aui:input label="First Name" readonly="${isReadonly}" name="firstName" value="${profileDetail.firstName}" type="text" >
					<aui:validator name="required" errorMessage='This field is required'></aui:validator>																																																									
					<aui:validator name="custom" errorMessage='Please enter valid value'>
			                function(val, fieldNode, ruleValue) {
			                   return validateAlphaNum(val);
			                }
			       </aui:validator> 
       				<aui:validator name="maxLength">50</aui:validator>
       				</aui:input>
				</aui:col>
				<aui:col width="30">
					<aui:input label="Last Name" readonly="${isReadonly}" name="lastName" value="${profileDetail.lastName}" type="text" >
						<aui:validator name="required" errorMessage='This field is required'></aui:validator>																																																									
					<aui:validator name="custom" errorMessage='Please enter valid value'>
		                function(val, fieldNode, ruleValue) {
		                   return validateAlphaNum(val);
		                }
	       			</aui:validator> 
       				<aui:validator name="maxLength">50</aui:validator>	
       				</aui:input>	
				</aui:col>
				<aui:col width="30">
					 <aui:select disabled='${isReadonly?"true":"false"}' name="gender" label="Gender">
					    <aui:validator name="required" errorMessage='This field is required'></aui:validator>																																																									
					    <aui:option  value="${profileDetail.male?true:false}" selected='${profileDetail.male ? true : false}'  >Male</aui:option>
					    <aui:option value="${profileDetail.male?false:true}" selected='${!profileDetail.male ? true : false}'>Female</aui:option>
					</aui:select> 
				</aui:col>
			</aui:row>
			 <aui:row>
				<aui:col width="50">
					<aui:input disabled='${isReadonly?"true":"false"}'  cssClass="dateOfBirth" name="birthDate"
					id="datepicker" type="text" value="${profileDetail.birthDate}"
					label="Birthday">
					<aui:validator name="required" errorMessage='This field is required'></aui:validator>																																																									
				 
					<aui:validator name="custom" errorMessage='Please enter valid value'>
		                function(val, fieldNode, ruleValue) {
		                   var validYear = new Date().getFullYear()-13;
							var year = val.substring(val.lastIndexOf("/")+1);   
		                     if(year<=validYear){
		                     	return true;
		                     }
		                     return false;
		                }
	       			</aui:validator>  
					</aui:input>
				</aui:col>
			</aui:row> 
			
		</aui:fieldset>
	</aui:fieldset-group>
 	 <aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Movie Interest">
			<aui:row>
				<aui:col>
					<aui:input readonly="${isReadonly}" label="About Me" value="${profileDetail.aboutMe}" name="aboutMe" type="textarea" >
						<aui:validator name="maxLength">5000</aui:validator>	
					</aui:input>
				</aui:col>
			</aui:row>	
			<aui:row>	
				<aui:col>
					<aui:input readonly="${isReadonly}" label="Favorite Quotes" value="${profileDetail.favoriteQuotes}"  name="favoriteQuotes" type="textarea" >
						<aui:validator name="maxLength">5000</aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group> 
	 <aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="General Information">
			<aui:row>
				<aui:col>
					<aui:input readonly="${isReadonly}" label="Favorite Movie" name="favoriteMovie" value="${profileDetail.favoriteMovie}" type="text" >
						<aui:validator name="maxLength">500</aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>	
			<aui:row>	
				<aui:col width="50">
					<aui:select disabled='${isReadonly?"true":"false"}' label="Favorite Genre" name="favoriteGenre">
						    <aui:option value="">Select Favorite Genre</aui:option>
					        <c:forEach var="favoriteGenreVal" items="${profileDetail.favoriteGenreList}">
					    		<aui:option selected='${favoriteGenreVal eq profileDetail.favoriteGenre ? true : false}' value="${favoriteGenreVal}">${favoriteGenreVal}</aui:option>
							</c:forEach>
					</aui:select>		
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col>
					<aui:input readonly="${isReadonly}" label="Least Favorite Movie" name="leastFavMovie" value="${profileDetail.leastFavoriteMovie}" type="text" >
						<aui:validator name="maxLength">500</aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>	
			<aui:row>
				<aui:col>
					<aui:input readonly="${isReadonly}" label="Favorite Actor/Actress" name="favoriteActor" value="${profileDetail.favoriteActor}" type="text" >
						<aui:validator name="maxLength">100</aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>
		<aui:button-row>
		<aui:button hidden="${hideUpdate}" class="btn btn-primary btn-lg btn-default px-2 py-1" name="update" type="submit" value="Update" />
	
	</aui:button-row>  
			
				
		</aui:fieldset>
	</aui:fieldset-group> 
</aui:form>
</c:if>
<aui:script>
	function validateAlphaNum(val){  
	   var alphaNum = /^[\u0621-\u064Aa-zA-Z0-9\s]+$/;   
	   return alphaNum.test(val);
	}
	
AUI().use('aui-datepicker', function(A) {
	  new A.DatePicker({
	 	 trigger : '#<portlet:namespace />datepicker',
   		appendOrder: ['m', 'd', 'y'],
        calendar: {
        dateFormat: 'dd/MM/yyyy'
         
        },popover : {
	 		 			zIndex : 1
			 		},
      
    })
    });


</aui:script> 
		  

