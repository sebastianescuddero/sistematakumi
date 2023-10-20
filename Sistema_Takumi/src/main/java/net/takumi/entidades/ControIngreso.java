package net.takumi.entidades;

import java.sql.Date;

public class ControIngreso {
	private int codigo_control_ing;
	private String numero_control_ing, fecha_reg_form;
	private double monto_total_efec, monto_total_elec, monto_total_ing;
	private Date fecha_reg;
	
	public int getCodigo_control_ing() {
		return codigo_control_ing;
	}
	public void setCodigo_control_ing(int codigo_control_ing) {
		this.codigo_control_ing = codigo_control_ing;
	}
	public String getNumero_control_ing() {
		return numero_control_ing;
	}
	public void setNumero_control_ing(String numero_control_ing) {
		this.numero_control_ing = numero_control_ing;
	}
	public String getFecha_reg_form() {
		return fecha_reg_form;
	}
	public void setFecha_reg_form(String fecha_reg_form) {
		this.fecha_reg_form = fecha_reg_form;
	}
	public double getMonto_total_ing() {
		return monto_total_ing;
	}
	public void setMonto_total_ing(double monto_total_ing) {
		this.monto_total_ing = monto_total_ing;
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
