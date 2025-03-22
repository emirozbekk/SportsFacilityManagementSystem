import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class AddCourseSquash extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField capacityTxt;
	private static SquashCourse sc=new SquashCourse(new SquashPage(new HomePage()));



	/**
	 * Create the frame.
	 */
	public AddCourseSquash(SquashCourse sc) {
		this.sc=sc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CourseID:");
		lblNewLabel.setBounds(87, 46, 67, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setBounds(87, 84, 67, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacity:");
		lblNewLabel_2.setBounds(87, 126, 67, 13);
		contentPane.add(lblNewLabel_2);
		
		idTxt = new JTextField();
		idTxt.setBounds(164, 43, 141, 19);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(164, 81, 141, 19);
		contentPane.add(nameTxt);
		
		capacityTxt = new JTextField();
		capacityTxt.setColumns(10);
		capacityTxt.setBounds(164, 123, 141, 19);
		contentPane.add(capacityTxt);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(164, 178, 156, 16);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("ADD COURSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTxt.getText().equalsIgnoreCase("") || nameTxt.getText().equalsIgnoreCase("") || capacityTxt.getText().equalsIgnoreCase(""))
				{
					textArea.setText("Fill all the voids!");
				}
				else {
					Course sc=new Course(nameTxt.getText(),capacityTxt.getText(),0);
					SportsFacilitySys.calculateCourseFee(sc);
					double fee=sc.getCourseFee();
					SportsFacilitySys.addCourse(Integer.parseInt(idTxt.getText()), nameTxt.getText(), capacityTxt.getText(),fee);
				}
			}
		});
		btnNewButton.setBounds(10, 204, 204, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sc.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(224, 204, 202, 48);
		contentPane.add(btnNewButton_1);
		
	
	}

}
