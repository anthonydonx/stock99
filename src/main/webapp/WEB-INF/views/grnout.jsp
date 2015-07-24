<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>GRN(IN)</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet"
	href="resources/css/screen.css">

<jsp:include page="nav.jsp" />
</head>
<body>

	<!-- Content -->

	<div class="container">
	<div class="panel panel-default ">
	<div class="panel-body bg-info">
	<div class="row ">
	<div class="col-md-4">
		<div class="ui-widget">
			<label for="tags">Sales oder: </label> <input class="form-control" id="tags">
		</div>
		</div>
		<div class="col-md-4">
		<div class="ui-widget">
			<label for="tags">Style: </label> <input class="form-control" id="tags">
		</div>
		</div>
		<div class="col-md-4">
		<div class="ui-widget">
			<label for="tags">Line/Item: </label> <input class="form-control" id="tags">
		</div>
		</div>
		</div>
		<div class="row">
		<div class="col-md-4">
		<div class="ui-widget">
			<label for="tags">Size: </label> <input class="form-control" id="tags">
		</div>
		</div>
		
		<div class="col-md-4">
		<div class="ui-widget">
			<label for="tags">Module: </label> <input class="form-control" id="tags">
		</div>
		</div>
		</div>
		</div>
		</div>
		
		
		<div class="row">
		<div class="col-md-3">
		<label for="quantity">Quantity: </label> <input class="form-control" id="quantity">
		</div>
		
		<div class="col-md-3">
		<label for="binlocation">BIN Location: </label> <input class="form-control" id="binlocation">
		</div>
		
		<div class="col-md-3">
		<label for="colour">Colour </label> <input class="form-control" id="colour">
		</div>
		
		<div class="col-md-3">
		<label for="epf">EPF </label> <input class="form-control" id="colour">
		</div>
		</div>
	
		
		</div>
	
	
	<div class="container">
	
	</div>

	<!-- End content -->
	<jsp:include page="footer.jsp" />


	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<!-- Page resources  -->
	<script src="resources/js/grnout.js"></script>
	

</body>

</html>