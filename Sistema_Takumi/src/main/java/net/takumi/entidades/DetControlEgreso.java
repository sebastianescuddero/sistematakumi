package net.takumi.entidades;

public class DetControlEgreso {
	private int codigo_control_egr, codigo_tip_egr, codigo_met_pago;
	private String numero_detalle_control_egr, descripcion_razon_egr, met_pago, tip_egr;
	private double monto_egr;
	
	public int getCodigo_control_egr() {
		return codigo_control_egr;
	}
	public void setCodigo_control_egr(int codigo_control_egr) {
		this.codigo_control_egr = codigo_control_egr;
	}
	public int getCodigo_tip_egr() {
		return codigo_tip_egr;
	}
	public void setCodigo_tip_egr(int codigo_tip_egr) {
		this.codigo_tip_egr = codigo_tip_egr;
	}
	public int getCodigo_met_pago() {
		return codigo_met_pago;
	}
	public void setCodigo_met_pago(int codigo_met_pago) {
		this.codigo_met_pago = codigo_met_pago;
	}
	public String getNumero_detalle_control_egr() {
		return numero_detalle_control_egr;
	}
	public void setNumero_detalle_control_egr(String numero_detalle_control_egr) {
		this.numero_detalle_control_egr = numero_detalle_control_egr;
	}
	public String getDescripcion_razon_egr() {
		return descripcion_razon_egr;
	}
	public void setDescripcion_razon_egr(String descripcion_razon_egr) {
		this.descripcion_razon_egr = descripcion_razon_egr;
	}
	public double getMonto_egr() {
		return monto_egr;
	}
	public void setMonto_egr(double monto_egr) {
		this.monto_egr = monto_egr;
	}
	/**
	 * @return the met_pago
	 */
	public String getMet_pago() {
		return met_pago;
	}
	/**
	 * @param met_pago the met_pago to set
	 */
	public void setMet_pago(String met_pago) {
		this.met_pago = met_pago;
	}
	/**
	 * @return the tip_egr
	 */
	public String getTip_egr() {
		return tip_egr;
	}
	/**
	 * @param tip_egr the tip_egr to set
	 */
	public void setTip_egr(String tip_egr) {
		this.tip_egr = tip_egr;
	}
}