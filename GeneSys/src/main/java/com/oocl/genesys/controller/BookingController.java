package com.oocl.genesys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.genesys.model.Booking;
import com.oocl.genesys.model.Container;
import com.oocl.genesys.service.BookingService;

@Controller
@RequestMapping("/booking")
@ComponentScan("com.oocl.genesys") 
public class BookingController {
	
	
	@Autowired
    BookingService bkgService;
	
	@RequestMapping(value = { "/contoller" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
		System.out.println("Test");
		return "";
    }
	
	@ResponseBody
	@RequestMapping(value = { "/listBkg" }, method = RequestMethod.GET)
    public List<Booking> listBkg(ModelMap model) {
		System.out.println("List Booking");
		List<Booking> bkgList = bkgService.listAllBooking();
        for(Booking bkg:bkgList) {
        	System.out.println("Booking Number: " + bkg.getBkgNum());
        }
        model.addAttribute("booking", bkgList);        
		return bkgList;
    }
	
    @RequestMapping(value = { "/searchBkg/{bkgNum}" }, method = RequestMethod.GET)
    public String searchBkgByBkgNum(@PathVariable int bkgNum, ModelMap model) {
    	System.out.println("Search Booking by booking number: " + bkgNum);
        Booking booking = bkgService.searchBkgByBkgNum(String.valueOf(bkgNum));
        
        System.out.println("from:" + booking.getFromCity() + "    to: " + booking.getToCity());
        return "";
    }
	
	@RequestMapping(value = { "/testSaveBkg" }, method = RequestMethod.GET)
    public String testSaveBkg(ModelMap model) {
		Booking bkg = new Booking();
		bkg.setBkgNum("40410004");
		bkg.setFromCity("HKG");
		bkg.setToCity("PUS");
		bkg.setIsApprovedDoc(1);
		bkg.setIsGoodCustomer(1);
		bkg.setIsValidWeight(1);
		bkg.setConsignee("Consignee");
		bkg.setShipper("Shipper");
		bkg.setStatus(1);
		bkg.setIsDeleted(0);
		bkg.setContainerList(getContainerList(bkg));
		bkgService.flushBkg();
		bkgService.saveBkg(bkg);
		
		System.out.println("Booking saved");
		return "test";
    }
	
	private List<Container> getContainerList(Booking bkg) {
		List<Container> cntr = new ArrayList<Container>();
		int loop = 3;
		for(int i=0; i<loop; i++) {
			cntr.add(getContainer(bkg, (i+1)));
		}
		
		return cntr;
	}

	private static Container getContainer(Booking bkg, int i) {
		Container cntr = new Container();
		cntr.setBooking(bkg);
		cntr.setCargoDesc("TestBooking");
		cntr.setCargoNature("GC");
		cntr.setContainerNum("GENE10200"+i);
		cntr.setContainerType("20GP");
		cntr.setGrossWeight(123.00);
		cntr.setNetWeight(123.00);
		cntr.setUnit(1);
		return cntr;
	}
	
	/*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/update/{bkgNum}" }, method = RequestMethod.GET)
    public void updateBooking(@PathVariable int bkgNum, ModelMap model) {
        Booking booking = bkgService.searchBkgByBkgNum(String.valueOf(bkgNum));
        model.addAttribute("booking", booking);
        model.addAttribute("update", true);
//        return "update";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public String updateBooking(@Valid Booking booking, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {
            return "update";
        }
 
        bkgService.updateBkg(booking);
        model.addAttribute("success", "Booking # " + booking.getBkgNum()  + " updated successfully.");
        return "success";
    }
	
}
