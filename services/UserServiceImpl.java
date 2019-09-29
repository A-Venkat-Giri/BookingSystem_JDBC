package com.bbs.services;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bbs.beans.Bus;
import com.bbs.beans.Feedback;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;
import com.bbs.dao.DaoUser;
import com.bbs.dao.DaoUserImpl;
import com.bbs.exceptions.CustomException;

public class UserServiceImpl implements ServiceUser {
	DaoUser dao=new DaoUserImpl();

	@Override
	public User createUser(User user) {
		return dao.createUser(user);
	}

	@Override
	public Boolean updateUser(User user, String password) {
		return dao.updateUser(user, password);
	}

	@Override
	public Boolean deleteUser(int userId, String password) {
		return dao.deleteUser(userId, password);
	}

	@Override
	public Boolean loginUser(int userId, String password) {
		return dao.loginUser(userId, password);
	}

	@Override
	public User searchUser(int userId) {
		return dao.searchUser(userId);
	}


	@Override
	public Ticket bookTicket(Ticket ticket) {
		return dao.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(int bookingId) {
		return dao.cancelTicket(bookingId);
	}

	@Override
	public Ticket getTicket(int bookingId) {
		return dao.getTicket(bookingId);
	}

	@Override
	public Integer checkAvailability(int busId, Date date) {
		return dao.checkAvailability(busId, date);
	}

	@Override
	public List<Bus> searchBus(String source, String destination, Date date) {
		return dao.searchBus(source, destination, date);
	}

	@Override
	public String checkUserIdAndBookinIdAndBusId(String number) {
		Pattern pat = Pattern.compile("\\d+");       // represents any number
		Matcher mat = pat.matcher(number);
		 if(mat.matches())
		 {
			 return number;
		 }
		 else
		 {
			 return null;
		 }
	}

	@Override
	public String checkContact(String contact) {
      Pattern pat = Pattern.compile("\\d{10,10}");
      Matcher mat =  pat.matcher(contact);
      if(mat.matches())
      {
    	  return contact;
      }
      else
      {
    	  throw new CustomException("ContactInputException:ProvideProperContact");
      }
   
	}

	@Override
	public String checkEmail(String email)
	{
		Pattern pattern=Pattern.compile("\\w+@\\w+.\\w+");
		Matcher matcher=pattern.matcher(email);
		if(matcher.matches())
		{
			return email;
		}
		else
		{
			throw new CustomException("EmailException:ProvideProperEmail");
		}
	}

	@Override
	public Boolean giveFeedBack(Feedback feedback) {
		
		return dao.giveFeedBack(feedback);
	}

	@Override
	public List<Ticket> getAllTickets(int userId) {
		return dao.getAllTickets(userId);
	}
	

}
