$(document).ready(function() {
	boxPanel();
	drawChart();
});


function boxPanel() {
	$( '#boxpanel' ).empty();
	var Str = "";
		Str += '<div class="col-md-3">';// style="padding-left: 0px;"
		Str += '<div class="info-box bg-aqua">';
		Str += '<span class="info-box-icon glyphicon glyphicon-home"> </span>';
		Str += '<div class="info-box-content">';
		Str += '<span class="info-box-text">Oder / Allowed</span> ';
		Str += '<span class="info-box-number">7743</span>';
		Str += '<div class="progress">';
		Str += '<div class="progress-bar" style="width:10%"></div>';
		Str += '</div>';
		Str += '<span class="progress-description"> 90% pending';
		Str += '</span></div></div></div>';
		
		
		
//		Str += '</tr>';

	/*Secound panel*/
		Str += '<div class="col-md-3">';
		Str += '<div class="info-box bg-green">';
		Str += '<span class="info-box-icon glyphicon glyphicon-home"> </span>';
		Str += '<div class="info-box-content">';
		Str += '<span class="info-box-text">GRN Quantity</span> ';
		Str += '<span class="info-box-number">554</span>';
		Str += '</div></div></div>';
	  
		
		/*thired panel*/
		Str += '<div class="col-md-3">';
		Str += '<div class="info-box  bg-yellow">';
		Str += '<span class="info-box-icon glyphicon glyphicon-home"> </span>';
		Str += '<div class="info-box-content">';
		Str += '<span class="info-box-text">GIN Quantity</span> ';
		Str += '<span class="info-box-number">33</span>';
		Str += '</div></div></div>';
		
		/*Fourth panel*/
		Str += '<div class="col-md-3">';
		Str += '<div class="info-box  bg-red">';
		Str += '<span class="info-box-icon glyphicon glyphicon-home"> </span>';
		Str += '<div class="info-box-content">';
		Str += '<span class="info-box-text">Booked/Res:</span> ';
		Str += '<span class="info-box-number">112</span>';
		Str += '</div></div></div>';
		
		
		
		
		
		
		$('#boxpanel').append(Str);
}
function drawChart() {
	var barData = {
		    labels: ['1034574', '1034575', '1074474', '1084065', '1634065', '1534065'],
		    datasets: [
		        {
		            label: 'Total Quantity #',
		            fillColor: '#382765',
		            data: [2500, 1902, 1221, 610, 1245, 952]
		        },
		        {
		            label: 'Allowed Quantity #',
		            fillColor: '#7BC225',
		            data: [500, 400, 270, 432, 1199, 55]
		        },
		        {
		            label: 'GRN Quantity #',
		            fillColor: '#FF0000',
		            data: [1000, 1689, 332, 589, 1199, 451]
		        }
		        ,
		        {
		            label: 'GIN Quantity #',
		            fillColor: '#FF9900',
		            data: [500, 300, 1318, 111, 987, 1436]
		        },
		        {
		            label: 'Booking Quantity #',
		            fillColor: '#003300',
		            data: [500, 333, 888, 589, 1199, 324]
		        }
		    ]
		};
	var context = document.getElementById('clients').getContext('2d');
	var clientsChart = new Chart(context).Bar(barData);
}