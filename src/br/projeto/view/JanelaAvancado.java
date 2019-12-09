package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.controller.ControllerJanelaAvancado;

public class JanelaAvancado extends JFrame{
	
	JLabel lblTotalCliente, lblLucro;
	public JTextField txtTotalCliente, txtLucro;
	public JButton btnResetar, btnCancel;
	
	public JanelaAvancado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Relatório Geral");
		
		initComponents();
		initEvents();
		
		setSize(600, 300);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initComponents(){
		setLayout(null);
		getContentPane().setBackground(new Color(255, 173, 30));
		
		lblTotalCliente = new JLabel("Total de clientes :");
		lblTotalCliente.setBounds(40, 30, 100, 20);
		lblTotalCliente.setForeground(new Color(255, 245, 240));
		add(lblTotalCliente);
		
		txtTotalCliente = new JTextField();
		txtTotalCliente.setBounds(40, 70, 520, 20);
		txtTotalCliente.setBackground(new Color(255, 245, 240));
		txtTotalCliente.setEditable(false);
		add(txtTotalCliente);
		
		lblLucro = new JLabel("Rendimentos:"); 
		lblLucro.setBounds(40, 110, 120, 20);
		lblLucro.setForeground(new Color(255, 245, 240));
		add(lblLucro);
		
		txtLucro = new JTextField();
		txtLucro.setBounds(40, 150, 520, 20);
		txtLucro.setBackground(new Color(255, 245, 240));
		txtLucro.setEditable(false);
		add(txtLucro);
		
		btnResetar = new JButton("Limpar");
		btnResetar.setBounds(320, 220, 95, 25);
		btnResetar.setBackground(new Color(255, 245, 240));
		add(btnResetar);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(450, 220, 95, 25);
		btnCancel.setBackground(new Color(232, 175, 172));
		add(btnCancel);
	}
	
	private void initEvents(){
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
	}
	
}
