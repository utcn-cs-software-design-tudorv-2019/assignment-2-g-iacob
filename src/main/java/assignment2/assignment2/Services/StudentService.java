package assignment2.assignment2.Services;

import java.util.Optional;

import assignment2.assignment2.Entities.Student;

public interface StudentService {
	Optional<Student> findStudentById(Integer id);
	Optional<Student> findStudentByName(String name);
}
