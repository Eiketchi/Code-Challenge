package com.challenge.Challenge.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.firebase.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;;
 
@Service
public class StorageService {
	Bucket bucket;
	
	
	
	/********************************** Constructor**************************/
	public StorageService()
	{
		try {
			FileInputStream serviceAccount = new FileInputStream("src/main/resources/Challenge1630341935f5.json");
	
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setStorageBucket("challenge-a0875.appspot.com")
					.build();
			
			
				FirebaseApp.initializeApp(options);
				
				 this.bucket = StorageClient.getInstance().bucket();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /*****************************Function***********************************/
	 public void SaveImg(String link) {
		 try {
			 String name = link.substring(link.indexOf("t1.0-9")+7,link.length());
				
			 URL url = new URL(link);
			 InputStream img = url.openStream();
			 
			 bucket.create(name, img);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
	 }
	
}
