<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<fmt:setLocale value="pt_BR" />
<table class="table table-hover table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<td  style="width: 10%">Id</td>
					<td  style="width: 10%">Marca</td>
					<td  style="width: 10%">Modelo</td>
					<td  style="width: 10%">Placa</td>
					<td  style="width: 10%">Ano de Fabricação</td>
					<td  style="width: 10%">Preço</td>
					<td  style="width: 10%">Tipo de Combustivel</td>
					<td  style="width: 10%">Tipo de Carroceria</td>
					<td style="width: 10%">Editar</td>
					<td style="width: 10%">Deletar</td>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${carros}" var="carro">
				<tr data-id="${carro.id}">
					 <td>${carro.id}</td>
					 <td>${carro.marca}</td>
					 <td>${carro.modelo}</td>
					 <td>${carro.placa}</td>
					 <td>
					 	<fmt:formatDate pattern="yyyy-MM-dd" value="${carro.anoFabricacao}" />
					 </td>
					 
					 <td>
					 	<fmt:formatNumber value="${carro.preco}" type="currency"/>
					 </td>
					 <td>${carro.categoriaCombustivel}</td>
					 <td>${carro.categoriaCarroceria}</td>
					 <td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
					 <td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
				</tr>
			</c:forEach>
				
			</tbody>
			<tfoot>
				
				<tr>
					<td colspan="10">Carros cadastrados: <span id="quantidade-carros">${carros.size()}</span></td>
				</tr>
				<tr>
					<td colspan="10">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#modal-carro">Cadastrar Carro</button>
					</td>
				</tr>
				
				
			</tfoot>
		</table>
	