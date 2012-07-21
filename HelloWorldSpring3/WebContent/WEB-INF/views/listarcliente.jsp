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
	<title>Lista de Clientes</title>
</head>
	<body> 
	<div class="center_content">
		<h1>Clientes</h1> <p>
		<form action="verRegistroCliente.jsp" method="get">
			<input type="submit" name="btnNuevo" id="btnNuevo" value="Nuevo" />
		</form>
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<td>Editar</td>
				<td>Eliminar</td>

			</tr>
			
			<c:forEach items="${model.clientes}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.nombre}</td>
				<td>${prod.apellidopaterno}</td>
				<td>${prod.apellidomaterno}</td>
				<td>${prod.direccion}</td>
				<td>${prod.telefono}</td>
				<td align="center"><a
						href="editarCliente.jsp?id=${prod.codigo}"> <img
							src="images/editar.jpg" alt="" title="" border="0" />
					</a></td>
				<td align="center"><a
						href="eliminarCliente.jsp?id=${prod.codigo}"><img
							src="images/delete.gif" alt="" title="" border="0" /></a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		</div>
	</body>
</html>