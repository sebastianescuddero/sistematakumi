package net.takumi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.ControlEgreso;
import net.takumi.entidades.DetControlEgreso;
import net.takumi.interfaces.IControlEgreso;
import net.takumi.util.ConexionMySQL;

public class ControlEgresoDAO implements IControlEgreso {

	@Override
	public List<ControlEgreso> listarControlesEgr() {
		List<ControlEgreso> lista=new ArrayList<ControlEgreso>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_listar_control_egresos()";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				ControlEgreso ce = new ControlEgreso();
				ce.setCodigo_control_egr(rs.getInt(1));
				ce.setNumero_control_egr(rs.getString(2));
				ce.setMonto_total_efec(rs.getDouble(3));
				ce.setMonto_total_elec(rs.getDouble(4));
				ce.setMonto_total_egr(rs.getDouble(5));
				ce.setFecha_reg_form(rs.getString(6));
				lista.add(ce);
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
	public List<ControlEgreso> listarControlesEgrSemana() {
		List<ControlEgreso> lista=new ArrayList<ControlEgreso>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_listar_control_egresos_semana()";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				ControlEgreso ce = new ControlEgreso();
				ce.setCodigo_control_egr(rs.getInt(1));
				ce.setNumero_control_egr(rs.getString(2));
				ce.setMonto_total_efec(rs.getDouble(3));
				ce.setMonto_total_elec(rs.getDouble(4));
				ce.setMonto_total_egr(rs.getDouble(5));
				ce.setFecha_reg_form(rs.getString(6));
				lista.add(ce);
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
	public int agregarControlEgr(ControlEgreso bean, List<DetControlEgreso> detalle) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstmCon = null,
		pstmDet = null;
		try {
			cn=ConexionMySQL.getConexion();
			cn.setAutoCommit(false);
			String sqlControlEgr="insert into control_egresos values(?,?,0,0,0,CURDATE())";
			pstmCon=cn.prepareStatement(sqlControlEgr,Statement.RETURN_GENERATED_KEYS);
			pstmCon.setInt(1, bean.getCodigo_control_egr());
			pstmCon.setString(2, bean.getNumero_control_egr());
			salida=pstmCon.executeUpdate();
			
			ResultSet rs = pstmCon.getGeneratedKeys();
			rs.next();
			
			String sqlDetControl="call usp_insertar_detalle_control_egr(?,?,?,?,?,?)";
			for(DetControlEgreso d:detalle){
				pstmDet=cn.prepareStatement(sqlDetControl);
				pstmDet.setInt(1, d.getCodigo_control_egr());
				pstmDet.setString(2, d.getNumero_detalle_control_egr());
				pstmDet.setDouble(3, d.getMonto_egr());
				pstmDet.setString(4, d.getDescripcion_razon_egr());
				pstmDet.setInt(5, d.getCodigo_tip_egr());
				pstmDet.setInt(6, d.getCodigo_met_pago());
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
	public int eliminarControlEgr(int codigo_control_egr) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_egr);
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
	public List<DetControlEgreso> listarDetalleControlEgr(int codigo_control_egr) {
		List<DetControlEgreso> lista=new ArrayList<DetControlEgreso>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_egr);
			rs=pstm.executeQuery();
			while(rs.next()) {
				DetControlEgreso de = new DetControlEgreso();
				de.setCodigo_control_egr(rs.getInt(1));
				de.setNumero_detalle_control_egr(rs.getString(2));
				de.setMonto_egr(rs.getDouble(3));
				de.setDescripcion_razon_egr(rs.getString(4));
				de.setCodigo_tip_egr(rs.getInt(5));
				de.setCodigo_met_pago(rs.getInt(6));
				lista.add(de);
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
	public int actualizarDetalleControlEgr(DetControlEgreso bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_control_egr());
			pstm.setString(2, bean.getNumero_detalle_control_egr());
			pstm.setDouble(3, bean.getMonto_egr());
			pstm.setString(4, bean.getDescripcion_razon_egr());
			pstm.setInt(5, bean.getCodigo_tip_egr());
			pstm.setInt(6, bean.getCodigo_met_pago());
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
	public int eliminarDetalleControlEgr(int codigo_control_egr) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_egr);
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
	public DetControlEgreso buscarDetalleControlEgr(int codigo_control, String numero_detalle_control) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		DetControlEgreso dce = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control);
			pstm.setString(2, numero_detalle_control);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dce = new DetControlEgreso();
				dce.setCodigo_control_egr(rs.getInt(1));
				dce.setNumero_detalle_control_egr(rs.getString(2));
				dce.setMonto_egr(rs.getDouble(3));
				dce.setDescripcion_razon_egr(rs.getString(4));
				dce.setCodigo_tip_egr(rs.getInt(5));
				dce.setCodigo_met_pago(rs.getInt(6));
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
		return dce;
	}

	@Override
	public String generarNumeroControlEgreso() {
		String num_con_egr="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_numero_control_egresos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				num_con_egr=rs.getString(1);
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
		return num_con_egr;
	}

	@Override
	public String generarCodigoControlEgreso() {
		String cod_con_egr="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_codigo_control_egresos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				cod_con_egr=rs.getString(1);
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
		return cod_con_egr;
	}
}