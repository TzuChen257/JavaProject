package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import model.Account;
import util.Tool;
import util.TransDetailTableModel;
import vo.ViewServiceImpl;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Color;

public class AccountSelectUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Account myAccount=(Account) Tool.readObject("account");
	private JTable table;
	private TransDetailTableModel tableModel=new TransDetailTableModel();
	private ViewServiceImpl view=new ViewServiceImpl();//可以查詢交易紀錄的物件

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSelectUI frame = new AccountSelectUI();
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
	public AccountSelectUI() {
		setTitle("欣新銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(125, 185, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 681, 452);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("我的交易紀錄");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(274, 10, 115, 18);
		panel.add(lblNewLabel);

		/*******setting******/
		//new Table
		table=new JTable();
		table.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 49, 661, 344);
		panel.add(scrollPane);
		//設定欄寬
		TableColumn c0=table.getColumnModel().getColumn(0);
		c0.setPreferredWidth(50);
		TableColumn c1=table.getColumnModel().getColumn(1);
		c1.setPreferredWidth(85);
		TableColumn c2=table.getColumnModel().getColumn(2);
		c2.setPreferredWidth(85);
		TableColumn c3=table.getColumnModel().getColumn(3);
		c3.setPreferredWidth(20);
		//直接帶入資料
		tableModel.setData(view.oneAccountView(myAccount.getBank_account()));
		
		/******event******/
		
		JButton btnNewButton = new JButton("回首頁");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountTopUI accountTopUI=new AccountTopUI();
				accountTopUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(211, 416, 84, 22);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("印出");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.setBounds(379, 416, 84, 22);
		panel.add(btnNewButton_1);
	}

}
