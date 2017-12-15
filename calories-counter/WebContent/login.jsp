<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%@include file="header.jsp" %>
	 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	  	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
	<link rel="stylesheet" href="sign-up-form/css/style.css">
	</head>
	<body>
		<header class="masthead" >
	      <div class="container">
	        <div class="intro-text">
	           <div class="intro-lead-in"><%=resource.getString("login.header.login") %></div>
				<form action="LoginServlet" method="post" class="form-horizontal">
				    <div class="input-group input-group-icon">
				        <input type="text" placeholder="UserName" id="username" name="username" required = "required"/>
				        	<div class="input-icon"><i class="fa fa-user"></i></div>
      						</div>
			        		<div class="input-group input-group-icon">
        						<input type="password" placeholder="Password" id="pwd" name="userpass" required = "required"/>
       						<div class="input-icon"><i class="fa fa-key"></i></div>
     				</div>  
			        	<div class="row">
    						<div class="col-sm-offset-2 col-sm-4">       
		                    	<input type="submit" value="<%=resource.getString("login.button.login") %>" class="btn btn-default" />
		                    		<a href="registration.jsp"><%=resource.getString("login.link.register") %> </a>\
		                     			<a href="verifyEmail.jsp"> Verify Email</a>
			        		</div>
			        	
			  		</div>   
			        <%if (session.getAttribute("errorMessage") != null) {%>
			        	<div class="form-group">    
			        		<p style="color:red">	<%= session.getAttribute("errorMessage") %></p>  
		                </div>  
		                <%} %>
					</fieldset>
				</form>
			</div>	
		</div>		
	</body>
</html>