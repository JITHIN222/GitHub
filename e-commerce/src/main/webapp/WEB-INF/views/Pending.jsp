<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pending orders</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"/>
<br><br><br><br>
<c:if test ="${fn:length(order) eq 0}">
<h2 align="center">All orders Shipped</h2>
</c:if>
<c:if test ="${fn:length(order) ge 1}">
<div class="panel panel-default panel-order">
  <div class="panel-heading">
      <strong>Pending orders</strong>
      <div class="btn-group pull-right">
          <div class="btn-group">


		  </div>
		</div>
  </div>
  
  <c:forEach var="o" items="${order}">	


<div class="panel-body">
  	<div class="row">
	  <div class="col-md-1"></div>
	  <div class="col-md-11">
		<div class="row">
		  <div class="col-md-12">
			
			<span><strong>Order ID</strong></span> <span class="label label-info">${o.id}</span><br>
			<span>Orders</span><p style="font-size: 25px">${o.order_detail }</p>
			<%-- <span>Total</span><p style="font-size: 25px">${o.total }</p> --%>
			<a href="shipped?id=${o.id}"><button>SHIP THE ORDERS</button></a>
		  </div>
		 
		</div>
	  </div>
	</div>

</div>


 <div class="col-md-12">
			order made by Email id: ${o.username}
		  </div>
</c:forEach>
</div></c:if>
<br><br><br><br><br>
<jsp:include page="Footer.jsp"/>
</body>
</html>