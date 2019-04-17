package assignment2.assignment2.Services;

import java.util.Optional;

import assignment2.assignment2.Entities.Student;

public interface StudentService {
	public Optional<Student> findStudentById(Integer id);
	public Optional<Student> findStudentByName(String name);
	public void insertStudent(Student student);
	public Iterable<Student> getStudents();
	public void deleteStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudentById(Integer id);
}
