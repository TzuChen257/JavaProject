package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Account;
import service.Impl.AccountServiceImpl;
import service.Impl.TransDServiceImpl;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;

public class AdminSelectUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();//可以查詢帳戶細目的物件
	private TransDServiceImpl transDServiceImpl=new TransDServiceImpl();//可以查詢交易紀錄的物件
	private JTextField bankAccount;
	private JTextField subjectAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSelectUI frame = new AdminSelectUI();
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
	public AdminSelectUI() {
		setTitle("欣新銀行-資料查詢");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 519, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳戶查詢");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 73, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳戶13碼：");
		lblNewLabel_1.setBounds(103, 19, 64, 14);
		panel.add(lblNewLabel_1);
		
		bankAccount = new JTextField();
		bankAccount.setBounds(164, 16, 148, 20);
		panel.add(bankAccount);
		bankAccount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 72, 519, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("交易查詢");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 10, 73, 32);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳戶13碼：");
		lblNewLabel_1_1.setBounds(103, 19, 64, 14);
		panel_1.add(lblNewLabel_1_1);
		
		subjectAccount = new JTextField();
		subjectAccount.setColumns(10);
		subjectAccount.setBounds(164, 16, 148, 20);
		panel_1.add(subjectAccount);
			
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 134, 519, 250);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 499, 204);
		panel_2.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JLabel lblNewLabel_1_2 = new JLabel("資料筆數：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(10, 224, 75, 14);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel dataCount = new JLabel("");
		dataCount.setHorizontalAlignment(SwingConstants.LEFT);
		dataCount.setBounds(86, 224, 90, 14);
		panel_2.add(dataCount);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("現在時間：");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setBounds(276, 224, 75, 14);
		panel_2.add(lblNewLabel_1_2_2);
		
		JLabel timeShow = new JLabel("");
		timeShow.setHorizontalAlignment(SwingConstants.LEFT);
		timeShow.setBounds(354, 224, 155, 14);
		panel_2.add(timeShow);

		JLabel accountErr = new JLabel("");
		accountErr.setHorizontalAlignment(SwingConstants.RIGHT);
		accountErr.setBounds(344, 19, 91, 14);
		panel.add(accountErr);
		
		JLabel transDetailErr = new JLabel("");
		transDetailErr.setHorizontalAlignment(SwingConstants.RIGHT);
		transDetailErr.setBounds(344, 19, 91, 14);
		panel_1.add(transDetailErr);
		
		/******event*****/
		
		JButton selectTrade = new JButton("查詢");
		selectTrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//transDServiceImpl;
			}
		});
		selectTrade.setBounds(445, 15, 64, 22);
		panel_1.add(selectTrade);
		
		JButton selectAccount = new JButton("查詢");
		selectAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bank_account=bankAccount.getText();
				String show="";
				int count=0;
				if(bank_account.equals(""))
				{
					List<Account> list=accountServiceImpl.allAccount();
					for(Account a:list)
					{
						show+="帳號："+a.getBank_account()+"\t帳戶餘額："+a.getBalance()+
								"\t生日："+a.getBirthday()+"\t身份證字號："+a.getNational_id()+
								"\t電話："+a.getPhone()+"\t地址："+a.getAddress();//待新增
						count++;
					}
					output.setText(show);
					dataCount.setText(count+"筆");
				}
				else
				{
					try
					{
						Account a=accountServiceImpl.findByAccount(bank_account).get(0);
						show+="帳戶餘額："+a.getBalance()+
								"\t生日："+a.getBirthday()+"\t身份證字號："+a.getNational_id()+
								"\t電話："+a.getPhone()+"\t地址："+a.getAddress();;
						output.setText(show);
						dataCount.setText("1筆");
					}
					catch(IndexOutOfBoundsException e1)
					{
						accountErr.setText("查無此帳號");
					}
				}
			}
		});
		selectAccount.setBounds(445, 15, 64, 22);
		panel.add(selectAccount);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 391, 519, 37);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
	}
}
