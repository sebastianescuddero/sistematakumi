package net.takumi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.DetPagoTarjeta;
import net.takumi.entidades.PagoTarjeta;
import net.takumi.interfaces.IPagoTarjeta;
import net.takumi.util.ConexionMySQL;

public class PagoTarjetaDAO implements IPagoTarjeta {

	@Override
	public List<PagoTarjeta> listarControlesPagoTarj() {
		List<PagoTarjeta> lista = new ArrayList<PagoTarjeta>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from control_pagos_tarjeta";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				PagoTarjeta pt = new PagoTarjeta();
				pt.setCodigo_control_pago_tarj(rs.getInt(1));
				pt.setNumero_control_pago_tarj(rs.getString(2));
				pt.setMonto_total_pago_tarj(rs.getDouble(3));
				pt.setFecha_reg_form(rs.getString(4));
				lista.add(pt);
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
	public int agregarControlPagoTarj(PagoTarjeta bean, List<DetPagoTarjeta> detalle) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstmCon = null,
		pstmDet = null;
		try {
			cn=ConexionMySQL.getConexion();
			cn.setAutoCommit(false);
			String sqlControlPagTarj="insert into control_pagos_tarjeta values(?,?,0,CURDATE())";
			pstmCon=cn.prepareStatement(sqlControlPagTarj,Statement.RETURN_GENERATED_KEYS);
			pstmCon.setInt(1, bean.getCodigo_control_pago_tarj());
			pstmCon.setString(2, bean.getNumero_control_pago_tarj());
			salida=pstmCon.executeUpdate();
			
			ResultSet rs = pstmCon.getGeneratedKeys();
			rs.next();
			
			String sqlDetControl="call usp_insertar_detalle_pago_tarj(?,?,?,?)";
			for(DetPagoTarjeta d:detalle){
				pstmDet=cn.prepareStatement(sqlDetControl);
				pstmDet.setInt(1, d.getCodigo_control_pago_tarj());
				pstmDet.setString(2, d.getNumero_detalle_pago_tarj());
				pstmDet.setDouble(3, d.getMonto_pos());
				pstmDet.setInt(4, d.getCodigo_pos());
				salida=pstmDet.executeUpdate();
			}
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
				salida=-1;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmDet!=null) pstmDet.close();
				if(pstmCon!=null) pstmCon.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int eliminarControlPagoTarj(int codigo_control_pago_tarj) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_pago_tarj);
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
	public List<DetPagoTarjeta> listarDetalleControlPagoTarj(int codigo_control_pago_tarj) {
		List<DetPagoTarjeta> lista=new ArrayList<DetPagoTarjeta>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_pago_tarj);
			rs=pstm.executeQuery();
			while(rs.next()) {
				DetPagoTarjeta dpt = new DetPagoTarjeta();
				dpt.setCodigo_control_pago_tarj(rs.getInt(1));
				dpt.setNumero_detalle_pago_tarj(rs.getString(2));
				dpt.setMonto_pos(rs.getDouble(3));
				dpt.setCodigo_pos(rs.getInt(4));
				lista.add(dpt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int actualizarDetalleControlPagoTarj(DetPagoTarjeta bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_control_pago_tarj());
			pstm.setString(2, bean.getNumero_detalle_pago_tarj());
			pstm.setDouble(3, bean.getMonto_pos());
			pstm.setInt(4, bean.getCodigo_pos());
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
	public int eliminarDetalleControlPagoTarj(int codigo_control_pago_tarj) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_pago_tarj);
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
	public DetPagoTarjeta buscarDetalleControlPagoTarj(int codigo_control, String numero_detalle_control) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		DetPagoTarjeta dpt = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control);
			pstm.setString(2, numero_detalle_control);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dpt = new DetPagoTarjeta();
				dpt.setCodigo_control_pago_tarj(rs.getInt(1));
				dpt.setNumero_detalle_pago_tarj(rs.getString(2));
				dpt.setMonto_pos(rs.getDouble(3));
				dpt.setCodigo_pos(rs.getInt(4));
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
		return dpt;
	}

	@Override
	public String generarNumeroControlPagoTarj() {
		String num_con_pag_tar="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_numero_control_pago_tarj()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				num_con_pag_tar=rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return num_con_pag_tar;
	}

	@Override
	public String generarCodigoControlPagoTarj() {
		String cod_con_pag_tar="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_codigo_control_pago_tarj()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				cod_con_pag_tar=rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cod_con_pag_tar;
	}
}
