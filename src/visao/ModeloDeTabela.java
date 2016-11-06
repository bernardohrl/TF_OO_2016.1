package visao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Pessoa;
import dados.MaiorIdade;
import dados.MenorIdade;

public class ModeloDeTabela extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Pessoa> listaEncontrada = new ArrayList<Pessoa>();


	public ModeloDeTabela (List<Pessoa> listaEncontrada)
	{
		this.listaEncontrada = listaEncontrada;
	}

	public Object getValueAt(int linha, int coluna) {
		//if(listaEncontrada.get(linha).getClass().getName().equalsIgnoreCase(Pessoa.class.getName()))
		//{
		Pessoa pessoa = (Pessoa) listaEncontrada.get(linha);
		switch(coluna)
		{
		case 0:
			return pessoa.getNome();
		case 1:
			return pessoa.getCpf();
		case 2:
			return pessoa.getSexo();
		case 3:
			return pessoa.getDataNascimento();
		case 4:
			return pessoa.getIdade();
		case 5:
			if(pessoa.getIdade()>=18)
				return ((((MaiorIdade)pessoa).getVacinada()== true ) ? "Sim" : "Não");
			else
				return ((MenorIdade)pessoa).getVacinada() + " vezes";
		case 6:
			return 0;
		}
		return null;
	}

	public String getColumnName(int coluna) {
		switch (coluna) {
		case 0:
			return "Nome";
		case 1:
			return "CPF";
		case 2:
			return "Sexo";
		case 3:
			return "Data de Nascimento";
		case 4:
			return "Idade";
		case 5:
			return "Vacinado";
		}
		return null; 
	}


	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {

		return listaEncontrada.size();
	}
}
