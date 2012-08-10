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
<script type="text/javascript" >
	function confirmar(){
		if(confirm("Desea realizar esta acción?")){
			return true;
		}else{
			return false;
		}
	}
</script>
<style type="text/css">
#gradient-style
{
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 800px;
	text-align: left;
	border-collapse: collapse;
}
#gradient-style th
{
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
	background: #b9c9fe url('table-images/gradhead.png') repeat-x;
	border-top: 2px solid #d3ddff;
	border-bottom: 1px solid #fff;
	color: #039;
}
#gradient-style td
{
	padding: 8px; 
	border-bottom: 1px solid #fff;
	color: #669;
	border-top: 1px solid #fff;
	background: #e8edff url('table-images/gradback.png') repeat-x;
}
#gradient-style tfoot tr td
{
	background: #e8edff;
	font-size: 12px;
	color: #99c;
}
#gradient-style tbody tr:hover td
{
	background: #d0dafd url('table-images/gradhover.png') repeat-x;
	color: #339;
}
</style>
</head>
	<body> 
	<div>
			<H1><% if(request.getAttribute("mensaje")!=null){ %>
				<%= request.getAttribute("mensaje")%>
		<%	} %>
			</H1>
	</div>
	<div class="center_content">
		<h1>Clientes</h1>
		<form action="verRegistroCliente.jsp" method="get">
			<a href="Menu.jsp">Menu</a>
		</form>
		<table id="gradient-style" summary="Meeting Results">
		<thead>
		    	<tr>
		        	<th scope="col">Nombre</th>
		            <th scope="col">Apellido Paterno</th>
		            <th scope="col">Apellido Materno</th>
		            <th scope="col">Direccion</th>
					<th scope="col">Telefono</th>
					<th scope="col">Editar</th>
					<th scope="col">Eliminar</th>
		        </tr>
	    	</thead>
	    	<tbody>
			<c:forEach items="${model.clientes}" var="prod" varStatus="i">
			<tr>
				<td width="100">${prod.nombre}</td>
				<td>${prod.apellidopaterno}</td>
				<td>${prod.apellidomaterno}</td>
				<td>${prod.direccion}</td>
				<td>${prod.telefono}</td>
				<td align="center"><a
						href="editarClienteC.jsp?id=${prod.codigo}"> <img
							src="<%=request.getContextPath()%>/images/editar.jpg" alt="" title="" border="0" onclick="return confirmar();" />
					</a></td>
				<td align="center"><a
						href="eliminarClienteC.jsp?id=${prod.codigo}"><img
							src="<%=request.getContextPath()%>/images/delete.gif" alt="" title="" border="0" onclick="return confirmar();" /></a>
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</body>
</html>