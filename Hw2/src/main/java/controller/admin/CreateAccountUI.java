package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Administrator;
import service.Impl.AccountServiceImpl;
import service.Impl.AdminServiceImpl;
import util.Tool;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateAccountUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();
	private JTextField bank_account;
	private JTextField trans_password;
	private JTextField online_user;
	private JTextField online_password;
	private JTextField birthday;
	private JTextField national_id;
	private JTextField address;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountUI frame = new CreateAccountUI();
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
	public CreateAccountUI() {
		setTitle("欣新銀行後台系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新增帳戶");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 10, 90, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("銀行帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(24, 55, 70, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("交易碼：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(24, 85, 70, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("線上帳號：");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(10, 117, 84, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("線上密碼：");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(10, 150, 84, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("出生年月日：");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setBounds(10, 185, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("身分證字號：");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 220, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("地址：");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 255, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		bank_account = new JTextField();
		bank_account.setBounds(97, 52, 128, 20);
		panel.add(bank_account);
		bank_account.setColumns(10);
		
		trans_password = new JTextField();
		trans_password.setColumns(10);
		trans_password.setBounds(97, 82, 128, 20);
		panel.add(trans_password);
		
		online_user = new JTextField();
		online_user.setColumns(10);
		online_user.setBounds(97, 114, 128, 20);
		panel.add(online_user);
		
		online_password = new JTextField();
		online_password.setColumns(10);
		online_password.setBounds(97, 147, 128, 20);
		panel.add(online_password);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(97, 182, 128, 20);
		panel.add(birthday);
		
		national_id = new JTextField();
		national_id.setColumns(10);
		national_id.setBounds(97, 217, 128, 20);
		panel.add(national_id);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(97, 252, 262, 20);
		panel.add(address);
		
		/*************event****************/
		
		JButton btnNewButton_1 = new JButton("回首頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminTopUI adminTopUI=new AdminTopUI();
				adminTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(47, 320, 84, 22);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("確定新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(178, 320, 84, 22);
		panel.add(btnNewButton);

	}

}
