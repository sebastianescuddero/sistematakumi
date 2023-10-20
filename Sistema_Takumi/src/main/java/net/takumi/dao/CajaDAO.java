package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.Caja;
import net.takumi.entidades.DetCaja;
import net.takumi.interfaces.ICaja;
import net.takumi.util.ConexionMySQL;

public class CajaDAO implements ICaja {

	@Override
	public List<Caja> listarCajas() {
		List<Caja> lista = new ArrayList<Caja>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from cajas";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Caja c = new Caja();
				c.setCodigo_caja(rs.getInt(1));
				c.setNombre_caja(rs.getString(2));
				c.setSuma_ingresos_caja(rs.getDouble(3));
				c.setSuma_egresos_caja(rs.getDouble(4));
				c.setBalance_caja(rs.getDouble(5));
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
	public int agregarCaja(Caja bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarCaja(Caja bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCaja(int codigo_caja) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Caja buscarCaja(int codigo_caja) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Caja c = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from cajas where codigo_caja=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_caja);
			rs = pstm.executeQuery();
			if(rs.next()) {
				c = new Caja();
				c.setCodigo_caja(rs.getInt(1));
				c.setNombre_caja(rs.getString(2));
				c.setSuma_ingresos_caja(rs.getDouble(3));
				c.setSuma_egresos_caja(rs.getDouble(4));
				c.setBalance_caja(rs.getDouble(5));
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

	@Override
	public List<DetCaja> listarDetCaja() {
		List<DetCaja> lista = new ArrayList<DetCaja>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_detalles_caja()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				DetCaja dc = new DetCaja();
				dc.setDet_nombre_caja(rs.getString(1));
				dc.setIngreso_caja(rs.getDouble(2));
				dc.setEgreso_caja(rs.getDouble(3));
				dc.setFecha_reg_form(rs.getString(4));
				lista.add(dc);
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
}
