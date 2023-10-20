package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.MetodoPago;

public interface IMetodoPago {
	public List<MetodoPago> listarMetodosPago();
	public int agregarMetodoPago(MetodoPago bean);
	public int actualizarMetodoPago(MetodoPago bean);
	public int eliminarMetodoPago(int codigo_met_pago);
	public MetodoPago buscarMetodoPago(int codigo_met_pago);
}
