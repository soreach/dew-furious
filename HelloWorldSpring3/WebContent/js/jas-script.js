 $(function(){
	 
        $('.row').each(function(){

    		$(this).find('.span6').first().css('width', '354px');
        });
        
        
        $('#btnNew').click(function(){
        	
        	var urlRegister ='';
        	
        	switch($(this).attr('flag'))
        	{
        		case 'Prospecto':
        			urlRegister = 'verRegistroCliente.jsp';
        			break;
        		case 'Doctor':
        			urlRegister = 'verRegistroDoctor.jsp';
        			break;
        		
        	}
        	
        	
        	$.ajax({
                url: urlRegister,
                success:  function (response) {
                        $(".modal-body").html(response);
                }
        	 });
     	
        	
        });
        
        
        
});