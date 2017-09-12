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
}</style>
</head>
<body>
<form class="form-horizontal" role="form">
  <nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
      <li><a href="#">Basket</a></li>
    </ul>
  </div>
</nav>
<div class="container" style="max-width:600px;padding:40px 20px;background:#ebeff2">
	   <div class="form-group">
	      <label for="name" class ="control-label col-sm-3">First name</label>
		<div class="col-sm-8">
	      <input type="name" class="form-control" id="name" placeholder="Enter name">
		</div>
	    </div>
	   <div class="form-group">
	      <label for="address" class ="control-label col-sm-3">Second name</label>
		<div class="col-sm-8">
	      <input type="address" class="form-control" id="address" placeholder="Enter address">
		</div>
	    </div>
	   <div class="form-group">
	      <label for="email" class ="control-label col-sm-3">Email</label>
		<div class="col-sm-8">
	      <input type="email" class="form-control" id="email" placeholder="Enter email">
		</div>
	    </div>
	   <div class="form-group">
	      <label for="pwd" class ="control-label col-sm-3">Password</label>
		<div class="col-sm-8">
	      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
		</div>
	    </div>
	   <div class="col-sm-offset-2 col-sm-8">
	     <button type="submit" class="btn btn-default">Register</button>
	   </div>
	   </div>
	   <footer>
        <p>© 2017<a style="color:#0a93a6; text-decoration:none;" href="#"> Shopping Website</a>, All rights reserved 2017-2018.</p>
    </footer>
	</form>
</body>
</html>