package net.takumi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.Producto;
import net.takumi.interfaces.IProducto;
import net.takumi.util.ConexionMySQL;

public class ProductoDAO implements IProducto {

	@Override
	public List<Producto> listarProductos() {
		List<Producto> lista = new ArrayList<Producto>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "call usp_listar_productos()";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Producto p = new Producto();
				p.setCodigo_pro(rs.getInt(1));
				p.setNombre_pro(rs.getString(2));
				p.setNombre_cat(rs.getString(3));
				p.setNombre_prov(rs.getString(4));
				p.setCantidad(rs.getInt(5));
				p.setDescripcion_can(rs.getString(6));
				p.setNumero_lote(rs.getString(7));
				p.setFecha_ven_form(rs.getString(8));
				lista.add(p);
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
	public int agregarProducto(Producto bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="insert into producto values(?,?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, bean.getCodigo_pro());
			pstm.setString(2, bean.getNombre_pro());
			pstm.setInt(3, bean.getCodigo_cat());
			pstm.setInt(4, bean.getCodigo_prov());
			pstm.setInt(5, bean.getCantidad());
			pstm.setString(6, bean.getDescripcion_can());
			pstm.setString(7, bean.getNumero_lote());
			pstm.setDate(8, bean.getFecha_ven());
			salida=pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();
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
	public int eliminarProducto(int codigo_pro) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "delete from producto where codigo_producto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_pro);
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
	public int actualizarProducto(Producto bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="update producto set nombre_producto=?, codigo_categoria=?, codigo_proveedor=?, cantidad=?, descripcion_cantidad=?, "
						+ "numero_lote=?, fecha_vencimiento=? where codigo_producto=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre_pro());
			pstm.setInt(2, bean.getCodigo_cat());
			pstm.setInt(3, bean.getCodigo_cat());
			pstm.setInt(4, bean.getCantidad());
			pstm.setString(5, bean.getDescripcion_can());
			pstm.setString(6, bean.getNumero_lote());
			pstm.setDate(7, bean.getFecha_ven());
			pstm.setInt(8, bean.getCodigo_pro());
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
	public Producto buscarProducto(int codigo_pro) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Producto p = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select codigo_producto, nombre_producto, codigo_categoria, codigo_proveedor, cantidad_actual,"
					+ "descripcion_cantidad, numero_lote, fecha_vencimiento from producto where codigo_producto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_pro);
			rs = pstm.executeQuery();
			if(rs.next()) {
				p = new Producto();
				p.setCodigo_pro(rs.getInt(1));
				p.setNombre_pro(rs.getString(2));
				p.setCodigo_cat(rs.getInt(3));
				p.setCodigo_prov(rs.getInt(4));
				p.setCantidad(rs.getInt(5));
				p.setDescripcion_can(rs.getString(6));
				p.setNumero_lote(rs.getString(7));
				p.setFecha_ven_form(rs.getString(8));
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
		return p;
	}

	@Override
	public String generarCodigoProducto() {
		String cod_pro="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="call usp_generar_codigo_producto()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			if(rs.next())
				cod_pro=rs.getString(1);
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
		return cod_pro;
	}
}