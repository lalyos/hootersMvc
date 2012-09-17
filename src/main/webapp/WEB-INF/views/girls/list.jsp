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

<h2>Add Girl</h2>

<c:url var="addUrl" value="/girl/add" />

<form action="${addUrl}" method="post">
 <br>Name: <input type="text" name="name" />
 <br>Breast Size: <input type="text" name="breast" />
 <br>Basket type: <select name="basket">
 <option value="A" >A</option>
 <option value="B" >B</option>
 <option value="C" >C</option>
 <option value="D" >D</option>
</select>
<br/><input type="submit" value="add"/>
</form>