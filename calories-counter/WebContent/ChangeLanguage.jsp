<!--
 * File - ChangeLanguage.jsp
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- This method checks if the user has changed the language of the application. It only triggers when the user presses the French/English button 
	to change property files. -->
<body>
	<%
		if (session.getAttribute("lang").equals("fr")) {
			session.setAttribute("lang", "en");
		} else if (session.getAttribute("lang").equals("en")) {
			session.setAttribute("lang", "fr");
		}
		response.sendRedirect("index.jsp");
	%>
</body>
</html>