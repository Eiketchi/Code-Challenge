package com.challenge.Challenge.service;

import java.util.List;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Photo;

@Service
public class FacebookService {
	public static final String MY_ACCESS_TOKEN = "EAALN6IhmUy0BANiZBsm5tqcx5tVvUy5YYYjiHZCg0lzJa6PH3F9UxNbLFn1reSgBRP3xA781boJYivKzjQkr0HtZCm3bNcuZAaZA8S98keF9ZBnJExjV3IqstIQ1QlYqehOZAzCCzZCwVrtSEdY4aCF0znMoN3GzDO0ZD";
    private Facebook facebook;
    private ConnectionRepository connectionRepository;
    private static FacebookClient facebookClient=new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_2_4);
        
    
    
    
    /********************************** Constructor**************************/
    public FacebookService(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
        //FacebookService.facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_2_4);
    }
    
    
    
    /*****************************Function***********************************/
    
   public boolean isConnected() {
	   return connectionRepository.findPrimaryConnection(Facebook.class) == null;
   }
   
   public User getUserInfo() {
	   String [] fields = { "id", "email",  "first_name", "last_name" };
       return facebook.fetchObject("me", User.class, fields);
	   
   }
   
   public static List<Photo> getUserPictures(){
	   Connection<Photo> PhotoConnection = facebookClient.fetchConnection(
	           "me/photos/uploaded", Photo.class, Parameter.with("fields", "id,link,name,picture,images"),Parameter.with("limit", 2000));
	   return PhotoConnection.getData();
	   
   }
   
    
    

}
