<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listas de Patrimônio</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>

<body>

	<div class="container">
		<h2>LISTA DE PATRIMÔNIO</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">marcaId</th>
				<th scope="row">Nome</th>
				<th scope="row">Descrição</th>
				<th scope="row">Nº do Tombo</th>
			</thead>
			<tbody>
				<c:forEach items="${listPatrimonio}" var="patrimonio">
					<tr>
						<td>${patrimonio.marcaId }</td>
						<td>${patrimonio.name }</td>
						<td>${patrimonio.description }</td>
						<td>${patrimonio.number }</td>
						<td><spring:url value="/api/${patrimonio.tomboId}/editar" 
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL } " role="button">Alterar</a></td>
						<td><spring:url value="/api/${patrimonio.tomboId}/excluir"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }"  role="button">Deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/api/cadastrar" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Adicionar Produto</a>
	</div>
</body>
</html>
</body>
</html>