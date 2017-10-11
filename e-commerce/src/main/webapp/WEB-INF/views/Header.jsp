<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.dropdown-menu {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-menu a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown:hover .dropdown-menu {
    display: block;
}
</style>
</head>
<body>
  <nav class="navbar navbar-inverse" style="background-color:#424558">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="">Home</a></li>
      <li ><a href="ad">Admin</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="cat">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <c:forEach var="designatee" items="${cate}">
                       <li><a href="${designatee.id}">${designatee.name}</a></li>    
                    </c:forEach>  
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="up"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="in"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="car"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </ul>
  </div></nav>
</body>
</html>