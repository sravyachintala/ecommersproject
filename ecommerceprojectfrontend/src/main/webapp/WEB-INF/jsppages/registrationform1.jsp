<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/resources/css/registrationform1.css'></c:url>">
<script src="<c:url value='/resources/js/jquery.validate.min.js'></c:url>"></script>
<!-- <script type="text/javascript"
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script> -->
<script type="text/javascript">
function fillShippingAddress(form){
	if(form.shippingaddressform.checked==true){
		//shippingaddress is same as billingaddress
		form["shippingaddress.apartmentnumber"].value=form["billingaddress.apartmentnumber"].value;
		form["shippingaddress.streetname"].value=form["billingaddress.streetname"].value;
		form["shippingaddress.city"].value=form["billingaddress.city"].value;
		form["shippingaddress.state"].value=form["billingaddress.state"].value;
		form["shippingaddress.country"].value=form["billingaddress.country"].value;
		form["shippingaddress.zipcode"].value=form["billingaddress.zipcode"].value;
	}
	if(form.shippingaddressform.checked==false){
		form["shippingaddress.apartmentnumber"].value=""
		form["shippingaddress.streetname"].value=""
		form["shippingaddress.city"].value=""
		form["shippingaddress.state"].value=""
		form["shippingaddress.country"].value=""
		form["shippingaddress.zipcode"].value=""
	}
}




$(document).ready(function(){
	$('#form').validate({
		rules:{
			firstname:{required:true},
			lastname:{required:true},
			phonenumber:{required:true,number:true,minlength:10,maxlength:10},
			"user.email":{required:true,email:true},
			"user.password":{required:true,minlength:5,maxlength:10},
			"billingaddress.apartmentnumber":{required:true},
			"billingaddress.streetname":{required:true},
			"billingaddress.state":{required:true},
			"billingaddress.city":{required:true},
			"billingaddress.country":{required:true},
			"billingaddress.zipcode":{required:true,number:true}
		},
		messages:{
			firstname:{required:"Firstname is mandatory"},
			phonenumber:{required:"Phonenumber is required"},
			"user.email":{required:"Email is required",email:"Please enter valid email address"}
		}
	})
})

</script>
</head>
<body>
<div class="container">
	<c:url value="/all/registercustomer" var="url"></c:url>
	<form:form modelAttribute="customer" action="${url }" id="form">
	
	<form:hidden path="customerId"/>
	
	<form:label path="firstname">Enter First name</form:label>
	<form:input path="firstname" id="firstname"/>
	
	
	<form:label path="lastname">Enter Last name</form:label>
	<form:input path="lastname" id="lastname"/>
	
	
	<form:label path="phonenumber">Enter Phone number</form:label>
	<form:input path="phonenumber" id="phonenumber"/>
	
	<hr>
	<b>Login Credentials</b><br>
	<form:label path="user.email">Enter Email</form:label>
	<form:input path="user.email" id="user.email" type="email"/>
	<span style="color:red">${errorMessage }</span>
	<form:label path="user.password">Enter password</form:label>
	<form:input path="user.password" id="user.password" type="password"  />
	<form:hidden path="user.enabled" value="true"/>
	<form:hidden path="user.authorities.role" value="ROLE_USER"/>
	
	<hr>
	<b>Billing Address</b><br>
	
	<form:label path="billingaddress.apartmentnumber">Enter Apartment number</form:label>
	<form:input path="billingaddress.apartmentnumber" id="billingaddress.apartmentnumber"/>
	
	<form:label path="billingaddress.streetname">Enter street name</form:label>
	<form:input path="billingaddress.streetname" id="billingaddress.streetname"/>
	
	<form:label path="billingaddress.city">Enter city</form:label>
	<form:input path="billingaddress.city" id="billingaddress.city"/>
	
	<form:label path="billingaddress.state">Enter state</form:label>
	<form:input path="billingaddress.state" id="billingaddress.state"/>
	
	<form:label path="billingaddress.country">Enter country</form:label>
	<form:input path="billingaddress.country" id="billingaddress.country"/>
	
	<form:label path="billingaddress.zipcode">Enter Zip code</form:label>
	<form:input path="billingaddress.zipcode" id="billingaddress.zipcode"/>
	<hr>
	<b>Shipping address</b><br>
Check this if shipping address is same as billing address
<input type="checkbox" onclick="fillShippingAddress(this.form)" id="shippingaddressform">
	
	<form:label path="shippingaddress.apartmentnumber">Enter Apartment number</form:label>
	<form:input path="shippingaddress.apartmentnumber" id="shippingaddress.apartmentnumber"/>
	
	<form:label path="shippingaddress.streetname">Enter street name</form:label>
	<form:input path="shippingaddress.streetname" id="shippingaddress.streetname"/>
	
	<form:label path="shippingaddress.city">Enter city</form:label>
	<form:input path="shippingaddress.city" id="shippingaddress.city"/>
	
	<form:label path="shippingaddress.state">Enter state</form:label>
	<form:input path="shippingaddress.state" id="shippingaddress.state"/>
	
	<form:label path="shippingaddress.country">Enter country</form:label>
	<form:input path="shippingaddress.country" id="shippingaddress.country"/>
	
	<form:label path="shippingaddress.zipcode">Enter zip code</form:label>
	<form:input path="shippingaddress.zipcode" id="shippingaddress.zipcode"/>
	<br>
	<input type="submit" value="Register" style="background-color:#333333;">
	
	</form:form>
	</div>

</body>
</html>