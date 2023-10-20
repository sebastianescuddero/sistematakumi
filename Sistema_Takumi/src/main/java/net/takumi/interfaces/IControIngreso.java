package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.ControIngreso;
import net.takumi.entidades.DetControIngreso;

public interface IControIngreso {
	public List<ControIngreso> listarControlesIng();
	public List<ControIngreso> listarControlesIngSemana();
	public int agregarControlIng(ControIngreso bean, List<DetControIngreso> detalle);
	public int eliminarControlIng(int codigo_control_ing);
	public List<DetControIngreso> listarDetalleControlIng(int codigo_control_ing);
	public int actualizarDetalleControlIng(DetControIngreso bean);
	public int eliminarDetalleControlIng(int codigo_control_ing);
	public DetControIngreso buscarDetalleControlIng(int codigo_control, String numero_detalle_control);
	public String generarNumeroControlIngreso();
	public String generarCodigoControlIngreso();
}
