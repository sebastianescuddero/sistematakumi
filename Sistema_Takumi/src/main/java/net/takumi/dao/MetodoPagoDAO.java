package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.MetodoPago;
import net.takumi.interfaces.IMetodoPago;
import net.takumi.util.ConexionMySQL;

public class MetodoPagoDAO implements IMetodoPago {

	@Override
	public List<MetodoPago> listarMetodosPago() {
		List<MetodoPago> lista = new ArrayList<MetodoPago>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from metodos_pago";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				MetodoPago mp = new MetodoPago();
				mp.setCodigo_met_pago(rs.getInt(1));
				mp.setNombre_met_pago(rs.getString(2));
				lista.add(mp);
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
	public int agregarMetodoPago(MetodoPago bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_met_pago());
			pstm.setString(2, bean.getNombre_met_pago());
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
	public int actualizarMetodoPago(MetodoPago bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre_met_pago());
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
	public int eliminarMetodoPago(int codigo_met_pago) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_met_pago);
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
	public MetodoPago buscarMetodoPago(int codigo_met_pago) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MetodoPago mp = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_met_pago);
			rs = pstm.executeQuery();
			if(rs.next()) {
				mp = new MetodoPago();
				mp.setCodigo_met_pago(rs.getInt(1));
				mp.setNombre_met_pago(rs.getString(2));
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
		return mp;
	}
}