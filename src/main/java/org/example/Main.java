package org.example;

import org.example.model.entities.ReservationEntity;
import org.example.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            ReservationEntity reservationEntity = new ReservationEntity(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservationEntity);

            System.out.println();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservationEntity.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservationEntity);
        } catch(ParseException e) {
            System.out.println("invalid date format");
        } catch (DomainException e){
            System.out.println("Error ir reservation: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}