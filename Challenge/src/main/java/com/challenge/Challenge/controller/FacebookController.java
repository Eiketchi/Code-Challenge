package com.challenge.Challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.challenge.Challenge.service.FacebookService;

@Controller
@SessionAttributes("name")
public class FacebookController {
	
	@Autowired
	FacebookService faceServ;
	

    @RequestMapping(value="/Hello", method = RequestMethod.GET)
    public String helloFacebook(Model model) {    	
    	if (faceServ.isConnected()) {
            return "redirect:/connect/facebook";
        }
    	
        model.addAttribute("msg", faceServ.getUserInfo().getFirstName());
        model.addAttribute("photos", FacebookService.getUserPictures());
        return "/connect/Hello";

    	
    }




}
