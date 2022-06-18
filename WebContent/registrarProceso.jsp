<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
			<div>
				<a href ="<%=request.getContextPath()%>/ProcesoServlet?action=cerrar" class="navbar-brand">Cerrar Sesión</a>
			</div>
		</nav>
		<img style="width:600px; display:block; margin-left: auto; margin-right:auto;" src="img/logo.jpg"/>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="ProcesoServlet?action=insert" method="post">
				<fieldset class="form-group">
					<label>Nombre del procedimiento</label><input type="text" class ="form-control" name="processname" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Código del procedimiento</label><input type="text" class ="form-control" name="codigo" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Valor</label><input type="text" class ="form-control" name="value" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Observación</label><input type="text" class ="form-control" name="observation" required="required">
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
				<a href="<%=request.getContextPath()%>/ProcesoServlet?action=list" class="btn btn-success">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
	<script src="js/script.js"></script>
</body>
</html>