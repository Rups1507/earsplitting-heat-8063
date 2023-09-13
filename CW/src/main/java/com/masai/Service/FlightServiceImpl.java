package com.masai.Service;

import java.util.List;

import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class FlightServiceImpl implements FlightService{

	@Override
	public void addFlight(Flights flight) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateFligth(Flights flight) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFlights(Integer flightId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flights> searchFlight(String departureDate, String arrivalDate)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flights getFlight(Integer flightId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
