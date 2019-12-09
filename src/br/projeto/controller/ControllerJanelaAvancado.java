package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.view.JanelaAvancado;

public class ControllerJanelaAvancado {
	
	JanelaAvancado form;
	
	public ControllerJanelaAvancado() {
		form = new JanelaAvancado();
		initEvents();
	}
	
	private void initEvents(){
		form.txtLucro.setText("R$ "+String.valueOf(ControllerPrincipal.caixa.getPrecoTotal()));
		form.txtTotalCliente.setText(String.valueOf(ControllerCadastro.clienteDB.size()) + " clientes registrados");
		form.btnResetar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControllerCadastro.clienteDB.clear();
				ControllerPrincipal.caixa.setPrecoTotal(0);
				form.txtLucro.setText("R$ "+String.valueOf(ControllerPrincipal.caixa.getPrecoTotal())); 
				form.txtTotalCliente.setText(String.valueOf(ControllerCadastro.clienteDB.size()) + " clientes registrados");
			}
		});
	}
	
}
