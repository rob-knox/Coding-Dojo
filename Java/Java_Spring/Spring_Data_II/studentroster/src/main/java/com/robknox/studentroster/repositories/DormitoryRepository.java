package com.robknox.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robknox.studentroster.models.Dormitory;

@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, Long>{
	List<Dormitory> findAll();
}
