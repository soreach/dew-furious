<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facturación</title>
<style type="text/css">
  .boton{
        font-size:10px;
        font-family:Verdana,Helvetica;
        font-weight:bold;
        color:white;
        background:#638cb5;
        border: 2px outset #d7b9c9;
        /*border:0px;
        width:120px;
        height:19px;*/
       }
</style>
</head>
<body>
<div>
		<div>
			<H1><% if(request.getAttribute("mensaje")!=null){ %>
				<%= request.getAttribute("mensaje")%>
		<%	} %>
			</H1>
		</div>
		<h1>Facturas</h1> <p>
		<form id="frmfacturacion" action="nuevafactura" method="get">
			<input type="submit" value="RegistrarFactura" class="boton">
			<a href="Menu.jsp">Menu</a>
		</form>
		<table border="1">
			<tr>
				<th>Factura</th>
				<th>Cliente</th>
				<th>Fecha</th>
			</tr>
			
			<c:forEach items="${model.facturas}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.codigofactura}</td>
				<td>${prod.nombrecliente}</td>
				<td>${prod.fecharegistro}</td>
				<td align="center"><a
						href="verfactura?id=${prod.codigofactura}"> <img
							src="<%=request.getContextPath()%>/images/editar.jpg" alt="Consultar" title="" border="0" />
					</a></td>
				<td align="center"><a
						href="eliminarfactura?id=${prod.codigofactura}"><img
							src="<%=request.getContextPath()%>/images/delete.gif" alt="Eliminar" title="" border="0" /></a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		</div>
</body>
</html>