package net.takumi.entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DetCuentaBanco {
	private int codigo_cuenta_banc;
	private double ingreso, egreso;
	private String nombre_cuenta_banc, fecha_reg_form;
	private Date fecha_reg;
	
	public int getCodigo_cuenta_banc() {
		return codigo_cuenta_banc;
	}
	public void setCodigo_cuenta_banc(int codigo_cuenta_banc) {
		this.codigo_cuenta_banc = codigo_cuenta_banc;
	}
	public double getIngreso() {
		return ingreso;
	}
	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
	}
	public double getEgreso() {
		return egreso;
	}
	public void setEgreso(double egreso) {
		this.egreso = egreso;
	}
	public String getNombre_cuenta_banc() {
		return nombre_cuenta_banc;
	}
	public void setNombre_cuenta_banc(String nombre_cuenta_banc) {
		this.nombre_cuenta_banc = nombre_cuenta_banc;
	}
	public String getFecha_reg_form() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fecha_reg_form);
	}
	public void setFecha_reg_form(String fecha_reg_form) {
		this.fecha_reg_form = fecha_reg_form;
	}
	public Date getFecha_reg() {
		return fecha_reg;
	}
	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}
}
