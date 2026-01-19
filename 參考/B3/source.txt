package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rocketBuger;
	private JTextField fries;
	private JTextField onionRings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUi frame = new OrderUi();
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
	public OrderUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 255, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SNOW BURGERS");
		lblNewLabel.setForeground(new Color(27, 49, 35));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblNewLabel.setBounds(203, 6, 246, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_Date = new JLabel("時間日期");
		lblNewLabel_Date.setForeground(new Color(20, 52, 35));
		lblNewLabel_Date.setBounds(314, 41, 246, 22);
		contentPane.add(lblNewLabel_Date);

		JLabel lblNewLabel_2 = new JLabel("芝麻葉起司漢堡");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(102, 100, 138, 22);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_2 = new JLabel("薯條");
		lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(102, 168, 138, 22);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("洋蔥圈");
		lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(102, 202, 138, 22);
		contentPane.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_3 = new JLabel("份");
		lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(326, 100, 31, 22);
		contentPane.add(lblNewLabel_2_3);

		rocketBuger = new JTextField();
		rocketBuger.setText("0");
		rocketBuger.setBounds(268, 101, 39, 22);
		contentPane.add(rocketBuger);
		rocketBuger.setColumns(10);

		fries = new JTextField();
		fries.setText("0");
		fries.setColumns(10);
		fries.setBounds(268, 169, 39, 22);
		contentPane.add(fries);

		onionRings = new JTextField();
		onionRings.setText("0");
		onionRings.setColumns(10);
		onionRings.setBounds(268, 203, 39, 22);
		contentPane.add(onionRings);

		JLabel lblNewLabel_2_3_1 = new JLabel("份");
		lblNewLabel_2_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_3_1.setBounds(326, 168, 31, 22);
		contentPane.add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_2_3_2 = new JLabel("份");
		lblNewLabel_2_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_3_2.setBounds(327, 206, 31, 22);
		contentPane.add(lblNewLabel_2_3_2);

		JCheckBox setMeal = new JCheckBox("＋套餐超值（薯條＋飲品）<僅限購一份>");
		setMeal.setForeground(new Color(74, 85, 105));
		setMeal.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		setMeal.setBounds(96, 134, 279, 23);
		contentPane.add(setMeal);

		JTextArea output = new JTextArea();
		output.setBounds(57, 284, 487, 89);
		contentPane.add(output);

		JLabel lblNewLabel_2_1 = new JLabel("＄180");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(387, 100, 138, 22);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("＄70");
		lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(387, 139, 138, 22);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("＄70");
		lblNewLabel_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(387, 172, 138, 22);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("＄70");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(387, 206, 138, 22);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		/************** event ***************/
		// 日期時間
				Timer timer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
						lblNewLabel_Date.setText("目前時間：" + time);
					}
				});
				timer.start();
				
		// 結帳
		JButton btnNewButton = new JButton("結帳");
		btnNewButton.setForeground(new Color(14, 78, 139));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String RocketBuger = rocketBuger.getText();
				String Fries = fries.getText();
				String OnionRings = onionRings.getText();

				int ROCKETBUGER = Integer.parseInt(RocketBuger);
				int FRIES = Integer.parseInt(Fries);
				int ONIONRINGS = Integer.parseInt(OnionRings);

				if (ROCKETBUGER >= 0 && FRIES >= 0 && ONIONRINGS >= 0) {
					Order o = new Order(ROCKETBUGER, FRIES, ONIONRINGS, setMeal.isSelected());
					output.setText("芝麻葉起司漢堡:\t" + o.getRocketBuger() + "份" +
					               "\n套餐:" + o.isSetMeal() +
					               "\n薯條:"+ o.getFries() + "份" +
					               "\n洋蔥圈:" + o.getOnionRings() + "份" + 
					               "\n總金額:" + o.getSum() + "元");
				} 
				else 
				{
					output.setText("餐點數量有誤喔");
				}

			}
		});
		btnNewButton.setBounds(233, 249, 117, 29);
		contentPane.add(btnNewButton);

		// 離開
		JButton btnNewButton_1_1_1 = new JButton("離開");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1_1.setBounds(387, 385, 117, 29);
		contentPane.add(btnNewButton_1_1_1);

		// 清除
		JButton btnClear = new JButton("清除");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnClear.addActionListener(w -> {
					rocketBuger.setText("0");
					fries.setText("0");
					onionRings.setText("0");
					setMeal.setSelected(false);
					output.setText("");
				});
			}
		});
		btnClear.setBounds(102, 385, 117, 29);
		contentPane.add(btnClear);

		// 列印
		JButton btnPrint = new JButton("列印");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPrint.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							output.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		btnPrint.setBounds(233, 385, 117, 29);
		contentPane.add(btnPrint);

		

	}
}
