package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.Categoria;

public interface ICategoria {
	public List<Categoria> listarCategorias();
	public int agregarCategoria(Categoria bean);
	public int actualizarCategoria(Categoria bean);
	public int eliminarCategoria(int codigo_cat);
	public Categoria buscarCategoria(int codigo_cat);
}
