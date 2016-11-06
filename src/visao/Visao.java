package visao;

import javax.swing.JOptionPane;

public class Visao {
	public static void painelErro(String titulo, String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static void painel(String titulo, String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public static void pulaLinha(int linhas)
	{
		for(int i=0; i<linhas; i++)
			System.out.println();
	}
}
