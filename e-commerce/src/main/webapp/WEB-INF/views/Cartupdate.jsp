<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:20%;
		margin:1.5em 0;
	}
	
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
  </style>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:8%">Product</th>
							<th style="width:2%">Price</th>
							<th style="width:1%">id</th>
							<th style="width:1%"></th>
							<th style="width:2%">Quantity</th>
						</tr>
					</thead>
					<tbody>
						<tr>
								
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="resources/Productimage/${ca.pid.img}" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${ca.pid.name}</h4>
									</div>
								</div>
							</td>
							<td data-th="Price">$${ca.price}</td>
							<form method="get" action="updatecart">
							<td><input type="number" class="form-control text-center" value="${ca.id}" name="id"></td>
							<td></td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="${ca.quantity}" name="quantity">				
								<input id="submit" class="btn btn-success btn-md" name="submit" type="submit" value="Update" style="width:100%">			    
							</td>
							</form>
						</tr>
					</tbody>
				</table>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>