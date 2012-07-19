package net.vetfurious.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Collection;

	import net.vetfurious.negocio.DAOExcepcion;
	import net.vetfurious.negocio.Paciente;
import net.vetfurious.negocio.ConexionBD;

public class PacienteDAO extends BaseDAO {	
	
	  public Collection<Paciente> buscarPorNombre(String nombre)
	                        throws DAOExcepcion {
	                String query = "select id_categoria, nombre, descripcion from categoria where nombre like ?";
	                Collection<Paciente> lista = new ArrayList<Paciente>();
	                Connection con = null;
	                PreparedStatement stmt = null;
	                ResultSet rs = null;
	                try {
	                        con = ConexionBD.obtenerConexion();
	                        stmt = con.prepareStatement(query);
	                        stmt.setString(1, "%" + nombre + "%");
	                        rs = stmt.executeQuery();
	                        while (rs.next()) {
	                                Paciente vo = new Paciente();
	                                vo.setIdPaciente(rs.getInt("id_categoria"));
	                                vo.setNombre(rs.getString("nombre"));
	                                vo.setDescripcion(rs.getString("descripcion"));
	                                lista.add(vo);
	                        }
	                } catch (SQLException e) {
	                        System.err.println(e.getMessage());
	                        throw new DAOExcepcion(e.getMessage());
	                } finally {
	                        this.cerrarResultSet(rs);
	                        this.cerrarStatement(stmt);
	                        this.cerrarConexion(con);
	                }
	                System.out.println(lista.size());
	                return lista;
	        }

	        public Paciente insertar(Paciente vo) throws DAOExcepcion {
	                String query = "insert into categoria(nombre,descripcion) values (?,?)";
	                Connection con = null;
	                PreparedStatement stmt = null;
	                ResultSet rs = null;
	                try {
	                        con = ConexionBD.obtenerConexion();
	                        stmt = con.prepareStatement(query);
	                        stmt.setString(1, vo.getNombre());
	                        stmt.setString(2, vo.getDescripcion());
	                        int i = stmt.executeUpdate();
	                        if (i != 1) {
	                                throw new SQLException("No se pudo insertar");
	                        }
	                        // Obtener el ultimo id
	                        int id = 0;
	                        query = "select last_insert_id()";
	                        stmt = con.prepareStatement(query);
	                        rs = stmt.executeQuery();
	                        if (rs.next()) {
	                                id = rs.getInt(1);
	                        }
	                        vo.setIdPaciente(id);

	                } catch (SQLException e) {
	                        System.err.println(e.getMessage());
	                        throw new DAOExcepcion(e.getMessage());
	                } finally {
	                        this.cerrarResultSet(rs);
	                        this.cerrarStatement(stmt);
	                        this.cerrarConexion(con);
	                }
	                return vo;
	        }

	        public Paciente obtener(String codigoDueno, String codigoPaciente, String especie, String raza, String genero, String tipoSangre, String esterilizado, String tamaño, String actividad, String peso, String fechaNacimiento) throws DAOExcepcion {
	                Paciente vo = new Paciente();
	                Connection con = null;
	                PreparedStatement stmt = null;
	                ResultSet rs = null;
	                try {
	                        String query = "select codigoDueno,codigoPaciente,especie,raza,genero,tipoSangre,esterilizado,tamaño,actividad,peso,fechaNacimiento from paciente where codigoDueno=?";
	                        con = ConexionBD.obtenerConexion();
	                        stmt = con.prepareStatement(query);
	                        stmt.setString(1, codigoDueno);
	                        rs = stmt.executeQuery();
	                        if (rs.next()) {
	                                vo.setCodigoDueno(rs.getString(10));
	                                vo.setCodigoPaciente(rs.getString(2));
	                                vo.setEspecie(rs.getString(3));
	                                vo.setRaza(rs.getString(4));
	                                vo.setGenero(rs.getString(5));
	                                vo.setTipoSangre(rs.getString(6));
	                                vo.setEsterilizado(rs.getString(7));
	                                vo.setTamaño(rs.getString(8));
	                                vo.setActividad(rs.getString(9));
	                                vo.setPeso(rs.getString(10));
	                                vo.setFechaNacimiento(rs.getString(11));
	                        }
	                } catch (SQLException e) {
	                        System.err.println(e.getMessage());
	                        throw new DAOExcepcion(e.getMessage());
	                } finally {
	                        this.cerrarResultSet(rs);
	                        this.cerrarStatement(stmt);
	                        this.cerrarConexion(con);
	                }
	                return vo;
	        }

	        public void eliminar(int idPaciente) throws DAOExcepcion {
	                String query = "delete from categoria WHERE id_categoria=?";
	                Connection con = null;
	                PreparedStatement stmt = null;
	                try {
	                        con = ConexionBD.obtenerConexion();
	                        stmt = con.prepareStatement(query);
	                        stmt.setInt(1, idPaciente);
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
	                String query = "update categoria set nombre=?,descripcion=? where id_categoria=?";
	                Connection con = null;
	                PreparedStatement stmt = null;
	                try {
	                        con = ConexionBD.obtenerConexion();
	                        stmt = con.prepareStatement(query);
	                        stmt.setString(1, vo.getNombre());
	                        stmt.setString(2, vo.getDescripcion());
	                        stmt.setInt(3, vo.getIdPaciente());
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

	        public Collection<Paciente> listar() throws DAOExcepcion {
	                Collection<Paciente> c = new ArrayList<Paciente>();
	                Connection con = null;
	                PreparedStatement stmt = null;
	                ResultSet rs = null;
	                try {
	                        con = ConexionBD.obtenerConexion();
	                        String query = "select id_categoria,nombre,descripcion from categoria order by nombre";
	                        stmt = con.prepareStatement(query);
	                        rs = stmt.executeQuery();
	                        while (rs.next()) {
	                                Paciente vo = new Paciente();
	                                vo.setIdPaciente(rs.getInt("id_categoria"));
	                                vo.setNombre(rs.getString("nombre"));
	                                vo.setDescripcion(rs.getString("descripcion"));
	                                c.add(vo);
	                        }

	                } catch (SQLException e) {
	                        System.err.println(e.getMessage());
	                        throw new DAOExcepcion(e.getMessage());
	                } finally {
	                        this.cerrarResultSet(rs);
	                        this.cerrarStatement(stmt);
	                        this.cerrarConexion(con);
	                }
	                return c;
	        }

	        
	}