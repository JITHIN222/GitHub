<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
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
                            <li><a href="#tab2" data-toggle="tab">Category</a></li>
                            <li><a href="#tab3" data-toggle="tab">Supplier</a></li>
                            <li><a href="#tab4" data-toggle="tab">SubCategory</a></li>   
                            <li><a href="#tab5" data-toggle="tab">Editor</a></li>                        
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                    <c:forEach var="designate" items="${pro}">
                        <div class="tab-pane fade in active" id="tab1"> 
                        <form action="upP" method="post">
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
            <input type="text" class="form-control" name="n" placeholder="Enter Id"> 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name"  placeholder="Enter Name" value="${designate.name}"> 
        </div>
        <div class="form-group">          
            <input type="number" class="form-control"  name="price" placeholder="Enter Price" value="${designate.price}">
        </div>
        <div class="form-group">        
            <input type="number" class="form-control"  name="stock" placeholder="Enter Stock" value="${designate.stock}">
       
        </div>
         <div class="form-group">          
            <input type="text" class="form-control"  name="short" placeholder="Enter Description" value="${designate.shortDesc}">
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form> </div></c:forEach>
   
   
                        <div class="tab-pane fade" id="tab2">
                             <form action="upC">
     <div class="form-group">            
            <input type="number" class="form-control" name="n" placeholder="Enter Id" > 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name" placeholder="Enter Name" > 
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form>
                        </div>
                        
                        
                        
                        <div class="tab-pane fade" id="tab3">
                             <form action="upS">
     <div class="form-group">            
            <input type="number" class="form-control" name="n" placeholder="Enter Id"> 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name" placeholder="Enter Name"> 
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form>
                        </div>
                        
                        
                        <div class="tab-pane fade" id="tab4">
                             <form action="addSC">
                             <div class="form-group">
        <label for="inputName" > Category</label>
        <select name="cat">
  <option value="volvo">Select Category</option>
  <c:forEach var="designatee" items="${categ}">
<option value="${designatee.id}">${designatee.name}</option>    
                    </c:forEach> 
  
</select>
</div>
     <div class="form-group">            
            <input type="number" class="form-control" name="n" placeholder="Enter Id"> 
        </div>
        <div class="form-group" >            
            <input type="text" class="form-control"  name="name" placeholder="Enter Name"> 
        </div>
          <button type="submit" class="btn btn-success" href="ad">Save</button>
   </form>
                        </div>
                        
                        
                         <div class="tab-pane fade" id="tab5">
                         <ul>
                       <li><div><a href="listpro"><h5 style="color:black;">List of Products</h5></a></div></li>  
                       <li><div><a href="listcat"><h5 style="color:black;">List of Category</h5></a></div></li>
                       <li><div><a href="listsup"><h5 style="color:black;">List of Supplier</h5></a></div></li>    
                        </ul></div>
                      </div></div></div></div>
                      
                      <jsp:include page="Footer.jsp"/>

</body>
</html>