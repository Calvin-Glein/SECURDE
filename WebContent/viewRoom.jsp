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



<!-- Include Required Prerequisites -->
<script type="text/javascript"
	src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
	src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />

<!-- Include Date Range Picker -->
<script type="text/javascript"
	src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

<title>Room details</title>

<style>
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="ui container">
		<br> <br> <br> <br>
		<h1 class="ui header headerc">Information</h1>
		<div class="ui fitted divider"></div>

		<br>

		<div class="ui grid">
			<div class="sixteen wide column">
				<h3 class="ui block header">
					<div class="ui grid">
						<div class="eight wide column">
							<div class="left aligned">Room Details</div>
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
									<%-- <div class="ui fluid large submit button green"
										onclick="location.href = '\accountdetails.jsp';">Borrow as </div>
									<%=session.getAttribute("Username")%> --%>
									<!-- 	<div class="ui fluid icon input">
										<input type="text" name="daterange" id="dateRangePicker"
											value="01/01/2015 - 01/31/2015" /> <i class="book icon"></i>
									</div>
 -->
									<c:if test="${sessionScope.Username != null}">
										<c:if test="${room.roomAvail == 1}">

											<form class="ui form" method="post"
												action="ReserveRoomServlet">
												<div class="ui action input fluid">
													<input type="text" name="daterange" id="dateRangePicker" value="01/01/2015 1:30 PM - 01/01/2015 2:00 PM" />
													<div id="borrow" class="ui green right button">Set</div>
												</div>
												<script type="text/javascript">
													$(function() {
													    $('input[name="daterange"]').daterangepicker({
													        timePicker: true,
													        timePickerIncrement: 30,
													        locale: {
													            format: 'MM/DD/YYYY h:mm A'
													        }
													    });
													});
												</script>	
												<br> <br>
												<h3 class="ui header">Verify Details</h3>
												<div class="ui fitted divider"></div>
												<br>

												<div class="ui action input fluid">
													<div class="ui labeled input">
														<div class="ui label">From:</div>
														<input type="text" id="fromString" name="fromString" />
													</div>
												</div>
												<br>
												<div class="ui action input fluid">
													<div class="ui labeled input">
														<div class="ui label">To:</div>
														<input type="text" id="toString" name="toString" />
													</div>
												</div>
												<br>


												<button class="ui button green fluid" type="submit">
												Reserve
												</button>


												<input type="text" name="roomId"
													value="${room.roomId}" />
											</form>
											
										</c:if>
									</c:if>


									<c:if test="${sessionScope.Username == null}">
										<div class="ui negative message">
											<i class="close icon"></i>
											<div class="header">User actions are restricted</div>
											<p>Please Login</p>
										</div>
									</c:if>

									<script>
										$("#borrow")
												.click(
														function() {
															document
																	.getElementById("fromString").value = $(
																	"#dateRangePicker")
																	.data(
																			'daterangepicker').startDate
																	.format('MM/DD/YYYY h:mm A');
															;
															document
																	.getElementById("toString").value = $(
																	"#dateRangePicker")
																	.data(
																			'daterangepicker').endDate
																	.format('MM/DD/YYYY h:mm A');
															;

														});
									</script>
								</div>
							</div>
						</div>
						<div class="ui twelve wide column">
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Room Name
										<div class="sub header">
											<c:out value="${room.roomName}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Availability
										<div class="sub header">
											<c:out value="${room.roomAvail}" />
										</div>
									</div>
								</h3>
							</div>
							<br>

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
</body>


</html>