package net.takumi.entidades;

public class Caja {
	private int codigo_caja;
	private String nombre_caja;
	private double suma_ingresos_caja, suma_egresos_caja, balance_caja;
	
	public int getCodigo_caja() {
		return codigo_caja;
	}
	public void setCodigo_caja(int codigo_caja) {
		this.codigo_caja = codigo_caja;
	}
	public String getNombre_caja() {
		return nombre_caja;
	}
	public void setNombre_caja(String nombre_caja) {
		this.nombre_caja = nombre_caja;
	}
	public double getSuma_ingresos_caja() {
		return suma_ingresos_caja;
	}
	public void setSuma_ingresos_caja(double suma_ingresos_caja) {
		this.suma_ingresos_caja = suma_ingresos_caja;
	}
	public double getSuma_egresos_caja() {
		return suma_egresos_caja;
	}
	public void setSuma_egresos_caja(double suma_egresos_caja) {
		this.suma_egresos_caja = suma_egresos_caja;
	}
	public double getBalance_caja() {
		return balance_caja;
	}
	public void setBalance_caja(double balance_caja) {
		this.balance_caja = balance_caja;
	}
}
