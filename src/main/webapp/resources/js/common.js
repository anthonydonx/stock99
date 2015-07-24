function autocompleteFill(url,feildid,valueid,name,dataid){
	$.get(url,{},function(data){
		var dataArray=[];
		var dataMap=[];
		$(data.Data).each(function(iIndex, sElement) {
			if(!dataMap[sElement[dataid]]){
				dataArray.push( {
					label: sElement[name] ,
					value: sElement[dataid]
				});
				dataMap[sElement[dataid]]=sElement[dataid];
			}
		});
		
		$( "#"+feildid ).autocomplete(
		{
			source:dataArray,
			minLength: 0,
			
			select: function( event, ui ) {
				$( "#"+feildid ).val( ui.item.label );
				$( "#"+valueid ).val( ui.item.value );
				
				return false;
			},
			focus: function ( e, ui ) {
				$( "#"+feildid ).val( ui.item.label );	
	                  return false;
      		}
		}).focus(function() {
			 $("#"+feildid).val('');
		    $("#"+feildid).autocomplete("search");
		});
		  
	
	});

}

/**
*   I don't recommend using this plugin on large tables, I just wrote it to make the demo useable. It will work fine for smaller tables 
*   but will likely encounter performance issues on larger tables.
*
*		<input type="text" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Developers" />
*		$(input-element).filterTable()
*		
*	The important attributes are 'data-action="filter"' and 'data-filters="#table-selector"'
*/
(function(){
    'use strict';
	var $ = jQuery;
	$.fn.extend({
		filterTable: function(){
			return this.each(function(){
				$(this).on('keyup', function(e){
					$('.filterTable_no_results').remove();
					var $this = $(this), 
                        search = $this.val().toLowerCase(), 
                        target = $this.attr('data-filters'), 
                        $target = $(target), 
                        $rows = $target.find('tbody tr');
                        
					if(search == '') {
						$rows.show(); 
					} else {
						$rows.each(function(){
							var $this = $(this);
							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
						})
						if($target.find('tbody tr:visible').size() === 0) {
							var col_count = $target.find('tr').first().find('td').size();
							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
							$target.find('tbody').append(no_results);
						}
					}
				});
			});
		}
	});
	$('[data-action="filter"]').filterTable();
})(jQuery);

$(function(){
    // attach table filter plugin to inputs
	$('[data-action="filter"]').filterTable();
	
	$('.container').on('click', '.panel-heading span.filter', function(e){
		var $this = $(this), 
			$panel = $this.parents('.panel');
		
		$panel.find('.panel-body').slideToggle();
		if($this.css('display') != 'none') {
			$panel.find('.panel-body input').focus();
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
})
