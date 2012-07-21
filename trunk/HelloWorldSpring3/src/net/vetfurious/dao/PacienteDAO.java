package net.vetfurious.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.Collection;
        import net.vetfurious.excepcion.DAOExcepcion;
        import net.vetfurious.modelo.Paciente;
        import net.vetfurious.util.ConexionBD;

public class PacienteDAO extends BaseDAO {      
        
                 public Paciente insertar(Paciente vo) throws DAOExcepcion {
                        String query = "insert into paciente(codigoDueno,codigoPaciente,especie,raza,genero,tipoSangre,esterilizado,tamaño,actividad,peso,fechaNacimiento) values (?,?,?,?,?,?,?,?,?,?,?)";
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;
                        try {
                                con = ConexionBD.obtenerConexion();
                                stmt = con.prepareStatement(query);
                                stmt.setString(1, vo.getCodigoDueno());
                                stmt.setString(2, vo.getCodigoPaciente());
                                stmt.setString(3, vo.getEspecie());
                                stmt.setString(4, vo.getRaza());
                                stmt.setString(5, vo.getGenero());
                                stmt.setString(6, vo.getTipoSangre());
                                stmt.setString(7, vo.getEsterilizado());
                                stmt.setString(8, vo.getTamaño());
                                stmt.setString(9, vo.getActividad());
                                stmt.setString(10, vo.getPeso());
                                stmt.setString(11, vo.getFechaNacimiento());

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
 //                               vo.setIdPaciente(id);

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

//                public Paciente obtener(String codigoDueno, String codigoPaciente, String especie, String raza, String genero, String tipoSangre, String esterilizado, String tamaño, String actividad, String peso, String fechaNacimiento) throws DAOExcepcion {
                public Paciente obtenerPaciente(String codigoDueno) throws DAOExcepcion {

                	Paciente vo = new Paciente();
                        Connection con = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;
                        try {
                                String query = "select codigoDueno,raza from Paciente where codigoDueno='Cliente001'";
                                con = ConexionBD.obtenerConexion();
                                stmt = con.prepareStatement(query);
               //                 stmt.setString(1, codigoDueno);
                                rs = stmt.executeQuery();
                                if (rs.next()) {
                                        vo.setCodigoDueno(rs.getString(1));
               //                         vo.setCodigoPaciente(rs.getString(2));
               //                         vo.setEspecie(rs.getString(3));
                                        vo.setRaza(rs.getString(2));
               //                         vo.setGenero(rs.getString(5));
               //                         vo.setTipoSangre(rs.getString(6));
               //                         vo.setEsterilizado(rs.getString(7));
               //                         vo.setTamaño(rs.getString(8));
               //                         vo.setActividad(rs.getString(9));
               //                         vo.setPeso(rs.getString(10));
               //                         vo.setFechaNacimiento(rs.getString(11));
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

                public void eliminar(String codigoDueno) throws DAOExcepcion {
                        String query = "delete from paciente WHERE codigoDueno='Cliente001'";
                        Connection con = null;
                        PreparedStatement stmt = null;
                        try {
                                con = ConexionBD.obtenerConexion();
                                stmt = con.prepareStatement(query);
//                                stmt.String("1", codigoDueno);
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
                        String query = "update paciente set especie=?,raza=? where codigoDueno?";
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
                    String query = "select codigoDueno,codigoPaciente,especie,raza,genero,tipoSangre,esterilizado,tamaño,actividad,peso,fechaNacimiento from paciente order by codigoDueno";
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
                                        vo.setCodigoDueno(rs.getString("Codigo Cliente"));
                                        vo.setCodigoPaciente(rs.getString("Codigo Paciente"));
                                        vo.setEspecie(rs.getString("Especie"));
                                        vo.setRaza(rs.getString("Raza"));
                                        vo.setGenero(rs.getString("Genero"));
                                        vo.setTipoSangre(rs.getString("Tipo de Sangre"));
                                        vo.setEsterilizado(rs.getString("Esterilizado"));
                                        vo.setTamaño(rs.getString("Tamaño"));
                                        vo.setActividad(rs.getString("Actividad"));
                                        vo.setPeso(rs.getString("Peso"));
                                        vo.setFechaNacimiento(rs.getString("Fecha de Nacimiento"));
//                                        c.add(vo);
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
