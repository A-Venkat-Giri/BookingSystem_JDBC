package com.bbs.beans;

public class Feedback {
private int suggestionId;
private int userId;
private String feedback;
public int getSuggestionId() {
	return suggestionId;
}
public void setSuggestionId(int suggestionId) {
	this.suggestionId = suggestionId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
@Override
public String toString() {
	return "Feedback [suggestionId=" + suggestionId + ", userId=" + userId + ", feedback=" + feedback + "]";
}


}
