package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.model.Cliente;
import br.projeto.view.FormValidacao;

public class ControllerValidacao {

	FormValidacao form;
	Cliente c;
	ControllerPedidoRapido formPR;
	
	public ControllerValidacao() {
		form = new FormValidacao();
		formPR = new ControllerPedidoRapido();
		c = new Cliente();
		
		iniciarEventos();
	}
	
	private void iniciarEventos(){
		
		form.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.setNome(form.txtNome.getText());
				
				for (int i = 0; i < ControllerCadastro.clienteDB.size(); i++) {
					if(c.equals(ControllerCadastro.clienteDB.get(i))){
						
						c = ControllerCadastro.clienteDB.get(i);
						formPR.form.setVisible(true);
						formPR.form.lblNome.setText(c.getNome());
						formPR.form.lblEnd.setText(c.getEndereco());
						formPR.form.lblTel.setText(c.getTelefone());
						
						form.setVisible(false);
					}
				}
			}
		});
	}
	
}
