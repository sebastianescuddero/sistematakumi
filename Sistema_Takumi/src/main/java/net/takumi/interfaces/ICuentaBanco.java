package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.CuentaBanco;
import net.takumi.entidades.DetCuentaBanco;

public interface ICuentaBanco {
	public List<CuentaBanco> listarCuentasBanco();
	public List<DetCuentaBanco> listarMovimientosBancoBcp();
	public List<DetCuentaBanco> listarMovimientosBancoBbva();
	public List<DetCuentaBanco> listarMovimientosBancoInterbank();
	public List<CuentaBanco> listarCuentasBcp();
	public List<CuentaBanco> listarCuentasBbva();
	public List<CuentaBanco> listarCuentasInterbank();
	public int agregarCuentaBanco(CuentaBanco bean);
	public int actualizarCuentaBanco(CuentaBanco bean);
	public int eliminarCuentaBanco(int codigo_banc);
	public CuentaBanco buscarCuentaBanco(int codigo_banc);
}
