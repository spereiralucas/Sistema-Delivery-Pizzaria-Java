package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class FormCadastroCliente extends JFrame {
	
	JLabel lblNome, lblEnd, lblTel;
	public JTextField txtNome, txtEnd;
	public JFormattedTextField txtTel;
	MaskFormatter mskTel;
	
	public JButton btnCadastrar, btnLimpar, btnCancelar;
	
	public FormCadastroCliente(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar");
		
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
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 245, 240));
		lblNome.setBounds(40, 20, 80, 20);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(40, 50, 520, 20);
		add(txtNome);
		
		lblEnd = new JLabel("Endereço:");
		lblEnd.setForeground(new Color (255, 245, 240));
		lblEnd.setBounds(40, 80, 100, 20);
		add(lblEnd);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(40, 110, 520, 20);
		add(txtEnd);
		
		lblTel = new JLabel("Telefone:");
		lblTel.setForeground(new Color (255, 245, 240));
		lblTel.setBounds(40, 140, 100, 20);
		add(lblTel);
		
		try {
			mskTel = new MaskFormatter("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtTel = new JFormattedTextField(mskTel);
		txtTel.setBounds(40, 170, 520, 20);
		add(txtTel);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color (186, 232, 172));
		btnCadastrar.setBounds(190, 220, 95, 25);
		add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (255, 245, 240));
		btnLimpar.setBounds(320, 220, 95, 25);
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (232, 175, 172));
		btnCancelar.setBounds(450, 220, 95, 25);
		add(btnCancelar);
		
	}
	
	public void iniciarEventos(){
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtEnd.setText("");
				txtTel.setText("");
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
	
}
