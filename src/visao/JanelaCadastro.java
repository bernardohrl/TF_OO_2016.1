package visao;

import javax.swing.*;

import validacao.Validacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dados.Data;
import dados.MaiorIdade;
import dados.MenorIdade;
import dados.RegistroPessoas;

public class JanelaCadastro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Integer idade = -1;
	private Integer opcoesDias[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	private Integer opcoesMeses[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	private Integer opcoesAnos[] = {2016,2015,2014,2013,2012,2011,2010,2009,2008,2007,2006,2005,2004,2003,2002,2001,2000,1999,1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,1975,1974,1973,1972,1971,1970,1969,1968,1967,1966,1965,1964,1963,1962,1961,1960,1959,1958,1957,1956,1955,1954,1953,1952,1951,1950,1949,1948,1947,1946,1945,1944,1943,1942,1941,1940,1939,1938,1937,1936,1935,1934,1933,1932,1931,1930,1929,1928,1927,1926,1925,1924,1923,1922,1921,1920,1919,1918,1917,1916,1915,1914,1913,1912,1911,1910,1909,1908,1907,1906,1905,1904,1903,1902,1901};

	private JFrame janela; 											//janela
	private JTextField txtNome = new JTextField();					//nome
	private JLabel lblNome = new JLabel("Nome");
	private JLabel lblSexo = new JLabel("Sexo");					//sexo
	private JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
	private JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
	private JRadioButton rdbtnOutro = new JRadioButton("Outro");
	private ButtonGroup grupo = new ButtonGroup();
	private JLabel lblCpf = new JLabel("CPF");						//cpf
	private JTextField txtCPF = new JTextField();
	private JLabel lblIdade = new JLabel("Nascimento");				//dataNascimento
	private JComboBox<Integer> dia = new JComboBox<Integer>(opcoesDias);
	private JComboBox<Integer> mes = new JComboBox<Integer>(opcoesMeses);
	private JComboBox<Integer> ano = new JComboBox<Integer>(opcoesAnos);
	private JCheckBox confirmaIdade = new JCheckBox();	
	private JButton cadastrar = new JButton("Cadastrar");			//cadastrar
	private JButton voltar = new JButton("Voltar");					//voltar			
	private JLabel vacinado = new JLabel("Já foi vacinado?");		//Vacinacao
	private JLabel qtdVacinado = new JLabel("Quantidade de vezes vacinado: ");
	private JRadioButton sim = new JRadioButton("Sim");
	private JRadioButton nao = new JRadioButton("Não");
	private ButtonGroup grupo2 = new ButtonGroup();
	private JTextField txtVacinado = new JTextField();


	public JanelaCadastro()
	{	
		janela = new JFrame();
	}

	public void montaJanelaCadastro(RegistroPessoas listaPessoas)
	{
		montaFrame();
		montaNome();
		montaSexo();
		montaCPF();
		montaIdade();
		montaVacinado();
		montaCadastrar(listaPessoas);
		montaVoltar();
	}


	private void montaFrame()
	{
		janela.setTitle("Cadastro");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(400,460);
		janela.setResizable(true);
		janela.setLocationRelativeTo(null);
		janela.setBounds(100, 100, 450, 300);
		janela.getContentPane().setLayout(null);

	}


	private void montaNome()
	{
		lblNome.setBounds(12, 26, 70, 15);
		janela.getContentPane().add(lblNome);

		txtNome.setBounds(68, 24, 114, 19);
		janela.getContentPane().add(txtNome);
		txtNome.setColumns(10);
	}


	private void montaSexo()
	{
		lblSexo.setBounds(12, 53, 70, 15);
		janela.getContentPane().add(lblSexo);

		rdbtnMasculino.setBounds(68, 49, 100, 23);
		janela.getContentPane().add(rdbtnMasculino);

		rdbtnFeminino.setBounds(177, 51, 100, 23);
		janela.getContentPane().add(rdbtnFeminino);

		rdbtnOutro.setBounds(281, 53, 149, 23);
		janela.getContentPane().add(rdbtnOutro);

		grupo.add(rdbtnMasculino);
		grupo.add(rdbtnFeminino);
		grupo.add(rdbtnOutro);
	}


	private void montaCPF()
	{
		lblCpf.setBounds(12, 98, 70, 15);
		janela.getContentPane().add(lblCpf);

		txtCPF.setBounds(65, 96, 114, 19);
		janela.getContentPane().add(txtCPF);
		txtCPF.setColumns(11);

	}


	private void montaIdade()
	{
		lblIdade.setBounds(12, 125, 120, 15);
		janela.getContentPane().add(lblIdade);

		dia.setBounds(135, 125, 60, 25);
		janela.getContentPane().add(dia);

		mes.setBounds(205, 125, 60, 25);
		janela.getContentPane().add(mes);

		ano.setBounds(270, 125, 60, 25);
		janela.getContentPane().add(ano);

		confirmaIdade.setBounds(12, 170, 400, 25);
		confirmaIdade.setText("Confirma Idade");
		janela.getContentPane().add(confirmaIdade);
		confirmaIdade.addActionListener(this);

	}


	private void montaVacinado()
	{
		vacinado.setBounds(12, 200, 200, 25);
		sim.setBounds(212, 200, 50, 25);
		nao.setBounds(262, 200, 70, 25);
		grupo2.add(sim);
		grupo2.add(nao);
		
		qtdVacinado.setBounds(12, 200, 500, 25);
		txtVacinado.setBounds(262, 200, 150, 25);
		txtVacinado.setColumns(10);
	}


	private void montaCadastrar(final RegistroPessoas listaPessoas)
	{
		cadastrar.setBounds(75, 255, 125, 25);
		janela.getContentPane().add(cadastrar);
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(confirmaIdade.isSelected())
					pegarValores(idade, listaPessoas);
				else
					Visao.painelErro("Erro", "Confirme a Idade");
			}
		});
	}


	private void montaVoltar()
	{
		voltar.setBounds(230, 255, 125, 25);
		janela.getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
			}
		});
	}



	//ACOES DA JANELA
	public void actionPerformed(ActionEvent evento) {

		Integer diaInt = Integer.parseInt(dia.getSelectedItem().toString());
		Integer mesInt = Integer.parseInt( mes.getSelectedItem().toString());
		Integer anoInt = Integer.parseInt(ano.getSelectedItem().toString());

		if(evento.getSource() == confirmaIdade && confirmaIdade.isSelected())
		{
			if(!Validacao.validaNascimento(diaInt, mesInt, anoInt))
			{
				idade = Data.descobrirIdade(diaInt, mesInt, anoInt);
				selecionarPainelVacinas(idade);
			}
			else
			{
				Visao.painelErro("Erro", "Data de Nascimento Inválida. Selecione outra data e confirme novamente!");
				confirmaIdade.setSelected(false);
			}
		}
	}

	//PAINEL A SER MOSTRADO
	private void selecionarPainelVacinas(int idade)
	{
		if(idade>=18)
		{
			if(txtVacinado.isVisible())
			{
				janela.getContentPane().remove(txtVacinado);
				janela.getContentPane().remove(qtdVacinado);
			}
			janela.getContentPane().add(vacinado);
			janela.getContentPane().add(sim);
			janela.getContentPane().add(nao);
			janela.getContentPane().setVisible(false);
			janela.getContentPane().setVisible(true);
		}
		else
		{
			if(vacinado.isVisible())
			{
				janela.getContentPane().remove(vacinado);
				janela.getContentPane().remove(sim);
				janela.getContentPane().remove(nao);
			}
			janela.getContentPane().add(qtdVacinado);
			janela.getContentPane().add(txtVacinado);
			janela.getContentPane().setVisible(false);
			janela.getContentPane().setVisible(true);
		}
	}

	//PEGAR VALORES
	private void pegarValores(int idade, RegistroPessoas listaPessoas)
	{
		String nome = "error";
		String sexo = "error";
		String cpf = "error";
		String qtdVacinas = "error";
		Boolean vacinado = null;
		Boolean valido = true;
		Data dataNascimento = null;

		//Nome
		nome = txtNome.getText();
		if(Validacao.validaNome(nome))
			valido = false;

		//Sexo
		if(rdbtnFeminino.isSelected())
			sexo = "Feminino";
		else if (rdbtnMasculino.isSelected())
			sexo = "Masculino";
		else if (rdbtnOutro.isSelected())
			sexo = "Outro";
		else
		{
			Visao.painelErro("Erro", "Selecione um sexo!");
			valido = false;
		}

		//CPF
		cpf = txtCPF.getText().toString();
		if(Validacao.validaCpf(cpf, listaPessoas))
		{
			//System.out.println("entrou");
			valido = false;
		}

		if(listaPessoas.validaUnicidadeCPF(cpf))
			valido = false;


		//Vacinacao
		if(idade<18)
		{	
			qtdVacinas =  txtVacinado.getText().toString();
			if(Validacao.validaQtdVacinas(qtdVacinas))
				valido = false;
		}
		else
		{
			if(nao.isSelected())
				vacinado = false;
			else if (sim.isSelected())
				vacinado = true;
			else
			{
				Visao.painelErro("Erro", "Selecione se já tomou vacina!");
				valido = false;
			}
		}

		//Data nascimento
		dataNascimento = new Data(Integer.parseInt(dia.getSelectedItem().toString()),Integer.parseInt( mes.getSelectedItem().toString()),Integer.parseInt(ano.getSelectedItem().toString()));



		if(valido && idade<18)
		{
			MenorIdade menorIdade = new MenorIdade(nome, sexo, dataNascimento, cpf, Integer.parseInt(qtdVacinas), idade);
			listaPessoas.setListaPessoas(menorIdade);
			janela.setVisible(false);
		}
		else if(valido && idade>=18)
		{
			MaiorIdade maiorIdade = new MaiorIdade(nome, sexo, dataNascimento, cpf, vacinado, idade);
			listaPessoas.setListaPessoas(maiorIdade);
			janela.setVisible(false);
		}

	}
}