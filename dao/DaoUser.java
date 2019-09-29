package com.bbs.dao;


import java.sql.Date;
import java.util.List;

import com.bbs.beans.Bus;
import com.bbs.beans.Feedback;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;

public interface DaoUser {
	public User createUser(User user);
	public Boolean updateUser(User user,String password);
	public Boolean deleteUser(int userId,String password);
	public Boolean loginUser(int userId,String password);
	public User searchUser(int userId);
	
	public List<Bus> searchBus(String source,String destination , Date date);
	
	
	
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(int bookingId);
	public Ticket getTicket(int bookingId);
	public List<Ticket> getAllTickets(int userId);
	public Integer checkAvailability(int bus_id,Date date);
	public Boolean giveFeedBack(Feedback feedback);

}
