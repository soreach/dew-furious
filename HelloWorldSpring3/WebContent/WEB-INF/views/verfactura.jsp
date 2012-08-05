<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Factura</title>
</head>
<body>
<form>
		<div>
			<table>
				<tr>
				<th colspan=4>Consulta de Factura</th>
				</tr>
				<tr>
					<td>Factura Nº:</td>
					<td><input type="text" id="txtfactura" value="${requestScope.model.codFactura}"></td>
					<td>Fecha:</td>
					<td><input type="text" id="txtfecha" value="${requestScope.model.feRegistro}"></td>
				</tr>
				<tr>
					<td>Cliente:</td>
					<td><input type="text" id="txtCliente" value="${requestScope.model.cliente}"></td>
					<td><input type="button" id="imgcliente" onclick="buscarcliente();" ></td>
					<td><input type="hidden" id="hiddencliente" value="${requestScope.model.intidCliente}"></td>
				</tr>
				<tr>
					<td>RUC:</td>
					<td><input type="text" id="txtruc" value="${requestScope.model.ruc}"></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div>
		<table>
				<tr>
					<td>Paciente:</td>
					<td><input type="text" id="txtpaciente" value="${requestScope.model.paciente}"></td>
					<td><img  id="imgpaciente"/></td>
					<td><input type="hidden" id="hiddenpaciente" value="${requestScope.model.idPaciente}"></td>
				</tr>
			</table>
		</div>
		
		<div>
			<table>
				<tr>
					<th>Codigo</th>
					<th>Producto</th>
					<th>Cantidad</th>
					<th>Precio</th>
				</tr>
				<c:forEach items="${requestScope.model.detalle}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.codProducto}</td>
				<td>${prod.producto}</td>
				<td>${prod.qtCantidad}</td>
				<td>${prod.precio}</td>
			</tr>
			</c:forEach>
				
			
			</table>
		</div>
	</form>
</body>
</html>