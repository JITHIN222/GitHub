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
    <div class="row">
         <c:forEach items="${pro}" var="p"  varStatus="loop">
<a href="${p.id}">
    	<div class="col-md-12">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail" >
					<h4 class="text-center"><span class="label label-info">Quick view</span></h4>
					<img src="resources/Productimage/${p.img}" class="img-responsive" style="width:80%; height:250px;">
					<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>${p.shortDesc}</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
								<h3>
								<label>$${p.price}</label></h3>
							</div>
						</div>
						<p>${p.shortDesc}</p>
						<div class="row">
							<div class="col-md-6">
								<a class="btn btn-primary btn-product" href="product?id=${p.id}"><span class="glyphicon glyphicon-circle-arrow-right"></span> Buy</a> 
							</div>
							<div class="col-md-6">
								<a href="#" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a></div>
						</div>

						<p> </p>
					</div>
				</div>
			</div>
        </div> 
        </a>
        </c:forEach>

	</div>
</div>
 <jsp:include page="Footer.jsp"/>
</body>
</html>