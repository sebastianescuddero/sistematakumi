package net.takumi.entidades;

public class TipoEgreso {
	private int codigo_tipo_egr;
	private String tipo_egr, descripcion_tipo_egr;
	
	public int getCodigo_tipo_egr() {
		return codigo_tipo_egr;
	}
	public void setCodigo_tipo_egr(int codigo_tipo_egr) {
		this.codigo_tipo_egr = codigo_tipo_egr;
	}
	public String getTipo_egr() {
		return tipo_egr;
	}
	public void setTipo_egr(String tipo_egr) {
		this.tipo_egr = tipo_egr;
	}
	public String getDescripcion_tipo_egr() {
		return descripcion_tipo_egr;
	}
	public void setDescripcion_tipo_egr(String descripcion_tipo_egr) {
		this.descripcion_tipo_egr = descripcion_tipo_egr;
	}
}
