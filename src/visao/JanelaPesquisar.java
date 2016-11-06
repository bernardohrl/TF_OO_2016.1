package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import dados.Pessoa;
import dados.RegistroPessoas;

public class JanelaPesquisar {
	private JFrame janela;
	private JLabel lblnome = new JLabel("Nome: ");
	private JTextField txtnome = new JTextField();
	private JButton pesquisar = new JButton("Pesquisar");
	private JButton voltar = new JButton("Voltar");
	private String[] colunas = {"Nome", "CPF", "Sexo", "Data de Nascimento", "Idade", "Vacinado"};
	private String[][] dados;
	private JPanel painel = new JPanel();
	private JTable tabela;
	private JScrollPane painelRolamento;
	private JLabel lblTotal = new JLabel();
	private JPanel painel2 = new JPanel();

	public JanelaPesquisar()
	{
		janela = new JFrame();
	}

	public void montaJanelaPesquisar(RegistroPessoas listaPessoas)
	{
		montaJanela();
		montaNome();
		montaPesquisar(listaPessoas);
		montaVoltar();
	}

	private void montaJanela()
	{
		janela.setTitle("Pesquisar");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(500,300);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.getContentPane().setLayout(null);
	}

	private void montaNome()
	{
		lblnome.setBounds(12, 26, 70, 15);
		janela.getContentPane().add(lblnome);

		txtnome.setBounds(68, 24, 114, 19);
		janela.getContentPane().add(txtnome);
		txtnome.setColumns(10);
	}

	private void montaPesquisar(final RegistroPessoas listaPessoas)
	{
		pesquisar.setBounds(50, 250, 125, 25);
		janela.getContentPane().add(pesquisar);
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Vector<Pessoa> VectorEncontrado = new Vector<Pessoa>();
				boolean encontrado = false;

				if(txtnome.getText().isEmpty())
					Visao.painelErro("Erro", "Preencha o campo do Nome!");
				else
				{
					for(Pessoa pessoa : listaPessoas.getListaPessoas())
						if(pessoa.getNome().toLowerCase().contains(txtnome.getText().toLowerCase()))
						{
							VectorEncontrado.add(pessoa);
							encontrado = true;
						}
				}
				
				janela.add(painel2);
				painel2.setVisible(true);
				painel2.setBounds(250, 0, 250, 15);
				lblTotal.setText("Total Pesquisados: " + VectorEncontrado.size());
				lblTotal.setBounds(0,0, 250, 15);
				painel2.add(lblTotal);
				
				List<Pessoa> lista = new ArrayList<Pessoa>(VectorEncontrado);
				Collections.sort(lista);
				ModeloDeTabela modelo = new ModeloDeTabela(lista);

				if(!encontrado && !txtnome.getText().isEmpty())
					Visao.painelErro("Erro", "Nome não encontrado!");

				if(encontrado)
				{
					janela.getContentPane().add(painel);
					painel.setBounds(25, 55, 600, 150);
					//painel.setBackground(Color.black);

					tabela = new JTable(dados, colunas);
					painelRolamento = new JScrollPane(tabela);
					painel.add(painelRolamento);
					painelRolamento.setBounds(0, 0, 465, 150);
					tabela.setModel(modelo);
				}
			}
		});
	}

	private void montaVoltar()
	{
		voltar.setBounds(250, 250, 125, 25);
		janela.getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
			}
		});
	}
}
