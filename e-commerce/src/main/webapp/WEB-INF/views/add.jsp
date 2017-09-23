<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="in"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="up"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="car"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div></nav>
  <div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#prod">Category</a></li>
    <li><a data-toggle="tab" href="#cat">Product</a></li>  
    <li><a data-toggle="tab" href="#sup">Supplier</a></li>
  </ul>

  <div class="tab-content">
    <div id="prod" class="tab-pane fade in active">
    <form action="addC">
      <h3>Caterogy</h3>
      <label><b>Category Id</b></label>
    <input type="number" name="uname" required></br>
    <label><b>Category Name</b></label>
    <input type="text"  name="psw" required></br>
    <button type="submit" class="btn btn-default" href="ad">Save</button>
   </form> </div>
    </div>
    
  </div>

</body>
</html>