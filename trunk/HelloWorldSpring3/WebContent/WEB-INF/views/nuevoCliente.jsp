<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

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
<title>Veterinaria - Clientes</title>
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
					<td><input type="submit" value="Ingresar" class="btn btn-primary btn-larg" ></td>
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

      <footer>
        <p>&copy; Furious LLC 2012</p>
      </footer>

    </div> 

	<div class="center_content">
		
	</div>

</body>
</html>