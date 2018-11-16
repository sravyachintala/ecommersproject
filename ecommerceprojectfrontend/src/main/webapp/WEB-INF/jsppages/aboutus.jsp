<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AboutUs</title>
<style type="text/css">
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

</style>
</head>
<video autoplay muted loop id="myVideo">
  <source src="<c:url value='/resources/img/video.mp4'></c:url>" type="video/mp4">
</video>
<body>

</body>
</html>