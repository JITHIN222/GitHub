<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers</title>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
table
{
	
   
border-collapse: separate;
    border-spacing: 10px ;
    cell-spacing:10px;
</style>
<body>
  <jsp:include page="Header.jsp" />  
     <div class="container">
             <div class="row">
     <div class="col-md-12">
     
     <div id="exTab2" class="container">	
<ul class="nav nav-tabs">
			<li class="active">
        <a  href="#1" data-toggle="tab">ADD OFFERS</a>
			</li>
			<li><a href="#2" data-toggle="tab">DELETE</a>
			</li>
			
		</ul>
			<div class="tab-content ">
			  <div class="tab-pane active" id="1">
			<c:forEach var="p" items="${pr}">
         <form action="setoffer?prid=${p.id}&actp=${p.price}" method="post">
      <table >
     
      
<tr>
<td>Name:${p.name}</td>
<td>Price:${p.price}</td>
<td><input type="number" name="offerprice" value="${p.offerprice}"></td>
<td><input id="submit" class="btn btn-success btn-md" name="submit" type="submit" value="Save" ></td>
</tr>
</table>
</form> 
         
         
         
         
         
         
         
                </c:forEach>
				</div>
				<div class="tab-pane" id="2">
				
				
				
				
				
 <table>
<thead>
						<tr>
							<th style="width:30%">Productname</th>
							<th style="width:20%">actual price</th>
							<th style="width:20%">offerprice</th>
							<th style="width:30%" class="text-center"></th>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="f" items="${offpr}">
  
<tr>
<td>${f.name}</td>
                                   
 
<td>
${f.price}
</td>
                                  
                                       
                                       
                                       
                                    <td>${f.offerprice}</td>
                                      <td> 
                                    
                                      <a href="offerdelete?pr=${f.id}"><input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="DELETE"></a>
                                       </td>
                                       
                                       
                             
                              
                                   
                                </tr>
                                
 </c:forEach>
                                </tbody>
								
								
 
 
 
 </table>
				
				
				
				
        
				</div>
    
			</div>
			</div>
			</div>
			</div>
			</div>
  <jsp:include page="Footer.jsp" />  
</body>
</html>