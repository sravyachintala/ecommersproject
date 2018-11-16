<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRODUCT INSERT FORM</title>
</head>
<body>
<c:url value="/admin/updateproduct" var="url"></c:url>
<form:form action="${url}" method="post" modelAttribute="product" enctype="multipart/form-data">
<div class="container">
<table align="center"border="1" class="table table">
<thead><caption><h2><center><font color="white">PRODUCT DETAILS</font></center></h2></caption></thead>
<form:hidden path="id"/>
<tr><td><b><font color="white">ENTER PRODUCT NAME</td><td><form:input path="productname"/></td><td><form:errors path="productname" cssStyle="color:white"/></td></tr>
<tr><td><b><font color="white">ENTER PRODUCT DESCRIPTION</td><td><form:textarea path="productdesc"/></td><td><form:errors path="productdesc" cssStyle="color:white"/></td></tr>
<tr><td><b><font color="white">ENTER PRODUCT QUANTITY</td><td><form:input path="quantity"/></td><td><form:errors path="quantity" cssStyle="color:white"/></td></tr>
<tr><td><b><font color="white">ENTER PRODUCT PRICE</td><td><form:input path="price"/></td><td><form:errors path="price" cssStyle="color:white"/></td></tr>
<tr><td><b><font color="white">SELECT CATEGORY</td>
<td><form:select path="category.id">
<c:forEach items="${categories}" var="c">
<form:option value="${c.id}">${c.categoryname}</form:option>
</c:forEach>
</form:select></td>
</tr>
<tr><td><b><font color="white">UPLOAD AN IMAGE</font></b></td><td><form:input type="file" path="image"/></td></tr>
<tr><td></td><td><a href="<c:url value='#'></c:url>"><button class="btn btn-sm btn-active">EDIT PRODUCTS</button></a></td><td></td></tr>
</table>
</div>
</form:form>
</body>
</html>