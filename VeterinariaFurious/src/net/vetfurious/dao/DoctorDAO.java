package net.vetfurious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;
import net.vetfurious.util.ConexionBD;

public class DoctorDAO extends BaseDAO {

	public Doctor insertar(Doctor vo) throws DAOExcepcion {
		String query = "insert into Doctor(nombre,paterno,materno,email,telefono,username) values (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getPaterno());
			stmt.setString(3, vo.getMaterno());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getUsuario());
			
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
			vo.setDoctorID(id);

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

	public Doctor obtener(int doctorID) throws DAOExcepcion {
		Doctor vo = new Doctor();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select doctorID,nombre,paterno,materno,email,telefono,username from Doctor where doctorID=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, doctorID);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setDoctorID(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setPaterno(rs.getString(3));
				vo.setMaterno(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setTelefono(rs.getString(6));
				vo.setUsuario(rs.getString(7));
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


	public Doctor actualizar(Doctor vo) throws DAOExcepcion {
		String query = "update categoria set nombre=?,paterno=?,materno=?,email=?,telefono=?,username=? where doctorID=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getPaterno());
			stmt.setString(3, vo.getMaterno());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getTelefono());
			stmt.setString(6, vo.getUsuario());
			
			stmt.setInt(7, vo.getDoctorID());
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

	
}
