package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;
import com.masai.Util.EMUtils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if customer with same username exists
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE username = :username");
			query.setParameter("username", customer.getUsername());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("The username" + customer.getUsername() + " is already occupied");
			}
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	@Override
	public Customer login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = EMUtils.getEntityManager();
		try {
			TypedQuery<Customer> query = em.createQuery("SELECT c FROM customers c WHERE c.username = :username AND c.password = :password", Customer.class);
			query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
            
		}
//		catch(SomethingWentWrongException | NoRecordFoundException ex) {
//			System.out.println(ex.getMessage());
//		}
		//Catch Block is missing some errors is there
		finally {
			em.close();
		}
		
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void changePassword(String oldPass, String newPass) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
//		EntityManager em = null;
//		try {
//			em = EMUtils.getEntityManager();
//			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE password = :oldPassword AND id = :id");
//			query.setParameter("oldPassword", oldPass);
//			query.setParameter("id", LoggedInUserId.loggedInUserId);
//			Long userCount = (Long)query.getSingleResult();
//			if(userCount == 0) {
//				//you are here old password is incorrect for logged in user
//				throw new SomethingWentWrongException("Invalid old password");
//			}
//			//You are here means all checks done, We can proceed for changing the password
//			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
//			EntityTransaction et = em.getTransaction();
//			et.begin();
//			customer.setPassword(newPassword);
//			et.commit();
//		}catch(PersistenceException ex) {
//			throw new SomethingWentWrongException("Unable to process request, try again later");
//		}finally{
//			em.close();
//		}
	}

	@Override
	public void deleteCustomer() throws SomethingWentWrongException {
//		EntityManager em = null;
//		try {
//			em = EMUtils.getEntityManager();
//			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
//			EntityTransaction et = em.getTransaction();
//			et.begin();
//			customer.setIsDeleted(1);
//			et.commit();
//		}catch(PersistenceException ex) {
//			throw new SomethingWentWrongException("Unable to process request, try again later");
//		}finally{
//			em.close();
//		}
//		
	}

	@Override
	public List<Customer> getAllCustomers() throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Customer> customerList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT c.customerId, c.name, c.username, c.date_of_birth  FROM Customer c");
			customerList = query.getResultList();
			if(customerList.size() == 0)
				throw new NoRecordFoundException("No Customer Found");
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return customerList;
	}

	@Override
	public Customer getCustomer(Integer customerId) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		Customer customer = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT c.customerId, c.name, c.username, c.date_of_birth  FROM Customer c");
			customer = (Customer) query.getSingleResult();
			if(customer == null)
				throw new NoRecordFoundException("No Customer Found");
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return customer;
	}

	

}
