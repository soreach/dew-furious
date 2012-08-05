<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" >
	function buscarcliente(){
		window.open("buscacliente","","width=600,height=400");
	}
	function buscarproducto(){
		window.open("buscaproducto","","width=600,height=400");
	}
function buscarpaciente(){
		window.open("buscapaciente","","width=600,height=400");
	}
</script>
</head>
<body>
	<form action="recargafactura" method="post">
		<div>
			<table>
				<tr>
					<td>Factura Nº:</td>
					<td><input type="text" id="txtfactura" name="txtfactura" value="${requestScope.model.codFactura}"/></td>
					<td>Fecha:</td>
					<td><input type="text" id="txtfecha" name="txtfecha" value="${requestScope.model.feRegistro}"/></td>
				</tr>
				<tr>
					<td>Cliente:</td>
					<td><input type="text" id="txtCliente" name="txtCliente" value="${requestScope.model.cliente}"></td>
					<td><input type="button" id="imgcliente" name="imgcliente" onclick="buscarcliente();" ></td>
					<td><input type="hidden" id="hiddencliente" name="hiddencliente" value="${requestScope.model.intidCliente}"></td>
				</tr>
				<tr>
					<td>RUC:</td>
					<td><input type="text" id="txtruc" name="txtruc" value="${requestScope.model.ruc}"></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div>
		<table>
				<tr>
					<td>Paciente:</td>
					<td><input type="text" id="txtpaciente" name="txtpaciente" value="${requestScope.model.paciente}"></td>
					<td><input type="button" id="imgcliente" name="imgcliente" onclick="buscarpaciente();" ></td>
					<td><input type="hidden" id="hiddenpaciente" name="hiddenpaciente" value="${requestScope.model.idPaciente}"></td>
				</tr>
			</table>
		</div>
		<div>
			Productos
			<table>
				<tr>
					<td>Producto:</td>
					<td><input type="text" id="idproducto" name="idproducto"></td>
					<td><input type="text" id="nombreproducto" name="nombreproducto"></td>
					<td><img  id="imgproducto" onclick="buscarproducto();" ></td>
				</tr>
				<tr>
					<td>Cantidad:</td>
					<td><input type="text" id="txtxcantidad" name="txtxcantidad"></td>
					<td>Precio:</td>
					<td><input type="text" id="txtprecio" name="txtprecio"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Agregar"></td>
					<td><a href="#">Eliminar</a></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div>
			<table>
				<tr>
					<td>Codigo</td>
					<td>Producto</td>
					<td>Cantidad</td>
					<td>Precio</td>
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