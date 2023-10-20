package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.ControlEgreso;
import net.takumi.entidades.DetControlEgreso;

public interface IControlEgreso {
	public List<ControlEgreso> listarControlesEgr();
	public List<ControlEgreso> listarControlesEgrSemana();
	public int agregarControlEgr(ControlEgreso bean, List<DetControlEgreso> detalle);
	public int eliminarControlEgr(int codigo_control_egr);
	public List<DetControlEgreso> listarDetalleControlEgr(int codigo_control_egr);
	public int actualizarDetalleControlEgr(DetControlEgreso bean);
	public int eliminarDetalleControlEgr(int codigo_control_egr);
	public DetControlEgreso buscarDetalleControlEgr(int codigo_control, String numero_detalle_control);
	public String generarNumeroControlEgreso();
	public String generarCodigoControlEgreso();
}
