<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.btn-product{
	width: 100%;
}
.btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
.icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}
</style>
</head>
<body>
<jsp:include page="Header.jsp"/>
</br></br></br></br>
<c:if test ="${fn:length(pro) eq 0}">
<h2 align="center">Products Out of Stock</h2>
</c:if>
<c:if test ="${fn:length(pro) ge 1}">
<div class="container">
    <div id="products" class="row list-group">
        <c:forEach items="${pro}" var="p"  varStatus="loop">
<a href="${p.id}">
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
            <a href="product?id=${p.id}">
                <img class="group list-group-image" src="${pageContext.request.contextPath}/resources/Productimage/${p.img}" alt="" style="width:48%; height:180px;"/></a>
                <div class="caption">
                    <h4 style="color:black" align="center">
                        ${p.name}</h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                        <c:if test="${p.offer eq 1}">     
                    <h3 style="margin-top:0px; color:black;">Price:$${p.offerprice}</h3> 
                    </c:if>
                        <c:if test="${p.offer eq 0}">     
                    <h3 style="margin-top:0px; color:black;">Price: $${p.price}</h3> 
                    </c:if>
                        </div></div>
                        <div class="row">
                        <div class="col-sm-6">
                        <a class="btn icon-btn btn-primary " href="product?id=${p.id}"><span class="glyphicon btn-glyphicon glyphicon-zoom-in img-circle text-primary"></span>Quick view</a>                        
                           </div>
                        <c:if test="${pageContext.request.userPrincipal.name  != null}">
                        <div class="col-sm-6">
                           <a class="btn icon-btn btn-success" href="car?id=${p.id}"><span class="glyphicon btn-glyphicon glyphicon-shopping-cart img-circle text-success"></span> Add to cart</a> 
                        </div></c:if>
                        <c:if test="${pageContext.request.userPrincipal.name  == null}">
					<div class="col-sm-6">
                          <a class="btn icon-btn btn-success" href="in"><span class="glyphicon btn-glyphicon glyphicon-log-in img-circle text-success"></span>Sign in</a></div></c:if></div>
                </div>
            </div>
        </div></a>
        </c:forEach>
                    </div>
                </div></c:if>
                </br></br></br></br>
 <jsp:include page="Footer.jsp"/>
</body>
</html>