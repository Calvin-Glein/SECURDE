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
	<div id="nav-placeholder"></div>
	<div class="ui container">
		<br> <br> <br> <br>
		<h1 class="ui header headerc">Profile</h1>
		<div class="ui fitted divider"></div>

		<br>

		<div class="ui grid">
			<div class="three wide column">
				<div class="ui small vertical steps">
					<div class="step active"
						onclick="location.href = 'userAccountDetails.jsp'">
						<i class="user icon"></i>
						<div class="content">
							<div class="title">Profile</div>
							<div class="description">Account Information</div>
						</div>
					</div>
					<div class="step"
						onclick="location.href = 'userMaterialsBorrowed.jsp'">
						<i class="small book icon"></i>
						<div class="content">
							<div class="title">Materials</div>
							<div class="description">View your borrowed materials</div>
						</div>
					</div>
					<div class="step"
						onclick="location.href = 'userAccountDetails.jsp'">
						<i class="university icon"></i>
						<div class="content">
							<div class="title">Room Reservations</div>
							<div class="description">View your room reservations</div>
						</div>
					</div>
				</div>
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
					<div class="ui grid">
						<div class="ui four wide column">
							<div class="ui card">
								<div class="image">
									<img src="images/filler.PNG">
								</div>
								<div class="content">
									Username
									<div class="sub header">Pogi</div>
								</div>
							</div>
						</div>
						<div class="ui twelve wide column">
							<div class="ui grid">
								<div class="ui six wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Firstname
												<div class="sub header">Glenn</div>
											</div>
										</h3>
									</div>
								</div>
								<div class="ui five wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Middlename
												<div class="sub header">Montes</div>
											</div>
										</h3>
									</div>
								</div>
								<div class="ui five wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Lastname
												<div class="sub header">Matias</div>
											</div>
										</h3>
									</div>
								</div>
							</div>

							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Email
										<div class="sub header">glenn_matias@dlsu.edu.ph</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Student/Employee Number
										<div class="sub header">11312345</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Birthday
										<div class="sub header">(02) XXX-XXXX</div>
									</div>
								</h3>
							</div>
							<div class="ui grid">
								<div class="ui eight wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Secret Question
												<div class="sub header">What is the name of my first
													pet?</div>
											</div>
										</h3>
									</div>
								</div>
								<div class="ui eight wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Answer
												<div class="sub header">Somerandomdogname</div>
											</div>
										</h3>
									</div>
								</div>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Password
										<div class="sub header">*********</div>
										<div class="sub header">change</div>

									</div>
								</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>

	<script>
		$.get("header.html", function(data) {
			$("#nav-placeholder").replaceWith(data);
		});
	</script>


</body>


</html>