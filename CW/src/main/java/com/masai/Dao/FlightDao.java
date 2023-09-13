package com.masai.Dao;

import java.util.List;

import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public interface FlightDao {
	List<Flights> searchFlight(String departureCity, String arrivalCity)throws SomethingWentWrongException, NoRecordFoundException;
	
	public void addFlight(Flights flight)throws SomethingWentWrongException;
	public void UpdateFligth(Flights flight) throws SomethingWentWrongException, NoRecordFoundException;
	public void deleteFlights(Integer flightId)throws SomethingWentWrongException, NoRecordFoundException;
	
	Flights getFlight(Integer flightId)throws  SomethingWentWrongException, NoRecordFoundException;
}
