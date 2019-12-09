package br.projeto.view;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.projeto.controller.ControllerPrincipal;

public class JanelaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTitulo, lblHora;
	public JButton btnPedidoRapido, btnCadastrar, btnListaDeClientes, btnAvancado;
	Date date = new Date();
	DateFormat formato = new SimpleDateFormat("HH:mm");
	String formattedDate = formato.format(date);
	
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu");
		
		iniciarTela();
		
		setSize(1000, 500);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 173, 30));
		
		lblTitulo = new JLabel("PIZZARIA POO");
		lblTitulo.setForeground(new Color(112, 25, 25)); 
		lblTitulo.setBounds(450,75,200,40);
		add(lblTitulo);
		
		lblHora = new JLabel(formattedDate);
		lblHora.setForeground(new Color(1, 115, 43));
		lblHora.setBounds(475, 425, 100, 20);
		add(lblHora);
		
		btnPedidoRapido = new JButton("Pedido");
		btnPedidoRapido.setBackground(new Color (255, 245, 240));
		btnPedidoRapido.setBounds(200, 200, 120, 30);
		add(btnPedidoRapido);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color (255, 245, 240));
		btnCadastrar.setBounds(350, 200, 120, 30);
		add(btnCadastrar);
		
		btnListaDeClientes = new JButton("Clientes");
		btnListaDeClientes.setBackground(new Color (255, 245, 240));
		btnListaDeClientes.setBounds(500, 200, 120, 30);
		add(btnListaDeClientes);
		
		btnAvancado = new JButton("Relatório Geral");
		btnAvancado.setBackground(new Color (255, 245, 240));
		btnAvancado.setBounds(650, 200, 120, 30);
		add(btnAvancado);	
	}
	
}
