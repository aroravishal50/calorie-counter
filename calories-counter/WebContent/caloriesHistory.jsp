<!--
 * File - caloriesHistory.jsp
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * -->
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
<!-- This file handles the display of the logged in user's total calorie count after they added items to their profile. -->
<body>
	<header class="masthead">
	<div class="container">
		<div class="intro-text">
		
			<% String totalCalories = (String)session.getAttribute("totalCalories"); %>
			<h1><%=resource.getString("addFriends.totalCalorie") %>
				<%=totalCalories %></h1>
		</div>
	</header>
</body>
</html>