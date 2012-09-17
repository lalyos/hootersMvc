<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<h2>Add Girl</h2>

<c:url var="addUrl" value="/girls/add" />

<form action="${addUrl}" method="post">
 <br>Name: <input type="text" name="name" />
 <br>Breast Size: <input type="text" name="breastSize" />
 <br>Basket type: <select name="basket">
 <option value="A" >A</option>
 <option value="B" >B</option>
 <option value="C" >C</option>
 <option value="D" >D</option>
</select>
<br/><input type="submit" value="add"/>
</form>