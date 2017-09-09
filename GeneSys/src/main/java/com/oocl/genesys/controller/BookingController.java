package com.oocl.genesys.controller;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.genesys.criteria.BookingSearchCriteria;
import com.oocl.genesys.mapper.BookingMapper;
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
        	/*if(bkg.getContainerList().isEmpty()) {
        		System.out.println(bkg.getContainerList().get(0));
        	}*/
        }
        model.addAttribute("booking", bkgList);
        
		return bkgList;
    }
	
    @RequestMapping(value = { "/searchBkg/bkgNum={bkgNum}" }, method = RequestMethod.GET)
    public String searchBkgByBkgNum(@PathVariable String bkgNum, ModelMap model) {
    	System.out.println("Search Booking by booking number: " + bkgNum);
        Booking booking = bkgService.searchBkgByBkgNum(bkgNum);
        if(booking!=null) {	
        	System.out.println("Booking number: " + booking.getBkgNum());
        }
        else {
   		 System.out.println("No booking found.");
        }
        return "success";
    }
    
    @RequestMapping(value = { "/searchBkg/cntrNum={cntrNum}" }, method = RequestMethod.GET)
    public String searchBkgByCntrNum(@PathVariable String cntrNum, ModelMap model) {
    	System.out.println("Search Booking by Container number: " + cntrNum);
    	 Booking booking = bkgService.searchBkgByCntrNum(cntrNum);
    	 if(booking!=null) {
    		 System.out.println("Booking number: "+booking.getBkgNum());
    	 }
    	 else {
    		 System.out.println("No booking found.");
    	}
    	 
        return "success";
    }
    
    @ResponseBody
    @RequestMapping(value = { "/testSaveBkg" }, method = {RequestMethod.POST, RequestMethod.GET})
    public String testSaveBkg(@RequestParam(required=true) String booking, @RequestParam(required=true) String containers
    		, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
//    	System.out.println(booking+" "+containers);
    	Object bkgObj = new JSONObject(booking);
    	JSONObject bkgJo = (JSONObject) bkgObj;
    	
    	Booking bkg = new Booking();
		bkg.setBkgNum(createBkgNum());
		bkg.setFromCity(bkgJo.getString("fromCity").isEmpty() ? "" : (String)bkgJo.getString("fromCity"));
		bkg.setToCity(bkgJo.getString("toCity").isEmpty() ? "" : (String)bkgJo.getString("toCity"));
		bkg.setIsApprovedDoc(bkgJo.getBoolean("approveDoc") ? 1 : 0);
		bkg.setIsGoodCustomer(bkgJo.getBoolean("goodCustomer") ? 1 : 0);
		bkg.setIsValidWeight(bkgJo.getBoolean("validWgt") ? 1 : 0);
		bkg.setConsignee(bkgJo.getString("consignee").isEmpty() ? "" : (String)bkgJo.getString("consignee"));
		bkg.setShipper(bkgJo.getString("shipper").isEmpty() ? "" : (String)bkgJo.getString("shipper"));
		bkg.setStatus(bkgJo.getBoolean("bkgStat") ? 1 : 0);
		bkg.setIsDeleted(0);
//		bkg.setContainerList(getContainerList(bkg));
//		bkgService.saveBkg(bkg);
		
		System.out.println(bkg.toString());
		Cookie c = new Cookie("User", "BKG");
		response.addCookie(c);
		return "Booking saved";
    }
    
    private String createBkgNum() {
    	String bkgNum = "";
    	
    	for(int i=0; i<10; i++) {
    		bkgNum += Math.floor(Math.random() * 10);
    	}
    	
    	return bkgNum;
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
    	bookingCriteria.setBkgNum("");
    	bookingCriteria.setToCity("MNL");
    	bookingCriteria.setFromCity("HKG");
        bookingCriteria.setCntrNum("");
        
    	List<Booking> bkgList = bkgService.searchBooking(bookingCriteria);
    	if(bkgList.size()!=0) {
	        System.out.println(bkgList.size());
	        for(Booking bkg : bkgList) {
	        	System.out.println(bkg.getBkgNum()+";)");
	        }
	       
    	}
    	else {
    		 System.out.println("No booking found.");
    	}
    	 return "success";
    }
}