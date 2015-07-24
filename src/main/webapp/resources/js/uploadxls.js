var obj ;

$(document).ready(
		function() {
			
			$("#dailytarget").click(function() {
				setDailyTarget();				
				
			});
					$(":file").filestyle({
				buttonName : "btn-primary"
			});
			document.getElementById("xlf").addEventListener('change',
					handleFile, false);
			
						$("#save").click(function() {
				updateData();
				
				
			});
			$(document)
			  .ajaxStart(function () {
				 obj =  $.alert({
					    icon: 'fa fa-spinner fa-spin',
					    title: 'Working!',
					    content: 'Sit back, we are processing your request.',
					    	confirmButton: false,
					});
			  })
			 .ajaxStop(function () {
				 obj.close();
			  });
		});

function handleFile(e) {
	$("#xlstable > tbody").html("");
	var files = e.target.files;
	var i, f;
	for (i = 0, f = files[i]; i != files.length; ++i) {
		var reader = new FileReader();
		var name = f.name;
		reader.onload = function(e) {
			var data = e.target.result;

			var workbook = XLSX.read(data, {
				type : 'binary'
			});
			/* DO SOMETHING WITH workbook HERE */
			var first_sheet_name = workbook.SheetNames[0];
			/* Get worksheet */
			var worksheet = workbook.Sheets[first_sheet_name];

			var valueValidation = true;
			var rowNumber = 1;
			try {
				while (valueValidation) {
					rowNumber++;
					var titleCells = [ 'A' + rowNumber, 'B' + rowNumber,
							'C' + rowNumber, 'D' + rowNumber, 'E' + rowNumber,
							'F' + rowNumber, 'G' + rowNumber ];

					var rawData = [];
					for (var int = 0; int < titleCells.length; int++) {
						/* Find desired cell */
						var desired_cell = worksheet[titleCells[int]];

						/* Get the value */
						var desired_value = desired_cell.v;
						rawData[int] = desired_value;

					}

					var Str = "";
					Str += '<tr>';
					Str += '<td>' + rawData[0] + '</td>';
					Str += '<td>' + rawData[1] + '</td>';
					Str += '<td>' + rawData[2] + '</td>';
					Str += '<td>' + rawData[3] + '</td>';
					Str += '<td>' + rawData[4] + '</td>';
					Str += '<td>' + rawData[5] + '</td>';
					Str += '<td>' + rawData[6] + '</td>';

					Str += '</tr>';
					$('#xlstable > tbody:last-child').append(Str);

				}
			} catch (err) {
				var rowCount = $('#xlstable tr').length;
				$.alert({
					title : 'Great Work',
					content : rowCount - 1 + " Rows found!",

				});
			}
		};

		reader.readAsBinaryString(f);

	}
	;

}
/*function name() {

	$.ajax({
		type : "GET",
		url : "oder/getAll",
		data : "",
		dataType : "json",
		//async : false,
		error : function(val) {

		},
		success : function(text) {
			console.log(text);
		}

	});
}*/

function setDailyTarget() {
	var table = $("#xlstable tbody");
		

		table
				.find('tr')
				.each(
						function(i) {
							var $tds = $(this).find('td'), module = $tds.eq(0)
									.text(), style = $tds.eq(1).text(), salesOder = $tds
									.eq(2).text();
							lineItem = $tds.eq(3).text(), size = $tds.eq(4).text(),
									oderQty = $tds.eq(5).text();
							dayQty = $tds.eq(6).text(), grnQty = $tds.eq().text(),
					

							$.ajax({
								type : "GET",
								url : "oder/setDailyTarget",
								type : 'POST',
								data : {
									module : module,
									style : style,
									salesOder : salesOder,
									lineItem : lineItem,
									size : size,
									oderQty : "0",
									dayQty : dayQty,
									allowedQuantity : oderQty,
									grnQty : "0"
								},
								dataType : "json",
								//async : false,
								error : function(val) {
									//console.log(val);
								},
								success : function(text) {
								//console.log(text);
								}

							});

						});
		
	}
function updateData() {

	
	
	var table = $("#xlstable tbody");
	

	table
			.find('tr')
			.each(
					function(i) {
						var $tds = $(this).find('td'), module = $tds.eq(0)
								.text(), style = $tds.eq(1).text(), salesOder = $tds
								.eq(2).text();
						lineItem = $tds.eq(3).text(), size = $tds.eq(4).text(),
								oderQty = $tds.eq(5).text();
						dayQty = $tds.eq(6).text(), grnQty = $tds.eq().text(),
				

						$.ajax({
							type : "GET",
							url : "oder/add",
							type : 'POST',
							data : {
								module : module,
								style : style,
								salesOder : salesOder,
								lineItem : lineItem,
								size : size,
								oderQty :oderQty ,
								dayQty : dayQty,
								allowedQuantity : oderQty,
								grnQty : "0",
								status:"pending",
								ginQty:"0",
								bookingQty : "0"
							},
							dataType : "json",
							//async : false,
							error : function(val) {
								//console.log(val);
							},
							success : function(text) {
							//console.log(text);
							}

						});

					});
	
	

}