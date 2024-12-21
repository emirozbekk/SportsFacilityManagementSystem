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

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon stadium = new ImageIcon(getClass().getResource("/images/D--Oym7X4AEUSus.jpg"));
	private ImageIcon logoImg = new ImageIcon(getClass().getResource("/images/logo.png"));
	private ImageIcon footballImg = new ImageIcon(getClass().getResource("/images/football.png"));
	private ImageIcon basketballImg = new ImageIcon(getClass().getResource("/images/basketball.png"));
	private ImageIcon tennisImg = new ImageIcon(getClass().getResource("/images/tennis.png"));
	private ImageIcon squashImg = new ImageIcon(getClass().getResource("/images/squash.png"));
	private TennisPage tennisFrame = new TennisPage(this);


	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 250, 252));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		logo.setIcon(logoImg);
		logo.setBounds(6, 6, 178, 80);
		contentPane.add(logo);
		
		JLabel uniName = new JLabel("Bilkent University ");
		uniName.setForeground(new Color(1, 74, 150));
		uniName.setFont(new Font("Beirut", Font.PLAIN, 20));
		uniName.setBounds(95, 33, 203, 29);
		contentPane.add(uniName);
		
		JButton footballBtn = new JButton("Football");
		footballBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		footballBtn.setBounds(667, 34, 117, 29);
		contentPane.add(footballBtn);
		
		JButton basketabllBtn = new JButton("Basketball");
		basketabllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasketballPage frame = new BasketballPage();
				frame.setVisible(true);
			}
		});
		basketabllBtn.setBounds(796, 34, 117, 29);
		contentPane.add(basketabllBtn);
		
		JButton tennisBtn = new JButton("Tennis");
		tennisBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tennisFrame.setVisible(true);
				setVisible(false);
				
			}
		});
		tennisBtn.setBounds(925, 34, 117, 29);
		contentPane.add(tennisBtn);
		
		JButton squashBtn = new JButton("Squash");
		squashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		squashBtn.setBounds(1054, 34, 117, 29);
		contentPane.add(squashBtn);
		
		JLabel lblNewLabel = new JLabel("Sport Facility Management System");
		lblNewLabel.setForeground(new Color(225, 0, 26));
		lblNewLabel.setFont(new Font("Beirut", Font.PLAIN, 13));
		lblNewLabel.setBounds(94, 55, 283, 21);
		contentPane.add(lblNewLabel);
		
		JLabel backgroundPhoto = new JLabel("");
		backgroundPhoto.setIcon(stadium);
		backgroundPhoto.setBounds(0, 98, 1191, 436);
		contentPane.add(backgroundPhoto);
		
		JPanel footballPnl = new JPanel();
		footballPnl.setBounds(49, 570, 219, 136);
		contentPane.add(footballPnl);
		footballPnl.setLayout(null);
		
		JLabel footballIcon = new JLabel("");
		footballIcon.setBounds(6, 6, 35, 35);
		footballIcon.setIcon(footballImg);
		footballPnl.add(footballIcon);
		
		
		JLabel footballLbl = new JLabel("Football");
		footballLbl.setForeground(new Color(60, 107, 37));
		footballLbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		footballLbl.setBounds(74, 6, 76, 35);
		footballPnl.add(footballLbl);
		
		JLabel footballFacCount = new JLabel("There are XX football courts.");
		footballFacCount.setBounds(6, 63, 195, 16);
		footballPnl.add(footballFacCount);
		
		JButton FootballMainBtn = new JButton("Football Page");
		FootballMainBtn.setBounds(0, 91, 213, 29);
		footballPnl.add(FootballMainBtn);
		
		JPanel basketballPnl = new JPanel();
		basketballPnl.setLayout(null);
		basketballPnl.setBounds(338, 570, 219, 136);
		contentPane.add(basketballPnl);
		
		JLabel basketballIcon = new JLabel("");
		basketballIcon.setIcon(basketballImg);
		basketballIcon.setBounds(6, 6, 35, 35);
		basketballPnl.add(basketballIcon);
		
		JLabel basketballLbl = new JLabel("Basketball");
		basketballLbl.setForeground(new Color(237, 155, 56));
		basketballLbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		basketballLbl.setBounds(65, 6, 106, 35);
		basketballPnl.add(basketballLbl);
		
		JLabel basketballFacCount = new JLabel("There are XX basketball courts.");
		basketballFacCount.setBounds(6, 63, 195, 16);
		basketballPnl.add(basketballFacCount);
		
		JButton BasketballMainBtn = new JButton("Basketball Page");
		BasketballMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasketballPage frame = new BasketballPage();
				frame.setVisible(true);
			}
		});
		BasketballMainBtn.setBounds(0, 91, 213, 29);
		basketballPnl.add(BasketballMainBtn);
		
		JPanel tennisPnl = new JPanel();
		tennisPnl.setLayout(null);
		tennisPnl.setBounds(630, 570, 219, 136);
		contentPane.add(tennisPnl);
		
		JLabel tennisIcon = new JLabel("");
		tennisIcon.setIcon(tennisImg);
		tennisIcon.setBounds(6, 6, 35, 35);
		tennisPnl.add(tennisIcon);
		
		JLabel tennisLbl = new JLabel("Tennis");
		tennisLbl.setForeground(new Color(224, 208, 70));
		tennisLbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		tennisLbl.setBounds(83, 6, 76, 35);
		tennisPnl.add(tennisLbl);
		
		JLabel tennislFacCount = new JLabel("There are XX tennis courts.");
		tennislFacCount.setBounds(6, 63, 195, 16);
		tennisPnl.add(tennislFacCount);
		
		JButton tennisMainBtn = new JButton("Tennis Page");
		tennisMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tennisFrame.setVisible(true);
				setVisible(false);
				
			}
		});
		tennisMainBtn.setBounds(0, 91, 213, 29);
		tennisPnl.add(tennisMainBtn);
		
		JPanel squashPnl = new JPanel();
		squashPnl.setLayout(null);
		squashPnl.setBounds(925, 570, 219, 136);
		contentPane.add(squashPnl);
		
		JLabel squashIcon = new JLabel("");
		squashIcon.setIcon(squashImg);
		squashIcon.setBounds(6, 6, 35, 35);
		squashPnl.add(squashIcon);
		
		JLabel squashLbl = new JLabel("Squash");
		squashLbl.setForeground(new Color(98, 211, 226));
		squashLbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		squashLbl.setBounds(85, 6, 76, 35);
		squashPnl.add(squashLbl);
		
		JLabel squashFacCount = new JLabel("There are XX squash courts.");
		squashFacCount.setBounds(6, 63, 195, 16);
		squashPnl.add(squashFacCount);
		
		JButton squashMainBtn = new JButton("Squash Page");
		squashMainBtn.setBounds(0, 91, 213, 29);
		squashPnl.add(squashMainBtn);
		

		
		
	}
}
