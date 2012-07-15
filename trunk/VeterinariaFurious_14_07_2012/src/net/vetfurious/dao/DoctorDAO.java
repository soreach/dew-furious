package net.vetfurious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.Doctor;
import net.vetfurious.util.ConexionBD;

public class DoctorDAO extends BaseDAO {

	public ArrayList<Doctor> listarDoctores() throws DAOExcepcion{
		String query = "SELECT doctor_Id,nombres,apellido_paterno,apellido_materno,email,telefono, codigoUsuario, claveSistema, esAdministrador FROM Doctor";
		ArrayList<Doctor> lista = new ArrayList<Doctor>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Doctor objDoctor = new Doctor();
				objDoctor.setIdDoctor(rs.getInt("doctor_Id"));
				objDoctor.setNombre(rs.getString("nombres"));
				objDoctor.setApellidopaterno(rs.getString("apellido_paterno"));
				objDoctor.setApellidomaterno(rs.getString("apellido_materno"));
				objDoctor.setEmail(rs.getString("email"));
				objDoctor.setTelefono(rs.getString("telefono"));
				objDoctor.setCodigoUsuario(rs.getString("codigoUsuario"));
				objDoctor.setClaveSistema(rs.getString("claveSistema"));
				objDoctor.setEsAdministrador(rs.getString("esAdministrador"));
				lista.add(objDoctor);
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

	public int existeDoctor(int idDoctor) throws DAOExcepcion {
		String query = "SELECT count(*) AS contador FROM Doctor WHERE Persona_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int contadorDoctor=0;
		try {
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idDoctor);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contadorDoctor=rs.getInt("contador");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return contadorDoctor;
	}

	public void eliminarDoctor(int idDoctor) throws DAOExcepcion {
		String query = "DELETE FROM Doctor WHERE doctor_id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idDoctor);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar el doctor.");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

		
	}

	public Doctor obtenerDoctor(int idDoctor) throws DAOExcepcion{
		String query = "SELECT doctor_Id,nombres,apellido_paterno,apellido_materno,email,telefono, codigoUsuario, claveSistema, esAdministrador FROM Doctor WHERE Doctor_Id=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Doctor objDoctor =null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idDoctor);
			rs = stmt.executeQuery();
			while (rs.next()) {
				objDoctor = new Doctor();
				objDoctor.setIdDoctor(rs.getInt("doctor_Id"));
				objDoctor.setNombre(rs.getString("nombres"));
				objDoctor.setApellidopaterno(rs.getString("apellido_paterno"));
				objDoctor.setApellidomaterno(rs.getString("apellido_materno"));
				objDoctor.setEmail(rs.getString("email"));
				objDoctor.setTelefono(rs.getString("telefono"));
				objDoctor.setCodigoUsuario(rs.getString("codigoUsuario"));
				objDoctor.setClaveSistema(rs.getString("claveSistema"));
				objDoctor.setEsAdministrador(rs.getString("esAdministrador"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return objDoctor;

	}

}
