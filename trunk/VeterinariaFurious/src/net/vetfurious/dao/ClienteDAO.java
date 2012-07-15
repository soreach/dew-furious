package net.vetfurious.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Cliente;
import net.vetfurious.util.ConexionBD;

public class ClienteDAO extends BaseDAO {

	public int DAOexisteprospecto(String codigo) throws DAOExcepcion {
		String query = "select count(*) as contador from Cliente where estado not in('X') and Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int contadorCliente=0;
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contadorCliente=rs.getInt("contador");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return contadorCliente;
	}

	public void DAOdeleteprospecto(String codigo) throws DAOExcepcion {
		String query = "UPDATE Cliente SET estado='X' where Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
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

	public ArrayList<Cliente> DAOlistarprospectos() throws DAOExcepcion{
		String query = "select Persona_Id,Nombres,apellido_paterno,apellido_materno,email,telefono,direccion,imagen,celular from Cliente where estado not in('X') and tipo_persona='P'";
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getString("Persona_Id"));
				objCliente.setNombre(rs.getString("Nombres"));
				objCliente.setApellidopaterno(rs.getString("apellido_paterno"));
				objCliente.setApellidomaterno(rs.getString("apellido_materno"));
				objCliente.setDireccion(rs.getString("direccion"));
				objCliente.setEmail(rs.getString("email"));
				objCliente.setImagen(rs.getString("imagen"));
				objCliente.setTelefono(rs.getString("telefono"));
				objCliente.setCelular(rs.getString("celular"));
				lista.add(objCliente);
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

	public void DAOgrabarprospecto(Cliente objCliente) throws DAOExcepcion{
		String query = "INSERT INTO Cliente(Persona_Id,Nombres,apellido_paterno,apellido_materno,email,direccion,imagen,telefono,celular,tipo_persona,estado) values (?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, objCliente.getCodigo());
			stmt.setString(2, objCliente.getNombre());
			stmt.setString(3, objCliente.getApellidopaterno());
			stmt.setString(4, objCliente.getApellidomaterno());
			stmt.setString(5, objCliente.getEmail());
			stmt.setString(6, objCliente.getDireccion());
			stmt.setString(7, objCliente.getImagen());
			stmt.setString(8, objCliente.getTelefono());
			stmt.setString(9, objCliente.getCelular());
			stmt.setString(10,"P");
			stmt.setString(11,"A");
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
				
	}

	public void DAOmodificarprospecto(Cliente objCliente) throws DAOExcepcion{
		String query = "update Cliente set Nombres=?,apellido_paterno=?,apellido_materno=?,email=?,direccion=?,imagen=?,telefono=?,celular=? where Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, objCliente.getNombre());
			stmt.setString(2, objCliente.getApellidopaterno());
			stmt.setString(3, objCliente.getApellidomaterno());
			stmt.setString(4, objCliente.getEmail());
			stmt.setString(5, objCliente.getDireccion());
			stmt.setString(6, objCliente.getImagen());
			stmt.setString(7, objCliente.getTelefono());
			stmt.setString(8, objCliente.getCelular());
			stmt.setString(9, objCliente.getCodigo());
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
				
	}

	public Cliente DAOobtenerprospecto(String codigo) throws DAOExcepcion{
		String query = "select Persona_Id,Nombres,apellido_paterno,apellido_materno,email,telefono,direccion,imagen,celular from Cliente where estado not in('X') and Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente objCliente =null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				objCliente = new Cliente();
				objCliente.setCodigo(rs.getString("Persona_Id"));
				objCliente.setNombre(rs.getString("Nombres"));
				objCliente.setApellidopaterno(rs.getString("apellido_paterno"));
				objCliente.setApellidomaterno(rs.getString("apellido_materno"));
				objCliente.setDireccion(rs.getString("direccion"));
				objCliente.setEmail(rs.getString("email"));
				objCliente.setImagen(rs.getString("imagen"));
				objCliente.setTelefono(rs.getString("telefono"));
				objCliente.setCelular(rs.getString("celular"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return objCliente;

	}

	public String DAOgetlastcodigo() throws DAOExcepcion{
		String query = "SELECT ISNULL((SELECT MAX(Persona_Id) FROM CLIENTE),'0') AS CODIGO";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String lastcodigo="0";
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				lastcodigo=rs.getString("CODIGO");
			}
			
			lastcodigo=Integer.toString(Integer.parseInt(lastcodigo) +1) ;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return lastcodigo;
	}

}
