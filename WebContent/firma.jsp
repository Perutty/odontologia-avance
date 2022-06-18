<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Firma de consentimiento</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/ProcesoServlet?action=list" class="navbar-brand">Regresar</a></li>
			</ul>
			</nav>
			<img style="width:600px; display:block; margin-left: auto; margin-right:auto;" src="img/logo.jpg"/>
	</header>
	<div class="container col-md-5">
	<br>
	<br>
			 <p>Firme a continuación:</p>
    			<canvas id="canvas"></canvas>
    			 <br>
   				 <button id="btnLimpiar">Limpiar</button>
   				 <button id="btnDescargar">Descargar</button>
    			 <button id="btnGenerarDocumento">Pasar a documento</button>
    </div>
	<script src="js/script.js"></script>
</body>
</html>