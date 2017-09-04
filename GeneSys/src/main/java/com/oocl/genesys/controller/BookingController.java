package com.oocl.genesys.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javacodegeeks.model.Employee;

@Controller
@ComponentScan("com.oocl.genesys") 
public class BookingController {
	
	@RequestMapping(value = { "/contoller" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
		System.out.println("Test");
		return "";
    }
}
