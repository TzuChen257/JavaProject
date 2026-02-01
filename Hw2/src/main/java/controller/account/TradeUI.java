package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Tool;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TradeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int trade_activity=Tool.readTrade();//確認是哪種交易1)提款2)存款3)轉帳(可否先隱藏一個panal!)
	private JTextField tradingAmount;
	private JTextField textField;

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
		setTitle("欣新銀行-交易");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 381);
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
		
		JLabel tradingLebal = new JLabel("提款");
		tradingLebal.setFont(new Font("新細明體", Font.PLAIN, 14));
		tradingLebal.setBounds(49, 10, 43, 25);
		panel_1.add(tradingLebal);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(78, 10, 56, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel subjectAccount = new JLabel("");
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
		
		JLabel balance = new JLabel("");
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 220, 375, 46);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("轉出帳號：");
		lblNewLabel_1_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(49, 10, 78, 25);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(129, 10, 189, 25);
		panel_3.add(textField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 276, 375, 56);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.setBounds(220, 10, 84, 22);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回上頁");
		btnNewButton_1.setBounds(62, 10, 84, 22);
		panel_4.add(btnNewButton_1);

	}
}
