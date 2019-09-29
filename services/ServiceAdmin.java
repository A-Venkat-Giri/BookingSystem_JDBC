package com.bbs.services;

import java.util.HashMap;
import java.util.List;

import com.bbs.beans.Available;
import com.bbs.beans.Bus;
import com.bbs.beans.Feedback;

public interface ServiceAdmin {
	public Boolean createBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Bus searchBus(int busId);
	public Boolean deletebus(int busId,String password);
	public HashMap<Integer, Bus> busBetween(String source,String destination);
	
	
	
	public Boolean adminLogin(int adminId, String password);
	public String checkUserIdAndBookinIdAndBusId(String number);
	public String checkContact (String contact);
	public String checkEmail (String email);
	public Boolean addAvailability(Available available);
	public List<Feedback> showFeedback();
}
