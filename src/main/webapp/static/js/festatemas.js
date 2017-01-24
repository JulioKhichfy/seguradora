$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		
		var url = 'festastemas';
		var dadosFestaTema = $('#form-festatema').serialize();
		
		$.post(url, dadosFestaTema)
			.done(function(pagina){
				$('#secao-festastemas').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-festatema').modal('hide');
				//$('.modal-backdrop').remove();
			});
	});
}


var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#descricao').val('');
	$('#categoriaTema').val('');
	$('#artefatos option').attr('selected', false);
	$('#preco').val('');
	$('#dataDeReserva').val('');
	$('#disponibilidade').val(true);
};

var aplicarListeners = function(){
	$('#modal-festatema').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		
		var id = $(this).parents('tr').data('id');
		
		var url = 'festastemas/'+id;
		
		$.get(url).then(function (festatema,success)
			{
				$('#id').val(festatema.id);
				$('#nome').val(festatema.nome);
				$('#idade').val(festatema.descricao);
				$('#categoriaTema').val(festatema.categoriaTema);
				$('#artefatos').val(festatema.artefatos);
				$('#preco').val(festatema.preco);
				$('#dataDeReserva').val(festatema.dataDeReserva);
				$('#disponibilidade').val(festatema.disponibilidade);
				
				festatema.artefatos.forEach(function(artefato){
					var id = artefatos.id;
					$('#artefatos option[value='+id+']').attr('selected', true);
				});
				
				$('#modal-festatema').modal('show');
			});
	});
	
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "festastemas/"+id,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var festastemas = parseInt( $('#quantidade-festastemas').text() );
		    	$('#quantidade-festastemas').text(festastemas - 1);
		    }
		});
		
		
	});
	
}