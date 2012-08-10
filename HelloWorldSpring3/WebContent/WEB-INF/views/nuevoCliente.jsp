<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" />
<title>Veterinaria - Prospectos</title>
<SCRIPT type="text/javascript">
 function validar(){
 
 if(confirm("Desea registrar el siguiente Prospecto?")){
 	 var msg="";
	 var bol=true;
	 if(document.getElementById("txtNombre").value=="") {
		 msg="Ingrese Nombre del Prospecto!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtApellidoPaterno").value=="") {
		 msg=msg + "Ingrese Apellido Paterno del Prospecto!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtApellidoMaterno").value=="") {
		 msg=msg + "Ingrese Apellido Materno del Prospecto!!! \n"; 
		 bol=false;
	 }
	 
	 if(document.getElementById("txtEmail").value!=""){
		 valor=document.getElementById("txtEmail").value;
			    re=/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$/;
			    if(!re.exec(valor))    {
			    	 msg=msg + "Email Incorrecto!!! \n"; 
			    	 bol=false;
			    }
	 }
	 
	 if(msg.toString().length!=0){
		 alert(msg);
	 }
	 return bol;
 }else{
 	return false;
 }
	 
 }
 
 function solonumbers(e){
		 var key;

		 if(window.event) // IE
		 {
		  key = e.keyCode;
		 }
		  else if(e.which) // Netscape/Firefox/Opera
		 {
		  key = e.which;
		 }
		
		 if (key < 48 || key > 57) 
		    {
		      return false;
		    }
		
		 return true;
	}
</SCRIPT>
</head>
<body>

	<div class="center_content">
		<h3>Registro de Prospectos</h3>
			<form name="input" action="registrarCliente.html" method="post">
		<table border="1">
			<thead>
				<tr>
					<th></th>
					<th>Ingreso de Información</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td><input type="submit" value="Ingresar" onclick="return validar();" ></td>
					<td><a href="listarcliente.jsp">Cancelar</a></td>
				</tr>
			</tfoot>
			<tr>
				<td>Codigo Prospecto:</td>
				<td><input type="text"  name="id" id="id" value="0" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input name = "txtNombre" id="txtNombre" maxlength="50"></td>
			</tr>
			<tr>
				<td>Ap. Paterno:</td>
				<td><input name ="txtApellidoPaterno" id="txtApellidoPaterno" maxlength="50"></td>
			</tr>
			<tr>
				<td>Ap. Materno:</td>
				<td><input name ="txtApellidoMaterno" id="txtApellidoMaterno" maxlength="50"></td>
			</tr>
			<tr>
				<td>Dirección:</td>
				<td><textarea rows="3" cols="20" name ="txtDireccion" id="txtDireccion" maxlength="150"></textarea></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><input name ="txtCelular" id="txtCelular"  maxlength="15" onkeypress="javascript:return solonumbers(event);"></td>
			</tr>
			<tr>
				<td>Teléfono:</td>
				<td><input name ="txtTelefono" id="txtTelefono" maxlength="15" onkeypress="javascript:return solonumbers(event);"></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input name="txtEmail" id="txtEmail" maxlength="30"></td>
			</tr>
		</table>
	  </form>
	</div>

</body>
</html>