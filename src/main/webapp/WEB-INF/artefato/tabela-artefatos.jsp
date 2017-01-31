<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<fmt:setLocale value="pt_BR" />

<p class="text-info">Objetos</p>
<table class="table table-hover table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<td  style="width: 5%">Id</td>
					<td  style="width: 10%">nome</td>
					<td  style="width: 10%">descricao</td>
					<td  style="width: 10%">categoriacor</td>
					<td  style="width: 10%">categoriaMaterial</td>
					<td  style="width: 10%">categoriatipoArtefato</td>
					<td  style="width: 5%">quantidade</td>
					<td  style="width: 5%">peso</td>
					<td  style="width: 5%">dimensao</td>
					<td  style="width: 5%">preco</td>
					<td  style="width: 5%">dataDeReserva</td>
					<td  style="width: 5%">disponibilidade</td>
					<td  style="width: 5%">Imagem</td>
					<td style="width: 5%">Editar</td>
					<td style="width: 5%">Deletar</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${artefatos}" var="artefato">
				<tr data-id="${artefato.id}">
					 <td>${artefato.id}</td>
					 
    				 <td>
    				 	<button type="button" class="btn btn-warning btn-listar-imagem">${artefato.nome}</button>
    				 </td>
					 
					 <td>${artefato.descricao}</td>
					 <td>${artefato.categoriaCor}</td>
					 <td>${artefato.categoriaMaterial}</td>
					 <td>${artefato.categoriaTipoArtefato}</td>
					 <td>${artefato.quantidade}</td>
					 <td>${artefato.peso}</td>
					 <td>${artefato.dimensao}</td>
					 <td>
					 	<fmt:formatNumber value="${artefato.preco}" type="currency"/>
					 </td>
					 <td>
					 	<fmt:formatDate pattern="yyyy-MM-dd" value="${artefato.dataDeReserva}" />
					 </td>
					  <td>${artefato.disponibilidade}</td>
					
					 <!--<a href="modal-imagem.jsp" data-remote="false" data-toggle="modal" data-target="#modal-imagem" class="btn btn-default">
    					imagem - ${artefato.id}
					</a> -->
					 <!-- <button type="button" class="btn btn-info btn-upimg">Imagem</button> -->
					
					 <td><button type="button" data-toggle="modal" data-target="#modal-imagem" class="btn btn-info btn-upimg" onclick="setaDadosModal(${artefato.id})">Imagem</button></td> 
					 <td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
					 <td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
				</tr>
			</c:forEach>
				
			</tbody>
			<tfoot>
				
				<tr>
					<td colspan="15">Artefatos cadastrados: <span id="quantidade-artefatos">${artefatos.size()}</span></td>
				</tr>
				<tr>
					<td colspan="15">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#modal-artefato">Cadastrar Artefato</button>
					</td>
				</tr>
				
				
			</tfoot>
		</table>
		
		
	