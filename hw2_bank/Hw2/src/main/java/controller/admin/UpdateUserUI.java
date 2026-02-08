package controller.admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import model.Account;
import service.Impl.AccountServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.List;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class UpdateUserUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bankAccount;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();
	private JTextField name;
	private JTextField address;
	private JTextField userpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserUI frame = new UpdateUserUI();
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
	public UpdateUserUI() {
		setTitle("欣新銀行後台系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 143, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 530);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("請輸入銀行帳號：");
		lblNewLabel.setBounds(10, 10, 106, 27);
		panel.add(lblNewLabel);
		
		bankAccount = new JTextField();
		bankAccount.setBounds(109, 13, 118, 20);
		panel.add(bankAccount);
		bankAccount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 47, 396, 206);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 10, 376, 186);
		panel_1.add(output);
		
		JLabel lblNewLabel_1 = new JLabel("出示相關證件確定為本人後，可選擇進行以下作業：");
		lblNewLabel_1.setBounds(10, 263, 289, 14);
		panel.add(lblNewLabel_1);

		
		JLabel selectErr = new JLabel("");
		selectErr.setForeground(new Color(255, 0, 0));
		selectErr.setBounds(235, 10, 95, 27);
		panel.add(selectErr);
		
		
		/***********setting************/
		//分頁標籤01
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane1.setBounds(10, 287, 396, 201);
		panel.add(tabbedPane1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 287, 396, 201);
		panel.add(panel_4);
		panel_4.setLayout(null);
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane2.setBounds(0, 0, 396, 201);
		panel_4.add(tabbedPane2);
				
		JPanel panel_2 = new JPanel();
		tabbedPane1.addTab("開通權限", null, panel_2, null);
		panel_2.setLayout(null);
		JPanel panel_3 = new JPanel();
		tabbedPane1.addTab("基本資料", null, panel_3, null);
		panel_3.setLayout(null);
		

		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("手機號碼：");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setBounds(10, 69, 79, 14);
		panel_3.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("地址：");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1_1.setBounds(44, 99, 45, 14);
		panel_3.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("使用者密碼：");
		lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 129, 79, 14);
		panel_3.add(lblNewLabel_2_1_1_1_1_1);
		
		name = new JTextField();
		name.setBounds(99, 36, 96, 20);
		panel_3.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(99, 96, 166, 20);
		panel_3.add(address);
		
		userpass = new JTextField();
		userpass.setColumns(10);
		userpass.setBounds(99, 126, 96, 20);
		panel_3.add(userpass);
		
		JFormattedTextField phone = new JFormattedTextField(Tool.numFormat());
		phone.setBounds(99, 66, 96, 20);
		panel_3.add(phone);
		
		JLabel updateMsg = new JLabel("");
		updateMsg.setHorizontalAlignment(SwingConstants.RIGHT);
		updateMsg.setForeground(Color.RED);
		updateMsg.setBounds(41, 168, 182, 14);
		panel_3.add(updateMsg);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("姓名：");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setBounds(44, 39, 45, 14);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("1)  請確認用戶交易紀錄無異狀方可開通");
		lblNewLabel_2_1.setBounds(44, 20, 252, 14);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("2)  請用戶重設交易碼");
		lblNewLabel_2_1_2.setBounds(44, 56, 129, 14);
		panel_2.add(lblNewLabel_2_1_2);
		
		JFormattedTextField password = new JFormattedTextField(Tool.numFormat());
		password.setBounds(134, 80, 119, 27);
		panel_2.add(password);
		
		JFormattedTextField passAgain = new JFormattedTextField(Tool.numFormat());
		passAgain.setBounds(134, 117, 119, 27);
		panel_2.add(passAgain);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("新交易碼：");
		lblNewLabel_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2_1.setBounds(65, 86, 66, 14);
		panel_2.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("確認：");
		lblNewLabel_2_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2_1_1.setBounds(65, 123, 66, 14);
		panel_2.add(lblNewLabel_2_1_2_1_1);
		
		JLabel accessMsg = new JLabel("");
		accessMsg.setForeground(new Color(255, 0, 0));
		accessMsg.setHorizontalAlignment(SwingConstants.RIGHT);
		accessMsg.setBounds(44, 168, 182, 14);
		panel_2.add(accessMsg);

		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("請先查詢帳號");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_2.setBounds(10, 10, 173, 14);
		panel_3.add(lblNewLabel_2_1_1_2);
		
		/***********event************/
		
		JButton btnNewButton = new JButton("開通權限");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pass=password.getText();
				String again=passAgain.getText();
				String BankAccount=bankAccount.getText();
				int result=accountServiceImpl.updateAccess(BankAccount, pass, again);
				if(result==0)
				{
					selectErr.setText("請輸入正確帳號!");
					accessMsg.setText("查無此帳未修改成功");
				}
				else if(result==1)
				{
					selectErr.setText("");
					accessMsg.setText("請輸入六位數字交易碼");
				}
				else if(result==2)
				{
					selectErr.setText("");
					accessMsg.setText("密碼需一致請重新確認");
				}
				else
				{
					selectErr.setText("");
					accessMsg.setText("修改成功，請更新資料再印出");
				}
				
			}
		});
		btnNewButton.setBounds(233, 164, 84, 22);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("查詢/更新");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String BankAccount=bankAccount.getText();
				List<Account> l=accountServiceImpl.findByAccount(BankAccount);
				if(BankAccount.equals(""))
				{
					selectErr.setText("請輸入帳號");
				}
				else if(l.size()==0)
				{
					selectErr.setText("查無此帳");
				}
				else
				{
					Account client=l.get(0);
					boolean hasAccess=false;
					if(client.getAccess_level()==3)
					{
						hasAccess=true;
					}
					output.setText("銀行帳號："+client.getBank_account()+
							"\n交易碼："+client.getTrans_password()+
							"\n線上帳號："+client.getOnline_user()+
							"\n線上密碼："+client.getOnline_password()+
							"\n姓名："+client.getName()+
							"\n生日："+client.getBirthday()+
							"\n身分證字號："+client.getNational_id()+
							"\n地址："+client.getAddress()+
							"\n手機號碼："+client.getPhone()+
							"\n帳戶餘額："+client.getBalance()+
							"\n存取權限："+hasAccess);
					name.setText(client.getName());
					phone.setText(client.getPhone());
					address.setText(client.getAddress());
					userpass.setText(client.getOnline_password());
				}
			}
		});
		btnNewButton_1_1.setBounds(300, 12, 106, 22);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_3 = new JButton("送出資料");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Account> list=new AccountServiceImpl().findByAccount(bankAccount.getText());
				if(list.isEmpty())
				{
					updateMsg.setText("帳號有誤請重新輸入");
				}
				else
				{
					Account client=list.get(0);
					String Name=name.getText();
					String Phone=phone.getText();
					String Address=address.getText();
					String OnlinePass=userpass.getText();
					client.setName(Name);
					client.setPhone(Phone);
					client.setAddress(Address);
					client.setOnline_password(OnlinePass);
					boolean[] isupdate=accountServiceImpl.updateData(client);
					if(isupdate[0])
					{
						updateMsg.setText("修改成功，請更新資料再印出");
					}
					else
					{
						if(!isupdate[1])
						{
							updateMsg.setText("資料不得為空");
						}
						else if(!isupdate[2])
						{
							updateMsg.setText("手機請填09+");
						}
					}
				}
			}
		});
		btnNewButton_1_3.setBounds(233, 164, 84, 22);
		panel_3.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2 = new JButton("印出");
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
				} catch (PrinterException e1) {
					System.out.println("無法印出");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setBounds(322, 498, 84, 22);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("回首頁");
		btnNewButton_1_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminTopUI adminTopUI=new AdminTopUI();
				adminTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2_1.setBounds(229, 498, 84, 22);
		panel.add(btnNewButton_1_2_1);
	}
}
