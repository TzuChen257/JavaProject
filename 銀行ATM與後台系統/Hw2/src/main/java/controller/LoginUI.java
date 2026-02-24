package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.account.AccountTopUI;
import controller.admin.AdminTopUI;
import model.Account;
import model.Administrator;
import service.Impl.AccountServiceImpl;
import service.Impl.AdminServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField online_user;
	private JPasswordField online_password;
	private AdminServiceImpl adminServiceImpl=new AdminServiceImpl();//要用的物件
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();//要用的物件

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
	public LoginUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 92, 110));
		panel.setBounds(10, 10, 357, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欣新銀行");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 10, 125, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(125, 185, 222));
		panel_1.setBounds(10, 71, 357, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(81, 10, 54, 23);
		panel_1.add(lblNewLabel_1);
		
		online_user = new JTextField();
		online_user.setBounds(145, 11, 96, 20);
		panel_1.add(online_user);
		online_user.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(81, 43, 54, 23);
		panel_1.add(lblNewLabel_1_1);
		
		online_password = new JPasswordField();
		online_password.setBounds(145, 47, 96, 20);
		panel_1.add(online_password);
		
		JLabel loginMessage = new JLabel("");
		loginMessage.setForeground(new Color(255, 0, 0));
		loginMessage.setBounds(232, 90, 125, 14);
		panel_1.add(loginMessage);
		
		/********event********/
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message=null;
				String user=online_user.getText();
				String keyin=online_password.getText();
				try
				{
					Administrator admin=adminServiceImpl.findByUser(user).get(0);
					String rightPass=admin.getOnline_password();
					if(keyin.equals(rightPass))
					{
						Tool.saveObject(admin,"admin");
						AdminTopUI adminTopUI=new AdminTopUI();
						adminTopUI.setVisible(true);
						dispose();
					}
					else message="員工密碼有誤";
				}
				catch(IndexOutOfBoundsException e1)
				{
					try {
						Account account=accountServiceImpl.findByOnlineUser(user).get(0);
						String rightPass=account.getOnline_password();
						if(account.getAccess_level()==4)
						{
							message="帳號被鎖，請找管理員";
						}
						else if(keyin.equals(rightPass))
						{
							Tool.saveObject(account,"account");
							AccountTopUI accountTopUI=new AccountTopUI();
							accountTopUI.setVisible(true);
							dispose();
						}
						else message="使用者密碼有誤";
					}
					catch(IndexOutOfBoundsException e2)
					{
						message="查無帳號，請先開戶";
					}
				}
				finally
				{
					loginMessage.setText(message);
				}	
			}
		});
		btnNewButton.setBounds(138, 90, 84, 22);
		panel_1.add(btnNewButton);
	}
}
