<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags"  prefix="h"%>

v1.2
<h:stomac var="gyomor" intoVariable="true">
 <c:out value="pacal" />
</h:stomac>


<c:if test="${not empty gyomor}">
<h1>content of  my stomac</h1>
${gyomor}
</c:if>
