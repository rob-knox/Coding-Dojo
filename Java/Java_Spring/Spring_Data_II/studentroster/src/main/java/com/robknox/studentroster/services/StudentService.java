package com.robknox.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robknox.studentroster.models.Student;
import com.robknox.studentroster.repositories.AddressRepository;
import com.robknox.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	// Instance
	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;
	
	// Dependency
	public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
		this.studentRepository = studentRepository;
		this.addressRepository = addressRepository;
	}
	
	// function to show all students
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	
	// function to createStudent
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	// function to retrieve a student
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}
}
