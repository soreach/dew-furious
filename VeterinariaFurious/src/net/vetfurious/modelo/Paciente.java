package net.vetfurious.negocio;

	import java.util.Collection;

	public class Paciente {

		public Paciente() {
            super();
            // TODO Auto-generated constructor stub
    }
		
//	        public Paciente(int idCategoria, String codigoDueno, String nombre, String descripcion,
//	                        Collection<Producto> productos) {
		    public Paciente(String codigoDueno, String codigoPaciente, String especie, String raza, String genero, String tipoSangre, String esterilizado, String tamaño, String actividad, String peso, String fechaNacimiento) {	
	                super();
	                this.codigoDueno = codigoDueno;
	                this.codigoPaciente = codigoPaciente;
	                this.especie = especie;
	                this.raza = raza;
	                this.genero = genero;
	                this.tipoSangre = tipoSangre;
	                this.esterilizado = esterilizado;
	                this.tamaño = tamaño;
	                this.actividad = actividad;
	                this.peso = peso;
	                this.fechaNacimiento = fechaNacimiento;
//	                this.productos = productos;
	        }

	        private String codigoDueno;
	        private String codigoPaciente;
	        private String especie;
	        private String raza;
	        private String genero;
	        private String tipoSangre;
	        private String esterilizado;
	        private String tamaño;
	        private String actividad;
	        private String peso;
	        private String fechaNacimiento;
//	        private Collection<Producto> productos;
	        

	        public String getCodigoDueno() {
                return codigoDueno;
	        }
	        public void setCodigoDueno(String codigoDueno) {
                this.codigoDueno = codigoDueno;
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
                this.especie = especie;
	        }

	        public String getRaza() {
                return raza;
	        }
	        public void setRaza(String raza) {
                this.raza = raza;
	        }

	        public String getGenero() {
                return genero;
	        }
	        public void setGenero(String genero) {
                this.genero = genero;
	        }

	        public String getTipoSangre() {
                return tipoSangre;
	        }
	        public void setTipoSangre(String tipoSangre) {
                this.tipoSangre = tipoSangre;
	        }

	        public String getEsterilizado() {
                return esterilizado;
	        }
	        public void setEsterilizado(String esterilizado) {
                this.esterilizado = esterilizado;
	        }

	        public String getTamaño() {
                return tamaño;
	        }
	        public void setTamaño(String tamaño) {
                this.tamaño= tamaño;
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
                this.fechaNacimiento = fechaNacimiento;
	        }
	        
//	        public Collection<Producto> getProductos() {
//	                return productos;
//	        }


//	        public void setProductos(Collection<Producto> productos) {
//	                this.productos = productos;
//	        }

	        
	        
	        
	}

