<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Serhii Maximchuk</title>

<!--
	sps Sara Soueidan za good animation 
	Thx Sara Soueidan for wonderful animation
	https://github.com/sarasoueidan/creative-list-effects -->
<link rel="stylesheet" href="resources/css/styles.css">
<link rel="stylesheet" href="resources/css/styles-1.css">

<style type="text/css"></style>
<style type="text/css">
.fancybox-margin {
	margin-right: 20px;
}
</style>
</head>

<body>

	<div class="demo-wrapper">

		<div class="notification save-notification" style="display: none;">
			Item Saved</div>

		<div class="reminder-container">

			<div class="buttons" style="height: 50px; display: none;"></div>

			<form id="input-form">
				<input type="text" id="text" placeholder="..."> <input
					type="submit" value="Add">
			</form>

			<ul class="reminders">
			</ul>

		</div>

	</div>

	<script src="resources/js/jquery-1.8.2.min.js"></script>
	<script src="resources/js/modernizr-1.5.min.js"></script>
	<script src="resources/js/scripts.js"></script>

</body>
</html>
