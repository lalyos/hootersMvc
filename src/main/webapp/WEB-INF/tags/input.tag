<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="path" description="" required="true"  %>

  <form:errors path="${path }">
    <c:set var="errorClass" value="error"  />
    <!-- empty ;) -->
  </form:errors>
  
  <c:set var="errorMsg" >
    <form:errors path="${path }" />
  </c:set>


<div class="control-group ${errorClass}">
  <label class="control-label" for="${path }">${path } : </label>
  <div class="controls">
    <form:input path="${path}"/>
    <form:errors path="${path }">
      <span class="help-inline">${errorMsg}</span>
    </form:errors>
    
  </div>
</div>
