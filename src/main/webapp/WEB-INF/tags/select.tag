<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="path" description="" required="true"  %>
<%@ attribute name="options" description="" required="true" type="java.util.List" %>
 
 <div class="control-group ">
  <label class="control-label" for="${path }">${path } : </label>
  <div class="controls">
 <form:select path="${path}" >
 <form:options items="${options}"/>
 </form:select>
    
  </div>
</div>