import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddFacilityBasketball extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFacilityBasketball frame = new AddFacilityBasketball();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddFacilityBasketball() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1249, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Location,is Indoor(true/false),Capacity,Opening,Closing Hour(Should be whole hour,DON'T write the :00),is Available(true/false),Lighting Availability(true/false),facility ID, floor Type, Hoop Height, TeamSize, Ball Availability(true/false)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(21, 101, 1175, 58);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(21, 182, 1164, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel outputlabel = new JLabel("");
		outputlabel.setBounds(453, 291, 499, 24);
		contentPane.add(outputlabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] arr = textField.getText().split(",");
				ArrayList<String> booked = new ArrayList<>();
				ArrayList<String> inside = new ArrayList<>();
				TreeSet<String> rs = new TreeSet<>();
				ArrayList<Course> courses = new ArrayList<>();
				courses.add(new Course("Basketball","20",450));
				
				if(arr.length==12) {
				SportsFacility newFacility = new Basketball(arr[0],Boolean.parseBoolean(arr[1]),Integer.parseInt(arr[2]),arr[3],arr[4],Boolean.parseBoolean(arr[5]),booked,Boolean.parseBoolean(arr[6]),Integer.parseInt(arr[7]),inside,courses,rs,arr[8],Double.parseDouble(arr[9]),Integer.parseInt(arr[10]),Boolean.parseBoolean(arr[11]));
				
				if(SportsFacilitySys.addFacility(newFacility)) {
					outputlabel.setText("Addition is completed succesfully");
					textField.setText("");
					
					
				}
				else {
					outputlabel.setText("Could not add the facility(check if id is unique");
				}}
				else {
					outputlabel.setText("Could not add the facility(check if you entered all the necessary inputs)");
				}
				
				
		
				
				
			}
			
		});
		btnNewButton.setBounds(564, 249, 116, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BasketballPage frame = new BasketballPage();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1031, 41, 129, 32);
		contentPane.add(btnNewButton_1);
		
		
	}
}
