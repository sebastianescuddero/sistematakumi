package net.takumi.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlAlmacen {
	private int codigo_control_alm;
	private String numero_control_alm, fecha_reg_form;
	private Date fecha_reg;
	
	public int getCodigo_control_alm() {
		return codigo_control_alm;
	}
	public void setCodigo_control_alm(int codigo_control_alm) {
		this.codigo_control_alm = codigo_control_alm;
	}
	public String getNumero_control_alm() {
		return numero_control_alm;
	}
	public void setNumero_control_alm(String numero_control_alm) {
		this.numero_control_alm = numero_control_alm;
	}
	public Date getFecha_reg() {
		return fecha_reg;
	}
	public void setFecha_reg(Date fecha_reg) {
		this.fecha_reg = fecha_reg;
	}
	public String getFecha_reg_form() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fecha_reg_form);
	}
	public void setFecha_reg_form(String fecha_reg_form) {
		this.fecha_reg_form = fecha_reg_form;
	}
}
