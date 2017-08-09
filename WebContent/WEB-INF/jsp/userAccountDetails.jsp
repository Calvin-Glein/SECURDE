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

	<!-- for checking user rights -->

	<c:if test="${sessionScope.Username == null}">
		<c:redirect url="noPrivilege.jsp" />
	</c:if>



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
					<div class="ui grid">
						<div class="ui four wide column">
							<div class="ui card">
								<div class="image">
									<img src="images/filler.PNG">
								</div>
								<div class="content">
									Username
									<div class="sub header">
										<c:out value="${account.username}" />
									</div>
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
												<div class="sub header">
													<c:out value="${account.firstname}" />
												</div>
											</div>
										</h3>
									</div>
								</div>
								<div class="ui five wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Middlename
												<div class="sub header">
													<c:out value="${account.middlename}" />
												</div>
											</div>
										</h3>
									</div>
								</div>
								<div class="ui five wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Lastname
												<div class="sub header">
													<c:out value="${account.lastname}" />
												</div>
											</div>
										</h3>
									</div>
								</div>
							</div>

							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Email
										<div class="sub header">
											<c:out value="${account.email}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Student/Employee Number
										<div class="sub header">
											<c:out value="${account.idNumber}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Birthday
										<div class="sub header">
											<c:out value="${account.birthdate}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui grid">
								<div class="ui eight wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Secret Question
												<div class="sub header">
													<c:out value="${account.sQuestion}" />
												</div>
											</div>
										</h3>
									</div>
								</div>
								<div class="ui eight wide column">
									<div class="ui segment">
										<h3 class="ui header left aligned">
											<div class="content">
												Answer
												<div class="sub header">
													<c:out value="${account.sAnswer}" />
												</div>
											</div>
										</h3>
									</div>
								</div>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Password
										<%-- <div class="sub header">
											<c:out value="${account.password}" />
										</div> --%>
										<div class="sub header" onclick="changePasswordModal();">change</div>


									</div>
								</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="ui modal">
		<i class="close icon"></i>
		<div class="header">Change Password</div>
		<form class="ui large form" method="post"
			action="ChangePasswordServlet">
			<div class="ui stacked segment">
				<div class="field">
					<div class="ui left icon input">
						<i class="lock icon"></i> <input type="password" name="password"
							placeholder="Old Password">
					</div>
				</div>
				<div class="field">
					<div class="ui left icon input">
						<i class="lock icon"></i> <input type="password"
							id ="newPassword" name="newpassword" placeholder="New Password">
					</div>
				</div>
				<script>
					$('#newPassword').keyup(
							function() {
								var min = 8;
								var len = $(this).val().length;
								var upperCase = new RegExp('[A-Z]');
								var lowerCase = new RegExp('[a-z]');
								var numbers = new RegExp('[0-9]');

								if (len < min) {
									$("#ChangeButton").prop("disabled", true);
								} else {
									if ($(this).val().match(upperCase)
											&& $(this).val().match(lowerCase)
											&& $(this).val().match(numbers)) {
										$("#ChangeButton").prop("disabled",
												false);

									}

								}

							});
				</script>
				<button id = "ChangeButton" disabled class="ui fluid large basic submit button green"
					type="submit">Change</button>
			</div>

			<div class="ui error message"></div>

		</form>
	</div>
	<script>
		function changePasswordModal() {
			$('.ui.modal').modal('show');
		}
	</script>

	<br>
	<br>
	<br>
	<br>




</body>


</html>