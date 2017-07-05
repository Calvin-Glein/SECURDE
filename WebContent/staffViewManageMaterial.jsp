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
										<c:if test="${material.status == 1}">

											<form class="ui form" method="post"
												action="BorrowMaterialServlet">
												<div class="ui action input fluid">
													<input type="text" name="daterange" id="dateRangePicker"
														value="01/01/2015 - 01/31/2015" />
													<div id="borrow" class="ui green right button">Set</div>
												</div>
												<script type="text/javascript">
													$(function() {
														$(
																'input[name="daterange"]')
																.daterangepicker();
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
													<i class="book icon"></i> Borrow
												</button>


												Account ID: <input type="text" name="materialID"
													value="${material.materialID}" />
											</form>

											<form class="ui form" method="post"
												action="DeleteMaterialServlet">


												Account ID: <input type="text" name="materialID"
													value="${material.materialID}" />
													
												<button class="ui button red fluid" type="submit">
													<i class="book icon"></i> Delete
												</button>

											</form>


										</c:if>

										<c:if test="${material.status == 0}">
											<form class="ui form" method="post"
												action="StaffReturnMaterialServlet">
												Material ID: <input type="text" name="material_id"
													value="${material.materialID}" />
												<button class="ui button green fluid" type="submit">
													<i class="book icon"></i> Return
												</button>
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
																	.format('DD/MM/YYYY');
															;
															document
																	.getElementById("toString").value = $(
																	"#dateRangePicker")
																	.data(
																			'daterangepicker').endDate
																	.format('DD/MM/YYYY');
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
										Title
										<div class="sub header">
											<c:out value="${material.title}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Author
										<div class="sub header">
											<c:out value="${material.author}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Year
										<div class="sub header">
											<c:out value="${material.year}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Location
										<div class="sub header">
											<c:out value="${material.location}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Publisher
										<div class="sub header">
											<c:out value="${material.publisher}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Status
										<div class="sub header">
											<c:out value="${material.status}" />
										</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Rating
										<div class="sub header">
											<c:out value="${material.rating}" />
										</div>
									</div>
								</h3>
							</div>
							<br>
							<div class="ui comments">
								<h3 class="ui dividing header">Comments</h3>
								<div class="comment">
									<a class="avatar"> <img src="images/filler.PNG">

										<div class="content">
											<a class="author">Matt</a>
											<div class="metadata">
												<span class="date">Today at 5:42PM</span>
											</div>
											<div class="text">How artistic!</div>
											<div class="actions">
												<a class="reply">Reply</a>
											</div>
										</div>
								</div>
								<div class="comment">
									<a class="avatar"> <img src="images/filler.PNG">

									</a>
									<div class="content">
										<a class="author">Elliot Fu</a>
										<div class="metadata">
											<span class="date">Yesterday at 12:30AM</span>
										</div>
										<div class="text">
											<p>This has been very useful for my research. Thanks as
												well!</p>
										</div>
										<div class="actions">
											<a class="reply">Reply</a>
										</div>
									</div>
									<div class="comments">
										<div class="comment">
											<a class="avatar"> <img src="images/filler.PNG">

											</a>
											<div class="content">
												<a class="author">Jenny Hess</a>
												<div class="metadata">
													<span class="date">Just now</span>
												</div>
												<div class="text">Elliot you are always so right :)</div>
												<div class="actions">
													<a class="reply">Reply</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="comment">
									<a class="avatar"> <img src="images/filler.PNG">

										<div class="content">
											<a class="author">Joe Henderson</a>
											<div class="metadata">
												<span class="date">5 days ago</span>
											</div>
											<div class="text">Dude, this is awesome. Thanks so much</div>
											<div class="actions">
												<a class="reply">Reply</a>
											</div>
										</div>
								</div>
								<form class="ui reply form">
									<div class="field">
										<textarea></textarea>
									</div>
									<div class="ui blue labeled submit icon button">
										<i class="icon edit"></i> Add Reply
									</div>
								</form>
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




</body>


</html>