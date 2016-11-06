package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import dados.RegistroPessoas;

public class JanelaInicial implements ActionListener{

	//CRIANDO COMPONENTES
	private JFrame janelaInicial;
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton listar = new JButton("Listar");
	private JButton consultar = new JButton("Consultar");
	private JButton pesquisar = new JButton("Pesquisar");
	private JButton sair = new JButton("Sair");
	private RegistroPessoas listaPessoas = new RegistroPessoas();

	public JanelaInicial()
	{	
		janelaInicial = new JFrame();
	}

	public void montarJanelaInicial()
	{
		montaJanela();
		montaLabel();
		montaBotoes();
	}

	private void montaJanela()
	{
		janelaInicial.setTitle("Menu");
		janelaInicial.setSize(250, 250);
		janelaInicial.setLayout(new GridLayout(6,1)); //Separando em 5 quadrados
		janelaInicial.setVisible(true);
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //programa fecha ao fechar esta janela
		janelaInicial.setResizable(false);
		janelaInicial.setLocationRelativeTo(null);

	}

	private void montaLabel()
	{
		JLabel legenda = new JLabel("Selecione a opção desejada:", JLabel.CENTER);
		janelaInicial.add(legenda);
		legenda.setBounds(0, 25, 300, 25); //vai pra diretira, vai pra baixo, tamanho maiximo em largura, tamanho em altura
	}

	private void montaBotoes()
	{
		//BOTAO CADASTRAR
		janelaInicial.add(cadastrar);
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaCadastro cadastro = new JanelaCadastro();
				cadastro.montaJanelaCadastro(listaPessoas);
			}
		});	



		//BOTAO LISTAR
		janelaInicial.add(listar);
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaPessoas.listarCadastros();
			}
		});




		//BOTAO CONSULTAR
		janelaInicial.add(consultar);
		consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaConsultar janela = new JanelaConsultar();
				janela.montaJanelaConsultar(listaPessoas);
			}
		});




		//BOTAO PESQUISAR
		janelaInicial.add(pesquisar);
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaPesquisar janela = new JanelaPesquisar();
				janela.montaJanelaPesquisar(listaPessoas);
			}
		});




		//BOTAO SAIR
		janelaInicial.add(sair);
		sair.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent acao) {
		String comando;
		comando = acao.getActionCommand();
		if(acao.getSource() == consultar)
		{
			JanelaConsultar janela = new JanelaConsultar();
			janela.montaJanelaConsultar(listaPessoas);
		}
		if(comando.equals("consultar"))
		{
			JanelaConsultar janela = new JanelaConsultar();
			janela.montaJanelaConsultar(listaPessoas);
		}
	}
}
