package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.projeto.model.ClienteBancoDAO;
import br.projeto.model.Cliente;
import br.projeto.view.FormCadastroCliente;

public class ControllerCadastro {
	
	FormCadastroCliente form;
	Cliente c;
	ControllerDetCliente clienteController;
	public static ArrayList <Cliente> clienteDB = new ArrayList<>();
	ClienteBancoDAO bd;
	public ControllerCadastro(ClienteBancoDAO bd) {
		this.bd = bd;
		clienteController = new ControllerDetCliente(new Cliente(), bd);
		form = new FormCadastroCliente();
		validacaoDeClienteExistente();
	}
	
	private void validacaoDeClienteExistente (){  
		
		form.btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c = new Cliente();
				c.setNome(form.txtNome.getText());
					if(clienteDB.contains(c)){
						JOptionPane.showMessageDialog(null, "Cliente já consta em nossa base de dados");
					}else{
						validacaoDeCamposNulos();
						clienteController.inserirCliente(form.txtNome.getText(), form.txtEnd.getText(), form.txtTel.getText());
					}
			}
		});
	}
	
	private void validacaoDeCamposNulos(){
                if ((form.txtNome.getText() == null || form.txtNome.getText().trim().isEmpty()) ||
                        (form.txtEnd.getText() == null || form.txtEnd.getText().trim().isEmpty()) ||
                        (form.txtTel.getText() == null || form.txtTel.getText().trim().length() != 13))
                {
                    JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
                } else {
                    eventosForm();
                }
            }
		 
	
	private void eventosForm(){
				Cliente cliente = new Cliente();
				cliente.setNome(form.txtNome.getText());
				cliente.setEndereco(form.txtEnd.getText());
				cliente.setTelefone(form.txtTel.getText());
				clienteDB.add(cliente);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado !");
				form.setVisible(false);
			}
		
}

