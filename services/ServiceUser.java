package com.bbs.services;


import java.sql.Date;
import java.util.List;

import com.bbs.beans.Bus;
import com.bbs.beans.Feedback;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;

public interface ServiceUser {
	public User createUser(User user);
	public Boolean updateUser(User user,String password);
	public Boolean deleteUser(int userId,String password);
	public Boolean loginUser(int userId,String password);
	public User searchUser(int userId);
	public List<Bus> searchBus(String source,String destination , Date date);
	public Boolean giveFeedBack(Feedback feedback);
	
	public List<Ticket> getAllTickets(int userId);
	
	
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(int bookingId);
	public Ticket getTicket(int bookingId);
	public Integer checkAvailability(int busId,Date date);
	
	public String checkUserIdAndBookinIdAndBusId(String number);
	public String checkContact (String contact);
	public String checkEmail (String email);

}
