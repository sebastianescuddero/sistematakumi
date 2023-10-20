package net.takumi.entidades;

public class Banco {
	private int codigo_banc;
	private String nombre_banc;
	private double suma_ingresos_banc, suma_egresos_banc, balance_banc;
	
	public int getCodigo_banc() {
		return codigo_banc;
	}
	public void setCodigo_banc(int codigo_banc) {
		this.codigo_banc = codigo_banc;
	}
	public String getNombre_banc() {
		return nombre_banc;
	}
	public void setNombre_banc(String nombre_banc) {
		this.nombre_banc = nombre_banc;
	}
	public double getSuma_ingresos_banc() {
		return suma_ingresos_banc;
	}
	public void setSuma_ingresos_banc(double suma_ingresos_banc) {
		this.suma_ingresos_banc = suma_ingresos_banc;
	}
	public double getSuma_egresos_banc() {
		return suma_egresos_banc;
	}
	public void setSuma_egresos_banc(double suma_egresos_banc) {
		this.suma_egresos_banc = suma_egresos_banc;
	}
	public double getBalance_banc() {
		return balance_banc;
	}
	public void setBalance_banc(double balance_banc) {
		this.balance_banc = balance_banc;
	}
}
