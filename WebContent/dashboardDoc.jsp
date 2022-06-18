<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Pacientes</title>
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
				<li><a href="<%=request.getContextPath()%>/PacienteServlet?action=cerrar" class="navbar-brand">Cerrar Sesión</a></li>
			</ul>
			</nav>
			<img style="width:600px; display:block; margin-left: auto; margin-right:auto;" src="img/logo.jpg"/>
	</header>
	<br />
	<div class="row">
		<div class="container">
		<h3 class="text-center">Bienvenido <%=request.getSession().getAttribute("username")%></h3>
			<h3 class="text-center">Listado de Pacientes</h3>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Cédula</th>
						<th>Teléfono</th>
						<th>Correo</th>
						<th>Procedimientos</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="paciente" items="${listPacientes}">
						<tr>
							<td><c:out value="${paciente.username}" /></td>
							<td><c:out value="${paciente.cedula}" /></td>
							<td><c:out value="${paciente.telefono}" /></td>
							<td><c:out value="${paciente.email}" /></td>
							<td><a class="btn btn-success" href="<%=request.getContextPath()%>/PacienteServlet?action=sp&id=<c:out value='${paciente.id}'/>">Ver</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td><a class="btn btn-success" href="<%=request.getContextPath()%>/PacienteServlet?action=delete&id=<c:out value='${paciente.id}'/>">Eliminar</a>
							<a class="btn btn-success" href="<%=request.getContextPath()%>/PacienteServlet?action=editPaciente&cedula=<c:out value='${paciente.cedula}'/>">Actualizar datos</a>
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="<%=request.getContextPath()%>/PacienteServlet?action=newPaciente" class="btn btn-success">Agregar</a>
		</div>
	</div>
</body>
</html>