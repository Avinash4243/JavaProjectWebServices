package org.citiustech.RESTfulAPI.messenger.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

public class BeanParameter {
	private @PathParam("messageId") long messageId;
	private @QueryParam("year")int year;
	private @QueryParam("start")int start;
	private @QueryParam("end")int end;
	private @MatrixParam("matrix") String matrixparam;
	private @HeaderParam("username") String username;
	private @CookieParam ("name") String name;
	private @Context UriInfo uriInf;
	private @Context HttpHeaders headers;
	
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getMatrixparam() {
		return matrixparam;
	}
	public void setMatrixparam(String matrixparam) {
		this.matrixparam = matrixparam;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UriInfo getUriInf() {
		return uriInf;
	}
	public void setUriInf(UriInfo uriInf) {
		this.uriInf = uriInf;
	}
	public HttpHeaders getHeaders() {
		return headers;
	}
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	
}
