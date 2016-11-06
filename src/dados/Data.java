package dados;

import java.util.Date; 
import java.text.SimpleDateFormat;

public class Data {
	private Integer dia;
	private Integer mes;
	private Integer ano;

	//CONSTRUTOR
	public Data (int dia, int mes, int ano)
	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	//ACESSOR DIA
	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	//ACESSOR MES
	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	//ACESSOR ANO
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public static int descobrirIdade(int dia, int mes, int ano)
	{
		Integer diaAtual, mesAtual, anoAtual;
		Date date = new Date();
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy");

		String datas[] = mascara.format(date).split("/");
		diaAtual = Integer.parseInt(datas[0]);
		mesAtual = Integer.parseInt(datas[1]);
		anoAtual = Integer.parseInt(datas[2]);

		if(mes > mesAtual)
			return (anoAtual - ano - 1);
		else if (mes == mesAtual && dia > diaAtual)
			return (anoAtual - ano - 1);
		else
			return (anoAtual - ano);
	}

	public String toString()
	{
		return (getDia().toString() + "/" + getMes().toString() + "/" + getAno().toString());
	}

}