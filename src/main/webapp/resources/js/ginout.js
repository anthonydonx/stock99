$(document).ready(function() {
	$("#getdata").click(function() {
		getGRNDetails();
	});
	$("#sendoff").click(function() {
		issuedGRN();
	});

	
});


function getGRNDetails() {
	var GRNId=$('#barcodetext').val();
	$.ajax({
		
		type : "GET",
		url : "grnin/"+GRNId,
		data : "",
		dataType : "json",
		error : function(val) {
			$.alert({
				title : 'Alert!',
				content : 'GRN not found !',
				confirmButtonClass: 'btn-info',
			    cancelButtonClass: 'btn-danger',
				confirm : function() {
				}
			});
		},
		success : function(text) {
			if(text.Data != "Empty"){
			if (text.Data.status=='booking') {
				var Str = "";
				Str += '<tr onclick="removeRow(this);">';
				Str += '<td>' + text.Data.grninId + '</td>';
				Str += '<td>' + text.Data.quantity + '</td>';
				Str += '<td>' + text.Data.bookingUserId + '</td>';
				Str += '<td>' + text.Data.date + '</td>';
				Str += '<td>' + text.Data.bookingDate + '</td>';
				Str += '<td>' + text.Data.orders.oderId + '</td>';
				Str += '<td>' + text.Data.binLocation + '</td>';
				Str += '<td>' + text.Data.colour + '</td>';
				Str += '<td class="text-center"><input type="checkbox"></td>';
				Str += '</tr>';
				$('#gintable > tbody:last-child').append(Str);
			}else{
				$.alert({
					title : 'Alert!',
					content : 'GRN not booked !',
					confirm : function() {
					}
				});
			}
			
		}else {
			$.alert({
				title : 'Alert!',
				content : 'GRN not found !',
				confirmButtonClass: 'btn-info',
			    cancelButtonClass: 'btn-danger',
				confirm : function() {
				}
			});
		}
		}

	});
	
}

function issuedGRN() {
	var table = $("#gintable tbody");
	table.find('tr').each(function(i) {
				var $tds = $(this).find('td'),
				 grnId = $tds.eq(0).text();
				 var row = $(this);
				if (row.find('input[type="checkbox"]').is(':checked')) {
					$.ajax({
						type : "POST",
						url : "grnin/issuedGRN",
						data :{ grnId : grnId},
						dataType : "json",
						error : function(val) {},
						success : function(text) {
							alert(text);
						}

					});   
			        }
				});
}