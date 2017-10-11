<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.btn-product{
	width: 100%;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="container">
    <div id="products" class="row list-group">
        <c:forEach items="${pro}" var="p"  varStatus="loop">
<a href="${p.id}">
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="resources/Productimage/${p.img}" alt="" style="width:70%; height:200px;"/>
                <div class="caption">
                    <h4 style="color:black" align="center">
                        ${p.name}</h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <h4 style="color:black">Price:<i class="fa fa-inr" style="color:red">${p.price}</i></h4>
                        </div></div>
                        <div class="row">
                        <div class="col-sm-6">
                        <a class="btn btn-primary btn-product" href="product?id=${p.id}"><span class="glyphicon glyphicon-zoom-in"></span> Quick view</a>                        
                           </div>
                        <div class="col-sm-6">
                           <a class="btn btn-success btn-product" href="product?id=${p.id}"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a> 
                        </div></div>
                </div>
            </div>
        </div></a>
        </c:forEach>
                    </div>
                </div>
 <jsp:include page="Footer.jsp"/>
</body>
</html>