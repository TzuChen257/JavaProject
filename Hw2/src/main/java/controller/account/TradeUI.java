package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Account;
import util.Tool;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TradeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tradingAmount;
	private JTextField objectAccount;
	private int trade_activity=Tool.readTrade();//確認是哪種交易1)提款2)存款3)轉帳(可否先隱藏一個panal!)
	private Account myAccount=Tool.readAccount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeUI frame = new TradeUI();
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
	public TradeUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 375, 34);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("現在時間：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 10, 65, 14);
		panel.add(lblNewLabel);
		
		JLabel timeNow = new JLabel("");
		timeNow.setHorizontalAlignment(SwingConstants.LEFT);
		timeNow.setBounds(76, 10, 65, 14);
		panel.add(timeNow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 120, 375, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel tradingLabel = new JLabel("");
		tradingLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		tradingLabel.setBounds(49, 10, 43, 25);
		panel_1.add(tradingLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(78, 10, 56, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel subjectAccount = new JLabel(myAccount.getBank_account());
		subjectAccount.setFont(new Font("新細明體", Font.PLAIN, 14));
		subjectAccount.setBounds(129, 10, 189, 25);
		panel_1.add(subjectAccount);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("交易金額：");
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(49, 45, 78, 25);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("帳戶餘額：");
		lblNewLabel_1.setBounds(129, 75, 66, 14);
		panel_1.add(lblNewLabel_1);
		
		tradingAmount = new JTextField();
		tradingAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		tradingAmount.setFont(new Font("新細明體", Font.PLAIN, 14));
		tradingAmount.setBounds(129, 45, 189, 25);
		panel_1.add(tradingAmount);
		tradingAmount.setColumns(10);
		
		JLabel balance = new JLabel(String.valueOf(myAccount.getBalance()));
		balance.setBounds(190, 75, 101, 14);
		panel_1.add(balance);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 54, 375, 56);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel tradingTopic = new JLabel("");
		tradingTopic.setFont(new Font("新細明體", Font.PLAIN, 16));
		tradingTopic.setHorizontalAlignment(SwingConstants.CENTER);
		tradingTopic.setBounds(93, 10, 181, 36);
		panel_2.add(tradingTopic);
		
		JPanel objectData = new JPanel();
		objectData.setBounds(10, 220, 375, 46);
		contentPane.add(objectData);
		objectData.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("轉出帳號：");
		lblNewLabel_1_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(49, 10, 78, 25);
		objectData.add(lblNewLabel_1_1_1_1);
		
		objectAccount = new JTextField();
		objectAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		objectAccount.setFont(new Font("新細明體", Font.PLAIN, 14));
		objectAccount.setColumns(10);
		objectAccount.setBounds(129, 10, 189, 25);
		objectData.add(objectAccount);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 276, 375, 46);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		/******setting*****/
		if(trade_activity==1)
		{
			tradingTopic.setText("提款");
			tradingLabel.setText("提款");
		}
		else if(trade_activity==2)
		{
			tradingTopic.setText("存款");
			tradingLabel.setText("存款");
		}
		else
		{
			tradingTopic.setText("轉帳");
			tradingLabel.setText("轉帳");
		}
		
		/******event*****/
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//showinputdialoge+交易碼
				//String tradePass=JOptionPane.
			}
		});
		btnNewButton.setBounds(220, 10, 84, 22);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回上頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountTopUI accountTopUI=new AccountTopUI();
				accountTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(62, 10, 84, 22);
		panel_4.add(btnNewButton_1);

	}
}
