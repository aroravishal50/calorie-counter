<!--  
 * File - Registration.jsp
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
<!--  
Registration.jsp consist of the login page in order for a user to sign up accepting input from various forms 
in order create their own profile. 
 -->
<body>
	<header class="masthead">
	<div class="container">
		<div class="intro-text">
			<div class="intro-lead-in">Registration</div>
			<form action="Registerservlet" method="post">
				<div class="row">
					<h4><%=resource.getString("registration.account")%></h4>
					<div class="input-group input-group-icon">
						<input type="text"
							placeholder="<%=resource.getString("registration.firstName")%>"
							id="fName" name="firstname" required="required" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<input type="text"
							placeholder="<%=resource.getString("registration.lastName")%>"
							id="lName" name="lastname" required="required" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<input type="text"
							placeholder="<%=resource.getString("registration.username")%>"
							id="username" name="username" required="required" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<input type="email"
							placeholder="<%=resource.getString("registration.email")%>"
							id="email" name="email" required="required" />
						<div class="input-icon">
							<i class="fa fa-envelope"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<input type="password"
							placeholder="<%=resource.getString("registration.password")%>"
							id="pwd" name="userpass" required="required" />
						<div class="input-icon">
							<i class="fa fa-key"></i>
						</div>
					</div>

					<div class="input-group input-group-icon">
						<input type="number"
							placeholder="<%=resource.getString("registration.age")%>"
							id="age" name="age" required="required" />
						<div class="input-icon">
							<i class="fa fa-key"></i>
						</div>
					</div>

					<div class="input-group input-group-icon">
						<input type="radio" name="gender"
							value="<%=resource.getString("registration.male")%>"
							id="gender-male" required="required" /> <label for="gender-male">Male</label>
						<input type="radio" name="gender"
							value="<%=resource.getString("registration.female")%>"
							id="gender-female" required="required" /> <label
							for="gender-female">Female</label>
						<div class="input-icon">
							<i class="fa fa-key"></i>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-2 col-sm-4">
						<input type="submit"
							value="<%=resource.getString("registration.submit")%>"
							class="btn btn-default" onclick="login.jsp" />

					</div>
				</div>
			</form>
		</div>
	</div>
	</header>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/index.js"></script>
</body>
</html>
