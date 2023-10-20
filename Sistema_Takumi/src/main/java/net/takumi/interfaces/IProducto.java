package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.Producto;

public interface IProducto {
	public List<Producto> listarProductos();
	public int agregarProducto(Producto bean);
	public int actualizarProducto(Producto bean);
	public int eliminarProducto(int codigo_pro);
	public Producto buscarProducto(int codigo_pro);
	public String generarCodigoProducto();
}
