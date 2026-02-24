package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import model.Account;
import model.TransactionDetail;
import service.Impl.AccountServiceImpl;
import service.Impl.TransDServiceImpl;
import util.TransDetailTableModel;
import vo.ViewServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;

public class AdminSelectUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();//可以查詢帳戶細目的物件
	private ViewServiceImpl view=new ViewServiceImpl();//可以查詢交易紀錄的物件
	private JTextField bankAccount;
	private JTextField subjectAccount;
	private JTable table;
	private TransDetailTableModel tableModel=new TransDetailTableModel();

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
		setTitle("欣新銀行後台系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 143, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 719, 52);
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
		panel_1.setBounds(10, 281, 719, 52);
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
		panel_2.setBounds(10, 343, 719, 250);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel accountErr = new JLabel("全部查詢無須輸入");
		accountErr.setHorizontalAlignment(SwingConstants.LEFT);
		accountErr.setBounds(322, 19, 239, 14);
		panel.add(accountErr);
		
		JLabel transDetailErr = new JLabel("");
		transDetailErr.setHorizontalAlignment(SwingConstants.RIGHT);
		transDetailErr.setBounds(344, 19, 91, 14);
		panel_1.add(transDetailErr);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 603, 719, 37);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 72, 719, 199);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("資料筆數：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(10, 175, 75, 14);
		panel_2_1.add(lblNewLabel_1_2);
		
		JLabel dataCount = new JLabel("");
		dataCount.setHorizontalAlignment(SwingConstants.LEFT);
		dataCount.setBounds(84, 175, 90, 14);
		panel_2_1.add(dataCount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 699, 154);
		panel_2_1.add(scrollPane);
		
		JTextArea outputAccount = new JTextArea();
		scrollPane.setViewportView(outputAccount);

		
		JLabel detailErr = new JLabel("全部查詢無須輸入");
		detailErr.setHorizontalAlignment(SwingConstants.LEFT);
		detailErr.setBounds(322, 19, 239, 14);
		panel_1.add(detailErr);
		
		/********setting********/
		//new table
		table=new JTable();
		table.setModel(tableModel);
		JScrollPane outputTrade = new JScrollPane(table);
		outputTrade.setBounds(10, 10, 699, 230);
		panel_2.add(outputTrade);
		//設定欄寬
		TableColumn c0=table.getColumnModel().getColumn(0);
		c0.setPreferredWidth(50);
		TableColumn c1=table.getColumnModel().getColumn(1);
		c1.setPreferredWidth(85);
		TableColumn c2=table.getColumnModel().getColumn(2);
		c2.setPreferredWidth(85);
		TableColumn c3=table.getColumnModel().getColumn(3);
		c3.setPreferredWidth(20);
		
		/******event*****/
		
		JButton selectTrade = new JButton("查詢");
		selectTrade.setBackground(new Color(255, 255, 255));
		selectTrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bank_account=subjectAccount.getText();
				if(bank_account.equals(""))
				{
					loadViewAll();
				}
				else if(!(new TransDServiceImpl().selectDetailByAccount(bank_account)).isEmpty())
				{
					loadViewOne(bank_account);
				}
				else
				{
					detailErr.setText("查無此帳號");
				}
			}
		});
		selectTrade.setBounds(571, 15, 64, 22);
		panel_1.add(selectTrade);
		
		JButton printTrade = new JButton("列印");
		printTrade.setBackground(new Color(255, 255, 255));
		printTrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					System.out.println("無法印出");
					e1.printStackTrace();
				}
			}
		});
		printTrade.setBounds(645, 15, 64, 22);
		panel_1.add(printTrade);
		
		JButton selectAccount = new JButton("查詢");
		selectAccount.setBackground(new Color(255, 255, 255));
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
						show+="姓名："+a.getName()+
								"\t銀行帳號："+a.getBank_account()+"\t帳戶餘額："+a.getBalance()+
								"\t交易碼："+a.getTrans_password()+"\t存取權限："+a.getAccess_level()+
								"\t線上帳號："+a.getOnline_user()+"\t線上密碼："+a.getOnline_password()+
								"\t生日："+a.getBirthday()+"\t身份證字號："+a.getNational_id()+
								"\t手機號碼："+a.getPhone()+"\t地址："+a.getAddress()+"\n";
						count++;
					}
					outputAccount.setText(show);
					dataCount.setText(count+"筆");
				}
				else
				{
					try
					{
						Account a=accountServiceImpl.findByAccount(bank_account).get(0);
						show+="姓名："+a.getName()+
								"\t銀行帳號："+a.getBank_account()+"\t帳戶餘額："+a.getBalance()+
								"\t交易碼："+a.getTrans_password()+"\t存取權限："+a.getAccess_level()+
								"\t線上帳號："+a.getOnline_user()+"\t線上密碼："+a.getOnline_password()+
								"\t生日："+a.getBirthday()+"\t身份證字號："+a.getNational_id()+
								"\t手機號碼："+a.getPhone()+"\t地址："+a.getAddress()+"\n";
						outputAccount.setText(show);
						dataCount.setText("1筆");
					}
					catch(IndexOutOfBoundsException e1)
					{
						accountErr.setText("查無此帳號");
					}
				}
			}
		});
		selectAccount.setBounds(571, 15, 64, 22);
		panel.add(selectAccount);
		
		JButton printAccount = new JButton("列印");
		printAccount.setBackground(new Color(255, 255, 255));
		printAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					outputAccount.print();
				} catch (PrinterException e1) {
					System.out.println("無法印出");
					e1.printStackTrace();
				}
			}
		});
		printAccount.setBounds(645, 15, 64, 22);
		panel.add(printAccount);
		
		JButton btnNewButton = new JButton("回首頁");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminTopUI adminTopUI=new AdminTopUI();
				adminTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(331, 10, 84, 22);
		panel_3.add(btnNewButton);
	}
	//自設method待呼叫
	//匯入資料
	private void loadViewAll()
	{
		tableModel.setData(view.allAccountView());
	}
	private void loadViewOne(String subject_account)
	{
		tableModel.setData(view.oneAccountView(subject_account));
	}
}
