package br.gov.cesarschool.poo.fidelidade.cartao.tela.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.gov.cesarschool.poo.fidelidade.cartao.dao.*;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.*;
import br.gov.cesarschool.poo.fidelidade.cartao.negocio.*;
import br.gov.cesarschool.poo.fidelidade.cliente.dao.ClienteDAO;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.poo.fidelidade.cliente.negocio.ClienteMediator;
import br.gov.cesarschool.poo.fidelidade.cliente.negocio.ResultadoInclusaoCliente;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.Endereco;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.Sexo;
import br.gov.cesarschool.poo.fidelidade.util.ValidadorCPF;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class TelaPontuacaoResgate {

	private JFrame frame;
	private JTextField txtNumeroCartao;
	private JTextField txtSaldoAtual;
	private JTextField txtValor;
	private JComboBox cmbTipoResgate;
	private JButton btnBuscar;
	private JButton btnPontuarResgatar;
	private JButton btnVoltar;
	private JRadioButton rdbtnOperacao;
	private JRadioButton rdbtnResgate;
	private CartaoFidelidade cartaoF;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPontuacaoResgate window = new TelaPontuacaoResgate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPontuacaoResgate() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.setBounds(100, 100, 439, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNumeroCartao = new JTextField();
		txtNumeroCartao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNumeroCartao.setBounds(138, 11, 130, 32);
		frame.getContentPane().add(txtNumeroCartao);
		txtNumeroCartao.setColumns(10);
		this.txtNumeroCartao = txtNumeroCartao;
		
		JRadioButton rdbtnPontuacao = new JRadioButton("Pontuação");
		rdbtnPontuacao.setEnabled(false);
		rdbtnPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPontuacao.setBounds(138, 73, 130, 32);
		frame.getContentPane().add(rdbtnPontuacao);
		
		JRadioButton rdbtnResgate = new JRadioButton("Resgate");
		rdbtnResgate.setEnabled(false);
		rdbtnResgate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnResgate.setBounds(140, 124, 111, 23);
		frame.getContentPane().add(rdbtnResgate);
		
		ButtonGroup botao = new ButtonGroup();
		botao.add(rdbtnPontuacao);
		botao.add(rdbtnResgate);

		
		
		txtSaldoAtual = new JTextField();
		txtSaldoAtual.setEnabled(false);
		txtSaldoAtual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSaldoAtual.setBounds(95, 169, 130, 32);
		frame.getContentPane().add(txtSaldoAtual);
		txtSaldoAtual.setColumns(10);
		this.txtSaldoAtual = txtSaldoAtual;
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtValor.setBounds(56, 294, 130, 32);
		frame.getContentPane().add(txtValor);
		txtValor.setColumns(10);
		this.txtValor = txtValor;
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tipo de Resgate"}));
		comboBox.setToolTipText("Tipo");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(124, 234, 187, 22);
		frame.getContentPane().add(comboBox);
		this.cmbTipoResgate = comboBox;
		
				
		JLabel lblNewLabel = new JLabel("Número do cartão");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 10, 130, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operação");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 68, 130, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo atual");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(6, 168, 130, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de resgate");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(6, 229, 130, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Valor");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(6, 293, 130, 32);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnPontuarResgatar = new JButton("Pontuar/Resgatar");
		btnPontuarResgatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorD;
				try {
					String valor = txtValor.getText().trim();	
					valorD = Double.parseDouble(valor);
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, 
	                            "Valor inválido");
	                    return;
					}
				
				if (rdbtnPontuacao.isSelected()){
					CartaoFidelidadeMediator mediador = CartaoFidelidadeMediator.getInstance();
					mediador.pontuar(cartaoF.getNumero(), valorD);
					}
				else if (rdbtnResgate.isSelected()) {
					
					TipoResgate tipo = TipoResgate.getByDescricao(cmbTipoResgate.getSelectedItem().toString());
					CartaoFidelidadeMediator mediador = CartaoFidelidadeMediator.getInstance();
					mediador.resgatar(cartaoF.getNumero(), valorD, tipo);
					
				}else {
					JOptionPane.showMessageDialog(null, 
                            "Não foi selecionado o tipo");
                    return;
				}
				disableDetailElements();
				enableAcessElements();
			}
		});
		btnPontuarResgatar.setEnabled(false);
		btnPontuarResgatar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPontuarResgatar.setBounds(41, 361, 159, 32);
		frame.getContentPane().add(btnPontuarResgatar);
		this.btnPontuarResgatar = btnPontuarResgatar;
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnAction();
			}
		});
		btnVoltar.setEnabled(false);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(246, 361, 130, 32);
		frame.getContentPane().add(btnVoltar);
		this.btnVoltar = btnVoltar;
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String numeroCartao = txtNumeroCartao.getText().trim();
						if (numeroCartao.length()!= 17){
							JOptionPane.showMessageDialog(null, 
									"Cartão inválido!");
							return;
						}
					CartaoFidelidadeDAO ccf = new CartaoFidelidadeDAO();
					CartaoFidelidade cartao = ccf.buscar(Long.parseLong(numeroCartao));
					if (cartao == null) {
						JOptionPane.showMessageDialog(null, 
								"Cartão não encontrado!");
						return;
					}		
				disableAcessElements();
				enableDetailElements();
				cartaoF = cartao;
			}
		});
				
			
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(278, 10, 130, 32);
		frame.getContentPane().add(btnBuscar);
		this.btnBuscar = btnBuscar;
			
		
	}
			private void clear() {
				
				txtSaldoAtual.setText("");
				txtValor.setText("");
			}
			private void enableDetailElements() {		
				txtSaldoAtual.setEnabled(true);
				txtValor.setEnabled(true);			
				cmbTipoResgate.setEnabled(true);
				btnPontuarResgatar.setEnabled(true);
				btnVoltar.setEnabled(true);
				rdbtnOperacao.setEnabled(true);
				rdbtnResgate.setEnabled(true);

			}
			private void disableDetailElements() {
				txtSaldoAtual.setEnabled(false);
				txtValor.setEnabled(false);			
				cmbTipoResgate.setEnabled(false);
				btnPontuarResgatar.setEnabled(false);
				btnVoltar.setEnabled(false);
				rdbtnOperacao.setEnabled(false);
				rdbtnResgate.setEnabled(false);

			}
			private void enableAcessElements() {
				txtNumeroCartao.setEnabled(true);
				btnBuscar.setEnabled(true);
			}
			private void disableAcessElements() {
				txtNumeroCartao.setEnabled(false);
				btnBuscar.setEnabled(false);
			}
			private void returnAction() {
				txtNumeroCartao.setText("");
				clear();
				disableDetailElements();
				enableAcessElements();		
			}

}
