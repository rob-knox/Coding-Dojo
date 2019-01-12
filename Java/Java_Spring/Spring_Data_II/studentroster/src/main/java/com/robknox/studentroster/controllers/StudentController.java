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

import com.robknox.studentroster.models.Address;
import com.robknox.studentroster.models.Student;
import com.robknox.studentroster.services.AddressService;
import com.robknox.studentroster.services.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;
	private final AddressService addressService;
	
	public StudentController(StudentService studentService, AddressService addressService) {
		this.studentService = studentService;
		this.addressService = addressService;
	}
	
	// Show all students
	@RequestMapping("/students")
	public String index(Model model) {
		List<Student> students = studentService.allStudents();
		model.addAttribute("students", students);
		model.addAttribute("allAddresses", addressService.allAddresses());
		return "/students/index.jsp";
	}
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("studentObj") Student student) {
		return "/students/new.jsp";
	}
	// Create a new student
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("studentObj") Student student, BindingResult result) {
		System.out.println("post method called");
		if (result.hasErrors()) {
			return "/students/new.jsp";
		} else {
			studentService.createStudent(student);
			return "redirect:/students";
		}
	}
	
	// Gets a student
	@RequestMapping("students/{id}")
	public Student show(@PathVariable("id") Long id) {
		Student student = studentService.findStudent(id);
		return student;
	}
}
