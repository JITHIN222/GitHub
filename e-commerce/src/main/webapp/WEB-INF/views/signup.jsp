<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registeration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="indexfooter.css" type="text/css">
  <style >
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
  padding: 20px 0;
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
<body>
<jsp:include page="Header.jsp"/>
<div class='container' id="nav">
  <div class='row'>
    <div class='col-md-12'>
    <form class="slideDown" id="f1" action="reg">
      <div class="form-Wrapper" id="f2">
        <div class="form-group" id="f3">            
          <label for="inputName">Full Name</label>
            <input type="text" class="form-control" id="f4" name="fname" > 
        </div>
        <div class="form-group" id="f3">            
          <label for="inputEmail">Email</label>
            <input type="email" class="form-control" id="f4" name="email" > 
        </div>
        <div class="form-group" id="f3">    
        <label for="inputPassword">Password</label>       
            <input type="password" class="form-control" id="f4" name="pwd">
        </div>
        <div class="form-group" id="f3">  
        <label for="inputPassword">Confirm Password</label>         
            <input type="password" class="form-control" id="f4" name="cpwd">     
        </div>
         <div class="form-group" id="f3">  
        <label for="inputNumber">Mobile Number</label>         
            <input type="password" class="form-control" id="f4" name="no">     
        </div>
     <!--     <div class="checkbox">
    <label><input type="checkbox" required> Remember me</label>
  </div> -->
        <button type="submit" class="btn btn-primary btn-block" id="b1">Register</button>
        <p align="center"><a href="in">Already have an account?</a></p>
      </div>
    </form>
    </div>
  </div>
</div></nav>
	<jsp:include page="Footer.jsp"/>
</body>
</html>