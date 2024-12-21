import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeSet;
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
import javax.swing.JTextArea;

public class TennisCourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon logoImg = new ImageIcon(getClass().getResource("/images/logo.png"));
	private ImageIcon footballImg = new ImageIcon(getClass().getResource("/images/football.png"));
	private ImageIcon footballBanner = new ImageIcon(getClass().getResource("/images/spor10.jpg"));
	private HomePage hp = null;
	private int tennisCount = 0;
	private boolean tableCreated = false;
	private int x;
	private JTextField removeInp;
	private JTextField nameInp;
	private JTextField capacityInp;
	private JTextField idInp;
	private JTextField cnameRemove;





	/**
	 * Create the frame.
	 */
	public TennisCourses() {
		System.out.println("constructor called"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 250, 252));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//delete this when everything finishes
		SportsFacilitySys.init();

		createTable();
		x = 156 + 30 * tennisCount/3;


		JButton removeBtn = new JButton("Remove Course");
		removeBtn.setForeground(new Color(255, 38, 0));
		
		JPanel addPanel = new JPanel();
		addPanel.setBackground(new Color(238, 238, 238));
		addPanel.setBounds(18, x, 396, 160);
		addPanel.setVisible(false);
		contentPane.add(addPanel);

		addPanel.setLayout(null);
		
		JButton closeBtn3 = new JButton("X");
		closeBtn3.setBackground(new Color(148, 17, 0));
		closeBtn3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		closeBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(false);
			}
		});
		closeBtn3.setBounds(0, 0, 45, 29);
		addPanel.add(closeBtn3);
		
		nameInp = new JTextField();
		nameInp.setBounds(196, 6, 130, 26);
		addPanel.add(nameInp);
		nameInp.setColumns(10);
		
		capacityInp = new JTextField();
		capacityInp.setColumns(10);
		capacityInp.setBounds(196, 42, 130, 26);
		addPanel.add(capacityInp);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name : ");
		lblNewLabel_2.setBounds(79, 13, 105, 16);
		addPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Course Capacity : ");
		lblNewLabel_2_1.setBounds(79, 47, 114, 16);
		addPanel.add(lblNewLabel_2_1);
		

		JPanel removePanel = new JPanel();
		removePanel.setBackground(new Color(238, 238, 238));
		removePanel.setBounds(25, x+40, 396, 175);
		removePanel.setVisible(false);
		contentPane.add(removePanel);

		removePanel.setLayout(null);
		
		JButton addBtn = new JButton("Add Course");
		addBtn.setForeground(new Color(0, 142, 0));
		addBtn.setBounds(18, x, 125, 29);
		contentPane.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePanel.setVisible(false);
				addPanel.setVisible(true);
				
		
			}
		});
		

		
		JButton addBtn2 = new JButton("Add Course");
		addBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!idInp.getText().equals("")) {
					Tennis t = (Tennis)SportsFacilitySys.searchFacilityById(Integer.parseInt(idInp.getText()));
					
					if(t != null) {
						Course c = new Course(nameInp.getText(), capacityInp.getText() , 0.0);
						SportsFacilitySys.calculateCourseFee(c);
						t.getCourses().add(c);
						createTable();
						x+= 30;
						addBtn.setBounds(18, x, 125, 29);
						removeBtn.setBounds(147, x, 151, 29);
						addPanel.setBounds(25, x + 60, 396, 160);
						removePanel.setBounds(25, x+50 , 396, 175);



						try {
							Thread.sleep(750);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						addPanel.setVisible(false);

						
					}
				}
			}
		});
		addBtn2.setBounds(208, 125, 117, 29);
		addPanel.add(addBtn2);
		
		JLabel facilityIdLbl = new JLabel("Facility Id : ");
		facilityIdLbl.setBounds(79, 75, 105, 16);
		addPanel.add(facilityIdLbl);
		
		idInp = new JTextField();
		idInp.setColumns(10);
		idInp.setBounds(196, 70, 130, 26);
		addPanel.add(idInp);

		

		JLabel deleteLbl = new JLabel("Enter Facility Id to remove : ");
		deleteLbl.setForeground(new Color(148, 17, 0));
		deleteLbl.setBounds(6, 36, 217, 16);
		removePanel.add(deleteLbl);

		removeInp = new JTextField();
		removeInp.setBounds(187, 31, 130, 26);
		removePanel.add(removeInp);
		removeInp.setColumns(10);


		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(238, 238, 238));
		textArea.setBounds(135, 143, 255, 26);
		removePanel.add(textArea);


		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.setVisible(false);
				removePanel.setVisible(true);	

			}
		});
		removeBtn.setBounds(147, x, 151, 29);
		contentPane.add(removeBtn);

		JButton removeBtn2 = new JButton("Remove");
		removeBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(!removeInp.getText().equals("")) {
					Tennis t = (Tennis)SportsFacilitySys.searchFacilityById(Integer.parseInt(removeInp.getText()));

					if(t != null) {
						Course c = SportsFacilitySys.searchCourseByName(cnameRemove.getText());
						t.courses.remove(c);
						textArea.setText("Facility removed succesfully");
						tennisCount--;

						x = 156 + 30 * tennisCount/3;
						
						addBtn.setBounds(18, x, 125, 29);
						removeBtn.setBounds(147, x, 151, 29);
						removePanel.setBounds(25, x+40 , 396, 175);
					}
					else {
						textArea.setText("Course does not exists");

					}
					
					try {
						Thread.sleep(750);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					removePanel.setVisible(false);
				}

				createTable();

				revalidate();
				repaint();
				
				


			}
		});
		removeBtn2.setBounds(6, 140, 117, 29);
		removePanel.add(removeBtn2);


		JButton closeBtn2 = new JButton("X");
		closeBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePanel.setVisible(false);
			}
		});
		closeBtn2.setBackground(new Color(148, 17, 0));
		closeBtn2.setBounds(6, 6, 36, 26);
		removePanel.add(closeBtn2);
		
		JLabel lblEnterCourseName = new JLabel("Enter Course Name to remove : ");
		lblEnterCourseName.setForeground(new Color(148, 17, 0));
		lblEnterCourseName.setBounds(6, 75, 217, 16);
		removePanel.add(lblEnterCourseName);
		
		cnameRemove = new JTextField();
		cnameRemove.setColumns(10);
		cnameRemove.setBounds(208, 70, 130, 26);
		removePanel.add(cnameRemove);

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




		JLabel lblNewLabel_1 = new JLabel("Tennis Courses");
		lblNewLabel_1.setForeground(new Color(226, 21, 45));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(508, 122, 144, 16);
		contentPane.add(lblNewLabel_1);



		createTable();


	}



	/*
	 *  Create table
	 */


	public void createTable() {
		System.out.println("inside");
		HashSet<Course> hs = new HashSet<>();


		boolean flag = true;

		tennisCount = 0;
		

		for(Object sf : SportsFacilitySys.getSportsFacilities()) {
			if(sf instanceof Tennis) {
				for(Course course : ((Tennis) sf).getCourses()) {
					flag = false;
					tennisCount++;
					hs.add(course);
				}
			}
		}

		JPanel courtsPanel = new JPanel();
		courtsPanel.setBounds(18, 150, 1140, 30);
		contentPane.add(courtsPanel);
		courtsPanel.setLayout(null);



		if(flag) {
			JLabel noTennisCourts = new JLabel("There are no Tennis courses!!");
			noTennisCourts.setBounds(480, 5, 200, 16);
			courtsPanel.add(noTennisCourts);
		}

		else {
			JPanel panel_2_01 = new JPanel();
			panel_2_01.setBounds(0, 6, 380, 17);
			courtsPanel.add(panel_2_01);
			panel_2_01.setLayout(null);

			JLabel facilityIdLbl = new JLabel("Course Name");
			facilityIdLbl.setBounds(120, 0, 380, 16);
			panel_2_01.add(facilityIdLbl);

			JPanel panel_2_1_02 = new JPanel();
			panel_2_1_02.setBounds(380, 6, 380, 17);
			courtsPanel.add(panel_2_1_02);
			panel_2_1_02.setLayout(null);

			JLabel isIndoorLbl = new JLabel("Course Capacity");
			isIndoorLbl.setBounds(130, 0, 380, 16);
			panel_2_1_02.add(isIndoorLbl);

			JPanel panel_2_1_03 = new JPanel();
			panel_2_1_03.setBounds(380+ 380, 6, 380, 17);
			courtsPanel.add(panel_2_1_03);
			panel_2_1_03.setLayout(null);

			JLabel capacityLbl = new JLabel("Course Fee");
			capacityLbl.setBounds(190, 0, 380, 16);
			panel_2_1_03.add(capacityLbl);



			/* after hours of trial and error i couldnt delete the rows added with the gui & started to search and 
			 * 
			 * **** https://stackoverflow.com/questions/7117332/dynamically-remove-component-from-jpanel *********
			 * 
			 * 
			 * from this link i learned and used revalidate(), repaint() and getComponents()
			 * 
			 * 
			 * 
			 * the code block here removes all panels that have a y bigger than 156 and smaller than x (x is actually a vertical position)
			 * 
			 * so because i couldnt remove the ones added dynamically i remove every row and render again
			 * 
			 * i know it is not efficient but this was the best i could 
			 */
			Component[] components = contentPane.getComponents();
			for (Component component : components) {
				if (component instanceof JPanel && component.getBounds().y >= 156 && component.getBounds().y < x) {
					contentPane.remove(component);
				}
			}

			JPanel[] rows = new JPanel[tennisCount];
			int j = 0;
			JLabel[] labels = new JLabel[3];




			for(Course course : hs) {
				rows[j] = new JPanel();
				rows[j].setBounds(18, 156 + 30 * (j+1), 1140, 30);
				rows[j].setLayout(null);

				labels[0] = new JLabel(course.getCourseName());
				labels[0].setBounds(110, 0, 380, 18);

				labels[1] = new JLabel(course.getCourseCapacity());
				labels[1].setBounds(550, 0, 380, 18);

				labels[2] = new JLabel(course.getCourseFee() + "");
				labels[2].setBounds(960, 0, 380, 18);

				rows[j].add(labels[0]);
				rows[j].add(labels[1]);
				rows[j].add(labels[2]);

				contentPane.add(rows[j]);


				j++;



			}


		}

		revalidate();
		repaint();


	}
}
