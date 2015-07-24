$(document)
		.ready(
				function() {
					/*
					 * $("#in").change(function() { if(this.checked) {
					 * alert("hello"); } });
					 */
					$("#save").click(function() {
						saveBooking();
					});

					$("#availablestock").click(function() {
						getGRNFromOderId();
					});
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

					function getSalesOders(style) {
						autocompleteFill('oder/getSalesOderidFromStyle?style='
								+ style, 'salesoder', 'salesOder', 'salesOder',
								"salesOder");
					}
					function getLineItem(salesoder, style) {
						autocompleteFill(
								'oder/getDataFromStyleAndSalesoder?style='
										+ style + '&salesoder=' + salesoder,
								'lineitem', 'lineItem', 'lineItem', "lineItem");
					}
					function getSize(style, salesoder, lineitem) {
						autocompleteFill(
								'oder/getDataFromStyleAndSalesoderLineItem?style='
										+ style + '&salesoder=' + salesoder
										+ '&lineitem=' + lineitem, 'size',
								'size', 'size', "size");
					}
					function getModule(style, salesoder, lineitem, size) {
						autocompleteFill(
								'oder/getDataFromStyleAndSalesoderLineItemSize?style='
										+ style + '&salesoder=' + salesoder
										+ '&lineitem=' + lineitem + '&size='
										+ size, 'module', 'module', 'module',
								"module");
					}

				});

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
			// $("#allowedquantity").val(text.Data[0].allowedQuantity);
		}

	});
}

function getGRNFromOderId() {
	var formData = {};
	var oderId = $("#oderid").val();
	formData.oderId = oderId;
	formData.status = "in";
	$
			.ajax({
				type : "GET",
				url : "grnin/getGRNFromOderId",
				data : formData,
				dataType : "json",
				// async : false,
				error : function(val) {

				},
				success : function(text) {
					if (text.Data != "Empty") {
						for (var int = 0; int < text.Data.length; int++) {
							var RowNumber = $('#booking tr').length;
							var date = text.Data[int].date;
							var grnID = text.Data[int].grninId;
							var quantity = text.Data[int].quantity;
							var binLocation = text.Data[int].binLocation;
							var colour = text.Data[int].colour;
							var epf = text.Data[int].epf;

							var Str = "";
							Str += '<tr onclick="removeRow(this);">';
							Str += '<td>' + grnID + '</td>';
							Str += '<td>' + date + '</td>';
							Str += '<td>' + oderId + '</td>';
							Str += '<td>' + quantity + '</td>';
							Str += '<td>' + binLocation + '</td>';
							Str += '<td>' + colour + '</td>';
							Str += '<td>' + epf + '</td>';
							Str += '<td class="text-center"><input type="checkbox"></td>';

							Str += '</tr>';
							$('#booking > tbody:last-child').append(Str);
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

function saveBooking() {

	var table = $("#booking tbody");
	table.find('tr').each(function(i) {

		var $tds = $(this).find('td'), grnId = $tds.eq(0).text();
		var row = $(this);
		if (row.find('input[type="checkbox"]').is(':checked')) {
			$.ajax({
				type : "POST",
				url : "grnin/saveBooking",
				data : {
					grnId : grnId
				},
				dataType : "json",
				error : function(val) {
				},
				success : function(text) {
					$.alert({
						title : 'Alert!',
						content : text.Data,});
				}

			});
		}
		/*
		 * var l= $tds.eq(7).html(); if(l.checked) { alert("hello"); }
		 */
		// status = $tds.eq(7).text(),
		// if()

	});

}
