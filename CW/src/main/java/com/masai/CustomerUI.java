package com.masai;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.masai.Entity.Booking;
import com.masai.Entity.BookingStatus;
import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;
import com.masai.Service.BookingService;
import com.masai.Service.BookingServiceImpl;
import com.masai.Service.CustomerService;
import com.masai.Service.CustomerServiceImpl;
import com.masai.Service.FlightService;
import com.masai.Service.FlightServiceImpl;



public class CustomerUI {
	public static void customerMenu(Scanner sc) {
		int choice =0;
    	do {
    		System.out.println("1.View Flights");
    		System.out.println("2.Book Flights");
    		System.out.println("3.Delete Booking");
    		System.out.println("4.Generate Booking Details");
    		System.out.println("5.Change Password");
    		System.out.println("6.Delete Profile");
    		System.out.println("0.Logout");
    		System.out.println("Enter you choice:");
    		choice = sc.nextInt();
    		switch(choice) {
    		case 1: viewFlights(sc);
    				break;
    		case 2: bookFlight(sc);
    				break;
    		case 3: deleteBooking(sc);
    				break;
    		case 4: generateBookingDetails(sc);
    				break;
    		case 5: changePassword(sc);
    				break;
    		case 6: deleteProfile(sc);
		    		System.out.println("Logging you out");
					choice = 0;
    				break;
    		case 0: System.out.println("Logged out!!");
    		 		break;
    		default : System.out.println("Invalid choice!!");
    		
    		}
    		
    	}while(choice !=0);
    }
	
	static void viewFlights(Scanner sc){
		System.out.println("Enter Departure city:");
		String departure = sc.next();
		System.out.println("Enter Arrival city:");
		String arrival = sc.next();
		try {
			FlightService fs = new FlightServiceImpl();
			List<Flights> list = fs.searchFlight(departure, arrival);
			for(Flights flight : list) {
				flight.toString();				//==========================
			}
		}catch(NoRecordFoundException | SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void bookFlight(Scanner sc) {
		System.out.println("Enter Flight Id:");
		int flightId = sc.nextInt();
		System.out.println("Enter Customer ID:");
		int customerId = sc.nextInt();
		
		CustomerService cs =  new CustomerServiceImpl();
		FlightService fs = new FlightServiceImpl();
		
		Customer c = null;
		Flights f = null;
		try {
			 c =cs.getCustomer(customerId);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			 f = fs.getFlight(flightId);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
		Booking b = new Booking(LocalDate.now(), LocalTime.now(),c, f, BookingStatus.CONFIRMED);
		
		BookingService bs = new BookingServiceImpl();
		
		try {
			bs.addBooking(b);
			System.out.println("Booking successful");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void deleteBooking(Scanner sc) {
		System.out.println("Enter Booking id");
		Integer bookingId = sc.nextInt();
		
		BookingService bs = new BookingServiceImpl();
		try {
			bs.deleteBooking(bookingId);
			System.out.println("Booking deleted");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void generateBookingDetails(Scanner sc) {
		System.out.println("Enter Customer id");
		Integer customerId = sc.nextInt();
		
		
		BookingService bs = new BookingServiceImpl();
		try {
			List<Booking> li =bs.viewBookings(customerId);
			System.out.println("Booking details:");
			for(Booking book : li) {
				book.toString();
			}
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void changePassword(Scanner sc) {
		System.out.print("Enter old password ");
		String oldPassword = sc.next();
		System.out.print("Enter new password ");
		String newPassword = sc.next();
		System.out.print("Re-Enter new password ");
		String reEnterNewPassword = sc.next();
		
		//Check if new password is correct
		if(!newPassword.equals(reEnterNewPassword)) {
			System.out.println("New password and Re-Entered password mismtached");
			return;
		}else if(newPassword.equals(oldPassword)) {
			System.out.println("New password and old password must be different");
			return;
		}
		
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.changePassword(oldPassword, reEnterNewPassword);
			System.out.println("Password updated");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void deleteProfile(Scanner sc) {
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				CustomerService customerService = new CustomerServiceImpl();
				customerService.deleteCustomer();
				System.out.println("Its really sad to see you go, As per your request account is deleted");			
			}catch(SomethingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
}
