package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.OnlineAccount;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminTopUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private OnlineAccount oAccount=Tool.readOnlineAccount();//取用檔案

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTopUI frame = new AdminTopUI();
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
	public AdminTopUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 52, 250, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("您好：");
		lblNewLabel.setBounds(75, 10, 45, 14);
		panel.add(lblNewLabel);
		
		JLabel username = new JLabel(oAccount.getOnline_user());
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(10, 10, 55, 14);
		panel.add(username);
		
		JLabel lblNewLabel_1 = new JLabel("請選擇業務內容：");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(56, 34, 148, 35);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 134, 250, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("1)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(42, 17, 27, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("2)");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(42, 68, 27, 35);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("3)");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(42, 118, 27, 35);
		panel_1.add(lblNewLabel_1_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 251, 32);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("現在時間：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 10, 65, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel timeNow = new JLabel("");
		timeNow.setBounds(75, 10, 145, 14);
		panel_2.add(timeNow);

		
		/*****event****/
		
		JButton btnNewButton = new JButton("查詢作業");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminSelectUI selectUI=new AdminSelectUI();
				selectUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(91, 23, 84, 22);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("新增帳戶");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateAccountUI createAccountUI=new CreateAccountUI();
				createAccountUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(91, 73, 84, 22);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("修改刪除");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateDeleteUI updateDeleteUI=new UpdateDeleteUI();
				updateDeleteUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(91, 123, 84, 22);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("離開");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1_1.setBounds(132, 202, 84, 22);
		panel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("登出");
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI loginUI=new LoginUI();
				loginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setBounds(30, 202, 84, 22);
		panel_1.add(btnNewButton_1_1_1_1);
		
	}

}
