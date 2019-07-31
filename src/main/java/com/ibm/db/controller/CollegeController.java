package com.ibm.db.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.db.model.College;
import com.ibm.db.model.Student;
import com.ibm.db.service.CollegeService;
import com.ibm.db.service.StudentService;


@RestController
public class CollegeController 
{
	@Autowired
	CollegeService cService;
	@Autowired
	StudentService sService;
	
	
	@PostMapping("/college")
	public College addCollege(@RequestBody College college)
	{
		return cService.addCollege(college);
	}
	
	@PostMapping("/college/{cid}/student")
	public Student addCollegeStudent(@RequestBody Student student,@PathVariable int cid)
	{
		return cService.addCollegeStudent(student,cid);
	}
	
	@GetMapping("/colleges")
	public List<College> getColleges()
	{
		return cService.getColleges();
	}
	
	@GetMapping("/college/{cid}/students")
	public List<Student> getCollegeStudents(@PathVariable int cid)
	{
		return cService.getCollegeStudents(cid);
	}

	
	@RequestMapping("/college/{cid}")
	//@ResponseBody
	public Optional<College> getCollege(@PathVariable("cid") int cid)
	{
		return cService.getCollege(cid);
	}
	
	
	
}
