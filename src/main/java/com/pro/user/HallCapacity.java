package com.pro.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hallcapacity")
public class HallCapacity {

	@Id
	private int HallCapacityId;

	@OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name="HallId")
	private Hall hallId;

	@OneToOne(cascade = CascadeType.ALL)
	private SeatType SeatTypeId;
	private int SeatCount;

	public int getHallCapacityId() {
		return HallCapacityId;
	}

	public void setHallCapacityId(int hallCapacityId) {
		HallCapacityId = hallCapacityId;
	}

	public Hall getHallId() {
		return hallId;
	}

	public void setHallId(Hall hallId) {
		this.hallId = hallId;
	}

	public SeatType getSeatTypeId() {
		return SeatTypeId;
	}

	public void setSeatTypeId(SeatType seatTypeId) {
		SeatTypeId = seatTypeId;
	}

	public int getSeatCount() {
		return SeatCount;
	}

	public void setSeatCount(int seatCount) {
		SeatCount = seatCount;
	}

	@Override
	public String toString() {
		return "HallCapacity [HallCapacityId=" + HallCapacityId + ", hallId=" + hallId + ", SeatTypeId=" + SeatTypeId
				+ ", SeatCount=" + SeatCount + "]";
	}
}
