package net.vetfurious.modelo;


public class Paciente {
	
	String codigoDueno;
	String codigoPaciente; 
	String especie;
	String raza;
	String genero; 
	String tipoSangre;
	String esterilizado; 
	String tamano; 
	String actividad;
	String peso;
	String fechaNacimiento;
	
	public Paciente(String codigoDueno, String codigoPaciente, String especie, String raza, String genero, String tipoSangre, String esterilizado, String tamano, String actividad, String peso, String fechaNacimiento) {

		this.codigoDueno=codigoDueno;
		this.codigoPaciente=codigoPaciente;
		this.especie=especie;
		this.raza=raza;
		this.genero=genero;
		this.tipoSangre=tipoSangre;
		this.esterilizado=esterilizado;
		this.tamano=tamano;
		this.actividad=actividad;
		this.peso=peso;
		this.fechaNacimiento=fechaNacimiento;
	}
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigoDueno() {
		return codigoDueno;
	}

	public void setCodigoDueno(String codigoDueno) {
		this.codigoDueno= codigoDueno;
	}
	
	public String getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(String codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie= especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza= raza;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero= genero;
	}
	
	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre= tipoSangre;
	}

	public String getEsterilizado() {
		return esterilizado;
	}

	public void setEsterilizado(String esterilizado) {
		this.esterilizado= esterilizado;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano= tamano;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad= actividad;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso= peso;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento= fechaNacimiento;

	}
}

