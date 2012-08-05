<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda de Pacientes</title>
<script type="text/javascript" language="javascript">
	function seleccionarpaciente(codigo,nombre){
		window.opener.document.getElementById("hiddenpaciente").value=codigo;
		window.opener.document.getElementById("txtpaciente").value=nombre;
		window.close();
	}
</script>
</head>
<body>
<div class="center_content">
		<h1>Buscador de Pacientes</h1> <p>
		<form action="" method="get">
		</form>
		<table border="1">
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
				<td>Seleccionar</td>
			</tr>
			<c:forEach items="${model.clientes}" var="prod" varStatus="i">
			<tr>
				<td>${prod.codigo}</td>
				<td width="100">${prod.nombre}</td>
				<td><a href="#" onclick='seleccionarpaciente("${prod.codigo}","${prod.nombre}","${prod.apellidopaterno}","${prod.apellidomaterno}");'>Seleccionar</a></td>
			</tr>
			</c:forEach>
			
			
		</table>
		</div>
</body>
</html>