package com.masai.Service;

import java.util.List;

import com.masai.Dao.CustomerDao;
import com.masai.Dao.CustomerDaoImpl;
import com.masai.Entity.Booking;
import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class CustomerServiceImpl implements CustomerService {
	 CustomerDao customerDao = new CustomerDaoImpl();
	


	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
		
	}

	@Override
	public Customer login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		return customerDao.login(username, password);
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void changePassword(String oldPass, String newPass) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		customerDao.changePassword(oldPass, newPass);
		
	}

	@Override
	public void deleteCustomer() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer();
		
	}


	@Override
	public List<Customer> getAllCustomers() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomer(Integer customerId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(customerId);
	}

}
