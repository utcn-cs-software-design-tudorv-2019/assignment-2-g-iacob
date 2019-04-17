package assignment2.assignment2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.assignment2.Entities.Course;
import assignment2.assignment2.Repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;
	
	public Iterable<Course> getCourses(){
		return courseRepository.findAll();
	}
}
