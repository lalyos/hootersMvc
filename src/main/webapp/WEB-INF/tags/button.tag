<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="value" description="" required="true" type="java.lang.String" %>

<div class="control-group ">
<div class="controls">
  <form:button class="btn btn-success">${value}</form:button>
  </div>
</div>
