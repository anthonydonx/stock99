<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>GRN(OUT)</title>
<link rel="stylesheet" href="resources/css/other/jquery-ui.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">
<link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<jsp:include page="nav.jsp" />
</head>
<style>
.btn-primary {
	margin-top: 25px;
	padding: 6px 40px;
}

@media ( max-width : 991px) {
	.btn-primary {
		margin-top: 0px;
		float: right;
		margin-right: 15px;
	}
}
</style>
<body>

	<!-- Content -->

	<div class="container">
		<div class="panel panel-default ">
			<div class="panel-body bg-info">
				<div class="row ">
					<div class="col-md-12">
						<form>
							<div class="form-group col-md-7">
								<label for="barcodetext">Barcode </label> <input
									type="text" class="form-control" id="barcodetext"
									placeholder="Please foucs first">
							</div>
							<div class="form-group">
								<button type="button" id="getdata" name="getdata" class="btn btn-primary">Get
									information</button>
							</div>
						</form>

					</div>


				</div>
				
			</div>
		</div>

<table class="table table-striped custab" id="gintable">

					<tr>
						<th>GRN no</th>
						<th>Quantity</th>
						<th>B UserId</th>
						<th>GRN date</th>
						<th>Booking date</th>
						<th>OderId</th>
						<th>Location</th>
						<th>Colour</th>
						<th class="text-center"><span class="text-center">Action</span></th>
					</tr>

					
				</table>


</div>


	<!-- Footer with buttons -->
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-bottom footerBar"
			role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="">STOCK99</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
				<button type="button" id="sendoff" name="sendoff" class="btn btn-primary pull-right ">
					<span class="glyphicon glyphicon glyphicon-hand-right"></span>SEND
					OFF
				</button>
				<button type="button" class="btn btn-default pull-right ">
					<span class="glyphicon glyphicon-copyright-mark"></span>Clear
				</button>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
	<!-- End footer with button -->


	<!-- End content -->



	<script src="resources/js/other/jquery-2.1.4.min.js"></script>
	<script src="resources/js/other/jquery-ui.js"></script>
	<script src="resources/js/other/bootstrap.min.js"></script>
	<script src="resources/js/other/jquery-confirm.min.js"></script>
	<script src="resources/js/other/bootstrap-filestyle.min.js"></script>
	<script src="resources/js/common.js"></script>
	<script src="resources/js/ginout.js"></script>
	<!-- Page resources  -->


</body>

</html>