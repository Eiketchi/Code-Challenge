package com.challenge.Challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.challenge.Challenge.service.StorageService;
import com.challenge.Challenge.service.FacebookService;
 
@Controller
@SessionAttributes("name")
public class StorageController {
	@Autowired	
	StorageService storServ;
		
		
		
		 @RequestMapping(value="/Upload", method = RequestMethod.POST)
		 public String UploadFirebase(Model model, @RequestParam List<String> Choices) 
		 {
				 for(String link: Choices)
				 {
					 storServ.SaveImg(link);
					
				 }
			model.addAttribute("msg", "Upload Complete");
			model.addAttribute("photos", FacebookService.getUserPictures());
			return "connect/Hello";
		 }
		
}
