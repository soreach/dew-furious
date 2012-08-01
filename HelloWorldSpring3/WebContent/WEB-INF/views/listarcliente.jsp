<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <!DOCTYPE html >
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <!-- Le styles -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
 
 
 <link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link href="css/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script src="js/jquery-ui-1.8.20.custom.min.js" type="text/javascript"
	charset="utf-8"></script>
	<title>Lista de Clientes</title>
</head>
	<body> 
	
	<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Team Furious</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="../index.jsp">Inicio</a></li>
              <li><a href="listarcliente.jsp">Clientes</a></li>
              <li><a href="listardoctor.jsp">Doctores</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
	
	   <div class="container" style="width: 1076px;">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h2>Clientes</h2> <p>
		<form action="verRegistroCliente.jsp" method="get">
			<input type="submit" name="btnNuevo" id="btnNuevo" value="Nuevo" class="btn btn-primary btn-larg" />
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

      <footer>
        <p>&copy; Furious LLC 2012</p>
      </footer>

    </div> 
	
	</body>
</html>