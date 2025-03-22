import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class FootballCoursesPage extends JFrame {

	private JPanel contentPane;
	private FootballPage fp = null;
	private JTextField capacityInp;
	private JTextField nameInp;
	private JTextField IdInp;
	private JTextField CapacityInp;
	private JTextField NameInp;
	private JTextField removeInp;
	
	
	public FootballCoursesPage(FootballPage fp) {
		this.fp = fp;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton footballPageBtn = new JButton("FootballPage");
		footballPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setVisible(true);
				setVisible(false);
			}
		});
		footballPageBtn.setBounds(767, 11, 147, 30);
		contentPane.add(footballPageBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 39, 829, 175);
		contentPane.add(scrollPane);
		
		JTextArea coursesTa = new JTextArea();
		scrollPane.setViewportView(coursesTa);
		
		JButton dispCoursesBtn = new JButton("Display Courses");
		dispCoursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursesTa.setText(SportsFacilitySys.displayCourses());
			}
		});
		dispCoursesBtn.setBounds(746, 211, 147, 30);
		contentPane.add(dispCoursesBtn);
		
		JPanel addCPanel = new JPanel();
		addCPanel.setBounds(60, 245, 324, 130);
		contentPane.add(addCPanel);
		addCPanel.setLayout(null);
		addCPanel.setVisible(false);
		
		JButton addCourseBtn = new JButton("Add Course");
		addCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCPanel.setVisible(true);
			}
		});
		addCourseBtn.setBounds(62, 211, 147, 30);
		contentPane.add(addCourseBtn);
		
		JPanel removeCPanel = new JPanel();
		removeCPanel.setLayout(null);
		removeCPanel.setBounds(60, 252, 324, 144);
		contentPane.add(removeCPanel);
		removeCPanel.setVisible(false);
		
		JButton RemoveCourseBtn = new JButton("Remove Course");
		RemoveCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCPanel.setVisible(true);
			}
		});
		RemoveCourseBtn.setBounds(219, 211, 147, 30);
		contentPane.add(RemoveCourseBtn);
		
		
		
		JLabel lblNewLabel = new JLabel("Course Name:");
		lblNewLabel.setBounds(10, 14, 81, 14);
		addCPanel.add(lblNewLabel);
		
		JLabel lblCourseCapacity = new JLabel("Course Capacity:");
		lblCourseCapacity.setBounds(10, 45, 96, 14);
		addCPanel.add(lblCourseCapacity);
		
		JLabel lblFacilityId = new JLabel("Facility Id:");
		lblFacilityId.setBounds(10, 70, 96, 14);
		addCPanel.add(lblFacilityId);
		
		capacityInp = new JTextField();
		capacityInp.setColumns(10);
		capacityInp.setBounds(116, 42, 86, 20);
		addCPanel.add(capacityInp);
		
		nameInp = new JTextField();
		nameInp.setColumns(10);
		nameInp.setBounds(116, 11, 86, 20);
		addCPanel.add(nameInp);
		
		IdInp = new JTextField();
		IdInp.setColumns(10);
		IdInp.setBounds(116, 67, 86, 20);
		addCPanel.add(IdInp);
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Football f = (Football)SportsFacilitySys.searchFacilityById(Integer.parseInt(IdInp.getText()));
				
				if(f != null) {
					Course c = new Course(nameInp.getText(), capacityInp.getText() , 0.0);
					SportsFacilitySys.calculateCourseFee(c);
					f.getCourses().add(c);
				}
				
			}
		});
		addBtn.setBounds(225, 96, 89, 23);
		addCPanel.add(addBtn);
		
		JButton closeAdd = new JButton("X");
		closeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCPanel.setVisible(false);
			}
		});
		closeAdd.setBounds(275, 10, 39, 23);
		addCPanel.add(closeAdd);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setBounds(10, 14, 81, 14);
		removeCPanel.add(lblNewLabel_1);
		
		JLabel lblCourseCapacity_1 = new JLabel("Course Capacity:");
		lblCourseCapacity_1.setBounds(10, 45, 96, 14);
		removeCPanel.add(lblCourseCapacity_1);
		
		JLabel lblFacilityId_1 = new JLabel("Facility Id:");
		lblFacilityId_1.setBounds(10, 70, 96, 14);
		removeCPanel.add(lblFacilityId_1);
		
		CapacityInp = new JTextField();
		CapacityInp.setColumns(10);
		CapacityInp.setBounds(116, 42, 86, 20);
		removeCPanel.add(CapacityInp);
		
		NameInp = new JTextField();
		NameInp.setColumns(10);
		NameInp.setBounds(116, 11, 86, 20);
		removeCPanel.add(NameInp);
		
		removeInp = new JTextField();
		removeInp.setColumns(10);
		removeInp.setBounds(116, 67, 86, 20);
		removeCPanel.add(removeInp);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Football f = (Football)SportsFacilitySys.searchFacilityById(Integer.parseInt(removeInp.getText()));

				if(f != null) {
					Course c = SportsFacilitySys.searchCourseByName(NameInp.getText());
					f.courses.remove(c);
			}
			}	
		});
		btnRemove.setBounds(225, 96, 89, 23);
		removeCPanel.add(btnRemove);
		
		JButton closeRemove = new JButton("X");
		closeRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCPanel.setVisible(false);
			}
		});
		closeRemove.setBounds(275, 0, 39, 23);
		removeCPanel.add(closeRemove);
		
		
	}

}