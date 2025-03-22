import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SquashCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AddCourseSquash acs=new AddCourseSquash(this);
	private static SquashPage SquashFrame=new SquashPage(new HomePage());
	private RemoveSquashCourse rsc=new RemoveSquashCourse(this);

	/**
	 * Create the frame.
	 */
	public SquashCourse(SquashPage sp) {
		this.SquashFrame=sp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 40, 719, 198);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("ADD COURSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				acs.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 274, 202, 73);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REMOVE COURSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rsc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(266, 274, 202, 73);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sp.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(527, 274, 202, 73);
		contentPane.add(btnNewButton_2);
	}

}
