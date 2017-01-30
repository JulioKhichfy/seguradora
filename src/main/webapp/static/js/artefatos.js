$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
	
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		
		var url = 'artefatos';
		var dadosArtefato = $('#form-artefato').serialize();
		
		$.post(url,dadosArtefato)
			.done(function(pagina){
				$('#secao-artefatos').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-artefato').modal('hide');
				// $('.modal-backdrop').remove();
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

function deletarImagem(data){
	
	$.ajax({
		url : "imagens/deletarImagemArtefato/"+data,
		type: 'DELETE',
		headers: {'X-CSRF-TOKEN': csrf},
	    success: function(result) {
	    	
	    	$('img[data-id="'+data+'"]').remove();
	    	$('button[data-id="'+data+'"]').remove();
	    	$( 'br[data-id="'+data+'"]' ).remove();

	    }
	});
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
				$('#categoriaCor').val(artefato.categoriaCor);
				$('#categoriaMaterial').val(artefato.categoriaMaterial);
				$('#categoriaTipoArtefato').val(artefato.categoriaTipoArtefato);
				$('#quantidade').val(artefato.quantidade);
				$('#peso').val(artefato.peso);
				$('#preco').val(artefato.preco);
				$('#quantidade').val(artefato.quantidade);
				var date2Edit = getDataParaEdicao(artefato.dataDeReserva);
			    $('#dataDeReserva').val(date2Edit);
			    $('#disponibilidade').val(artefato.disponibilidade);
				$('#modal-artefato').modal('show');
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
	
	$(".btn-listar-imagem").on("click", function() {
		var idArtefato = $(this).parents('tr').data('id');
		var url = 'imagens/buscarImagensArtefato/'+idArtefato;

		$("#imagediv img").remove();
		$("#imagediv button").remove();

		$.get(url).then(function (imageList,success)
		{
			
			for (let index = 0; index < imageList.length; ++index) {
			
				
				
				var img = $('<img>'); // Equivalent $(document.createElement('img'))
					img.attr('id', imageList[index].id);
					img.attr('width', 100);
					img.attr('height', 100);
					img.attr('data-id', imageList[index].id);
				
				var btn = $('<button>');
					btn.attr('type', 'button');
					btn.attr('class', 'btn btn-danger btn-deletar-imagem');
					btn.attr('data-id',imageList[index].id);
					$(btn).html("Remover");
					btn.attr('onclick' , 'deletarImagem('+imageList[index].id+')' );
				
					if(imageList[index].fileName.split('.')[1] == "png")
					{
						img.attr('src', "data:image/png;base64," + imageList[index].data);
					}
					else if(imageList[index].fileName.split('.')[1] == "jpg")
					{
						img.attr('src', "data:image/jpg;base64," + imageList[index].data);
					}
					
					var br = $('<br>');
					br.attr('data-id', imageList[index].id);
					
					$("#imagediv").append(img);
					$("#imagediv").append(btn);
					$("#imagediv").append(br);
			}
			
			//$("#imagediv").append(content);
			$('#modal-exibir-imagem').modal('show');
					
		});
	    
	});
	
}