package assignment2.assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import assignment2.assignment2.Controllers.StudentController;
import assignment2.assignment2.View.LoginInterface;

@SpringBootApplication
public class Assignment2Application {

	@Autowired
	StudentController studentController;
	
	public static void main(String[] args) {
	    ConfigurableApplicationContext context = new SpringApplicationBuilder(Assignment2Application.class).headless(false).run(args);
	    LoginInterface loginInterface = context.getBean(LoginInterface.class);
	    
	    
	}
}
