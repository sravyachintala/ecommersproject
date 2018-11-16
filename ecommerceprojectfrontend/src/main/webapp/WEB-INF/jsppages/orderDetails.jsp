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
<div class="container-wrapper">
<div class="container">
<div class="container">
<div class="row">
<div class="well cols-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-1">
<div>
<h1 align="center">INVOICE</h1>
</div>
ORDER ID:${customerOrder.orderId}
<div class="row">
<div class="col-xs-6 col-sm-6 col-md-6">
<address>
<strong><button disabled>SHIPPING ADDRESS</button></strong><br/>
${customerOrder.user.customer.shippingaddress.apartmentnumber},
${customerOrder.user.customer.shippingaddress.streetname}
<br/>
${customerOrder.user.customer.shippingaddress.state},
${customerOrder.user.customer.shippingaddress.city}
<br/>
${customerOrder.user.customer.shippingaddress.zipcode}
</address>
</div>
<div class="col-xs-6 col-sm-6 col-md-6 text-right">
<p>SHIPPING DATE:${customerOrder.purchaseDate}</p>
</div>
</div>
<hr>
<div class="row">
<div class="col-xs-6 col-sm-6 col-md-6">
<address>
<strong><button disabled>BILLING ADDRESS</button></strong><br/>
${customerOrder.user.customer.billingaddress.apartmentnumber},
${customerOrder.user.customer.billingaddress.streetname}
<br/>
${customerOrder.user.customer.billingaddress.state},
${customerOrder.user.customer.billingaddress.city}
<br/>
${customerOrder.user.customer.billingaddress.zipcode}
</address>
</div>
</div>
<div class="row">
<table class="table table-hover" border="1">
<thead>
<tr>
<td>IMAGE</td>
<td>PRODUCT</td>
<td>UNITS</td>
<td class="text-center">PRICE</td>
<td class="text-center">TOTAL</td>
</tr>
</thead>
<tbody>
<c:forEach var="cartItem" items="${cartItems}">
<tr>
<c:url value="/resources/images/$(cartItem.product.id).jpg" var="imgUrl"></c:url>
<td><img src="${imgUrl}" height="50px" width="50px"/></td>
<td class="col-md-9"><em>${cartItem.product.productname}</em></td>
<td class="col-md-1" style="text-align:center">${cartItem.quantity}</td>
<td class="col-md-1" style="text-align:center">${cartItem.product.price}</td>
<td class="col-md-1" style="text-align:center">${cartItem.totalprice}</td>
</tr>
</c:forEach>
<tr>
<td></td>
<td></td>
<td></td>
<td class="text-right">
<h4><strong>GRAND TOTAL</strong></h4>
</td>
<td class="text-center text-danger">
<h4><strong>Rs. ${customerOrder.grandTotal}</strong></h4>
</td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>