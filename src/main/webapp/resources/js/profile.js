jQuery(document).ready(function(){
		$( "#project" ).combogrid({
		url: 'oder/getAll',
		debug:true,
    //replaceNull: true,
		colModel: [{'columnName':'style','width':'10','label':'style'}],
		select: function( event, ui ) {
			$( "#project" ).val( ui.item.Data[0].style );
			return false;
		}
	});
		$("input[type=file]").on('change',function(){
			 readURL(this);
			var formData = {};
			 var formData = new FormData($('#imagesend')[0]);
			$.ajax({
				type : "POST",
				url : "profile/upload",
				data : formData,
				 cache: false,
			        contentType: false,
			        processData: false,
				error : function(val) {
					alert("Error in Upload !");
				},
				success : function(text) {
				if(text.success==true){
							 
					alert("Change Image !");
				}else{
					alert("Error in Upload !");
				}
				
				}

			});
		});
		
	
		
});

$('input.geo-autocomplete').remoteList({
	maxLength: 9,
	source: function(val, response){
		$.ajax({
			url: 'oder/getAll',
			dataType: 'json',
			/*data: {
				q: val,
				key: '37693c',
				nl: true
			},*/
			success: function(data){
				$.each(data.Data, function(i, item){
					item.value = item.style;
				});
				response(data.Data);
			}
		});
	},
	select: function(){
		if(window.console){
			console.log($(this).remoteList('selectedOption'), $(this).remoteList('selectedData'))
		}
	}
});
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
        	var output = document.getElementById('imageview');
        	output.src = reader.result;
          //  $('#imagesend').attr('src', e.target.result);
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}