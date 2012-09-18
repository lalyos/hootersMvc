<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:if test="${not empty msg}">
  <div style="background: #050; border: 2px green solid; color:white; width: 300px;"> ${msg}
  </div>
</c:if>
<h1>List of girls</h1>
<div class="row">
<table class="table .table-striped table-condensed">
<thead>
  <tr>
    <th>name</th>
    <th>breast</th>
    <th>basket</th>
    <th>delete</th>
   </tr>
</thead>
<tbody>
  <c:forEach var="next" items="${girls}">
  <c:url var="removeUrl" value="/girls/remove/${next.name}"/>
  <tr>
    <td>${next.name}</td>
    <td>${next.breastSize}</td>
    <td>${next.basket}</td>
    <td><a href="${removeUrl}">X</a></td>
  </tr>
  </c:forEach>
</tbody>
</table>

</div>
<div class="row">

<h2>Add Girl v1.7</h2>


<c:url var="addUrl" value="/girls/add" />
<form:form action="${addUrl}" modelAttribute="girl" cssClass="form-horizontal">

<h:input path="name" /> 
<h:input path="breastSize" /> 
<h:select path="basket" options="${basketOptions}" /> 

<h:button value="add_1" />

</form:form>
</div>
