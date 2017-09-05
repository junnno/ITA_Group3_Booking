package com.oocl.genesys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oocl.genesys.model.Booking;
import com.oocl.genesys.service.BookingService;

@Controller
@ComponentScan("com.oocl.genesys") 
public class BookingController {
	
	
	@Autowired
    BookingService bkgService;
	
	@RequestMapping(value = { "/contoller" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
		System.out.println("Test");
		return "";
    }
	
	@RequestMapping(value = { "/listBkg" }, method = RequestMethod.GET)
    public String listBkg(ModelMap model) {
		System.out.println("List Booking");
		List<Booking> bkgList = bkgService.listAllBooking();
        for(Booking bkg:bkgList) {
        	System.out.println("Booking Number: " + bkg.getBkgNum());
        }
        model.addAttribute("booking", bkgList);
        
		return "";
    }
	
}
