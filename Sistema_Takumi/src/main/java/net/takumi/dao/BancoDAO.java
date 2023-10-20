package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.Banco;
import net.takumi.interfaces.IBanco;
import net.takumi.util.ConexionMySQL;

public class BancoDAO implements IBanco {

	@Override
	public List<Banco> listarBancos() {
		List<Banco> lista = new ArrayList<Banco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from bancos";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Banco b = new Banco();
				b.setCodigo_banc(rs.getInt(1));
				b.setNombre_banc(rs.getString(2));
				b.setSuma_ingresos_banc(rs.getDouble(3));
				b.setSuma_egresos_banc(rs.getDouble(4));
				b.setBalance_banc(rs.getDouble(5));
				lista.add(b);
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
	public int agregarBanco(Banco bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_banc());
			pstm.setString(2, bean.getNombre_banc());
			pstm.setDouble(3,  bean.getSuma_ingresos_banc());
			pstm.setDouble(4,  bean.getSuma_egresos_banc());
			pstm.setDouble(5,  bean.getBalance_banc());
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
	public int actualizarBanco(Banco bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=ConexionMySQL.getConexion();
			String sql="";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodigo_banc());
			pstm.setString(2, bean.getNombre_banc());
			pstm.setDouble(3,  bean.getSuma_ingresos_banc());
			pstm.setDouble(4,  bean.getSuma_egresos_banc());
			pstm.setDouble(5,  bean.getBalance_banc());
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
	public int eliminarBanco(int codigo_banc) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_banc);
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
	public Banco buscarBanco(int codigo_banc) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Banco b = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from bancos where codigo_banco=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_banc);
			rs = pstm.executeQuery();
			if(rs.next()) {
				b = new Banco();
				b.setCodigo_banc(rs.getInt(1));
				b.setNombre_banc(rs.getString(2));
				b.setSuma_ingresos_banc(rs.getDouble(3));
				b.setSuma_egresos_banc(rs.getDouble(4));
				b.setBalance_banc(rs.getDouble(5));
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
		return b;
	}

	@Override
	public List<Banco> listarBalanceBancBcp() {
		List<Banco> lista = new ArrayList<Banco>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from bancos";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Banco b = new Banco();
				b.setCodigo_banc(rs.getInt(1));
				b.setNombre_banc(rs.getString(2));
				b.setSuma_ingresos_banc(rs.getDouble(3));
				b.setSuma_egresos_banc(rs.getDouble(4));
				b.setBalance_banc(rs.getDouble(5));
				lista.add(b);
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
	public List<Banco> listarBalanceBancBbva() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banco> listarBalanceBancInterbank() {
		// TODO Auto-generated method stub
		return null;
	}
}