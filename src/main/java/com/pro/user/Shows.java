package com.pro.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Show")
public class Shows {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ShowId;

	@OneToOne(cascade = CascadeType.ALL)
	private Hall HallId;

	@OneToOne(cascade = CascadeType.ALL)
	private Movies MovieId;

	private int SlotNo;
	private String FromDate;
	private String ToDate;

	public int getShowId() {
		return ShowId;
	}

	public void setShowId(int showId) {
		ShowId = showId;
	}

	public Hall getHallId() {
		return HallId;
	}

	public void setHallId(Hall hallId) {
		HallId = hallId;
	}

	public Movies getMovieId() {
		return MovieId;
	}

	public void setMovieId(Movies movieId) {
		MovieId = movieId;
	}

	public int getSlotNo() {
		return SlotNo;
	}

	public void setSlotNo(int slotNo) {
		SlotNo = slotNo;
	}

	public String getFromDate() {
		return FromDate;
	}

	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}

	public String getToDate() {
		return ToDate;
	}

	public void setToDate(String toDate) {
		ToDate = toDate;
	}

	@Override
	public String toString() {
		return "Shows [ShowId=" + ShowId + ", HallId=" + HallId + ", MovieId=" + MovieId + ", SlotNo=" + SlotNo
				+ ", FromDate=" + FromDate + ", ToDate=" + ToDate + "]";
	}

}
