<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CATEGORY FORM</title>
</head>
<body>
<c:url value="/admin/addcategory" var="url"></c:url>
<form:form action="${url}" method="post" modelAttribute="category">
<div class="container">
<table align="center"border="1" class="table table">
<caption><h2><center><font color="white">ADD CATEGORY</font></center></h2></caption>
<tr><td><b><font color="white">ENTER CATEGORY NAME</td><td><form:input path="categoryname"/></td><td><form:errors path="categoryname" cssStyle="color:white"/></td></tr>
<tr><td></td><td><a href="<c:url value='#'></c:url>"><button class="btn btn-sm btn-active">ADD CATEGORY</button></a></td><td></td></tr>
</table>
</div>
</form:form>
</body>
</html>