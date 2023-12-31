package com.masai.Entity;

import java.time.LocalDate;
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
@Table(name ="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private int customerId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "date_of_birth",nullable = false)
	private LocalDate dob;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "customer" , cascade =  CascadeType.ALL)
	private List<Booking> booking;
	
	

	public Customer() {
		super();
	}

	public Customer(String name, LocalDate dob,String username, String password, List<Booking> booking) {
		super();
		this.name = name;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.booking = booking;
	}
	
	

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", dob=" + dob + ", username=" + username
				+ ", password=" + password + ", booking=" + booking + "]";
	}
	
	
}
