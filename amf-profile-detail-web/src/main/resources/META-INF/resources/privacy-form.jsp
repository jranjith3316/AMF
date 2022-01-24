<%@ include file="/init.jsp"%>
<portlet:actionURL name="updatePrivacy" var="updatePrivacyActionURL">
	<portlet:param name="screenName" value="${screenName}" />
</portlet:actionURL>
<c:if test="${hasEditPrivacyPermission}">
<aui:form name="privacyForm" method="post" action="${updatePrivacyActionURL}">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Set Privacy">
			<aui:row>
				<aui:col>					
					<aui:input name="privacy" type="radio" value="0" checked='${privacyId == 0 ? true : false}' label="public" />
					<aui:input name="privacy" type="radio" value="1" checked='${privacyId == 1 ? true : false}' label="private" />
					<aui:input name="privacy" type="radio" value="2" checked='${privacyId == 2 ? true : false}' label="protected" />
			 
			 	</aui:col>
			</aui:row>
			<aui:button-row>
				<aui:button class="btn btn-primary btn-lg btn-default px-2 py-1"
					name="UpdatePrivacy" type="submit" value="Update Privacy"/>
			</aui:button-row>
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>
</c:if>