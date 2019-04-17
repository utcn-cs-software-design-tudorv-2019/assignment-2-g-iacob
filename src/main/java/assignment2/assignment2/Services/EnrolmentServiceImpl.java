package assignment2.assignment2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.assignment2.Entities.Enrolment;
import assignment2.assignment2.Repositories.EnrolmentRepository;

@Service
public class EnrolmentServiceImpl implements EnrolmentService{

	@Autowired
	EnrolmentRepository enrolmentRepository;
	
	public Iterable<Enrolment> getEnrolments(){
		return enrolmentRepository.findAll();
	}
}
