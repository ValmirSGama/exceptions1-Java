package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Criação de um objeto SimpleDateFormat para manipulação de datas com um formato específico.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Solicita ao usuário informações sobre a reserva
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            // Criação de um objeto Reservation com as informações fornecidas
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            // Solicita ao usuário informações para atualizar a reserva
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // Chama o método updateDates da classe Reservation para atualizar as datas da reserva.
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        // Captura exceções específicas do tipo ParseException, que ocorrem ao tentar converter String em Date.
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        // Captura exceções específicas do tipo DomainException, que representam erros específicos do domínio.
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        // Captura exceções não verificadas do tipo RuntimeException (ou subclasses).
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    
            sc.close();
    }
}

