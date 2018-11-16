<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="header.jsp" %>
     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LIST OF PRODUCTS</title>
<script type="text/javascript">
$(document).ready(function()
		{
			var searchCondition = '${searchCondition}'
			$('.table').DataTable({
				"lengthMenu":[[5,10,-1],[5,10,"All"]],
				"oSearch":{
				"sSearch":searchCondition
				}
			})
		}
		)
</script>
</head>
<body background="<c:url value='/resources/images/gray_black.jpg'></c:url>" >
<div class="container">
<font color="white">
<table align="center" class="table"><!-- table-responsive -->
<caption><h2><center><font color="black">LIST OF PRODUCTS</font></center></h2></caption>
<thead>

<tr><th><font color="black">PRODUCT ID</font></th><th><font color="black">PRODUCT NAME</font></th><!-- <th><font color="white">PRODUCT DESCRIPTION</font></th><th><font color="white">PRODUCT QUANTITY</font></th> --><th><font color="black">PRODUCT PRICE</font></th><th><font color="black">CATEGORY</font></th><th><font color="black">ACTION</font></th></tr></thead>

<tbody>
<c:forEach items="${product }" var="p">
<tr><td> <img src="<c:url value='/resources/images/${p.id}.png'></c:url>" height="180px" width="200px"></td><td><font color="black"><font size="3"><c:out value="${p.productname}"></c:out></font></font></td> <!--  <td><font color="white"><c:out value="${p.productdesc}"></c:out></font></td><td><font color="white"><c:out value="${p.quantity}"></c:out></font></td>--><td><font color="black"><font size="3"><c:out value="${p.price}"></c:out></font></font></td>
<td><font color="black"><font size="3"><c:out value="${p.category.categoryname}"></c:out></font></td>
<td>
<a href="<c:url value='/all/getproducts?id=${p.id}'></c:url>"><span class="glyphicon glyphicon-info-sign"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href="<c:url value='/admin/deleteproduct?id=${p.id}'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/admin/getupdateproductform?id=${p.id}'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
</security:authorize>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</font>
</div>
</body>
</html>