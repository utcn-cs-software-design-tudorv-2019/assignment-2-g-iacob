package assignment2.assignment2.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment2.assignment2.Controllers.StudentController;
import assignment2.assignment2.Entities.Course;
import assignment2.assignment2.Entities.Enrolment;
import assignment2.assignment2.Entities.Student;
import assignment2.assignment2.Services.CourseService;
import assignment2.assignment2.Services.EnrolmentService;
import assignment2.assignment2.Services.StudentService;

@Component
public class LoginInterface extends JFrame {

	private JPanel loginPane;
	private JPanel studentPane;
	private JPanel adminPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	@Autowired
	StudentController studentController;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	EnrolmentService enrolmentService;
	
	private JPasswordField passwordField;

	public LoginInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginPane.setLayout(null);
		setContentPane(loginPane);
		
		JTextPane usernameTextField = new JTextPane();
		usernameTextField.setBounds(138, 60, 200, 30);
		loginPane.add(usernameTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 120, 200, 30);
		loginPane.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTextField.getText();
				if (username.equals("admin")) {
					setBounds(100, 100, 900, 600);
					loginPane.setVisible(false);
					setContentPane(getAdminPane());
				}
				else if (studentController.validLogin(username)) {
					setBounds(100, 100, 900, 600);
					loginPane.setVisible(false);
					setContentPane(getStudentPane());
				}
					
			}
		});
		loginButton.setBounds(170, 180, 97, 25);
		loginPane.add(loginButton);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(90, 60, 36, 30);
		loginPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(90, 120, 36, 30);
		loginPane.add(lblPass);
		
		this.setVisible(true);
	}
	
	private JPanel getStudentPane() {
		studentPane = new JPanel();
		studentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		studentPane.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(170, 180, 97, 25);
		studentPane.add(loginButton);

		
		return studentPane;
	}
	
	private JPanel getAdminPane() {
		adminPane = new JPanel();
		adminPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		adminPane.setLayout(null);
		
		JButton viewStudentsButton = new JButton("View Students");
		viewStudentsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("NAME");
				model.addColumn("CNP");
				model.addColumn("GROUP");
				
				for (Student student : studentService.getStudents()) {
					//System.out.println(student.getId());
					model.addRow(new Object[]{student.getId(), student.getName(), student.getCnp(), student.getGr()});
				}
				table = new JTable(model);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(400, 100, 300, 400);
				table.setVisible(true);
				adminPane.add(scrollPane);
				
			}
		});
		viewStudentsButton.setBounds(0, 0, 200, 50);
		adminPane.add(viewStudentsButton);
		
		JButton viewCoursesButton = new JButton("View Courses");
		viewCoursesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("NAME");
				model.addColumn("TUTOR");
				model.addColumn("EXAM DATE");
				
				for (Course course : courseService.getCourses()) {
					//System.out.println(student.getId());
					model.addRow(new Object[]{course.getId(), course.getName(), course.getTutor_name(), course.getExam_date()});
				}
				table = new JTable(model);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(400, 100, 300, 400);
				table.setVisible(true);
				adminPane.add(scrollPane);
				
			}
		});
		viewCoursesButton.setBounds(0, 50, 200, 50);
		adminPane.add(viewCoursesButton);

		JButton viewEnrolmentsButton = new JButton("View Enrolments");
		viewEnrolmentsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("ID");
				model.addColumn("STUDENT");
				model.addColumn("COURSE");
				model.addColumn("GRADE");
				
				for (Enrolment enrolment : enrolmentService.getEnrolments()) {
					//System.out.println(enrolment.getId());
					model.addRow(new Object[]{enrolment.getId(), enrolment.getStudent().getName(), 
							enrolment.getCourse().getName(), enrolment.getGrade()});
				}
				table = new JTable(model);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(400, 100, 300, 400);
				table.setVisible(true);
				adminPane.add(scrollPane);
				
			}
		});
		viewEnrolmentsButton.setBounds(0, 100, 200, 50);
		adminPane.add(viewEnrolmentsButton);
		
		JButton insertButton = new JButton("Insert Test");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentController.insertTest();
			}
		});
		insertButton.setBounds(0, 200, 200, 50);
		adminPane.add(insertButton);
		
		JButton deleteButton = new JButton("Delete Test");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentController.deleteTest();
			}
		});
		deleteButton.setBounds(0, 250, 200, 50);
		adminPane.add(deleteButton);

		
		return adminPane;
	}
}

