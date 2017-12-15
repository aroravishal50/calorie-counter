<!--  
 * File - verifyEmail.jsp
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="sign-up-form/css/style.css">
</head>

<!-- verifyEmail.jsp allows the client to very their email after registering. I consist of two input fields: Verification code 
and email. If those two fields are successful the user is now able to login into their profile
 -->
 
<body>
	<header class="masthead">
	<div class="container">
		<div class="intro-text">
			<div class="intro-lead-in">Verify</div>

			<form action="VerifyServlet" method="post" class="form-horizontal">
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Verification Code:"
						id="verification_code" name="verification_code"
						required="required" />
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Email id" id="email" name="email"
						required="email" />
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-offset-2 col-sm-4">
						<input type="submit" value="Submit" class="btn btn-default"
							onclick="login.jsp" />

					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>