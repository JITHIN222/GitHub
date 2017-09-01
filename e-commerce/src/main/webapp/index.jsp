<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="navbar navbar-inverse">
<div class="navbar-header">
      <a class="navbar-brand">Welcome</a>
    </div>
<ul class="nav navbar-right">
        <li><a href="signin.jsp" class="glyphicon glyphicon-log-in text-success">Signin</a></li>
        </ul>
       <ul class="nav navbar-right">
            <li><a href="signup.jsp" class="glyphicon glyphicon-user text-warning">Signup</a></li>
        </ul>
    </div>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="item active"> 
        <img class="img-responsive" src="images\3.jpg" alt="page1" style="width:100%; height:100%">
      </div>
      <div class="item">
        <img class="img-responsive" src="images\1.jpg" alt="page2" style="width:100%;">
      </div>
      <div class="item">
        <img class="img-responsive" src="images\2.jpg" alt="page3" style="width:100%; height:100%">
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
  </div>
</div>
</body>
</html>
