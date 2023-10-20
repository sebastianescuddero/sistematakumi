package net.takumi.entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Producto {
	private int codigo_pro, codigo_cat, codigo_prov, cantidad;
	private String nombre_pro, nombre_cat, nombre_prov, descripcion_can, fecha_ven_form, numero_lote;
	private Date fecha_ven;
	
	public int getCodigo_pro() {
		return codigo_pro;
	}
	public void setCodigo_pro(int codigo_pro) {
		this.codigo_pro = codigo_pro;
	}
	public int getCodigo_cat() {
		return codigo_cat;
	}
	public void setCodigo_cat(int codigo_cat) {
		this.codigo_cat = codigo_cat;
	}
	public int getCodigo_prov() {
		return codigo_prov;
	}
	public void setCodigo_prov(int codigo_prov) {
		this.codigo_prov = codigo_prov;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre_pro() {
		return nombre_pro;
	}
	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}
	public String getNombre_cat() {
		return nombre_cat;
	}
	public void setNombre_cat(String nombre_cat) {
		this.nombre_cat = nombre_cat;
	}
	public String getNombre_prov() {
		return nombre_prov;
	}
	public void setNombre_prov(String nombre_prov) {
		this.nombre_prov = nombre_prov;
	}
	public String getDescripcion_can() {
		return descripcion_can;
	}
	public void setDescripcion_can(String descripcion_can) {
		this.descripcion_can = descripcion_can;
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
	public String getNumero_lote() {
		return numero_lote;
	}
	public void setNumero_lote(String numero_lote) {
		this.numero_lote = numero_lote;
	}
}
