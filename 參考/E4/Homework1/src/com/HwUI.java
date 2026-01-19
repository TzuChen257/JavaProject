package com;

import java.awt.EventQueue;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class HwUI extends JFrame {
	
	// 方案相關
	private JCheckBox member;
	private JRadioButton combo;   // 全科
	private JComboBox level;

	private JCheckBox listen;
	private JCheckBox speak;
	private JCheckBox read;
	private JCheckBox write;

	// 結果區
	private JTextArea txtDetail;

	// 按鈕
	private JButton cfm;
	private JButton del;
	private JButton print;
	private JButton close;


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField birthday;
	private JTextField mobileNumber;
	
	//時間
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HwUI frame = new HwUI();
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
	public HwUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(197, 197, 197));
		panel.setBounds(10, 75, 146, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名:");
		lblNewLabel_1_1_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_1.setBounds(10, 42, 49, 22);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("生日:");
		lblNewLabel_1_1_2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_2.setBounds(10, 88, 33, 22);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("手機:");
		lblNewLabel_1_1_3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_3.setBounds(10, 140, 49, 22);
		panel.add(lblNewLabel_1_1_3);
		
		name = new JTextField();
		name.setBounds(50, 42, 86, 22);
		panel.add(name);
		name.setColumns(10);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(50, 92, 86, 22);
		panel.add(birthday);
		
		mobileNumber = new JTextField();
		mobileNumber.setColumns(10);
		mobileNumber.setBounds(50, 144, 86, 22);
		panel.add(mobileNumber);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("YYYY/MM/DD");
		lblNewLabel_1_1_2_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_1_2_1.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_2_1.setBounds(53, 108, 86, 22);
		panel.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("09XX-XXX-XXX");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_1_2_1_1.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_2_1_1.setBounds(50, 162, 86, 17);
		panel.add(lblNewLabel_1_1_2_1_1);
		
		member = new JCheckBox("舊生 (全科95折)");
		member.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		member.setBounds(6, 206, 134, 35);
		panel.add(member);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("[個資]");
		lblNewLabel_1_1_4.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblNewLabel_1_1_4.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_4.setBounds(10, 10, 59, 22);
		panel.add(lblNewLabel_1_1_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(197, 197, 197));
		panel_1.setBounds(166, 75, 389, 104);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		combo = new JRadioButton("全科");
		combo.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		combo.setBounds(10, 64, 65, 22);
		panel_1.add(combo);
		
		level = new JComboBox();
		level.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		level.setModel(new DefaultComboBoxModel(new String[] {"A1:  全科$4000 ; 單一科$1200", "A2:  全科$4000 ; 單一科$1200", "B1:  全科$5000 ; 單一科$1450", "B2:  全科$5000 ; 單一科$1450", "C1:  全科$6000 ; 單一科$1700", "C2:  全科$6000 ; 單一科$1700"}));
		level.setBounds(144, 10, 235, 35);
		panel_1.add(level);
		
		listen = new JCheckBox("聽");
		listen.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		listen.setBounds(144, 64, 39, 22);
		panel_1.add(listen);
		
		read = new JCheckBox("讀");
		read.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		read.setBounds(278, 64, 39, 22);
		panel_1.add(read);
		
		JLabel lblNewLabel_1_1 = new JLabel("或");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(105, 64, 18, 22);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(new Color(128, 128, 0));
		
		speak = new JCheckBox("說");
		speak.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		speak.setBounds(211, 64, 39, 22);
		panel_1.add(speak);
		
		write = new JCheckBox("寫");
		write.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		write.setBounds(340, 64, 39, 22);
		panel_1.add(write);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("[方案]");
		lblNewLabel_1_1_5.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblNewLabel_1_1_5.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_5.setBounds(10, 10, 65, 22);
		panel_1.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("級數");
		lblNewLabel_1_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_6.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblNewLabel_1_1_6.setBackground(new Color(128, 128, 0));
		lblNewLabel_1_1_6.setBounds(105, 16, 39, 22);
		panel_1.add(lblNewLabel_1_1_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(197, 197, 197));
		panel_2.setBounds(166, 189, 389, 143);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtDetail = new JTextArea();
		txtDetail.setBounds(10, 10, 369, 89);
		txtDetail.setEditable(false);//不能改動明細
		panel_2.add(txtDetail);
		
		cfm = new JButton("確認");
		cfm.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		cfm.setBounds(10, 104, 84, 22);
		panel_2.add(cfm);
		
		close = new JButton("關閉");
		close.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		close.setBounds(295, 104, 84, 22);
		panel_2.add(close);
		
		del = new JButton("清除");
		del.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		del.setBounds(104, 104, 84, 22);
		panel_2.add(del);
		
		print = new JButton("列印");
		print.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		print.setBounds(201, 104, 84, 22);
		panel_2.add(print);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(201, 196, 184));
		panel_3.setBounds(10, 23, 545, 42);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("德文檢定報名");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		lblNewLabel.setBounds(205, 10, 137, 22);
		panel_3.add(lblNewLabel);
		
		lblTime = new JLabel();//顯示時間
		lblTime.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblTime.setBounds(370, 7, 190, 14);
		contentPane.add(lblTime);
		
		
		
		/******event******/
		
		//右上角timer
	
		Timer timer = new Timer(1000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		                .format(new Date());
		        lblTime.setText("目前時間：" + time);
		    }
		});
		timer.start();
		
		
		//全科時，單科不能選
		combo.addActionListener(e -> {
		    boolean isCombo = combo.isSelected();
		    listen.setEnabled(!isCombo);
		    speak.setEnabled(!isCombo);
		    read.setEnabled(!isCombo);
		    write.setEnabled(!isCombo);

		    //如果選了全科，順便把單科勾選清掉
		    if (isCombo) {
		        listen.setSelected(false);
		        speak.setSelected(false);
		        read.setSelected(false);
		        write.setSelected(false);
		    }
		});

		
		
		//確認按鈕
		cfm.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        // 1)取級數前兩碼：A1/A2/B1...
		        String selected = level.getSelectedItem().toString();
		        String lv = selected.substring(0, 2);

		        // 2) combo：
		        //    勾選=全科，沒勾=單科（用聽說讀寫勾選）
		        boolean isCombo = combo.isSelected();

		        // 3) 建model
		        HwModel m = new HwModel(
		                name.getText().trim(),
		                birthday.getText().trim(),
		                mobileNumber.getText().trim(),
		                member.isSelected(),
		                lv,
		                isCombo,
		                listen.isSelected(),
		                speak.isSelected(),
		                read.isSelected(),
		                write.isSelected()
		        );

		        txtDetail.setText(m.getDetail());
		    }
		});

		
		
			
		//清除
		del.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        name.setText("");
		        birthday.setText("");
		        mobileNumber.setText("");

		        member.setSelected(false);

		        // 預設回全科
		        combo.setSelected(false);

		        // 科目清掉
		        listen.setSelected(false);
		        speak.setSelected(false);
		        read.setSelected(false);
		        write.setSelected(false);

		        // 級數回到第一個
		        level.setSelectedIndex(0);

		        txtDetail.setText("");
		    }
		});

		
		
		
		//列印
		print.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		            txtDetail.print();
		        } catch (PrinterException ex) {
		            ex.printStackTrace();
		        }
		    }});
		
		
		
		//關閉整個程式
		close.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		    }
		});

		

		
		
		
		
		
		
		
	}
}
