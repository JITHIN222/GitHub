<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link href="https://fonts.googleapis.com/css?family=Sansita" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>$(document).ready(function(){
// invoke the carousel
    $('#myCarousel').carousel({
      interval:6000
    });

// scroll slides on mouse scroll 
$('#myCarousel').bind('mousewheel DOMMouseScroll', function(e){

        if(e.originalEvent.wheelDelta > 0 || e.originalEvent.detail < 0) {
            $(this).carousel('prev');
			
			
        }
        else{
            $(this).carousel('next');
			
        }
    });

//scroll slides on swipe for touch enabled devices 

 	$("#myCarousel").on("touchstart", function(event){
 
        var yClick = event.originalEvent.touches[0].pageY;
    	$(this).one("touchmove", function(event){

        var yMove = event.originalEvent.touches[0].pageY;
        if( Math.floor(yClick - yMove) > 1 ){
            $(".carousel").carousel('next');
        }
        else if( Math.floor(yClick - yMove) < -1 ){
            $(".carousel").carousel('prev');
        }
    });
    $(".carousel").on("touchend", function(){
            $(this).off("touchmove");
    });
});
    
});
//animated  carousel start
$(document).ready(function(){

//to add  start animation on load for first slide 
$(function(){
		$.fn.extend({
			animateCss: function (animationName) {
				var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
				this.addClass('animated ' + animationName).one(animationEnd, function() {
					$(this).removeClass(animationName);
				});
			}
		});
			 $('.item1.active img').animateCss('slideInDown');
			 $('.item1.active h2').animateCss('zoomIn');
			 $('.item1.active p').animateCss('fadeIn');
			 
});
	
//to start animation on  mousescroll , click and swipe


 
     $("#myCarousel").on('slide.bs.carousel', function () {
		$.fn.extend({
			animateCss: function (animationName) {
				var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
				this.addClass('animated ' + animationName).one(animationEnd, function() {
					$(this).removeClass(animationName);
				});
			}
		});
	
// add animation type  from animate.css on the element which you want to animate

		$('.item1 img').animateCss('slideInDown');
		$('.item1 h2').animateCss('zoomIn');
		$('.item1 p').animateCss('fadeIn');
		
		$('.item2 img').animateCss('zoomIn');
		$('.item2 h2').animateCss('swing');
		$('.item2 p').animateCss('fadeIn');
		
		$('.item3 img').animateCss('fadeInLeft');
		$('.item3 h2').animateCss('fadeInDown');
		$('.item3 p').animateCss('fadeIn');
    });
});
  </script>
<style>
 html, body{
    width:100%;
    height:100%;
    background-color:#fff;
	font-family: 'Sansita', sans-serif;
    }
.carousel-inner,.carousel,.item,.container,.fill {
  height:100%;
  width:100%;
  background-position:center center;
  background-size:cover;
}
.slide-wrapper{display:inline;}
.slide-wrapper .container{padding:0px;}

/*------------------------------ vertical bootstrap slider----------------------------*/

.carousel-inner> .item.next ,  .carousel-inner > .item.active.right{ transform: translateY(100%); -webkit-transform: translateY(100%); -ms-transform: translateY(100%);
-moz-transform: translateY(100%); -o-transform: translateY(100%);  top: 0;left:0;}
.carousel-inner > .item.prev ,.carousel-inner > .item.active.left{ transform: translateY(-100%); -webkit-transform: translateY(-100%);  -moz-transform: translateY(-100%);
-ms-transform: translateY(-100%); -o-transform: translateY(-100%); top: 0; left:0;}
.carousel-inner > .item.next.left , .carousel-inner > .item.prev.right , .carousel-inner > .item.active{transform:translateY(0); -webkit-transform:translateY(0);
-ms-transform:translateY(0);-moz-transform:translateY(0); -o-transform:translateY(0); top:0; left:0;}

