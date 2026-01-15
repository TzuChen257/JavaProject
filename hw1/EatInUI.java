package hw1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;

public class EatInUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EatInUI frame = new EatInUI();
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
	public EatInUI() {
		setTitle("欣欣火鍋店 - 內用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1022, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239, 232, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 232, 216));
		panel.setBounds(10, 67, 636, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("沙茶湯底");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(26, 75, 79, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("昆布湯底");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(26, 152, 79, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("麻辣湯底");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(26, 226, 79, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("豬肉");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(182, 10, 46, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("雞肉");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(345, 10, 48, 25);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("牛肉");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(510, 10, 48, 25);
		panel.add(lblNewLabel_3_1_1);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(163, 99, 54));
		panel_1.setBounds(656, 10, 342, 580);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("餐點明細");
		lblNewLabel_4.setForeground(new Color(240, 240, 240));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(112, 10, 112, 47);
		panel_1.add(lblNewLabel_4);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 66, 322, 440);
		panel_1.add(output);
		
		JLabel basicShare = new JLabel("");
		basicShare.setForeground(new Color(255, 0, 0));
		basicShare.setBounds(296, 322, 212, 14);
		panel.add(basicShare);
		
		JLabel lblNewLabel_6 = new JLabel("120元");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6.setBounds(163, 59, 84, 34);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("120元");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_1.setBounds(331, 59, 84, 34);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("130元");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_2.setBounds(495, 59, 84, 34);
		panel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("110元");
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_3.setBounds(163, 136, 84, 34);
		panel.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("110元");
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_4.setBounds(331, 136, 84, 34);
		panel.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("120元");
		lblNewLabel_6_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_5.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_5.setBounds(495, 136, 84, 34);
		panel.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_6_6 = new JLabel("130元");
		lblNewLabel_6_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_6.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_6.setBounds(163, 210, 84, 34);
		panel.add(lblNewLabel_6_6);
		
		JLabel lblNewLabel_6_7 = new JLabel("130元");
		lblNewLabel_6_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_7.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_7.setBounds(331, 210, 84, 34);
		panel.add(lblNewLabel_6_7);
		
		JLabel lblNewLabel_6_8 = new JLabel("140元");
		lblNewLabel_6_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_8.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_8.setBounds(495, 210, 84, 34);
		panel.add(lblNewLabel_6_8);
		
		JLabel lblNewLabel_6_9 = new JLabel("90元");
		lblNewLabel_6_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_9.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_9.setBounds(163, 291, 84, 34);
		panel.add(lblNewLabel_6_9);
		
		JLabel spicyPork = new JLabel("0");
		spicyPork.setHorizontalAlignment(SwingConstants.CENTER);
		spicyPork.setFont(new Font("新細明體", Font.PLAIN, 13));
		spicyPork.setBounds(182, 250, 45, 14);
		panel.add(spicyPork);
		
		JLabel kombuPork = new JLabel("0");
		kombuPork.setHorizontalAlignment(SwingConstants.CENTER);
		kombuPork.setFont(new Font("新細明體", Font.PLAIN, 13));
		kombuPork.setBounds(182, 176, 45, 14);
		panel.add(kombuPork);
		
		JLabel shachaPork = new JLabel("0");
		shachaPork.setHorizontalAlignment(SwingConstants.CENTER);
		shachaPork.setFont(new Font("新細明體", Font.PLAIN, 13));
		shachaPork.setBounds(182, 99, 45, 14);
		panel.add(shachaPork);
		
		JLabel shachaChi = new JLabel("0");
		shachaChi.setHorizontalAlignment(SwingConstants.CENTER);
		shachaChi.setFont(new Font("新細明體", Font.PLAIN, 13));
		shachaChi.setBounds(348, 99, 45, 14);
		panel.add(shachaChi);
		
		JLabel kombuChi = new JLabel("0");
		kombuChi.setHorizontalAlignment(SwingConstants.CENTER);
		kombuChi.setFont(new Font("新細明體", Font.PLAIN, 13));
		kombuChi.setBounds(348, 176, 45, 14);
		panel.add(kombuChi);
		
		JLabel spicyChi = new JLabel("0");
		spicyChi.setHorizontalAlignment(SwingConstants.CENTER);
		spicyChi.setFont(new Font("新細明體", Font.PLAIN, 13));
		spicyChi.setBounds(348, 250, 45, 14);
		panel.add(spicyChi);
		
		JLabel shachaBeef = new JLabel("0");
		shachaBeef.setHorizontalAlignment(SwingConstants.CENTER);
		shachaBeef.setFont(new Font("新細明體", Font.PLAIN, 13));
		shachaBeef.setBounds(513, 99, 45, 14);
		panel.add(shachaBeef);
		
		JLabel kombuBeef = new JLabel("0");
		kombuBeef.setHorizontalAlignment(SwingConstants.CENTER);
		kombuBeef.setFont(new Font("新細明體", Font.PLAIN, 13));
		kombuBeef.setBounds(513, 176, 45, 14);
		panel.add(kombuBeef);
		
		JLabel spicyBeef = new JLabel("0");
		spicyBeef.setHorizontalAlignment(SwingConstants.CENTER);
		spicyBeef.setFont(new Font("新細明體", Font.PLAIN, 13));
		spicyBeef.setBounds(513, 250, 45, 14);
		panel.add(spicyBeef);
		
		JLabel lblNewLabel_7 = new JLabel("*內用自助吧自取，酌收一成服務費");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_7.setBounds(26, 431, 293, 34);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2_1 = new JLabel("共鍋人數");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(26, 307, 79, 34);
		panel.add(lblNewLabel_2_1);
				
		JLabel bonus = new JLabel("會員內用享免服務費");
		bonus.setForeground(new Color(0, 0, 0));
		bonus.setBounds(109, 404, 212, 14);
		panel.add(bonus);
		
		JLabel labeltime = new JLabel("現在時間：");
		labeltime.setFont(new Font("新細明體", Font.BOLD, 16));
		labeltime.setBackground(Color.WHITE);
		labeltime.setBounds(36, 10, 84, 47);
		contentPane.add(labeltime);
		
		JLabel timeNow = new JLabel("");
		timeNow.setFont(new Font("新細明體", Font.BOLD, 16));
		timeNow.setBackground(new Color(255, 255, 255));
		timeNow.setBounds(130, 10, 375, 47);
		contentPane.add(timeNow);
		
		Timer timer=new Timer(1000, (ActionListener) new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				timeNow.setText(time);
			}
		});
		timer.start();
		
		JLabel share = new JLabel("0");
		share.setFont(new Font("新細明體", Font.PLAIN, 13));
		share.setHorizontalAlignment(SwingConstants.CENTER);
		share.setBounds(182, 329, 45, 14);
		panel.add(share);
		
		/********botton event01choose**********/
		
		JButton minSaP = new JButton("-");
		minSaP.setBackground(new Color(240, 240, 240));
		minSaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaPork=Integer.parseInt(shachaPork.getText());
				if(ShachaPork>0)
				{
					shachaPork.setText(""+(--ShachaPork));
				}
			}
		});
		minSaP.setBounds(130, 95, 48, 22);
		panel.add(minSaP);
		
		JButton plSaP = new JButton("+");
		plSaP.setBackground(new Color(240, 240, 240));
		plSaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaPork=Integer.parseInt(shachaPork.getText());
				shachaPork.setText(""+(++ShachaPork));
			}
		});
		plSaP.setBounds(231, 95, 48, 22);
		panel.add(plSaP);
		
		JButton minSaC = new JButton("-");
		minSaC.setBackground(new Color(240, 240, 240));
		minSaC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaChi=Integer.parseInt(shachaChi.getText());
				if(ShachaChi>0)
				{
					shachaChi.setText(""+(--ShachaChi));
				}
			}
		});
		minSaC.setBounds(296, 95, 48, 22);
		panel.add(minSaC);
		
		JButton plSaC = new JButton("+");
		plSaC.setBackground(new Color(240, 240, 240));
		plSaC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaChi=Integer.parseInt(shachaChi.getText());
				shachaChi.setText(""+(++ShachaChi));
			}
		});
		plSaC.setBounds(398, 95, 48, 22);
		panel.add(plSaC);
		
		JButton minSaB = new JButton("-");
		minSaB.setBackground(new Color(240, 240, 240));
		minSaB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaBeef=Integer.parseInt(shachaBeef.getText());
				if(ShachaBeef>0)
				{
					shachaBeef.setText(""+(--ShachaBeef));
				}
			}
		});
		minSaB.setBounds(460, 95, 48, 22);
		panel.add(minSaB);
		
		JButton plSaB = new JButton("+");
		plSaB.setBackground(new Color(240, 240, 240));
		plSaB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaBeef=Integer.parseInt(shachaBeef.getText());
				shachaBeef.setText(""+(++ShachaBeef));
			}
		});
		plSaB.setBounds(562, 95, 48, 22);
		panel.add(plSaB);
		
		JButton minKP = new JButton("-");
		minKP.setBackground(new Color(240, 240, 240));
		minKP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int KombuPork=Integer.parseInt(kombuPork.getText());
				if(KombuPork>0)
				{
					kombuPork.setText(""+(--KombuPork));
				}
			}
		});
		minKP.setBounds(130, 172, 48, 22);
		panel.add(minKP);
		
		JButton plKP = new JButton("+");
		plKP.setBackground(new Color(240, 240, 240));
		plKP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int KombuPork=Integer.parseInt(kombuPork.getText());
				kombuPork.setText(""+(++KombuPork));
			}
		});
		plKP.setBounds(231, 172, 48, 22);
		panel.add(plKP);
		
		JButton minKC = new JButton("-");
		minKC.setBackground(new Color(240, 240, 240));
		minKC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int KombuChi=Integer.parseInt(kombuChi.getText());
				if(KombuChi>0)
				{
					kombuChi.setText(""+(--KombuChi));
				}
			}
		});
		minKC.setBounds(296, 172, 48, 22);
		panel.add(minKC);
		
		JButton plKC = new JButton("+");
		plKC.setBackground(new Color(240, 240, 240));
		plKC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int KombuChi=Integer.parseInt(kombuChi.getText());
				kombuChi.setText(""+(++KombuChi));
			}
		});
		plKC.setBounds(398, 172, 48, 22);
		panel.add(plKC);
		
		JButton minKB = new JButton("-");
		minKB.setBackground(new Color(240, 240, 240));
		minKB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int KombuBeef=Integer.parseInt(kombuBeef.getText());
				if(KombuBeef>0)
				{
					kombuBeef.setText(""+(--KombuBeef));
				}
			}
		});
		minKB.setBounds(460, 172, 48, 22);
		panel.add(minKB);
		
		JButton plKB = new JButton("+");
		plKB.setBackground(new Color(240, 240, 240));
		plKB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int KombuBeef=Integer.parseInt(kombuBeef.getText());
				kombuBeef.setText(""+(++KombuBeef));
			}
		});
		plKB.setBounds(562, 172, 48, 22);
		panel.add(plKB);
		
		JButton minSpP = new JButton("-");
		minSpP.setBackground(new Color(240, 240, 240));
		minSpP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SpicyPork=Integer.parseInt(spicyPork.getText());
				if(SpicyPork>0)
				{
					spicyPork.setText(""+(--SpicyPork));
				}
			}
		});
		minSpP.setBounds(130, 246, 48, 22);
		panel.add(minSpP);
		
		JButton plSpP = new JButton("+");
		plSpP.setBackground(new Color(240, 240, 240));
		plSpP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SpicyPork=Integer.parseInt(spicyPork.getText());
				spicyPork.setText(""+(++SpicyPork));
			}
		});
		plSpP.setBounds(231, 246, 48, 22);
		panel.add(plSpP);
		
		JButton minSpC = new JButton("-");
		minSpC.setBackground(new Color(240, 240, 240));
		minSpC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SpicyChi=Integer.parseInt(spicyChi.getText());
				if(SpicyChi>0)
				{
					spicyChi.setText(""+(--SpicyChi));
				}
			}
		});
		minSpC.setBounds(296, 246, 48, 22);
		panel.add(minSpC);
		
		JButton plSpC = new JButton("+");
		plSpC.setBackground(new Color(240, 240, 240));
		plSpC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SpicyChi=Integer.parseInt(spicyChi.getText());
				spicyChi.setText(""+(++SpicyChi));
			}
		});
		plSpC.setBounds(398, 246, 48, 22);
		panel.add(plSpC);

		JButton minSpB = new JButton("-");
		minSpB.setBackground(new Color(240, 240, 240));
		minSpB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SpicyBeef=Integer.parseInt(spicyBeef.getText());
				if(SpicyBeef>0)
				{
					spicyBeef.setText(""+(--SpicyBeef));
				}
			}
		});
		minSpB.setBounds(460, 246, 48, 22);
		panel.add(minSpB);
		
		JButton plSpB = new JButton("+");
		plSpB.setBackground(new Color(240, 240, 240));
		plSpB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SpicyBeef=Integer.parseInt(spicyBeef.getText());
				spicyBeef.setText(""+(++SpicyBeef));
			}
		});
		plSpB.setBounds(562, 246, 48, 22);
		panel.add(plSpB);
		
		JButton minShare = new JButton("-");
		minShare.setBackground(new Color(240, 240, 240));
		minShare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Share=Integer.parseInt(share.getText());
				if(Share>0)
				{
					share.setText(""+(--Share));
				}
			}
		});
		minShare.setBounds(130, 327, 48, 22);
		panel.add(minShare);
		
		JButton plShare = new JButton("+");
		plShare.setBackground(new Color(240, 240, 240));
		plShare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaPork=Integer.parseInt(shachaPork.getText());
				int ShachaChi=Integer.parseInt(shachaChi.getText());
				int ShachaBeef=Integer.parseInt(shachaBeef.getText());
				int KombuPork=Integer.parseInt(kombuPork.getText());
				int KombuChi=Integer.parseInt(kombuChi.getText());
				int KombuBeef=Integer.parseInt(kombuBeef.getText());
				int SpicyPork=Integer.parseInt(spicyPork.getText());
				int SpicyChi=Integer.parseInt(spicyChi.getText());
				int SpicyBeef=Integer.parseInt(spicyBeef.getText());
				int potNum=ShachaPork+ShachaChi+ShachaBeef+KombuPork+KombuChi+KombuBeef+SpicyPork+SpicyChi+SpicyBeef;
				int Share=Integer.parseInt(share.getText());
				if(potNum>Share)
				{
					share.setText(""+(++Share));
				}
				else
				{
					basicShare.setText("一份鍋物最多一人共鍋");
				}
			}
		});
		plShare.setBounds(231, 327, 48, 22);
		panel.add(plShare);
		
		JCheckBox member = new JCheckBox("會員");
		member.setBackground(new Color(239, 232, 216));
		member.setFont(new Font("新細明體", Font.BOLD, 16));
		member.setBounds(21, 400, 79, 22);
		panel.add(member);
		
		/********botton event02act**********/
		
		JButton input = new JButton("送出");
		input.setBackground(new Color(240, 240, 240));
		input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ShachaPork=Integer.parseInt(shachaPork.getText());
				int ShachaChi=Integer.parseInt(shachaChi.getText());
				int ShachaBeef=Integer.parseInt(shachaBeef.getText());
				int KombuPork=Integer.parseInt(kombuPork.getText());
				int KombuChi=Integer.parseInt(kombuChi.getText());
				int KombuBeef=Integer.parseInt(kombuBeef.getText());
				int SpicyPork=Integer.parseInt(spicyPork.getText());
				int SpicyChi=Integer.parseInt(spicyChi.getText());
				int SpicyBeef=Integer.parseInt(spicyBeef.getText());
				int Share=Integer.parseInt(share.getText());
				
				EatIn i;
				try {
					i = new EatIn(member.isSelected(),ShachaPork,ShachaChi,ShachaBeef,KombuPork,KombuChi,KombuBeef,SpicyPork,SpicyChi,SpicyBeef,Share);
					output.setText("訂單時間："+timeNow.getText()+"\n"+i.showStr());
				} catch (Check e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					output.setText("請至少點一份鍋物。");
				}
				
			}
		});
		input.setBounds(495, 438, 84, 22);
		panel.add(input);
		
		JButton erase = new JButton("清除");
		erase.setBackground(new Color(240, 240, 240));
		erase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shachaPork.setText("0");
				shachaChi.setText("0");
				shachaBeef.setText("0");
				kombuPork.setText("0");
				kombuChi.setText("0");
				kombuBeef.setText("0");
				spicyPork.setText("0");
				spicyChi.setText("0");
				spicyBeef.setText("0");
				share.setText("0");
				member.setSelected(false);
				output.setText("");
			}
		});
		erase.setBounds(376, 438, 84, 22);
		panel.add(erase);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 214, 137));
		panel_2.setBounds(10, 59, 616, 65);
		panel.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(220, 184, 121));
		panel_2_1.setBounds(10, 135, 616, 65);
		panel.add(panel_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(225, 166, 121));
		panel_2_1_1.setBounds(10, 210, 616, 65);
		panel.add(panel_2_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(218, 201, 166));
		panel_3.setBounds(0, 0, 636, 364);
		panel.add(panel_3);
		
		JButton takeOut = new JButton("我要外帶");
		takeOut.setBackground(new Color(240, 240, 240));
		takeOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		takeOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "資料尚未儲存確定要離開？", "確認", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
				{
					TakeOutUI out=new TakeOutUI();
					out.setVisible(true);
					dispose();
				}
			}
		});
		takeOut.setBounds(54, 557, 84, 22);
		contentPane.add(takeOut);
		
		JButton leave = new JButton("離開");
		leave.setBackground(new Color(240, 240, 240));
		leave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		leave.setBounds(506, 557, 84, 22);
		contentPane.add(leave);
		
		JButton print = new JButton("列印明細");
		print.setBackground(new Color(240, 240, 240));
		print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
				}catch(PrinterException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		print.setBounds(129, 532, 84, 22);
		panel_1.add(print);
	}
}
