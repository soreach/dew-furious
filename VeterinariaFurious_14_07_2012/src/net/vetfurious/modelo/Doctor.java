package net.vetfurious.modelo;

public class Doctor {
	
	private int idDoctor;
	private String nombre; 
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email; 
	private String telefono; 
	private String codigoUsuario;
	private String claveSistema;
	private String esAdministrador;
	
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno() {
		return apellidoPaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidoPaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidoMaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidoMaterno = apellidomaterno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getClaveSistema() {
		return claveSistema;
	}
	public void setClaveSistema(String claveSistema) {
		this.claveSistema = claveSistema;
	}
	public String getEsAdministrador() {
		return esAdministrador;
	}
	public void setEsAdministrador(String esAdministrador) {
		this.esAdministrador = esAdministrador;
	}
	public Doctor() {
		super();
	}
	public Doctor(int idDoctor, String nombre, String apellidoPaterno,
			String apellidoMaterno, String email, String telefono, 
			String codigoUsuario, String claveSistema,
			String esAdministrador) {
		super();
		this.idDoctor = idDoctor;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.telefono = telefono;
		this.codigoUsuario = codigoUsuario;
		this.claveSistema = claveSistema;
		this.esAdministrador = esAdministrador;
	}
}
