package br.projeto.dao;

import java.util.ArrayList;

import br.projeto.model.Suco;

public interface SucoDAO {
	
	public void inserirSuco(Suco obj);
	
	public void editarSuco(Suco obj);
	
	public void apagarSuco(Suco obj);
	
	public ArrayList<Suco> listarSuco();

}
