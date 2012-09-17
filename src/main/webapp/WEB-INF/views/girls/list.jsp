<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>List of girls</h1>

<ul>
<c:forEach var="next" items="${girls}">
  <c:url var="removeUrl" value="/girl/remove">
    <c:param name="name" value="${next.name}" />
  </c:url>
      <li>${next}
      <a href="${removeUrl}">X</a>
      </li>
</c:forEach>
</ul>