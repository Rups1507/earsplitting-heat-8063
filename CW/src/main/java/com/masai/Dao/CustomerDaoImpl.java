package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flights> searchFlight(String departureCity, String arrivalCity)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
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

}
