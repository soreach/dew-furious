<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" />
<title>Veterinaria - Clientes</title>
</head>
<body>

	<div class="center_content">
		<h3>Ingresar nuevo Cliente</h3>
			<form name="input" action="registrarCliente.html" method="post">
		<table border="1">
			<thead>
				<tr>
					<th></th>
					<th>Ingresar Datos</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td></td>
					<td><input type="submit" value="Ingresar"></td>
				</tr>
			</tfoot>
			<tr>
				<td>Id Cliente</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input name = "txtNombre"></td>
			</tr>
			<tr>
				<td>Ap. paterno</td>
				<td><input name ="txtApellidoPaterno"></td>
			</tr>
			<tr>
				<td>Ap. materno</td>
				<td><input name ="txtApellidoMaterno"></td>
			</tr>
			<tr>
				<td>Celular</td>
				<td><input name ="txtCelular"></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input name ="txtTelefono"></td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input name ="txtDireccion"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name ="txtEmail"></td>
			</tr>

		</table>
	</form>
	</div>

</body>
</html>