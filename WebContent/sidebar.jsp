<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="ui small vertical steps">
	<div class="step" onclick="location.href = 'ViewProfileServlet'">
		<i class="user icon"></i>
		<div class="content">
			<div class="title">Profile</div>
			<div class="description">Account Information</div>
		</div>
	</div>
	<div class="step" onclick="location.href = 'ViewBorrowedServlet'">
		<i class="small book icon"></i>
		<div class="content">
			<div class="title">Materials</div>
			<div class="description">View your borrowed materials</div>
		</div>
	</div>
	<div class="step" onclick="location.href = 'userAccountDetails.jsp'">
		<i class="university icon"></i>
		<div class="content">
			<div class="title">Room Reservations</div>
			<div class="description">View your room reservations</div>
		</div>
	</div>
</div>


<c:if test="${sessionScope.accountType == 4}">
	<div class="ui small vertical steps">
		<div class="step"
			onclick="location.href = 'administratorCreateAccount.jsp'">
			<i class="user icon"></i>
			<div class="content">
				<div class="title">Create Account</div>
				<div class="description">Create any account</div>
			</div>
		</div>
	</div>
</c:if>

<c:if
	test="${sessionScope.accountType == 2 || sessionScope.accountType == 3}">
	<div class="ui small vertical steps">
		<div class="step" onclick="location.href = 'staffAddMaterial.jsp'">
			<i class="user icon"></i>
			<div class="content">
				<div class="title">Add Material</div>
				<div class="description">Add Material to the library</div>
			</div>
		</div>
		<div class="step" onclick="location.href = 'ViewAllMaterialsServlet'">
			<i class="user icon"></i>
			<div class="content">
				<div class="title">Manage Material</div>
				<div class="description">Manage Material in the library</div>
			</div>
		</div>
		<div class="step" onclick="location.href = 'ViewAllRoomsServlet'">
			<i class="user icon"></i>
			<div class="content">
				<div class="title">Room Availability</div>
				<div class="description">Manage Room Availability in the library</div>
			</div>
		</div>
	</div>
</c:if>