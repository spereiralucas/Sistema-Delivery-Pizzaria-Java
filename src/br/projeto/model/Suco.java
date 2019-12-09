package br.projeto.model;

public enum Suco {

	LARANJA(6.99), MARACUJA(6.99), UVA(6.99), LIMAO(6.99), MELANCIA(6.99), MANGA(6.99), ABACAXI(6.99);

	public double preco;
	
	private Suco(double d) {
		preco = d; 
	}
	public double getValue(){
        return preco;
    }
	
}
