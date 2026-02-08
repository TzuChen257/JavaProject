package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.Account;
import model.Administrator;
import util.Tool;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountTopUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Account account=(Account) Tool.readObject("account");//取用檔案

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountTopUI frame = new AccountTopUI();
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
	public AccountTopUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(125, 185, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 47, 292, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel username = new JLabel(account.getOnline_user());
		username.setHorizontalAlignment(SwingConstants.RIGHT);
		username.setBounds(10, 10, 63, 14);
		panel.add(username);
		
		JLabel lblNewLabel_1 = new JLabel("您好：");
		lblNewLabel_1.setBounds(83, 10, 63, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("歡迎使用欣新銀行線上系統！");
		lblNewLabel_2.setBounds(10, 34, 188, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 114, 292, 262);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("您的帳戶餘額");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(35, 22, 112, 28);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(35, 73, 218, 47);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel balance = new JLabel(String.valueOf(account.getBalance()));
		balance.setBounds(0, 0, 208, 47);
		panel_2.add(balance);
		balance.setBackground(new Color(240, 240, 240));
		balance.setFont(new Font("新細明體", Font.BOLD, 16));
		balance.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel bank_account = new JLabel(account.getBank_account());
		bank_account.setHorizontalAlignment(SwingConstants.RIGHT);
		bank_account.setBounds(99, 48, 144, 15);
		panel_1.add(bank_account);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 386, 292, 45);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 291, 27);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("現在時間：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 10, 63, 14);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel timeNow = new JLabel("");
		timeNow.setBounds(73, 10, 174, 14);
		panel_4.add(timeNow);
		
		/*****setting*****/
		Timer timer=new Timer(1000, (ActionListener) new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				timeNow.setText(time);
			}
		});
		timer.start();

		/**********event**********/
		
		JButton btnNewButton_1_1 = new JButton("帳戶明細");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSelectUI accountSelectUI=new AccountSelectUI();
				accountSelectUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(169, 139, 84, 22);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_2 = new JButton("設定");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountUpdateUI accountUpdateUI=new AccountUpdateUI();
				accountUpdateUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(219, 10, 63, 38);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("提款");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.saveTradeActivity(1);
				TradeUI tradeUI=new TradeUI();
				tradeUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 202, 68, 41);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("存款");
		btnNewButton_3_1.setBackground(new Color(255, 255, 255));
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.saveTradeActivity(2);
				TradeUI tradeUI=new TradeUI();
				tradeUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setBounds(112, 202, 68, 41);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("轉帳");
		btnNewButton_3_2.setBackground(new Color(255, 255, 255));
		btnNewButton_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.saveTradeActivity(3);
				TradeUI tradeUI=new TradeUI();
				tradeUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_2.setBounds(214, 202, 68, 41);
		panel_1.add(btnNewButton_3_2);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI loginUI=new LoginUI();
				loginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(45, 10, 84, 22);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("離開");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(155, 10, 84, 22);
		panel_3.add(btnNewButton);
	}
}
