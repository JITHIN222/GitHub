<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="indexfooter.css" type="text/css">
<style>
body, html {height: 100%}
body,h1,h2,h3,h4,h5,h6 {font-family: "Amatic SC", sans-serif}
.menu {display: none}
</style>
<body>

<div class="w3-top w3-hide-small">
  <div class="w3-bar w3-xlarge w3-black w3-opacity w3-hover-opacity-off" id="myNavbar">
    <a href="#" class="w3-bar-item w3-button active">HOME</a>
    <a href="signin.jsp" class="w3-bar-item w3-button">Login</a>
    <a href="signup.jsp" class="w3-bar-item w3-button">Signup</a>
  </div>
</div>

  <div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    
    <div class="carousel-inner">
      <div class="item active" >  
                       <img class="img-responsive" src="images\3.jpg" alt="page1" width="100%" height="800px"> 
                       <div class="carousel-caption">
                        <h1 class="w3-animate-fading w3-padding-64 ">image 1!</h1>       
                </div></div>
      <div class="item">
        <img class="img-responsive w3-hover-opacity" src="images\1.jpg" alt="page2"  width="100%" height="800px">
        <div class="carousel-caption">
                        <h1 class="w3-animate-fading w3-padding-16">image 2 dgdfgsgsrgsgsrgzdhszgzsrgS!</h1>       
                </div>
      </div>
      <div class="item">
        <img class="img-responsive" src="images\2.jpg" alt="page3"  width="100%" height="800px">
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
  </div>
    <footer>
        <p>© 2017<a style="color:#0a93a6; text-decoration:none;" href="#"> Shopping Website</a>, All rights reserved 2017-2018.</p>
    </footer>
</body>
</html>