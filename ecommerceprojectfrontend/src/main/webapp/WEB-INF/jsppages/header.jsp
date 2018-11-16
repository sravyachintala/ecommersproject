<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> 

<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'></c:url>"/>

<!-- jQuery library -->
<script src="<c:url value='/resources/js/bootstrap.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/jquery.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/jquery-2.2.1.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/jquery.dataTables.min.js'></c:url>"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/jquery.dataTables.min.css'></c:url>"/>
<!-- Latest compiled JavaScript -->
<script src="<c:url value='/resources/js/bootstrap.min.js'></c:url>"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/navbar.css'></c:url>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/home.css'></c:url>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chopard</title>
</head>
<body background="<c:url value='/resources/images/Background.jpg'></c:url>">
<div class="container-container">
<nav class="navbar navbar-inverse" id="navbar-bg">
<div class="navbar-header">
				<a href="" class="navbar-brand"><img src="<c:url value='/resources/images/Untitled.png'></c:url>" alt="Cartier" height="50px" width="70px"></a>
				<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#navbardemo" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
</div>
<div class="collapse navbar-collapse" id="navbardemo">
<ul class="nav navbar-nav">
<li><a href="<c:url value='/home'></c:url>"><span class="glyphicon glyphicon-home"></span>&nbsp;<font color="white">Home</font></a></li>
 <li><a href="<c:url value='/aboutus'></c:url>"><font color="white">AboutUs</font></a></li>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-plus"></span>&nbsp;<font color="white">Add</font><span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="<c:url value='/admin/getproductform'></c:url>"><span class="glyphicon glyphicon-plus"></span>&nbsp;Add Product</a></li>
<li><a href="<c:url value='/admin/getcategoryform'></c:url>"><span class="glyphicon glyphicon-plus"></span>&nbsp;Add Category</a></li>
</ul>
</li>
</security:authorize>
<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Add<span class="caret"></span></a>
<ul class="dropdown-menu"> -->
<li><a href="<c:url value='/all/getallproducts/'></c:url>"><span class="glyphicon glyphicon-search"></span>&nbsp;<font color="white">Browse All Products</font></a></li>
<%-- <li><a href="<c:url value='/all/getallcategories/'></c:url>"><span class="glyphicon glyphicon-plus"></span>Browse All Categories</a></li>
</ul>
</li> --%>
<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><font color="white">Select By Category</font><span class="caret"></span></a>
					
				<ul class="dropdown-menu">
				<c:forEach items="${categories}" var="c">
				<li><a href="<c:url value='/all/searchByCategory?searchCondition=${c.categoryname}'></c:url>">${c.categoryname}</a></li>
				</c:forEach>
				</ul>
</li>
<security:authorize access="hasRole('ROLE_USER')">
<li><a href="<c:url value='/cart/getcart'></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;(${cartSize})</a></li>
</security:authorize>
</ul>
<ul class="nav navbar-nav navbar-right">
<c:if test="${pageContext.request.userPrincipal.name == null}">
<li><a href="<c:url value='/all/getregistrationform'></c:url>"><span class="glyphicon glyphicon-registration-mark"></span>&nbsp;<font color="white">Sign Up</font></a></li>
<li><a href="<c:url value='/login'></c:url>"><span class="glyphicon glyphicon-log-in"></span>&nbsp;<font color="white">Sign In</font></a></li>	
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != null}">
<li><a href="#">WELCOME ${pageContext.request.userPrincipal.name}</a></li>
<li><a href="<c:url value='/j_spring_security_logout'></c:url>"><span class="glyphicon glyphicon-log-out"></span>&nbsp;<font color="white">Sign Out</font></a></li>		
</c:if>
</ul>
</div>
</nav>

</div>
</body>




</html>