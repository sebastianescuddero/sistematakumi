package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.TipoEgreso;

public interface ITipoEgreso {
	public List<TipoEgreso> listarTiposEgreso();
	public int agregarTipoEgreso(TipoEgreso bean);
	public int actualizarTipoEgreso(TipoEgreso bean);
	public int eliminarTipoEgreso(int codigo_tipo_egr);
	public TipoEgreso buscarTipoEgreso(int codigo_tipo_egr);
}
