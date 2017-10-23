<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:black;">
<jsp:include page="Header.jsp"/>
</br></br></br></br></br>
<div class="container">
            <div class="panel with-nav-tabs" >
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1" data-toggle="tab">Product</a></li>
                            <li><a href="#tab2" data-toggle="tab">Category</a></li>
                            <li><a href="#tab3" data-toggle="tab">Supplier</a></li>
                            <li><a href="#tab4" data-toggle="tab">Offer</a></li>
                            <li><a href="#tab5" data-toggle="tab">Editor</a></li> 
                            <li><a href="#tab6" data-toggle="tab">Latest Orders</a></li>                       
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1"> 
                        <form action="addP" method="post" enctype="multipart/form-data">
                         <div class="form-group">
        <label for="inputName" > Category</label>
        <select name="cat">
  <option value="volvo">Select Category</option>
  <c:forEach var="designatee" items="${categ}">
<option value="${designatee.id}">${designatee.name}</option>    
                    </c:forEach> 
  
</select>
        <label for="inputName" >Supplier</label>
        <select name="sid">
  <option value="volvo">Select Supplier</option>
  <c:forEach var="designatee" items="${catego}">
<option value="${designatee.id}">${designatee.name}</option>    
                    </c:forEach> 
  
</select>
</div>
     <div class="form-group">            
            <input type="hidden" class="form-control" name="n" placeholder="Enter Id" required> 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name"  placeholder="Enter Name" required> 
        </div>
        <div class="form-group">          
            <input type="number" class="form-control"  name="price" placeholder="Enter Price" required pattern="[0-9]+(\\.[0-9][0-9]?)?">
        </div>
        <div class="form-group">        
            <input type="number" class="form-control"  name="stock" placeholder="Enter Stock" required>
       
        </div>
         <div class="form-group">          
            <input type="text" class="form-control" style="height:100px;" name="short" placeholder="Enter Description" required>
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
   </form> </div>
                        <div class="tab-pane fade" id="tab2">
                             <form action="addC">
     <div class="form-group">            
            <input type="hidden" class="form-control" name="n" placeholder="Enter Id" > 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name" placeholder="Enter Name" > 
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form>
                        </div>
                        <div class="tab-pane fade" id="tab3">
                             <form action="addS">
     <div class="form-group">            
            <input type="hidden" class="form-control" name="n" placeholder="Enter Id"> 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name" placeholder="Enter Name"> 
        </div>
         <div class="form-group" >            
            <input type="text" class="form-control"  name="email" placeholder="Enter email"> 
        </div>
         <div class="form-group" >            
            <input type="long" class="form-control"  name="mob" placeholder="Enter Mobile No"> 
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form>
                        </div>
                        <div class="tab-pane fade" id="tab4">
                           <div><a href="offer"><h5 style="color:black;">Add Offer</h5></a></div>
                        </div>
                         <div class="tab-pane fade" id="tab5">
                         <ul>
                       <li><div><a href="listpro?f="><h5 style="color:black;">List of Products</h5></a></div></li>  
                       <li><div><a href="listcat?f="><h5 style="color:black;">List of Category</h5></a></div></li>
                       <li><div><a href="listsup?f="><h5 style="color:black;">List of Supplier</h5></a></div></li>  
                        </ul></div>
                         <div class="tab-pane fade" id="tab6">
                         <div><a href="order"><h5 style="color:black;">Pending Orders</h5></a></div>
                         </div>
                      </div></div></div></div>
                      </br></br></br></br></br>
                      <jsp:include page="Footer.jsp"/>

</body>
</html>