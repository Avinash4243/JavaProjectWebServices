package org.citiustech.RESTfulAPI.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.citiustech.RESTfulAPI.messenger.model.Profile;
import org.citiustech.RESTfulAPI.messenger.service.ProfileService;


@Path(value = "/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profileService = new ProfileService();	
	@GET	
	public List<Profile> getProfiles() {
		List<Profile> list = profileService.getProfiles();
		return list;
	}
	@Path(value="/{username}")
	@GET	
	public Profile getProfile(@PathParam("username") String username){		
		return profileService.getProfile(username);
	}
	@POST	
	public Profile addProfile(Profile p){
		Profile profile = profileService.createProfile(p);
		return profile;
	}
	@Path(value="/{username}")
	@PUT	
	public Profile updateProfile(@PathParam("username") String username,Profile p){
		p.setUsername(username);
		Profile profile = profileService.updateProfile(username, p);
		return profile;
	}
	@Path(value="/{username}")
	@DELETE	
	public Profile deleteProfile(@PathParam("username") String username){
		Profile profile = profileService.deleteProfile(username);
		return profile;
	}
	@Path(value="/test")
	@GET	
	public String test(){		
		return "Hey there, Welcome!!";
	}
	
}
