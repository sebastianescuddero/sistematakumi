package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.DetPagoTarjeta;
import net.takumi.entidades.PagoTarjeta;

public interface IPagoTarjeta {
	public List<PagoTarjeta> listarControlesPagoTarj();
	public int agregarControlPagoTarj(PagoTarjeta bean, List<DetPagoTarjeta> detalle);
	public int eliminarControlPagoTarj(int codigo_control_pago_tarj);
	public List<DetPagoTarjeta> listarDetalleControlPagoTarj(int codigo_control_pago_tarj);
	public int actualizarDetalleControlPagoTarj(DetPagoTarjeta bean);
	public int eliminarDetalleControlPagoTarj(int codigo_control_pago_tarj);
	public DetPagoTarjeta buscarDetalleControlPagoTarj(int codigo_control, String numero_detalle_control);
	public String generarNumeroControlPagoTarj();
	public String generarCodigoControlPagoTarj();
}
