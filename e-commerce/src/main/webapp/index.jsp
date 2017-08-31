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
<body background="bgimage.jpg">
<div class="container">
<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Menu
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="signin.html">Signin</a></li>
    <li><a href="signup.html">Signup</a></li>
  </ul>
</div>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="images\joker-3.jpg" alt="Los Angeles" style="width:100%; height:100%">
      </div>
      <div class="item">
        <img src="images\Greatest-Superhero-Films-The-Dark-Knight.jpg" alt="Chicago" style="width:100%;">
      </div>
      <div class="item">
        <img src="images\joker-hands-wait-so-now-the-joker-s-immortal.jpeg" alt="New york" style="width:100%; height:100%">
      </div>
      <h1 style="color:red;">Welcome to Hell</h1>
    </div>

    <!-- Left and right controls -->
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
