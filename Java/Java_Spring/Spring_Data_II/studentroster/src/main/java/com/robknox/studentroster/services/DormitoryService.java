package com.robknox.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robknox.studentroster.models.Dormitory;
import com.robknox.studentroster.models.Student;
import com.robknox.studentroster.repositories.DormitoryRepository;

@Service
public class DormitoryService {
	private final DormitoryRepository dormitoryRepository;
	
	public DormitoryService(DormitoryRepository dormitoryRepository) {
		this.dormitoryRepository = dormitoryRepository;
	}
	
	// function to show all students
	public List<Dormitory> allDorms() {
		return dormitoryRepository.findAll();
	}
	
	// function to createStudent
	public Dormitory createDormitory(Dormitory dormitory) {
		return dormitoryRepository.save(dormitory);
	}
	
	// function to retrieve a student
	public Dormitory findDormitory(Long id) {
		Optional<Dormitory> optionalDormitory = dormitoryRepository.findById(id);
		if (optionalDormitory.isPresent()) {
			return optionalDormitory.get();
		} else {
			return null;
		}
	}
	
}
