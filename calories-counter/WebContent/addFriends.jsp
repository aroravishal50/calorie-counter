<!--
 * File - addFriends.jsp
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
<!-- This file handles the feature to add friends into database with various checks to get the proper output.
	If the user has no friends, the list will display that he has no friends that shared information with him after 
	they wish to share information with a user.  -->
<body>
	<header class="masthead">
	<div class="container">
		<div class="intro-text">
			<% String usernameFriend = (String)session.getAttribute("usernameFriend"); %>

			<%
if(usernameFriend == null || usernameFriend.equals(null)){
	usernameFriend = "";
	%><form action="searchAddFriend" method="post">
				<%= resource.getString("addFriends.search") %>
				<input type="search"
					placeholder="<%= resource.getString("addFriends.enterUser") %>"
					name="friendSearch"> <input type="submit"
					value="<%= resource.getString("addFriends.searchButton") %>">
			</form>
		</div>
		<%}
else{%>

		<form action="addFriends" method="post" class="form-horizontal"
			novalidate>

			<div class="row">
				<input type="hidden" name="<%=usernameFriend %>"
					value="<%=usernameFriend %>" /> <label for="<%=usernameFriend %>"><%=usernameFriend %></label>

			</div>

			<input type="submit" value="Add Friend" class="btn btn-default" />

		</form>
	</div>
	<% usernameFriend = null;}%>
	</div>
	</header>
</body>
</html>