package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import dados.RegistroPessoas;

public class JanelaConsultar implements ActionListener {

	private JFrame janela;
	private JLabel lblcpf = new JLabel("CPF:");
	private JTextField txtcpf = new JTextField();
	private JButton consultar = new JButton("Consultar");
	private JButton voltar = new JButton("Voltar");

	public JanelaConsultar() {
		janela = new JFrame();
	}

	public void montaJanelaConsultar(RegistroPessoas listaPessoas)
	{
		montaFrame();
		montaCPF();
		montaConsultar(listaPessoas);
		montaVoltar();
	}

	private void montaFrame()
	{
		janela.setTitle("Consultar");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(400,150);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		//janela.setBounds(100, 100, 400, 200);
		janela.getContentPane().setLayout(null);
	}

	private void montaCPF()
	{
		lblcpf.setBounds(12, 26, 70, 15);
		janela.getContentPane().add(lblcpf);

		txtcpf.setBounds(68, 24, 114, 19);
		janela.getContentPane().add(txtcpf);
		txtcpf.setColumns(10);
	}

	private void montaConsultar(final RegistroPessoas listaPessoas)
	{
		consultar.setBounds(50, 75, 125, 25);
		janela.getContentPane().add(consultar);
		consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaPessoas.consultarCadastros(txtcpf.getText());
			}
		});

	}

	private void montaVoltar()
	{
		voltar.setBounds(250, 75, 125, 25);
		janela.getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
			}
		});
	}

	public void actionPerformed(ActionEvent arg0) {}
}
