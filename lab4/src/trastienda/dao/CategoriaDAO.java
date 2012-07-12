package trastienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Categoria;
import trastienda.util.ConexionBD;


public class CategoriaDAO extends BaseDAO {

	public Collection<Categoria> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select id_categoria, nombre, descripcion from categoria where nombre like ?";
		Collection<Categoria> lista = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria vo = new Categoria();
				vo.setIdCategoria(rs.getInt("id_categoria"));
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

	public Categoria insertar(Categoria vo) throws DAOExcepcion {
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
			vo.setIdCategoria(id);

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

	public Categoria obtener(int idCategoria) throws DAOExcepcion {
		Categoria vo = new Categoria();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select id_categoria, nombre, descripcion from categoria where id_categoria=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdCategoria(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setDescripcion(rs.getString(3));
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

	public void eliminar(int idCategoria) throws DAOExcepcion {
		String query = "delete from categoria WHERE id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
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

	public Categoria actualizar(Categoria vo) throws DAOExcepcion {
		String query = "update categoria set nombre=?,descripcion=? where id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getIdCategoria());
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

	public Collection<Categoria> listar() throws DAOExcepcion {
		Collection<Categoria> c = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select id_categoria,nombre,descripcion from categoria order by nombre";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria vo = new Categoria();
				vo.setIdCategoria(rs.getInt("id_categoria"));
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
