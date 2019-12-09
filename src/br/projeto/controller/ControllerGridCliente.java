package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import br.projeto.model.ClienteBancoDAO;
import br.projeto.model.Cliente;
import br.projeto.view.JanelaGridCliente;

public class ControllerGridCliente {

    JanelaGridCliente gridCliente;
    ControllerDetCliente formEdicao;
    ClienteBancoDAO bd;

    public ControllerGridCliente(ClienteBancoDAO bd) {
        this.bd = bd;
        gridCliente = new JanelaGridCliente();
        initEvents();
        chargeScreen();
        gridCliente.grid.clearSelection();
    }
    private void initEvents() {
        gridCliente.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int posicao = gridCliente.grid.getSelectedRow();
                ArrayList<Cliente> lista = bd.listarCliente();
                Cliente c = lista.get(posicao);


                formEdicao = new ControllerDetCliente(c, bd);
                formEdicao.form.setVisible(true);

                if (formEdicao.c != null) {
                    try {
                        ControllerCadastro.clienteDB.set(posicao, c);
                        refreshGrid(ControllerCadastro.clienteDB);
                    } catch (java.lang.IndexOutOfBoundsException indexOutOfBoundsException) {

                    }
                }

            }
        });

        gridCliente.btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int posicao = gridCliente.grid.getSelectedRow();
                ControllerCadastro.clienteDB.remove(posicao);
                ((DefaultTableModel) gridCliente.grid.getModel()).removeRow(posicao);
            }
        });

    }

    public void chargeScreen() {
        refreshGrid(ControllerCadastro.clienteDB);
    }

    public void refreshGrid(ArrayList<Cliente> lista) {
        lista = bd.listarCliente();

        int x = gridCliente.dtm.getRowCount();
        while (x > 0) {
            x--;
            gridCliente.dtm.removeRow(x);
        }

        for (Cliente c : lista) {
            gridCliente.dtm.addRow(new Object[]{c.idCliente, c.getNome(), c.getEndereco(), c.getTelefone()});
        }
        if (gridCliente.dtm.getRowCount() > 0) {
            gridCliente.grid.setRowSelectionInterval(0, 0);
        }
    }

}
