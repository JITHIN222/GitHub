<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="indexfooter.css" type="text/css">
  <style>
      footer{
   background-color: #424558;
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    height: 35px;
    text-align: center;
    color: #CCC;
}

footer p {
    padding: 10.5px;
    margin: 0px;
    line-height: 100%;
}
  </style>
</head>
<body>
<form>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="in"><span class=" glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="up"><span class=" glyphicon glyphicon-user"></span> Sign Up</a></li>
      </ul>
    </div>
  </div>
 <div class="row">
 <div class="col-xs-2" >
 <div class="container">
<div class="jumbotron" style="background-color:#D7D6CC;" >
<table class="table table-bordered">
    <tbody>
      <tr class="danger">
        <td>Product type</td>
        <td>Gloves</td>
      </tr>      
      <tr class="success">
        <td>Name</td>
        <td>Kookaburra Kahuna 1000 English Willow Cricket Bat</td>
      </tr>
      <tr class="danger">
        <td>Description</td>
        <td>This type of willow seasoning gives best in class willow characteristics to cricket bat</td>
      </tr>
      <tr class="info">
        <td>Supplier</td>
        <td>Prime dealers</td>
      </tr>
      <tr class="danger">
        <td>Price</td>
        <td>2500.00</td>
      </tr>
    </tbody>
  </table>
  <div>
<input type="button" value="Add to Cart" >
						</div>
</div></div> </div></div></nav>
<footer>
        <p>© 2017<a style="color:#0a93a6; text-decoration:none;" href="#"> Shopping Website</a>, All rights reserved 2017-2018.</p>
    </footer>
</form>
</body>
</html>