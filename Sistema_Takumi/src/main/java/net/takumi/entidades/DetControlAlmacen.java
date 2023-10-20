package net.takumi.entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DetControlAlmacen {
	private int codigo_control_alm, codigo_pro, codigo_usu, cantidad_pro;
	private String numero_detalle_control_alm, tipo_control_alm, fecha_ven_form, nombre_pro, nombre_usu;
	private Date fecha_ven;
	
	public int getCodigo_control_alm() {
		return codigo_control_alm;
	}
	public void setCodigo_control_alm(int codigo_control_alm) {
		this.codigo_control_alm = codigo_control_alm;
	}
	public int getCodigo_pro() {
		return codigo_pro;
	}
	public void setCodigo_pro(int codigo_pro) {
		this.codigo_pro = codigo_pro;
	}
	public int getCodigo_usu() {
		return codigo_usu;
	}
	public void setCodigo_usu(int codigo_usu) {
		this.codigo_usu = codigo_usu;
	}
	public int getCantidad_pro() {
		return cantidad_pro;
	}
	public void setCantidad_pro(int cantidad_pro) {
		this.cantidad_pro = cantidad_pro;
	}
	public String getNumero_detalle_control_alm() {
		return numero_detalle_control_alm;
	}
	public void setNumero_detalle_control_alm(String numero_detalle_control_alm) {
		this.numero_detalle_control_alm = numero_detalle_control_alm;
	}
	public String getTipo_control_alm() {
		return tipo_control_alm;
	}
	public void setTipo_control_alm(String tipo_control_alm) {
		this.tipo_control_alm = tipo_control_alm;
	}
	public Date getFecha_ven() {
		return fecha_ven;
	}
	public void setFecha_ven(Date fecha_ven) {
		this.fecha_ven = fecha_ven;
	}
	public String getFecha_ven_form() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fecha_ven_form);
	}
	public void setFecha_ven_form(String fecha_ven_form) {
		this.fecha_ven_form = fecha_ven_form;
	}
	public String getNombre_pro() {
		return nombre_pro;
	}
	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}
	public String getNombre_usu() {
		return nombre_usu;
	}
	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}
}