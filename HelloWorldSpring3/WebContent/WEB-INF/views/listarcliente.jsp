<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <!DOCTYPE html >
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <!-- Le styles -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/DT_bootstrap.css" rel="stylesheet">
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
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Team Furious</a>
          
          <div class="btn-group pull-right">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="icon-user"></i> Username
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="#">Sign Out</a></li>
            </ul>
          </div>
          
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="../index.jsp">Inicio</a></li>
               <li><a href="listarcliente.jsp">Prospectos</a></li>
              <li><a href="listarcliente2.jsp">Clientes</a></li>
      		  <li><a href="listardoctor.jsp">Doctores</a></li>
	          <li><a href="listarfacturas">Facturacion</a></li>
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
		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
			<thead>	
				<tr>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Direccion</th>
					<th>Telefono</th>
					<td>Editar</td>
					<td>Eliminar</td>
	
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
							href="editarCliente.jsp?id=${prod.codigo}"> <img
								src="images/editar.jpg" alt="" title="" border="0" />
						</a></td>
					<td align="center"><a
							href="eliminarCliente.jsp?id=${prod.codigo}"><img
								src="images/delete.gif" alt="" title="" border="0" /></a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
      </div>

      <footer>
        <p>&copy; Furious LLC 2012</p>
      </footer>

    </div> 
    
    
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" charset="utf-8" language="javascript" src="../js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf-8" language="javascript" src="../js/DT_bootstrap.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script language="javascript">

    $(function(){
        $('.row').each(function(){

    		$(this).find('.span6').first().css('width', '354px');
        });
    });
    
    </script>
	
	</body>
</html>