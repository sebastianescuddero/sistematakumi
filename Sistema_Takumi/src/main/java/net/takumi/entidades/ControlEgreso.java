package net.takumi.entidades;

import java.sql.Date;

public class ControlEgreso {
	private int codigo_control_egr;
	private String numero_control_egr, fecha_reg_form;
	private double monto_total_efec, monto_total_elec, monto_total_egr;
	private Date fecha_reg;
	
	public int getCodigo_control_egr() {
		return codigo_control_egr;
	}
	public void setCodigo_control_egr(int codigo_control_egr) {
		this.codigo_control_egr = codigo_control_egr;
	}
	public String getNumero_control_egr() {
		return numero_control_egr;
	}
	public void setNumero_control_egr(String numero_control_egr) {
		this.numero_control_egr = numero_control_egr;
	}
	public String getFecha_reg_form() {
		return fecha_reg_form;
	}
	public void setFecha_reg_form(String fecha_reg_form) {
		this.fecha_reg_form = fecha_reg_form;
	}
	public double getMonto_total_egr() {
		return monto_total_egr;
	}
	public void setMonto_total_egr(double monto_total_egr) {
		this.monto_total_egr = monto_total_egr;
	}
	public Date getFecha_reg() {
		return fecha_reg;
	}
	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}
	public double getMonto_total_efec() {
		return monto_total_efec;
	}
	public void setMonto_total_efec(double monto_total_efec) {
		this.monto_total_efec = monto_total_efec;
	}
	public double getMonto_total_elec() {
		return monto_total_elec;
	}
	public void setMonto_total_elec(double monto_total_elec) {
		this.monto_total_elec = monto_total_elec;
	}
}