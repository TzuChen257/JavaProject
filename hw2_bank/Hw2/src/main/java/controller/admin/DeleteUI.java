package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Account;
import model.Administrator;
import service.Impl.AccountServiceImpl;
import service.Impl.AdminServiceImpl;
import service.Impl.TransDServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.Color;

public class DeleteUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField bank_account;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();//可以查詢帳戶的物件
	private AdminServiceImpl adminServiceImpl=new AdminServiceImpl();//可以查詢員工帳號的物件

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUI frame = new DeleteUI();
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
	public DeleteUI() {
		setTitle("欣新銀行後台系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 143, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用戶銀行帳號：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 180, 96, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("員工帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 145, 96, 14);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(113, 142, 96, 20);
		panel.add(username);
		username.setColumns(10);
		
		bank_account = new JTextField();
		bank_account.setColumns(10);
		bank_account.setBounds(113, 177, 96, 20);
		panel.add(bank_account);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 396, 76);
		panel.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		/*******event*********/
		
		JButton btnNewButton = new JButton("查詢員工");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String show="";
				List<Administrator> list=adminServiceImpl.allAdmin();
				for(Administrator a:list)
				{
					show+="帳號："+a.getOnline_user()+"\t權限："+a.getAccess_level()+"\n";
				}
				output.setText(show);
			}
		});
		btnNewButton.setBounds(10, 10, 84, 22);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢用戶");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String show="";
				List<Account> list=accountServiceImpl.allAccount();
				for(Account a:list)
				{
					show+="帳號："+a.getBank_account()+"\t客戶名："+a.getName()+"\n";
				}
				output.setText(show);
			}
		});
		btnNewButton_1.setBounds(113, 10, 84, 22);
		panel.add(btnNewButton_1);
				
		JButton btnNewButton_2 = new JButton("刪除員工");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option=JOptionPane.showConfirmDialog(null, "是否永久刪除員工資料？", "警告", JOptionPane.OK_CANCEL_OPTION);
				if(option==JOptionPane.OK_OPTION)
				{
					String adminUser=username.getText();
					adminServiceImpl.deleteAdminByUser(adminUser);
				}
			}
		});
		btnNewButton_2.setBounds(283, 141, 84, 22);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("刪除用戶");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option=JOptionPane.showConfirmDialog(null, "是否永久刪除用戶資料？(交易資料無法刪除)", "警告", JOptionPane.OK_CANCEL_OPTION);
				if(option==JOptionPane.OK_OPTION)
				{
					String bankAccount=bank_account.getText();
					accountServiceImpl.deleteByAccount(bankAccount);
				}
			}
		});
		btnNewButton_1_1.setBounds(283, 176, 84, 22);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("回首頁");
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminTopUI adminTopUI=new AdminTopUI();
				adminTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(169, 211, 84, 22);
		panel.add(btnNewButton_1_1_1);

	}
}
