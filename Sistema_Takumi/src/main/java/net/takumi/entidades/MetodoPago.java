package net.takumi.entidades;

public class MetodoPago {
	private int codigo_met_pago, codigo_banco, codigo_cuenta_banc;
	private String nombre_met_pago;
	
	public int getCodigo_met_pago() {
		return codigo_met_pago;
	}
	public void setCodigo_met_pago(int codigo_met_pago) {
		this.codigo_met_pago = codigo_met_pago;
	}
	public int getCodigo_banco() {
		return codigo_banco;
	}
	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}
	public int getCodigo_cuenta_banc() {
		return codigo_cuenta_banc;
	}
	public void setCodigo_cuenta_banc(int codigo_cuenta_banc) {
		this.codigo_cuenta_banc = codigo_cuenta_banc;
	}
	public String getNombre_met_pago() {
		return nombre_met_pago;
	}
	public void setNombre_met_pago(String nombre_met_pago) {
		this.nombre_met_pago = nombre_met_pago;
	}
}
