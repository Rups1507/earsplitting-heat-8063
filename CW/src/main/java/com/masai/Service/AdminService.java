package com.masai.Service;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Entity.Flights;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public interface AdminService {
	void addFlights(Flights flights) throws SomethingWentWrongException;
	void updateFlights(Flights flight) throws SomethingWentWrongException , NoRecordFoundException;
	void deleteFlights(Flights flight) throws SomethingWentWrongException , NoRecordFoundException;
	List<Booking> getBooking() throws SomethingWentWrongException , NoRecordFoundException;
	
}
