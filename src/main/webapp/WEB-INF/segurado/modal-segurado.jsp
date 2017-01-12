<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-segurado" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-segurado" method="post" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Segurado</h4>
				</div>
				<div class="modal-body">
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="idade">Idade: </label>
					<input id="idade" name="idade" class="form-control">
				
					<label for="categoriaSexo">Sexo: </label>
					<select id="categoriaSexo" name="categoriaSexo" class="form-control">
						<c:forEach items="${categoriaSexo}" var="catsexo">
							<option value="${catsexo}">${catsexo}</option>
						</c:forEach>
					</select>
					
					<label for="carros">Carros: </label>
					<select id="carros" name="carros" class="form-control" multiple="multiple">
						<c:forEach items="${carros}" var="carro">
							<option value="${carro.id}">${carro.modelo}  ${carro.marca}  ${carro.placa}</option>
						</c:forEach>
					</select>
					
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