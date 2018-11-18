package org.citiustech.RESTfulAPI.messenger.Exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.citiustech.RESTfulAPI.messenger.model.ErrorMessage;
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		System.out.println("Sending Response");
		ErrorMessage errorMessage = new ErrorMessage(404, exception.getMessage(), "www.learningHub.com");
		return Response.status(Status.NOT_FOUND)
						.entity(errorMessage)
						.build();
						
	}

}
