package br.projeto.dao;

import java.util.ArrayList;

import br.projeto.model.Cliente;

public interface ClienteDAO {
		
	public void inserirCliente(Cliente model);
		
	public void editarCliente(int idCliente);
		
	public void apagarCliente(int idCliente);
		
	public ArrayList<Cliente> listarCliente();
	
}
