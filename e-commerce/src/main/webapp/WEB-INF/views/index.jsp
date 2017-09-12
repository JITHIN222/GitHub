<!DOCTYPE html>
<html>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<body>
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
      <li><a href="in"><span class="w3-blue glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="up"><span class="w3-blue glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="car"><span class="w3-blue glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="item active" >  
                       <img src="images\3.jpg" alt="page1" style="width:100%; height:600px;"> 
                       <div class="carousel-caption">
                        <h1 class="w3-animate-fading w3-padding-64 ">image 1!</h1>       
                </div></div>
      <div class="item">
        <img src="\resources\images\1.jpg" alt="page2" style="width:100%; height:600px;">
        <div class="carousel-caption">
                        <h1 class="w3-animate-fading w3-padding-16">image 2 dgdfgsgsrgsgsrgzdhszgzsrgS!</h1>       
                </div>
      </div>
      <div class="item">
        <img src="images\2.jpg" alt="page3"  style="width:100%; height:600px;">
        <div class="carousel-caption">
                        <h1 class="w3-animate-bottom
                         w3-padding-64 text-success">image 3!</h1>       
                </div>
      </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div></nav>
    <footer>
        <p>© 2017<a style="color:#0a93a6; text-decoration:none;" href="#"> Shopping Website</a>, All rights reserved 2017-2018.</p>
    </footer>
</body>
</html>