package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.Caja;
import net.takumi.entidades.DetCaja;

public interface ICaja {
	// M�todo de Caja
	public List<Caja> listarCajas();
	public int agregarCaja(Caja bean);
	public int actualizarCaja(Caja bean);
	public int eliminarCaja(int codigo_caja);
	public Caja buscarCaja(int codigo_caja);
	
	// M�todos de Detalle Caja
	public List<DetCaja> listarDetCaja();
}
