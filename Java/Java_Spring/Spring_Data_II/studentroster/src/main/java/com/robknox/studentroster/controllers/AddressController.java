package com.robknox.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robknox.studentroster.models.Address;
import com.robknox.studentroster.services.AddressService;
import com.robknox.studentroster.services.StudentService;

@Controller
public class AddressController {
	private StudentService studentService;
	private AddressService addressService;
	
	public AddressController(AddressService addressService, StudentService studentService) {
		this.addressService = addressService;
		this.studentService = studentService;
	}
	
	// Contact info for student
	@RequestMapping("/students/contact/new")
	public String newAddress(@ModelAttribute("addressObj") Address address, Model model) {
		model.addAttribute("allStudents", studentService.allStudents());
		return "/students/contact.jsp";
	}
	// Create a new student
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("addressObj") Address address, BindingResult result) {
		System.out.println("post method called");
		if (result.hasErrors()) {
			System.out.println("error");
			return "/students/contact.jsp";
		} else {
			System.out.println("works");
			addressService.createAddress(address);
			return "redirect:/students";
		}
	}
	
	// test
//	@RequestMapping("/students/contact/new")
//	public String newAddress() {
//		return "/students/contact.jsp";
//	}
}
