
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="background-color: black">
	<div class="ui large secondary  pointing menu fixed inverted"
		style="background-color: green">
		<div class="ui container">
			<a href="home.jsp" class="item">Home</a> <a href="GetBooksServlet"
				class="item">Books</a> <a href="GetMagazinesServlet" class="item">Magazines</a>
			<a href="GetThesesServlet" class="item">Theses</a> <a
				href="GetThesesServlet" class="item">Rooms</a>


			<div class="right menu" style="margin: 10px;">

				<c:if test="${sessionScope.Username == null}">
					<div class="item">
						<a href="login.jsp" class="ui inverted green button"> Log In </a>
					</div>
					<div class="item">
						<a href="signup.jsp" class="ui green button">Sign Up</a>
					</div>
				</c:if>
				<c:if test="${sessionScope.Username != null}">
					<div class="item">
						<%-- <c:out
								value="${account.username}" />
						</a> --%>
						<%=session.getAttribute("Username")%>
						&nbsp;

						<div class="ui dropdown" id ="dropdownAccount">
							<div class="text">
								<img class="ui avatar image" src="images/avatar.jpg">
							</div>
							<i class="dropdown icon"></i>
							<div class="menu">
								<div class="item"
									onclick="document.location.href='ViewProfileServlet';">
									<span class="description"></span> Profile
								</div>
								<div class="item" onclick="document.location.href='ViewBorrowedServlet';">
									<span class="description"></span> Materials
								</div>
								<div class="item">
									<span class="description"></span> Rooms
								</div>
								<div class="divider"></div>
								<div class="item">
									<a href="LogoutServlet" class="ui red button fluid">Logout</a>
								</div>

							</div>
						</div>
					</div>
					<div class="item"></div>
				</c:if>

			</div>
		</div>
	</div>
</div>

<script>
	$('#dropdownAccount').dropdown();
</script>