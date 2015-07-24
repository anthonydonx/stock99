<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>GRN(IN)</title>
<link rel="stylesheet" href="resources/css/other/jquery-ui.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">

<jsp:include page="nav.jsp" />
</head>
<body>

	<!-- Content -->

	<div class="container">
	
		<div class="panel panel-default ">
			<div class="panel-body bg-info">
				<div class="row ">
					<div class="col-md-2">
						<div class="ui-widget">
							<label for="style">Style: </label> <input class="form-control"
								id="style" required>
						</div>
					</div>

					<div class="col-md-2">
						<div class="ui-widget">
							<label for="salesoder">Sales oder: </label> <input
								class="form-control" id="salesoder"required>
						</div>
					</div>

					<div class="col-md-2">
						<div class="ui-widget">
							<label for="lineitem">Line/Item: </label> <input
								class="form-control" id="lineitem">
						</div>
					</div>


					<div class="col-md-1">
						<div class="ui-widget">
							<label for="size">Size: </label> <input class="form-control"
								id="size">
						</div>
					</div>

					<div class="col-md-1">
						<div class="ui-widget">
							<label for="module">Module: </label> <input class="form-control"
								id="module">
						</div>
					</div>
					<div class="col-md-2">
				<label for="oderid">Oder Id: </label> <input class="form-control"
					id="oderid" disabled="disabled">
			</div>


				
				
			
<div class="col-md-2">
<label>&nbsp;</label>
<br>

				<button type="button" id="availablestock" class="btn btn-primary" style="width:100%">Load available stocks</button>


		
				</div>
				</div>
				</div>
</div>
				<div class="row">
					<table id="booking" class="table table-striped custab">
						<thead>


							<tr>
							    <th>GRN Id</th>	
								<th>Date</th>	
								<th>Oder Id</th>
								<th>Quantity</th>
								<th>BIN</th>
								<th>Colour</th>
								<th>EPF</th>
								
								<th class="text-center">Action</th>
							</tr>
						</thead>
<tbody>
					 
				</tbody>
					</table>

				</div>


			

		


		


	</div>

	<!-- Footer with buttons -->
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-bottom footerBar"
			role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="">STOCK99</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<button type="button" class="btn btn-primary pull-right " id="save">
				<span class="glyphicon glyphicon glyphicon-copy"></span> Book these items
			</button>
			<button type="button" class="btn btn-default pull-right ">
				<span class="glyphicon glyphicon-copyright-mark"></span>Clear
			</button>
		</div>
		<!-- /.navbar-collapse --> </nav>
	</div>
	<!-- End footer with button -->

	<!-- End content -->



	<script src="resources/js/other/jquery-2.1.4.min.js"></script>
	<script src="resources/js/other/jquery-ui.js"></script>
	<script src="resources/js/other/bootstrap.min.js"></script>	
	<script src="resources/js/other/jquery-confirm.min.js"></script>

	<!-- Page resources  -->
	
	
		<script src="resources/js/common.js"></script>
		<script src="resources/js/booking.js"></script>


</body>

</html>