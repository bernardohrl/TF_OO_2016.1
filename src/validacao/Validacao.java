package validacao;

import dados.RegistroPessoas;
import visao.Visao;

public class Validacao {

	//VALIDACAO DO NOME
	public static boolean validaNome(String nome)
	{
		if(nome.isEmpty())
		{
			Visao.painelErro("Erro", "Nome não pode ser vazio!");
			return true;
		}
		return false;
	}


	//VALIDACAO DA DATA DE NASCIMENTO
	public static boolean validaNascimento(int dia, int mes, int ano)
	{
		if(mes == 2)
		{
			if(ano%4!=0 && dia>28)
				return true;
			else if(dia>29)
				return true;
			else 
				return false;
		}
		if(mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11)
		{
			if(dia>30)
				return true;
			else 
				return false;
		}
		else
			return false;
	}


	//VALIDACAO DA QUANTIDADE DE VEZES QUE FOI VACINADO
	public static boolean validaVacinado(int vacinado)
	{
		return (vacinado<0) ? true : false;
	}


	//VALIDA CPF
	public static boolean validaCpf(String CPF, RegistroPessoas listaPessoas){	

		if(CPF.isEmpty()){
			Visao.painelErro("Erro", "CPF vazio! Tente novamente.");
			return true;
		}else if(CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11)){
			Visao.painelErro("Erro", "CPF invalido! Tente novamente.");		
			return true;
		}
		else {
			try
			{	
				Integer cpf[] = new Integer[11];
				Integer primeiroDigito=0, segundoDigito = 0;
				int contador2=10;

				for(int contador = 0; contador<11; contador++)
				{
					cpf[contador] = Integer.parseInt(CPF.substring(contador, contador+1));
					if(contador<9)
						primeiroDigito+=cpf[contador]*contador2;
					contador2--;
				}

				primeiroDigito = primeiroDigito%11;
				if(primeiroDigito<2)
					primeiroDigito=0;
				else
					primeiroDigito = 11-primeiroDigito;

				//System.out.println("primeiro digito= " + primeiroDigito);

				contador2=11;
				for(int contador = 0; contador<9; contador++)
				{
					//System.out.println("cpf " + cpf[contador] + " - contador: " + contador2 + " - multiplicacao: " + cpf[contador] * contador2);
					segundoDigito = segundoDigito + cpf[contador] * contador2;
					contador2--;
				}
				segundoDigito+=primeiroDigito * contador2;
				segundoDigito = segundoDigito%11;


				if(segundoDigito<2)
					segundoDigito=0;
				else
					segundoDigito = 11-segundoDigito;

				//System.out.println("segundo digito= " + segundoDigito);

				if(primeiroDigito!=cpf[9] || segundoDigito!=cpf[10])
				{
					Visao.painelErro("Erro", "CPF inválido! Tente Novamente.");
					return true;
				}

			} catch (Exception erro)
			{
				Visao.painelErro("Erro", "Insira apenas números no CPF!");
				return true;
			}
			return false;
		}
	}

	//VALIDA QUANTIDADE DE VACINAS
	public static boolean validaQtdVacinas(String qtdVacinas){

		if(qtdVacinas.isEmpty()){
			Visao.painelErro("Erro", "Informe a quantidade de vacinas já tomadas.");
			return true;
		}
		else {
			try
			{
				Integer qtdVacinasInt = Integer.parseInt(qtdVacinas.toString());
				if(qtdVacinasInt<0)
				{
					Visao.painelErro("Erro", "Quantidade de vacinas deve ser positivo ou 0.");
					return true;
				}
			} catch (Exception erro)
			{
				Visao.painelErro("Erro", "Quantidade de vacinas inválida. Use apenas números!");
				return true;
			}
			return false;
		}
	}
}
