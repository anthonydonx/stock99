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
			//$("#allowedquantity").val(text.Data[0].allowedQuantity);
			setBoxPanel(text);
		}

	});
}
function setBoxPanel(text) {
	$( '#boxpanel' ).empty();
/*{"size":"32B","status":"pending","module":"1","allowedQuantity":"1800","bookingQty":"0","dayQty":"814","oderId":"6888","lineItem":"700","grnQty":"666","salesOder":"1034574","style":"VS 55288","oderQty":"2666","ginQty":"866"}*/
var allowedQuantity=parseInt(text.Data[0].allowedQuantity);
var oderQty=parseInt(text.Data[0].oderQty);
var progress=(allowedQuantity/oderQty)*100;
var grnQty=parseInt(text.Data[0].grnQty);
var ginQty=parseInt(text.Data[0].ginQty);
var bookingQty=parseInt(text.Data[0].bookingQty);
var Str = "";
	Str += '<div class="col-md-3">';// style="padding-left: 0px;"
	Str += '<div class="info-box bg-aqua">';
	Str += '<span class="info-box-icon glyphicon glyphicon-home"> </span>';
	Str += '<div class="info-box-content">';
	Str += '<span class="info-box-text">Oder / Allowed</span> ';
	Str += '<span class="info-box-number">'+oderQty+' / '+allowedQuantity+'</span>';
	Str += '<div class="progress">';
	Str += '<div class="progress-bar" style="width:'+progress.toFixed(1)+'%"></div>';
	Str += '</div>';
	Str += '<span class="progress-description"> '+progress.toFixed(1)+'% pending';
	Str += '</span></div></div></div>';
	
	
	
//	Str += '</tr>';

/*Secound panel*/
	Str += '<div class="col-md-3">';
	Str += '<div class="info-box bg-green">';
	Str += '<span class="info-box-icon glyphicon glyphicon-tags"> </span>';
	Str += '<div class="info-box-content">';
	Str += '<span class="info-box-text">GRN Quantity</span> ';
	Str += '<span class="info-box-number">'+grnQty+'</span>';
	Str += '</div></div></div>';
  
	
	/*thired panel*/
	Str += '<div class="col-md-3">';
	Str += '<div class="info-box  bg-yellow">';
	Str += '<span class="info-box-icon glyphicon glyphicon-ok"> </span>';
	Str += '<div class="info-box-content">';
	Str += '<span class="info-box-text">GIN Quantity</span> ';
	Str += '<span class="info-box-number">'+ginQty+'</span>';
	Str += '</div></div></div>';
	
	/*Fourth panel*/
	Str += '<div class="col-md-3">';
	Str += '<div class="info-box  bg-red">';
	Str += '<span class="info-box-icon glyphicon glyphicon-check"> </span>';
	Str += '<div class="info-box-content">';
	Str += '<span class="info-box-text">Booked/Res:</span> ';
	Str += '<span class="info-box-number">'+bookingQty+'</span>';
	Str += '</div></div></div>';
	
	
	
	
	
	
	$('#boxpanel').append(Str);
drawChart(text);
	
}
var clientsChart=null;
function drawChart(text) {

	var allowedQuantity=parseInt(text.Data[0].allowedQuantity);
	var oderQty=parseInt(text.Data[0].oderQty);
	var progress=(allowedQuantity/oderQty)*100;
	var grnQty=parseInt(text.Data[0].grnQty);
	var ginQty=parseInt(text.Data[0].ginQty);
	var bookingQty=parseInt(text.Data[0].bookingQty);
	var oderId=parseInt(text.Data[0].oderId);
	var barData = {
		    labels: [oderId],
		    datasets: [
		        {
		            label: 'Oder Quantity #',
		            fillColor: '#382765',
		            data: [oderQty]
		        },
		        {
		            label: 'Allowed Quantity #',
		            fillColor: '#003300',
		            data: [allowedQuantity]
		        },
		        {
		            label: 'GRN Quantity #',
		            fillColor: '#7BC225',
		            data: [grnQty]
		        }
		        ,
		        {
		            label: 'GIN Quantity #',
		            fillColor: '#FF9900',
		            data: [ginQty]
		        },
		        {
		            label: 'Booking Quantity #',
		            fillColor: '#FF0000',
		            data: [bookingQty]
		        }
		    ]
		};
	 if(clientsChart!=null){
		 clientsChart.destroy();
	    }
	var context = document.getElementById('clients').getContext('2d');
	
	clientsChart = new Chart(context).Bar(barData,{
		   animation: true,
		   maintainAspectRatio: false,
		   tooltipFillColor: "rgba(0,0,0,0.8)",                
		   multiTooltipTemplate: "<%= datasetLabel %> - <%= value %>",
		});
	//clientsChart.clear();
}