<style>
.container {
	margin-top: 65px;
	padding-bottom: 50px;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
<!-- <header> -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="home">STOCK99</a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li class="active"><a href="home"><span
					class="glyphicon glyphicon-home"></span> Dashboard</a></li>
			<li><a href="upload"><span class="fa fa-camera-retro"></span>
					Upload xls</a></li>
			<li><a href="grnin"><span
					class="glyphicon glyphicon-calendar"></span> Stock In(GRN)</a></li>
			<li><a href="booking"><span
					class="glyphicon glyphicon-calendar"></span>Booking</a></li>
			<li><a href="ginout"><span
					class="glyphicon glyphicon-calendar"></span> Stock Out(GIN)</a></li>
			<!-- <li><a href="report"><span
					class="glyphicon glyphicon-calendar"></span> Reports</a></li> -->
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><span
					class="glyphicon glyphicon-calendar"></span> Reports <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="dailytargetreport"><span class="glyphicon glyphicon-stats"></span>Daily target report</a></li>
					<li class="divider"></li>
					<li><a href="oderreport"><span class="glyphicon glyphicon-stats"></span>Oder report</a></li>
					<li class="divider"></li>
					<li><a href="grnreport"><span class="glyphicon glyphicon-stats"></span>GRN Report</a></li>
				</ul></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><span class="glyphicon glyphicon-comment"></span>
					GRN <span class="label label-primary">42</span> </a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><span
					class="glyphicon glyphicon-envelope"></span> GIN <span
					class="label label-info">32</span> </a></li>
			<li class="dropdown">
			
			<a href="#" class="dropdown-toggle"
				data-toggle="dropdown">
				<!-- <span class="glyphicon glyphicon-user"></span> -->
				<img alt="" src="${sessionScope.url}" width="25px" height="25px">
					Admin <b class="caret"></b>
					
					</a>
					
				<ul class="dropdown-menu">
					<li><a href="profile"><img alt="" src="${sessionScope.url}" width="20px" height="25px"> .Profile</a></li>
				<!-- 	<li><a href="#"><span class="glyphicon glyphicon-cog"></span>Settings</a></li> -->
					<li class="divider"></li>
					<li><a href="#"><span class="glyphicon glyphicon-off"></span>Logout</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>
<!-- 	</header> -->


