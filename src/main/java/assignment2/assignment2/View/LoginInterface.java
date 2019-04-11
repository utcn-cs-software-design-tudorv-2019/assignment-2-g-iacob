package assignment2.assignment2.View;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment2.assignment2.Services.StudentService;
import javafx.application.*;

import javafx.stage.*;

import javafx.geometry.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


import javafx.event.*;

@Component
public class LoginInterface{
	
	//@Autowired
	//StudentService studentService; 
	
	//public LoginInterface() {}
	
	public void show(StudentService studentService) {
		Stage primaryStage = new Stage();
		
		primaryStage.setTitle("Login");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		grid.add(new Label("User:"), 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		grid.add(new Label("Pass:"), 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	if (userTextField.getText().equals("admin")) {
		    		primaryStage.hide();
		    		System.out.println("eureka");
		    		//new AdminInterface();
		    	} else {
		    		System.out.println(studentService);
		    		/*
		    		if (studentService.findStudentByName(userTextField.getText()).isPresent()) {
		    			primaryStage.hide();
		    			System.out.println("eureka");
		    			//new StudentInterface(rtn);
		    		}
		    		*/
		    	}
		    }
		});
		
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
