<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/api/cadastrar" var="saveURL" />
		<h2>Produtos</h2>
		<form:form modelAttribute="produtoForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="idProduto" />
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" cssClass="form-control" id="nome" />
			</div>
			<div class="form-group">
				<label>Tipo Produto</label>
				<form:input path="tipo" cssClass="form-control" id="tipo" />
			</div>
			<button type="submit" class="btn btn-primary">Salvar</button>
		</form:form>

	</div>
</body>
</html>