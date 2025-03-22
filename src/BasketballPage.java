import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class BasketballPage extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField facilityidtf;
	private JTextField nametf;
	private JTextField stuidtf;
	private JTextField timetf;
	private JTextField searchfacilitytf;
	private ImageIcon logoImg = new ImageIcon(getClass().getResource("/images/logo.png"));
	private JTextField removetf;


	/**
	 * Create the frame.
	 */

	public BasketballPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1168, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1100, 240);
		contentPane.add(scrollPane);
		JLabel logo = new JLabel("");
		logo.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		logo.setIcon(logoImg);
		logo.setBounds(6, 6, 178, 80);
		contentPane.add(logo);

		JLabel uniName = new JLabel("Bilkent University ");
		uniName.setForeground(new Color(1, 74, 150));
		uniName.setFont(new Font("Beirut", Font.PLAIN, 20));
		uniName.setBounds(95, 33, 203, 29);
		contentPane.add(uniName);
		
		JLabel lblNewLabel = new JLabel("Sport Facility Management System");
		lblNewLabel.setForeground(new Color(225, 0, 26));
		lblNewLabel.setFont(new Font("Beirut", Font.PLAIN, 13));
		lblNewLabel.setBounds(94, 55, 283, 21);
		contentPane.add(lblNewLabel);
		
		
		


		String res="";
		res+= 	"Facility ID\tLocation\tIs indoor\tCapacity\tOpening-Closing Hour\tIs available\tLighting Availability\tFloor Type\tHoop Height\tTeam Size\tBall Availability\n\n";

		for(SportsFacility sf:SportsFacilitySys.getSportsFacilities()) {

			if(sf instanceof Basketball) {
				res+=
						sf.getFacilityId() +"\t"
						+sf.getLocation() +"\t"
						 + sf.isIndoor() +"\t"
						 + sf.getCapacity() +"\t"
						+sf.getOpeningHour()+":00 - " +sf.getClosingHour()+":00"+ "\t\t"
						+ sf.isAvailable() +"\t"
						 +sf.isLightingAvailability() +"\t\t"
						 +((Basketball)sf).getFloorType() +"\t"
						+ ((Basketball)sf).getHoopHeight() + "\t"
						+ ((Basketball)sf).getTeamSize() +"\t"
						 + ((Basketball)sf).isBallAvailability() +"\n\n\n\n";

			
			
			
			}
		}
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(res);
		
		
		
		JButton btnNewButton = new JButton("Return Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(971, 10, 151, 30);
		contentPane.add(btnNewButton);
		
		JLabel reservelabel = new JLabel("");
		reservelabel.setBounds(10, 515, 417, 13);
		contentPane.add(reservelabel);
		
		JButton btnNewButton_1 = new JButton("Make reservation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(facilityidtf.getText().isEmpty() || nametf.getText().isEmpty() || stuidtf.getText().isEmpty() || timetf.getText().isEmpty()) {
					reservelabel.setText("Fill al the fields");
				}
				else {
				if(SportsFacilitySys.reserveFacility(Integer.parseInt(facilityidtf.getText()), nametf.getText(), stuidtf.getText(), timetf.getText())) {
					reservelabel.setText("Reservation complete");
				}
				else {
					reservelabel.setText("Reservation is NOT complete");
				}
				}
			}
		});
		btnNewButton_1.setBounds(262, 372, 118, 37);
		contentPane.add(btnNewButton_1);
		
		facilityidtf = new JTextField();
		facilityidtf.setBounds(124, 372, 96, 19);
		contentPane.add(facilityidtf);
		facilityidtf.setColumns(10);
		
		nametf = new JTextField();
		nametf.setBounds(124, 401, 96, 19);
		contentPane.add(nametf);
		nametf.setColumns(10);
		
		stuidtf = new JTextField();
		stuidtf.setBounds(124, 437, 96, 19);
		contentPane.add(stuidtf);
		stuidtf.setColumns(10);
		
		timetf = new JTextField();
		timetf.setBounds(124, 467, 96, 19);
		contentPane.add(timetf);
		timetf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("facility id:");
		lblNewLabel_1.setBounds(50, 375, 74, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("name:");
		lblNewLabel_2.setBounds(50, 404, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("student id:");
		lblNewLabel_3.setBounds(50, 440, 64, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("time:");
		lblNewLabel_4.setBounds(50, 470, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Delete reservation");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(facilityidtf.getText().isEmpty() || nametf.getText().isEmpty() || stuidtf.getText().isEmpty() || timetf.getText().isEmpty()) {
					reservelabel.setText("Fill al the fields");
				}
				else
				reservelabel.setText(SportsFacilitySys.deleteReservation(timetf.getText(),Integer.parseInt(facilityidtf.getText()),nametf.getText(), stuidtf.getText()));
				
			}
		});
		btnNewButton_2.setBounds(262, 419, 118, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Display Outdoor Facilities");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res="";
				for(SportsFacility b:SportsFacilitySys.getSportsFacilities()) {
					if(b instanceof Basketball) {
						if(!b.isIndoor()) {
							res+=b.toString() +"\n\n";
						}
					}
				}
				
				textArea.setText(res);
			}
		});
		btnNewButton_3.setBounds(418, 372, 151, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Display Indoor Facilities");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res="";
				for(SportsFacility b:SportsFacilitySys.getSportsFacilities()) {
					if(b instanceof Basketball) {
						if(b.isIndoor()) {
							res+=b.toString() +"\n\n";
						}
					}
				}
				textArea.setText(res);
			}
		});
		btnNewButton_4.setBounds(418, 419, 151, 37);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Display All");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res="";
				for(SportsFacility b:SportsFacilitySys.getSportsFacilities()) {
					if(b instanceof Basketball) {
							res+=b.toString() +"\n\n";
					}
				}
				textArea.setText(res);
				
			}
		});
		btnNewButton_5.setBounds(418, 468, 151, 37);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Search Facility by ID");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SportsFacility sf = SportsFacilitySys.searchFacilityById(Integer.parseInt(searchfacilitytf.getText()));
				if(sf!=null) {
					textArea.setText(sf.toString());
				}
				else {
					textArea.setText("There is not a facility with the given id");
				}
				
				
			}
		});
		btnNewButton_6.setBounds(579, 372, 151, 37);
		contentPane.add(btnNewButton_6);
		
		searchfacilitytf = new JTextField();
		searchfacilitytf.setBounds(764, 381, 108, 19);
		contentPane.add(searchfacilitytf);
		searchfacilitytf.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("Display Courses");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res="";
				for(SportsFacility b:SportsFacilitySys.getSportsFacilities()) {
					if(b instanceof Basketball) {
						res+= b.getFacilityId()+"\n" + b.getCourses() +"\n";
					}
				}
				textArea.setText(res);
				
			}
		});
		btnNewButton_7.setBounds(922, 419, 154, 37);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Display Schedule");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String res="";
				for(SportsFacility b:SportsFacilitySys.getSportsFacilities()) {
					if(b instanceof Basketball) {
						if(b.displayUpcomingReservations().size()!=0)
						res+=b.getFacilityId()+"\n"+ b.displayUpcomingReservations() +"\n\n";
					}
				}
			textArea.setText(res);
			}
		});
		btnNewButton_8.setBounds(922, 372, 154, 37);
		contentPane.add(btnNewButton_8);
		JLabel removelabel = new JLabel("");
		removelabel.setBounds(615, 479, 259, 13);
		contentPane.add(removelabel);
		
		JButton btnNewButton_9 = new JButton("Remove facility by ID");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int i=0;
				while(SportsFacilitySys.getSportsFacilities().get(i).getFacilityId()!=Integer.parseInt(removetf.getText())) {
					i++;
				}
				SportsFacility sf =SportsFacilitySys.getSportsFacilities().get(i);
				SportsFacilitySys.getSportsFacilities().remove(sf);
				removelabel.setText("Facility removed");
				
				for(SportsFacility sf:SportsFacilitySys.getSportsFacilities()) {
					if(sf.getFacilityId()==Integer.parseInt(removetf.getText())) {
						SportsFacilitySys.getSportsFacilities().remove(sf);
						removelabel.setText("Facility removed");
					}
					else {
						removelabel.setText("No facility with the given id");
					}
				}*/
				boolean removed = SportsFacilitySys.getSportsFacilities().removeIf(
					    sf -> sf.getFacilityId() == Integer.parseInt(removetf.getText())
					);

					if (removed) {
					    removelabel.setText("Facility removed");
					} else {
					    removelabel.setText("No facility with the given ID");
					}
			}
		});
		btnNewButton_9.setBounds(579, 419, 151, 37);
		contentPane.add(btnNewButton_9);
		
		removetf = new JTextField();
		removetf.setBounds(764, 428, 108, 19);
		contentPane.add(removetf);
		removetf.setColumns(10);
		
		JButton btnNewButton_10 = new JButton("Add Facility");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFacilityBasketball frame = new AddFacilityBasketball();
				frame.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(922, 468, 154, 37);
		contentPane.add(btnNewButton_10);
		
		
		
		
		
		
		

		
		
		
	}
}
