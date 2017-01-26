<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
function setaDadosModal(valor) {
    document.getElementById('id_image').value = valor;
}
</script>

<div class="modal fade" id="modal-imagem" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form method="post" action="doUpload" enctype="multipart/form-data">
				
				<div class="modal-header">
					<h4 class="modal-title">Imagens do Artefato</h4>
				</div>
				<div class="modal-body">
				
					<input id="id_image" name="id_image" type="text">
				
					<input type="text" name="campo" id="campo">
		            <table border="1">
		                <tr>
		                    <td>Foto #1:</td>
		                    <td><input type="file" name="fileUpload" size="50" /></td>
		                </tr>
		                <tr>
		                    <td>Foto #2:</td>
		                    <td><input type="file" name="fileUpload" size="50" /></td>
		                </tr>
		                <tr>
		                    <td>Foto #3:</td>
		                    <td><input type="file" name="fileUpload" size="50" /></td>
		                </tr>
		                <tr>
		                    <td>Foto #4:</td>
		                    <td><input type="file" name="fileUpload" size="50" /></td>
		                </tr>
		                <tr>
		                    <td>Foto #5:</td>
		                    <td><input type="file" name="fileUpload" size="50" /></td>
		                </tr>
		            </table>
	            </div>
	            <input id="id_image" name="id_image" type="hidden">
				<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" value="Upload" /> Clique aqui para salvar as fotos
				</div>
	        </form>
		</div>
	</div>
</div>