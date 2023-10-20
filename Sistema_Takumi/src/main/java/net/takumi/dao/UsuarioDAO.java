package net.takumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.takumi.entidades.Usuario;
import net.takumi.interfaces.IUsuario;
import net.takumi.util.ConexionMySQL;

public class UsuarioDAO implements IUsuario{

	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = ConexionMySQL.getConexion();
			String sql = "select * from usuario";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setCodigo_usu(rs.getInt(1));
				u.setNombre_usu(rs.getString(2));
				lista.add(u);
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
	public int agregarUsuario(Usuario bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarUsuario(Usuario bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarUsuario(int codigo_usu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario buscarUsuario(int codigo_usu) {
		// TODO Auto-generated method stub
		return null;
	}

}
