<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"/>
</br></br></br></br>
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
						    <th style="width:10%">Id</th>
							<th style="width:20%">Name</th>
							<th style="width:10%">Action</th>
						</tr>
					</thead>
					<c:forEach var="designate" items="${lists}">
					<tbody>
			
						<tr>
						<td >${ designate.id}</td>
							<td><h4>${designate.name}</h4></td>
							<td >
								<a href="updates?supid=${ designate.id}"><button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button></a>
								<a href="deletes?supid=${ designate.id}"><button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button></a>								
							</td>
						</tr>
					
					</tbody>
					</c:forEach>
				</table>
				 
</div>
</br></br></br></br>
<jsp:include page="Footer.jsp"/>
</body>
</html>