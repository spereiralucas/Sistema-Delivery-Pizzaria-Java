package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.model.ClienteBancoDAO;
import br.projeto.model.Caixa;
import br.projeto.view.JanelaPrincipal;

public class ControllerPrincipal {
	
	JanelaPrincipal form;
	ControllerPedidoRapido formPedido;
	static Caixa caixa = new Caixa();
	ClienteBancoDAO bd;
	
	public ControllerPrincipal(ClienteBancoDAO bd) {
		this.bd = bd;
		form = new JanelaPrincipal();
		iniciarEventos();
	}
	
	private void iniciarEventos(){
		form.btnCadastrar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerCadastro(bd);
			}
		});
		
		form.btnPedidoRapido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerValidacao();
			}
		});
		
		form.btnListaDeClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerGridCliente(bd);
			}
		});
		
		form.btnAvancado.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerJanelaAvancado();
			}
		});
		
	}
	
}
