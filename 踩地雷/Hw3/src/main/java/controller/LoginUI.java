package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;
import service.UserServiceImpl;
import controller.CheckinUI;
import util.Tool;
import util.ui.UITheme;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Color;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField password;
	private UserServiceImpl userServiceImpl=new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LoginUI() {
		setTitle("踩地雷");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 238);
		contentPane = new JPanel();
		contentPane.setBackground(UITheme.BG);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UITheme.CARD);
		panel.setBounds(10, 10, 301, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("歡迎來到踩地雷！");
		lblNewLabel.setFont(UITheme.FONT_TITLE);
		lblNewLabel.setForeground(UITheme.PRIMARY_DARK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 10, 149, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 61, 72, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 97, 72, 14);
		panel.add(lblNewLabel_1_1);

		password = new JPasswordField();
		password.setBounds(92, 94, 96, 20);
		panel.add(password);

		JLabel errMsg = new JLabel("");
		errMsg.setForeground(new Color(255, 0, 0));
		errMsg.setHorizontalAlignment(SwingConstants.LEFT);
		errMsg.setBounds(102, 124, 72, 14);
		panel.add(errMsg);
		
		/*******setting*******/

		JComboBox usernames = new JComboBox();
		usernames.setBounds(92, 57, 96, 22);
		panel.add(usernames);
		List<User> list=userServiceImpl.allUser();
		for(User u:list)
		{
			usernames.addItem(u.getUsername());
		}
		
		/********event*******/
		
		JButton btnNewButton = new JButton("註冊");
		UITheme.applySecondaryButton(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUI signUI=new SignUI();
				signUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(228, 10, 63, 22);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登入");
		UITheme.applyPrimaryButton(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=(String)usernames.getSelectedItem();
				String Password=password.getText();
				User user=userServiceImpl.findByUser(Username).get(0);
				if(user.getPassword().equals(Password))
				{
					boolean didCheckin = userServiceImpl.processDailyCheckin(user);
					Tool.saveObject(user, "User");
					if(didCheckin) {
						new CheckinUI(user).setVisible(true);
					}
					GameTopUI gameTopUI=new GameTopUI();
					gameTopUI.setVisible(true);
					dispose();
				}
				else
				{
					errMsg.setText("密碼輸入有誤");
				}
			}
		});
		btnNewButton_1.setBounds(216, 58, 63, 53);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("訪客登入");
		UITheme.applyPrimaryButton(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null,"訪客登入無法進行排名是否繼續？","注意",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				if(option==JOptionPane.OK_OPTION)
				{
					Tool.saveObject(new User("Guest","0000",0), "User");
					GameTopUI gameTopUI=new GameTopUI();
					gameTopUI.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_2.setBounds(90, 148, 114, 26);
		panel.add(btnNewButton_2);
		
	}
}