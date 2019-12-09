package br.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.projeto.controller.ControllerGridCliente;

public class JanelaGridCliente extends JFrame {
	
	public JButton btnOk, btnEditar, btnExcluir;
	JPanel pnlgrid;
	public JTable grid;
	public DefaultTableModel dtm;
	JScrollPane scr;
	
	public JanelaGridCliente() {
        setTitle("Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        initComponents();
        initEvents();
 
        setSize(1000, 500);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

	private void initComponents() {
		setLayout(null);
		getContentPane().setBackground(new Color(255, 173, 30));
		
		//Botões
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(830, 20, 100, 30);
		btnEditar.setBackground(new Color (255, 245, 240)); 
		btnEditar.setEnabled(false);
		add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(830, 120, 100, 30);
		btnExcluir.setBackground(new Color (232, 175, 172));
		btnExcluir.setEnabled(false);
		add(btnExcluir);
		
		btnOk = new JButton("Confirmar");
		btnOk.setBounds(830, 220, 100, 30);
		btnOk.setBackground(new Color (186, 232, 172));
		add(btnOk);
		
		//Grid
		scr = new JScrollPane();
		
		pnlgrid = new JPanel(); //Painel
		pnlgrid.setBorder(new TitledBorder("Clientes"));
		pnlgrid.setBackground(new Color(255, 245, 240));
		pnlgrid.setLayout(new BorderLayout());
		
		String[] colunas ={"Id", "Nome", "Endere�o", "Telefone"};
		dtm = new DefaultTableModel(colunas, 0){ 
			@Override
			public boolean isCellEditable(int row, int col) {
					return false;
			}
		};
		
		grid = new JTable(dtm);
		grid.setBackground(new Color(255, 245, 240));
		
		for (int i = 0; i < colunas.length; i++) {
			grid.getColumnModel().getColumn(i).setPreferredWidth(200); 
			grid.getColumnModel().getColumn(i).setResizable(false);
		}
		grid.getTableHeader().setReorderingAllowed(false);
		
		DefaultTableCellRenderer alinCentro = new DefaultTableCellRenderer();
		alinCentro.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < colunas.length; i++) {
			grid.getColumnModel().getColumn(i).setCellRenderer(alinCentro);
		}
		
		grid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		grid.setCellSelectionEnabled(false);
		grid.setRowSelectionAllowed(true);
		
		pnlgrid.add(grid);
		pnlgrid.add(scr);
		scr.setViewportView(grid);

		pnlgrid.setBounds(20, 10, 750, 450);
		add(pnlgrid);
		repaint();
		
	}
	
	private void initEvents(){
		btnOk.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		grid.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							return;
						}
					}
		});
		
		grid.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				btnEditar.setEnabled(!lsm.isSelectionEmpty());
				btnExcluir.setEnabled(!lsm.isSelectionEmpty());
			}
		});
		
	}
	
}
