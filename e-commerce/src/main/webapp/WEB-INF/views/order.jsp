<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div id="wrap">
	<div id="accordian">
		<div class="step" id="step1">
			<div class="number">
				<span>1</span>
			</div>
			<div class="title">
				<h1>Email Address</h1>
			</div>
			<div class="modify">
				<i class="fa fa-plus-circle"></i>
			</div>
		</div>
		<div class="content" id="email">
			<form class="go-right">
				<div>
        <input type="email" name="email" value="" id="email-address" placeholder="Email Address" data-trigger="change" data-validation-minlength="1" data-type="email" data-required="true" data-error-message="Enter a valid email address."/><label for="email">Email Address</label>
        </div>
				<button class="login">Login</button>
				<button class="create">Create Account</button>
			</form>
			<a class="continue" href="#">Continue</a>
		</div>
		<div class="step" id="step2">
			<div class="number">
				<span>2</span>
			</div>
			<div class="title">
				<h1>Shipping Address</h1>
			</div>
			<div class="modify">
				<i class="fa fa-plus-circle"></i>
			</div>
		</div>
		<div class="content" id="address">
			<form class="go-right">
				<div>
				<input type="name" name="first_name" value="" id="first_name" placeholder="John" data-trigger="change" data-validation-minlength="1" data-type="name" data-required="true" data-error-message="Enter Your First Name"/><label for="first_name">First Name</label>
        </div>
				<div>
				<label for="last_name">Last Name</label>
				<input type="name" name="last_name" value="" id="last_name" placeholder="Smith" data-trigger="change" data-validation-minlength="1" data-type="name" data-required="true" data-error-message="Enter Your Last Name"/><label for="last_name">Last Name</label>
				</div>
				<div>
				<input type="phone" name="telephone" value="" id="telephone" placeholder="(555)-867-5309" data-trigger="change" data-validation-minlength="1" data-type="number" data-required="true" data-error-message="Enter Your Telephone Number"/><label for="telephone">Telephone</label>
				</div>
				<div>
				<input type="text" name="company" value="" id="company" placeholder="Company" data-trigger="change" data-validation-minlength="1" data-type="name" data-required="false"/><label for="Company">Company</label>
				</div>
				<div>
				<input type="text" name="address" value="" id="address" placeholder="123 Main Street" data-trigger="change" data-validation-minlength="1" data-type="text" data-required="true" data-error-message="Enter Your Billing Address"/><label for="Address">Address</label>
				</div>
				<div>
				<input type="text" name="city" value="" id="city" placeholder="Everytown" data-trigger="change" data-validation-minlength="1" data-type="text" data-required="true" data-error-message="Enter Your Billing City"/><label for="city">City</label>
				</div>
				<div>
				<div class="state_options">
        			<div class="select">
                 		<select id="state">
                  	 		<option value = "1">Alabama</option>
                   			<option value = "2">Alaska</option>
                   			<option value = "3">Arkansas</option>
                   			<option value = "4">Etc.</option>
                 		</select>
                 	</div>
                  <label class="state" for="state">State</label>
          		</div>
				</div>
				<div>
				<input type="text" name="zip" value="" id="zip" placeholder="12345" data-trigger="change" data-validation-minlength="1" data-type="text" data-required="true" data-error-message="Enter Your Billing Zip Code"/><label for="zip">Zip Code</label>
				</div>
				<div>
				<div class="country_options">
				  <label class="country" for="country">Country</label>
        			<div class="select">
                 		<select id="country">
                  	 		<option value = "1">United States</option>
                   			<option value = "2">United Kingdom</option>
                   			<option value = "3">Uganda</option>
                   			<option value = "4">Etc.</option>
                 		</select>
                 	</div>
          		</div>
				</div>
			</form>
			<a class="continue" href="#">Continue</a>
		</div>
		
 		<div class="step" id="step5">
			<div class="number">
				<span>3</span>
			</div>
			<div class="title">
				<h1>Finalize Order</h1>
			</div>
			<div class="modify">
				<i class="fa fa-plus-circle"></i>
			</div>
		</div>
		<div class="content" id="final_products">
			<div class="left" id="ordered">
				<div class="products">
					<div class="product_image">
						<img src="https://i.imgur.com/YwqxBXc.jpg"/>
					</div>
					<div class="product_details">
						<span class="product_name">Cherry Bikini</span>
						<span class="quantity">1</span>
						<span class="price">$45.00</span>
					</div>
				</div>
				<div class="totals">
					<span class="subtitle">Subtotal <span id="sub_price">$45.00</span></span>
					<span class="subtitle">Tax <span id="sub_tax">$2.00</span></span>
					<span class="subtitle">Shipping <span id="sub_ship">$4.00</span></span>
				</div>
				<div class="final">
					<span class="title">Total <span id="calculated_total">$51.00</span></span>
				</div>
			</div>	
			<div class="right" id="reviewed">
				<div id="complete">
				<a class="big_button" id="complete" href="#">Complete Order</a>
				</div>


</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>