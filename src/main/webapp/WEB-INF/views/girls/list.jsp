<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>List of girls</h1>

<ul>
<c:forEach var="next" items="${girls}">
      <li>${next}</li>
</c:forEach>
</ul>