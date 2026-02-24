package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import model.Account;
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
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class CreateAccountUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField online_user;
	private JTextField online_password;
	private JTextField birthday;
	private JTextField national_id;
	private JTextField address;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();
	private JTextField phone;
	private JTextField name;
	
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
		setBounds(100, 100, 665, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 143, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 343, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新增帳戶");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 10, 90, 31);
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
		lblNewLabel_1_1_1_1_1.setBounds(10, 220, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("身分證字號：");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 255, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("地址：");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 291, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("手機號碼：");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(10, 327, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("開戶存款：");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(10, 364, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);

		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("姓名：");
		lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_2.setBounds(10, 185, 84, 14);
		panel.add(lblNewLabel_1_1_1_1_1_2);
		
		online_user = new JTextField();
		online_user.setColumns(10);
		online_user.setBounds(97, 114, 128, 20);
		panel.add(online_user);
		
		online_password = new JTextField();
		online_password.setColumns(10);
		online_password.setBounds(97, 147, 128, 20);
		panel.add(online_password);
		
		national_id = new JTextField();
		national_id.setColumns(10);
		national_id.setBounds(97, 252, 128, 20);
		panel.add(national_id);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(97, 288, 128, 20);
		panel.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(97, 324, 128, 20);
		panel.add(phone);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(97, 182, 128, 20);
		panel.add(name);
		
		JLabel bank_account = new JLabel("");
		bank_account.setBounds(97, 55, 128, 14);
		panel.add(bank_account);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(125, 185, 222));
		panel_1.setBounds(363, 10, 278, 459);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 52, 258, 365);
		panel_1.add(output);
		
		JLabel lblNewLabel_2 = new JLabel("帳戶明細");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(99, 11, 90, 31);
		panel_1.add(lblNewLabel_2);

		JLabel addResult = new JLabel("");
		addResult.setForeground(new Color(255, 0, 0));
		addResult.setHorizontalAlignment(SwingConstants.CENTER);
		addResult.setBounds(179, 392, 84, 14);
		panel.add(addResult);
		
		JLabel err1 = new JLabel("");
		err1.setHorizontalAlignment(SwingConstants.LEFT);
		err1.setForeground(Color.RED);
		err1.setBounds(230, 85, 103, 14);
		panel.add(err1);
		
		JLabel err2 = new JLabel("");
		err2.setHorizontalAlignment(SwingConstants.LEFT);
		err2.setForeground(Color.RED);
		err2.setBounds(230, 117, 103, 14);
		panel.add(err2);
		
		JLabel err3 = new JLabel("");
		err3.setHorizontalAlignment(SwingConstants.LEFT);
		err3.setForeground(Color.RED);
		err3.setBounds(230, 255, 103, 14);
		panel.add(err3);
		
		JLabel err4 = new JLabel("");
		err4.setHorizontalAlignment(SwingConstants.LEFT);
		err4.setForeground(Color.RED);
		err4.setBounds(230, 327, 103, 14);
		panel.add(err4);
		
		JLabel err5 = new JLabel("");
		err5.setHorizontalAlignment(SwingConstants.LEFT);
		err5.setForeground(Color.RED);
		err5.setBounds(230, 364, 103, 14);
		panel.add(err5);
		
		JFormattedTextField balance = new JFormattedTextField(Tool.numFormat());
		balance.setBounds(97, 361, 128, 20);
		panel.add(balance);

		JFormattedTextField trans_password = new JFormattedTextField(Tool.numFormat());
		trans_password.setBounds(97, 82, 128, 20);
		panel.add(trans_password);
		
		/************setting*************/
		//calender與格式
		DatePickerSettings setting=new DatePickerSettings();
		setting.setFormatForDatesCommonEra("yyyy.MM.dd");
		
		DatePicker birthday=new DatePicker(setting);
		birthday.setBounds(97, 217, 155, 25);
		panel.add(birthday);
		
		//bank account流水號表示
		List<Account> all=accountServiceImpl.allAccount();
		Account last=all.get(all.size()-1);
		String todayPattern=Tool.addDate()+"\\d{5}";
		if(last.getBank_account().matches(todayPattern))
		{
			//同天+1
			String sub=last.getBank_account().substring(8);//從第八個開始
			String newsub=Integer.toString(Integer.valueOf(sub)+1);
			bank_account.setText(Tool.addDate()+newsub);
		}
		else
		{
			//今天的1
			bank_account.setText(Tool.addDate()+"10001");
		}
		
		/*************event****************/
		
		JButton btnNewButton_1 = new JButton("回首頁");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminTopUI adminTopUI=new AdminTopUI();
				adminTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(65, 416, 84, 22);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("確定新增");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//歸零
				err1.setText("");
				err2.setText("");
				err3.setText("");
				err4.setText("");
				err5.setText("");
				//資料
				String bankAccount=bank_account.getText();
				String transPassword=trans_password.getText();
				String onlineUser=online_user.getText();
				String onlinePass=online_password.getText();
				String Name=name.getText();
				String Birthday=birthday.getText();
				String nationalID=national_id.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				int Balance=Integer.parseInt(balance.getText());
				Account newAccount=new Account(bankAccount,transPassword,onlineUser,
						onlinePass,Balance,Name,Birthday,nationalID,Address,Phone);
				boolean[] isAdd=accountServiceImpl.addAccount(newAccount);
				if(isAdd[0])
				{
					addResult.setText("新增成功");
					output.setText("銀行帳號："+newAccount.getBank_account()+
							"\n交易碼："+newAccount.getTrans_password()+
							"\n線上帳號："+newAccount.getOnline_user()+
							"\n線上密碼："+newAccount.getOnline_password()+
							"\n姓名："+newAccount.getName()+
							"\n生日："+newAccount.getBirthday()+
							"\n身分證字號："+newAccount.getNational_id()+
							"\n地址："+newAccount.getAddress()+
							"\n手機號碼："+newAccount.getPhone()+
							"\n開戶存款："+newAccount.getBalance());
				}
				else
				{
					addResult.setText("新增失敗");
					if(!isAdd[1])
					{
						err1.setText("交易碼為六位數字");
					}
					if(!isAdd[2])
					{
						err2.setText("使用者名稱重複");
					}
					if(!isAdd[3])
					{
						err3.setText("大寫字母+9碼數字");
					}
					if(!isAdd[4])
					{
						err4.setText("手機開頭09");
					}
					if(!isAdd[5])
					{
						err5.setText("開戶至少存入1000");
					}
				}
			}
		});
		btnNewButton.setBounds(189, 416, 84, 22);
		panel.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("印出");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
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
		btnNewButton_2.setBounds(99, 427, 84, 22);
		panel_1.add(btnNewButton_2);
	}
}