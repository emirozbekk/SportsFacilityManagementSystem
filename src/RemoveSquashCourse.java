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

public class RemoveSquashCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField nameTxt;
	private static SquashCourse sc=new SquashCourse(new SquashPage(new HomePage()));

	
	/**
	 * Create the frame.
	 */
	public RemoveSquashCourse(SquashCourse sc) {
		this.sc=sc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CourseID:");
		lblNewLabel.setBounds(100, 48, 70, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CourseName:");
		lblNewLabel_1.setBounds(100, 89, 70, 13);
		contentPane.add(lblNewLabel_1);
		
		idTxt = new JTextField();
		idTxt.setBounds(180, 45, 151, 19);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(180, 86, 151, 19);
		contentPane.add(nameTxt);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(166, 127, 165, 16);
		contentPane.add(textArea);
		
		
		JButton btnNewButton = new JButton("REMOVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!idTxt.getText().equals("")) {
					Squash s = (Squash)SportsFacilitySys.searchFacilityById(Integer.parseInt(idTxt.getText()));

					if(s != null) {
						Course c = SportsFacilitySys.searchCourseByName(nameTxt.getText());
						s.courses.remove(c);
						textArea.setText("Course removed succesfully");
						
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
					
					
				}
			}
		});
		btnNewButton.setBounds(10, 153, 202, 100);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sc.setVisible(true);
			}
		});
		btnClose.setBounds(222, 153, 204, 100);
		contentPane.add(btnClose);
		
		
		
		
	}

}
