package com.ibm.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.ibm.db.model.College;
import com.ibm.db.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>
{
	List<Student> findByCollege(College c);
}
