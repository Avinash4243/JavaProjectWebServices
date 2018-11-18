package org.citiustech.RESTfulAPI.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.citiustech.RESTfulAPI.messenger.Datebase.DatabaseClass;
import org.citiustech.RESTfulAPI.messenger.model.Comment;
import org.citiustech.RESTfulAPI.messenger.model.ErrorMessage;
import org.citiustech.RESTfulAPI.messenger.model.Message;

public class CommentService {
	Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getComments(long messageId)
	{			
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}
	public Comment getComment(long messageId,long commentId) {
		ErrorMessage errorMessage = new ErrorMessage(404, "Resource not found", "www.learningHub.com");
		Response response = Response.status(Status.NOT_FOUND)
						.entity(errorMessage)
						.build();
		if(messages.get(messageId)==null) {
			throw new WebApplicationException(response);
		}
		Comment comment = messages.get(messageId).getComments().get(commentId);
		if(comment ==null) {
			throw new WebApplicationException(response);
		}
		return comment;
	}
	public Comment addComment(long messageId,Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1L);
		comment.setCreated(new Date());
		comments.put(comment.getId(), comment);		
		return comment;
		
	}
	public boolean editComment(long messageId, long commentId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comments.get(messageId) != null) {
			comments.put(commentId, comment);
			return true;
		}
		return false;
	}
	public boolean removeComment(long messageId,long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comments.get(commentId)!=null) {
			comments.remove(commentId);
			return true;
		}
		return false;
	}
}
