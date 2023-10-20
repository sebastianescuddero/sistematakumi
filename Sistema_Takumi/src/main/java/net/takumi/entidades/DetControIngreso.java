package net.takumi.entidades;

public class DetControIngreso {
	private int codigo_control_ing, codigo_met_pago;
	private double monto_ing;
	private String descripcion_otro_ing, numero_detalle_control_ing, met_pago;
	
	public int getCodigo_control_ing() {
		return codigo_control_ing;
	}
	public void setCodigo_control_ing(int codigo_control_ing) {
		this.codigo_control_ing = codigo_control_ing;
	}
	public int getCodigo_met_pago() {
		return codigo_met_pago;
	}
	public void setCodigo_met_pago(int codigo_met_pago) {
		this.codigo_met_pago = codigo_met_pago;
	}
	public double getMonto_ing() {
		return monto_ing;
	}
	public void setMonto_ing(double monto_ing) {
		this.monto_ing = monto_ing;
	}
	public String getDescripcion_otro_ing() {
		return descripcion_otro_ing;
	}
	public void setDescripcion_otro_ing(String descripcion_otro_ing) {
		this.descripcion_otro_ing = descripcion_otro_ing;
	}
	public String getNumero_detalle_control_ing() {
		return numero_detalle_control_ing;
	}
	public void setNumero_detalle_control_ing(String numero_detalle_control_ing) {
		this.numero_detalle_control_ing = numero_detalle_control_ing;
	}
	public String getMet_pago() {
		return met_pago;
	}
	public void setMet_pago(String met_pago) {
		this.met_pago = met_pago;
	}
}