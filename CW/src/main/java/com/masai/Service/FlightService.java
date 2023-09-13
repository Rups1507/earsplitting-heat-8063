package com.masai.Service;

import java.util.List;

import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public interface FlightService {
		
	//public void addFlight(Flights flight) throws SomethingWentWrongException;
	public void addFlight(Flights flight)throws SomethingWentWrongException;
	public void UpdateFligth(Flights flight) throws SomethingWentWrongException, NoRecordFoundException;
	public void deleteFlights(Integer flightId)throws SomethingWentWrongException, NoRecordFoundException;
	List<Flights> searchFlight(String departureDate,String arrivalDate) throws  SomethingWentWrongException, NoRecordFoundException;
	Flights getFlight(Integer flightId)throws  SomethingWentWrongException, NoRecordFoundException;
	
}
