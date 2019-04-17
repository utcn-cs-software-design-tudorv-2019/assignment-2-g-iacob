package assignment2.assignment2.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment2.assignment2.Controllers.StudentController;
import javax.swing.JTextPane;

@Component
public class LoginInterface extends JFrame {

	private JPanel contentPane;
	
	@Autowired
	StudentController studentController;

	public LoginInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextPane usernameTextField = new JTextPane();
		usernameTextField.setBounds(111, 58, 200, 30);
		contentPane.add(usernameTextField);
		
		this.setVisible(true);
	}
}
