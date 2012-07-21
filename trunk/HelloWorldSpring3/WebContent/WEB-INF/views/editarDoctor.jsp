<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Veterinaria - Mantenimiento de Doctores::.. Editar un Doctor</title>
<link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>

<script>
	$(function() {
		$( "#datepicker" ).datepicker({ autoSize: true });
	});
</script>


</head>

<style>
<!--
.errors {
	color: red;
}
-->
</style>
</head>
<body>

	<div class="center_content">
	<h3>Mantenimiento de Doctores</h3>
	<form action="guardarModificacionDoctor.jsp" method="post">
		<table>
			<tr>
				<td>Id Doctor:</td>
				<td><input id="id" name="id" value="${requestScope.model.id}"/></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input id="txtNombre" name="txtNombre" value="${requestScope.model.nombre}"/></td>
			</tr>
			<tr>
				<td>Apellido Paterno:</td>
				<td><textarea rows="3" cols="20" name="txtApellidoPaterno"
						id="txtDescripcion">${requestScope.model.apellidoPaterno}</textarea></td>

			</tr>
			
			<tr>
				<td>Apellido Materno:</td>
				<td><textarea rows="3" cols="20" name="txtApellidoMaterno"
						id="txtDescripcion">${requestScope.model.apellidoMaterno}</textarea></td>

			</tr>
			
			<tr>
				<td>Raza:</td>
				<td><textarea rows="3" cols="20" name="txtRaza"
						id="txtDescripcion">${requestScope.model.raza}</textarea></td>

			</tr>
			
			
			<tr>
				<td colspan="2"><input type="submit" value="Guardar"
					name="btnRegistrar" /></td>
			</tr>
		</table>
	</form>
	</div>
	<!-- end of center content -->

	
</body>
</html>