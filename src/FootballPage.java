import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



public class FootballPage extends JFrame {

	private JPanel contentPane;
	
	private JTextField locationInp;
	private JTextField capacityInp;
	private JTextField idInp;
	private JTextField openingInp;
	private JTextField closingInp;
	private JTextField teamSizeInp;
	private JTextField pitchSizeInp;
	

	private HomePage hp = null;
	FootballCoursesPage cp = new FootballCoursesPage(this);
	private JTextField removeFacInp;
	private JTextField AddResFacIdInp;
	private JTextField addResNameInp;
	private JTextField addResYourIdInp;
	private JTextField AddResTimeInp;
	
	private JTextField removeResFacIdInp;
	private JTextField removeResNameInp;
	private JTextField removeResYourIdInp;
	private JTextField removeResTimeInp;
	
	
	
	
	
	public FootballPage(HomePage hp) {
		this.hp=hp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(10, 56, 969, 287);
		contentPane.add(displayPanel);
		displayPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 957, 254);
		displayPanel.add(scrollPane);
		
		JTextArea displayFacTa = new JTextArea();
		scrollPane.setViewportView(displayFacTa);
		
		
		JPanel addPanel = new JPanel();
		addPanel.setBounds(10, 55, 969, 265);
		contentPane.add(addPanel);
		addPanel.setVisible(false);
		addPanel.setLayout(null);



		JLabel locationLbl = new JLabel("Location : ");
		locationLbl.setBounds(109, 40, 78, 16);
		addPanel.add(locationLbl);
		
		locationInp = new JTextField();
		locationInp.setBounds(237, 35, 130, 26);
		addPanel.add(locationInp);
		locationInp.setColumns(10);

		JLabel isIndoorLbl = new JLabel("Is Indoor : ");
		isIndoorLbl.setBounds(109, 76, 78, 16);
		addPanel.add(isIndoorLbl);
		
		JCheckBox indoorCheck = new JCheckBox("Yes");
		indoorCheck.setBounds(239, 72, 128, 23);
		addPanel.add(indoorCheck);

		JLabel capacityLbl = new JLabel("Capacity : ");
		capacityLbl.setBounds(109, 109, 78, 16);
		addPanel.add(capacityLbl);
		
		capacityInp = new JTextField();
		capacityInp.setBounds(237, 104, 130, 26);
		capacityInp.setColumns(10);
		addPanel.add(capacityInp);

		JLabel availableLbl = new JLabel("Is Available :   ");
		availableLbl.setBounds(109, 137, 99, 16);
		addPanel.add(availableLbl);
		
		JCheckBox availableCheck = new JCheckBox("Yes");
		availableCheck.setBounds(239, 133, 128, 23);
		addPanel.add(availableCheck);
		
		JLabel lightingLbl = new JLabel("Lighting : ");
		lightingLbl.setBounds(552, 40, 78, 16);
		addPanel.add(lightingLbl);
		
		JCheckBox lightingCheck = new JCheckBox("Has");
		lightingCheck.setBounds(615, 37, 128, 23);
		addPanel.add(lightingCheck);


		JLabel idLbl = new JLabel("Facility Id :");
		idLbl.setBounds(109, 175, 78, 16);
		addPanel.add(idLbl);

		idInp = new JTextField();
		idInp.setBounds(237, 170, 130, 26);
		idInp.setColumns(10);
		addPanel.add(idInp);
		
		JLabel openingLbl = new JLabel("Opening : ");
		openingLbl.setBounds(109, 213, 78, 16);
		addPanel.add(openingLbl);

		openingInp = new JTextField();
		openingInp.setBounds(179, 208, 46, 26);
		addPanel.add(openingInp);
		
		JLabel closingLbl = new JLabel("Closing : ");
		closingLbl.setBounds(247, 212, 78, 16);
		addPanel.add(closingLbl);

		closingInp = new JTextField();
		closingInp.setBounds(317, 208, 46, 26);
		addPanel.add(closingInp);
		
		JLabel teamALbl = new JLabel("Team Size:");
		teamALbl.setBounds(552, 77, 72, 14);
		addPanel.add(teamALbl);
		
