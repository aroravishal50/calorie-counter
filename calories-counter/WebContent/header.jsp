<!--
 * File - header.jsp
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%
ResourceBundle resource;
if (session.getAttribute("lang") != null){
	resource = ResourceBundle.getBundle("app", new Locale(session.getAttribute("lang").toString()));
} else {
	resource = ResourceBundle.getBundle("app");
	session.setAttribute("lang", "en");
}
String langToChangeTo;
if(session.getAttribute("lang").equals("en")){
	langToChangeTo = "FRANCAIS";
} else {
	langToChangeTo= "ENGLISH";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	
	<!-- Navbar section -->
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<link
	href="startbootstrap-agency-gh-pages/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="startbootstrap-agency-gh-pages/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>
<link href="startbootstrap-agency-gh-pages/css/agency.min.css"
	rel="stylesheet">
</head>
<!-- This method contains the header properties along with the navigation bar of our application. 
	The user is able to click on various links and it will redirect them to other part of our application. -->
<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="index.jsp">CalorieCounter</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="index.jsp#services"><%=resource.getString("header.services") %></a>
				</li>

				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="index.jsp#about"><%=resource.getString("header.about") %></a>
				</li>

				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="index.jsp#contact"><%=resource.getString("header.contact") %></a>
				</li>
				<%if(session.getAttribute("name") == null) {%>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="registration.jsp"><%=resource.getString("header.registration") %></a>
				</li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="login.jsp"><%=resource.getString("header.login") %></a></li>

				<%} else { %>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="Logout.jsp"><%=resource.getString("header.logout") %></a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="welcome.jsp"><%=resource.getString("header.welcome") %> <%=session.getAttribute("name") %></a>
				</li>
				<%} %>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="switchLang.jsp"><%=resource.getString("header.lang") %></a></li>
			</ul>
		</div>
	</div>
	</nav>
</body>
</html>