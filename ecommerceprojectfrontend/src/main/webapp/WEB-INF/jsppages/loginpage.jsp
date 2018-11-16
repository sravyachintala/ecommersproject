<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
<!-- <style type="text/css">
 #myVideo {
    position: fixed;
  top: 50%;
  left: 50%;
  min-width: 100%;
  min-height: 100%;
  width: auto;
  height: auto;
  z-index: -100;
  transform: translate(-50%, -50%);;
} 

</style> -->
</head>
<body>
<div class="container">
<font color="white">
<b>LoginPage</b>
</font>
<span style="color:white">${loginError}</span><br>
<form action="<c:url value='/j_spring_security_check'></c:url>" method="post">
<table class="table table">
<tr><td>EMAIL_ID</td><td><input type="text" name="j_username"></td>
<tr><td>PASSWORD</td><td><input type="password" name="j_password"></td>
<tr><td></td><td><button type="submit">LOGIN</button></td></tr>
</table>
</form>
<font color="white">
${message}
</font>
</div>
<%-- <video autoplay muted loop id="myVideo">
  <source src="<c:url value='/resources/img/video.mp4'></c:url>" type="video/mp4">
</video> --%>
</body>
</html>