<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ tag language="java" pageEncoding="UTF-8" body-content="tagdependent"%>
<%@ attribute name="var" description="" required="true" type="java.lang.String"  rtexprvalue="false"%>
<%@ attribute name="intoVariable" type="java.lang.Boolean" description="" required="true"  %>
<%@ variable variable-class="java.lang.Object" name-from-attribute="var" alias="myvar" description="" scope="AT_END" %>

<c:choose>
  <c:when test="${intoVariable}">
    <c:set var="myvar" >
      <jsp:doBody />
    </c:set>
  </c:when>
  <c:otherwise>
  
    <hr /> stomac BEGIN <hr />
    <jsp:doBody />
    <jsp:doBody />
    <hr /> stomac END <hr />

  </c:otherwise>
</c:choose>
