package assignment2.assignment2.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import assignment2.assignment2.Entities.Student;
import assignment2.assignment2.Services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	public String test(){
		Optional<Student> student = studentService.findStudentById(1); 
		if(student.isPresent())
			return student.get().getName();
		else
			return "ERROR 404: Student not found";
	}
	
	public boolean validLogin(String name) {
		return studentService.findStudentByName(name).isPresent();
	}
	
	public void insertTest() {
		Student student = new Student();
		student.setName("TestIF");
		studentService.insertStudent(student);
	}
	
	public void deleteTest() {
		try {
			studentService.deleteStudentById(1);
		}
		catch (Exception e) {
			// no student with given ID
		}
		
	}
}
