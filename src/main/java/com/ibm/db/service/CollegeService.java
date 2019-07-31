package com.ibm.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.db.model.College;
import com.ibm.db.model.Student;
import com.ibm.db.repo.CollegeRepo;
import com.ibm.db.repo.StudentRepo;


@Service
public class CollegeService {

	@Autowired
	private CollegeRepo crepo;
	@Autowired
	private StudentRepo repo;
	
	
	
	public College addCollege(College college)
	{
		crepo.save(college);
		return college;
	}
	
	public Student addCollegeStudent(Student student, int cid)
	{
	    Optional<College> o = crepo.findById(cid);
	    if(o.isPresent())
	    {
	       College c = o.get();
	       student.setCollege(c);
	       repo.save(student);
	       return student;
	    }
	    else
	    {
	    	return null;
	    }
	}
	
	public List<Student> getCollegeStudents(int cid)
	{
		Optional<College> o = crepo.findById(cid);
		if(o.isPresent()) 
		{
			College c = o.get();
			List<Student> ls = repo.findByCollege(c);
			return ls;
		}
		else 
		{
			return null;
		}
	}
	
	public List<College> getColleges()
	{
		return crepo.findAll();
	}

	
	public Optional<College> getCollege(int cid)
	{
		return crepo.findById(cid);
	}
	
}
