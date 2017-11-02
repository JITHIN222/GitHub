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
.item img{margin:auto; transition:all 0.3s ease; -webkit-transition:all 0.3s ease; -moz-transition:all 0.3s ease; -ms-transition:all 0.3s ease; -o-transition:all 0.3s ease;}
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




/* Indicators list style */
.article-slide .carousel-indicators {
    bottom: 0;
    left: 0;
    margin-left: 466px;
    margin-top: 410px;
    width: 100%;
}
/* Indicators list style */
.article-slide .carousel-indicators li {
    border: medium none;
    border-radius: 0;
    float: left;
    height: 54px;
    margin-bottom: 5px;
    margin-left: 0;
    margin-right: 5px !important;
    margin-top: 0;
    width: 100px;
}
/* Indicators images style */
.article-slide .carousel-indicators img {
    border: 2px solid #FFFFFF;
    float: left;
    height: 54px;
    left: 0;
    width: 100px;
}
/* Indicators active image style */
.article-slide .carousel-indicators .active img {
    border: 2px solid #428BCA;
    opacity: 0.7;
}


</style>
<body>
<jsp:include page="homeheader.jsp"/>
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
                               <a href="product?id=${ofp1.id}"> <div class="carousel-img">
                                    <img src="${pageContext.request.contextPath}/resources/Productimage/${ofp1.img4}" alt="sofa" class="img img-responsive" />
                                </div></a>
                                <div class="carousel-desc">
                                    <h2>${ofp1.name}</h2>
                                    <p style="font-size:30px;">$${ofp1.price}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item item2">
                        <div class="fill" style="background-color:#b33f4a;">
                            <div class="inner-content">
                                <a href="product?id=${ofp2.id}"><div class="carousel-img">
                                    <img src="${pageContext.request.contextPath}/resources/Productimage/${ofp2.img4}" alt="white-sofa" class="img img-responsive" />
                                </div></a>
                                <div class="carousel-desc">

                                    <h2>${ofp2.name}</h2>
                                    <p style="font-size:30px;">$${ofp2.price}</p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item item3">
                        <div class="fill" style="background-color:#7fc2f4;">
                            <div class="inner-content">
                               <a href="product?id=${ofp3.id}"> <div class="col-md-6">
                                    <div class="carousel-img">
                                        <img src="${pageContext.request.contextPath}/resources/Productimage/${ofp3.img4}" alt="sofa" class="img img-responsive" />
                                    </div></a>
                                </div>

                                <div class="col-md-6 text-left">
                                    <div class="carousel-desc">

                                        <h2>${ofp3.name}</h2>
                                        <p style="font-size:30px;">$${ofp3.price}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
    </section>
    
      <div id="section1">
  <h1><strong>Hot Deals</strong></h1>
  <div class="carousel slide article-slide" id="article-photo-carousel">

  <!-- Wrapper for slides -->
  <div class="carousel-inner cont-slider">
   
    <div class="item active"><h4 align="center">price: <small><strike>$${ofp11.price}</strike></small> <strong>$${ofp11.offerprice}</strong></h4><a href="product?id=${ofp11.id}"> 
      <img alt="" class="img-responsive" src="${pageContext.request.contextPath}/resources/Productimage/${ofp11.img}" style="width:200px; height:300px;">
      </a>
    </div>
    <div class="item"><h4 align="center"><small><strike>$${ofp11.price}</strike></small> <strong>$${ofp11.offerprice}</strong></h4><a href="product?id=${ofp21.id}"> 
      <img alt="" title="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp21.img}" style="width:200px; height:300px;"></a>
    </div>
    <div class="item"><h4 align="center"><small><strike>$${ofp11.price}</strike></small> <strong>$${ofp11.offerprice}</strong></h4><a href="product?id=${ofp31.id}"> 
      <img alt="" title="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp31.img}" style="width:200px; height:300px;"></a>
    </div>
    <div class="item"><h4 align="center"><small><strike>$${ofp11.price}</strike></small> <strong>$${ofp11.offerprice}</strong></h4><a href="product?id=${ofp41.id}"> 
      <img alt="" title="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp41.img}" style="width:200px; height:300px;"></a>
    </div>
  </div>
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li  data-slide-to="0" data-target="#article-photo-carousel">
      <img alt="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp11.img}"  style="width:99px;">
    </li>
    <li class="" data-slide-to="1" data-target="#article-photo-carousel">
      <img alt="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp21.img}" style="width:99px;">
    </li>
    <li class="" data-slide-to="2" data-target="#article-photo-carousel">
      <img alt="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp31.img}" style="width:99px;">
    </li>
    <li class="" data-slide-to="3" data-target="#article-photo-carousel">
      <img alt="" src="${pageContext.request.contextPath}/resources/Productimage/${ofp41.img}" style="width:99px;">
    </li>
  </ol>
</div></div>
<br><br><br><br><br><br>
  <jsp:include page="Footer.jsp"/>
</body>
</html>