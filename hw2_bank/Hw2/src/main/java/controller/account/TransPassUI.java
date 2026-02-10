package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Account;
import model.TransactionDetail;
import service.Impl.AccountServiceImpl;
import service.Impl.TransDServiceImpl;
import util.Tool;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TransPassUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private Account myAccount=(Account) Tool.readObject("account");
	private TransactionDetail detail=(TransactionDetail) Tool.readObject("Detail");
	private int countErr=0;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();
	private TransDServiceImpl transDServiceImpl=new TransDServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransPassUI frame = new TransPassUI();
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
	public TransPassUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 211);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(125, 185, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 308, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 61, 96, 21);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("請輸入交易碼6碼數字");
		lblNewLabel.setBounds(97, 36, 114, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel tradeErr = new JLabel("");
		tradeErr.setForeground(new Color(255, 0, 0));
		tradeErr.setHorizontalAlignment(SwingConstants.CENTER);
		tradeErr.setBounds(51, 92, 205, 15);
		panel.add(tradeErr);
			
		/****event****/
		
		JButton btnNewButton = new JButton("確認交易");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(passwordField.getText().equals(myAccount.getTrans_password()))
				{
					String result=null;
					if(detail.getTrading_activity()==1)
					{
						if(transDServiceImpl.addActivity1Withdraw(detail))
						{
							result="交易成功";
						}
						else result="帳戶餘額不足或數字有誤無法提款";
					}
					else if(detail.getTrading_activity()==2)
					{
						if(transDServiceImpl.addActivity2Deposit(detail))
						{
							result="交易成功";
						}
						else result="數字有誤無法存款";
					}
					else if(detail.getTrading_activity()==3)
					{
						result=transDServiceImpl.addActivity3Trans(detail);
						
					}
					JOptionPane.showMessageDialog(null,result+"，返回首頁","交易結果",JOptionPane.INFORMATION_MESSAGE);
					Account myNew=accountServiceImpl.findByOnlineUser(myAccount.getOnline_user()).get(0);
					Tool.saveObject(myNew, "account");
					AccountTopUI accountTopUI=new AccountTopUI();
					accountTopUI.setVisible(true);
					dispose();
				}
				else
				{					
					countErr++;
					if(countErr==3)
					{
						myAccount.setAccess_level(4);
						accountServiceImpl.updateData(myAccount);
						JOptionPane.showMessageDialog(null,"交易碼錯誤3帳號已鎖，請聯繫管理員","錯誤",JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					tradeErr.setText("交易碼有誤"+countErr+"次，錯誤3次進行鎖帳");
				}
			}
		});
		btnNewButton.setBounds(51, 121, 85, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消交易");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TradeUI tradeUI=new TradeUI();
				tradeUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(176, 121, 85, 23);
		panel.add(btnNewButton_1);

	}
}
