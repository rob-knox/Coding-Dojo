package com.robknox.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robknox.studentroster.models.Dormitory;
import com.robknox.studentroster.models.Student;
import com.robknox.studentroster.services.DormitoryService;
import com.robknox.studentroster.services.StudentService;

@Controller
public class DormitoryController {
	private final DormitoryService dormitoryService;
	private final StudentService studentService;
	
	public DormitoryController(DormitoryService dormitoryService, StudentService studentService ) {
		this.dormitoryService = dormitoryService;
		this.studentService = studentService;
	}
	
	// show current dormitory
	@RequestMapping("/dorms/{id}")
	public String assignDormitory(@PathVariable("id") Long id) {
		dormitoryService.findDormitory(id);
		return "/dorms/{id}";
	}
	
	// add new dormitory
	@RequestMapping("/dorms/new")
	public String newDormitory(@ModelAttribute("dormitoryObj") Dormitory dormitory) {
		return "/dorms/addDorm.jsp";
	}
	
	// function to create a dormitory
	@RequestMapping(value="/newDorm", method=RequestMethod.POST)
	public String createDorm(@Valid @ModelAttribute("dormitoryObj") Dormitory dormitory, BindingResult result) {
		if (result.hasErrors()) {
			return "/dorms/addDorm.jsp";
		} else {
			dormitoryService.createDormitory(dormitory);
			return "redirect:/students";
		}
	}
}
