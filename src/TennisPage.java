import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class TennisPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon logoImg = new ImageIcon(getClass().getResource("/images/logo.png"));
	private ImageIcon footballImg = new ImageIcon(getClass().getResource("/images/football.png"));
	private ImageIcon footballBanner = new ImageIcon(getClass().getResource("/images/spor10.jpg"));
	private static HomePage hp = new HomePage();
	private int tennisCount = 0;
	private JTextField locationInp;
	private JTextField capacityInp;
	private JTextField idInp;
	private JTextField surfaceInp;
	private JTextField heightInp;





	/**
	 * Create the frame.
	 */
	public TennisPage(HomePage hp) {
		this.hp = hp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 250, 252));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel backgroundPnl = new JPanel();
		backgroundPnl.setBackground(new Color(248, 250, 252));
		backgroundPnl.setForeground(new Color(248, 250, 252));
		backgroundPnl.setBounds(18, 380, 1140, 386);
		contentPane.add(backgroundPnl);
		backgroundPnl.setLayout(null);
		backgroundPnl.setVisible(false);
		

		JPanel addPanel = new JPanel();
		addPanel.setBounds(18, 117, 1140, 265);
		contentPane.add(addPanel);
		addPanel.setLayout(null);
		addPanel.setVisible(false);
		
		
				
				
				JLabel locationLbl = new JLabel("Location : ");
				locationLbl.setBounds(109, 40, 78, 16);
				addPanel.add(locationLbl);
				
				JLabel isIndoorLbl = new JLabel("Is Indoor : ");
				isIndoorLbl.setBounds(109, 76, 78, 16);
				addPanel.add(isIndoorLbl);
				
				JLabel capacityLbl = new JLabel("Capacity : ");
				capacityLbl.setBounds(109, 109, 78, 16);
				addPanel.add(capacityLbl);
				
				JLabel availableLbl = new JLabel("Is Available :   ");
				availableLbl.setBounds(109, 137, 99, 16);
				addPanel.add(availableLbl);
				
				JLabel idLbl = new JLabel("Facility Id :");
				idLbl.setBounds(109, 175, 78, 16);
				addPanel.add(idLbl);
				
				JLabel surfaceLbl = new JLabel("Surface Type : ");
				surfaceLbl.setBounds(648, 40, 92, 16);
				addPanel.add(surfaceLbl);
				
				JLabel lblNewLabel_2_1_4_1_1 = new JLabel("Net Height : ");
				lblNewLabel_2_1_4_1_1.setBounds(648, 76, 92, 16);
				addPanel.add(lblNewLabel_2_1_4_1_1);
				
				JLabel doublesLbl = new JLabel("Is Doubles : ");
				doublesLbl.setBounds(648, 104, 92, 16);
				addPanel.add(doublesLbl);
				
				JLabel racketLbl = new JLabel("Racket : ");
				racketLbl.setBounds(648, 137, 61, 16);
				addPanel.add(racketLbl);
				
				JLabel lightingLbl = new JLabel("Lighting : ");
				lightingLbl.setBounds(648, 175, 78, 16);
				addPanel.add(lightingLbl);
				
				locationInp = new JTextField();
				locationInp.setBounds(237, 35, 130, 26);
				addPanel.add(locationInp);
				locationInp.setColumns(10);
				
				capacityInp = new JTextField();
				capacityInp.setColumns(10);
				capacityInp.setBounds(237, 104, 130, 26);
				addPanel.add(capacityInp);
				
				idInp = new JTextField();
				idInp.setColumns(10);
				idInp.setBounds(237, 170, 130, 26);
				addPanel.add(idInp);
				
				surfaceInp = new JTextField();
				surfaceInp.setColumns(10);
				surfaceInp.setBounds(773, 35, 130, 26);
				addPanel.add(surfaceInp);
				
				heightInp = new JTextField();
				heightInp.setColumns(10);
				heightInp.setBounds(773, 71, 130, 26);
				addPanel.add(heightInp);
				
				JCheckBox indoorCheck = new JCheckBox("Yes");
				indoorCheck.setBounds(239, 72, 128, 23);
				addPanel.add(indoorCheck);
				
				JCheckBox doublesCheck = new JCheckBox("Yes");
				doublesCheck.setBounds(775, 100, 128, 23);
				addPanel.add(doublesCheck);
				
				JCheckBox racketCheck = new JCheckBox("Contains");
				racketCheck.setBounds(775, 133, 128, 23);
				addPanel.add(racketCheck);
				
				JCheckBox lightingCheck = new JCheckBox("Has");
				lightingCheck.setBounds(773, 171, 128, 23);
				addPanel.add(lightingCheck);
				
				JCheckBox availableCheck = new JCheckBox("Yes");
				availableCheck.setBounds(239, 133, 128, 23);
				addPanel.add(availableCheck);
				
				JButton addBtn2 = new JButton("Add");
				addBtn2.setBounds(1017, 218, 117, 29);
				addPanel.add(addBtn2);

		JLabel logo = new JLabel("");
		logo.setBounds(6, 6, 178, 80);
		logo.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		logo.setIcon(logoImg);
		contentPane.add(logo);

		JLabel uniName = new JLabel("Bilkent University ");
		uniName.setBounds(95, 33, 203, 29);
		uniName.setForeground(new Color(1, 74, 150));
		uniName.setFont(new Font("Beirut", Font.PLAIN, 20));
		contentPane.add(uniName);

		JButton HomePage = new JButton("Home Page");
		HomePage.setBounds(1054, 34, 117, 29);
		HomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(HomePage);

		JLabel lblNewLabel = new JLabel("Sport Facility Management System");
		lblNewLabel.setBounds(94, 55, 283, 21);
		lblNewLabel.setForeground(new Color(225, 0, 26));
		lblNewLabel.setFont(new Font("Beirut", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);




		JLabel lblNewLabel_1 = new JLabel("Tennis Courts");
		lblNewLabel_1.setForeground(new Color(226, 21, 45));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(508, 128, 125, 16);
		contentPane.add(lblNewLabel_1);

		
		//delete this when everything finishes
		SportsFacilitySys.init();

		createTable();

		
		JButton closeBtn = new JButton("X");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(false);
				backgroundPnl.setVisible(false);

				
			}
		});
		closeBtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		closeBtn.setBounds(6, 6, 35, 29);
		addPanel.add(closeBtn);
		

		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(6, 250+ 30 * tennisCount, 1180, 12);
		contentPane.add(separator);
		
		JButton addBtn = new JButton("Add Facility");
		addBtn.setForeground(new Color(0, 142, 0));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(true);
				backgroundPnl.setVisible(true);



			}
		});
		addBtn.setBounds(18, 200+ 30 * tennisCount, 125, 29);
		contentPane.add(addBtn);
		
		JButton removeBtn = new JButton("Remove Facility");
		removeBtn.setForeground(new Color(255, 38, 0));
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removeBtn.setBounds(147, 200+ 30 * tennisCount, 151, 29);
		contentPane.add(removeBtn);




	}



	/*
	 *  Create table
	 */


	public void createTable() {

		boolean flag = true;

		for(Object sf : SportsFacilitySys.getSportsFacilities()) {
			if(sf instanceof Tennis) {
				flag = false;
				tennisCount++;
			}
		}

		JPanel courtsPanel = new JPanel();
		courtsPanel.setBounds(18, 156, 1140, 30);
		contentPane.add(courtsPanel);
		courtsPanel.setLayout(null);
		
		
		if(flag) {
			JLabel noTennisCourts = new JLabel("There are no Tennis courts!!");
			noTennisCourts.setBounds(480, 5, 200, 16);
			courtsPanel.add(noTennisCourts);
		}

		else {
			JPanel panel_2_01 = new JPanel();
			panel_2_01.setToolTipText("");
			panel_2_01.setBounds(6, 6, 100, 17);
			courtsPanel.add(panel_2_01);
			panel_2_01.setLayout(null);

			JLabel facilityIdLbl = new JLabel("Facility Id");
			facilityIdLbl.setBounds(17, 0, 61, 16);
			panel_2_01.add(facilityIdLbl);

			JPanel panel_2_1_02 = new JPanel();
			panel_2_1_02.setBounds(118, 6, 100, 17);
			courtsPanel.add(panel_2_1_02);
			panel_2_1_02.setLayout(null);

			JLabel isIndoorLbl = new JLabel("Indoor");
			isIndoorLbl.setBounds(30, 0, 41, 16);
			panel_2_1_02.add(isIndoorLbl);

			JPanel panel_2_1_03 = new JPanel();
			panel_2_1_03.setBounds(230, 6, 100, 17);
			courtsPanel.add(panel_2_1_03);
			panel_2_1_03.setLayout(null);

			JLabel capacityLbl = new JLabel("Capacity");
			capacityLbl.setBounds(24, 0, 54, 16);
			panel_2_1_03.add(capacityLbl);

			JPanel panel_2_1_04 = new JPanel();
			panel_2_1_04.setBounds(342, 6, 100, 17);
			courtsPanel.add(panel_2_1_04);
			panel_2_1_04.setLayout(null);

			JLabel hoursLbl = new JLabel("Working Hours");
			hoursLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			hoursLbl.setBounds(6, 0, 88, 16);
			panel_2_1_04.add(hoursLbl);

			JPanel panel_2_1_05 = new JPanel();
			panel_2_1_05.setBounds(454, 6, 100, 17);
			courtsPanel.add(panel_2_1_05);
			panel_2_1_05.setLayout(null);

			JLabel availabilityLbl = new JLabel("Availability");
			availabilityLbl.setBounds(15, 0, 75, 16);
			panel_2_1_05.add(availabilityLbl);

			JPanel panel_2_1_06 = new JPanel();
			panel_2_1_06.setBounds(566, 6, 100, 17);
			courtsPanel.add(panel_2_1_06);
			panel_2_1_06.setLayout(null);

			JLabel lightingLbl = new JLabel("Lighting");
			lightingLbl.setBounds(22, 0, 61, 16);
			panel_2_1_06.add(lightingLbl);

			JPanel panel_2_1_07 = new JPanel();
			panel_2_1_07.setBounds(678, 6, 100, 17);
			courtsPanel.add(panel_2_1_07);
			panel_2_1_07.setLayout(null);

			JLabel surfaceLbl = new JLabel("Surface");
			surfaceLbl.setBounds(28, 0, 46, 16);
			panel_2_1_07.add(surfaceLbl);

			JPanel panel_2_1_08 = new JPanel();
			panel_2_1_08.setBounds(790, 6, 100, 17);
			courtsPanel.add(panel_2_1_08);
			panel_2_1_08.setLayout(null);

			JLabel netLbl = new JLabel("Net Height");
			netLbl.setBounds(15, 0, 68, 16);
			panel_2_1_08.add(netLbl);

			JPanel panel_2_09 = new JPanel();
			panel_2_09.setBounds(902, 6, 100, 17);
			courtsPanel.add(panel_2_09);
			panel_2_09.setLayout(null);

			JLabel doublesLbl = new JLabel("Doubles Court");
			doublesLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			doublesLbl.setBounds(6, 0, 88, 16);
			panel_2_09.add(doublesLbl);

			JPanel panel_2_10 = new JPanel();
			panel_2_10.setBounds(1014, 6, 100, 17);
			courtsPanel.add(panel_2_10);
			panel_2_10.setLayout(null);

			JLabel racketLbl = new JLabel("Has Rackets");
			racketLbl.setBounds(12, 0, 88, 16);
			panel_2_10.add(racketLbl);

			JPanel[] rows = new JPanel[tennisCount];
			int j = 0;
			JLabel[] labels = new JLabel[10];


			for(Object sf : SportsFacilitySys.getSportsFacilities()) {
				if(sf instanceof Tennis) {
					rows[j++] = new JPanel();
					rows[j-1].setBounds(18, 156+ 30 * j, 1140, 30);
					rows[j-1].setLayout(null);
					
					labels[0] = new JLabel(((Tennis)(sf)).getFacilityId() + "");
					labels[0].setBounds(35, 6, 100, 16);  
					
					labels[1] = new JLabel(((Tennis)(sf)).isIndoor() ? "+" : "-");
					labels[1].setBounds(160, 6, 100, 16); 
					
					labels[2] = new JLabel(((Tennis)(sf)).getCapacity() + "");
					labels[2].setBounds(280, 6, 100, 16);  
					
					labels[3] = new JLabel(((Tennis)(sf)).getOpeningHour() + ":00 - " + ((Tennis)(sf)).getClosingHour() + ":00");
					labels[3].setBounds(345, 6, 120, 16); 
					
					labels[4] = new JLabel(((Tennis)(sf)).isAvailable() ? "+" : "-");
					labels[4].setBounds(500, 6, 100, 16); 
					
					labels[5] = new JLabel(((Tennis)(sf)).lightingAvailability ? "+" : "-");
					labels[5].setBounds(610, 6, 100, 16);  

					labels[6] = new JLabel(((Tennis)(sf)).getSurfaceType());
					labels[6].setBounds(710, 6, 100, 16); 
					
					labels[7] = new JLabel(((Tennis)(sf)).getNetHeight() + "");
					labels[7].setBounds(825, 6, 100, 16);  
					
					labels[8] = new JLabel(((Tennis)(sf)).isDoublesCourt() ? "+" : "-");
					labels[8].setBounds(950, 6, 120, 16);  
					
					labels[9] = new JLabel(((Tennis)(sf)).isRacketAvailability() ? "+" : "-");
					labels[9].setBounds(1060, 6, 100, 16);  
					
					

					

					for(int i = 0; i < 10; i++) {
						rows[j-1].add(labels[i]);


					}
					

					contentPane.add(rows[j-1]);

		

				}


			}

		}
	}
}
