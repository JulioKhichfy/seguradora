<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-carro" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-carro" method="post" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Carro</h4>
				</div>
				<div class="modal-body">
					<label for="marca">Marca: </label>
					<input id="marca" name="marca" class="form-control">
					
					<label for="modelo">Modelo: </label>
					<input id="modelo" name="modelo" class="form-control">
					
					<label for="placa">Placa: </label>
					<input id="placa" name="placa" class="form-control">
					
					<label for="anoFabricacao">Ano Fabricação: </label>
					<input type="date" id="anoFabricacao" name="anoFabricacao" class="form-control">
					
					<label for="preco">Preço: </label>
					<input id="preco" name="preco" class="form-control">
					
					<label for="categoriaCombustivel">Combustivel: </label>
					<select id="categoriaCombustivel" name="categoriaCombustivel" class="form-control" >
						<c:forEach items="${categoriaCombustivel}" var="catcomb">
							<option value="${catcomb}">${catcomb}</option>
						</c:forEach>
					</select>
					
					<label for="categoriaCarroceria">Carroceria: </label>
					<select id="categoriaCarroceria" name="categoriaCarroceria" class="form-control">
						<c:forEach items="${categoriaCarroceria}" var="catcar">
							<option value="${catcar}">${catcar}</option>
						</c:forEach>
					</select>
					
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