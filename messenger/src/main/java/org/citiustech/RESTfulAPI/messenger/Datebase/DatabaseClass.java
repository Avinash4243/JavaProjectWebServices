package org.citiustech.RESTfulAPI.messenger.Datebase;

import java.util.HashMap;
import java.util.Map;


import org.citiustech.RESTfulAPI.messenger.model.Comment;
import org.citiustech.RESTfulAPI.messenger.model.Message;
import org.citiustech.RESTfulAPI.messenger.model.Profile;

public class DatabaseClass {
	private static Map<Long,Message> messages= new HashMap<Long,Message>();
	private static Map<String,Profile> profiles= new HashMap<String,Profile>();
	private static Map<Long,Comment> comments= new HashMap<Long,Comment>();
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}
	public static Map<Long, Comment> getComments() {
		return comments;
	}
	public static void setComments(Map<Long, Comment> comments) {
		DatabaseClass.comments = comments;
	}
}