		JLabel teamBLbl = new JLabel("Pitch Size:");
		teamBLbl.setBounds(552, 110, 72, 14);
		addPanel.add(teamBLbl);
		
		teamSizeInp = new JTextField();
		teamSizeInp.setBounds(615, 74, 130, 20);
		addPanel.add(teamSizeInp);
		teamSizeInp.setColumns(10);
		
		pitchSizeInp = new JTextField();
		pitchSizeInp.setBounds(613, 107, 130, 20);
		pitchSizeInp.setColumns(10);
		addPanel.add(pitchSizeInp);
		
		JLabel resultLbl = new JLabel("");
		resultLbl.setBounds(552, 202, 270, 52);
		addPanel.add(resultLbl);
		
		JButton AddBtn = new JButton("ADD");
		AddBtn.setBounds(552, 172, 89, 23);
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> booked = new ArrayList<>();
				ArrayList<String> inside = new ArrayList<>();
				ArrayList<Course> courses = new ArrayList<>();
				TreeSet<String> rs = new TreeSet<>();
				
				if(teamSizeInp.getText().equals("") || pitchSizeInp.getText().equals("")|| locationInp.getText().equals("") || capacityInp.getText().equals("") ||  openingInp.getText().equals("") || closingInp.getText().equals("") || idInp.getText().equals("")) {
					resultLbl.setText("Fill the necessary fields");
				}
				else {
					Football f = new Football(locationInp.getText(), indoorCheck.isSelected(),
							Integer.parseInt(capacityInp.getText()), openingInp.getText(), closingInp.getText(), availableCheck.isSelected(), booked, lightingCheck.isSelected(), Integer.parseInt(idInp.getText()), inside, courses, rs,pitchSizeInp.getText(),Integer.parseInt(teamSizeInp.getText()));
					SportsFacilitySys.getSportsFacilities().add(f);
					resultLbl.setText("Facility added");
				}
				
				
				
			}
		});
		addPanel.add(AddBtn);
		
		JButton CloseAddFac = new JButton("X");
		CloseAddFac.setBounds(10, 11, 46, 23);
		CloseAddFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(false);
				displayPanel.setVisible(true);
			}
		});
		addPanel.add(CloseAddFac);
		
		JButton AddFacBtn = new JButton("Add Facility");
		AddFacBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(true);
				displayPanel.setVisible(false);
				
				
			}
		});
		AddFacBtn.setBounds(20, 354, 99, 33);
		contentPane.add(AddFacBtn);
		
		
		JPanel removeFacPanel = new JPanel();
		removeFacPanel.setBounds(30, 398, 355, 155);
		contentPane.add(removeFacPanel);
		removeFacPanel.setVisible(false);
		
		JButton RemoveFacBtn_1 = new JButton("Remove Facility");
		RemoveFacBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFacPanel.setVisible(true);
				
			}
		});
		RemoveFacBtn_1.setBounds(129, 354, 147, 33);
		contentPane.add(RemoveFacBtn_1);
		
	
		
		JButton closeRemoveFac = new JButton("X");
		closeRemoveFac.setBounds(10, 11, 51, 23);
		closeRemoveFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFacPanel.setVisible(false);
				
			}
		});
		removeFacPanel.setLayout(null);
		removeFacPanel.add(closeRemoveFac);
		
		JLabel removeFacLbl = new JLabel("Facility Id To Remove:");
		removeFacLbl.setBounds(10, 45, 129, 23);
		removeFacPanel.add(removeFacLbl);
		
		removeFacInp = new JTextField();
		removeFacInp.setBounds(149, 46, 162, 20);
		removeFacPanel.add(removeFacInp);
		removeFacInp.setColumns(10);
		
		JLabel removeLbl = new JLabel("");
		removeLbl.setBounds(130, 111, 215, 23);
		removeFacPanel.add(removeLbl);
		
		JButton removeFacBtn = new JButton("REMOVE");
		removeFacBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean removed = SportsFacilitySys.getSportsFacilities().removeIf(
					    sf -> sf.getFacilityId() == Integer.parseInt(removeFacInp.getText())
					);

					if (removed) {
					    removeLbl.setText("Facility removed");
					} else {
					    removeLbl.setText("No facility with the given ID");
					}
				}
			}
		);
		removeFacBtn.setBounds(10, 79, 89, 23);
		removeFacPanel.add(removeFacBtn);
		
		
		
		JPanel addResPanel = new JPanel();
		addResPanel.setBounds(30, 398, 376, 186);
		contentPane.add(addResPanel);
		addResPanel.setLayout(null);
		addResPanel.setVisible(false);
		
		JButton addReservationBtn = new JButton("Add Reservation");
		addReservationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addResPanel.setVisible(true);
			}
		});
		addReservationBtn.setBounds(286, 354, 147, 33);
		contentPane.add(addReservationBtn);
		
		
		
		JLabel FacResIdLbl = new JLabel("Facility Id To Reserve:");
		FacResIdLbl.setBounds(20, 45, 205, 24);
		addResPanel.add(FacResIdLbl);
		
		JButton closeAddRes = new JButton("X");
		closeAddRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addResPanel.setVisible(false);
			}
		});
		closeAddRes.setBounds(10, 11, 49, 24);
		addResPanel.add(closeAddRes);
		
		JLabel FacResNameLbl = new JLabel("Name:");
		FacResNameLbl.setBounds(20, 73, 205, 24);
		addResPanel.add(FacResNameLbl);
		
		JLabel lblYourId = new JLabel("Your Id:");
		lblYourId.setBounds(20, 103, 205, 24);
		addResPanel.add(lblYourId);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(20, 135, 205, 24);
		addResPanel.add(lblTime);
		
		JLabel addResLbl = new JLabel("");
		addResLbl.setBounds(20, 166, 125, 14);
		addResPanel.add(addResLbl);
		
		AddResFacIdInp = new JTextField();
		AddResFacIdInp.setBounds(146, 47, 165, 20);
		addResPanel.add(AddResFacIdInp);
		AddResFacIdInp.setColumns(10);
		
		addResNameInp = new JTextField();
		addResNameInp.setColumns(10);
		addResNameInp.setBounds(146, 75, 165, 20);
		addResPanel.add(addResNameInp);
		
		addResYourIdInp = new JTextField();
		addResYourIdInp.setColumns(10);
		addResYourIdInp.setBounds(146, 105, 165, 20);
		addResPanel.add(addResYourIdInp);
		
		AddResTimeInp = new JTextField();
		AddResTimeInp.setColumns(10);
		AddResTimeInp.setBounds(146, 137, 165, 20);
		addResPanel.add(AddResTimeInp);
		
		JButton reserveBtn = new JButton("RESERVE");
		reserveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AddResFacIdInp.getText().isEmpty() || addResNameInp.getText().isEmpty() || addResYourIdInp.getText().isEmpty() || AddResTimeInp.getText().isEmpty()) {
					addResLbl.setText("Fill all the fields");
				}
				else {
					SportsFacilitySys.reserveFacility(Integer.parseInt( AddResFacIdInp.getText()),addResNameInp.getText(),addResYourIdInp.getText(),AddResTimeInp.getText());
					addResLbl.setText("Facility reserved");
				}
			}
		});
		reserveBtn.setBounds(178, 160, 125, 26);
		addResPanel.add(reserveBtn);
		

		
		JPanel removeResPanel = new JPanel();
		removeResPanel.setBounds(30, 398, 376, 210);
		contentPane.add(removeResPanel);
		removeResPanel.setLayout(null);
		removeResPanel.setVisible(false);
		
		JButton removeResBtn = new JButton("Remove Reservation");
		removeResBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeResPanel.setVisible(true);
			}
		});
		removeResBtn.setBounds(437, 354, 153, 33);
		contentPane.add(removeResBtn);
		
		
		
		
		JButton closeRemoveRes = new JButton("X");
		closeRemoveRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeResPanel.setVisible(false);
			}
		});
		closeRemoveRes.setSize(49, 24);
		closeRemoveRes.setLocation(10, 11);
		closeAddRes.setBounds(10, 11, 49, 24);
		removeResPanel.add(closeRemoveRes);
		
		JLabel FacRemoveResIdLbl = new JLabel("Facility Id to Remove:");
		FacRemoveResIdLbl.setSize(205, 24);
		FacRemoveResIdLbl.setLocation(20, 45);
		FacResIdLbl.setBounds(20, 45, 205, 24);
		removeResPanel.add(FacRemoveResIdLbl);
		
		JLabel FacRemoveResNameLbl = new JLabel("Name:");
		FacRemoveResNameLbl.setSize(205, 24);
		FacRemoveResNameLbl.setLocation(20, 73);
		FacResNameLbl.setBounds(20, 73, 205, 24);
		removeResPanel.add(FacRemoveResNameLbl);
		
		JLabel RemlblYourId = new JLabel("Your Id:");
		RemlblYourId.setSize(205, 24);
		RemlblYourId.setLocation(20, 103);
		lblYourId.setBounds(20, 103, 205, 24);
		removeResPanel.add(RemlblYourId);
		
		JLabel RemlblTime = new JLabel("Time:");
		RemlblTime.setSize(205, 24);
		RemlblTime.setLocation(20, 135);
		lblTime.setBounds(20, 135, 205, 24);
		removeResPanel.add(RemlblTime);
		
		JLabel RemoveResLbl = new JLabel("");
		RemoveResLbl.setBounds(20, 170, 125, 16);
		removeResPanel.add(RemoveResLbl);
		
		removeResFacIdInp = new JTextField();
		removeResFacIdInp.setBounds(146, 47, 165, 20);
		removeResPanel.add(removeResFacIdInp);
		removeResFacIdInp.setColumns(10);
		
		removeResNameInp = new JTextField();
		removeResNameInp.setColumns(10);
		removeResNameInp.setBounds(146, 75, 165, 20);
		removeResPanel.add(removeResNameInp);
		
		removeResYourIdInp = new JTextField();
		removeResYourIdInp.setColumns(10);
		removeResYourIdInp.setBounds(146, 105, 165, 20);
		removeResPanel.add(removeResYourIdInp);
		
		removeResTimeInp = new JTextField();
		removeResTimeInp.setColumns(10);
		removeResTimeInp.setBounds(146, 137, 165, 20);
		removeResPanel.add(removeResTimeInp);
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(removeResFacIdInp.getText().isEmpty() || removeResNameInp.getText().isEmpty() || removeResYourIdInp.getText().isEmpty() || removeResTimeInp.getText().isEmpty()) {
					RemoveResLbl.setText("Fill all the fields");
				}
				else {
					SportsFacilitySys.deleteReservation(AddResTimeInp.getText(),Integer.parseInt( AddResFacIdInp.getText()),addResNameInp.getText(),addResYourIdInp.getText());
					RemoveResLbl.setText("Reservation removed");
				}
			}
		});
		removeBtn.setBounds(178, 160, 125, 26);
		removeResPanel.add(removeBtn);
		
		
		
		JTextArea scheduleTa = new JTextArea();
		scheduleTa.setBounds(544, 398, 435, 235);
		contentPane.add(scheduleTa);
		
		JButton displayScheduleBtn = new JButton("Display Schedule");
		displayScheduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String res="";
				for(SportsFacility f:SportsFacilitySys.getSportsFacilities()) {
					if(f instanceof Football) {
						if(f.displayUpcomingReservations().size()!=0)
						res+=f.displayUpcomingReservations() +"\n";
					}
				}
				scheduleTa.setText(res);
				
			}
		});
		displayScheduleBtn.setBounds(826, 634, 153, 33);
		contentPane.add(displayScheduleBtn);
		
		JButton HomeBtn = new JButton("Home");
		HomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				hp.setVisible(true);
			}
		});
		HomeBtn.setBounds(855, 11, 124, 33);
		contentPane.add(HomeBtn);
		
		JButton courseBtn = new JButton("Courses");
		courseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.setVisible(true);
				setVisible(false);
				
			}
		});
		courseBtn.setBounds(600, 354, 124, 33);
		contentPane.add(courseBtn);
		
		JButton displayFac = new JButton("Display Facilities");
		displayFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res="";
				for(SportsFacility f:SportsFacilitySys.getSportsFacilities()) {
					if(f instanceof Football) {
							res+=f.toString() +"\n\n";
					}
				}
				displayFacTa.setText(res);
				
			}
		});
		displayFac.setBounds(855, 354, 124, 33);
		contentPane.add(displayFac);
		
		
		
		
		
		
		
		
	}
}