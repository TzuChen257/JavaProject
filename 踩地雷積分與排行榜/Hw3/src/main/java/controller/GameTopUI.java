package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.gameLevel.AdvancedUI;
import controller.gameLevel.EasyGameUI;
import controller.gameLevel.HardGameUI;
import controller.rank.UserRankUI;
import model.User;
import util.Tool;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import util.ui.UITheme;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameTopUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user=(User) Tool.readObject("User");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameTopUI frame = new GameTopUI();
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
	public GameTopUI() {
		setTitle("踩地雷");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 352);
		contentPane = new JPanel();
		contentPane.setBackground(UITheme.BG);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setJMenuBar(buildMenu());
		
		JPanel panel = new JPanel();
		panel.setBackground(UITheme.CARD);
		panel.setBounds(10, 64, 241, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新遊戲");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(UITheme.FONT_TITLE);
		lblNewLabel.setForeground(UITheme.PRIMARY_DARK);
		lblNewLabel.setBounds(76, 10, 84, 26);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UITheme.CARD);
		panel_1.setBounds(10, 10, 241, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("歡迎");
		lblNewLabel_1.setBounds(10, 10, 60, 18);
		lblNewLabel_1.setFont(UITheme.FONT_BODY);
		lblNewLabel_1.setForeground(UITheme.MUTED);
		panel_1.add(lblNewLabel_1);
		
		JLabel username = new JLabel(user.getUsername()+" !");
		username.setBounds(41, 10, 180, 18);
		username.setFont(UITheme.FONT_BODY);
		username.setForeground(UITheme.TEXT);
		panel_1.add(username);
		
		/****event*****/
		
		JButton btnNewButton = new JButton("EASY");
		UITheme.applyPrimaryButton(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EasyGameUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(53, 63, 133, 22);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADVANCED");
		UITheme.applyPrimaryButton(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdvancedUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(53, 107, 133, 22);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("HARD");
		UITheme.applyPrimaryButton(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HardGameUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(53, 152, 133, 22);
		panel.add(btnNewButton_2);
	}
	public JMenuBar buildMenu() {
		//主功能
		JMenuBar mbar=new JMenuBar();
		//mbar.setBounds(0, 0, 60, 23);
		JMenu menu=new JMenu("選項(M)");
		menu.setMnemonic(KeyEvent.VK_M);
		mbar.add(menu);
		//項目
		JMenuItem item=new JMenuItem("說明(C)",KeyEvent.VK_C);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RuleUI ruleUI=new RuleUI();
				ruleUI.setVisible(true);
			}
		});
		menu.add(item);
		item=new JMenuItem("排行榜(R)",KeyEvent.VK_R);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserRankUI().setVisible(true);
				dispose();
			}
		});
		menu.add(item);
		item=new JMenuItem("個人資訊(P)",KeyEvent.VK_P);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProfileUI().setVisible(true);
				dispose();
			}
		});
		menu.add(item);
		item=new JMenuItem("登出(O)",KeyEvent.VK_O);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUI loginUI=new LoginUI();
				loginUI.setVisible(true);
				dispose();
			}
		});
		menu.add(item);
		item=new JMenuItem("離開(X)",KeyEvent.VK_X);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(item);
		return mbar;
	}
}
