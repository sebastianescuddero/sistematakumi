package net.takumi.entidades;

public class Categoria {
	private int codigo_cat;
	private String nombre_cat, descripcion_cat;
	
	public int getCodigo_cat() {
		return codigo_cat;
	}
	public void setCodigo_cat(int codigo_cat) {
		this.codigo_cat = codigo_cat;
	}
	public String getNombre_cat() {
		return nombre_cat;
	}
	public void setNombre_cat(String nombre_cat) {
		this.nombre_cat = nombre_cat;
	}
	public String getDescripcion_cat() {
		return descripcion_cat;
	}
	public void setDescripcion_cat(String descripcion_cat) {
		this.descripcion_cat = descripcion_cat;
	}
}
