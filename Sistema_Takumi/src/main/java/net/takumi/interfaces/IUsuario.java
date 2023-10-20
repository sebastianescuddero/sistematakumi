package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.Usuario;

public interface IUsuario {
	public List<Usuario> listarUsuarios();
	public int agregarUsuario(Usuario bean);
	public int actualizarUsuario(Usuario bean);
	public int eliminarUsuario(int codigo_usu);
	public Usuario buscarUsuario(int codigo_usu);
}
