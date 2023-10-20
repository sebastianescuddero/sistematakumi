package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.Proveedor;

public interface IProveedor {
	public List<Proveedor> listarProveedores();
	public int agregarProveedor(Proveedor bean);
	public int actualizarProveedor(Proveedor bean);
	public int eliminarProveedor(int codigo_prov);
	public Proveedor buscarProveedor(int codigo_prov);
}
