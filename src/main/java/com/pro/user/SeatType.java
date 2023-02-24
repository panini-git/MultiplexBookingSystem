package com.pro.user;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Seattype")
public class SeatType {

	@Id
//@GeneratedValue(strategy = GenerationType.Auto)  
	private int SeatTypeId;
	private String SeatTypeDesc;
	private double SeatFare;

	public int getSeatTypeId() {
		return SeatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		SeatTypeId = seatTypeId;
	}

	public String getSeatTypeDesc() {
		return SeatTypeDesc;
	}

	public void setSeatTypeDesc(String seatTypeDesc) {
		SeatTypeDesc = seatTypeDesc;
	}

	public double getSeatFare() {
		return SeatFare;
	}

	public void setSeatFare(double seatFare) {
		SeatFare = seatFare;
	}

	@Override
	public String toString() {
		return "SeatType [SeatTypeId=" + SeatTypeId + ", SeatTypeDesc=" + SeatTypeDesc + ", SeatFare=" + SeatFare + "]";
	}

}