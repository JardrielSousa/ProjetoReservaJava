/**
 * 
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

/**
 * @author Jardriel Sousa
 * Sistema de reserva 
 * Método Principal
 */
public class Program {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Digite o número do quarto :");
		int number = sc.nextInt();
		
		System.out.println("Data do CheckIn : (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next()); 
		
		System.out.println("Data do CheckOut : (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na Reserva : Data de checkIn não pode ser menor que a de checkOut");
		}else {
			Reserva reserva = new Reserva(number,checkIn,checkOut);
			System.out.println("Reserva" + reserva);
			
			System.out.println();
			
			System.out.println("Precione Enter para Alterar a reserva");
			
			System.out.println("Data do CheckIn : (dd/mm/yyyy)");
			checkIn = sdf.parse(sc.next()); 
			
			System.out.println("Data do CheckOut : (dd/mm/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now) ) {
				System.out.println("Erro na Reserva : Preencha com datas futuras");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na Reserva : Data de checkIn não pode ser menor que a de checkOut");
			}else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println("Reserva" + reserva);
				
			}
			
			
		}
		
		sc.close();
	}

}
