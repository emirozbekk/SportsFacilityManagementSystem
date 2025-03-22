import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Cursor;
import javax.swing.JScrollPane;

public class SquashPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static HomePage homeFrame=new HomePage();
	private AddSquashPage asp=new AddSquashPage(this);
	private JTextField dispTxt;
	private RemoveSquashPage rsp=new RemoveSquashPage(this);
	private ResSquashPage respage=new ResSquashPage(this);
	private DeleteResSquashPage drsp=new DeleteResSquashPage(this);
	private SquashCourse sc=new SquashCourse(this);
	
	

	public JTextField getDispTxt() {
		return dispTxt;
	}

	

	


	/**
	 * Create the frame.
	 */
	public SquashPage(HomePage hp) {
		this.homeFrame=hp;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SQUASH");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(399, 10, 97, 56);
		contentPane.add(lblNewLabel);
		
		/*dispTxt = new JTextField();
		dispTxt.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		dispTxt.setBackground(new Color(240, 240, 240));
		dispTxt.setBounds(10, 76, 865, 208);
		contentPane.add(dispTxt);
		dispTxt.setColumns(10);*/
		
	
		
		JButton addBtn = new JButton("ADD FACILITY");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asp.setVisible(true);
				setVisible(false);
			}
		});
		addBtn.setBounds(10, 294, 125, 42);
		contentPane.add(addBtn);
		
		JButton removeBtn = new JButton("REMOVE FACILITY");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				rsp.setVisible(true);
			}
		});
		removeBtn.setBounds(145, 294, 125, 42);
		contentPane.add(removeBtn);
		
		JButton makeBtn = new JButton("MAKE RESERVATION");
		makeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				respage.setVisible(true);
				setVisible(false);
			}
		});
		makeBtn.setBounds(280, 294, 140, 42);
		contentPane.add(makeBtn);
		
		JButton deleteBtn = new JButton("DELETE RESERVATION");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drsp.setVisible(true);
				setVisible(false);
			}
		});
		deleteBtn.setBounds(430, 294, 140, 42);
		contentPane.add(deleteBtn);
		
		JButton btnNewButton = new JButton("COURSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(580, 294, 125, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(715, 294, 160, 42);
		contentPane.add(btnNewButton_1);
		
		String s  = "";
		
		for(Object sf : SportsFacilitySys.getSportsFacilities()) {
			if(sf instanceof Squash) {
				s += sf.toString();
			}
			repaint();
		}
		repaint();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 859, 208);
		contentPane.add(scrollPane);
		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setBackground(new Color(240, 240, 240));
		
	
		ta.setText(s);
	/*	+ ((Squash)sf)() + "\t"
		+ ((Basketball)sf).getTeamSize() +"\t"
		 + ((Basketball)sf).isBallAvailability() +"\n\n\n\n";*/
	}
}
