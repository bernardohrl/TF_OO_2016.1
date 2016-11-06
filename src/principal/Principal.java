/*Síntese:
 * Objetivo: Cadastrar usuários e apresentar dados sobre tais.
 * Entrada:  Nome, Sexo, Cpf, Data de Nascimento, se foi vaciado ou quantas vezes foi vacinado.
 * Saída:    Lista de usuários cadastrados, Usuário cadastrado selecionado pelo CPF, Lista de usuários selecionados pelo nome.
 * 
*/
package principal;

import visao.JanelaInstrucoes;

public class Principal{
	public static void main(String[] args) {
		JanelaInstrucoes janelaInstrucoes = new JanelaInstrucoes();
		janelaInstrucoes.montarJanelaIntrucoes();
	}
}
