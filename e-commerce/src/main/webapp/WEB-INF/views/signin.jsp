<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
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
.container {
  margin-top: 30px
}
form {
  max-width: 350px;
  width: 100%;
  margin: 40px auto;
  background: #fff;
  position: relative;
  box-shadow: 0 5px 5px 0 rgba(50, 50, 50, 0.7);
}
.form-group {
  padding: 20px 0;
  position: relative;
  margin-bottom: 0;
}
.form-control, .form-control:focus {
  border: none;
  box-shadow: none;
  padding-left: 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.26);
  border-radius: 0
}
.form-group label {
  position: absolute;
  width: 100%;
  left:0;
  right: 0;
  bottom: 0;
  overflow: hidden;
  top: 4px;
  color:  background: #000000;;
  
}
.form-Wrapper {
    padding: 42px;
}
button.btn {
  background: #40ff00;
  border: none;
  border-radius: 0;
  text-transform: uppercase;
 font-weight: bold;
  width: 180px;
  height: 45px;
  margin: 30px auto;
  display: block;
}
#navbar, #nav {
     opacity: 0.5;
}
.right{
text-align: right;
    float: right;}
.slideDown {
    animation-duration: 1.5s;
    animation-name: slideDown;
    animation-timing-function: ease;
    visibility: visible !important;
}
@keyframes slideDown {
0% {
    transform: translateY(-100%);
}
100% {
    transform: translateY(0%);
}
}
</style>
</head>
<body style="background-color:powderblue;">
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
        <li><a href="car"><span class=" glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
<div class='container' id="nav">
  <div class='row'>
    <div class='col-md-12'>
    <form class="slideDown">
      <div class="form-Wrapper">
        <div class="form-group">             
            <input type="email" class="form-control" id="inputEmail" > 
          <label for="inputEmail">Email</label>
        </div>
        <div class="form-group">           
            <input type="password" class="form-control" id="inputPassword">
           <label for="inputPassword">Password</label>
        </div>
         <div class="checkbox">
    <label><input type="checkbox" required> Remember me</label>
  </div>
        <button type="submit" class="btn btn-primary">Login</button>
        <div class="right">
   <a href="#forgot" data-toggle="modal"> Forgot Password? </a></br>
                                       <a href="signup.jsp">create an account</a>
                                       </div>
      </div>
    </form>
    </div>
  </div>
</div></nav>
<footer>
        <p>© 2017<a style="color:#0a93a6; text-decoration:none;" href="#"> Shopping Website</a>, All rights reserved 2017-2018.</p>
    </footer>
</body>
</html>