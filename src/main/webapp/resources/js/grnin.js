$(document)
		.ready(
				function() {
					

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

					// Get LineItem
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

					// Get other details //Quantity,Oderid
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
					// END Get other details //Quantity,Oderid

					autocompleteFill('oder/getAll', 'style', 'style', 'style',
							"style");
					$("#addToTable").click(function() {
						addToTable();
					});
					$("#quantity").blur(function() {
						checkQuantity();
					});
					$("#save").click(function() {
						saveGrnin();
					});
				});
function addToTable() {
	var RowNumber=$('#grnin tr').length;
	var oderid = $("#oderid").val();
	var style = $("#style").val();
	var salesOder = $("#salesoder").val();
	var lineitem = $("#lineitem").val();
	var size = $("#size").val();
	var module = $("#module").val();
	var quantity = $("#quantity").val();
	var binlocation = $("#binlocation").val();
	var colour = $("#colour").val();
	var epf = $("#epf").val();

	var Str = "";
	Str += '<tr onclick="removeRow(this);">';
	Str += '<td>' + oderid + '</td>';
	Str += '<td>' + style + '</td>';
	Str += '<td>' + salesOder + '</td>';
	Str += '<td>' + lineitem + '</td>';
	Str += '<td>' + size + '</td>';
	Str += '<td>' + module + '</td>';
	Str += '<td>' + quantity + '</td>';
	Str += '<td>' + binlocation + '</td>';
	Str += '<td>' + colour + '</td>';
	Str += '<td>' + epf + '</td>';
	//Str += '<td class="text-center"><a class="btn btn-info btn-xs" onclick="removeRow('+RowNumber+');"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>';

	Str += '</tr>';
	$('#grnin > tbody:last-child').append(Str);
	/*$("#grnin tr").click(function(){
	alert(	$(this).html());
	$(this).eq();
        $(this).find("td").each(function(){
            alert($(this).html());
        });
    });*/
	clearAll();
}
function clearAll() {
	$("#oderid").val("");
	$("#style").val("");
	$("#salesoder").val("");
	$("#lineitem").val("");
	$("#size").val("");
	$("#module").val("");
	$("#quantity").val("");
	$("#binlocation").val("");
	$("#colour").val("");
	$("#epf").val("");
	$("#allowedquantity").val("");

}
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
function checkQuantity() {
	var allowedquantity = parseInt($("#allowedquantity").val());
	var quantity = parseInt($("#quantity").val());

	if ($.trim(allowedquantity).length == 0 || $.trim(quantity).length == 0) {
		$.alert({
			title : 'Alert!',
			content : 'Please select valid data',
			confirm : function() {
				//$("#quantity").focus();
			}
		});
	} else if (quantity > allowedquantity) {
		$.alert({
			title : 'Alert!',
			content : 'Quantity Not Allowed',
			confirm : function() {
				//$("#quantity").focus();
			}
		});
	}
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
			$("#allowedquantity").val(text.Data[0].allowedQuantity);
		}

	});
}
function saveGrnin() {
	var table = $("#grnin tbody");
	table.find('tr').each(
			function(i) {

				var $tds = $(this).find('td'),
				 oderid = $tds.eq(0).text(),
				size = $tds.eq(4).text(), quantity = $tds.eq(6)
						.text(), binlocation = $tds.eq(7).text();
				colour = $tds.eq(8).text(), epf = $tds.eq(9).text(),
						date = "2015-06-10";
				userid = "1", $.ajax({
					type : "POST",
					url : "grnin/addGrn",
					type : 'POST',
					data : {
						oderId : oderid,
						quantity : quantity,
						binLocation : binlocation,
						colour : colour,
						size : size,
						epf : epf,
						date : date,
						userId : userid,
						status:"in",
						BookingUserId:2
					},
					dataType : "json",
					// async : false,
					error : function(val) {
						$.alert({
							title : 'Alert!',
							content : val.Data,});
					
					},
					success : function(text) {
						$.alert({
							title : 'Alert!',
							content : text.Data,});
					}

				});

			});
}
function updateTest() {
	$.ajax({
		type : "POST",
		url : "ginin/addGin",
		data : "",
		dataType : "json",
		// async : false,
		error : function(val) {

		},
		success : function(text) {
			console.log(text);
		}

	});

}
function removeRow(row) {
	$.confirm({
	    title: 'Confirm!',
	    content: 'Remove row?',
	    confirm: function(){
	    	$(row).remove();
	    },
	    cancel: function(){
	     
	    }
	});
	
	
}