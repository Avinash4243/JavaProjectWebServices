package org.citiustech.RESTfulAPI.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.citiustech.RESTfulAPI.messenger.Datebase.DatabaseClass;

import org.citiustech.RESTfulAPI.messenger.model.Profile;

public class ProfileService {
	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String username){		
		return profiles.get(username);
	}
	
	public Profile createProfile(Profile profile){
		profile.setId((long) (profiles.size()+1));
		profile.setCreated(new Date());
		profiles.put(profile.getUsername(),profile);
		return profile;
	}
	public Profile updateProfile(String username, Profile profile){
		if(profile.getUsername().isEmpty()){
			return null;
		}		
		profile.setCreated(getProfile(username).getCreated());
		profile.setUpdated(new Date());
		profiles.put(profile.getUsername(),profile);
		return profile;
	}
	public Profile deleteProfile(String username){
		return profiles.remove(username);
	}
}
