<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ attribute name="map" required="true" type="java.util.Map" %>
<%@ attribute name="title" required="false"  %>


<hr/>
<h3>${title }</h3>

<table>
<thead>
  <tr>
    <th></th>
    <th></th>
   </tr>
</thead>
<tbody>
  <c:forEach var="next" items="${map}">
  <tr>
    <td>${next.key }</td>
    <td>${next.value }</td>
  </tr>
  </c:forEach>
</tbody>
</table>