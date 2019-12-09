package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.controller.ControllerPedidoRapido;
import br.projeto.model.*;

public class FormPedidoRapido extends JFrame {
	
	public JLabel lblNome, lblEnd, lblTel;
	JLabel lblPrecos, lblPizza, lblSuco, lblRefri;
	public JLabel lblPrecoPizza, lblPrecoSuco, lblPrecoRefri, lblPrecoTotal;
	public double precoPizza = 0, precoRefri = 0, precoSuco = 0;

	public JComboBox <Pizzas> cmbPizza;
	public JComboBox <Suco> cmbSuco;
	public JComboBox <Refrigerante> cmbRefri;
	
	public JTextField txtPrecoTotal;
	
	public JButton btnConfirmar, btnLimpar, btnCancelar, btnCalcular;
	
	public FormPedidoRapido() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Pedido");
		
		iniciarTela();
		iniciarEventos();
		
		setSize(1000, 500);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(false);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 173, 30));
		
		lblNome = new JLabel();
		lblNome.setBounds(20, 10, 100, 20);
		lblNome.setForeground(new Color(112, 25, 25));
		add(lblNome);
		
		lblEnd = new JLabel();
		lblEnd.setBounds(260, 10, 150, 20);
		lblEnd.setForeground(new Color(112, 25, 25));
		add(lblEnd);
		
		lblTel = new JLabel();
		lblTel.setBounds(520, 10, 100, 20);
		lblTel.setForeground(new Color(112, 25, 25));
		add(lblTel);
		
		lblPizza = new JLabel("Pizza:");
		lblPizza.setBounds(20, 70, 50, 20);
		lblPizza.setForeground(new Color(224,255,255));
		add(lblPizza);
		
		cmbPizza = new JComboBox <Pizzas>();
		cmbPizza.setBackground(new Color (255, 245, 240));
		cmbPizza.setBounds(20, 90, 820, 20);
		add(cmbPizza);
		
		lblPrecoPizza = new JLabel();
		lblPrecoPizza.setBounds(900, 90, 130, 20);
		lblPrecoPizza.setForeground(new Color(224,255,255));
		add(lblPrecoPizza);
		
		lblSuco = new JLabel("Suco:");
		lblSuco.setBounds(20, 150, 50, 20);		
		lblSuco.setForeground(new Color(224,255,255));
		add(lblSuco);
		
		cmbSuco = new JComboBox <Suco>();
		cmbSuco.setBackground(new Color (255, 245, 240));
		cmbSuco.setBounds(20, 170, 820, 20);
		add(cmbSuco);
		
		lblPrecoSuco = new JLabel();
		lblPrecoSuco.setBounds(900, 170, 130, 20);
		lblPrecoSuco.setForeground(new Color(224,255,255));
		add(lblPrecoSuco);
		
		lblRefri = new JLabel("Refrigerante:");
		lblRefri.setBounds(20, 230, 50, 20);
		lblRefri.setForeground(new Color(224,255,255));
		add(lblRefri);
		
		cmbRefri = new JComboBox <Refrigerante>();
		cmbRefri.setBackground(new Color (255, 245, 240));
		cmbRefri.setBounds(20, 250, 820, 20);
		add(cmbRefri);
		
		lblPrecoRefri = new JLabel();
		lblPrecoRefri.setBounds(900, 250, 130, 20);
		lblPrecoRefri.setForeground(new Color(224,255,255));
		add(lblPrecoRefri);
		
		lblPrecoTotal = new JLabel("Total:");
		lblPrecoTotal.setBounds(700, 330, 150, 20);
		lblPrecoTotal.setForeground(new Color(224,255,255));
		add(lblPrecoTotal);
		
		txtPrecoTotal = new JTextField();
		txtPrecoTotal.setEditable(false);
		txtPrecoTotal.setBounds(795, 330, 150, 20);
		txtPrecoTotal.setBackground(new Color(255, 245, 240));
		txtPrecoTotal.setForeground(new Color(112, 25, 25));
		txtPrecoTotal.setText("0.00");
		add(txtPrecoTotal);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color (186, 232, 172));
		btnConfirmar.setBounds(460, 420, 95, 25);
		add(btnConfirmar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (255, 245, 240));
		btnLimpar.setBounds(590, 420, 95, 25);
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (232, 175, 172));
		btnCancelar.setBounds(720, 420, 95, 25);
		add(btnCancelar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(850, 420, 95, 25);
		btnCalcular.setBackground(new Color(172, 207, 232));
		add(btnCalcular);
		
	}

	private void iniciarEventos(){
		
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				cmbPizza.setSelectedItem(null);
				cmbSuco.setSelectedItem(null);
				cmbRefri.setSelectedItem(null);
				txtPrecoTotal.setText("0.00");
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

