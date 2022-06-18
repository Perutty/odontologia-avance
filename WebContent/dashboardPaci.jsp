<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Procedimientos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/PacienteServlet?action=list" class="navbar-brand">Regresar</a></li>
			</ul>
			</nav>
			<img style="width:600px; display:block; margin-left: auto; margin-right:auto;" src="img/logo.jpg"/>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Procedimientos realizados</h3>
			<br>
			
		 	<br>
		 	<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Código</th>
						<th>Valor</th>
						<th>Fecha</th>
						<th>Observación</th>
						<th>Acciones</th>
						<th>Firma</th>
						<th>Foto</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="proceso" items="${listProcesos}">
						<tr>
							<td><c:out value="${proceso.processname}" /></td>
							<td><c:out value="${proceso.codigo}" /></td>
							<td><c:out value="${proceso.value}" /></td>
							<td><c:out value="${proceso.date_process}" /></td>
							<td><c:out value="${proceso.observation}" /></td>
							<td><a href="<%=request.getContextPath()%>/ProcesoServlet?action=delete&id=<c:out value='${proceso.id}'/>" class="btn btn-success">Eliminar</a>
							</td>
							<td><a href="<%=request.getContextPath()%>/PacienteServlet?action=firmar" class="btn btn-success">Firmar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="<%=request.getContextPath()%>/ProcesoServlet?action=newProcess" class="btn btn-success">Agregar</a>
		</div>
	</div>
</body>
</html>