package com.masai.Service;

import java.util.List;

import com.masai.Entity.Booking;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public interface BookingService {
		void addBooking(Booking booking)throws SomethingWentWrongException;
		void deleteBooking(Integer bookingId)throws SomethingWentWrongException, NoRecordFoundException;;
		List<Booking> viewBookings(Integer customerId)throws SomethingWentWrongException, NoRecordFoundException;
		List<Booking> viewAllBookings()throws SomethingWentWrongException, NoRecordFoundException;;
}
