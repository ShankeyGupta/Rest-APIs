package com.ibm.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.db.model.College;
import com.ibm.db.model.Student;


public interface CollegeRepo extends JpaRepository<College,Integer>
{
	
}

