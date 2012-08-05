<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda de Clientes</title>
<script type="text/javascript" language="javascript">
	function seleccionarcliente(codigo,nombre,paterno,materno){
		window.opener.document.getElementById("hiddencliente").value=codigo;
		window.opener.document.getElementById("txtCliente").value=paterno + ' ' + materno + ',' + nombre;
		window.close();
	}
</script>
</head>
<body>
<div class="center_content">
		<h1>Buscador de Clientes</h1> <p>
		<form action="" method="get">
		</form>
		<table border="1">
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<td>Seleccionar</td>
			</tr>
			<c:forEach items="${model.clientes}" var="prod" varStatus="i">
			<tr>
				<td>${prod.codigo}</td>
				<td width="100">${prod.nombre}</td>
				<td>${prod.apellidopaterno}</td>
				<td>${prod.apellidomaterno}</td>
				<td><a href="#" onclick='seleccionarcliente("${prod.codigo}","${prod.nombre}","${prod.apellidopaterno}","${prod.apellidomaterno}");'>Seleccionar</a></td>
			</tr>
			</c:forEach>
			
			
		</table>
		</div>
</body>
</html>