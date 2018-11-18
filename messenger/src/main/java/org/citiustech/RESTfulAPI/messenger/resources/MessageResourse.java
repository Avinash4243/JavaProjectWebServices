package org.citiustech.RESTfulAPI.messenger.resources;



import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.ws.rs.core.UriInfo;

import org.citiustech.RESTfulAPI.messenger.model.Message;

import org.citiustech.RESTfulAPI.messenger.service.MessageService;

@Path(value = "/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResourse {
	MessageService messageService = new MessageService();	
	
	@GET	
	public List<Message> getMessages(@BeanParam BeanParameter bean) {
		System.out.println("Into the get Function!!!");
		if(bean.getYear()>0){
			return messageService.getMessages(bean.getYear());
		}
		if(bean.getStart()>=0 && bean.getEnd()>=0){
			return messageService.getMessagesPaginated(bean.getStart(), bean.getEnd());
		}
		System.out.println("Going to return messages!!");
		return messageService.getMessages();
		 
	}
	@Path(value="/{id}")
	@GET	
	public Message getMessage(@PathParam("id") long ids, @Context UriInfo uriInfo){		
		Message message = messageService.getMessage(ids);
		
		//String uri = uriInfo.getAbsolutePathBuilder().build().toString();
		message.addLink(getUriForSelf(ids, uriInfo), "self");
		message.addLink(getUriForProfile(message, uriInfo), "profile");
		message.addLink(getUriForComment(message, uriInfo), "comment");
		return message;
	}
	private String getUriForComment(Message message, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResourse.class)
				.path(MessageResourse.class,"getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build()
				.toString();
		return uri;
	}
	private String getUriForProfile(Message message, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build().toString();
		return uri;
	}
	private String getUriForSelf(long ids, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(MessageResourse.class).path(String.valueOf(ids)).build().toString();
		return uri;
	}
	@POST	
	public Response addMessage(Message msg,@Context UriInfo uriFilter){
		Message message = messageService.createMessage(msg);
		URI uri = uriFilter.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build();
		return Response.created(uri)
						.status(Status.CREATED)
						.entity(message)
						.build();
	}		
	@Path(value="/{id}")
	@PUT	
	public boolean updateMessage(@PathParam("id") long id,Message message){
		message.setId(id);
		boolean status = messageService.updateMessage(id, message);
		return status;
	}
	@Path(value="/{id}")
	@DELETE	
	public Message deleteMessage(@PathParam("id") long id){
		Message message = messageService.deleteMessage(id);
		return message;
	}
	@Path(value="/{messageId}/comments")
	public CommentResource getCommentResource(){		
		return new CommentResource();


	}
	
}
