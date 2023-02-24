package com.pro.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private int BookinId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shows ShowId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User UserId;
	
	private String BookedDate;
	private String ShowDate;
	public int getBookinId() {
		return BookinId;
	}
	public void setBookinId(int bookinId) {
		BookinId = bookinId;
	}
	public Shows getShowId() {
		return ShowId;
	}
	public void setShowId(Shows showId) {
		ShowId = showId;
	}
	public User getUserId() {
		return UserId;
	}
	public void setUserId(User userId) {
		UserId = userId;
	}
	public String getBookedDate() {
		return BookedDate;
	}
	public void setBookedDate(String bookedDate) {
		BookedDate = bookedDate;
	}
	public String getShowDate() {
		return ShowDate;
	}
	public void setShowDate(String showDate) {
		ShowDate = showDate;
	}
	@Override
	public String toString() {
		return "Booking [BookinId=" + BookinId + ", ShowId=" + ShowId + ", UserId=" + UserId + ", BookedDate="
				+ BookedDate + ", ShowDate=" + ShowDate + "]";
	}
	
	
	
}
