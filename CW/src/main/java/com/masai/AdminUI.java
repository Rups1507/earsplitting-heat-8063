package com.masai;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.masai.Entity.Booking;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;
import com.masai.Service.BookingService;
import com.masai.Service.BookingServiceImpl;
import com.masai.Service.FlightService;
import com.masai.Service.FlightServiceImpl;

public class AdminUI {
	public static void adminMenu(Scanner sc) {
    	int choice =0;
    	do {
    		System.out.println("1.Add Flights");
    		System.out.println("2.Update Flights");
    		System.out.println("3.Delete Flights");
    		System.out.println("4.Generate Booking Details");
    		System.out.println("0.Logout");
    		System.out.println("Enter you choice:");
    		choice = sc.nextInt();
    		switch(choice) {
    		
    		//add all the admin functionality
    		case 1 : addFlight(sc);
    		break;
    		case 2 : updateFlight(sc);
    		break;
    		case 3: deleteFlight(sc);
    		break;
    		case 4: generateBookingDeatails(sc);
    		break;
    		case 0: System.out.println("Bye Bye Admin!");
    		break;
    		default: System.out.println("Invalid choice!");
    		
    		}
    		
    	}while(choice !=0);
    }
	
	static public void addFlight(Scanner sc)  {
		System.out.println("Enter AirLine name");
		String airlineName = sc.next();
		
		System.out.println("Enter Flight number");
		String flightNumber = sc.next();
		
		System.out.println("Enter departure city");
		String departureCity = sc.next();
		
		System.out.println("Enter arrival city");
		String arrivalCity = sc.next();
		
		System.out.println("Enter departure date (YYYY-MM-DD)");
		LocalDate departureDate = LocalDate.parse(sc.next());
		
		System.out.println("Enter arrival date (YYYY-MM-DD)");
		LocalDate arrivalDate = LocalDate.parse(sc.next());
		
		System.out.println("Enter departure time");
		LocalTime departureTime = LocalTime.parse(sc.next());
		
		System.out.println("Enter arrival time");
		LocalTime arrivalTime = LocalTime.parse(sc.next());
		
		System.out.println("Enter price");
		Double price = sc.nextDouble();
		
		Flights flight = new Flights(flightNumber, airlineName, departureCity, arrivalCity, departureDate, arrivalDate, departureTime, arrivalTime, price, null) ;
		
		FlightService fs= new FlightServiceImpl();
		
		try {
			fs.addFlight(flight);
			System.out.println("Flight added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}
	
	static public void updateFlight(Scanner sc) {
		System.out.println("Enter flight id");
		Integer flightId = sc.nextInt();
		
		System.out.println("Enter AirLine name");
		String airlineName = sc.next();
		
		System.out.println("Enter Flight number");
		String flightNumber = sc.next();
		
		System.out.println("Enter departure city");
		String departureCity = sc.next();
		
		System.out.println("Enter arrival city");
		String arrivalCity = sc.next();
		
		System.out.println("Enter departure date (YYYY-MM-DD)");
		LocalDate departureDate = LocalDate.parse(sc.next());
		
		System.out.println("Enter arrival date (YYYY-MM-DD)");
		LocalDate arrivalDate = LocalDate.parse(sc.next());
		
		System.out.println("Enter departure time");
		LocalTime departureTime = LocalTime.parse(sc.next());
		
		System.out.println("Enter arrival time");
		LocalTime arrivalTime = LocalTime.parse(sc.next());
		
		System.out.println("Enter price");
		Double price = sc.nextDouble();
		
		Flights flight = new Flights(flightNumber, airlineName, departureCity, arrivalCity, departureDate, arrivalDate, departureTime, arrivalTime, price, null);
		flight.setFlightId(flightId);
		
		FlightService fs = new FlightServiceImpl();
		try {
			fs.UpdateFligth(flight);
			System.out.println("Fligth updated successfully");
			
		}catch(SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static public void deleteFlight(Scanner sc) {
		System.out.println("Enter flight id");
		Integer flightId = sc.nextInt();
		
		FlightService fs = new FlightServiceImpl();
		
		try {
			fs.deleteFlights(flightId);
			System.out.println("Fligth updated successfully");
			
		}catch(SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static public void generateBookingDeatails(Scanner sc) {
			BookingService booking = new BookingServiceImpl();
			List<Booking> b;
			try {
				b = booking.viewAllBookings();
				
				for(Booking book : b ) {
					book.toString();
				}
			} catch (SomethingWentWrongException | NoRecordFoundException e) {
				System.out.println(e.getMessage());
			}
			
			
	}
	
}
