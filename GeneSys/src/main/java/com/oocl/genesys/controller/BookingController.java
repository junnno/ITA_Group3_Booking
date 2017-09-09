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

import com.oocl.genesys.criteria.BookingSearchCriteria;
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
	@RequestMapping(value = { "/listBkg" }, method = RequestMethod.POST)
	public List<Booking> listBkg(ModelMap model) {
		System.out.println("List Booking");
		List<Booking> bkgList = bkgService.listAllBooking();
        for(Booking bkg:bkgList) {
        	System.out.println("Booking Number: " + bkg.getBkgNum());
        }
        model.addAttribute("booking", bkgList);
        
		return bkgList;
    }
	
    @RequestMapping(value = { "/searchBkg/bkgNum={bkgNum}" }, method = RequestMethod.GET)
    public String searchBkgByBkgNum(@PathVariable String bkgNum, ModelMap model) {
    	System.out.println("Search Booking by booking number: " + bkgNum);
        Booking booking = bkgService.searchBkgByBkgNum(bkgNum);
        System.out.println("from:" + booking.getFromCity() + "    to: " + booking.getToCity());
        return "success";
    }
    
    @RequestMapping(value = { "/searchBkg/cntrNum={cntrNum}" }, method = RequestMethod.GET)
    public String searchBkgByCntrNum(@PathVariable String cntrNum, ModelMap model) {
    	System.out.println("Search Booking by Container number: " + cntrNum);
    	 Booking booking = bkgService.searchBkgByCntrNum(cntrNum);
    	 System.out.println("done");
    	 System.out.println("Booking number: "+booking.getBkgNum());
        return "";
    }
    @RequestMapping(value = { "/testSaveBkg" }, method = RequestMethod.GET)
    public String testSaveBkg(ModelMap model) {
		Booking bkg = new Booking();
		bkg.setBkgNum("404100001");
		bkg.setFromCity("HKG");
		bkg.setToCity("PUS");
		bkg.setIsApprovedDoc(1);
		bkg.setIsGoodCustomer(1);
		bkg.setIsValidWeight(1);
		bkg.setConsignee("Consignee");
		bkg.setShipper("Shipper");
		bkg.setStatus(1);
		bkg.setContainerList(getContainerList(bkg));
		bkg.setIsDeleted(0);
		
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
		cntr.setContainerNum("DASH0101"+i);
		cntr.setContainerType("20GP");
		cntr.setGrossWeight(123.00);
		cntr.setNetWeight(123.00);
		cntr.setUnit(1);
		return cntr;
	}
	
    @RequestMapping(value = { "/update/{bkgNum}" }, method = RequestMethod.GET)
    public String updateBooking(@PathVariable String bkgNum, ModelMap model) {
        Booking booking = bkgService.searchBkgByBkgNum(bkgNum);
        model.addAttribute("booking", booking);
        model.addAttribute("update", true);
        return "updateBooking";
    }
     
    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public String updateBooking(@Valid Booking booking, BindingResult result, ModelMap model)
    {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
            return "update";
        }
        bkgService.updateBkg(booking);
        model.addAttribute("success", "Booking # " + booking.getBkgNum()  + " updated successfully.");
        return "success";
    }
    
    @RequestMapping(value = { "/delete/{bkgNum}" }, method = RequestMethod.GET)
    public String deleteBooking(@PathVariable String bkgNum, ModelMap model) {
    	bkgService.deleteBkg(bkgNum);
        model.addAttribute("success", "Booking # " + bkgNum  + " has been deleted successfully.");
        return "success";
    }
    
    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public String search(@Valid BookingSearchCriteria bookingCriteria,  ModelMap model){
    	bookingCriteria.setBkgNum("1000");
    	bookingCriteria.setToCity("MNL");
    	bookingCriteria.setFromCity("HKG");
        bookingCriteria.setCntrNum("");
        
    	List<Booking> bkgList = bkgService.searchBooking(bookingCriteria);
        System.out.println(bkgList.size());
        for(Booking bkg : bkgList) {
        	System.out.println(bkg.getBkgNum()+";)");
        }
        return "success";
    }
}