package com.masai.Service;

import java.util.List;

import com.masai.Dao.BookingDao;
import com.masai.Dao.BookingDaoImpl;
import com.masai.Entity.Booking;
import com.masai.Exeception.NoRecordFoundException;
import com.masai.Exeception.SomethingWentWrongException;

public class BookingServiceImpl implements BookingService {
	BookingDao bookingDao = new BookingDaoImpl();
	@Override
	public void addBooking(Booking booking) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		bookingDao.addBooking(booking);
	}


	@Override
	public List<Booking> viewAllBookings() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return bookingDao.viewAllBookings();
	}

	@Override
	public void deleteBooking(Integer bookingId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		bookingDao.deleteBooking(bookingId);
		
	}

	@Override
	public List<Booking> viewBookings(Integer customerId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return bookingDao.viewBookings(customerId);
	}

}
