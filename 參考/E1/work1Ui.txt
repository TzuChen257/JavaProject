package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;


public class work extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;
	private JTextField au;
	private JTextField pt;
	private JTextField ag;
	private JLabel 黃金;
	private JLabel 鉑金;
	private JLabel 白銀;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_2;
	private JLabel labeltime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					work frame = new work();
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
	public work() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 294);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("炫麗貴金屬");
		lblNewLabel.setBounds(182, 0, 96, 39);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(220, 49, 242, 166);
		contentPane.add(textArea);
		
		lblNewLabel_1 = new JLabel("訂單列印");
		lblNewLabel_1.setBounds(307, 19, 68, 20);
		lblNewLabel_1.setForeground(new Color(128, 64, 0));
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		contentPane.add(lblNewLabel_1);
		
		au = new JTextField();
		au.setBounds(146, 28, 25, 20);
		contentPane.add(au);
		au.setColumns(10);
		
		pt = new JTextField();
		pt.setBounds(146, 49, 25, 20);
		contentPane.add(pt);
		pt.setColumns(10);
		
		ag = new JTextField();
		ag.setBounds(146, 72, 25, 20);
		contentPane.add(ag);
		ag.setColumns(10);
		
		黃金 = new JLabel("黃    金 15000/一錢");
		黃金.setBackground(SystemColor.activeCaption);
		黃金.setForeground(new Color(64, 128, 128));
		黃金.setBounds(10, 30, 126, 14);
		contentPane.add(黃金);
		
		鉑金 = new JLabel("鉑    金  7000/一錢");
		鉑金.setForeground(SystemColor.activeCaptionText);
		鉑金.setBounds(10, 52, 126, 14);
		contentPane.add(鉑金);
		
		白銀 = new JLabel("白   銀   2600/一盎司");
		白銀.setForeground(new Color(192, 192, 192));
		白銀.setBounds(10, 75, 126, 14);
		contentPane.add(白銀);
		
		
		
		JCheckBox 非會員 = new JCheckBox("非會員");
		buttonGroup.add(非會員);
		非會員.setBounds(106, 103, 68, 22);
		contentPane.add(非會員);
		
		JCheckBox 會員 = new JCheckBox("會員");
		buttonGroup.add(會員);
		會員.setBounds(10, 103, 54, 22);
		會員.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(會員);
		
		JLabel TimeEx = new JLabel("");
		TimeEx.setBounds(24, 328, 142, 35);
		contentPane.add(TimeEx);
		
		lblNewLabel_2 = new JLabel("會員95折 ");
		lblNewLabel_2.setFont(new Font("PMingLiU", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(20, 188, 136, 39);
		contentPane.add(lblNewLabel_2);
		
		labeltime = new JLabel("");
		labeltime.setBounds(19, 233, 217, 24);
		contentPane.add(labeltime);
		Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		labeltime.setText("目前時間：" + time);
		    }
		});
		timer.start();
		
		
		/*______________event____________________*/
		
		JButton btnNewButton = new JButton("結帳");
		btnNewButton.setBounds(10, 131, 68, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				
				
				int Au=Integer.parseInt(au.getText());
				int Pt=Integer.parseInt(pt.getText());
				int Ag=Integer.parseInt(ag.getText());
				if(Au>=0&&Pt>=0&&Ag>=0) {
				
				work1 aaa=new work1(Au,Pt,Ag,會員.isSelected());
				textArea.setText("總數:"+"\n黃金:"+Au+"\n鉑金:"+Pt+"\n白銀:"+Ag+"\n總額:"+aaa.getSum());
				
				}
				else
				{
					textArea.setText("請重新輸入");
					
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				au.setText("");
				pt.setText("");
				ag.setText("");
				會員.setSelected(false);
				textArea.setText("");
			}
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(86, 131, 68, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("離開");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(375, 218, 68, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("列印");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							textArea.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(385, 1, 62, 39);
		contentPane.add(btnNewButton_3);
	}
}
