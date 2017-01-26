<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-artefato" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-artefato" method="post" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Artefato</h4>
				</div>
				
				<div class="modal-body">
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="descricao">Descrição: </label>
					<input id="descricao" name="descricao" class="form-control">
					
					<label for="cor">Cor: </label>
					<select id="categoriaCor" name="categoriaCor" class="form-control" >
						<c:forEach items="${categoriaCor}" var="catcor">
							<option value="${catcor}">${catcor}</option>
						</c:forEach>
					</select>
					
					<label for="material">Material: </label>
					<select id="categoriaMaterial" name="categoriaMaterial" class="form-control" >
						<c:forEach items="${categoriaMaterial}" var="catmat">
							<option value="${catmat}">${catmat}</option>
						</c:forEach>
					</select>
					
					<label for="tipo">Tipo: </label>
					<select id="categoriaTipoArtefato" name="categoriaTipoArtefato" class="form-control" >
						<c:forEach items="${categoriaTipoArtefato}" var="cattipo">
							<option value="${cattipo}">${cattipo}</option>
						</c:forEach>
					</select>
					
					<label for="quantidade">Quantidade: </label>
					<input id="quantidade" name="quantidade" class="form-control">
					
					<label for="peso">Peso: </label>
					<input id="peso" name="peso" class="form-control">
					
					<label for="dimensao">Dimensão: </label>
					<input id="dimensao" name="dimensao" class="form-control">
					
					<label for="preco">Preço: </label>
					<input id="preco" name="preco" class="form-control">
					
					<label for="dataDeReserva">Data de Reserva: </label>
					<input type="date" id="dataDeReserva" name="dataDeReserva" class="form-control">
					
					<label for="disponibilidade">Disponibilidade: </label>
					<input id="disponibilidade" name="disponibilidade" class="form-control">
					
					<input id="id" name="id" type="hidden">
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-primary">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>