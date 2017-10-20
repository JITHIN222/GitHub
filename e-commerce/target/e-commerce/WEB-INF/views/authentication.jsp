<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <style>
  div.background {
  background: url(http://oswintechnologies.com/error/404.jpg) ;
  border: 1px solid white;
     background-size: cover;
     background-repeat: no-repeat;
     height: 100%;
     width: 100%;
     margin : auto;
     padding: 120px;
}

/* Below piece of code makes  the highlitened box*/ 
div.err {
  margin: 100px;
  background-color: #ffffff;/* Used for colouring the transition box*/
  border: 1px solid white;
  opacity: 0.6;/*Used to specify opacity*/
  padding-top: 50px;
  padding-bottom: 50px
  
}

div.err p {
  margin: 2%;
  font-weight: bold;
  color: #000000;
  padding: 90px;
}
  </style>
</head>
<body >
<jsp:include page="Header.jsp"/>
<div class="background">
  <div class="err">
     <h2 style="text-align: center;">
          Oops Username & Password Doesn't Exist <a href="in" >Login Again</a></h2>
 </div>
  
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>