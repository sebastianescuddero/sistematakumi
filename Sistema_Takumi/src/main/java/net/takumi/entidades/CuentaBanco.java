package net.takumi.entidades;

public class CuentaBanco {
	private int codigo_cuenta_banc;
	private String cuenta_banc, numero_cuenta_banc;
	private double ingreso_total_cuenta, egreso_total_cuenta, balance_cuenta;
	
	public int getCodigo_cuenta_banc() {
		return codigo_cuenta_banc;
	}
	public void setCodigo_cuenta_banc(int codigo_cuenta_banc) {
		this.codigo_cuenta_banc = codigo_cuenta_banc;
	}
	public String getCuenta_banc() {
		return cuenta_banc;
	}
	public void setCuenta_banc(String cuenta_banc) {
		this.cuenta_banc = cuenta_banc;
	}
	public String getNumero_cuenta_banc() {
		return numero_cuenta_banc;
	}
	public void setNumero_cuenta_banc(String numero_cuenta_banc) {
		this.numero_cuenta_banc = numero_cuenta_banc;
	}
	public double getIngreso_total_cuenta() {
		return ingreso_total_cuenta;
	}
	public void setIngreso_total_cuenta(double ingreso_total_cuenta) {
		this.ingreso_total_cuenta = ingreso_total_cuenta;
	}
	public double getEgreso_total_cuenta() {
		return egreso_total_cuenta;
	}
	public void setEgreso_total_cuenta(double egreso_total_cuenta) {
		this.egreso_total_cuenta = egreso_total_cuenta;
	}
	public double getBalance_cuenta() {
		return balance_cuenta;
	}
	public void setBalance_cuenta(double balance_cuenta) {
		this.balance_cuenta = balance_cuenta;
	}
}