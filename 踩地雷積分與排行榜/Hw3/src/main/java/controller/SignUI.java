package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.List;

import model.User;
import service.UserServiceImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField password;
	private JPasswordField passwordAgain;
	private JTextField username;
	private UserServiceImpl userServiceImpl=new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUI frame = new SignUI();
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
	public SignUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 216, 229);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("註冊");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 10, 158, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 61, 72, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 108, 72, 14);
		panel.add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(92, 105, 96, 20);
		panel.add(password);
		
		passwordAgain = new JPasswordField();
		passwordAgain.setBounds(92, 135, 96, 20);
		panel.add(passwordAgain);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("確認密碼：");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(10, 138, 72, 14);
		panel.add(lblNewLabel_1_1_1);
		
		username = new JTextField();
		username.setBounds(92, 58, 96, 20);
		panel.add(username);
		username.setColumns(10);
		
		JLabel sameUser = new JLabel("");
		sameUser.setForeground(new Color(255, 0, 0));
		sameUser.setHorizontalAlignment(SwingConstants.LEFT);
		sameUser.setBounds(92, 81, 96, 14);
		panel.add(sameUser);
		
		/******event*****/

		JButton btnNewButton_2 = new JButton("確認註冊");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				String PasswordAgain=passwordAgain.getText();
				List<User> hasuser=userServiceImpl.findByUser(Username);
				if(!hasuser.isEmpty())
				{
					sameUser.setText("此帳號已存在");
				}
				else if(!Password.equals(PasswordAgain))
				{
					sameUser.setText("密碼需相同");
				}
				else
				{
					User newUser=new User(Username,Password);
					userServiceImpl.addUser(newUser);
					JOptionPane.showMessageDialog(null,"將回到登入頁面","新增成功",JOptionPane.INFORMATION_MESSAGE);
					new LoginUI().setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_2.setBounds(56, 186, 103, 22);
		panel.add(btnNewButton_2);

	}

}
