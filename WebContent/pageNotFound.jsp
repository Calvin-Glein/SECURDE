<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="css/semantic/semantic.min.css">
<script src="css/semantic/semantic.min.js"></script>

<title>Sorry, that page does not exist</title>

<style>
#container {
	background-color: #ffffff;
	position: relative;
	z-index: 1;
}

.pushFooter {
	height: 50vh;
}
</style>




</head>
<body>
	<div class="container" style="background-color: white;">
		<jsp:include page="header.jsp" />

		<br> <br> <br> <br> <br> <br>
		<br>
		<br>
		<h2 class="ui center aligned icon header">
			<i class="warning sign icon"></i> 404 Page not found
			<div class="sub header">The file you are trying to access does not exist</div>
		</h2>

	</div>


	<div id="footer-placeholder"></div>


</body>
</html>