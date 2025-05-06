package Aula150_Programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades150.Reservas;
import modelo.exceptions150.DominioException;


public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyyy): ");
			Date datasaida = sdf.parse(sc.next());
			
			
		
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
			// MÉTODO QUE ATUALIZA AS DATAS
			reservas.atualizaDatas(dataEntrada, datasaida);
			System.out.println("Data atualizada da reserva: " + reservas);
		}
		
		catch (ParseException e) {
			System.out.println("Formato de data inválida.");
		}
		
		catch (DominioException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		
		
		sc.close();
	}
}
