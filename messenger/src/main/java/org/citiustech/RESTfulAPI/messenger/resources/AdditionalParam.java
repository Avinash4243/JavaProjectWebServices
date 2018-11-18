package org.citiustech.RESTfulAPI.messenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value="/additionalparams")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class AdditionalParam {
	@GET	
	public String getParams(@BeanParam BeanParameter bean){
		return "Matrix Parameter = "+bean.getMatrixparam()+"\nUser Name = "+bean.getUsername();
	}
	@GET
	@Path(value="/context")
	public String getContextParams(@BeanParam BeanParameter bean){
		return "URI Path = "+bean.getUriInf().getAbsolutePath().toString()+"\nCookies = "+bean.getHeaders().getDate();
	}
}
