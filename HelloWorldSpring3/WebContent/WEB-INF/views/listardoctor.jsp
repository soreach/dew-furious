<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <!DOCTYPE html >
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>
	<title>Lista de Doctores</title>
</head>
	<body> 
	<div class="center_content">
		<h1>Doctores</h1> <p>
		<form action="verRegistroDoctor.jsp" method="get">
			<input type="submit" name="btnNuevo" id="btnNuevo" value="Nuevo" />
		</form>
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<td>Editar</td>
				<td>Eliminar</td>

			</tr>
			
			<c:forEach items="${model.personas}" var="prod">
			<tr>
				<td width="100">${prod.nombre}</td>	
				<td>${prod.paterno}</td>
				<td>${prod.materno}</td>			
				<td align="center"><a
						href="editarDoctor.jsp?id=${prod.doctorID}"> <img
							src="images/editar.jpg" alt="" title="" border="0" />
					</a></td>
				<td align="center"><a
						href="eliminarDoctor.jsp?id=${prod.doctorID}"><img
							src="images/delete.gif" alt="" title="" border="0" /></a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		</div>
	</body>
</html>