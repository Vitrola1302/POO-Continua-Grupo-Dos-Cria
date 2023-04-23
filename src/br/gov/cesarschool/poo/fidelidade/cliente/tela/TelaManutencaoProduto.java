package br.gov.cesarschool.poo.fidelidade.cliente.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaManutencaoProduto {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Label lblCdigo;
	private Label lblNome;
	private Label lblPreo;
	private Label lblEstoque;
	private Label lblTipo;
	private Text txtCPF;
	private Text txtNome;
	private Text txtPreco;
	private Text txtEstoque;
	private Combo cmbTipo;
	private Button btnNovo;
	private Button btnBuscar;
	private Button btnIncluiralterar;
	private Button btnLimpar;
	private Button btnVoltar;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaManutencaoProduto window = new TelaManutencaoProduto();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setToolTipText("");
		shell.setSize(538, 396);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblCPF = new Label(shell, SWT.NONE);
		lblCPF.setBounds(39, 35, 70, 20);
		lblCPF.setText("CPF");
		this.lblCdigo = lblCPF;
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(39, 84, 70, 20);
		lblNome.setText("Nome");
		this.lblNome = lblNome;
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(39, 138, 70, 20);
		lblPreo.setText("Pre\u00E7o");
		this.lblPreo = lblPreo;
		
		Label lblEstoque = new Label(shell, SWT.NONE);
		lblEstoque.setBounds(39, 191, 70, 20);
		lblEstoque.setText("Estoque");
		this.lblEstoque = lblEstoque;
		
		Label lblTipo = new Label(shell, SWT.NONE);
		lblTipo.setBounds(39, 244, 70, 20);
		lblTipo.setText("Tipo");
		this.lblTipo = lblTipo;
		
		txtCPF = new Text(shell, SWT.BORDER);
		txtCPF.setToolTipText("");
		txtCPF.setBounds(128, 35, 106, 26);
		formToolkit.adapt(txtCPF, true, true);
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnBuscar.setBounds(360, 31, 90, 30);
		this.btnBuscar = btnBuscar;
		formToolkit.adapt(btnBuscar, true, true);
		btnBuscar.setText("Buscar");
		
		Combo cmbTipo = new Combo(shell, SWT.NONE);
		cmbTipo.setBounds(129, 241, 243, 23);
		this.cmbTipo = cmbTipo;
		cmbTipo.setEnabled(false);
		cmbTipo.setItems(new String[] {"Eletr\u00F4nicos", "Linha branca", "Computadores e celulares"});
		formToolkit.adapt(cmbTipo);
		formToolkit.paintBordersFor(cmbTipo);
		
		Button btnNovo = new Button(shell, SWT.NONE);
		btnNovo.setBounds(255, 31, 90, 30);
		btnNovo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		this.btnNovo = btnNovo;
		formToolkit.adapt(btnNovo, true, true);
		btnNovo.setText("Novo");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(128, 84, 281, 26);
		txtNome.setEnabled(false);
		formToolkit.adapt(txtNome, true, true);
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(128, 138, 106, 26);
		txtPreco.setEditable(true);
		txtPreco.setEnabled(false);
		txtPreco.setText("");
		formToolkit.adapt(txtPreco, true, true);
		
		txtEstoque = new Text(shell, SWT.BORDER);
		txtEstoque.setBounds(128, 191, 78, 26);
		txtEstoque.setEnabled(false);
		formToolkit.adapt(txtEstoque, true, true);
		
		
		Button btnIncluiralterar = new Button(shell, SWT.NONE);
		btnIncluiralterar.setBounds(75, 309, 106, 30);
		btnIncluiralterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Long codigo = obterCodigo();
				Double preco = obterPreco();
				Integer estoque = obterEstoque();
				if(codigo == null || preco == null || estoque == null) {
					return;
				}
				Produto prod = new Produto(codigo, txtNome.getText(), 
						preco, estoque, 
						TipoProduto.obterPorCodigo(cmbTipo.getSelectionIndex()));
				String mensagem = null;
				if (btnIncluiralterar.getText().equals("Incluir")) {
					mensagem = ProdutoMediator.incluir(prod);
				} else {
					mensagem = ProdutoMediator.alterar(prod);
				}
				if (mensagem == null) {
					JOptionPane.showMessageDialog(null, 
							"Produto incluído/alterado com sucesso!");		
					acaoVoltar();
				} else {
					JOptionPane.showMessageDialog(null, 
							mensagem);										
				}
			}
		});
		this.btnIncluiralterar = btnIncluiralterar;
		btnIncluiralterar.setEnabled(false);
		formToolkit.adapt(btnIncluiralterar, true, true);
		btnIncluiralterar.setText("Incluir/Alterar");
		
		Button btnLimpar = new Button(shell, SWT.NONE);
		btnLimpar.setBounds(202, 309, 90, 30);
		this.btnLimpar = btnLimpar;
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				limpar();
			}
		});
		
		btnLimpar.setEnabled(false);
		formToolkit.adapt(btnLimpar, true, true);
		btnLimpar.setText("Limpar");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.setBounds(319, 309, 90, 30);
		this.btnVoltar = btnVoltar; 
		btnVoltar.setEnabled(false);
		formToolkit.adapt(btnVoltar, true, true);
		btnVoltar.setText("Voltar");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Long codigo = obterCodigo();
				if (codigo == null) {
					return;
				}				
				Produto prod = ProdutoMediator.buscar(codigo);				
				if (prod != null) {
					JOptionPane.showMessageDialog(null, 
							"Produto já existente!");		
					return;
				}
				desabilitarElementosAcesso();
				habilitarElementosDetalhe();
				btnIncluiralterar.setText("Incluir");
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Long codigo = obterCodigo();
				if (codigo == null) {
					return;
				}
				Produto prod = ProdutoMediator.buscar(codigo);
				if (prod == null) {
					JOptionPane.showMessageDialog(null, 
							"Produto não encontrado!");		
					return;
				} else {
					txtNome.setText(prod.getNome());
					txtPreco.setText(prod.getPreco() + "");
					txtEstoque.setText(prod.getEstoque() + "");
					cmbTipo.select(prod.getTipo().getCodigo());					
				}
				desabilitarElementosAcesso();
				habilitarElementosDetalhe();
				btnIncluiralterar.setText("Alterar");
			}
		});
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				acaoVoltar();
			}
		});
	}
	private Long obterCodigo() {
		Long codigo = null;
		try {
			codigo = Long.parseLong(txtCPF.getText().trim());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
					"Formato de código inválido!");
			
		}	
		return codigo;
	}
	private Double obterPreco() {
		Double preco = null;
		try {
			preco = Double.parseDouble(txtPreco.getText().trim());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
					"Formato de preço inválido!");
			
		}	
		return preco;
	}
	private Integer obterEstoque() {
		Integer estoque = null;
		try {
			estoque = Integer.parseInt(txtEstoque.getText().trim());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
					"Formato de estoque inválido!");
			
		}	
		return estoque;
	}	
	private void limpar() {
		txtNome.setText("");
		txtPreco.setText("");
		txtEstoque.setText("");
		cmbTipo.deselectAll();		
	}
	private void habilitarElementosDetalhe() {
		txtNome.setEnabled(true);
		txtPreco.setEnabled(true);
		txtEstoque.setEnabled(true);
		cmbTipo.setEnabled(true);
		btnIncluiralterar.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnVoltar.setEnabled(true);						
	}
	private void desabilitarElementosDetalhe() {
		txtNome.setEnabled(false);
		txtPreco.setEnabled(false);
		txtEstoque.setEnabled(false);
		cmbTipo.setEnabled(false);
		btnIncluiralterar.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnVoltar.setEnabled(false);						
	}
	private void habilitarElementosAcesso() {
		txtCPF.setEnabled(true);
		btnNovo.setEnabled(true);
		btnBuscar.setEnabled(true);
	}
	private void desabilitarElementosAcesso() {
		txtCPF.setEnabled(false);
		btnNovo.setEnabled(false);
		btnBuscar.setEnabled(false);
	}
	private void acaoVoltar() {
		txtCPF.setText("");
		limpar();
		desabilitarElementosDetalhe();
		habilitarElementosAcesso();		
	}
}