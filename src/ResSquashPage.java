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

public class ResSquashPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField stuidTxt;
	private JTextField resTxt;
	private static SquashPage squashFrame=new SquashPage(new HomePage());
	
	

	/**
	 * Create the frame.
	 */
	public ResSquashPage(SquashPage sp) {
		this.squashFrame=sp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FacilityID:");
		lblNewLabel.setBounds(63, 58, 84, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name:");
		lblNewLabel_1.setBounds(63, 81, 84, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("StudentID:");
		lblNewLabel_2.setBounds(63, 104, 84, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Reservation Hour:");
		lblNewLabel_3.setBounds(63, 127, 84, 13);
		contentPane.add(lblNewLabel_3);
		
		idTxt = new JTextField();
		idTxt.setBounds(157, 55, 176, 19);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(157, 78, 176, 19);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		stuidTxt = new JTextField();
		stuidTxt.setBounds(157, 101, 176, 19);
		contentPane.add(stuidTxt);
		stuidTxt.setColumns(10);
		
		resTxt = new JTextField();
		resTxt.setBounds(157, 124, 176, 19);
		contentPane.add(resTxt);
		resTxt.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(163, 10, 170, 16);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("RESERVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTxt.getText().equalsIgnoreCase("") || nameTxt.getText().equalsIgnoreCase("") || stuidTxt.getText().equalsIgnoreCase("") || resTxt.getText().equalsIgnoreCase(""))
					textArea.setText("Fill All the Voids!");
				else
				{
					if(SportsFacilitySys.reserveFacility(Integer.parseInt(idTxt.getText()), nameTxt.getText(), stuidTxt.getText(), resTxt.getText())==false)
						textArea.setText("Facility already booked!");
				}
			}
		});
		btnNewButton.setBounds(10, 174, 202, 79);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(224, 174, 202, 79);
		contentPane.add(btnNewButton_1);
		
		
	}
}
