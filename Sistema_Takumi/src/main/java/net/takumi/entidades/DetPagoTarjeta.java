package net.takumi.entidades;

public class DetPagoTarjeta {
	private int codigo_control_pago_tarj, codigo_pos;
	private String numero_detalle_pago_tarj, pos;
	private double monto_pos;
	
	public int getCodigo_control_pago_tarj() {
		return codigo_control_pago_tarj;
	}
	public void setCodigo_control_pago_tarj(int codigo_control_pago_tarj) {
		this.codigo_control_pago_tarj = codigo_control_pago_tarj;
	}
	public int getCodigo_pos() {
		return codigo_pos;
	}
	public void setCodigo_pos(int codigo_pos) {
		this.codigo_pos = codigo_pos;
	}
	public String getNumero_detalle_pago_tarj() {
		return numero_detalle_pago_tarj;
	}
	public void setNumero_detalle_pago_tarj(String numero_detalle_pago_tarj) {
		this.numero_detalle_pago_tarj = numero_detalle_pago_tarj;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public double getMonto_pos() {
		return monto_pos;
	}
	public void setMonto_pos(double monto_pos) {
		this.monto_pos = monto_pos;
	}
}
