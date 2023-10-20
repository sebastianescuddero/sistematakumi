package net.takumi.entidades;

public class Proveedor {
	private int codigo_prov;
	private String nombre_prov, descripcion_prov, telefono_prov;
	
	public int getCodigo_prov() {
		return codigo_prov;
	}
	public void setCodigo_prov(int codigo_prov) {
		this.codigo_prov = codigo_prov;
	}
	public String getNombre_prov() {
		return nombre_prov;
	}
	public void setNombre_prov(String nombre_prov) {
		this.nombre_prov = nombre_prov;
	}
	public String getDescripcion_prov() {
		return descripcion_prov;
	}
	public void setDescripcion_prov(String descripcion_prov) {
		this.descripcion_prov = descripcion_prov;
	}
	public String getTelefono_prov() {
		return telefono_prov;
	}
	public void setTelefono_prov(String telefono_prov) {
		this.telefono_prov = telefono_prov;
	}
}
