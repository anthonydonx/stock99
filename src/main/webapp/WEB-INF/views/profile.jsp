<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>User Management</title>
<link rel="stylesheet" href="resources/css/other/jquery-ui.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/screen.css">
<link rel="stylesheet" href="resources/css/other/jquery-confirm.min.css">
<link rel="stylesheet" href="resources/css/combo/jquery.ui.combogrid.css">

<!-- Image selector -->
<link rel="stylesheet" href="resources/css/other/jasny-bootstrap.css">


	
	<script type="text/javascript" src="resources/js/other/chart.min.js"></script>
	<style type="text/css">
	    	.row{
		    margin-top:40px;
		    padding: 0 10px;
		}
		.clickable{
		    cursor: pointer;   
		}

		.panel-heading div {
			margin-top: -18px;
			font-size: 15px;
		}
		.panel-heading div span{
			margin-left:5px;
		}
		.panel-body{
			display: none;
		}
		</style>
	<jsp:include page="nav.jsp" />
</head>
<body>
<div class="container">
<div class="row ">
					<div class="col-md-6">
						<div class="ui-widget">
							<label for="style">User name: </label> <input class="form-control"
								id="style" required>
						</div>
	</div>				
<div class="col-md-6 pull-right text-right">	
<img name="imageview" id="imageview" src="<%= session.getAttribute("url") %>" alt="your image" class="img-circle"  style="width: 130px; height: 130px;">
<form id="imagesend" name="imagesend" action="" method="post"
                        enctype="multipart/form-data">
<span class="btn btn-default btn-file">
<span class="fileinput-new"></span>
<span class="fileinput-exists">Change</span>
<input type="file" name="file" size="50" />
</span>

</form>
</div>		
</div>	


<div class="row ">
					<div class="col-md-3">
						<div class="ui-widget">
							<label for="password">Password: </label> <input class="form-control"
								id="password" required>
						</div>
	</div>				
<div class="col-md-6">	

</div>		
</div>	

</div>	
	
	
<script src="resources/js/other/jquery-2.1.4.min.js"></script>
	<script src="resources/js/other/jquery-ui.js"></script>
	<script src="resources/js/other/bootstrap.min.js"></script>	
	<script src="resources/js/other/jquery-confirm.min.js"></script>

	<!-- Page resources  -->
	
	
		<script src="resources/js/common.js"></script>
		<!-- Image selector -->
		<script src="resources/js/other/jasny-bootstrap.js"></script>
		<script src="resources/js/other/jasny-bootstrap.js"></script>
		<script src="resources/js/combo/jquery.ui.combogrid-1.6.3.js"></script>
		<script src="resources/js/combo/remote-list.js"></script>
		<script src="resources/js/profile.js"></script>
<script >

</script>
<script type="text/javascript">
(function(){
    'use strict';
	var $ = jQuery;
	$.fn.extend({
		filterTable: function(){
			return this.each(function(){
				$(this).on('keyup', function(e){
					$('.filterTable_no_results').remove();
					var $this = $(this), 
                        search = $this.val().toLowerCase(), 
                        target = $this.attr('data-filters'), 
                        $target = $(target), 
                        $rows = $target.find('tbody tr');
                        
					if(search == '') {
						$rows.show(); 
					} else {
						$rows.each(function(){
							var $this = $(this);
							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
						})
						if($target.find('tbody tr:visible').size() === 0) {
							var col_count = $target.find('tr').first().find('td').size();
							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
							$target.find('tbody').append(no_results);
						}
					}
				});
			});
		}
	});
	$('[data-action="filter"]').filterTable();
})(jQuery);

$(function(){
    // attach table filter plugin to inputs
	$('[data-action="filter"]').filterTable();
	
	$('.container').on('click', '.panel-heading span.filter', function(e){
		var $this = $(this), 
			$panel = $this.parents('.panel');
		
		$panel.find('.panel-body').slideToggle();
		if($this.css('display') != 'none') {
			$panel.find('.panel-body input').focus();
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
})
</script>

</body>
</html>
