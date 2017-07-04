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
				<form class="ui form" method="post" action="CreateAccountAdminServlet">
					<div class="field">
						<label>Username</label> <input type="text" id="username"
							name="username" placeholder="Your nickname in this website">
					</div>
					<div class="ui form">
						<label>Name</label>
						<div class="inline fields">
							<div class="six wide field">
								<input type="text" placeholder="First Name" id="firstname"
									name="firstname">
							</div>
							<div class="five wide field">
								<input type="text" placeholder="Middle Name" id="middlename"
									name="middlename">
							</div>
							<div class="five wide field">
								<input type="text" placeholder="Last Name" id="lastname"
									name="lastname">
							</div>
						</div>
					</div>
					<div class="field">
						<label>Email</label> <input type="text" id="email" name="email"
							placeholder="username@domain.com">
					</div>

					<div class="field">
						<label>Password</label> <input type="text" id="password"
							name="password" placeholder="Must be alphanumeric">
					</div>
					<div class="field">
						<label>Re-type Password</label> <input type="text" name="retype"
							placeholder="Re-type password">
					</div>
					<div class="field">
						<label>Student Number/Employee Number</label> <input type="text"
							id="numberID" name="numberID" placeholder="Refer to your ID">
					</div>
					<div class="field">
						<label>Birthday</label> <input type="text" name="birthdate"
							placeholder="Birth" id="birthdate">
					</div>
					<div class="ui form">
						<label>Secret Question</label>
						<div class="inline fields">
							<div class="ten wide field">
								<input type="text" placeholder="Question" name="sQuestion"
									id="sQuestion">
							</div>
							<div class="six wide field">
								<input type="text" placeholder="Answer" name="sAnswer"
									id="sAnswer">
							</div>

						</div>
					</div>
					<div class="field">
						<label>Type</label> <select class="ui search dropdown fluid"
							name="accountType">
							<option value="">You are a</option>
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

					<button class="ui button basic green fluid" type="submit">Register
						Account</button>

					<br>
					<div class="item">
						<a href="userAccountDetails.jsp" class="ui green button">[Debug]
							Go to profile</a>
					</div>


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