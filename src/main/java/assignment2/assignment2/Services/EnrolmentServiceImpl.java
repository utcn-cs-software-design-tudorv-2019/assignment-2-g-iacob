package assignment2.assignment2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.assignment2.Repositories.EnrolmentRepository;

@Service
public class EnrolmentServiceImpl {

	@Autowired
	EnrolmentRepository enrolmentRepository;
}
