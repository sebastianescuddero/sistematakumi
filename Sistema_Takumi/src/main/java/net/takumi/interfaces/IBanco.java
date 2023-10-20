package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.Banco;

public interface IBanco {
	public List<Banco> listarBancos();
	public List<Banco> listarBalanceBancBcp();
	public List<Banco> listarBalanceBancBbva();
	public List<Banco> listarBalanceBancInterbank();
	public int agregarBanco(Banco bean);
	public int actualizarBanco(Banco bean);
	public int eliminarBanco(int codigo_banc);
	public Banco buscarBanco(int codigo_banc);
}
