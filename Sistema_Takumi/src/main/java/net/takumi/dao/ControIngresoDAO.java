package net.takumi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.ControIngreso;
import net.takumi.entidades.DetControIngreso;
import net.takumi.interfaces.IControIngreso;
import net.takumi.util.ConexionMySQL;

public class ControIngresoDAO implements IControIngreso{

	@Override
	public List<ControIngreso> listarControlesIng() {
		List<ControIngreso> lista=new ArrayList<ControIngreso>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_listar_control_ingresos()";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				ControIngreso ci = new ControIngreso();
				ci.setCodigo_control_ing(rs.getInt(1));
				ci.setNumero_control_ing(rs.getString(2));
				ci.setMonto_total_efec(rs.getDouble(3));
				ci.setMonto_total_elec(rs.getDouble(4));
				ci.setMonto_total_ing(rs.getDouble(5));
				ci.setFecha_reg_form(rs.getString(6));
				lista.add(ci);
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
	public List<ControIngreso> listarControlesIngSemana() {
		List<ControIngreso> lista=new ArrayList<ControIngreso>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_listar_control_ingresos_semana()";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				ControIngreso ci = new ControIngreso();
				ci.setCodigo_control_ing(rs.getInt(1));
				ci.setNumero_control_ing(rs.getString(2));
				ci.setMonto_total_efec(rs.getDouble(3));
				ci.setMonto_total_elec(rs.getDouble(4));
				ci.setMonto_total_ing(rs.getDouble(5));
				ci.setFecha_reg_form(rs.getString(6));
				lista.add(ci);
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
	public int agregarControlIng(ControIngreso bean, List<DetControIngreso> detalle) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstmCon = null,
		pstmDet = null;
		try {
			cn=ConexionMySQL.getConexion();
			cn.setAutoCommit(false);
			String sqlControlIng="insert into control_ingresos values(?,?,0,0,0,CURDATE())";
			pstmCon=cn.prepareStatement(sqlControlIng,Statement.RETURN_GENERATED_KEYS);
			pstmCon.setInt(1, bean.getCodigo_control_ing());
			pstmCon.setString(2, bean.getNumero_control_ing());
			salida=pstmCon.executeUpdate();
			
			ResultSet rs = pstmCon.getGeneratedKeys();
			rs.next();
			
			String sqlDetControl="call usp_insertar_detalle_control_ing(?,?,?,?,?)";
			for(DetControIngreso d:detalle){
				pstmDet=cn.prepareStatement(sqlDetControl);
				pstmDet.setInt(1, d.getCodigo_control_ing());
				pstmDet.setString(2, d.getNumero_detalle_control_ing());
				pstmDet.setDouble(3, d.getMonto_ing());
				pstmDet.setInt(4, d.getCodigo_met_pago());
				pstmDet.setString(5, d.getDescripcion_otro_ing());
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
	public int eliminarControlIng(int codigo_control_ing) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from control_ingresos where codigo_control_ingreso=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_ing);
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
	public List<DetControIngreso> listarDetalleControlIng(int codigo_control_ing) {
		List<DetControIngreso> lista=new ArrayList<DetControIngreso>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_listar_detalle_control_ing(?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_ing);
			rs=pstm.executeQuery();
			while(rs.next()) {
				DetControIngreso di = new DetControIngreso();
				di.setCodigo_control_ing(rs.getInt(1));
				di.setNumero_detalle_control_ing(rs.getString(2));
				di.setMonto_ing(rs.getDouble(3));
				di.setCodigo_met_pago(rs.getInt(4));
				di.setDescripcion_otro_ing(rs.getString(5));
				lista.add(di);
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
	public int actualizarDetalleControlIng(DetControIngreso bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_insertar_actualizar_detalle_control_ing(?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_control_ing());
			pstm.setString(2, bean.getNumero_detalle_control_ing());
			pstm.setDouble(3, bean.getMonto_ing());
			pstm.setInt(4, bean.getCodigo_met_pago());
			pstm.setString(5, bean.getDescripcion_otro_ing());
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
	public int eliminarDetalleControlIng(int codigo_control_ing) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from control_ingresos where codigo_control_ingresos=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_ing);
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
	public DetControIngreso buscarDetalleControlIng(int codigo_control, String numero_detalle_control) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		DetControIngreso dci = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_buscar_detalle_control_ing(?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control);
			pstm.setString(2, numero_detalle_control);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dci = new DetControIngreso();
				dci.setCodigo_control_ing(rs.getInt(1));
				dci.setNumero_detalle_control_ing(rs.getString(2));
				dci.setMonto_ing(rs.getDouble(3));
				dci.setCodigo_met_pago(rs.getInt(4));
				dci.setDescripcion_otro_ing(rs.getString(5));
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
		return dci;
	}

	@Override
	public String generarNumeroControlIngreso() {
		String num_con_ing="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_numero_control_ingresos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				num_con_ing=rs.getString(1);
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
		return num_con_ing;
	}

	@Override
	public String generarCodigoControlIngreso() {
		String cod_con_ing="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_codigo_control_ingresos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				cod_con_ing=rs.getString(1);
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
		return cod_con_ing;
	}
}