package com.masai;

import java.time.LocalDate;
import java.util.Scanner;
import com.masai.Entity.*;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;
import com.masai.Service.CustomerService;
import com.masai.Service.CustomerServiceImpl;
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
    			System.out.println("1.Admin Login");
    			System.out.println("2.Customer Login");
    			System.out.println("3.Customer Registration");
    			System.out.println("0.Exit");
    			System.out.println("Please Enter your choice");
    			choice = sc.nextInt();
    			
    			switch(choice) {
    			case 1: adminLogin(sc);
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
    
//    public static void admin(Scanner sc) {
//    	int choice =0;
//		do {
//			System.out.println("=================================");
//			System.out.println("     Welcome To Admin section");
//			System.out.println("=================================");
//			System.out.println("1.Admin Login");
//			System.out.println("0.Exit");
//			System.out.println("Please Enter your choice");
//			 choice = sc.nextInt();
//			
//			switch(choice) {
//			case 1: adminLogin(sc);
//					break;
//			
//			case 0: System.out.println("Thankyou for using Udaan!!");
//					break;
//			default : System.out.println("Invalid choice, please try again");
//			 		
//			}
//			
//		}while(choice!=0);
//    }
    
    
    
    static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			AdminUI.adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
   
    
    
    
    
    static void customerLogin(Scanner sc) {
    	System.out.println("Enter username");
    	String username = sc.next();
    	System.out.println("Enter Password");
    	String password = sc.next();
    	
    	try {
    		CustomerService cs = new CustomerServiceImpl();
    		cs.login(username, password);
    		System.out.println("Login successful");
    		CustomerUI.customerMenu(sc);
    	}catch(NoRecordFoundException | SomethingWentWrongException e) {
    		System.out.println(e.getMessage());
    	} 
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
		
		try {
			CustomerService cs = new CustomerServiceImpl();
			cs.addCustomer(customer);
			System.out.println("Customer added successfully");
		}catch(SomethingWentWrongException e){
			System.out.println(e.getMessage());
		}
		
    }
  
}
