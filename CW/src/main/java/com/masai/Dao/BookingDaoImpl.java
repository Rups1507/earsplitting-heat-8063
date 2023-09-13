package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Customer;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;
import com.masai.Util.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class BookingDaoImpl implements BookingDao {

	@Override
	public void addBooking(Booking booking) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager entityManager = EMUtils.getEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	    try {
	        transaction.begin();
	        entityManager.persist(booking);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw new SomethingWentWrongException("Booking cannot be added: " + e.getMessage());
	    } finally {
	        entityManager.close();
	    }
		
	}

	@Override
	public void deleteBooking(Integer bookingId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = EMUtils.getEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	    try {
	        transaction.begin();
	        Flights booking = entityManager.find(Flights.class, bookingId);
	        if (booking != null) {
	            entityManager.remove(booking);
	        } else {
	            throw new NoRecordFoundException("Booking is not availabe with bookingId: " + bookingId );
	        }
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw new SomethingWentWrongException("Flight cannot be deleted: " + e.getMessage());
	    } finally {
	        entityManager.close();
	    }
		
	}

	@Override
	public List<Booking> viewBookings(Integer customerId) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Booking> bookingList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT b FROM Booking b WHERE b.customerId = :customerId");
			query.setParameter("customerId", customerId);
			bookingList = query.getResultList();
			if(bookingList.size() == 0)
				throw new NoRecordFoundException("No Customer Found");
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return bookingList;
	}

	@Override
	public List<Booking> viewAllBookings() throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Booking> bookingList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT b FROM Booking b");
			bookingList = query.getResultList();
			if(bookingList.size() == 0)
				throw new NoRecordFoundException("No Customer Found");
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return bookingList;
	}

}
