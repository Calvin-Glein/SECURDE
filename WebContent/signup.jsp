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

<title>Sign-Up</title>

<style>
</style>
</head>
<body>

	<div id="nav-placeholder"></div>

	<div class="ui container" style="width: 600px; padding-top: 30px;">
		<br> <br> <br>
		<h1 class="ui header headerc">Create an Account</h1>


		<div class="ui fitted divider"></div>


		<div class="ui segment">


			<form class="ui form">
				<div class="field">
					<label>Username</label> <input type="text" name="username"
						placeholder="Your nickname in this website">
				</div>
				<div class="ui form">
					<label>Name</label>
					<div class="inline fields">
						<div class="six wide field">

							<input type="text" placeholder="First Name">
						</div>
						<div class="five wide field">
							<input type="text" placeholder="Middle Name">
						</div>
						<div class="five wide field">
							<input type="text" placeholder="Last Name">
						</div>
					</div>
				</div>
				<div class="field">
					<label>Email</label> <input type="text" name="email"
						placeholder="username@domain.com">
				</div>

				<div class="field">
					<label>Password</label> <input type="text" name="password"
						placeholder="Must be alphanumeric">
				</div>
				<div class="field">
					<label>Re-type Password</label> <input type="text" name="re-type"
						placeholder="Re-type password">
				</div>
				<div class="field">
					<label>Student Number/Employee Number</label> <input type="text"
						name="number" placeholder="Refer to your ID">
				</div>
				<div class="field">
					<label>Birthday</label> <input type="text" name="number"
						placeholder="Refer to your ID">
				</div>
				<div class="ui form">
					<label>Secret Question</label>
					<div class="inline fields">
						<div class="ten wide field">
							<input type="text" placeholder="Question">
						</div>
						<div class="six wide field">
							<input type="text" placeholder="Answer">
						</div>

					</div>
				</div>
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" tabindex="0" class="hidden"> <label>I
							agree to the Terms and Conditions</label>
					</div>
				</div>
				<button class="ui button basic green fluid" type="submit">Register
					Account</button>
				<br>
				<div class="item">
					<a href="userAccountDetails.jsp" class="ui green button">[Debug] Go to
						profile</a>
				</div>
			</form>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br>


	</div>


	<div id="footer-placeholder"></div>

	<script>
		$.get("header.html", function(data) {
			$("#nav-placeholder").replaceWith(data);
		});
	</script>


</body>
</html>