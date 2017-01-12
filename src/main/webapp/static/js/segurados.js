$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		
		var url = 'segurados';
		var dadosSegurado = $('#form-segurado').serialize();
		
		$.post(url, dadosSegurado)
			.done(function(pagina){
				$('#secao-segurados').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-segurado').modal('hide');
				//$('.modal-backdrop').remove();
			});
	});
}

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#idade').val('');
	$('#categoriaSexo').val('');
	$('#carros option').attr('selected', false);
};

var aplicarListeners = function(){
	$('#modal-segurado').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		
		var id = $(this).parents('tr').data('id');
		
		var url = 'segurados/'+id;
		
		$.get(url).then(function (segurado,success)
			{
				$('#id').val(segurado.id);
				$('#nome').val(segurado.nome);
				$('#idade').val(segurado.idade);
				$('#categoriaSexo').val(segurado.categoriaSexo);
				$('#carros').val(segurado.carros);
				
				segurado.carros.forEach(function(carro){
					var id = carro.id;
					$('#carros option[value='+id+']').attr('selected', true);
				});
				
				$('#modal-segurado').modal('show');
			});
	});
	
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "segurados/"+id,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var segurados = parseInt( $('#quantidade-segurados').text() );
		    	$('#quantidade-segurados').text(segurados - 1);
		    }
		});
		
		
	});
	
}