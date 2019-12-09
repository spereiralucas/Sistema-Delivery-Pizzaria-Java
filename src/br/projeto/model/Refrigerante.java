package br.projeto.model;

public enum Refrigerante {

	COCA_COLA(7.99), FANTA_LARANJA(6.99), GUARANA(6.99), SPRITE(6.99), FANTA_UVA(6.99), COCA_DIET(8.99), PESI(6.99);
	
	public double preco;
	
	private Refrigerante(double d) {
		preco = d; 
	}
	public double getValue(){
        return preco;
    }
	
}
