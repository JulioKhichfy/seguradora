$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
	
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		
		var url = 'carros';
		var dadosCarro = $('#form-carro').serialize();
		
		$.post(url, dadosCarro)
			.done(function(pagina){
				$('#secao-carros').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-carro').modal('hide');
				//$('.modal-backdrop').remove();
			});
	});
	
}

function getDataParaEdicao(date2Edit){

    var now = new Date(date2Edit);
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var d = now.getFullYear()+"-"+(month)+"-"+(day) ;

    return d;
}



var limparModal = function(){
	$('#id').val('');
	$('#marca').val('');
	$('#modelo').val('');
	$('#placa').val('');
	$('#anoFabricacao').val('');
	$('#preco').val('');
	$('#categoriaCombustivel option').attr('selected', false);
	//$('#categoriaCombustivel').val('');
	$('#categoriaCarroceria option').attr('selected', false);
	//$('#categoriaCarroceria').val('');
};


var aplicarListeners = function(){
	$('#modal-carro').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		
		var id = $(this).parents('tr').data('id');
		
		var url = 'carros/'+id;
		
		$.get(url).then(function (carro,success)
			{
				$('#id').val(carro.id);
				$('#marca').val(carro.marca);
				$('#modelo').val(carro.modelo);
				$('#placa').val(carro.placa);
				
				var date2Edit = getDataParaEdicao(carro.anoFabricacao);
			    $('#anoFabricacao').val(date2Edit);
				
			    $('#preco').val(carro.preco);
			    $('#categoriaCombustivel').val(carro.categoriaCombustivel);
			    $('#categoriaCarroceria').val(carro.categoriaCarroceria);
				
				$('#modal-carro').modal('show');
			});
	});
	
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "carros/"+id,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var carros = parseInt( $('#quantidade-carros').text() );
		    	$('#quantidade-carros').text(carros - 1);
		    }
		});
		
		
	});
	
}