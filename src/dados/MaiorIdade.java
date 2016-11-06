package dados;

public class MaiorIdade extends Pessoa {
	private Boolean vacinada;

	public MaiorIdade(String nome, String sexo, Data dataNascimento, String cpf, boolean vacinada, Integer idade)
	{
		super.setNome(nome);
		super.setSexo(sexo);
		super.setDataNascimento(dataNascimento);
		super.setCpf(cpf);
		super.setIdade(idade);
		this.vacinada = vacinada;
	}

	public boolean getVacinada() {
		return vacinada;
	}

	public void setVacinada(boolean vacinada) {
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
				+ ((this.getVacinada()) ? "Sim" : "Não") );
	}
	
	/*
	public String toString()
	{
		return ("\n"+ super.getNome() + "          " 
				+ super.getCpf() + "          "
				+ super.getSexo() + "          "
				+ super.getDataNascimento() + "          "
				+ super.getIdade() + "          "
				+ ((this.getVacinada()) ? "Sim" : "Não") );
	}*/
}
