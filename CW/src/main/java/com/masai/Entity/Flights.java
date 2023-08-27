package com.masai.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flights {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	@Column(nullable = false , unique = true)
	private String flightNumber;
	@Column(nullable = false)
	private String airlineName;
	@Column(nullable = false)
	private String departureCity;
	@Column(nullable = false)
	private String arrivalCity;
	@Column(nullable = false)
	private LocalDate departureDate;
	@Column(nullable = false)
	private LocalDate arrivalDate;
	@Column(nullable = false)
	private LocalTime departureTime;
	@Column(nullable = false)
	private LocalTime arrivalTime;
	@Column(nullable = false)
	private double price;
	
	@OneToMany(mappedBy = "flights" , cascade = CascadeType.ALL)
	private List<Booking> booking;

	public Flights(String flightNumber, String airlineName, String departureCity, String arrivalCity,
			LocalDate departureDate, LocalDate arrivalDate, LocalTime departureTime, LocalTime arrivalTime,
			double price, List<Booking> booking) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.booking = booking;
	}

	public Flights() {
		super();
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", flightNumber=" + flightNumber + ", airlineName=" + airlineName
				+ ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", price=" + price + ", booking=" + booking + "]";
	}
	
	
}
