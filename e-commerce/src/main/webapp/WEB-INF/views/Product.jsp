<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
#s{
	text-align: center;
}

.carousel-inner, .carousel-inner img {
  position: relative;
  margin-left: 35px;
   margin-top: 1px;
  width: 70%;
  min-height: 100px;
  }
#carousel-custom {
    margin: 40px auto;
    width: 380px;
}
#carousel-custom .carousel-indicators {
    margin: 90px;
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
    border:1px solid black;
    opacity: 0.5;
}
#carousel-custom .carousel-indicators li.active img {
    opacity: 1;
}
#carousel-custom .carousel-indicators li:hover img {
    opacity: 0.75;
}
#carousel-custom .carousel-outer {
    position: relative;
}
.carousel-indicators li img {
  height: 59px;
  width: 38px;}
  
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
<img data-toggle="magnify" alt=""  src="resources/Productimage/${pr.img}"/>
</div>
<div class="item">
<img data-toggle="magnify" alt=""   src="resources/Productimage/${pr.img1}" />
</div>
<div class="item">
<img data-toggle="magnify" alt=""  src="resources/Productimage/${pr.img2}" />
</div>
<div class="item">
<img data-toggle="magnify" alt=""  src="resources/Productimage/${pr.img3}" />
</div>
            </div>
             <a class='left carousel-control' href='#carousel-custom' data-slide='prev'>
        </a>
        <a class='right carousel-control' href='#carousel-custom' data-slide='next'>        
        </a>
    </div>
    <ol class='carousel-indicators'>
        <li data-target='#carousel-custom' data-slide-to='0' class='active'><img src='resources/Productimage/${pr.img}' alt='' /></li>    
        <li data-target='#carousel-custom' data-slide-to='1' ><img src='resources/Productimage/${pr.img1}' alt='' /></li>
        <li data-target='#carousel-custom' data-slide-to='2' ><img src='resources/Productimage/${pr.img2}' alt='' /></li>
        <li data-target='#carousel-custom' data-slide-to='3' ><img src='resources/Productimage/${pr.img3}' alt='' /></li>
    
    </ol>
    </div></div>
 <div class="col-sm-6" >
                    <!-- product description-->
                    <h3>${pr.name}</h3>         
                    <h6><small>PRICE</small></h6>
                    <h3 style="margin-top:0px;">US$ ${pr.price}</h3> 
                    <p style="margin-top:0px;"><h3>Description:</h3></a>${pr.shortDesc}</p>              
                        <div class="btn-group cart">
						<a class="btn icon-btn btn-warning" href="#"><span class="glyphicon btn-glyphicon glyphicon-shopping-cart img-circle text-warning"></span>Add to cart</a>
					</div>
					<div class="btn-group buy">
						<a class="btn icon-btn btn-danger" href="#"><span class="glyphicon btn-glyphicon glyphicon-flash img-circle text-danger"></span>Buy now</a>
					</div>
                                                          
                </div>                              
        </div></div>
                <jsp:include page="Footer.jsp"/>
</body>
</html>