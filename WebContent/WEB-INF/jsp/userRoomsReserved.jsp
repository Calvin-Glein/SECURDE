<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
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

<script>
	$(document).ready(function() {
		$("button").click(function() {
			//get id of the clicked delete button
			var room_id = $(this).attr("id");

			//set value of hiddne inpiut to the id
			$("#hiddeninput").val(room_id);

			//submit form automatically
			$("form").submit();
		});
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="ui container">
		<br> <br> <br> <br>
		<h1 class="ui header headerc">Rooms</h1>
		<div class="ui fitted divider"></div>

		<br>

		<div class="ui grid">
			<div class="three wide column">
				<jsp:include page="sidebar.jsp" />
			</div>

			<div class="thirteen wide column">
				<h3 class="ui block header">
					<div class="ui grid">
						<div class="eight wide column">
							<div class="left aligned">Personal Information</div>
						</div>
					</div>
				</h3>
				<div class="ui segment">
					<div class="ui container">
						<table id="example" class="ui definition selectable padded table"
							cellspacing="
					0" width="100%">
							<thead>
								<tr>
									<th>Room Name</th>
									<th>Room Location</th>
									<th>View</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="c" items="${rooms}">
									<tr>
										<td>${c.roomName}</td>
										<td>${c.roomLocation}</td>
										<td><button class="ui button basic green"
												id="${c.roomId}">Return</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>

	<form action="ReturnRoomServlet" method="POST">
		<input id="hiddeninput" name="room_id" type="hidden">
	</form>


</body>


</html>