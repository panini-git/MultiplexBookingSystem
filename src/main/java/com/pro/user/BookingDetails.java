package com.pro.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Bookingdetails")
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private int BookingDetailsId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Booking bookingId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SeatType SeatTypeID;
	public int getBookingDetailsId() {
		return BookingDetailsId;
	}
	public void setBookingDetailsId(int bookingDetailsId) {
		BookingDetailsId = bookingDetailsId;
	}
	public Booking getBookingId() {
		return bookingId;
	}
	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}
	public SeatType getSeatTypeID() {
		return SeatTypeID;
	}
	public void setSeatTypeID(SeatType seatTypeID) {
		SeatTypeID = seatTypeID;
	}
	public int getNoofSeats() {
		return NoofSeats;
	}
	public void setNoofSeats(int noofSeats) {
		NoofSeats = noofSeats;
	}
	private int NoofSeats;
	@Override
	public String toString() {
		return "BookingDetails [BookingDetailsId=" + BookingDetailsId + ", bookingId=" + bookingId + ", SeatTypeID="
				+ SeatTypeID + ", NoofSeats=" + NoofSeats + "]";
	}
	
	
}
