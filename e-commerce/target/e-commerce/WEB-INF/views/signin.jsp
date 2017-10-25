<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .container {
  margin-top: 30px
}
#f1 {
  max-width: 350px;
  width: 100%;
  margin: 40px auto;
  background: #fff;
  position: relative;
  box-shadow: 0 5px 5px 0 rgba(50, 50, 50, 0.7);
}
#f3 {
  padding: 9px 0;
  position: relative;
  margin-bottom: 0;
}
#f4, #f4:focus {
  border: none;
  box-shadow: none;
  padding-left: 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.26);
  border-radius: 0
}
#f2 {
    padding: 42px;
}
#b1.btn {
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
     opacity: 0.6;
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
<body background="${pageContext.request.contextPath}/resources/images/bg1.jpg">
<jsp:include page="Header.jsp"/>
<div class='container' id="nav">
  <div class='row'>
    <div class='col-md-12'>
    <form class="slideDown" id="f1" action="j_spring_security_check" method="post">
      <div class="form-Wrapper" id="f2">
        <div class="form-group" id="f3"> 
        <span style="font-weight:900">Email</span>            
            <input type="text" id="f4" class="form-control" name="j_username" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required >
        </div>
        <div class="form-group" id="f3">           
        <span style="font-weight:900">Password</span>
            <input type="password" class="form-control" id="f4" name="j_password"  required>
        </div>
       <!--   <div class="checkbox">
    <label><input type="checkbox" required> Remember me</label>
  </div> -->
        <button type="submit" class="btn btn-primary btn-block" id="b1">Login</button>
        <p align="center">new user? <a href="up">create new account</a></p>
      </div>
    </form>
    </div>
  </div>
</div>
  <jsp:include page="Footer.jsp"/>
</body>
</html>