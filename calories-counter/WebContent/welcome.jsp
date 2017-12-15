<!--  
 * File - welcome.jsp
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
<link rel="stylesheet" href="sign-up-form/css/welcome.css">
</head>

<!-- Welcome.jsp is considered to be the main menu of the program after logging in. 
Through this page a user will be presented with a map displaying near by gyms and also menu buttons in order
 to navigate to different pages in the application. -->

<body onload="getLocation()">
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPs2SgMnYzGXD_jiI7ojNj2m6H7TGHmjo&libraries=places&callback=getLocation"
		async defer></script>
	<header class="masthead">

	<div class="container">
		<div class="intro-text">
			<div class="intro-lead-in">
				<%=resource.getString("welcome.label.welcomeText")%>
				<%=session.getAttribute("name")%></div>
			<div id="map" align="center"
				style="width: 600px; height: 400px; color: black;"></div>

			<form class="Button" name="Menu" action="Menu" method="get">
				<input class="button" type="button"
					value="<%=resource.getString("welcome.label.addCalories")%>"
					name="Add calories" onclick="openPage('foodServlet')" /> <input
					class="button1" type="button"
					value="<%=resource.getString("welcome.label.addFriends")%>"
					name="Add Friends" onclick="openPage('addFriends.jsp')" /> <input
					class="button2" type="button"
					value="<%=resource.getString("welcome.label.viewCalories")%>"
					name="Add Daily calories" onclick="openPage('caloriesHistory.jsp')" />

				<input class="button3" type="button"
					value="<%=resource.getString("welcome.label.viewFriends")%>"
					name="View Friends" onclick="openPage('displayAllFriends')" />
			</form>
		</div>
	</div>
	</header>

	<script type="text/javascript">
		var x, y;
		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition);
			} else {
			}
		}

		function showPosition(position) {
			x = position.coords.latitude;
			y = position.coords.longitude;
			initMap(x, y);
		}

		var map;
		var infowindow;

		function initMap(x, y) {
			var pyrmont = {
				lat : x,
				lng : y
			};

			map = new google.maps.Map(document.getElementById('map'), {
				center : pyrmont,
				zoom : 15
			});

			infowindow = new google.maps.InfoWindow();
			var service = new google.maps.places.PlacesService(map);
			service.nearbySearch({
				location : pyrmont,
				radius : 5000,
				type : [ 'gym' ]
			}, callback);
		}

		function callback(results, status) {
			if (status === google.maps.places.PlacesServiceStatus.OK) {
				for (var i = 0; i < results.length; i++) {
					createMarker(results[i]);
				}
			}
		}

		function createMarker(place) {
			var placeLoc = place.geometry.location;
			var marker = new google.maps.Marker({
				map : map,
				position : place.geometry.location
			});

			google.maps.event.addListener(marker, 'click', function() {
				infowindow.setContent(place.name);
				infowindow.open(map, this);
			});
		}

		function openPage(pageURL) {
			window.location.href = pageURL;
		}
	</script>
</body>
</html>