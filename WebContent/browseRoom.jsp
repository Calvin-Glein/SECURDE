<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="css/semantic/semantic.min.css">
<link rel="stylesheet" href="css/datatables.css">
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script src="css/semantic/semantic.min.js"></script>

<title>Meeting Room</title>

<style>
#container {
	background-color: #ffffff;
	position: relative;
	z-index: 1;
}

.pushFooter {
	height: 50vh;
}

.coverFixed {
	background-size: cover;
	background-attachment: fixed;
}

.headersection {
	height: 100vh;
}
</style>

</head>
<body>
	<div class="container" style="background-color: white;">
			<jsp:include page="header.jsp" />


		<br> <br> <br> <br>


		<!-- <div class="headersection coverFixed"
			style="background-image: url(images/book.jpg); background-position: 0 -120px;">

			<h1 class="ui header inverted centered"
				style="font-size: 3rem; padding-top: 140px;">Reserve</h1>
			<h1 class="ui header inverted centered" style="font-size: 7rem;">BOOK</h1>

		</div> -->
		<br> <br> <br>


		<div class="ui container">
			<h1 class="ui horizontal divider header">Meeting Rooms</h1>
			<br>
			<div class="ui container">
				<table id="example" class="ui definition selectable padded table"
					cellspacing="
					0" width="100%">
					<thead>
						<tr>
							<th>Room Name</th>
							<th>Room Location</th>
							<th>Room Available</th>
							<th>Time Occupied</th>
							<th>Time Out</th>
							<th>View</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${Rooms}">
							<tr>
								<td>${c.roomName}</td>
								<td>${c.roomLocation}</td>
								<td>${c.roomAvail}</td>
								<td>${c.timeOccupied}</td>
								<td>${c.timeOut}</td>
								<td><button class="ui button basic green" id="${c.materialID}">View</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


		<script>
			$('.card').hover(function() {
				$(this).transition('bounce');
			}, function() {
			});

			$('#mainmenu').visibility({
				once : false,
				onBottomPassed : function() {
					$('.fixed.menu').transition('fade in');
				},
				onBottomPassedReverse : function() {
					$('.fixed.menu').transition('fade out');
				}
			});

		

			$.get("footer.html", function(data) {
				$("#footer-placeholder").replaceWith(data);
			});

			$(document).ready(function() {
				$('#example').DataTable({
					"pagingType" : "full_numbers"
				});
			});
		</script>



		<br> <br> <br> <br>
	</div>


	<div id="footer-placeholder"></div>


</body>
</html>