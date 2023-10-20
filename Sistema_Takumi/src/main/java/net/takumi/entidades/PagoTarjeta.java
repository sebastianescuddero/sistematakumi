package net.takumi.entidades;

import java.sql.Date;

public class PagoTarjeta {
	private int codigo_control_pago_tarj;
	private String numero_control_pago_tarj, fecha_reg_form;;
	private double monto_total_pago_tarj;
	private Date fecha_reg;
	
	public int getCodigo_control_pago_tarj() {
		return codigo_control_pago_tarj;
	}
	public void setCodigo_control_pago_tarj(int codigo_control_pago_tarj) {
		this.codigo_control_pago_tarj = codigo_control_pago_tarj;
	}
	public String getNumero_control_pago_tarj() {
		return numero_control_pago_tarj;
	}
	public void setNumero_control_pago_tarj(String numero_control_pago_tarj) {
		this.numero_control_pago_tarj = numero_control_pago_tarj;
	}
	public String getFecha_reg_form() {
		return fecha_reg_form;
	}
	public void setFecha_reg_form(String fecha_reg_form) {
		this.fecha_reg_form = fecha_reg_form;
	}
	public double getMonto_total_pago_tarj() {
		return monto_total_pago_tarj;
	}
	public void setMonto_total_pago_tarj(double monto_total_pago_tarj) {
		this.monto_total_pago_tarj = monto_total_pago_tarj;
	}
	public Date getFecha_reg() {
		return fecha_reg;
	}
	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}
}