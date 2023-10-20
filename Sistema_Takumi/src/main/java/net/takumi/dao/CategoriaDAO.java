package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.Categoria;
import net.takumi.interfaces.ICategoria;
import net.takumi.util.ConexionMySQL;

public class CategoriaDAO implements ICategoria {

	@Override
	public List<Categoria> listarCategorias() {
		List<Categoria> lista = new ArrayList<Categoria>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from categoria";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setCodigo_cat(rs.getInt(1));
				c.setNombre_cat(rs.getString(2));
				c.setDescripcion_cat(rs.getString(3));
				lista.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int agregarCategoria(Categoria bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="insert into categoria values(null,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre_cat());
			pstm.setString(2, bean.getDescripcion_cat());
			salida=pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	@Override
	public int actualizarCategoria(Categoria bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="update categoria set nombre_categoria=?, descripcion_categoria=? where codigo_categoria=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre_cat());
			pstm.setString(2, bean.getDescripcion_cat());
			pstm.setInt(3, bean.getCodigo_cat());
			salida=pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int eliminarCategoria(int codigo_cat) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from categoria where codigo_categoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_cat);
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (cn != null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public Categoria buscarCategoria(int codigo_cat) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Categoria c = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from categoria where codigo_categoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_cat);
			rs = pstm.executeQuery();
			if(rs.next()) {
				c = new Categoria();
				c.setCodigo_cat(rs.getInt(1));
				c.setNombre_cat(rs.getString(2));
				c.setDescripcion_cat(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return c;
	}
}