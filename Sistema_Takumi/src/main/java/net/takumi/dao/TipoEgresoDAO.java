package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.TipoEgreso;
import net.takumi.interfaces.ITipoEgreso;
import net.takumi.util.ConexionMySQL;

public class TipoEgresoDAO implements ITipoEgreso{

	@Override
	public List<TipoEgreso> listarTiposEgreso() {
		List<TipoEgreso> lista = new ArrayList<TipoEgreso>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from tipo_egreso";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				TipoEgreso te = new TipoEgreso();
				te.setCodigo_tipo_egr(rs.getInt(1));
				te.setTipo_egr(rs.getString(2));
				te.setDescripcion_tipo_egr(rs.getString(3));
				lista.add(te);
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
	public int agregarTipoEgreso(TipoEgreso bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarTipoEgreso(TipoEgreso bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarTipoEgreso(int codigo_tipo_egr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TipoEgreso buscarTipoEgreso(int codigo_tipo_egr) {
		// TODO Auto-generated method stub
		return null;
	}

}
