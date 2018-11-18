package org.citiustech.RESTfulAPI.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.citiustech.RESTfulAPI.messenger.model.Comment;
import org.citiustech.RESTfulAPI.messenger.service.CommentService;

@Path(value="/")
public class CommentResource {
	CommentService commentService = new CommentService();
	@GET
	public List<Comment> getComments(@BeanParam BeanParameter bean) {
		return commentService.getComments(bean.getMessageId());
	}
	@POST
	public Comment putComment(@BeanParam BeanParameter bean,Comment comment) {
		return commentService.addComment(bean.getMessageId(), comment);
	}
	
}
