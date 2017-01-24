<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-festatema" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-festaTema" method="post" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações de festa Tema</h4>
				</div>
				<div class="modal-body">
				
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="descricao">descricao: </label>
					<input id="descricao" name="descricao" class="form-control">
				
					<label for="categoriatemas">categoriaTema: </label>
					<select id="categoriatemas" name="categoriatemas" class="form-control">
						<c:forEach items="${categoriatemas}" var="cattema">
							<option value="${cattema}">${cattema}</option>
						</c:forEach>
					</select>
					
					<label for="artefatos">artefatos: </label>
					<select id="artefatos" name="artefatos" class="form-control" multiple="multiple">
						<c:forEach items="${artefatos}" var="artefato">
							<option value="${artefato.id}">${artefato.nome}</option>
						</c:forEach>
					</select>
					
					<label for="preco">preco: </label>
					<input id="preco" name="preco" class="form-control">
					
					<label for="dataDeReserva">dataDeReserva: </label>
					<input type="date" id="dataDeReserva" name="dataDeReserva" class="form-control">
					
					<label for="disponibilidade">disponibilidade: </label>
					<input id="disponibilidade" name="disponibilidade" class="form-control">
					
					<input id="id" name="id" type="hidden">
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button  id="btn-salvar" type="button" class="btn btn-primary">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>