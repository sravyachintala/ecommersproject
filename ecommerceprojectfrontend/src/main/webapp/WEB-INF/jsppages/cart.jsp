<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<table align="center" class="table table"><!-- table-responsive -->
<caption><h2><center><font color="white">ADDED PRODUCTS IN CART</font></center></h2></caption>
<thead>
<c:if test=""></c:if>
<tr><th><a href="<c:url value='/cart/clearcart'></c:url>" >
<button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>CLEAR CART</button></a></th>
<th></th>
<th></th>
<th><a href="<c:url value='/all/getallproducts/'></c:url>">
<button class="btn btn-sm btn-success">&nbsp;ADD PRODUCTS</button></a></th>
</tr>
<thead>
<tr><th><font color="white">PRODUCT NAME</font></th><th><font color="white">QUANTITY</font></th><th><font color="white">TOTAL PRICE</font></th><th><font color="white">ACTION</font></th></tr></thead>
<c:set var="grandTotal" value="0"></c:set>
<tbody>
<c:forEach items="${cartItems}" var="p">
<tr>
<td><font color="white"><c:out value="${p.product.productname}"></c:out></font></td><td><font color="white"><c:out value="${p.quantity}"></c:out></font></td><td><font color="white"><c:out value="${p.totalprice}"></c:out></font></td>
<c:set var="grandTotal" value="${grandTotal+p.totalprice}"></c:set>
<td>
<a href="<c:url value='/cart/removecartitem/${p.cartId}'></c:url>">
<button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>REMOVE</button></a></td>
</tr>
</c:forEach>
<tr><td><font color="white">TOTAL AMOUNT</font></td><td><input type="text" value="${grandTotal}"/></td><td></td>
<c:if test="${empty(cartSize)}">
<h3>YOUR CART IS EMPTY</h3>
</c:if>
<c:if test="${!empty(cartSize)}">
<td>
<a href="<c:url value='/cart/shippingaddressform'></c:url>">
<button class="btn btn-sm btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;PLACEORDER</button></a></td>
</c:if>
</tr>
</tbody>
</table>
</div>
</body>
</html>