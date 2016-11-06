package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JanelaInstrucoes implements ActionListener {

	private JFrame janela;
	private JButton ok = new JButton("Ok");

	public JanelaInstrucoes()
	{
		janela = new JFrame();
	}

	public void montarJanelaIntrucoes()
	{
		montaTela();
		montaInstrucoes();
		montaBotaoOk();
	}

	private void montaTela()
	{
		janela.setTitle("Instruções");
		janela.setSize(500, 220);
		janela.setBackground(Color.black);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLayout(new GridLayout(6, 1));
		janela.setLocationRelativeTo(null);
	}

	private void montaInstrucoes()
	{
		JLabel cadastrar = new JLabel("Cadastrar – cadastrar novos usuários", JLabel.CENTER);
		janela.add(cadastrar);
		JLabel listar = new JLabel("Listar - listar todas as pessoas cadastradas", JLabel.CENTER);
		janela.add(listar);
		JLabel consultar = new JLabel("Consultar - uma pessoa por meio de seu CPF", JLabel.CENTER);
		janela.add(consultar);
		JLabel pesquisar = new JLabel("Pesquisar - usando parte do nome", JLabel.CENTER);
		janela.add(pesquisar);
		JLabel sair = new JLabel("Sair - do programa", JLabel.CENTER);
		janela.add(sair);
	}

	private void montaBotaoOk()
	{
		JPanel painel = new JPanel();
		painel.add(ok);
		ok.setBounds(20, 20, 20, 25);
		ok.addActionListener(this);
		janela.add(painel);
		janela.getContentPane().setVisible(false);
		janela.getContentPane().setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {
		JanelaInicial janela = new JanelaInicial();
		janela.montarJanelaInicial();
		this.janela.setVisible(false);
	}
}