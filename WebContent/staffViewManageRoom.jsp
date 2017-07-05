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


<script>
	$(document).ready(function() {
		$("button").click(function() {
			//get id of the clicked delete button
			var reserve_id = $(this).attr("id");

			//set value of hiddne inpiut to the id
			$("#hiddeninput").val(reserve_id);

			//submit form automatically
			$("form").submit();
		});
	});
</script>
<title>Remaining Time Slots</title>

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
				<div class="ui container">
					<table id="example" class="ui definition selectable padded table"
						cellspacing="
					0" width="100%">
						<thead>
							<tr>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Availability</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="a" items="${reservations}">
								<tr>
									<td>${a.fromTime}</td>
									<td>${a.toTime}</td>
									<td><button class="ui button basic green"
											id="${a.reserveId}" type = "submit">FREE</button></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>



	<form action="FreeTimeSlotsServlet" method="POST">
		<input id="hiddeninput" name="reserve_id" type="hidden">
	</form>

</body>


</html>