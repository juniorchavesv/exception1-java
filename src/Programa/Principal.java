package Programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;


public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Data de saída (dd/MM/yyyy): ");
		Date datasaida = sdf.parse(sc.next());
		
		// VERIFICA SE DATA SAÍDA É POSTERIOR DATA ENTRADA
		if (!datasaida.after(dataEntrada)) {
			System.out.println("Erro na reserva, a data de saída deve ser posterior a data de entrada!");
		}
		else {
			//INSTANCIANDO A RESERVA
			Reservas reservas = new Reservas(numeroQuarto, dataEntrada, datasaida);
			System.out.println("Reserva: " + reservas);
			
			System.out.println();
			
			// ATUALIZANDO A DATA DE RESERVA
			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyyy): ");
			datasaida = sdf.parse(sc.next());
			
			// CRIA UMA DATA ATUAL PARA VERIFICA SE A DATA FUTURA FOI LANÇADA ANTES DO DIA ATUAL
			Date dataAgora = new Date();
			if (dataEntrada.before(dataAgora) || datasaida.before(dataAgora)) {
				System.out.println("Erro na reserva: a data para atualização não deve ser anterior a data atual!");
			}
			else if (!datasaida.after(dataEntrada)) {
				System.out.println("Erro na reserva, a data de saída deve ser posterior a data de entrada!");
			}
			else {
				
				// MÉTODO QUE ATUALIZA AS DATAS
				reservas.atualizaDatas(dataEntrada, datasaida);
				System.out.println("Data atualizada da reserva: " + reservas);
					
			}
			
			
			
		}

	}

}
