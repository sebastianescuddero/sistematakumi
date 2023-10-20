package net.takumi.interfaces;

import java.util.List;

import net.takumi.entidades.POS;

public interface IPos {
	public List<POS> listarPOS();
	public int agregarPOS(POS bean);
	public int actualizarPOS(POS bean);
	public int eliminarPOS(int codigo_pos);
	public POS buscarPOS(int codigo_pos);
}
