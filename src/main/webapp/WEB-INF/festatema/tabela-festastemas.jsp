<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table class="table table-hover table-condensed table-bordered">
			<thead>
				<tr>
					<td  style="width: 5%">Id</td>
					<td  style="width: 30%">Nome</td>
					<td  style="width: 5%">descricao</td>
					<td  style="width: 10%">categoriaTema</td>
					<td  style="width: 30%">artefatos</td>
					<td  style="width: 10%">preco</td>
					<td  style="width: 10%">dataDeReserva</td>
					<td  style="width: 10%">disponibilidade</td>
					<td style="width: 10%">Editar</td>
					<td style="width: 10%">Deletar</td>
				</tr>
			</thead>
			<tbody>
					
				<c:forEach items="${festastemas}" var="festatema">
					<tr data-id="${festatema.id}">
						 <td>${festatema.id}</td>
						 <td>${festatema.nome}</td>
						 <td>${festatema.descricao}</td>
						 <td>${festatema.categoriaTema}</td>
						 <td>
							<c:forEach items="${festatema.artefatos}" var="artefato">
								${artefato.id} ${artefato.nome}</br>
							</c:forEach>
						</td>
						<td>${festatema.preco}</td>
						 <td>
						 	<fmt:formatDate pattern="yyyy-MM-dd" value="${festatema.dataDeReserva}" />
						 </td>
					
						<td>${festatema.disponibilidade}</td>
						 <td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
						 <td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
					</tr>
				</c:forEach>
				
			</tbody>
			<tfoot>
				
				<tr>
					<td colspan="10">Festas Temas cadastradas: <span id="quantidade-festastemas">${festastemas.size()}</span></td>
				</tr>
				<tr>
					<td colspan="10">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#modal-festatema">Cadastrar Festa Tema</button>
					</td>
				</tr>
				
				
			</tfoot>
		</table>
	