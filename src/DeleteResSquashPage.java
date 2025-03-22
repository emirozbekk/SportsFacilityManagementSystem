import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeleteResSquashPage extends JFrame {

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
	public DeleteResSquashPage(SquashPage sp) {
		this.squashFrame=sp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FacilityID:");
		lblNewLabel.setBounds(95, 44, 60, 13);
		contentPane.add(lblNewLabel);
		
		idTxt = new JTextField();
		idTxt.setBounds(175, 41, 156, 19);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name:");
		lblNewLabel_1.setBounds(95, 76, 80, 13);
		contentPane.add(lblNewLabel_1);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(175, 73, 156, 19);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("StudentID:");
		lblNewLabel_2.setBounds(95, 105, 80, 13);
		contentPane.add(lblNewLabel_2);
		
		stuidTxt = new JTextField();
		stuidTxt.setBounds(175, 102, 156, 19);
		contentPane.add(stuidTxt);
		stuidTxt.setColumns(10);
		
		resTxt = new JTextField();
		resTxt.setBounds(175, 131, 156, 19);
		contentPane.add(resTxt);
		resTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Reservation Time:");
		lblNewLabel_3.setBounds(82, 134, 93, 13);
		contentPane.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(170, 10, 161, 16);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("DELETE RESERVATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTxt.getText().equalsIgnoreCase("") || nameTxt.getText().equalsIgnoreCase("") || stuidTxt.getText().equalsIgnoreCase("") || resTxt.getText().equalsIgnoreCase(""))
					textArea.setText("Fill All the Voids!");
				else
				{
					SportsFacilitySys.deleteReservation(resTxt.getText(), Integer.parseInt(idTxt.getText()) ,nameTxt.getText(), stuidTxt.getText());
				}
			}
		});
		btnNewButton.setBounds(10, 173, 202, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(224, 173, 202, 80);
		contentPane.add(btnNewButton_1);
		
		
	}

}
