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

<title>Home</title>

<style>
#container {
	background-color: #ffffff;
	position: relative;
	z-index: 1;
}

.pushFooter {
	height: 50vh;
}
</style>




</head>
<body>
	<div class="container" style="background-color: white;">
	<jsp:include page="header.jsp" />

		<br> <br> <br> <br> <br> <br>

		<div class="ui container">
			<br>

			<div class="ui fluid image">
				<img src="images/experience.png">
			</div>
			<br> <br> <br> <br>


			<h1 class="ui horizontal divider header">Reserve</h1>
			<br>
			<div class="ui four cards">
				<div class="ui card">
					<div class="image">
						<img src="images/filler.PNG">
					</div>
					<div class="content">
						<a class="header">Book</a>
						<div class="description">Probability of getting heads</div>
						<br>
						<button class="ui green fluid button">Browse</button>

					</div>
				</div>
				<div class="ui card">
					<div class="image">
						<img src="images/filler.PNG">
					</div>
					<div class="content">
						<a class="header">Magazine</a>
						<div class="description">Probability of getting heads</div>
						<br>
						<button class="ui green fluid button">Browse</button>

					</div>
				</div>
				<div class="ui card">
					<div class="image">
						<img src="images/filler.PNG">
					</div>
					<div class="content">
						<a class="header">Thesis</a>
						<div class="description">Probability of getting heads</div>
						<br>
						<button class="ui green fluid button">Browse</button>

					</div>
				</div>
				<div class="ui card">
					<div class="image">
						<img src="images/filler.PNG">
					</div>
					<div class="content">
						<a class="header">Meeting Room</a>
						<div class="description">Probability of getting heads</div>
						<br>
						<button class="ui green fluid button">Browse</button>

					</div>
				</div>
			</div>


			<br> <br> <br>

			<!-- <h1 class="ui horizontal divider header">Toss coin</h1>
			<br>
			<div class="ui grid">
				<div class="ui eight wide column ">
					<div class="ui fluid image">
						<img src="images/filler.PNG">
					</div>
				</div>
				<div class="ui eight wide column">
					<div class="ui content justify">Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations. Get probability of getting a
						head or a tail based on simulations.</div>
					<br> <br>
					<button class="ui blue fluid button">Add Friend</button>
				</div>
			</div> -->


		</div>

		<script>
			$('.card').hover(function() {
				$(this).transition('bounce');
			}, function() {
			});

			/* $('#mainmenu').visibility({
				once : false,
				onBottomPassed : function() {
					$('.fixed.menu').transition('fade in');
				},
				onBottomPassedReverse : function() {
					$('.fixed.menu').transition('fade out');
				}
			}); */


			$.get("footer.html", function(data) {
				$("#footer-placeholder").replaceWith(data);
			});
		</script>



		<br>
		<br>
		<br>
		<br>
	</div>


	<div id="footer-placeholder"></div>


</body>
</html>