/*------------------------------- vertical carousel indicators ------------------------------*/
.carousel-indicators{
position:absolute;
top:0;
bottom:0;
margin:auto;
height:20px;
right:10px; left:auto;
width:auto;
}
.carousel-indicators li{display:block; margin-bottom:5px; border:1px solid #00a199; }
.carousel-indicators li.active{margin-bottom:5px; background:#00a199;}
/*-------- Animation slider ------*/

.animated{
	animation-duration:3s;
	-webkit-animation-duration:3s;
	-moz-animation-duration:3s;
	-ms-animation-duration:3s;
	-o-animation-duration:3s;
	visibility:visible;
	opacity:1;
	transition:all 0.3s ease;
}
.carousel-img{   
	 display: inline-block;
    margin: 0 auto;
    width: 100%;
    text-align: center;
	}
.item img{margin:auto;visibility:hidden; opacity:0; transition:all 0.3s ease; -webkit-transition:all 0.3s ease; -moz-transition:all 0.3s ease; -ms-transition:all 0.3s ease; -o-transition:all 0.3s ease;}
.item1 .carousel-img img , .item1.active .carousel-img img{max-height:300px;}
.item1.active .carousel-img img.animated{visibility:visible; opacity:1; transition:all 1s ease; -webkit-transition:all 1s ease; -moz-transition:all 1s ease; -ms-transition:all 1s ease; -o-transition:all 1s ease;
animation-duration:2s; -webkit-animation-duration:2s; -moz-animation-duration:2s; -ms-animation-duration:2s; -o-animation-duration:2s; animation-delay:0.3s ; -webkit-animation-delay:0.3s;
-moz-animation-delay:0.3s;-ms-animation-delay:0.3s; }
.item .carousel-desc{color:#fff; text-align:center;}
.item  h2{font-size:50px; animation-delay:1.5s;animation-duration:1s; }
.item  p{animation-delay:2.5s;animation-duration:1s; width:50%; margin:auto;}

.item2 .carousel-img img , .item2.active .carousel-img img{max-height:300px;}
.item2.active .carousel-img img.animated{visibility:visible; opacity:1; transition:all 0.3s ease; animation-duration:3s; animation-delay:0.3s}
.item2 h2 , item2.active h2{visibility:hidden; opacity:0; transition:all 5s ease;}
.item2.active h2.animated{visibility:visible; opacity:1;  animation-delay:3s;}

.item .fill{padding:0px 30px; display:table; }
.item .inner-content{display: table-cell;vertical-align: middle;}
.item3 .col-md-6{float:none; display:inline-block; vertical-align:middle; width:49%;}

.item3.active .carousel-img img.animated{visibility:visible; opacity:1; transition:all 0.3s ease; animation-duration:2s; animation-delay:0.3s}
.item3 h2 , item3.active h2{visibility:hidden; opacity:0; transition:all 5s ease; }
.item.item3 .carousel-desc{text-align:left;}
.item3.active h2.animated{visibility:visible; opacity:1;  animation-delay:1.5s}
.item3 p , item3.active p{visibility:hidden; opacity:0; transition:all 5s ease; width:100%;  }
.item3.active p.animated{visibility:visible; opacity:1;  animation-delay:2.5s;}

@media(max-width:991px)
{
	.item .carousel-desc , .item.item3 .carousel-desc{text-align:center;}
	.item .carousel-desc p {width:80%;}
	.item3 .col-md-6{width:100%; text-align:center;}
}
@media(max-width:768px)
{
.item .carousel-img img, .item.active .carousel-img img{max-height:155px;}
.item  h2{font-size:30px; margin-top:0px;}
.item .carousel-desc p{width:100%; font-size:12px;}
}
@media(max-width:480px)
{
.item  h2{font-size:30px;}
.item .carousel-desc p{width:100%;}
}



.MultiCarousel { float: left; overflow: hidden; padding: 15px; width: 100%; position:relative; }
    .MultiCarousel .MultiCarousel-inner { transition: 1s ease all; float: left;width:100%;hieght:100% }
        .MultiCarousel .MultiCarousel-inner .item { float: left; width:100%;hieght:100%}
        .MultiCarousel .MultiCarousel-inner .item > div { text-align: center; padding:10px; margin:10px; background:#f1f1f1; color:#666;}
    .MultiCarousel .leftLst, .MultiCarousel .rightLst { position:absolute; border-radius:50%;top:calc(50% - 20px); }
    .MultiCarousel .leftLst { left:0; }
    .MultiCarousel .rightLst { right:0; }
    
        .MultiCarousel .leftLst.over, .MultiCarousel .rightLst.over { pointer-events: none; background:#ccc; }


</style>
<body>
<jsp:include page="Header.jsp"/>
  <section class="slide-wrapper">
        <div class="container">
            <div id="myCarousel" class="carousel slide">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                 </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item item1 active">
                        <div class="fill" style=" background-color:#F5DEB3;">
                            <div class="inner-content">
                                <div class="carousel-img">
                                    <img src="${pageContext.request.contextPath}/resources/images/125.png" alt="sofa" class="img img-responsive" />
                                </div>
                                <div class="carousel-desc">
                                    <h2>MacBook</h2>
                                    <p>The vision is brighter than ever</p>
                                    <p>A touch of genius</p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item item2">
                        <div class="fill" style="background-color:#b33f4a;">
                            <div class="inner-content">
                                <div class="carousel-img">
                                    <img src="${pageContext.request.contextPath}/resources/images/123.png" alt="white-sofa" class="img img-responsive" />
                                </div>
                                <div class="carousel-desc">

                                    <h2>OPPO f3</h2>
                                    <p>OPPO F3 Plus offers fast and fluid multitasking</p>
                                    <p>Beautiful Metal Design</p>
                                    <p>Big Battery, Fast Charging</p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item item3">
                        <div class="fill" style="background-color:#7fc2f4;">
                            <div class="inner-content">
                                <div class="col-md-6">

                                    <div class="carousel-img">
                                        <img src="${pageContext.request.contextPath}/resources/images/124.png" alt="sofa" class="img img-responsive" />
                                    </div>
                                </div>

                                <div class="col-md-6 text-left">
                                    <div class="carousel-desc">

                                        <h2>Canon IXUS</h2>
                                        <p>Make the Most of Your Photos</p>
                                        <p>Make Memories</p>
                                        <p>Capture Life</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
  <h1><strong>Hot Deals</strong></h1>
    <div class="row">
<c:forEach items="${off}" var="p"  varStatus="loop">
<c:if test="${p.offer eq 1}">
<div class="col-sm-2">
    <img src="${pageContext.request.contextPath}/resources/Productimage/${p.img}" class="img-responsive">
    <table><tr><p align="center">${p.name}</p></tr>
    <tr><p align="center"><font color="black"><strong> $${p.offerprice}</strong></font> <strike><small>$${p.price}</small></strike> <font color="black">${p.offerper}% off</font></p></tr>
    <div class="row">
    <div class="col-sm-6">
    <a class="btn btn-success btn-product" href="car?id=${p.id}"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a>
    </div>
    <div class="col-sm-6">
    <a class="btn btn-danger btn-product" href="buy?id=${p.id}"><span class="glyphicon glyphicon-flash"></span> Buy Now</a>
    </div></div>
    </table>
</div>
</c:if>
</c:forEach></div>



    <div class="row">
<div class="col-sm-2">
    <img src="${pageContext.request.contextPath}/resources/Productimage/${ofp1.img}" class="img-responsive">
    <table><tr><p align="center">${ofp1.name}</p></tr>
    <tr><p align="center"><font color="black"><strong> $${ofp1.offerprice}</strong></font> <strike><small>$${ofp1.price}</small></strike> <font color="black">${ofp1.offerper}% off</font></p></tr>
    <div class="row">
    <div class="col-sm-6">
    <a class="btn btn-success btn-product" href="car?id=${ofp1.id}"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a>
    </div>
    <div class="col-sm-6">
    <a class="btn btn-danger btn-product" href="buy?id=${ofp1.id}"><span class="glyphicon glyphicon-flash"></span> Buy Now</a>
    </div></div>
    </table>
</div>
</div> 

	<div class="row">
	
	
		<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel"  data-interval="1000">
            <div class="MultiCarousel-inner">
            
            
            <c:forEach var="o" items="${of}">
          <a href="product?id=${o.id}" > 
        
                <div class="item">
                    <div class="pad15">
                    <img src="${pageContext.request.contextPath}/resources/Productimage/${o.img}" class="img-responsive" style="width:100px; height:250px">
                        <p class="lead">${o.name}</p>
                        <p><strike>$${o.price}</strike> $${o.offerprice}</p>
                        <p>${o.offerper }% OFF</p>
                    </div>
                </div>
               
                </a>
</c:forEach>              
              
            </div>
            <button class="btn btn-success leftLst"><</button>
            <button class="btn btn-success rightLst">></button>
        </div>
	</div>
  <jsp:include page="Footer.jsp"/>
</body>
</html>