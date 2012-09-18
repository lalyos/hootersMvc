<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty msg}">  
  
  <div class="alert">
    <button type="button" class="close" data-dismiss="alert">×</button>
    <strong>Warning!</strong> ${msg}
  </div>
</c:if>


<table class="table .table-striped table-condensed">
<thead>
  <tr>
    <th>#</th>
    <th>customer</th>
    <th>food</th>
    <th>girl</th>
    <th>state</th>
    <th>action</th>
   </tr>
</thead>
<tbody>
  <c:forEach var="next" items="${orders}">
  <c:url var="actionUrl" value="/orders/${next.id}/approove"/>
  <tr>
    <td>${next.id}</td>
    <td>${next.customer}</td>
    <td>${next.food}</td>
    <td>${next.girl.name}</td>
    <td>${next.state}</td>
    <td><a href="${actionUrl}">approove</a></td>
  </tr>
  </c:forEach>
</tbody>
</table>

