package com.masai.Service;

import java.util.List;

import com.masai.Dao.FlightDao;
import com.masai.Dao.FlightDaoImpl;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class FlightServiceImpl implements FlightService{
	FlightDao flightDao = new FlightDaoImpl();
	@Override
	public void addFlight(Flights flight) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		flightDao.addFlight(flight);
		
	}

	@Override
	public void UpdateFligth(Flights flight) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		flightDao.UpdateFligth(flight);
		
	}

	@Override
	public void deleteFlights(Integer flightId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		flightDao.deleteFlights(flightId);
	}

	@Override
	public List<Flights> searchFlight(String departureDate, String arrivalDate)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return flightDao.searchFlight(departureDate, arrivalDate);
	}

	@Override
	public Flights getFlight(Integer flightId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return flightDao.getFlight(flightId);
	}

}
