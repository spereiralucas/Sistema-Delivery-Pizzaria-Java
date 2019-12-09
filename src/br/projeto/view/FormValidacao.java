package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.controller.ControllerValidacao;

public class FormValidacao extends JFrame {
	
	JLabel lblNome;
	public JTextField txtNome;
	public JButton btnOk, btnCancel;
	
	public FormValidacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Validação");
		
		iniciarTela();
		iniciarEventos();
		
		setSize(600, 300);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 173, 30));
		
		lblNome = new JLabel("Nome do cliente:");
		lblNome.setBounds(40, 80, 150, 20);
		lblNome.setForeground(new Color(255, 245, 240));
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(40, 120, 520, 20);
		txtNome.setBackground(new Color(255, 245, 240));
		add(txtNome);
		
		btnOk = new JButton("Confirmar");
		btnOk.setBounds(320, 220, 114, 30);
		btnOk.setBackground(new Color(186, 232, 172));
		add(btnOk);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(450, 220, 114, 30);
		btnCancel.setBackground(new Color(232, 175, 172));
		add(btnCancel);
	}
	
	private void iniciarEventos(){
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
	}
	
}
