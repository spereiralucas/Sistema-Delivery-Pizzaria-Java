package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.projeto.model.ClienteBancoDAO;
import br.projeto.model.Cliente;
import br.projeto.view.FormDetCliente;

public class ControllerDetCliente {

    FormDetCliente form;
    Cliente c;
    ClienteBancoDAO bd;

    public ControllerDetCliente(Cliente cliente, ClienteBancoDAO bd) {

        this.bd = bd;
        c = new Cliente();
        c = cliente;
        bd = new ClienteBancoDAO();
        chargeScreen();
        validacaoDeCamposNulos();

    }

    private void chargeScreen() {
        try {
            form = new FormDetCliente(bd, Integer.valueOf(c.idCliente));
        } catch (Exception e) {
            form = new FormDetCliente(bd, 0);
        }

        form.txtNome.setText(c.getNome());
        form.txtEnd.setText(c.getEndereco());
        form.txtTel.setText(c.getTelefone());
    }

    private void validacaoDeCamposNulos() {
        form.btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((form.txtNome.getText() == null || form.txtNome.getText().trim().isEmpty()) ||
                        (form.txtEnd.getText() == null || form.txtEnd.getText().trim().isEmpty()) ||
                        (form.txtTel.getText() == null || form.txtTel.getText().trim().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
                } else {
                    initEvents();
                }
            }
        });
    }

    private void initEvents() {
        c.setNome(form.txtNome.getText());
        c.setEndereco(form.txtEnd.getText());
        c.setTelefone(form.txtTel.getText());
        form = new FormDetCliente(bd, Integer.valueOf(c.idCliente));
        form.setVisible(false);
        JOptionPane.showMessageDialog(null, "Edição realizada!");
    }

    public void inserirCliente(String nome, String endereco, String telefone) {

        bd.inserirCliente(nome, endereco, telefone);
    }

}
