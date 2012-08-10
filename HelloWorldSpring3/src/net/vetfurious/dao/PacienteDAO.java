package net.vetfurious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Paciente;
import net.vetfurious.util.ConexionBD;

public class PacienteDAO extends BaseDAO {      
        
	public Paciente DAOinsertarPacientes(Paciente objPaciente) throws DAOExcepcion {
        String query = "insert into paciente(codigoDueno,codigoPaciente,especie,raza,genero,tipoSangre,esterilizado,tamano,actividad,peso,fechaNacimiento) values (?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
                stmt.setInt(1, objPaciente.getCodigoDueno());
                stmt.setInt(2, objPaciente.getCodigoPaciente());
                stmt.setString(3, objPaciente.getEspecie());
                stmt.setString(4, objPaciente.getRaza());
                stmt.setString(5, objPaciente.getGenero());
                stmt.setString(6, objPaciente.getTipoSangre());
                stmt.setString(7, objPaciente.getEsterilizado());
                stmt.setString(8, objPaciente.getTamano());
                stmt.setString(9, objPaciente.getActividad());
                stmt.setString(10, objPaciente.getPeso());
                stmt.setString(11, objPaciente.getFechaNacimiento());

                int i = stmt.executeUpdate();
                if (i != 1) {
                        throw new SQLException("No se pudo insertar");
                }

        } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new DAOExcepcion(e.getMessage());
        } finally {
                this.cerrarResultSet(rs);
                this.cerrarStatement(stmt);
                this.cerrarConexion(con);
        }
        return objPaciente;
}


 public Paciente obtenerPaciente(String codigoDueno) throws DAOExcepcion {

        Paciente objPaciente = new Paciente();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
                String query = "select codigoPaciente,especie,raza,genero,tipoSangre,esterilizado,tamano,actividad,peso,fechaNacimiento  from Paciente where codigoDueno=?";
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
//                 stmt.setString(1, codigoDueno);
                rs = stmt.executeQuery();
                if (rs.next()) {
                        objPaciente.setCodigoPaciente(Integer.parseInt(rs.getString(2)));
                        objPaciente.setEspecie(rs.getString(3));
                        objPaciente.setRaza(rs.getString(2));
                        objPaciente.setGenero(rs.getString(5));
                        objPaciente.setTipoSangre(rs.getString(6));
                        objPaciente.setEsterilizado(rs.getString(7));
                        objPaciente.setTamano(rs.getString(8));
                        objPaciente.setActividad(rs.getString(9));
                        objPaciente.setPeso(rs.getString(10));
                        objPaciente.setFechaNacimiento(rs.getString(11));
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new DAOExcepcion(e.getMessage());
        } finally {
                this.cerrarResultSet(rs);
                this.cerrarStatement(stmt);
                this.cerrarConexion(con);
        }
        return objPaciente;
}

public void eliminarPaciente(String codigoDueno) throws DAOExcepcion {
        String query = "delete from paciente WHERE codigoDueno=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
//                            stmt.String("1", codigoDueno);
                int i = stmt.executeUpdate();
                if (i != 1) {
                        throw new SQLException("No se pudo eliminar");
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new DAOExcepcion(e.getMessage());
        } finally {
                this.cerrarStatement(stmt);
                this.cerrarConexion(con);
        }
}

public Paciente actualizar(Paciente vo) throws DAOExcepcion {
        String query = "update paciente set codigoPaciente=?,especie=?,raza=?,genero=?,tipoSangre=?,esterilizado=?,tamano=?,actividad=?,peso=?,fechaNacimiento=? where codigoDueno?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
                stmt.setString(1, vo.getEspecie());
                stmt.setString(2, vo.getRaza());
                int i = stmt.executeUpdate();
                if (i != 1) {
                        throw new SQLException("No se pudo actualizar");
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new DAOExcepcion(e.getMessage());
        } finally {
                this.cerrarStatement(stmt);
                this.cerrarConexion(con);
        }
        return vo;
}

public ArrayList<Paciente> listarPacientes() throws DAOExcepcion {
    String query = "select codigoDueno,codigoPaciente,especie,raza,genero,tipoSangre,esterilizado,tamano,actividad,peso,fechaNacimiento from paciente order by codigoDueno";
    ArrayList<Paciente> lista = new ArrayList<Paciente>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
                rs = stmt.executeQuery();
                while (rs.next()) {
                        Paciente vo = new Paciente();
                        vo.setCodigoDueno(Integer.parseInt(rs.getString("Codigo Cliente")));
                        vo.setCodigoPaciente(Integer.parseInt(rs.getString("Codigo Paciente")));
                        vo.setEspecie(rs.getString("Especie"));
                        vo.setRaza(rs.getString("Raza"));
                        vo.setGenero(rs.getString("Genero"));
                        vo.setTipoSangre(rs.getString("Tipo de Sangre"));
                        vo.setEsterilizado(rs.getString("Esterilizado"));
                        vo.setTamano(rs.getString("Tamano"));
                        vo.setActividad(rs.getString("Actividad"));
                        vo.setPeso(rs.getString("Peso"));
                        vo.setFechaNacimiento(rs.getString("Fecha de Nacimiento"));
//                        c.add(vo);
                }

        } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new DAOExcepcion(e.getMessage());
        } finally {
                this.cerrarResultSet(rs);
                this.cerrarStatement(stmt);
                this.cerrarConexion(con);
        }
        return lista;
}

                
        }
