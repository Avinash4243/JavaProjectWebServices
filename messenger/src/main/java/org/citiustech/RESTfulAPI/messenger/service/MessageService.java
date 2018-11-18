package org.citiustech.RESTfulAPI.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.citiustech.RESTfulAPI.messenger.Datebase.DatabaseClass;
import org.citiustech.RESTfulAPI.messenger.Exception.DataNotFoundException;
import org.citiustech.RESTfulAPI.messenger.model.Message;

public class MessageService {
	
	Map<Long, Message> messages = DatabaseClass.getMessages();	
	public  MessageService() {
		// TODO Auto-generated constructor stub
//		messages.put(1L, new Message(1L,"Hello","Avinash"));
//		messages.put(2L, new Message(2L,"How are you?","Santosh"));
	}
	
	
	public List<Message> getMessages() {		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){	
		if(messages.get(id)==null) {
			throw new DataNotFoundException("Message with id "+id+" not found");
		}
		Message message = messages.get(id);		
		return message;
		
	}
	public List<Message>  getMessages(int year){
		List<Message> messagesForyear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForyear.add(message);
			}
		}
		return messagesForyear;
	}
	public List<Message>  getMessagesPaginated(int start, int size){
		List<Message>  paginatedMessage = new ArrayList<>(messages.values());
		if(start+size > paginatedMessage.size()) return new ArrayList<Message>();
		paginatedMessage.subList(start, size);
		return paginatedMessage;
	}
	
	public Message createMessage(Message msg){
		msg.setId((long) (messages.size()+1));
		msg.setCreated(new Date());
		messages.put(msg.getId(),msg);
		return msg;
	}
	public boolean updateMessage(long id, Message msg){
		if(msg.getId()==0){
			return false;
		}		
		msg.setCreated(getMessage(id).getCreated());
		msg.setUpdated(new Date());
		messages.put(msg.getId(),msg);
		return true;

	}
	public Message deleteMessage(Long id){
		return messages.remove(id);
	}
}
