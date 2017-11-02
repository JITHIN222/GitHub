<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 

<title>Footer</title>
</head>
<style>
.fa {
  padding: 15px;
  font-size: 21px;
  width: 55px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
  border-radius: 26%;
}

.fa-facebook {
  background: white;
  color: #D4AF37;
}

.fa-twitter {
  background: white;
  color: #D4AF37;
}

.fa-google {
  background: white;
  color: #D4AF37;
}

.fa-linkedin {
  background: white;
  color: #D4AF37;
}

.fa-youtube {
  background: white;
  color: #D4AF37;
}
.footer{
   background-color: #515199;
   position: absolute;
   margin-bottom: 0px;
 margin-top:1%;
    height: 350px;
    text-align: center;
    color: #CCC;
}

.footer p {
    padding: 10.5px;
    margin: 0px;
    line-height: 100%;
}
#s1{
padding: 10.5px;
}
</style>
<body>
<div class="footer">
 <div class="row">
      <div class="col-sm-4">
    <h3><img alt="" class="img-responsive" src="${pageContext.request.contextPath}/resources/images/101.png" style="margin:0; width:120px; height:60px;"></h3>
		    <p align="left">
		        <strong>TechGuru</strong> is One of the Top Online Shopping Site for Electronic Gadgets in India. The Company was started on November 2017 by Jithin.  </p>
 </div>
 	<div class="col-sm-4">
 	 <div class="form-group"></br>
                <div class="input-group" id="s1">
                  
                  <input class="form-control"   placeholder="Enter your email .." type="text">
                   <span class="input-group-btn">
                    <button class="btn btn-success"  type="submit">Subscribe Us !</button>
                  </span>
                </div>
              </div><p align="left">About us</p>
                  <p align="left">Website</p>
                  <p align="left">Blog</p>
                      </div>
      <div class="col-sm-4">
                <h2> <p align="left"><button class="btn btn-success">Contact us</button></p></h2>
                    <p align="left">Phone : +0487-232918</p>
                    <p align="left">Email : jidhin.shaj@gmail.com</p>
                    <p align="left">Fax : 123-456-789</p>
                    </div>
                    </div></br>
                    <p>Follow Us :</p>
<a href="#" class="fa fa-facebook"></a>
<a href="#" class="fa fa-twitter"></a>
<a href="#" class="fa fa-google"></a>
<a href="#" class="fa fa-linkedin"></a>
<a href="#" class="fa fa-youtube"></a></li>
       <h5>© 2017<a style="color:#0a93a6; text-decoration:none;" href="#"> TechGuru Website</a>, All rights reserved 2017-2018.</h5>
    </div>
        
</body>
</html>