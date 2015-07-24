<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/other/jquery-ui.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">
<link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<style>
.col-md-4 {float: none;}
.contentDiv {padding:20px; margin-top: 5%;}
</style>

<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
<div class="col-md-12">
<h1>Stock99</h1>
</div>
</div>
</div>
<center>
<div class="col-md-12 contentDiv">
<div class="col-md-4">
	<form action="login" method="post" class="form">
		<div class="form-group">
			<input name="username"
				type="text" class="form-control" id="username"
				placeholder="Enter Username">
		</div>
		<div class="form-group">
			 <input name="password"
				type="password" class="form-control" id="password"
				placeholder="Password">
		</div>
		
		
		<button type="submit" class="btn btn-primary col-md-12">Say hello</button>
	</form>
</div>

</div>
</center>


</div>


	</form>
</body>
<!-- Latest compiled and minified JavaScript -->
<script src="resources/js/other/jquery-2.1.4.min.js"></script>
	<script src="resources/js/other/jquery-ui.js"></script>
	<script src="resources/js/other/bootstrap.min.js"></script>
	<script src="resources/js/other/jquery-confirm.min.js"></script>
	<script src="resources/js/other/bootstrap-filestyle.min.js"></script>
	<script src="resources/js/common.js"></script>
<!-- 	<script src="resources/js/ginout.js"></script> -->
	<!-- Page resources  -->
</html>
