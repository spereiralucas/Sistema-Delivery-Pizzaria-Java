package br.projeto.dao;

import java.util.ArrayList;

import br.projeto.model.Refrigerante;

public interface RefrigeranteDAO{
	
	public void inserirRefrigerante(Refrigerante obj);
	
	public void editarRefrigerante(Refrigerante obj);
	
	public void apagarRefrigerante(Refrigerante obj);
	
	public ArrayList<Refrigerante> listarRefrigerante();

}
