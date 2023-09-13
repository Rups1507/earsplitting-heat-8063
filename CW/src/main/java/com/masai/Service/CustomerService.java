package com.masai.Service;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public interface CustomerService {
	
		void addBooking(Booking booking) throws SomethingWentWrongException;
		void addCustomer(Customer customer) throws SomethingWentWrongException;
		void login(String username, String password)throws SomethingWentWrongException, NoRecordFoundException;
		
	//	void updateCustomer(int customerid)throws SomethingWentWrongException,NoRecordFoundException;
		void changePassword(String oldPass, String newPass)throws SomethingWentWrongException;
		void deleteCustomer() throws SomethingWentWrongException;
		
		List<Customer> getAllCustomers()throws SomethingWentWrongException,NoRecordFoundException;
		
		Customer getCustomer(Integer customerId)throws SomethingWentWrongException,NoRecordFoundException;
}
