import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class AddSquashPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField capacityTxt;
	private JTextField floorTxt;
	private JTextField locationTxt;
	private JTextField openingTxt;
	private JTextField closingTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static SquashPage squashFrame=new SquashPage(new HomePage());


	/**
	 * Create the frame.
	 */
	public AddSquashPage(SquashPage sp) {
		this.squashFrame=sp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FacilityID:");
		lblNewLabel.setBounds(39, 26, 92, 13);
		contentPane.add(lblNewLabel);
		
		idTxt = new JTextField();
		idTxt.setBounds(141, 23, 428, 19);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Capacity:");
		lblNewLabel_2.setBounds(39, 84, 92, 13);
		contentPane.add(lblNewLabel_2);
		
		capacityTxt = new JTextField();
		capacityTxt.setBounds(141, 81, 428, 19);
		contentPane.add(capacityTxt);
		capacityTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Floor Type:");
		lblNewLabel_3.setBounds(39, 113, 92, 13);
		contentPane.add(lblNewLabel_3);
		
		floorTxt = new JTextField();
		floorTxt.setBounds(141, 110, 428, 19);
		contentPane.add(floorTxt);
		floorTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Location:");
		lblNewLabel_1.setBounds(39, 55, 92, 13);
		contentPane.add(lblNewLabel_1);
		
		locationTxt = new JTextField();
		locationTxt.setBounds(141, 52, 428, 19);
		contentPane.add(locationTxt);
		locationTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("OpeningHour:");
		lblNewLabel_4.setBounds(39, 142, 92, 13);
		contentPane.add(lblNewLabel_4);
		
		openingTxt = new JTextField();
		openingTxt.setBounds(141, 139, 428, 19);
		contentPane.add(openingTxt);
		openingTxt.setColumns(10);
		
		closingTxt = new JTextField();
		closingTxt.setBounds(141, 168, 428, 19);
		contentPane.add(closingTxt);
		closingTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ClosingHour:");
		lblNewLabel_5.setBounds(39, 171, 92, 13);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton radioIndoor = new JRadioButton("Indoor");
		buttonGroup.add(radioIndoor);
		radioIndoor.setBounds(141, 202, 159, 21);
		contentPane.add(radioIndoor);
		

		JCheckBox checkLightning = new JCheckBox("Available");
		checkLightning.setBounds(108, 235, 93, 21);
		contentPane.add(checkLightning);
		
		JCheckBox checkDoubles = new JCheckBox("Allowed");
		checkDoubles.setBounds(373, 235, 93, 21);
		contentPane.add(checkDoubles);
		
		JRadioButton radioOutdoor = new JRadioButton("Outdoor");
		buttonGroup.add(radioOutdoor);
		radioOutdoor.setBounds(310, 202, 103, 21);
		contentPane.add(radioOutdoor);
		
		
		
		JButton btnNewButton = new JButton("ADD FACILITY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String location=locationTxt.getText();
				boolean isIndoor=false;
				if(radioIndoor.isSelected())
					isIndoor=true;
				int capacity=Integer.parseInt(capacityTxt.getText());
				String openingHour=openingTxt.getText();
				String closingHour=closingTxt.getText();
				boolean lightning=false;
				if(checkLightning.isSelected())
					lightning=true;
				int facilityId=Integer.parseInt(idTxt.getText());
				String floortype=floorTxt.getText();
				boolean isDoubles=false;
				if(checkDoubles.isSelected())
					isDoubles=true;
				
				Squash sf=new Squash(location,isIndoor,capacity,openingHour,closingHour,true,null,lightning,facilityId,null,null,null,floortype,isDoubles,true);
				SportsFacilitySys.addFacility(sf);
			}
		});
		btnNewButton.setBounds(10, 273, 290, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				squashFrame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(310, 273, 305, 50);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Facility:");
		lblNewLabel_6.setBounds(39, 206, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Lightning:");
		lblNewLabel_7.setBounds(39, 239, 63, 13);
		contentPane.add(lblNewLabel_7);
		
		
		JLabel doub = new JLabel("Doubles:");
		doub.setBounds(310, 239, 70, 13);
		contentPane.add(doub);
		
		
		
		
	}
}
