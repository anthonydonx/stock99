<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>GRN Report</title>
<link rel="stylesheet" href="resources/css/other/jquery-ui.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">
<link rel="stylesheet"
	href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- <link href="catalog/view/javascript/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" /> -->
<!-- <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> -->
<jsp:include page="nav.jsp" />
</head>
<body>
	<div class="container">
		<div class="panel panel-default ">
			<div class="panel-body bg-primary">
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
								class="form-control" id="salesoder" required>
						</div>
					</div>

					<div class="col-md-2">
						<div class="ui-widget">
							<label for="lineitem">Line/Item: </label> <input
								class="form-control" id="lineitem">
						</div>
					</div>


					<div class="col-md-2">
						<div class="ui-widget">
							<label for="size">Size: </label> <input class="form-control"
								id="size">
						</div>
					</div>

					<div class="col-md-2">
						<div class="ui-widget">
							<label for="module">Module: </label> <input class="form-control"
								id="module">
						</div>
					</div>
					<div class="col-md-2">
						<label for="oderid">Oder Id: </label> <input class="form-control"
							id="oderid" disabled="disabled">
					</div>


				</div>


			</div>
		</div>
		<div class="row" id="boxpanel">
		</div>
		<div class="row">
    	
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Agent Oders</h3>
						<div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip" title="Toggle table filter" data-container="body">
								<i class="glyphicon glyphicon-filter"></i>
							</span>
						</div>
					</div>
					<div class="panel-body">
						<input type="text" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Developers" />
					</div>
					<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
								<th>GRN</th>
								<th>Oder</th>
								<th>date</th>
								<th>BIN</th>
								<th>Colour</th>
								<th>EPF</th>
								<th>Qty</th>	
									<th>User</th>
								<th>Status</th>
								<th>B-User</th>	
								<th>B-Date</th>		
								<th>Iss-User</th>
								<th>Iss-Date</th>							
							</tr>
						</thead>
						<tbody>
							
							
						</tbody>
					</table>
				</div>
			</div>
		
		</div>
		
	

</div>
	


		<script src="resources/js/other/jquery-2.1.4.min.js"></script>
		<script src="resources/js/other/jquery-ui.js"></script>
		<script src="resources/js/other/bootstrap.min.js"></script>
		<script src="resources/js/other/jquery-confirm.min.js"></script>
		<script src="resources/js/other/bootstrap-filestyle.min.js"></script>
		<!-- Page resources  -->
<script src="resources/js/other/Chart.min.js"></script>

		<script src="resources/js/common.js"></script>
		<script src="resources/js/grnreport.js"></script>
	

</body>

</html>