package com.pro.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hall")
public class Hall {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private int HallId;
	private String HallDesc;
	private int TotalCapacity;
	public int getHallId() {
		return HallId;
	}
	public void setHallId(int hallId) {
		HallId = hallId;
	}
	public String getHallDesc() {
		return HallDesc;
	}
	public void setHallDesc(String hallDesc) {
		HallDesc = hallDesc;
	}
	public int getTotalCapacity() {
		return TotalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		TotalCapacity = totalCapacity;
	}
	@Override
	public String toString() {
		return "Hall [HallId=" + HallId + ", HallDesc=" + HallDesc + ", TotalCapacity=" + TotalCapacity + "]";
	}
}
