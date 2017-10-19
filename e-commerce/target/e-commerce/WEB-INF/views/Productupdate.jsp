<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product update</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:black;">
<jsp:include page="Header.jsp"/>
                      <div class="container">
            <div class="panel with-nav-tabs" >
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1" data-toggle="tab">Product</a></li>                        
                        </ul>
                </div>
                <div class="panel-body">
                 
                  <form action="upP" method="post" enctype="multipart/form-data">
                         <div class="form-group">
        <label for="inputName" > Category</label>
        <select name="cat">
  <option value="volvo">${pr.cid.name}</option>
  
  <c:forEach var="designatee" items="${categ}">
  
<option value="${designatee.id}">${designatee.name}</option>    
                    </c:forEach> 
  
</select>
        <label for="inputName" >Supplier</label>
        <select name="sid">
  
   <option value="volvo">${pr.sid.name}</option>
  <c:forEach var="designatee" items="${sup}">
  
<option value="${designatee.id}">${designatee.name}</option>    
                    </c:forEach> 
  
</select>
</div>
     <div class="form-group">            
            <input type="hidden" class="form-control" name="id" placeholder="Enter Id" value="${pr.id}" required> 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name"  placeholder="Enter Name" value="${pr.name}" required> 
        </div>
        <div class="form-group">          
            <input type="number" class="form-control"  name="price" placeholder="Enter Price" value="${pr.price }" required pattern="[0-9]+(\\.[0-9][0-9]?)?">
        </div>
        <div class="form-group">        
            <input type="number" class="form-control"  name="stock" placeholder="Enter Stock" value="${pr.stock }" required>
       
        </div>
         <div class="form-group">          
            <input type="text" class="form-control" style="height:100px;" name="short" placeholder="Enter Description" value="${pr.shortDesc }"required>
        </div>
<div class="form-group">                   
           <input type="file" name="img" required/>
        </div>
<div class="form-group">                   
           <input type="file" name="img1" required/>
        </div>
<div class="form-group">                   
           <input type="file" name="img2" required/>
        </div>
<div class="form-group">                   
           <input type="file" name="img3" required/>
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form> 
                       
                      </div></div></div>
                      <jsp:include page="Footer.jsp"/>

</body>
</html>