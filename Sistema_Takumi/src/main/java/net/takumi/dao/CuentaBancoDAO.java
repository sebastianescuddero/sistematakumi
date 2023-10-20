package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.CuentaBanco;
import net.takumi.entidades.DetCuentaBanco;
import net.takumi.interfaces.ICuentaBanco;
import net.takumi.util.ConexionMySQL;

public class CuentaBancoDAO implements ICuentaBanco {

	@Override
	public List<CuentaBanco> listarCuentasBanco() {
		List<CuentaBanco> lista = new ArrayList<CuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from cuentas_banco";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CuentaBanco cb = new CuentaBanco();
				cb.setCodigo_cuenta_banc(rs.getInt(1));
				cb.setCuenta_banc(rs.getString(2));
				cb.setNumero_cuenta_banc(rs.getString(3));
				cb.setIngreso_total_cuenta(rs.getDouble(4));
				cb.setEgreso_total_cuenta(rs.getDouble(5));
				cb.setBalance_cuenta(rs.getDouble(6));;
				lista.add(cb);
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
	public int agregarCuentaBanco(CuentaBanco bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarCuentaBanco(CuentaBanco bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCuentaBanco(int codigo_banc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CuentaBanco buscarCuentaBanco(int codigo_banc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetCuentaBanco> listarMovimientosBancoBcp() {
		List<DetCuentaBanco> lista = new ArrayList<DetCuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_movimientos_banco_bcp()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				DetCuentaBanco dcb = new DetCuentaBanco();
				dcb.setNombre_cuenta_banc(rs.getString(1));
				dcb.setIngreso(rs.getDouble(2));
				dcb.setEgreso(rs.getDouble(3));
				dcb.setFecha_reg_form(rs.getString(4));
				lista.add(dcb);
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
	public List<DetCuentaBanco> listarMovimientosBancoBbva() {
		List<DetCuentaBanco> lista = new ArrayList<DetCuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_movimientos_banco_bbva()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				DetCuentaBanco dcb = new DetCuentaBanco();
				dcb.setNombre_cuenta_banc(rs.getString(1));
				dcb.setIngreso(rs.getDouble(2));
				dcb.setEgreso(rs.getDouble(3));
				dcb.setFecha_reg_form(rs.getString(4));
				lista.add(dcb);
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
	public List<DetCuentaBanco> listarMovimientosBancoInterbank() {
		List<DetCuentaBanco> lista = new ArrayList<DetCuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_movimientos_banco_interbank()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				DetCuentaBanco dcb = new DetCuentaBanco();
				dcb.setNombre_cuenta_banc(rs.getString(1));
				dcb.setIngreso(rs.getDouble(2));
				dcb.setEgreso(rs.getDouble(3));
				dcb.setFecha_reg_form(rs.getString(4));
				lista.add(dcb);
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
	public List<CuentaBanco> listarCuentasBcp() {
		List<CuentaBanco> lista = new ArrayList<CuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_cuentas_bcp()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CuentaBanco cb = new CuentaBanco();
				cb.setCodigo_cuenta_banc(rs.getInt(1));
				cb.setCuenta_banc(rs.getString(2));
				cb.setNumero_cuenta_banc(rs.getString(3));
				cb.setIngreso_total_cuenta(rs.getDouble(4));
				cb.setEgreso_total_cuenta(rs.getDouble(5));
				cb.setBalance_cuenta(rs.getDouble(6));
				lista.add(cb);
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
	public List<CuentaBanco> listarCuentasBbva() {
		List<CuentaBanco> lista = new ArrayList<CuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_cuentas_bbva()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CuentaBanco cb = new CuentaBanco();
				cb.setCodigo_cuenta_banc(rs.getInt(1));
				cb.setCuenta_banc(rs.getString(2));
				cb.setNumero_cuenta_banc(rs.getString(3));
				cb.setIngreso_total_cuenta(rs.getDouble(4));
				cb.setEgreso_total_cuenta(rs.getDouble(5));
				cb.setBalance_cuenta(rs.getDouble(6));
				lista.add(cb);
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
	public List<CuentaBanco> listarCuentasInterbank() {
		List<CuentaBanco> lista = new ArrayList<CuentaBanco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_cuentas_interbank()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CuentaBanco cb = new CuentaBanco();
				cb.setCodigo_cuenta_banc(rs.getInt(1));
				cb.setCuenta_banc(rs.getString(2));
				cb.setNumero_cuenta_banc(rs.getString(3));
				cb.setIngreso_total_cuenta(rs.getDouble(4));
				cb.setEgreso_total_cuenta(rs.getDouble(5));
				cb.setBalance_cuenta(rs.getDouble(6));
				lista.add(cb);
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
