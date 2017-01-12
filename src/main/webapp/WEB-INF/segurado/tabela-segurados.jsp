<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table class="table table-hover table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<td  style="width: 5%">Id</td>
					<td  style="width: 30%">Nome</td>
					<td  style="width: 5%">Idade</td>
					<td  style="width: 10%">categoriaSexo</td>
					<td  style="width: 30%">Carros</td>
					<td style="width: 10%">Editar</td>
					<td style="width: 10%">Deletar</td>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${segurados}" var="segurado">
				<tr data-id="${segurado.id}">
					 <td>${segurado.id}</td>
					 <td>${segurado.nome}</td>
					 <td>${segurado.idade}</td>
					 <td>${segurado.categoriaSexo}</td>
					 <td>
						<c:forEach items="${segurado.carros}" var="carro">
							${carro.modelo} ${carro.marca} ${carro.placa} </br>
						</c:forEach>
					</td>
					 <td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
					 <td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
				</tr>
			</c:forEach>
				
			</tbody>
			<tfoot>
				
				<tr>
					<td colspan="7">Segurados cadastrados: <span id="quantidade-segurados">${segurados.size()}</span></td>
				</tr>
				<tr>
					<td colspan="7">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#modal-segurado">Cadastrar Segurado</button>
					</td>
				</tr>
				
				
			</tfoot>
		</table>
	