package br.gov.cesarschool.poo.fidelidade.cliente.tela;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import br.gov.cesarschool.poo.fidelidade.cliente.dao.*;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.*;
import br.gov.cesarschool.poo.fidelidade.cliente.negocio.*;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.*;
import br.gov.cesarschool.poo.fidelidade.util.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class TelaManutencaoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldLogradouro;
	private JTextField textFieldComplemento;
	private JTextField textFieldCidade;
	private JFormattedTextField formattedTextFieldCPF;
	private JFormattedTextField formattedTextFieldDataDeNascimento;
	private JFormattedTextField formattedTextFieldCep;
	private JFormattedTextField formattedTextFieldRenda;
	private JFormattedTextField formattedTextFieldNumero;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private JButton btnNovo;
	private JButton btnBuscar;
	private JButton btnIncluirAlterar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JComboBox comboBoxEstado;
	private ButtonGroup sexoBg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaManutencaoCliente frame = new TelaManutencaoCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaManutencaoCliente() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 11, 41, 14);
		contentPane.add(lblCPF);
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setBounds(10, 36, 85, 14);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 61, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(10, 86, 112, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblRenda = new JLabel("Renda");
		lblRenda.setBounds(10, 111, 46, 14);
		contentPane.add(lblRenda);
		
		JLabel lblLogaradouro = new JLabel("Logradouro");
		lblLogaradouro.setBounds(10, 136, 85, 14);
		contentPane.add(lblLogaradouro);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(10, 161, 46, 14);
		contentPane.add(lblNumero);
		
		JLabel lblComlemento = new JLabel("Complemento");
		lblComlemento.setBounds(10, 186, 85, 14);
		contentPane.add(lblComlemento);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(10, 211, 46, 14);
		contentPane.add(lblCEP);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 236, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 261, 46, 14);
		contentPane.add(lblEstado);
		
		textFieldNome = new JTextField();
		textFieldNome.setEnabled(false);
		textFieldNome.setBounds(140, 33, 150, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setEnabled(false);
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(140, 133, 150, 20);
		contentPane.add(textFieldLogradouro);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setEnabled(false);
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(140, 183, 150, 20);
		contentPane.add(textFieldComplemento);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setEnabled(false);
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(140, 233, 150, 20);
		contentPane.add(textFieldCidade);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setEnabled(false);
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"PE", "RJ"}));
		comboBoxEstado.setBounds(140, 257, 150, 22);
		contentPane.add(comboBoxEstado);
		this.comboBoxEstado = comboBoxEstado;
		
		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField(new MaskFormatter("###########")); // ###.###.###-##
		formattedTextFieldCPF.setBounds(140, 8, 90, 20);
		contentPane.add(formattedTextFieldCPF);
		this.formattedTextFieldCPF = formattedTextFieldCPF;
		
		JFormattedTextField formattedTextFieldDataDeNascimento = new JFormattedTextField(new MaskFormatter("########")); // ##/##/####
		formattedTextFieldDataDeNascimento.setEnabled(false);
		formattedTextFieldDataDeNascimento.setText("");
		formattedTextFieldDataDeNascimento.setBounds(140, 83, 71, 20);
		contentPane.add(formattedTextFieldDataDeNascimento);
		this.formattedTextFieldDataDeNascimento = formattedTextFieldDataDeNascimento;
		
		JFormattedTextField formattedTextFieldCep = new JFormattedTextField(new MaskFormatter("########")); // ##.###-###
		formattedTextFieldCep.setText("");
		formattedTextFieldCep.setEnabled(false);
		formattedTextFieldCep.setBounds(140, 208, 71, 20);
		contentPane.add(formattedTextFieldCep);
		this.formattedTextFieldCep = formattedTextFieldCep;
		
		JFormattedTextField formattedTextFieldRenda = new JFormattedTextField(new MaskFormatter("############")); // ##########.##
		formattedTextFieldRenda.setText("");
		formattedTextFieldRenda.setEnabled(false);
		formattedTextFieldRenda.setBounds(140, 108, 90, 20);
		contentPane.add(formattedTextFieldRenda);
		this.formattedTextFieldRenda = formattedTextFieldRenda;
		
		JFormattedTextField formattedTextFieldNumero = new JFormattedTextField(new MaskFormatter("#######"));
		formattedTextFieldNumero.setText("");
		formattedTextFieldNumero.setEnabled(false);
		formattedTextFieldNumero.setBounds(140, 158, 59, 20);
		contentPane.add(formattedTextFieldNumero);
		this.formattedTextFieldNumero = formattedTextFieldNumero;
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = getCpf();
				if(!ValidadorCPF.ehCpfValido(cpf)) {
					JOptionPane.showMessageDialog(null, 
							"Formato de cpf inválido!");
					return;
				}
				ClienteDAO dao = new ClienteDAO();
				Cliente cliente = dao.buscar(cpf);
				if(cliente != null) {
					JOptionPane.showMessageDialog(null, 
							"Cliente já existente!");		
					return;
				} else {
					disableAcessElements();
					enableDetailElements();
					btnIncluirAlterar.setText("Incluir");				
				}			
			}
		});
		btnNovo.setBounds(240, 7, 65, 23);
		contentPane.add(btnNovo);
		this.btnNovo = btnNovo;
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = getCpf();
				if (ValidadorCPF.ehCpfValido(cpf)) {
					JOptionPane.showMessageDialog(null, 
							"Formato de cpf inválido!");
					return;
				}
				ClienteDAO cDao = new ClienteDAO();
				Cliente cliente = cDao.buscar(cpf);
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, 
							"Cliente não encontrado!");		
					return;
				} else {
					textFieldNome.setText(cliente.getCpf());
					if(cliente.getSexo().getCodigo() == 1){
						rdbtnM.setSelected(true);
					} else {
						rdbtnF.setSelected(true);
					}		
					formattedTextFieldRenda.setText(cliente.getRenda() + "");
					textFieldLogradouro.setText(cliente.getEndereco().getLogradouro());
					formattedTextFieldNumero.setText(cliente.getEndereco().getNumero() + "");
					textFieldComplemento.setText(cliente.getEndereco().getComplemento());
					formattedTextFieldCep.setText(cliente.getEndereco().getCep());
					textFieldCidade.setText(cliente.getEndereco().getCidade());	
					//comboBoxEstado.set; //Set estado to cliente.getEndereco().getEstado();
				}
				disableAcessElements();
				enableDetailElements();;
				btnIncluirAlterar.setText("Alterar");
			}
		});
		btnBuscar.setBounds(315, 7, 65, 23);
		contentPane.add(btnBuscar);
		this.btnBuscar = btnBuscar;
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setEnabled(false);
		rdbtnM.setBounds(140, 57, 41, 23);
		contentPane.add(rdbtnM);
		this.rdbtnM = rdbtnM;
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setEnabled(false);
		rdbtnF.setBounds(183, 57, 41, 23);
		contentPane.add(rdbtnF);
		this.rdbtnF = rdbtnF;
		
		
		ButtonGroup sexoBg = new ButtonGroup();
	    sexoBg.add(rdbtnM);
	    sexoBg.add(rdbtnF);
	    this.sexoBg = sexoBg;
	    
	    JButton btnIncluirAlterar = new JButton("Incluir/Alterar");
	    btnIncluirAlterar.setEnabled(false);
	    btnIncluirAlterar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String cpf = formattedTextFieldCPF.getText();
	    		String nome = textFieldNome.getText();
	    		
	    		Sexo sexo;
	    		if(rdbtnM.isSelected()) {
	    			sexo = Sexo.getByCodigo(1);
	    			
	    		} else if (rdbtnF.isSelected()) {
	    			sexo = Sexo.getByCodigo(2);
	    			
	    		} else {
	    			sexo = null;
	    		}
	    		
	    		Date dataDeNascimento = new Date(Long.parseLong(formattedTextFieldDataDeNascimento.getText()));
	    		double renda = Double.parseDouble(formattedTextFieldRenda.getText());
	    		
	    		String logradouro = textFieldLogradouro.getText();
	    		int numero = Integer.parseInt(formattedTextFieldNumero.getText());
	    		String complemento = textFieldComplemento.getText();
	    		String cep = formattedTextFieldCep.getText();
	    		String cidade = textFieldCidade.getText();
	    		String estado = comboBoxEstado.getSelectedItem().toString();
	    		String pais = "Brasil";
	    		
	    		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, cidade, estado, pais);
	    		
	    		Cliente cliente = new Cliente(cpf, nome, sexo, dataDeNascimento, renda, endereco);
	    		ClienteMediator mediador = ClienteMediator.getInstance();
	    		
	    		String mensagem;
	    		
	    		if(btnIncluirAlterar.getText().equals("Incluir")) {
	    			ResultadoInclusaoCliente resultado = mediador.incluir(cliente); 
	    			mensagem = resultado.getMensagemErroValidacao();
	    		}else {
	    			mensagem = mediador.alterar(cliente);	
	    		}
	    		if (mensagem == null) {
					JOptionPane.showMessageDialog(null, 
							"Cliente incluído/alterado com sucesso!");		
					returnAction();
				} else {
					JOptionPane.showMessageDialog(null, 
							mensagem);										
				}
	    	}
	    });
	    btnIncluirAlterar.setBounds(71, 290, 99, 23);
	    contentPane.add(btnIncluirAlterar);
	    this.btnIncluirAlterar = btnIncluirAlterar;
	    
	    JButton btnLimpar = new JButton("Limpar");
	    btnLimpar.setEnabled(false);
	    btnLimpar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		clear();
	    	}
	    });
	    btnLimpar.setBounds(183, 290, 89, 23);
	    contentPane.add(btnLimpar);
	    this.btnLimpar = btnLimpar;
	    
	    JButton btnVoltar = new JButton("Voltar");
	    btnVoltar.setEnabled(false);
	    btnVoltar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		returnAction();
	    	}
	    });
	    btnVoltar.setBounds(282, 290, 89, 23);
	    contentPane.add(btnVoltar);
	    this.btnVoltar = btnVoltar;
	    
	}
	private String getCpf() {
		return formattedTextFieldCPF.getText().trim();
	}
	private void clear() {
		textFieldNome.setText("");
		rdbtnM.setSelected(false);
		rdbtnF.setSelected(false);
		formattedTextFieldDataDeNascimento.setText("");
		formattedTextFieldRenda.setText("");
		textFieldLogradouro.setText("");	
		formattedTextFieldNumero.setText("");
		textFieldComplemento.setText("");
		formattedTextFieldCep.setText("");
		textFieldCidade.setText("");
	}
	private void enableDetailElements() {
		textFieldNome.setEnabled(true);
		rdbtnM.setEnabled(true);
		rdbtnF.setEnabled(true);		
		formattedTextFieldDataDeNascimento.setEnabled(true);
		formattedTextFieldRenda.setEnabled(true);
		textFieldLogradouro.setEnabled(true);
		formattedTextFieldNumero.setEnabled(true);
		textFieldComplemento.setEnabled(true);
		formattedTextFieldCep.setEnabled(true);
		textFieldCidade.setEnabled(true);			
		comboBoxEstado.setEnabled(true);
		btnIncluirAlterar.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnVoltar.setEnabled(true);
	}
	private void disableDetailElements() {
		textFieldNome.setEnabled(false);
		rdbtnM.setEnabled(false);
		rdbtnF.setEnabled(false);		
		formattedTextFieldDataDeNascimento.setEnabled(false);
		formattedTextFieldRenda.setEnabled(false);
		textFieldLogradouro.setEnabled(false);
		formattedTextFieldNumero.setEnabled(false);
		textFieldComplemento.setEnabled(false);
		formattedTextFieldCep.setEnabled(false);
		textFieldCidade.setEnabled(false);			
		comboBoxEstado.setEnabled(false);
		btnIncluirAlterar.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnVoltar.setEnabled(false);
	}
	private void enableAcessElements() {
		formattedTextFieldCPF.setEnabled(true);
		btnNovo.setEnabled(true);
		btnBuscar.setEnabled(true);
	}
	private void disableAcessElements() {
		formattedTextFieldCPF.setEnabled(false);
		btnNovo.setEnabled(false);
		btnBuscar.setEnabled(false);
	}
	private void returnAction() {
		formattedTextFieldCPF.setText("");
		clear();
		disableDetailElements();
		enableAcessElements();		
	}
}
