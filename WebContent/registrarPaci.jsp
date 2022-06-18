<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de paciente</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
			<div>
				<a href ="<%=request.getContextPath()%>/PacienteServlet?action=list" class="navbar-brand">Regresar</a>
			</div>
		</nav>
		<img style="width:600px; display:block; margin-left: auto; margin-right:auto;" src="img/logo.jpg"/>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<caption>
				 <c:if test="${usuario != null}">
					<form action="PacienteServlet?action=update" method="post"></c:if>
				<c:if test="${usuario == null}">
					<form action="PacienteServlet?action=insert" method="post"></c:if>
			</caption>
			
				<fieldset class="form-group">
					<label>Nombre del paciente</label><input type="text" class ="form-control" name="username" 
							value="<c:out value='${paciente.username}'/>" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Cédula</label><input type="text" class ="form-control" name="cedula"
							value="<c:out value='${paciente.cedula}'/>" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Teléfono</label><input type="text" class ="form-control" name="telefono" 
							value="<c:out value='${paciente.telefono}'/>" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label><input type="text" class ="form-control" name="email"
							value="<c:out value='${paciente.email}'/>" required="required">
				</fieldset>
				<fieldset>
				 <input type="file" name="archivo" />
				</fieldset>
  				 <br>
				<button type="submit" class="btn btn-success">Guardar</button>
				<a href="<%=request.getContextPath()%>/PacienteServlet?action=list" class="btn btn-success">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>