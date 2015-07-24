<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/>
<FilesMatch".(eot|ttf|otf|woff)"> Header set
Access-Control-Allow-Origin "*" </FilesMatch>
<title>Daily Target Report</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">
<link rel="stylesheet" href="resources/css/other/jquery-ui.min.css">
<jsp:include page="nav.jsp" />

</head>
<body>
	<div class="container">
  <div class="panel panel-default ">
			<div class="panel-body bg-info">
				<div class="row ">
					<div class="col-md-6">
						<div class="ui-widget form-inline">
							<label for="datepicker">Date : </label> <input
								class="form-control" style="width: 90%;" type="text"
								name="datepicker" id="datepicker">
						</div>
					</div>
				</div>

			</div>
		</div>
		<input type="button" id="exbutton" value="Export Xls">
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
								<th>Id</th>
								<th>Oder</th>
								<th>Style</th>
								<th>Sales oder</th>
								<th>Allowed quantity</th>
								<th>Daily quantity</th>
								<th>Issued</th>								
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

	<!-- Page resources  -->
	<!-- Upload res -->
	<!-- End upload res -->

	<script src="resources/js/other/jquery-confirm.min.js"></script>
	<script src="resources/js/other/bootstrap-filestyle.min.js"></script>
	<script src="resources/js/other/jquery.table2excel.min.js"></script>
	
	<script src="resources/js/common.js"></script>
	<script src="resources/js/dailytargetreport.js"></script>


	<script>
		$(function() {
			$("#datepicker").datepicker({
				showButtonPanel : true,
				dateFormat : 'yy-mm-dd',
			});
		});
	</script>
</body>

</html>