package controller;

import java.util.Scanner;
import model.Reservation;
import service.HotelService;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelService hotelService = new HotelService();

        while (true) {
            System.out.println("\n===== Welcome to Grand Hotel =====");
            System.out.println("1. Reserve Room");
            System.out.println("2. Check Reservation by ID");
            System.out.println("3. Check Reservation by Name");
            System.out.println("4. Check Reservation by Room Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    // Reserve Room
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter room number: ");
                    int room = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter contact number: ");
                    String contact = sc.nextLine();

                    Reservation reservation = new Reservation(room, name, contact);

                    boolean isBooked = hotelService.reserveRoom(reservation);

                    if (isBooked) {
                        System.out.println("Room booked successfully!");
                    } else {
                        System.out.println("Booking failed. Try again.");
                    }
                    break;

                case 2:
                    // Check Reservation by ID
                    System.out.print("Enter reservation ID: ");
                    int reservationId = sc.nextInt();
                    sc.nextLine();

                    Reservation res = hotelService.checkReservationById(reservationId);

                    if (res != null) {
                        System.out.println("\nReservation Found:");
                        System.out.println("ID: " + res.getId());
                        System.out.println("Room: " + res.getRoomNumber());
                        System.out.println("Guest: " + res.getGuestName());
                        System.out.println("Contact: " + res.getContactNumber());
                        System.out.println("Date: " + res.getReservationDate());
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter Reservation name : ");
                    String reservationName = sc.nextLine();

                    Reservation reservationByName = hotelService.checkReservationByName(reservationName);

                    if (reservationByName != null) {
                        System.out.println("\nReservation Found:");
                        System.out.println("ID: " + reservationByName.getId());
                        System.out.println("Room: " + reservationByName.getRoomNumber());
                        System.out.println("Guest: " + reservationByName.getGuestName());
                        System.out.println("Contact: " + reservationByName.getContactNumber());
                        System.out.println("Date: " + reservationByName.getReservationDate());
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;
                

                case 4:
                    // Check Reservation by ID
                    System.out.print("Enter room number: ");
                    int reservationRoomNumber = sc.nextInt();
                    sc.nextLine();

                    Reservation reservationRoom = hotelService.checkReservationByRoomNumber(reservationRoomNumber);

                    if (reservationRoom != null) {
                        System.out.println("\nReservation Found:");
                        System.out.println("ID: " + reservationRoom.getId());
                        System.out.println("Room: " + reservationRoom.getRoomNumber());
                        System.out.println("Guest: " + reservationRoom.getGuestName());
                        System.out.println("Contact: " + reservationRoom.getContactNumber());
                        System.out.println("Date: " + reservationRoom.getReservationDate());
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;

                    
                
                case 5:
                    System.out.println("Thank you for using Grand Hotel System!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}