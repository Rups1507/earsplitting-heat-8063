package com.masai.Service;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	

	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void changePassword(String oldPass, String newPass) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Customer> getAllCustomers() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(Integer customerId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
