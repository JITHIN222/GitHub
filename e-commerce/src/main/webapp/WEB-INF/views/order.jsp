<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(function(){
	$('a[title]').tooltip();
	});

</script>
<style>
.board{
    width: 75%;
margin: 60px auto;
height: 500px;
background: #fff;
/*box-shadow: 10px 10px #ccc,-10px 20px #ddd;*/
}
.board .nav-tabs {
    position: relative;
    /* border-bottom: 0; */
    /* width: 80%; */
    margin: 40px auto;
    margin-bottom: 0;
    box-sizing: border-box;

}

.board > div.board-inner{
    background: #fafafa url(http://subtlepatterns.com/patterns/geometry2.png);
    background-size: 30%;
}

p.narrow{
    width: 60%;
    margin: 10px auto;
}

.liner{
    height: 2px;
    background: #ddd;
    position: absolute;
    width: 80%;
    margin: 0 auto;
    left: 0;
    right: 0;
    top: 50%;
    z-index: 1;
}

.nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus {
    color: #555555;
    cursor: default;
    /* background-color: #ffffff; */
    border: 0;
    border-bottom-color: transparent;
}

span.round-tabs{
    width: 70px;
    height: 70px;
    line-height: 70px;
    display: inline-block;
    border-radius: 50px;
    background: white;
    z-index: 2;
    position: absolute;
    left: 0;
    text-align: center;
    font-size: 25px;
}

span.round-tabs.one{
    color: rgb(34, 194, 34);border: 2px solid rgb(34, 194, 34);
}

li.active span.round-tabs.one{
    background: #fff !important;
    border: 2px solid #ddd;
    color: rgb(34, 194, 34);
}

span.round-tabs.two{
    color: #febe29;border: 2px solid #febe29;
}

li.active span.round-tabs.two{
    background: #fff !important;
    border: 2px solid #ddd;
    color: #febe29;
}

span.round-tabs.three{
    color: #3e5e9a;border: 2px solid #3e5e9a;
}

li.active span.round-tabs.three{
    background: #fff !important;
    border: 2px solid #ddd;
    color: #3e5e9a;
}

span.round-tabs.four{
    color: #f1685e;border: 2px solid #f1685e;
}

li.active span.round-tabs.four{
    background: #fff !important;
    border: 2px solid #ddd;
    color: #f1685e;
}

span.round-tabs.five{
    color: #999;border: 2px solid #999;
}

li.active span.round-tabs.five{
    background: #fff !important;
    border: 2px solid #ddd;
    color: #999;
}

.nav-tabs > li.active > a span.round-tabs{
    background: #fafafa;
}
.nav-tabs > li {
    width: 20%;
}
li:after {
    content: " ";
    position: absolute;
    left: 45%;
   opacity:0;
    margin: 0 auto;
    bottom: 0px;
    border: 5px solid transparent;
    border-bottom-color: #ddd;
    transition:0.1s ease-in-out;
    
}
li.active:after {
    content: " ";
    position: absolute;
    left: 45%;
   opacity:1;
    margin: 0 auto;
    bottom: 0px;
    border: 10px solid transparent;
    border-bottom-color: #ddd;
    
}
.nav-tabs > li a{
   width: 70px;
   height: 70px;
   margin: 20px auto;
   border-radius: 100%;
   padding: 0;
}

.nav-tabs > li a:hover{
    background: transparent;
}

.tab-content .head{
    font-family: 'Roboto Condensed', sans-serif;
    font-size: 25px;
    text-transform: uppercase;
    padding-bottom: 10px;
}
.btn-outline-rounded{
    padding: 10px 40px;
    margin: 20px 0;
    border: 2px solid transparent;
    border-radius: 25px;
}

.btn.green{
    background-color:#5cb85c;
    /*border: 2px solid #5cb85c;*/
    color: #ffffff;
}

li i{
margin:20px;
}

@media( max-width : 585px ){
    
    .board {
width: 90%;
height:auto !important;
}
    span.round-tabs {
        font-size:16px;
width: 50px;
height: 50px;
line-height: 50px;
    }
    .tab-content .head{
        font-size:20px;
        }
    .nav-tabs > li a {
width: 50px;
height: 50px;
line-height:50px;
}

li.active:after {
content: " ";
position: absolute;
left: 35%;
}

.btn-outline-rounded {
    padding:12px 20px;
    }
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"/>
<%
String ship=(String)request.getAttribute("ship");

String[] shipr=ship.split(",");

String bill=(String)request.getAttribute("bill");

String[] billr=bill.split(",");
%>
<section style="background:#efefe9;">
        <div class="container">
            <div class="row">
                
                    <ul class="nav nav-tabs" id="myTab">
                     <li>
                     <a href="#home" title="Shipping Detail">
                      <span class="round-tabs one">
                              <i class="fa fa-home"></i>
                      </span> 
                  </a></li>

                  <li><a href="#profile">
                     <span class="round-tabs two">
                         <i class="fa fa-user"></i>
                     </span> 
           </a>
                 </li>
                 <li class="active"><a href="#messages"  >
                     <span class="round-tabs three">
                          <i class="fa fa-truck"></i>
                     </span> </a>
                     </li>

        <li><a href="#settings" >
                         <span class="round-tabs four">
                              <i class="fa fa-credit-card"></i>
                         </span> 
                     </a></li>

                     <li><a href="#doner">
                         <span class="round-tabs five">
                              <i class="fa fa-check"></i>
                         </span> </a>
                     </li>
                     
                     </ul></div>

                     <div class="tab-content">
                      <div class="tab-pane fade in active" >

                          <h3 class="head text-center">Order Confirmation</h3>
                          <table>
                          <tr>
                          <th  style="width:5%"></th>
                          <th style="width:5%">Billing Address</th>
							<th style="width:5%">Shipping Address</th></tr>
							<tr>
							<td></td>
							<td><address>
               <%=billr[0]%> <%=billr[1]%><br> 
                     <%=billr[2]%><br>
               <%=billr[4]%>, <%=billr[3]%>, pin:<%=billr[6]%><br>
               <%=billr[5]%><br>
               INDIA
</address>
							
							</td>
							<td><address>
               <%=shipr[0]%> <%=shipr[1]%><br> 
                     <%=shipr[2]%><br>
               <%=shipr[4]%>, <%=shipr[3]%>, pin:<%=shipr[6]%><br>
                Phone No:<%=shipr[5]%><br>
               INDIA
</address></td>
							
							</tr>
                          </table>
             	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:30%">Product</th>
							<th style="width:2%">Price</th>
							<th style="width:0.5%;">Quantity</th>
							<th style="width:2%">Subtotal</t>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach var="c" items="${ca}">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/resources/Productimage/${c.pid.img}" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${c.pid.name}</h4>
									</div>
								</div>
							</td>
							<td data-th="Price">$${c.price}</td>
							<td align="center">${c.quantity}</td>
							<td>$${c.price * c.quantity }</td>
							
						</tr></c:forEach>
					</tbody>
						
						<tr>
							<td><a href="#"></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total:$${t}</strong></td>
							<td><a href="buy"></td>
						</tr>
				</table>
                          <p class="text-center">
                    <a href="payment" class="btn btn-success btn-outline-rounded green"> Proceed to pay <span style="margin-left:10px;" class="glyphicon glyphicon-ok"></span></a>
                </p>
                      </div>

</div>
</div>


</section>
      <jsp:include page="Footer.jsp"/>             
</body>
</html>