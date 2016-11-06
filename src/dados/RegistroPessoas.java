package dados;

import interfaces.ChavePessoa;

import java.util.Vector;

import visao.Visao;

public class RegistroPessoas implements ChavePessoa{
	private Vector<Pessoa> listaPessoas;

	public RegistroPessoas() 
	{
		listaPessoas = new Vector<Pessoa>();
	}

	public Vector<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(Pessoa pessoa) {
		listaPessoas.add(pessoa);
	}



	//METODO DE LISTAR CADASTROS
	public void listarCadastros() {
		int maiorIdade=0, menorIdade=0;
		Visao.pulaLinha(10);
		if(listaPessoas.size() == 0)
			System.out.println("NÃO HA CADASTROS");
		else
		{
			System.out.println("Nome                          CPF                  Sexo             DataNascimento       Idade          Vacinado");
			for(Pessoa pessoa : listaPessoas)
			{
				System.out.print(pessoa);
				if(pessoa.getIdade()<18)
					menorIdade++;
				else
					maiorIdade++;
			}

			System.out.println("\n\nMaiores de Idade: " + maiorIdade + "\nMenores de Idade: " + menorIdade + "\nTotal: " + (maiorIdade+menorIdade));
		}
	}

	//METODO DE CONSULTA DE CADATROS
	public void consultarCadastros(String cpf) {
		Boolean registrado = false;
		StringBuilder mensagem = new StringBuilder();
		for(Pessoa pessoa : listaPessoas)
			if(pessoa.getCpf().equals(cpf))
			{
				registrado = true;
				mensagem.append("Nome: " + pessoa.getNome());
				mensagem.append("\nCPF: " + pessoa.getCpf());
				mensagem.append("\nSexo: " + pessoa.getSexo());
				mensagem.append("\nNascimento: " + pessoa.getDataNascimento());
				mensagem.append("\nIdade: " + pessoa.getIdade());
				if(pessoa.getIdade()>=18)
					mensagem.append("\nVacinado: " + ((((MaiorIdade)pessoa).getVacinada()== true ) ? "Sim" : "Não"));
				else
					mensagem.append("\nVacinado: " +  ((MenorIdade)pessoa).getVacinada() + " vezes");
				Visao.painel("Consulta", mensagem.toString());
			}
		if(registrado == false)
			Visao.painel("Consultar", "CPF não encontrado!");
	}

	//VALIDA SE O CPF É UNICO
	public boolean validaUnicidadeCPF(String CPF) {
		for(Pessoa pessoa : listaPessoas)
		{
			//System.out.println("passou aqui");
			if(CPF.equals(pessoa.getCpf()))
			{
				//System.out.println("entrou aqui mas nao foi o painel");
				Visao.painelErro("Erro", "CPF já registrado. Tente novamente!");
				return true;
			}
		}
		return false;
	}
}
