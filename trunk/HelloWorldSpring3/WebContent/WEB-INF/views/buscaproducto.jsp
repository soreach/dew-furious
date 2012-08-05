<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="javascript">
	function seleccionarproducto(codigo,producto,precio){
		window.opener.document.getElementById("idproducto").value=codigo;
		window.opener.document.getElementById("nombreproducto").value=producto;
		window.opener.document.getElementById("txtprecio").value=precio;
		window.close();
	}
</script>
</head>
<body>
<div class="center_content">
		<h1>Buscador de Productos</h1> <p>
		<form action="" method="get">
		</form>
		<table border="1">
			<tr>
				<th>Codigo</th>
				<th>Producto</th>
				<th>Precio</th>
				<td>Seleccionar</td>
			</tr>
			<c:forEach items="${model.productos}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.idproducto}</td>
				<td>${prod.nombreproducto}</td>
				<td>${prod.precio}</td>
				<td><a href="#" onclick='seleccionarproducto("${prod.idproducto}","${prod.nombreproducto}","${prod.precio}");'>Seleccionar</a></td>
			</tr>
			</c:forEach>
			
			
		</table>
		</div>
</body>
</html>