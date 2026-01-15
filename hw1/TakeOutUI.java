package hw1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TakeOutUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField shachaPork;
	private JTextField kombuPork;
	private JTextField spicyPork;
	private JTextField shachaChi;
	private JTextField kombuChi;
	private JTextField spicyChi;
	private JTextField shachaBeef;
	private JTextField kombuBeef;
	private JTextField spicyBeef;
	private JTextField rice;
	private JTextField noodle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeOutUI frame = new TakeOutUI();
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
	public TakeOutUI() {
		setTitle("欣欣火鍋店 - 外帶");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1022, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 234, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(226, 234, 219));
		panel.setBounds(10, 67, 636, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("沙茶湯底");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(21, 75, 79, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("昆布湯底");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(21, 152, 79, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("麻辣湯底");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(21, 226, 79, 34);
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
		
		shachaPork = new JTextField();
		shachaPork.setHorizontalAlignment(SwingConstants.CENTER);
		shachaPork.setText("0");
		shachaPork.setBounds(182, 96, 46, 20);
		panel.add(shachaPork);
		shachaPork.setColumns(10);
		
		kombuPork = new JTextField();
		kombuPork.setText("0");
		kombuPork.setHorizontalAlignment(SwingConstants.CENTER);
		kombuPork.setColumns(10);
		kombuPork.setBounds(182, 173, 46, 20);
		panel.add(kombuPork);
		
		spicyPork = new JTextField();
		spicyPork.setText("0");
		spicyPork.setHorizontalAlignment(SwingConstants.CENTER);
		spicyPork.setColumns(10);
		spicyPork.setBounds(182, 247, 46, 20);
		panel.add(spicyPork);
		
		shachaChi = new JTextField();
		shachaChi.setText("0");
		shachaChi.setHorizontalAlignment(SwingConstants.CENTER);
		shachaChi.setColumns(10);
		shachaChi.setBounds(348, 96, 46, 20);
		panel.add(shachaChi);
		
		kombuChi = new JTextField();
		kombuChi.setText("0");
		kombuChi.setHorizontalAlignment(SwingConstants.CENTER);
		kombuChi.setColumns(10);
		kombuChi.setBounds(347, 173, 46, 20);
		panel.add(kombuChi);
		
		spicyChi = new JTextField();
		spicyChi.setText("0");
		spicyChi.setHorizontalAlignment(SwingConstants.CENTER);
		spicyChi.setColumns(10);
		spicyChi.setBounds(347, 247, 46, 20);
		panel.add(spicyChi);
		
		shachaBeef = new JTextField();
		shachaBeef.setText("0");
		shachaBeef.setHorizontalAlignment(SwingConstants.CENTER);
		shachaBeef.setColumns(10);
		shachaBeef.setBounds(512, 96, 46, 20);
		panel.add(shachaBeef);
		
		kombuBeef = new JTextField();
		kombuBeef.setText("0");
		kombuBeef.setHorizontalAlignment(SwingConstants.CENTER);
		kombuBeef.setColumns(10);
		kombuBeef.setBounds(512, 173, 46, 20);
		panel.add(kombuBeef);
		
		spicyBeef = new JTextField();
		spicyBeef.setText("0");
		spicyBeef.setHorizontalAlignment(SwingConstants.CENTER);
		spicyBeef.setColumns(10);
		spicyBeef.setBounds(512, 247, 46, 20);
		panel.add(spicyBeef);
		
		rice = new JTextField();
		rice.setText("0");
		rice.setHorizontalAlignment(SwingConstants.CENTER);
		rice.setColumns(10);
		rice.setBounds(182, 339, 46, 20);
		panel.add(rice);
		
		noodle = new JTextField();
		noodle.setText("0");
		noodle.setHorizontalAlignment(SwingConstants.CENTER);
		noodle.setColumns(10);
		noodle.setBounds(347, 339, 46, 20);
		panel.add(noodle);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(38, 69, 61));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(656, 10, 342, 580);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("餐點明細");
		lblNewLabel_4.setForeground(new Color(240, 240, 240));
		lblNewLabel_4.setBounds(112, 10, 112, 47);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 16));
		panel_1.add(lblNewLabel_4);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 66, 322, 440);
		panel_1.add(output);
		
		JLabel basicMain = new JLabel("");
		basicMain.setForeground(new Color(255, 0, 0));
		basicMain.setBounds(460, 325, 166, 14);
		panel.add(basicMain);
		
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
		
		JLabel lblNewLabel_6_9 = new JLabel("白飯");
		lblNewLabel_6_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_9.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_9.setBounds(163, 302, 84, 34);
		panel.add(lblNewLabel_6_9);
		
		JLabel lblNewLabel_2_1 = new JLabel("附餐主食");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(21, 302, 79, 34);
		panel.add(lblNewLabel_2_1);
				
		JLabel bonus = new JLabel("會員享附餐主食免費");
		bonus.setForeground(new Color(0, 0, 0));
		bonus.setBounds(110, 403, 212, 14);
		panel.add(bonus);
		
		JLabel lblNewLabel_6_9_1 = new JLabel("王子麵");
		lblNewLabel_6_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_9_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_6_9_1.setBounds(331, 302, 84, 34);
		panel.add(lblNewLabel_6_9_1);
		
		JLabel lblNewLabel_5 = new JLabel("每份10元");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(21, 342, 65, 14);
		panel.add(lblNewLabel_5);
		
		JCheckBox member = new JCheckBox("會員");
		member.setBackground(new Color(226, 234, 219));
		member.setFont(new Font("新細明體", Font.BOLD, 16));
		member.setBounds(21, 399, 79, 22);
		panel.add(member);
		
		JCheckBox bag = new JCheckBox("加購購物袋2元");
		bag.setBackground(new Color(226, 234, 219));
		bag.setFont(new Font("新細明體", Font.BOLD, 16));
		bag.setBounds(336, 399, 144, 22);
		panel.add(bag);
		
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
		
		JButton minRice = new JButton("-");
		minRice.setBackground(new Color(240, 240, 240));
		minRice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		minRice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Rice=Integer.parseInt(rice.getText());
				if(Rice>0)
				{
					rice.setText(""+(--Rice));
				}
			}
		});
		minRice.setBounds(130, 338, 48, 22);
		panel.add(minRice);
		
		JButton plRice = new JButton("+");
		plRice.setBackground(new Color(240, 240, 240));
		plRice.addMouseListener(new MouseAdapter() {
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
				int Rice=Integer.parseInt(rice.getText());
				int Noodle=Integer.parseInt(noodle.getText());
				int BasicMain=Rice+Noodle;
				if(potNum>BasicMain)
				{
					rice.setText(""+(++Rice));
				}
				else
				{
					basicMain.setText("一份鍋物最多一份主食");
				}
			}
		});
		plRice.setBounds(231, 338, 48, 22);
		panel.add(plRice);
		
		JButton minNoodle = new JButton("-");
		minNoodle.setBackground(new Color(240, 240, 240));
		minNoodle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Noodle=Integer.parseInt(noodle.getText());
				if(Noodle>0)
				{
					noodle.setText(""+(--Noodle));
				}
			}
		});
		minNoodle.setBounds(296, 338, 48, 22);
		panel.add(minNoodle);
		
		JButton plNoodle = new JButton("+");
		plNoodle.setBackground(new Color(240, 240, 240));
		plNoodle.addMouseListener(new MouseAdapter() {
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
				int Rice=Integer.parseInt(rice.getText());
				int Noodle=Integer.parseInt(noodle.getText());
				int BasicMain=Rice+Noodle;
				if(potNum>BasicMain)
				{
					noodle.setText(""+(++Noodle));
				}
				else
				{
					basicMain.setText("一份鍋物最多一份主食");
				}
			}
		});
		plNoodle.setBounds(398, 338, 48, 22);
		panel.add(plNoodle);
		
		
		
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
				int Rice=Integer.parseInt(rice.getText());
				int Noodle=Integer.parseInt(noodle.getText());
				
				TakeOut o;
				try {
					o = new TakeOut(member.isSelected(),ShachaPork,ShachaChi,ShachaBeef,KombuPork,KombuChi,KombuBeef,SpicyPork,SpicyChi,SpicyBeef,bag.isSelected(),Rice,Noodle);
					output.setText("訂單時間："+timeNow.getText()+"\n"+o.showStr());
				} catch (Check e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					output.setText("請輸入正確數量，火鍋及主食數量皆須>=0。");
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
				rice.setText("0");
				noodle.setText("0");
				member.setSelected(false);
				bag.setSelected(false);
				output.setText("");
			}
		});
		erase.setBounds(376, 438, 84, 22);
		panel.add(erase);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(181, 202, 160));
		panel_2.setBounds(0, 0, 636, 380);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(177, 180, 121));
		panel_3.setBounds(10, 59, 616, 65);
		panel_2.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(145, 180, 147));
		panel_3_1.setBounds(10, 134, 616, 65);
		panel_2.add(panel_3_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(145, 173, 112));
		panel_3_1_1.setBounds(10, 209, 616, 65);
		panel_2.add(panel_3_1_1);

		JButton eatIn = new JButton("我想內用");
		eatIn.setBackground(new Color(240, 240, 240));
		eatIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		eatIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "資料尚未儲存確定要離開？", "確認", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
				{
					EatInUI in=new EatInUI();
					in.setVisible(true);
					dispose();
				}				
			}
		});
		eatIn.setBounds(54, 557, 84, 22);
		contentPane.add(eatIn);
		
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
		print.setBounds(129, 532, 84, 22);
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
		panel_1.add(print);

	}

}
