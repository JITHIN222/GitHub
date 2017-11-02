<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
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
  <nav class="navbar navbar-inverse" style="background-color:#515199; height:80px; margin:0px;">
  <div class="container-fluid">
    <div class="navbar-Left">
      <a class="navbar-brand" href="./"><img alt="" class="img-responsive" src="${pageContext.request.contextPath}/resources/images/101.png" style="margin:0; width:120px; height:60px;"></a>
    </div>
    <ul class="nav navbar-nav">
       <c:if test="${pageContext.request.userPrincipal.name  == 'lovelyps@gmail.com'}">
      <li ><a href="ad" style="color:#e3e3e5;">Admin</a></li>
      </c:if>
       <c:if test="${pageContext.request.userPrincipal.name  != 'lovelyps@gmail.com'}">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" style="color:#e3e3e5;">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <c:forEach var="c" items="${cate}">
                       <li><a href="${c.id}">${c.name}</a></li>    
                    </c:forEach>  
        </ul>
      </li></c:if>
      <c:if test="${pageContext.request.userPrincipal.name  != 'lovelyps@gmail.com'}">
            <li><a href="#section1" style="color:#e3e3e5;">Sale On</a></li></c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name == null }">
      <li><a href="up?f=" style="color:#e3e3e5;"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="in" style="color:#e3e3e5;"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name  != 'lovelyps@gmail.com'}">
        <li><a href="cart" style="color:#e3e3e5;"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a style="color:#e3e3e5;">Welcome: ${pageContext.request.userPrincipal.name}</a></li>
					<li><a href='<c:url value="/j_spring_security_logout" />' style="color:#e3e3e5;"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
				</c:if>
      </ul>
  </div></nav>
</body>
</html>