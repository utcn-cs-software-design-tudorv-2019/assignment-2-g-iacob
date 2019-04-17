package assignment2.assignment2.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.assignment2.Entities.Student;
import assignment2.assignment2.Repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	public Optional<Student> findStudentById(Integer id) {
		return studentRepository.findById(id);
	}
	
	public Optional<Student> findStudentByName(String name){
		for (Student student : studentRepository.findAll()) {
			if (name.equals(student.getName()))
				return Optional.of(student);
		}
		return Optional.empty();
	}
	
	public void insertStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Iterable<Student> getStudents(){
		return studentRepository.findAll();
	}

	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
}
