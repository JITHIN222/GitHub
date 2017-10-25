<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<script>
!function ($) {

    "use strict"; // jshint ;_;


    /* MAGNIFY PUBLIC CLASS DEFINITION
     * =============================== */

    var Magnify = function (element, options) {
        this.init('magnify', element, options)
    }

    Magnify.prototype = {

        constructor: Magnify

        , init: function (type, element, options) {
            var event = 'mousemove'
                , eventOut = 'mouseleave';

            this.type = type
            this.$element = $(element)
            this.options = this.getOptions(options)
            this.nativeWidth = 0
            this.nativeHeight = 0

            this.$element.wrap('<div class="magnify" \>');
            this.$element.parent('.magnify').append('<div class="magnify-large" \>');
            this.$element.siblings(".magnify-large").css("background","url('" + this.$element.attr("src") + "') no-repeat");

            this.$element.parent('.magnify').on(event + '.' + this.type, $.proxy(this.check, this));
            this.$element.parent('.magnify').on(eventOut + '.' + this.type, $.proxy(this.check, this));
        }

        , getOptions: function (options) {
            options = $.extend({}, $.fn[this.type].defaults, options, this.$element.data())

            if (options.delay && typeof options.delay == 'number') {
                options.delay = {
                    show: options.delay
                    , hide: options.delay
                }
            }

            return options
        }

        , check: function (e) {
            var container = $(e.currentTarget);
            var self = container.children('img');
            var mag = container.children(".magnify-large");

            // Get the native dimensions of the image
            if(!this.nativeWidth && !this.nativeHeight) {
                var image = new Image();
                image.src = self.attr("src");

                this.nativeWidth = image.width;
                this.nativeHeight = image.height;

            } else {

                var magnifyOffset = container.offset();
                var mx = e.pageX - magnifyOffset.left;
                var my = e.pageY - magnifyOffset.top;

                if (mx < container.width() && my < container.height() && mx > 0 && my > 0) {
                    mag.fadeIn(100);
                } else {
                    mag.fadeOut(100);
                }

                if(mag.is(":visible"))
                {
                    var rx = Math.round(mx/container.width()*this.nativeWidth - mag.width()/2)*-1;
                    var ry = Math.round(my/container.height()*this.nativeHeight - mag.height()/2)*-1;
                    var bgp = rx + "px " + ry + "px";

                    var px = mx - mag.width()/2;
                    var py = my - mag.height()/2;

                    mag.css({left: px, top: py, backgroundPosition: bgp});
                }
            }

        }
    }


    /* MAGNIFY PLUGIN DEFINITION
     * ========================= */

    $.fn.magnify = function ( option ) {
        return this.each(function () {
            var $this = $(this)
                , data = $this.data('magnify')
                , options = typeof option == 'object' && option
            if (!data) $this.data('tooltip', (data = new Magnify(this, options)))
            if (typeof option == 'string') data[option]()
        })
    }

    $.fn.magnify.Constructor = Magnify

    $.fn.magnify.defaults = {
        delay: 0
    }


    /* MAGNIFY DATA-API
     * ================ */

    $(window).on('load', function () {
        $('[data-toggle="magnify"]').each(function () {
            var $mag = $(this);
            $mag.magnify()
        })
    })

} ( window.jQuery );
</script>
<style>
.carousel-inner {
  position: relative;
  width: 100%;
  min-height: 300px;
  }
 
 .carousel-control.right {
  right: 0;
  left: auto;
  background-image: none !important;
  background-repeat: repeat-x;
}
 .carousel-control.left {
  left: 0;
  right: auto;
  background-image: none !important;
  background-repeat: repeat-x;
}
#carousel-custom {
    margin: 20px auto;
    width: 400px;
}
#carousel-custom .carousel-indicators {
    margin: 10px 0 0;
    overflow: auto;
    position: static;
    text-align: left;
    white-space: nowrap;
    width: 100%;
    overflow:hidden;
}
#carousel-custom .carousel-indicators li {
    background-color: transparent;
    -webkit-border-radius: 0;
    border-radius: 0;
    display: inline-block;
    height: auto;
    margin: 0 !important;
    width: auto;
}
#carousel-custom .carousel-indicators li img {
    display: block;
    opacity: 0.9;
}
#carousel-custom .carousel-indicators li.active img {
    opacity: 0.9;
}
#carousel-custom .carousel-indicators li:hover img {
    opacity: 0.9;
}
#carousel-custom .carousel-outer {
    position: relative;
}
.carousel-indicators li img {
  height: 66px;
  width: 52px;}
  
  .merge-bottom-input {
  width: 67px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.center {
  text-align: center;
}
.merge-top-left-button {
  border-top-left-radius: 0;
}

.merge-top-right-button {
  border-top-right-radius: 0;
}
  
.magnify {
    position: relative;
    cursor: none
}

.magnify-large {
    position: absolute;
    display: none;
    width: 175px;
    height: 175px;

    -webkit-box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
       -moz-box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
            box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 0 0 7px 7px rgba(0, 0, 0, 0.25), inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
     
    -webkit-border-radius: 100%;
       -moz-border-radius: 100%;
             border-radius: 100%
}

.btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
.icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}
</style>
<body style="background-color:;">
<jsp:include page="Header.jsp"/>
<div class="container-fluid" style="background-repeat:no-repeat;background-position:center center;background-size:cover;">
<div class="row">
<div class="col-sm-6">
<div id='carousel-custom' class='carousel slide' data-ride='carousel'>
<div class='carousel-outer'>
 
        <div class="carousel-inner" id="s">
        <div class="item active">
