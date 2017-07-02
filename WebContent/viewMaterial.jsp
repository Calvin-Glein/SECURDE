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

<title>Material details</title>

<style>
</style>
</head>
<body>
	<div id="nav-placeholder"></div>
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
							<div class="left aligned">Material Details</div>
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
									<div class="ui fluid large submit button green"
										onclick="location.href = '\accountdetails.jsp';">Borrow</div>
								</div>
							</div>
						</div>
						<div class="ui twelve wide column">
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Title
										<div class="sub header">10F Henry Sy Learning Commons</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Author
										<div class="sub header">10F Henry Sy Learning Commons</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Year
										<div class="sub header">10F Henry Sy Learning Commons</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Location
										<div class="sub header">10F Henry Sy Learning Commons</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Publisher
										<div class="sub header">11312345</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Status
										<div class="sub header">(02) XXX-XXXX</div>
									</div>
								</h3>
							</div>
							<div class="ui segment">
								<h3 class="ui header left aligned">
									<div class="content">
										Rating
										<div class="sub header">*********</div>
										<div class="sub header">change</div>
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
											<div class="text">Dude, this is awesome. Thanks so much
											</div>
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

	<script>
		$.get("header.html", function(data) {
			$("#nav-placeholder").replaceWith(data);
		});
	</script>


</body>


</html>