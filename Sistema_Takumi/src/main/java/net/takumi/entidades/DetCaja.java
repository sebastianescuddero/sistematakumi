package net.takumi.entidades;

import java.sql.Date;

public class DetCaja {
	private int codigo_caja;
	private double ingreso_caja, egreso_caja;
	private Date fecha_reg;
	private String det_nombre_caja, fecha_reg_form;
	
	public int getCodigo_caja() {
		return codigo_caja;
	}
	public void setCodigo_caja(int codigo_caja) {
		this.codigo_caja = codigo_caja;
	}
	public double getIngreso_caja() {
		return ingreso_caja;
	}
	public void setIngreso_caja(double ingreso_caja) {
		this.ingreso_caja = ingreso_caja;
	}
	public double getEgreso_caja() {
		return egreso_caja;
	}
	public void setEgreso_caja(double egreso_caja) {
		this.egreso_caja = egreso_caja;
	}
	public Date getFecha_reg() {
		return fecha_reg;
	}
	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}
	public String getDet_nombre_caja() {
		return det_nombre_caja;
	}
	public void setDet_nombre_caja(String det_nombre_caja) {
		this.det_nombre_caja = det_nombre_caja;
	}
	public String getFecha_reg_form() {
		return fecha_reg_form;
	}
	public void setFecha_reg_form(String fecha_reg_form) {
		this.fecha_reg_form = fecha_reg_form;
	}
}
