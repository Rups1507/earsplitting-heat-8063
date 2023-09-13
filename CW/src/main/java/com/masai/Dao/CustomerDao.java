package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public interface CustomerDao {
		void addCustomer(Customer customer) throws SomethingWentWrongException;
		Customer login(String username,String password) throws SomethingWentWrongException,NoRecordFoundException;
		
		void changePassword(String oldPass, String newPass)throws SomethingWentWrongException;
		void deleteCustomer() throws SomethingWentWrongException;
		List<Customer> getAllCustomers()throws SomethingWentWrongException,NoRecordFoundException;
		Customer getCustomer(Integer customerId)throws SomethingWentWrongException,NoRecordFoundException;
		
		
		
}
