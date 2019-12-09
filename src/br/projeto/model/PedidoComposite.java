//DESIGN PATTERN - COMPOSITE
package br.projeto.model;

import java.util.ArrayList;
import java.util.List;

public abstract class PedidoComposite {
	
	private List<PedidoComposite> pc = new ArrayList<>();
	
	public void add(PedidoComposite pedido) {
		pc.add(pedido);
	}
	
	public int countPedidos() {
		return pc.size();
	}
	
	protected void printThisBefore() {
		
	}
	
	protected void printThisAfter() {
		
	}
	
	public void print() {
		printThisBefore();
		pc.forEach(PedidoComposite::print);
		printThisAfter();
	}

}