<img data-toggle="magnify" alt=""  src="${pageContext.request.contextPath}/resources/Productimage/${pr.img}" style="width:85%; height:375px;"/>
</div>
<div class="item">
<img data-toggle="magnify" alt=""   src="${pageContext.request.contextPath}/resources/Productimage/${pr.img1}"  style="width:85%; height:375px;"/>
</div>
<div class="item">
<img data-toggle="magnify" alt=""  src="${pageContext.request.contextPath}/resources/Productimage/${pr.img2}" style="width:85%; height:375px;" />
</div>
<div class="item">
<img data-toggle="magnify" alt=""  src="${pageContext.request.contextPath}/resources/Productimage/${pr.img3}" style="width:85%; height:375px;" />
</div>
            </div>
             <a class='left carousel-control' href='#carousel-custom' data-slide='prev'>
        </a>
        <a class='right carousel-control' href='#carousel-custom' data-slide='next'>        
        </a>
    </div>
    <ol class='carousel-indicators'>
        <li data-target='#carousel-custom' data-slide-to='0' class='active'><img src='${pageContext.request.contextPath}/resources/Productimage/${pr.img}' alt='' /></li>    
        <li data-target='#carousel-custom' data-slide-to='1' ><img src='${pageContext.request.contextPath}/resources/Productimage/${pr.img1}' alt='' /></li>
        <li data-target='#carousel-custom' data-slide-to='2' ><img src='${pageContext.request.contextPath}/resources/Productimage/${pr.img2}' alt='' /></li>
        <li data-target='#carousel-custom' data-slide-to='3' ><img src='${pageContext.request.contextPath}/resources/Productimage/${pr.img3}' alt='' /></li>
    
    </ol>
    </div></div>
 <div class="col-sm-6" >
                    </br>
                    </br>
                    <h4 style="color:black;">${pr.name}</h4> <br>
                     <c:if test="${pr.offer eq 1}">
                     <h2><small style="color:green;">Extra $${pr.price - pr.offerprice} discount</small></h2>     
                    <h2 style="margin-top:0px; color:black;" >Price:$${pr.offerprice} <small><strike> $${pr.price}</strike> <a style="color:green;">${pr.offerper}% off Hurry up!!!</a></small></h2> 
                    </c:if>
                     <c:if test="${pr.offer eq 0}">     
                    <h3 style="margin-top:0px; color:black;">Price: $${pr.price}</h3> 
                    </c:if>
                    <div class="row">
   
  </div><!-- end row -->
  <div>left ${pr.stock}</div>
                    <p style="margin-top:0px; color:black;"><h3>Description:</h3></a>${pr.shortDesc}</p>  </br></br>            
                        <c:if test="${pageContext.request.userPrincipal.name  != null}">
                        <c:if test="${pr.stock eq 0}">
                         <div class="btn-group cart">
						<a class="btn icon-btn btn-warning" style="cursor: not-allowed"  href=""><span class="glyphicon btn-glyphicon glyphicon-shopping-cart img-circle text-warning"></span>Add to cart</a>
					</div>
					<div class="btn-group buy">
						<a class="btn icon-btn btn-danger" style="cursor: not-allowed"  href=""><span class="glyphicon btn-glyphicon glyphicon-flash img-circle text-danger"></span>Buy now</a>
					</div>
                        </c:if></c:if>
                        <c:if test="${pageContext.request.userPrincipal.name  != null}">
                        <c:if test="${pr.stock ge 1}">
                        <div class="btn-group cart">
						<a class="btn icon-btn btn-warning" href="car?id=${pr.id}"><span class="glyphicon btn-glyphicon glyphicon-shopping-cart img-circle text-warning"></span>Add to cart</a>
					</div>
					<div class="btn-group buy">
						<a class="btn icon-btn btn-danger" href="buy?id=${pr.id}"><span class="glyphicon btn-glyphicon glyphicon-flash img-circle text-danger"></span>Buy now</a>
					</div>
					</c:if></c:if>
					<c:if test="${pageContext.request.userPrincipal.name  == null}">
					<div class="btn-group cart">
						<a class="btn icon-btn btn-success" href="in"><span class="glyphicon btn-glyphicon glyphicon-log-in img-circle text-success"></span>Please Sign in</a>
					</div></c:if>
					
                                                          
                </div>                              
        </div></div>
            <div class="row">
    	<div class="col-sm-12">
            <div class="panel with-nav-tabs panel-default">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1default" data-toggle="tab">Review</a></li>
                            <li><a href="#tab2default" data-toggle="tab">Feedback</a></li>
                          
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1default">
                        <c:forEach items="${review}" var="rev"  varStatus="loop">	
                   <table>
                    <tr>
           <td>${rev.custname}</td>
           <td>says</td>
            <td>${rev.review}</td>
            </tr>
            </table>
</c:forEach>  </div>
                        <div class="tab-pane fade" id="tab2default">
                        <form action="review?id=${pr.id}" method="post">
                <table >
<tr><td>Name</td><td><input type="text"  name="name"  style="width:100%" required></td></tr>
<tr><td>Feedback</td><td><textarea rows="4" cols="50" name="rev" style="width:100%; height:100px;" required></textarea></td></tr>
<tr><td></td><td><input id="submit" class="btn btn-success btn-md" name="submit" type="submit" value="SUBMIT" style="width:100%"></td></tr>
</table>
</form></div>
                    </div>
                </div>
            </div>
        </div>
       
            </div>
                <jsp:include page="Footer.jsp"/>
</body>
</html>