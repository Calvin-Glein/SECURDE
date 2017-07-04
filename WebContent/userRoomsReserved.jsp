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
		<h1 class="ui header headerc">Profile</h1>
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
									<th>Title</th>
									<th>Location</th>
									<th>Author</th>
									<th>Publisher</th>
									<th>Year</th>
									<th>Tags</th>
									<th>Status</th>
									<th>Rating</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td><button class="ui red button fluid">Red</button></td>
								</tr>
								<tr>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td>None</td>
									<td><button class="ui red button fluid">Red</button></td>
								</tr>
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



</body>


</html>