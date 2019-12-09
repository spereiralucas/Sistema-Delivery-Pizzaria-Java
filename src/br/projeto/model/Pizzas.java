package br.projeto.model;

public enum Pizzas {

	LOMBO(45.99), MUZZARELA(45.99), PEPPERONI(59.99), MARGHERITTA(49.99), VEGAN(49.99), PROVOLLONE(49.99), FRANGO_COM_REQUEIJAO(59.99);
	
	public double preco;
	
	private Pizzas(Double d) {
		preco = d; 
	}
	public double getValue(){
        return preco;
    }
	
}
