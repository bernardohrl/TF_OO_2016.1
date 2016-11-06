package dados;

public abstract class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private String sexo;
	private Data dataNascimento;
	private String cpf;
	private Integer idade;

	//NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	//SEXO
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	//DATA NASCIMENTO
	public Data getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	//CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	//IDADE
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	
	public int compareTo(Pessoa objeto) {
		Pessoa pessoaParametro = (Pessoa)objeto;
		return this.getNome().compareTo( pessoaParametro.getNome());
	}
}
