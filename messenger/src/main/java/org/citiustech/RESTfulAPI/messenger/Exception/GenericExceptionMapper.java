package org.citiustech.RESTfulAPI.messenger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.citiustech.RESTfulAPI.messenger.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(404, exception.getMessage(), "www.learningHub.com");
		return Response.status(Status.NOT_FOUND)
						.entity(errorMessage)
						.build();						
	}
		
}


