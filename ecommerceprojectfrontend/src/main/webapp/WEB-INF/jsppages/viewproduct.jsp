<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<center>
<img src="<c:url value='/resources/images/${productAttr.id}.png'></c:url>" height="640px" width="1000px"></center>
<br><br><br>
<table align="center" border="1" class="table table-sm">
<tbody>
<tr><td><font color="white">PRODUCT NAME</font></td><td><font color="white">${productAttr.productname}</font></td></tr>
<tr><td><font color="white">PRODUCT DESCRIPTION</font></td><td><font color="white">${productAttr.productdesc}</font></td></tr>
<tr><td><font color="white">PRODUCT PRICE</font></td><td><font color="white">${productAttr.price}</font></td></tr>
<tr><td><font color="white">PRODUCT IN STOCK</font></td><td><font color="white">${productAttr.quantity}</font></td></tr>
<tr><td><font color="white">PRODUCT CATEGORY</font></td><td><font color="white">${productAttr.category.categoryname}</font></td></tr>
<c:if test="${productAttr.quantity > 0 }">
<security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/cart/addtocart/${productAttr.id}'></c:url>">
<tr><td><font color="white">ENTER QUANTITY</font></td><td><input type="number" name="requestedQuantity" min="1" max="${productAttr.quantity} " value=0></td></tr>
<tr>
<td>
<a href="<c:url value='#'></c:url>">
<button class="btn btn-sm btn-active">ADD TO CART</button></a></td></form>
</security:authorize>
</c:if>
<td><a href="<c:url value='/all/getallproducts/'></c:url>">
<button class="btn btn-sm btn-active">BACK TO PREVIOUS PAGE</button></a></td>
</tr>
</tbody>
</table>
${productAttr.id}
</div>
</body>
</html>