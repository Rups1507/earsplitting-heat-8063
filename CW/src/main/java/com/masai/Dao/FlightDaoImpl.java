package com.masai.Dao;

import java.util.List;


import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;
import com.masai.Util.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class FlightDaoImpl implements FlightDao {
	@Override
	public List<Flights> searchFlight(String departureCity, String arrivalCity)
			throws SomethingWentWrongException, NoRecordFoundException {
		 EntityManager entityManager = EMUtils.getEntityManager();
	        try {
	            TypedQuery<Flights> query = entityManager.createQuery("SELECT f FROM Flight f WHERE f.departureCity = :departureCity AND f.arrivalCity = :arrivalCity", Flights.class);
	            query.setParameter("departureCity", departureCity);
	            query.setParameter("arrivalCity", arrivalCity);
	            return query.getResultList();
	        } catch (Exception e) {
	            throw new SomethingWentWrongException("Error fetching flights ");
	        } finally {
	            entityManager.close();
	        }
	}

	@Override
	public void addFlight(Flights flight) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager entityManager = EMUtils.getEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	    try {
	        transaction.begin();
	        entityManager.persist(flight);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw new SomethingWentWrongException("Flights cannot be added: " + e.getMessage());
	    } finally {
	        entityManager.close();
	    }
		
	}

	@Override
	public void UpdateFligth(Flights flight) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager entityManager =EMUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new SomethingWentWrongException("Flight Cannot Be Updated: " + e.getMessage());
        } finally {
            entityManager.close();
        }
		
		
	}

	@Override
	public void deleteFlights(Integer flightId) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager entityManager = EMUtils.getEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	    try {
	        transaction.begin();
	        Flights flight = entityManager.find(Flights.class, flightId);
	        if (flight != null) {
	            entityManager.remove(flight);
	        } else {
	            throw new NoRecordFoundException("Flight is not availabe with FlightId: " + flightId );
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
	public Flights getFlight(Integer flightId) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		Flights flight = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT f FROM Flights f");
			flight = (Flights) query.getSingleResult();
			if(flight == null)
				throw new NoRecordFoundException("No Customer Found");
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return flight;
	}
}
