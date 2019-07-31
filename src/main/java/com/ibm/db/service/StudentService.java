package com.ibm.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.db.model.College;
import com.ibm.db.model.Student;
import com.ibm.db.repo.CollegeRepo;
import com.ibm.db.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	@Autowired
	private CollegeRepo crepo;
	
	
	public Student addStudent(Student student)
	{
		repo.save(student);
		return student;
	}
	
	
	
	public List<Student> getStudents()
	{
		return repo.findAll();
	}
	
	
	public String deleteStudent( int sid )
	{
		Optional<Student> o = repo.findById(sid);
		if(o.isPresent())
		{
			Student s = repo.getOne(sid);
			repo.delete(s);
			return "Data Deleted";
		}
		else 
		{
			return"No Student is in our database with sid = "+sid+" ";
		}
	}
	

	public Student updateStudent(Student student)
	{
		int sid = student.getSid();
		Optional<Student> o = repo.findById(sid);
		if(o.isPresent())
		{
			Student s = o.get();
			College c = s.getCollege();
			student.setCollege(c);
			repo.save(student);
			return student;
		}
		else {
			return null;
		}
		
	}
	
	public Student UpdateCollegeOfStudent(int sid,int cid)
	{
		Optional<Student> o = repo.findById(sid);
		if(o.isPresent())
		{
			Student s = o.get();
			Optional<College> oc = crepo.findById(cid);
			if(oc.isPresent())
			{
				College c = oc.get();
				s.setCollege(c);
				repo.save(s);
				return s;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	
	public Optional<Student> getStudent(int sid)
	{
		return repo.findById(sid);
	}
	
	
	
}


