package com.masai.Service;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class BookingServiceImpl implements BookingService {

	@Override
	public void addBooking(Booking booking) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Booking> viewAllBookings() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(Integer bookingId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Booking> viewBookings(Integer customerId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
