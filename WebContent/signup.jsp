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

	<jsp:include page="header.jsp" />

	<div class="ui container" style="width: 600px; padding-top: 30px;">
		<br> <br> <br>
		<h1 class="ui header headerc">Create an Account</h1>


		<div class="ui fitted divider"></div>


		<div class="ui segment">

			<form class="ui form" method="post" action="CreateAccountServlet">
				<div class="field">
					<label>Username</label> <input required type="text" id="username"
						name="username" placeholder="Your nickname in this website"
						maxlength="10">
				</div>
				<div class="ui form">
					<label>Name</label>
					<div class="inline fields">
						<div class="six wide field">
							<input required type="text" placeholder="First Name"
								id="firstname" name="firstname" maxlength="20">
						</div>
						<div class="five wide field">
							<input required type="text" placeholder="Middle Name"
								id="middlename" name="middlename" maxlength="20">
						</div>
						<div class="five wide field">
							<input required type="text" placeholder="Last Name" id="lastname"
								name="lastname" maxlength="20">
						</div>
					</div>
				</div>
				<div class="field">
					<label>Email</label> <input required type="text" id="email"
						name="email" placeholder="username@domain.com" maxlength="20">
				</div>

				<div class="field">
					<label>Password</label> <input required type="text" id="password"
						name="password"
						placeholder="Must be alphanumeric with at least one uppercase. Minimum length is 8 while maximum is 15."
						maxlength="15">
				</div>

				<script>
					$('#password').keyup(
							function() {
								var min = 8;
								var len = $(this).val().length;
								var upperCase = new RegExp('[A-Z]');
								var lowerCase = new RegExp('[a-z]');
								var numbers = new RegExp('[0-9]');

								if (len < min) {
									$("#CreateButton").prop("disabled", true);
								} else {
									if ($(this).val().match(upperCase)
											&& $(this).val().match(lowerCase)
											&& $(this).val().match(numbers)) {
										$("#CreateButton").prop("disabled",
												false);

									}

								}

							});
				</script>
				<div class="field">
					<label>Re-type Password</label> <input required type="text"
						name="retype" placeholder="Re-type password" maxlength="15">
				</div>
				<div class="field">
					<label>Student Number/Employee Number</label> <input required
						type="text" id="numberID" name="numberID"
						placeholder="Refer to your ID" maxlength="10" onkeypress="return isNumberKey(event)">
					<script>
					function isNumberKey(evt){
					    var charCode = (evt.which) ? evt.which : event.keyCode
					    if (charCode > 31 && (charCode < 48 || charCode > 57))
					        return false;
					    return true;
					}
					</script>
				</div>
				<div class="field">
					<label>Birthday</label> <input required type="text"
						name="birthdate" placeholder="Birth" id="birthdate" maxlength="10">
				</div>
				<div class="ui form">
					<label>Secret Question</label>
					<div class="inline fields">
						<div class="ten wide field">
							<input type="text" required placeholder="Question"
								name="sQuestion" id="sQuestion" maxlength="20">
						</div>
						<div class="six wide field">
							<input type="text" required placeholder="Answer" name="sAnswer"
								id="sAnswer" maxlength="20">
						</div>

					</div>
				</div>
				<div class="field">
					<label>Type</label> <select class="ui search dropdown fluid"
						name="accountType">
						<option value="1">Student</option>
						<option value="2">Library Staff</option>
						<option value="3">Library Manager</option>
						<option value="4">Administrator</option>
					</select>
				</div>
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" tabindex="0" class="hidden"> <label>I
							agree to the Terms and Conditions</label>
					</div>
				</div>

				<button disabled id="CreateButton"
					class="ui button basic green fluid" type="submit">Register
					Account</button>

				<br>
				<div class="item">
					<a href="userAccountDetails.jsp" class="ui green button">[Debug]
						Go to profile</a>
				</div>


			</form>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br>


	</div>


	<div id="footer-placeholder"></div>



</body>
</html>