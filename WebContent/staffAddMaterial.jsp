<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Profile</title>

<style>
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="ui container">
		<br> <br> <br> <br>
		<h1 class="ui header headerc">Create User</h1>
		<div class="ui fitted divider"></div>

		<br>

		<div class="ui grid">
			<div class="three wide column">
				<jsp:include page="sidebar.jsp" />
			</div>

			<div class="thirteen wide column">
				<form class="ui form" method="post" action="AddMaterialServlet">
					<div class="field">
						<label>Title</label> <input type="text" id="title" name="title"
							placeholder="What is the name of this material?">
					</div>

					<div class="field">
						<label>Type of Material</label> <select
							class="ui search dropdown fluid" name="materialType">
							<option value="Select">Select</option>
							<option value="book">Book</option>
							<option value="magazine">Magazine</option>
							<option value="thesis">Thesis</option>
						</select>
					</div>

					<div class="field">
						<label>Dewey Location</label> <input type="text" id="location"
							name="location" placeholder="Dewey location of material">
					</div>

					<div class="field">
						<label>Author</label> <input type="text" id="author" name="author"
							placeholder="Who wrote this material?">
					</div>

					<div class="field">
						<label>Publisher</label> <input type="text" id="publisher"
							name="publisher" placeholder="Who published this material?">
					</div>

					<div class="field">
						<label>Year</label> <input type="text" id="year" name="year"
							placeholder="In what year was this material published?">
					</div>

					<div class="field">
						<label>Tags</label> <input type="text" id="tags" name="tags"
							placeholder="May include one or more tags">
					</div>


					<button class="ui button basic green fluid" type="submit">Register
						Account</button>

					<br>
				</form>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>




</body>


</html>