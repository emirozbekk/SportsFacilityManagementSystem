import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveSquashPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTxt;
	private static SquashPage SquashFrame=new SquashPage(new HomePage());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveSquashPage frame = new RemoveSquashPage(SquashFrame);
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
	public RemoveSquashPage(SquashPage sp) {
		this.SquashFrame=sp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ID:");
		lblNewLabel.setBounds(55, 74, 59, 13);
		contentPane.add(lblNewLabel);
		
		idTxt = new JTextField();
		idTxt.setBounds(114, 71, 225, 19);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("REMOVE FACILITY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(idTxt.getText().equalsIgnoreCase("")))
				{
					int id=Integer.parseInt(idTxt.getText());
				for(int i=0;i<SportsFacilitySys.getSportsFacilities().size();i++)
				{
					if(SportsFacilitySys.getSportsFacilities().get(i).getFacilityId()==id)
						SportsFacilitySys.getSportsFacilities().remove(i);
					
				}
				}
				else {
					idTxt.setText("Fill this void!");
				}
			}
		});
		btnNewButton.setBounds(10, 154, 202, 88);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(224, 154, 202, 88);
		contentPane.add(btnNewButton_1);
	}
}
