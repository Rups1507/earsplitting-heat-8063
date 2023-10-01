package com.masai.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(nullable = false)
	private LocalDate bookDate;
	
	@Column(nullable = false)
	private LocalTime bookTime;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flights flight;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	
	public Booking() {
		super();
	}

	public Booking(LocalDate bookDate, LocalTime bookTime, Customer customer, Flights flight,
			BookingStatus bookingStatus) {
		super();
		this.bookDate = bookDate;
		this.bookTime = bookTime;
		this.customer = customer;
		this.flight = flight;
		this.bookingStatus = bookingStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public LocalTime getBookTime() {
		return bookTime;
	}

	public void setBookTime(LocalTime bookTime) {
		this.bookTime = bookTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookDate=" + bookDate + ", bookTime=" + bookTime + ", customer="
				+ customer + ", flight=" + flight + ", bookingStatus=" + bookingStatus + "]";
	}
	
	
	
}
