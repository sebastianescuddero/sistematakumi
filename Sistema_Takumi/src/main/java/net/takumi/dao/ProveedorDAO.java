package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.Proveedor;
import net.takumi.interfaces.IProveedor;
import net.takumi.util.ConexionMySQL;

public class ProveedorDAO implements IProveedor {

	@Override
	public List<Proveedor> listarProveedores() {
		List<Proveedor> lista = new ArrayList<Proveedor>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from proveedor";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Proveedor pv = new Proveedor();
				pv.setCodigo_prov(rs.getInt(1));
				pv.setNombre_prov(rs.getString(2));
				pv.setDescripcion_prov(rs.getString(3));
				pv.setTelefono_prov(rs.getString(4));
				lista.add(pv);
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
	public int agregarProveedor(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="insert into proveedor values(null,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre_prov());
			pstm.setString(2, bean.getDescripcion_prov());
			pstm.setString(3, bean.getTelefono_prov());
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
	public int actualizarProveedor(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="update proveedor set nombre_proveedor=?, descripcion_proveedor=?, telefono_proveedor=? where codigo_proveedor=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre_prov());
			pstm.setString(2, bean.getDescripcion_prov());
			pstm.setString(3, bean.getTelefono_prov());
			pstm.setInt(4, bean.getCodigo_prov());
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
	public int eliminarProveedor(int codigo_prov) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from proveedor where codigo_proveedor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_prov);
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
	public Proveedor buscarProveedor(int codigo_prov) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Proveedor pv = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from proveedor where codigo_proveedor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_prov);
			rs = pstm.executeQuery();
			if(rs.next()) {
				pv = new Proveedor();
				pv.setCodigo_prov(rs.getInt(1));
				pv.setNombre_prov(rs.getString(2));
				pv.setDescripcion_prov(rs.getString(3));
				pv.setTelefono_prov(rs.getString(4));
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
		return pv;
	}
}