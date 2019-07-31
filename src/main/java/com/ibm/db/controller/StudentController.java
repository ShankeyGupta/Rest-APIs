package com.ibm.db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.db.model.College;
import com.ibm.db.model.Student;
import com.ibm.db.service.CollegeService;
import com.ibm.db.service.StudentService;


//@Controller
@RestController
public class StudentController 
{
	@Autowired
	StudentService sService;
	@Autowired
	CollegeService cService;
	
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student)
	{
		return sService.addStudent(student);
	}
	
	
	@DeleteMapping("/student/{sid}")
	public String deleteStudent(@PathVariable int sid )
	{
		return sService.deleteStudent(sid);
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return sService.getStudents();
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student)
	{
		return sService.updateStudent(student);
	}
	
	@PutMapping("/student/{sid}/college/{cid}")
	public Student UpdateCollegeOfStudent(@PathVariable int sid, @PathVariable int cid)
	{
		return sService.UpdateCollegeOfStudent(sid,cid);
	}
	
	@RequestMapping("/student/{sid}")
	//@ResponseBody
	public Optional<Student> getStudent(@PathVariable("sid") int sid)
	{
		return sService.getStudent(sid);
	}
	
	
	
}
