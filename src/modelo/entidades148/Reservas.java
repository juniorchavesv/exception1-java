package modelo.entidades148;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservas() {
		
	}
	
	public Reservas(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {

		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}

	/*public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	} 

	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	*/
	
	// DURAÇÃO EM DIAS
	public long duracaoDias() {
		long diferencaD = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferencaD, TimeUnit.MILLISECONDS);
	}
	
	// ATUALIZA DATAS ENTRADA E SAÍDA
	public void atualizaDatas(Date dataEntrada, Date dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", data entrada: "
				+ sdf.format(dataEntrada)
				+ ", data saída: "
				+ sdf.format(dataSaida)
				+ ", "
				+ duracaoDias()
				+ " noites!";
	}
	
	
	
	
	
	
	
	
	
	

}
