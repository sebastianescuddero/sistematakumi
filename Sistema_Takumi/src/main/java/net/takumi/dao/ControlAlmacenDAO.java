package net.takumi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.ControlAlmacen;
import net.takumi.entidades.DetControlAlmacen;
import net.takumi.interfaces.IControlAlmacen;
import net.takumi.util.ConexionMySQL;

public class ControlAlmacenDAO implements IControlAlmacen {

	@Override
	public List<ControlAlmacen> listarControlesAlm() {
		List<ControlAlmacen> lista=new ArrayList<ControlAlmacen>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="select * from control_almacen";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				ControlAlmacen ca = new ControlAlmacen();
				ca.setCodigo_control_alm(rs.getInt(1));
				ca.setNumero_control_alm(rs.getString(2));
				ca.setFecha_reg_form(rs.getString(3));
				lista.add(ca);
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
	public int agregarControlAlm(ControlAlmacen bean, List<DetControlAlmacen> detalle) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstmCon = null,
		pstmDet = null;
		try {
			cn=ConexionMySQL.getConexion();
			cn.setAutoCommit(false);
			String sqlControl="insert into control_almacen values(?,?,CURDATE())";
			pstmCon=cn.prepareStatement(sqlControl,Statement.RETURN_GENERATED_KEYS);
			pstmCon.setInt(1, bean.getCodigo_control_alm());
			pstmCon.setString(2, bean.getNumero_control_alm());
			salida=pstmCon.executeUpdate();
			
			ResultSet rs = pstmCon.getGeneratedKeys();
			rs.next();
			
			String sqlDetControl="call usp_insertar_detalle_control_alm(?,?,?,?,?,?)";
			for(DetControlAlmacen d:detalle){
				pstmDet=cn.prepareStatement(sqlDetControl);
				pstmDet.setInt(1, d.getCodigo_control_alm());
				pstmDet.setString(2, d.getNumero_detalle_control_alm());
				pstmDet.setInt(3, d.getCodigo_pro());
				pstmDet.setInt(4, d.getCantidad_pro());
				pstmDet.setString(5, d.getTipo_control_alm());
				pstmDet.setInt(6, d.getCodigo_usu());
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
	public int eliminarControlAlm(int codigo_control_alm) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from control_almacen where codigo_control_almacen=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_alm);
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
	public List<DetControlAlmacen> listarDetalleControlAlm(int codigo_control_alm) {
		List<DetControlAlmacen> lista=new ArrayList<DetControlAlmacen>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_listar_detalle_control_alm(?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_alm);
			rs=pstm.executeQuery();
			while(rs.next()) {
				DetControlAlmacen dc = new DetControlAlmacen();
				dc.setCodigo_control_alm(rs.getInt(1));
				dc.setNumero_detalle_control_alm(rs.getString(2));
				dc.setNombre_pro(rs.getString(3));
				dc.setCantidad_pro(rs.getInt(4));
				dc.setTipo_control_alm(rs.getString(5));
				dc.setFecha_ven_form(rs.getString(6));
				dc.setNombre_usu(rs.getString(7));
				lista.add(dc);
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
	public int actualizarDetalleControlAlm(DetControlAlmacen bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_actualizar_detalle_control_alm(?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_control_alm());
			pstm.setString(2, bean.getNumero_detalle_control_alm());
			pstm.setInt(3, bean.getCodigo_pro());
			pstm.setInt(4, bean.getCantidad_pro());
			pstm.setString(5, bean.getTipo_control_alm());
			pstm.setInt(6, bean.getCodigo_usu());
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
	public int eliminarDetalleControlAlm(int codigo_control_alm) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from detalle_control_almacen where codigo_control_almacen=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control_alm);
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
	public DetControlAlmacen buscarDetalleControlAlm(int codigo_control, String numero_detalle_control) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		DetControlAlmacen dc = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_buscar_detalle_control_alm(?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_control);
			pstm.setString(2, numero_detalle_control);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dc = new DetControlAlmacen();
				dc.setCodigo_control_alm(rs.getInt(1));
				dc.setNumero_detalle_control_alm(rs.getString(2));
				dc.setCodigo_pro(rs.getInt(3));
				dc.setCantidad_pro(rs.getInt(4));
				dc.setTipo_control_alm(rs.getString(5));
				dc.setFecha_ven_form(rs.getString(6));
				dc.setCodigo_usu(rs.getInt(7));
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
		return dc;
	}

	@Override
	public String generarNumeroControl() {
		String num_con="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_numero_control_almacen()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				num_con=rs.getString(1);
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
		return num_con;
	}

	@Override
	public String generarCodigoControlAlmacen() {
		String cod_con_alm="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_codigo_control_almacen()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				cod_con_alm=rs.getString(1);
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
		return cod_con_alm;
	}
}