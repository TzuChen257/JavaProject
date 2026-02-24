package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.Account;
import service.Impl.AccountServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class AccountUpdateUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField address;
	private JTextField phone;	
	private JPasswordField online_pass;
	private JPasswordField online_confirm;
	private Account myAccount=(Account) Tool.readObject("account");
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountUpdateUI frame = new AccountUpdateUI();
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
	public AccountUpdateUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(125, 185, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 320, 459);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("基本資料修改");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(97, 10, 116, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("銀行帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(24, 55, 70, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("線上帳號：");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(10, 88, 84, 14);
		panel.add(lblNewLabel_1_1_1);
		
		
		JLabel bank_account = new JLabel(myAccount.getBank_account());
		bank_account.setHorizontalAlignment(SwingConstants.LEFT);
		bank_account.setBounds(97, 55, 128, 14);
		panel.add(bank_account);
		
		JLabel username = new JLabel(myAccount.getOnline_user());
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setBounds(97, 88, 128, 14);
		panel.add(username);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(10, 112, 300, 63);
		panel.add(panel_1_1);
		
		online_pass = new JPasswordField();
		online_pass.setBounds(87, 10, 89, 21);
		panel_1_1.add(online_pass);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("線上密碼：");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setBounds(7, 13, 75, 14);
		panel_1_1.add(lblNewLabel_1_1_2);
		
		online_confirm = new JPasswordField();
		online_confirm.setBounds(87, 34, 89, 21);
		panel_1_1.add(online_confirm);
		
		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("確認：");
		lblNewLabel_1_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_2_1_1.setBounds(-7, 34, 89, 20);
		panel_1_1.add(lblNewLabel_1_1_1_1_2_1_1);
		
		JLabel passwordErr = new JLabel("");
		passwordErr.setForeground(new Color(255, 0, 0));
		passwordErr.setBounds(186, 37, 104, 14);
		panel_1_1.add(passwordErr);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 217, 300, 149);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("姓名：");
		lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_2.setBounds(0, 10, 84, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel name = new JLabel(myAccount.getName());
		name.setBounds(87, 10, 128, 14);
		panel_1.add(name);
		name.setHorizontalAlignment(SwingConstants.LEFT);
				
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("出生年月日：");
		lblNewLabel_1_1_1_1_1.setBounds(0, 34, 84, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
				
		JLabel birthday = new JLabel(myAccount.getBirthday());
		birthday.setBounds(87, 34, 128, 14);
		panel_1.add(birthday);
		birthday.setHorizontalAlignment(SwingConstants.LEFT);
				
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("身分證字號：");
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 58, 84, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
				
		JLabel national_id = new JLabel(myAccount.getNational_id());
		national_id.setBounds(87, 58, 128, 14);
		panel_1.add(national_id);
		national_id.setHorizontalAlignment(SwingConstants.LEFT);
				
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("地址：");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(0, 85, 84, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
				
		address = new JTextField(myAccount.getAddress());
		address.setBounds(87, 82, 128, 20);
		panel_1.add(address);
		address.setColumns(10);
				
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("手機號碼：");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(0, 119, 84, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
				
		phone = new JTextField(myAccount.getPhone());
		phone.setBounds(87, 116, 128, 20);
		panel_1.add(phone);
		phone.setColumns(10);
				
		JLabel updateData = new JLabel("");
		updateData.setForeground(new Color(255, 0, 0));
		updateData.setBounds(97, 380, 123, 14);
		panel.add(updateData);
		
		/***event****/
		
		JButton btnNewButton_1 = new JButton("回首頁");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountTopUI accountTopUI=new AccountTopUI();
				accountTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(115, 427, 84, 22);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("資料修改");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Address=address.getText();
				String Phone=phone.getText();
				boolean[] isUpdate=accountServiceImpl.updateData(myAccount);
				if(isUpdate[0])
				{
					Tool.saveObject(myAccount,"account");
					updateData.setText("修改成功");
				}
				else if(isUpdate[1])
				{
					updateData.setText("請勿漏填資料");
				}
				else if(isUpdate[2])
				{
					updateData.setText("手機請填09開頭");
				}
			}
		});
		btnNewButton.setBounds(226, 376, 84, 22);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("密碼修改");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int isChanged=accountServiceImpl.updateOnlinePassword(myAccount,online_pass.getText(), online_confirm.getText());
				if(isChanged==0)
				{
					passwordErr.setText("重複輸入有誤");
				}
				else if(isChanged==1)
				{
					passwordErr.setText("新密碼不可同原密碼");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"請以新密碼重新登入","密碼修改成功",JOptionPane.INFORMATION_MESSAGE);
					Tool.saveObject(myAccount,"account");
					LoginUI login=new LoginUI();
					login.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_2.setBounds(226, 185, 84, 22);
		panel.add(btnNewButton_2);


	}
}
