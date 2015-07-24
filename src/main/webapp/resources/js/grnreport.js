$(document).ready(function() {
autocompleteFill('oder/getAll', 'style', 'style', 'style',
	"style");

	// get SalesOders
	$("#style").blur(function() {
		var style = $("#style").val();
		if ($.trim(style).length == 0) {
			$.alert({
				title : 'Alert!',
				content : 'Please select valid data',
				confirm : function() {
				}
			});
		} else {
			getSalesOders(style);
		}
	});
	// END getSalesOders
});
//Get LineItem
$("#salesoder").blur(
		function() {
			var salesoder = $("#salesoder").val();
			var style = $("#style").val();
			if ($.trim(salesoder).length == 0
					|| $.trim(style).length == 0) {
				$.alert({
					title : 'Alert!',
					content : 'Please select valid data',
					confirm : function() {
					}
				});
			} else {
				getLineItem(salesoder, style);
			}
		});
// END Get LineItem

// Get Size
$("#lineitem").blur(
		function() {
			var salesoder = $("#salesoder").val();
			var style = $("#style").val();
			var lineitem = $("#lineitem").val();
			if ($.trim(salesoder).length == 0
					|| $.trim(style).length == 0
					|| $.trim(lineitem).length == 0) {
				$.alert({
					title : 'Alert!',
					content : 'Please select valid data',
					confirm : function() {
					}
				});
			} else {
				getSize(style, salesoder, lineitem);
			}
		});
// END Get Size

// Get Module
$("#size")
		.blur(
				function() {
					var salesoder = $("#salesoder").val();
					var style = $("#style").val();
					var lineitem = $("#lineitem").val();
					var size = $("#size").val();
					if ($.trim(salesoder).length == 0
							|| $.trim(style).length == 0
							|| $.trim(lineitem).length == 0
							|| $.trim(size).length == 0) {
						$
								.alert({
									title : 'Alert!',
									content : 'Please select valid data',
									confirm : function() {
									}
								});
					} else {
						getModule(style, salesoder,
								lineitem, size);
					}
				});
// END Get Module

// Get other details,Oderid
$("#module").blur(
		function() {
			var salesoder = $("#salesoder").val();
			var style = $("#style").val();
			var lineitem = $("#lineitem").val();
			var size = $("#size").val();
			var module = $("#module").val();
			if ($.trim(salesoder).length == 0
					|| $.trim(style).length == 0
					|| $.trim(lineitem).length == 0
					|| $.trim(size).length == 0
					|| $.trim(module).length == 0) {
				$.alert({
					title : 'Alert!',
					content : 'Please select valid data',
					confirm : function() {
					}
				});
			} else {
				getOderDetails(style, salesoder, lineitem,
						size, module);
			}
		});
// END Get other details //Oderid

function getSalesOders(style) {
	autocompleteFill('oder/getSalesOderidFromStyle?style=' + style,
			'salesoder', 'salesOder', 'salesOder', "salesOder");
}
function getLineItem(salesoder, style) {
	autocompleteFill('oder/getDataFromStyleAndSalesoder?style=' + style
			+ '&salesoder=' + salesoder, 'lineitem', 'lineItem', 'lineItem',
			"lineItem");
}
function getSize(style, salesoder, lineitem) {
	autocompleteFill('oder/getDataFromStyleAndSalesoderLineItem?style=' + style
			+ '&salesoder=' + salesoder + '&lineitem=' + lineitem, 'size',
			'size', 'size', "size");
}
function getModule(style, salesoder, lineitem, size) {
	autocompleteFill('oder/getDataFromStyleAndSalesoderLineItemSize?style='
			+ style + '&salesoder=' + salesoder + '&lineitem=' + lineitem
			+ '&size=' + size, 'module', 'module', 'module', "module");
}
function getOderDetails(style, salesoder, lineitem, size, module) {
	var formData = {};
	formData.style = style;
	formData.salesoder = salesoder;
	formData.lineitem = lineitem;
	formData.size = size;
	formData.module = module;
	$.ajax({
		type : "GET",
		url : "oder/getDataFromOthers",
		data : formData,
		dataType : "json",
		// async : false,
		error : function(val) {

		},
		success : function(text) {
			$("#oderid").val(text.Data[0].oderId);
			getGRNFromOderId(text.Data[0].oderId);
		}

	});
}
function getGRNFromOderId(oderId) {
	var formData = {};
	formData.oderId = oderId;
	$.ajax({
		type : "GET",
		url : "grnin/getAllGRNById",
		data : formData,
		dataType : "json",
		error : function(val) {

		},
		success : function(text) {
			$("#dev-table > tbody").html("");
			if (text.Data != "Empty") {
				for (var int = 0; int < text.Data.length; int++) {
					var grninId = text.Data[int].grninId;
					var quantity = text.Data[int].quantity;
					var binLocation = text.Data[int].binLocation;
					var colour = text.Data[int].colour;
					var epf = text.Data[int].epf;
					var date = text.Data[int].date;
					var userId = text.Data[int].userId;
					
					var bookingUserId = text.Data[int].bookingUserId;
					var status = text.Data[int].status;
					var bookingDate = text.Data[int].bookingDate;
					var issuedDate = text.Data[int].issuedDate;
					var issuedUserId = text.Data[int].issuedUserId;	
					var oderId = text.Data[int].orders.oderId;	
					var statusStr;
					var rowClass;
					if(status=='in'){
						statusStr='<span class="label label-primary">'+status+'</span>';
						rowClass='class="info"';
					}else if (status=='booking') {
						statusStr='<span class="label label-warning">'+status+'</span>';
						rowClass='class="warning"';
					}else {
						statusStr='<span class="label label-success">'+status+'</span>';
						rowClass='class="success"';
					}
					var Str = "";
					Str += '<tr '+rowClass+'>';
					Str += '<td>' + grninId + '</td>';
					Str += '<td>' + oderId + '</td>';
					Str += '<td>' + date + '</td>';
					Str += '<td>' +binLocation  + '</td>';
					Str += '<td>' + colour + '</td>';
					Str += '<td>' + epf + '</td>';
					Str += '<td>' + quantity + '</td>';
					
					Str += '<td>' +userId  + '</td>';
					Str += '<td>' + statusStr + '</td>';
					Str += '<td>' + bookingUserId + '</td>';
					Str += '<td>' + bookingDate + '</td>';
					
					Str += '<td>' + issuedUserId + '</td>';
					Str += '<td>' + issuedDate + '</td>';

					Str += '</tr>';
					$('#dev-table > tbody:last-child').append(Str);
				}

			} else {
				$.alert({
					title : 'Alert!',
					content : 'Stocks not available !',
					confirm : function() {
					}
				});
			}
		}

	});
}