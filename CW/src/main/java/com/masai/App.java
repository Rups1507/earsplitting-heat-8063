package com.masai;

import java.time.LocalDate;
import java.util.Scanner;
import com.masai.Entity.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	Scanner sc = new Scanner(System.in);
    		
    		int choice=0;
    		do {
    			System.out.println("=================================");
    			System.out.println("       Welcome To Udaan");
    			System.out.println("=================================");
    			System.out.println("1.Admin");
    			System.out.println("2.Customer");
    			System.out.println("0.Exit");
    			System.out.println("Please Enter your choice");
    			choice = sc.nextInt();
    			
    			switch(choice) {
    			case 1: admin(sc);
    					break;
    			case 2: customerLogin(sc);
						break;	
    			case 3 : customerRegistration(sc);
		 				break;    			
    			case 0: System.out.println("Thankyou for using Udaan!!");
						break;
				default : System.out.println("Invalid choice, please try again");
				 		
    			}
    			
    		}while(choice!=0);
    	
   
    	
    }
    
    public static void admin(Scanner sc) {
    	int choice =0;
		do {
			System.out.println("=================================");
			System.out.println("     Welcome To Admin section");
			System.out.println("=================================");
			System.out.println("1.Admin Login");
			System.out.println("0.Exit");
			System.out.println("Please Enter your choice");
			 choice = sc.nextInt();
			
			switch(choice) {
			case 1: adminLogin(sc);
					break;
			
			case 0: System.out.println("Thankyou for using Udaan!!");
					break;
			default : System.out.println("Invalid choice, please try again");
			 		
			}
			
		}while(choice!=0);
    }
    
    
    static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
   
    
    
    static void adminMenu(Scanner sc) {
    	int choice =0;
    	do {
    		System.out.println("1.Add Flights");
    		System.out.println("2.Update Flights");
    		System.out.println("3.Delete Flights");
    		System.out.println("4.Generate Booking Details");
    		System.out.println("5.Logout");
    		System.out.println("Enter you choice:");
    		switch(choice) {
    		
    		//add all the admin functionality
    		
    		}
    		
    	}while(choice !=0);
    }
    
    static void customerLogin(Scanner sc) {
    	
    }
    
    static void customerRegistration(Scanner sc) {
    	System.out.println("Enter name");
    	String name = sc.nextLine();
    	System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dob = LocalDate.parse(sc.next());
		
		Customer customer = new Customer(name,dob,username,password,null);
		
		// finish the service and dao layer
    }
  
}
