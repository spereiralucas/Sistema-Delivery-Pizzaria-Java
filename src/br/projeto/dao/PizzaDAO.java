package br.projeto.dao;

import java.util.ArrayList;

import br.projeto.model.Pizzas;

public interface PizzaDAO {
	
	public void inserirPizza(Pizzas obj);
	
	public void editarPizza(Pizzas obj);
	
	public void apagarPizza(Pizzas obj);
	
	public ArrayList<Pizzas> listarPizzas();

}
