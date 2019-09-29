package com.bbs.dao;

import java.util.HashMap;
import java.util.List;

import com.bbs.beans.Available;
import com.bbs.beans.Bus;
import com.bbs.beans.Feedback;

public interface DaoAdmin {
	public Boolean createBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Bus searchBus(int busId);
	public Boolean deletebus(int busId,String password);
	public HashMap<Integer, Bus> busBetween(String source,String destination);
	public Boolean addAvailability(Available available);
	public List<Feedback> showFeedback();
	
	
	public Boolean adminLogin(int adminId, String password);
}
