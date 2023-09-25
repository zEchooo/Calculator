package movieTheater;
import java.util.Scanner;

import movie.Display;
import movie.Movie;
import movie.Person;

public class MovieTheaterTicketingSystem {
	 public static void main(String[] args) {
		 String ticketTypeRe = "yes";
	    	
	        Movie movie = new Movie("Insidious", "2023-09-25 3:00 PM", 50, 30, 20, "2:55 PM");
	        Display dsp = new Display (movie.getSeatingCapacity(),movie.getName(),movie.getEntryCutoffTime(),movie.getDateAndTime());
            
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Welcome to the Movie Theater Ticket Booking System!");
	        System.out.println(dsp.show());
	        
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        int totalPrice = 0;
	        int vipTicketCount = 0;
	        int standardTicketCount = 0;
	        int generalTicketCount = 0;
	        boolean reservationConfirmed = false;

	        while (movie.canReserveMoreTickets(null) && ticketTypeRe.equalsIgnoreCase("yes")) {
	            System.out.print("\nPrices: VIP = 8000 | Standard = 6000 | General Admission = 3000");
	            System.out.print("\nSelect Ticket Type (VIP/Standard/General Admission) or 'End' to finish: ");
	            String ticketType = scanner.nextLine();

	            if ("End".equalsIgnoreCase(ticketType)) {
	                break;
	            }

	            int availableSeats;
	            int price;
	            int maxSeatsToReserve;

	            if ("VIP".equalsIgnoreCase(ticketType)) {
	                availableSeats = movie.getVipSeats();
	                price = 8000;
	                maxSeatsToReserve = 5;
	            } else if ("Standard".equalsIgnoreCase(ticketType)) {
	                availableSeats = movie.getStandardSeats();
	                price = 6000;
	                maxSeatsToReserve = 5;
	            } else if ("General Admission".equalsIgnoreCase(ticketType)) {
	                availableSeats = movie.getGeneralSeats();
	                price = 3000;
	                maxSeatsToReserve = 5;
	            } else {
	                System.out.println("Invalid ticket type. Please choose from VIP, Standard, General Admission, or 'End'.");
	                continue;
	            }

	            System.out.println("\nAvailable Seats: " + availableSeats);

	            int quantity;
	            do {
	                System.out.print("Enter the number of seats to reserve (maximum " + maxSeatsToReserve + "): ");
	                quantity = scanner.nextInt();
	                scanner.nextLine();

	                if (quantity <= 0 || quantity > maxSeatsToReserve) {
	                    System.out.println("Invalid quantity. Please enter a valid quantity (maximum " + maxSeatsToReserve + ").");
	                }
	            } while (quantity <= 0 || quantity > maxSeatsToReserve);

	            int subtotal = price * quantity;
	            totalPrice += subtotal;

	            int reservedSeats = 0;

	            while (quantity > 0) {
	                int minSeat, maxSeat;
	                if ("VIP".equalsIgnoreCase(ticketType)) {
	                    minSeat = 1;
	                    maxSeat = movie.getVipSeats();
	                } else if ("Standard".equalsIgnoreCase(ticketType)) {
	                    minSeat = 51;
	                    maxSeat = 80;
	                } else {
	                    minSeat = 81;
	                    maxSeat = movie.getSeatingCapacity();
	                }

	                System.out.print("Enter your desired seat number (" + minSeat + "-" + maxSeat + "): ");
	                int seatNumber = scanner.nextInt();
	                scanner.nextLine();

	                if (seatNumber >= minSeat && seatNumber <= maxSeat && movie.isValidSeat(seatNumber) && !movie.isSeatOccupied(seatNumber)) {
	                    Person customer = new Person(name, seatNumber);
	                    movie.reserveSeat(seatNumber, customer);
	                    quantity--;
	                    reservedSeats++;
	                } else {
	                    System.out.println("Invalid seat number or seat is already occupied or does not match the selected ticket type. Please choose another seat.");
	                }
	            }

	            if ("VIP".equalsIgnoreCase(ticketType)) {
	                vipTicketCount += reservedSeats;
	            } else if ("Standard".equalsIgnoreCase(ticketType)) {
	                standardTicketCount += reservedSeats;
	            } else {
	                generalTicketCount += reservedSeats;
	            }

	            System.out.println("Subtotal for this ticket type: Php " + subtotal);
	            
	            if(movie.canReserveMoreTickets(null)) {
	            	System.out.println("\nWould you like to select another type of ticket? ( yes / no )");
		            ticketTypeRe = scanner.nextLine();
	            }
	            
	        }

	        System.out.print("\nPrices: VIP = 8000 | Standard = 6000 | General Admission = 3000");
	        System.out.println("\nTotal Price: Php " + totalPrice);
	        System.out.println("VIP Tickets: " + vipTicketCount);
	        System.out.println("Standard Tickets: " + standardTicketCount);
	        System.out.println("General Admission Tickets: " + generalTicketCount);

	        System.out.print("Are these information correct? (Confirm/Decline): ");
	        String confirmation;
	        
	        while (true) {
	            confirmation = scanner.nextLine();
	            if ("Confirm".equalsIgnoreCase(confirmation) || "Decline".equalsIgnoreCase(confirmation)) {
	                break;
	            } else {
	                System.out.print("Invalid input. Please enter 'Confirm' or 'Decline': ");
	            }
	        }

	        if ("Confirm".equalsIgnoreCase(confirmation)) {
	        	
	        	
	        	System.out.println("\nThank you for your reservation! Take note of the Entry Cutoff Time so you will not miss the show.");
	            System.out.println("Here is the information we received:");
	            
	            System.out.println(dsp.show()); 
	     
	            System.out.println("| \tTotal Price: Php " + totalPrice);
	            reservationConfirmed = true;
	        } else {
	            System.out.println("Reservation declined. Please make another transaction.");
	        }

	        if (reservationConfirmed) {
	            //movie.displayOccupancy();
	        }

	        scanner.close();
	    }
}
