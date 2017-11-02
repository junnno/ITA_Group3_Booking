package com.oocl.genesys.controller;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONArray;
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
//import com.oocl.genesys.mapper.BookingMapper;
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
    @RequestMapping(value = { "/saveBkg" }, method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, Object> saveBkg(@RequestParam(required=true) String booking, @RequestParam(required=true) String containers
    		, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
    	HashMap<String, Object> res = new HashMap<String, Object>();
    	Object bkgObj = null;
    	JSONArray cntrObj = null;
    	JSONObject bkgJo = null;
    	Booking bkg = null;
    	
    	//JSON parser for bkg object
    	if(!booking.isEmpty()) {
    		bkgObj = new JSONObject(booking);
        	bkgJo = (JSONObject) bkgObj;
    	}
    	
    	//JSON parser for cntr object
    	if(!containers.isEmpty()) {
    		cntrObj = new JSONArray(containers);
        	//cntrJo = (JSONObject) cntrObj;
    	}
    	
    	if(bkgJo != null) {
    		bkg = new Booking();
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
    		if(cntrObj.length() > 0) {
    			bkg.setContainerList(getContainerList(bkg, bkgJo, cntrObj));
    		}
    		bkgService.saveBkg(bkg);
    		res.put("bkgNum", bkg.getBkgNum());
    		res.put("success", true);
    		res.put("error", "");
    		//return "Booking saved";
    		return res;
    	}
		
		Cookie c = new Cookie("Cookie", "ThisISACookie");
		response.addCookie(c);
		
		res.put("success", false);
		res.put("error", "Required booking details not filled up");
		//return "Booking not saved!";
		return res;
    }
    
    @ResponseBody
    @RequestMapping(value = { "/updateBkg" }, method = {RequestMethod.POST})
    public HashMap<String, Object> updateBkg(@RequestParam(required=true) String booking, @RequestParam(required=true) String containers
    		, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
    	HashMap<String, Object> res = new HashMap<String, Object>();
    	Object bkgObj = null;
    	JSONArray cntrObj = null;
    	JSONObject bkgJo = null;
    	
    	//JSON parser for bkg object
    	if(!booking.isEmpty()) {
    		bkgObj = new JSONObject(booking);
        	bkgJo = (JSONObject) bkgObj;
    	}
    	
    	//JSON parser for cntr object
    	if(!containers.isEmpty()) {
    		cntrObj = new JSONArray(containers);
        	//cntrJo = (JSONObject) cntrObj;
    	}

    	Booking bkg = bkgService.searchBkgByBkgNum(bkgJo.getString("bkgNum"));
    	
    	if(bkg!=null && bkgJo!=null) {
    		bkg.setFromCity(bkgJo.getString("fromCity").isEmpty() ? "" : (String)bkgJo.getString("fromCity"));
    		bkg.setToCity(bkgJo.getString("toCity").isEmpty() ? "" : (String)bkgJo.getString("toCity"));
    		bkg.setIsApprovedDoc(bkgJo.getBoolean("approveDoc") ? 1 : 0);
    		bkg.setIsGoodCustomer(bkgJo.getBoolean("goodCustomer") ? 1 : 0);
    		bkg.setIsValidWeight(bkgJo.getBoolean("validWgt") ? 1 : 0);
    		bkg.setConsignee(bkgJo.getString("consignee").isEmpty() ? "" : (String)bkgJo.getString("consignee"));
    		bkg.setShipper(bkgJo.getString("shipper").isEmpty() ? "" : (String)bkgJo.getString("shipper"));
    		bkg.setStatus(bkgJo.getBoolean("bkgStat") ? 1 : 0);
    		bkg.setIsDeleted(0);
    		bkg.getContainerList().clear();
    		
    		if(cntrObj.length() > 0) {
    			bkg.setContainerList(getContainerList(bkg, bkgJo, cntrObj));
    		}
    		
    		bkgService.updateBkg(bkg);
    		
    		res.put("bkgNum", bkg.getBkgNum());
    		res.put("success", true);
    		res.put("error", "");
    		
    		return res;
    	}
		res.put("success", false);
		res.put("error", "Required booking details not filled up");
		return res;
    }
    
    private String createBkgNum() {
    	String num = "";
    	
    	for(int i=0; i<10; i++) {
    		num += (int)Math.floor(Math.random() * 10);
    	}
    	
    	return num;
    }
    
    private String createCntrNum() {
    	String num = "OOLU";
    	
    	for(int i=0; i<6; i++) {
    		num += (int)Math.floor(Math.random() * 10);
    	}
    	
    	return num;
    }
	
	private List<Container> getContainerList(Booking bkg, JSONObject bkgJo, JSONArray cntrObj) {
		List<Container> cntr = new ArrayList<Container>();
		
		for(int i=0; i<cntrObj.length(); i++) {
			cntr.add(getContainer(bkg, bkgJo, cntrObj.getJSONObject(i)));
		}
		return cntr;
	}
	
	//Function for checking unique cntr number 
	private String getCntrNum() {
		String cntrNum = createCntrNum();
		
		if(false/*object NOT empty*/) {
			getCntrNum();
		}
		
		return cntrNum;
	}

	private Container getContainer(Booking bkg, JSONObject bkgJo, JSONObject cntrJo) {
		Container cntr;
		cntr = bkgService.getContainer(bkg, cntrJo.getString("CntrNumber"));
		if(cntr==null) {
			cntr = new Container();
			cntr.setContainerNum(getCntrNum());
		}
		cntr.setBooking(bkg);
		cntr.setCargoDesc(bkgJo.getString("description").isEmpty() ? "" : (String)bkgJo.getString("description"));
		cntr.setCargoNature(bkgJo.getString("cargoNature").isEmpty() ? "" : (String)bkgJo.getString("cargoNature"));
		cntr.setContainerType(cntrJo.getString("CntrType").isEmpty() ? "" : (String)cntrJo.getString("CntrType"));
		cntr.setGrossWeight(cntrJo.get("CntrGross").toString().equals("null") ? 0.0 : cntrJo.getDouble("CntrGross"));
		cntr.setNetWeight(cntrJo.get("CntrNet").toString().equals("null") ? 0.0 : cntrJo.getDouble("CntrNet"));
		cntr.setUnit(cntrJo.get("CntrUnit").toString().equals("KG") ? 1 : 0);
		return cntr;
	}
	
    @RequestMapping(value = { "/update/{bkgNum}" }, method = RequestMethod.GET)
    public String updateBooking(@PathVariable String bkgNum, ModelMap model) {
        Booking booking = bkgService.searchBkgByBkgNum(bkgNum);
        if(booking!=null) {
        	bkgService.updateBkg(booking);
        }
        else {
        	System.out.println("Booking does not exist");
        }
        model.addAttribute("booking", booking);
        model.addAttribute("update", true);
        return "updateBooking";
    }
     
    public void updateBooking(Booking booking) {
        bkgService.updateBkg(booking);
    }
    @ResponseBody
    @RequestMapping(value = { "/delete" }, method ={RequestMethod.POST, RequestMethod.GET})
    public String deleteBooking(@Valid String bkgNums, ModelMap model) {
    	List<String> bkgList = new ArrayList();
    	String[] x = bkgNums.split(" ");
    	
    	for(String n: x) {
    		System.out.println("delete: " + n);
    		bkgService.deleteBkg(n);
    	}
    	
//    	System.out.println("delete");
//    	bkgService.deleteBkg(bkgNum);
//        model.addAttribute("success", "Booking # " + bkgNum  + " has been deleted successfully.");
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = { "/search" }, method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, Object> search(@Valid String criteria,  ModelMap model){
    	HashMap<String, Object> response = new HashMap<String, Object>();
    	BookingSearchCriteria bkgCriteria = new BookingSearchCriteria();
    	Object criteriaObj = new JSONObject(criteria);
    	JSONObject critBkg = (JSONObject) criteriaObj;
    	
    	bkgCriteria.setBkgNum(critBkg.getString("bkgNum").isEmpty() ? "" : (String)critBkg.getString("bkgNum"));
    	bkgCriteria.setCntrNum(critBkg.getString("cntrNum").isEmpty() ? "" : (String)critBkg.getString("cntrNum"));
    	bkgCriteria.setFromCity(critBkg.getString("fromCity").isEmpty() ? "" : (String)critBkg.getString("fromCity"));
    	bkgCriteria.setToCity(critBkg.getString("toCity").isEmpty() ? "" : (String)critBkg.getString("toCity"));
    	bkgCriteria.setStatus(critBkg.getString("status").isEmpty() ? "" : (String)critBkg.getString("status"));
    	List<Booking> bkgList = bkgService.searchBooking(bkgCriteria);
    	if(bkgList.size()!=0) {
	        System.out.println(bkgList.size());
	        for(Booking bkg : bkgList) {
	        	System.out.println(bkg.getBkgNum()+";)");
	        }
	        model.addAttribute("booking", bkgList);
	        response.put("data", bkgList);
			response.put("success", true);
			return response;
    	}
    	else {
    		 System.out.println("No booking found.");
    	}
    	return response;
    }
}