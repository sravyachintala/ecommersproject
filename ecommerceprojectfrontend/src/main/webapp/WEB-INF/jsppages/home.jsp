<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chopard</title>


</head> 

<body>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="<c:url value='/resources/images/ChopardW.png'></c:url>" alt="first slide" width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                         
                               <a class= "btn btn-theme btn-sm btn-min-block" href="<c:url value='/login'></c:url>"><button id="myBtn" type="submit">Login</button></a><a class="btn btn-theme btn-sm btn-min-block" href="<c:url value='/all/getregistrationform'></c:url>"><button id="myBtn" type="submit">Register</button></a>
                        
                            <h1><font color="white">Welcome</font> to <font color="white">Chopard</font> Watch <font color="white">Store</font></h1>
                        
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img  src="<c:url value='/resources/images/SB_Watches_MenWatches_v1.jpg'></c:url>" alt="Second slide"width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                            <!-- <h1>.</h1> -->
                            <p><h2>Explore Men's Watches</h2></h2></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img  src="<c:url value='/resources/images/SB_Watches_LadiesWatches.png'></c:url>" alt="Third slide"width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                            <!-- <h1>.</h1> -->
                            <p><h2>Explore Women's Watches</h2></p>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img src="<c:url value='/resources/images/SB_Watches_Mouvements_ManualWatches_pf.png'></c:url>" alt="forth slide" width="100%">
                    <div class="container">
                        <div class="carousel-caption">
                            <!-- <h1>.</h1> -->
                            <p><h2>Explore Manual Watches</h2></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->




</div>

</body>
</html>