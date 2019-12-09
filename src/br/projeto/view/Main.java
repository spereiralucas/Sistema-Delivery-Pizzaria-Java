package br.projeto.view;

import br.projeto.controller.ControllerPrincipal;
import br.projeto.model.ClienteBancoDAO;

public class Main {

	/**
	 * @author JEFFERSON CASTRO; LUCAS PEREIRA; PAULA SANDOLI; VITÓRIA CRISPIM.
	 * @in 02/12/2019 
	 * @version 1.0
	 * @serialData 29/11/2019
	 * */
	
	public static void main(String[] args) {
		ClienteBancoDAO bd = new ClienteBancoDAO();
		bd.conectar();

		System.out.println(bd.estaConectado());


		new ControllerPrincipal(bd);
	}
}
