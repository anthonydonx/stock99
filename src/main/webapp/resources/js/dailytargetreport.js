$(function() {
	$("#exbutton").click(function(){
		  $("#dev-table").table2excel({
		    // exclude CSS class
		    exclude: ".noExl",
		    name: "Excel Document Name"
		  }); 
		});
    $("#datepicker").on("change",function(){
        var selected = $(this).val();
      getDailyTargetDetailsByDate(selected);
    });
});

function getDailyTargetDetailsByDate(selectedDate) {
	var formData = {};
	formData.selectedDate = selectedDate;
	$.ajax({
		type : "GET",
		url : "dailyoders/getDailyTargetDetailsByDate",
		data : formData,
		dataType : "json",
		error : function(val) {

		},
		success : function(text) {
			$("#dev-table > tbody").html("");
			if (text.Data != "Empty") {
				for (var int = 0; int < text.Data.length; int++) {
					var RowNumber = $('#dev-table tr').length;
					var dailyId = text.Data[int].dailyId;
					var dayIss = text.Data[int].dayIss;
					var dayQty = text.Data[int].dayQty;
					var oderId = text.Data[int].orders.oderId;
					var style = text.Data[int].orders.style;
					var salesOder = text.Data[int].orders.salesOder;
					var allowedQuantity = text.Data[int].orders.allowedQuantity;
					
					var Str = "";
					Str += '<tr>';
					Str += '<td>' + dailyId + '</td>';
					Str += '<td>' + oderId + '</td>';
					Str += '<td>' + style + '</td>';
					Str += '<td>' +salesOder  + '</td>';
					Str += '<td>' + allowedQuantity + '</td>';
					Str += '<td>' + dayQty + '</td>';
					Str += '<td>' + dayIss + '</td>';
					

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