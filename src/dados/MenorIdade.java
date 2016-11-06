package dados;

public class MenorIdade extends Pessoa{
	private Integer vacinada;

	public MenorIdade(String nome, String sexo, Data dataNascimento, String cpf, int vacinada, int idade)
	{
		super.setNome(nome);
		super.setSexo(sexo);
		super.setDataNascimento(dataNascimento);
		super.setCpf(cpf);
		super.setIdade(idade);
		this.vacinada = vacinada;
	}

	public Integer getVacinada() {
		return vacinada;
	}

	public void setVacinada(Integer vacinada) {
		this.vacinada = vacinada;
	}

	
	public String toString()
	{
		StringBuilder espaçacamento = new StringBuilder();
		for(int i=0; i<30-super.getNome().length(); i++)
			espaçacamento.append(" ");
				
		return ("\n"+ super.getNome() + espaçacamento.toString() 
				+ super.getCpf() + "          "
				+ super.getSexo() + "          "
				+ super.getDataNascimento() + "             "
				+ super.getIdade() + "            "
				+ this.getVacinada() + " vezes" );
	}
	
	/*
	public String toString()
	{
		return ("\n"+ super.getNome() + "          " 
				+ super.getCpf() + "          "
				+ super.getSexo() + "          "
				+ super.getDataNascimento() + "          "
				+ super.getIdade() + "          "
				+ this.getVacinada() + " vezes");
	}*/

}
