package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.ControlAlmacen;
import net.takumi.entidades.DetControlAlmacen;

public interface IControlAlmacen {
	public List<ControlAlmacen> listarControlesAlm();
	public int agregarControlAlm(ControlAlmacen bean, List<DetControlAlmacen> detalle);
	public int eliminarControlAlm(int codigo_control_alm);
	public List<DetControlAlmacen> listarDetalleControlAlm(int codigo_control_alm);
	public int actualizarDetalleControlAlm(DetControlAlmacen bean);
	public int eliminarDetalleControlAlm(int codigo_control_alm);
	public DetControlAlmacen buscarDetalleControlAlm(int codigo_control, String numero_detalle_control);
	public String generarNumeroControl();
	public String generarCodigoControlAlmacen();
}
