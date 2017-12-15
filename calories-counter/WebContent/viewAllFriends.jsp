<!--  
 * File - viewAllFriends.jsp
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend List</title>
</head>
<head>

<%@include file="header.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="sign-up-form/css/style.css">
<link rel="stylesheet" href="lookAndFeel/viewAllFriend.css">
</head>

<!-- viewAllFriends.jsp is a web page which allows a user to view the consumption of foods by friends  
who shared their profile.  -->

<body>
	<header class="masthead">
	<div class="container">
		<div class="intro-text">

			<%
				session.setAttribute("usernameFriend", null);
				String friendsFirstName = (String) session.getAttribute("friendsFirstName");
				String friendsLastName = (String) session.getAttribute("friendsLastName");
				String friendsEntryDate = (String) session.getAttribute("friendsEntryDate");
				String friendsFoodItems = (String) session.getAttribute("friendsFoodItems");
				String friendsTotalCalories = (String) session.getAttribute("friendsTotalCalories");
				String friendsFirstNameArr[] = friendsFirstName.split("x02");
				String friendsLastNameArr[] = friendsLastName.split("x02");
				String friendsFoodItemsArr[] = friendsFoodItems.split("x02");
				String friendsTotalCaloriesArr[] = friendsTotalCalories.split("x02");
			%>
			<div class="scroll" id="style-14">
				<table class="table table-fixed"0>
					<%
						if (friendsFirstNameArr[0].equals("")) {
					%>
					<tr>No Friends To Display
					</tr>
					<%
						}

						for (int i = 0; i < friendsFirstNameArr.length; i++) {
					%>
					<tr>
						<td><%=friendsFirstNameArr[i]%></td>
						<td><%=friendsLastNameArr[i]%></td>
						<td><%=friendsFoodItemsArr[i]%></td>
						<td><%=friendsTotalCaloriesArr[i]%></td>
					</tr>

					<%
						}
					%>

				</table>
			</div>
		</div>
	</header>
</body>
</html>