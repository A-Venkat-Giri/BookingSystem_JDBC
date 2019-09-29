package com.bbs.beans;

import java.util.Date;

public class Available {
	
	private int availId;
	private int busId;
	private int availSeats;
	private String date;
	public int getAvailId() {
		return availId;
	}
	public void setAvailId(int availId) {
		this.availId = availId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getAvailSeats() {
		return availSeats;
	}
	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Available [availId=" + availId + ", busId=" + busId + ", availSeats=" + availSeats + ", date=" + date
				+ "]";
	}
	
	

}
