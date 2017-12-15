<!--
 * File - foodItems.jsp
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
<link rel="stylesheet" href="lookAndFeel/foodItems.css">
</head>
<!-- This file is responsible for retrieving and displaying all the food items in our database to the front end. -->
<body>
	<header class="masthead">
	<div class="container">
		<div class="intro-text">

			<%
				String foods = (String) session.getAttribute("food");
				String items[] = foods.split("x01");
			%>
			<form action="foodServlet" method="post" class="form-horizontal"
				novalidate>
				<div class="scroll" id="style-14">
					<table class="table table-fixed"0>
						<%
							for (int i = 0; i < items.length; i++) {
						%>
						<tr>
							<!-- <div class="row"> -->
							<th><input type="checkbox" name="food<%=i%>"
								value="<%out.println(items[i]);%>"
								id="<%out.println(items[i]);%>" required="required" /> <label
								for="<%out.println(items[i]);%>"><font color="#fed136">
										<%
											out.println(items[i]);
										%>
								</font></label></th>
						</tr>
						<%
							}
						%>
					</table>
				</div>
				<input type="submit" value="Submit" class="btn btn-default" />
			</form>
		</div>
	</div>
	</header>
</body>
</html>