package assignment2.assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import assignment2.assignment2.Controllers.StudentController;
import assignment2.assignment2.Services.StudentService;
import assignment2.assignment2.View.LoginInterface;
import javafx.application.*;
import javafx.stage.Stage;

@SpringBootApplication
public class Assignment2Application extends Application implements CommandLineRunner {

	@Autowired
	StudentController studentController;

	private static ConfigurableApplicationContext springContext;
	
	public static void main(String[] args) {
		springContext = SpringApplication.run(Assignment2Application.class, args);
		System.out.println(springContext);
	}
	
	@Override
	public void run(String... args) {
		System.out.println(studentController.test());
		//this.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println(studentController.test());
	}
}
