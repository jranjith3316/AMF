<%@ include file="/init.jsp" %>
 
<p>
	
		<h4>All Users:</h4>
        <c:forEach var="user" items="${users}">
        <portlet:renderURL var="renderUrl" >
		<portlet:param name="screenName" value="${user.screenName}" />
		<portlet:param name="mvcRenderCommandName" value="/profile/view" />
		<portlet:param name="tag" value="view" />
				
		</portlet:renderURL>
         <a href="${renderUrl}">${user.screenName}</a>
      		<br/>
      </c:forEach>
 
 </p>
 
