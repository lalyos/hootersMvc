<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:if test="${not empty msg}">
  <div style="background: #050; border: 2px green solid; color:white; width: 300px;"> ${msg}
  </div>
</c:if>
<h1>List of girls</h1>

<ul>
<c:forEach var="next" items="${girls}">
  <c:url var="removeUrl" value="/girls/remove">
    <c:param name="name" value="${next.name}" />
  </c:url>
      <li>${next}
      <a href="${removeUrl}">X</a>
      </li>
</c:forEach>

</ul>

<h2>Add Girl v1.1</h2>


<c:url var="addUrl" value="/girls/add" />
<form:form action="${addUrl}" modelAttribute="girl">

 <br/><form:input path="name"/> <form:errors path="name" cssStyle="color:red" />
 <br/><form:input path="breastSize"/> <form:errors path="breastSize" cssStyle="color:red"  />
 <br/><form:select path="basket" >
 <form:options items="${basketOptions}"/>
 </form:select>
 <br/><form:button>add</form:button>
</form:form>


<h:debugMap map="${requestScope}" title="Request"></h:debugMap>
<h:debugMap map="${sessionScope}" title="session"></h:debugMap>