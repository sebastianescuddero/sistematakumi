package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.POS;
import net.takumi.interfaces.IPos;
import net.takumi.util.ConexionMySQL;

public class PosDAO implements IPos {

	@Override
	public List<POS> listarPOS() {
		List<POS> lista = new ArrayList<POS>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from pos";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				POS p = new POS();
				p.setCodigo_pos(rs.getInt(1));
				p.setPos(rs.getString(2));
				p.setNumero_pos(rs.getString(3));
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
	public int agregarPOS(POS bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarPOS(POS bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarPOS(int codigo_pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public POS buscarPOS(int codigo_pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
