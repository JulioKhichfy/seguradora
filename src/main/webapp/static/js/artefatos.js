$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
	
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		
		var url = 'artefatos';
		var dadosArtefato = $('#form-artefato').serialize();
		
		$.post(url, dadosArtefato)
			.done(function(pagina){
				$('#secao-artefatos').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-artefato').modal('hide');
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
	$('#nome').val('');
	$('#descricao').val('');
	$('#categoriacor option').attr('selected', false);
	$('#categoriaMaterial option').attr('selected', false);
	$('#categoriatipoArtefato option').attr('selected', false);
	$('#quantidade').val('');
	$('#peso').val('');
	$('#dimensao').val('');
	$('#preco').val('');
	$('#dataDeReserva').val('');
	$('#disponibilidade').val(true);
};


var aplicarListeners = function(){
	$('#modal-artefato').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		
		var id = $(this).parents('tr').data('id');
		
		var url = 'artefatos/'+id;
		
		$.get(url).then(function (artefato,success)
			{
				$('#id').val(artefato.id);
				$('#nome').val(artefato.nome);
				$('#descricao').val(artefato.descricao);
				$('#categoriaCombustivel').val(artefato.categoriacor);
				$('#categoriaCombustivel').val(artefato.categoriaMaterial);
				$('#categoriaCombustivel').val(artefato.categoriatipoArtefato);
				$('#quantidade').val(artefato.quantidade);
				$('#peso').val(artefato.peso);
				$('#preco').val(artefato.preco);
				$('#quantidade').val(artefato.quantidade);
				var date2Edit = getDataParaEdicao(artefato.dataDeReserva);
			    $('#dataDeReserva').val(date2Edit);
			    $('#disponibilidade').val(artefato.disponibilidade);
				$('#modal-carro').modal('show');
			});
	});
	
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "artefatos/"+id,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var artefatos = parseInt( $('#quantidade-artefatos').text() );
		    	$('#quantidade-artefatos').text(artefatos - 1);
		    }
		});
		
		
	});
	
}