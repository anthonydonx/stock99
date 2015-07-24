<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <FilesMatch ".(eot|ttf|otf|woff)">
        Header set Access-Control-Allow-Origin "*"
    </FilesMatch>
<title>Upload Xls</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">
<jsp:include page="nav.jsp" />
</head>
<body>

	<!-- Content -->

	<div class="container">
		<div class="row col-md-12 col-md-offset-0 custyle">
			<input id="xlf" type="file" name="xlfile">
			<br>
			<table class="table table-striped custab" id="xlstable"
				name="xlstable">

				<thead>


					<tr>
						<th>Module</th>
						<th>Style</th>
						<!--   <th>Style Code</th> -->
						<th>Sales Oders</th>
						<th>Line/Item</th>
						<th>Size</th>
						<th>Oder Qty</th>
						<th>Day Qty</th>
						<!--  <th class="text-center">Action</th> -->
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>


	<!-- Inbox button -->

	<div class="row">
		<div id="inbox">
			<div class="fab btn-group show-on-hover dropup">
				<div data-toggle="tooltip" data-placement="left" title="Compose"
					style="margin-left: 42px;">
					<button type="button" class="btn btn-info btn-io dropdown-toggle"
						data-toggle="dropdown">
						<span class="fa-stack fa-2x"> <i
							class="fa fa-stack-2x fab-backdrop"></i> <i
							class="fa fa-plus fa-stack-1x fa-inverse fab-primary"></i> <i
							class="fa fa-pencil fa-stack-1x fa-inverse fab-secondary"></i>
						</span>
					</button>
				</div>
				<ul class="dropdown-menu dropdown-menu-right" role="menu">
					<li><a href="#" data-toggle="tooltip" data-placement="left"
						title="Coffee"><i class="fa fa-floppy-o"></i></a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="left"
						title="LiveChat"><i class="fa fa-comments-o"></i></a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="left"
						title="Reminders"><i class="fa fa-hand-o-up"></i></a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="left"
						title="Invites"><i class="fa fa-ticket"></i></a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- End inbox button -->




	<!-- Footer with buttons -->
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-bottom footerBar"
			role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="">STOCK99</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
			<button type="button" class="btn btn-primary pull-right " id="save" name="save" data-loading-text="Saving...." autocomplete="off">
				<span class="glyphicon glyphicon glyphicon-floppy-disk" ></span>Save oders
			</button>
			<button type="button" class="btn btn-primary pull-right " id="dailytarget" name="dailytarget" data-loading-text="Saving...." autocomplete="off">
				<span class="glyphicon glyphicon glyphicon-floppy-disk" ></span>Set daily targets
			</button>
			<button type="button" class="btn btn-default pull-right " data-loading-text="Saving...." autocomplete="off">
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

	<!-- Page resources  -->
	<!-- Upload res -->
	<script src="resources/js/uploadres/xlsx.core.min.js"></script>
	<script src="resources/js/uploadres/cpexcel.js"></script>
	<script src="resources/js/uploadres/ods.js"></script>
	<!-- End upload res -->
	<script src="resources/js/uploadxls.js"></script>
	<script src="resources/js/other/jquery-confirm.min.js"></script>
		<script src="resources/js/other/bootstrap-filestyle.min.js"></script>
	
	
	<script type="text/javascript">
		$('.fab').hover(function() {
			$(this).toggleClass('active');
		});
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>

</body>

</html>