package Homework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Viewer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EmeraldField;
	private JScrollPane statusScrollPane;
	private JScrollPane buyListScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewer frame = new Viewer();
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
	public Viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 134, 85));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//建立商店物件
		Shop s = new Shop();
		String [][] sellList = s.getSellList();//0物品名稱 1物品售價 2交易exp 3商品可購買數
		
		//建立玩家物件
		Player p = new Player();
		
		//統整重複性的物件
		JPanel [] itemBoxes = new JPanel[7];//商品欄
		JLabel [] itemName = new JLabel[7];//商品名稱
		JLabel [] itemPrice = new JLabel[7];//商品價格
		JLabel [] itemLeft = new JLabel[7];//商品剩餘量
		
		//設定、調整圖片
		//綠寶石圖標
		java.net.URL emeraldImgURL = Viewer.class.getResource("/Homework/img/Emerald.png");
		ImageIcon emeraldIcon = new ImageIcon(emeraldImgURL);

		//村民圖片
		java.net.URL villagerImgURL = Viewer.class.getResource("/Homework/img/Villager.png");
		ImageIcon villagerIcon = new ImageIcon(villagerImgURL);
    	Image img = villagerIcon.getImage();
    	Image scaledVillagerImg = img.getScaledInstance(120, 180, Image.SCALE_DEFAULT);

    	//建立時間標籤
		JLabel dateLabel = new JLabel("");
		dateLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		dateLabel.setBounds(297, 10, 189, 15);
		contentPane.add(dateLabel);
		//設定時間listener
		Timer timer = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		        dateLabel.setText("目前時間：" + time);
		    }
		});
		timer.start();

		//建立狀態顯示欄
		JTextArea status = new JTextArea();
		status.setBounds(290, 283, 109, 202);
		status.setEditable(false);
		status.setText("事件紀錄\n----------\n");
		contentPane.add(status);
		
		//把購買狀態顯示欄放入scroll panel
		JScrollPane statusScrollPane;
		statusScrollPane = new JScrollPane(status);
		statusScrollPane.setBounds(290, 283, 130, 202);
		statusScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(statusScrollPane);
		
		
		//建立購買清單
		JTextArea buyList = new JTextArea();
		buyList.setBounds(409, 283, 289, 202);
		buyList.setEditable(false);
		buyList.setText("購買紀錄\n----------\n");
		contentPane.add(buyList);
		
		//把購買清單元件放入scroll panel
		JScrollPane buyListScrollPane;
		buyListScrollPane = new JScrollPane(buyList);
		buyListScrollPane.setBounds(430, 283, 268, 202);
		buyListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(buyListScrollPane);
		
		//建立商店區塊背景
		JPanel shopBg = new JPanel();
		shopBg.setBackground(new Color(128, 128, 128));
		shopBg.setBounds(10, 10, 270, 475);
		contentPane.add(shopBg);
		shopBg.setLayout(null);
		
		//建立村民圖案背景
		JPanel villagerBg = new JPanel();
		villagerBg.setBackground(new Color(128, 128, 128));
		villagerBg.setBounds(521, 88, 177, 185);
		contentPane.add(villagerBg);
		villagerBg.setLayout(null);
		shopBg.setLayout(null);
		
		//建立村民圖案標籤
		JLabel villagerImgLabel = new JLabel(new ImageIcon(scaledVillagerImg));
	    villagerImgLabel.setBounds(0, 0, 177, 185); 
	    villagerBg.add(villagerImgLabel);
	    villagerBg.revalidate();
		
		//建立村莊英雄選項
		JCheckBox villageHero = new JCheckBox("村莊英雄");
		villageHero.setFont(new Font("新細明體", Font.PLAIN, 14));
		villageHero.setBounds(302, 183, 87, 23);
		contentPane.add(villageHero);
		
		//建立綠寶石文字標籤
		JLabel lblNewLabel = new JLabel("綠寶石 : ");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(297, 46, 60, 15);
		contentPane.add(lblNewLabel);
		
		//建立綠寶石數字顯示標籤
		JLabel Emerald = new JLabel(""+p.getEmerald());
		Emerald.setFont(new Font("新細明體", Font.PLAIN, 14));
		Emerald.setBounds(353, 46, 345, 15);
		contentPane.add(Emerald);
		
		//建立彩蛋用的綠寶石數字輸入欄
		EmeraldField = new JTextField();		
		EmeraldField.setBounds(353, 43, 63, 21);
		contentPane.add(EmeraldField);
		EmeraldField.setVisible(false); // 預設隱藏
		EmeraldField.setColumns(10);
		
		//建立職業等級文字標籤
		JLabel lblNewLabel_1 = new JLabel("村民職業等級 : ");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(521, 10, 97, 27);
		contentPane.add(lblNewLabel_1);
		
		//建立職業等級數字標籤
		JLabel levelLbl = new JLabel(s.getLevelName());
		levelLbl.setFont(new Font("新細明體", Font.PLAIN, 14));
		levelLbl.setBounds(616, 10, 46, 27);
		contentPane.add(levelLbl);
		
		//建立經驗文字標籤
		JLabel lblNewLabel_3 = new JLabel("經驗 : ");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(521, 38, 46, 23);
		contentPane.add(lblNewLabel_3);
		
		//建立經驗數字標籤
		JLabel expLbl = new JLabel(s.getExp());
		expLbl.setFont(new Font("新細明體", Font.PLAIN, 14));
		expLbl.setBounds(577, 38, 90, 23);
		contentPane.add(expLbl);
		
		//建立心情文字標籤
		JLabel lblNewLabel_2 = new JLabel("村民心情 : ");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(297, 70, 68, 15);
		contentPane.add(lblNewLabel_2);
		
		//建立心情名稱標籤
		JLabel moodLbl = new JLabel(s.getMoodName());
		moodLbl.setFont(new Font("新細明體", Font.PLAIN, 14));
		moodLbl.setBounds(364, 71, 60, 15);
		contentPane.add(moodLbl);
		
		//建立血量文字標籤
		JLabel lblNewLabel_5 = new JLabel("血量 : ");
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(521, 63, 46, 23);
		contentPane.add(lblNewLabel_5);
		
		//建立血量數字標籤
		JLabel healthLbl = new JLabel(s.getHealth()+"/10");
		healthLbl.setFont(new Font("新細明體", Font.PLAIN, 14));
		healthLbl.setBounds(574, 63, 46, 23);
		contentPane.add(healthLbl);
		
		
		// ----------------- setting ----------------------
		
		//建立重複性的物件
		for (int i = 0; i < 7; i++) {
			itemBoxes[i] = new JPanel();
			itemBoxes[i].setBounds(10, 10 + (i * 66), 250, 56);
			shopBg.add(itemBoxes[i]);
			if(i>1) { //限制初始顯示的商品數
				itemBoxes[i].setVisible(false);
			}
			itemBoxes[i].setLayout(null);

		    //建立商品名稱標籤
		    itemName[i] = new JLabel("");
		    itemName[i].setFont(new Font("新細明體", Font.PLAIN, 14));
		    itemName[i].setBounds(10, 10, 135, 36);
		    itemBoxes[i].add(itemName[i]);    

		    //建立綠寶石圖示標籤
		    JLabel emeraldImgLbl = new JLabel(emeraldIcon);
		    emeraldImgLbl.setBounds(140, 21, 16, 16);
		    itemBoxes[i].add(emeraldImgLbl);

		    //建立價格標籤
		    itemPrice[i] = new JLabel("");
		    itemPrice[i].setFont(new Font("新細明體", Font.PLAIN, 14));
		    itemPrice[i].setBounds(160, 21, 25, 18);
		    itemBoxes[i].add(itemPrice[i]);

			//建立 "剩餘" 字樣標籤
		    JLabel lbl = new JLabel("剩餘 : ");
		    lbl.setFont(new Font("新細明體", Font.PLAIN, 14));
		    lbl.setBounds(190, 10, 40, 36);
		    itemBoxes[i].add(lbl);

		    //建立剩餘數量標籤
		    itemLeft[i] = new JLabel("");
		    itemLeft[i].setFont(new Font("新細明體", Font.PLAIN, 14));
		    itemLeft[i].setBounds(230, 10, 15, 36);
		    itemBoxes[i].add(itemLeft[i]);

    		final int index = i; 
    		
    		//為每一個商品格子建立listener
    		itemBoxes[i].addMouseListener(new MouseAdapter() {
    		    @Override
    		    public void mouseClicked(MouseEvent e) {
    		        String itemNameStr = itemName[index].getText();
    		        String price = itemPrice[index].getText();
					String exp = sellList[index][2];
					String left = itemLeft[index].getText();
    		        
					if((Integer.parseInt(left))>0){ //確認商品有剩餘
						if(Integer.parseInt(p.getEmerald())>=Integer.parseInt(price)){//確認持有金錢大於價格
							if(itemNameStr == "彩蛋-\"你渴望財富嗎?\""){
		    					Emerald.setVisible(false);     //調整顯示 讓綠寶石數量可編輯
		    					EmeraldField.setVisible(true);   
		    					EmeraldField.setText("" + p.getEmerald());
							}
							status.append("綠寶石 -"+price+"\n村民經驗 +"+exp+"\n----------\n");
							p.pay(price); //玩家付錢
							Emerald.setText(p.getEmerald());//更新持有金錢
							s.addExp(exp);//村民獲得經驗
							levelLbl.setText(s.getLevelName());//更新村民職業熟練度
							expLbl.setText(s.getExp());//更新村民當前經驗
							itemLeft[index].setText(""+(Integer.parseInt(left)-1));//更新商品餘量
							String entry = String.format("%-30s %5s綠寶石\n",itemNameStr, price);
							buyList.append(entry);
						}else{
							status.append("你沒錢了，去挖礦\n----------\n");
						}
					}else{
						status.append("沒貨了\n----------\n");
					}
					
    		        
					if(s.getLevel()>3 && s.getLevel() <7) {//依村民職業熟練度解除商品格的隱藏
						itemBoxes[2].setVisible(true);
						itemBoxes[3].setVisible(true);
					}else if(s.getLevel() >7) {
						itemBoxes[4].setVisible(true);
						itemBoxes[5].setVisible(true);
						itemBoxes[6].setVisible(true);
					}
    		    }
    		});
		}

		//設定商品內容
		for(int i=0;i<sellList.length;i++){
			itemName[i].setText(sellList[i][0]);
			itemPrice[i].setText(sellList[i][1]);
			itemLeft[i].setText(sellList[i][3]);
		} 

		// ----------------- button event --------------------
		
		//當村莊英雄的選項有變化時
		villageHero.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int discount=0;//建立折扣
				
				//依據心情值和村莊英雄選項給予對應折扣
				if(villageHero.isSelected()) {
					if(s.getMood()>0) {
						discount=-4;
					}else if(s.getMood()<0) {
						discount=2;
					}else {
						discount=-1;
					}
				}else {
					if(s.getMood()>0) {
						discount=-3;
					}else if(s.getMood()<0) {
						discount=3;
					}else {
						discount=0;
					}
				}
				
				setDiscount(itemPrice,sellList,discount);//設定折扣後價格
			}
		});
		
		//彩蛋用的編輯欄位
		EmeraldField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					p.setEmerald(Integer.parseInt(EmeraldField.getText())); 
					Emerald.setText("" + p.getEmerald());
					EmeraldField.setVisible(false);
					Emerald.setVisible(true);
				}catch(Exception except){
					javax.swing.JOptionPane.showMessageDialog(//玩家輸入非整數時跳出提醒
	            		    Viewer.this, 
	            		    "請輸入整數", 
	            		    "商店提示",
	            		     javax.swing.JOptionPane.WARNING_MESSAGE
	            		);
				}
	            
			}
		});
		
		//建立挖礦按鈕 點擊增加持有金錢
		JButton mine = new JButton("挖礦");
		mine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.mine();
				Emerald.setText(p.getEmerald());
			}
		});
		mine.setFont(new Font("新細明體", Font.PLAIN, 14));
		mine.setBounds(421, 35, 90, 49);
		contentPane.add(mine);
		
		//建立攻擊村民按鈕 點擊對村民造成 1點傷害 心情值-1
		JButton attack = new JButton("攻擊村民");
		attack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(s.attack()=="dead") { //村民死亡 交易結束
					healthLbl.setText(s.getHealth()+"/10");
					moodLbl.setText(s.getMoodName());
					javax.swing.JOptionPane.showMessageDialog(//死亡時跳出警告視窗
            		    Viewer.this, 
            		    "你把村民打死了，交易結束", 
            		    "商店提示",
            		     javax.swing.JOptionPane.WARNING_MESSAGE
            		);
					System.exit(0);
				}else {
					healthLbl.setText(s.getHealth()+"/10");
					moodLbl.setText(s.getMoodName());
					status.append("村民:噢!\n----------\n");
					int discount = 0;//依心情值給予折扣或加價
					if(villageHero.isSelected()) {//確認是否為村莊英雄
						if(s.getMood()<0) {
							discount=2;
						}else {
							discount=-1;
						}
					}else {
						if(s.getMood()<0) {
							discount=3;
						}else {
							discount=0;
						}
					}
					setDiscount(itemPrice,sellList,discount);//更新價格
				}
			}
		});
		attack.setFont(new Font("新細明體", Font.PLAIN, 14));
		attack.setBounds(421, 113, 90, 49);
		contentPane.add(attack);
		
		//建立送禮按鈕 點擊造成 玩家持有金錢-1 村民心情值+1
		JButton gift = new JButton("送禮");
		gift.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(p.gift() == "broked") {
					status.append("你沒錢了，去挖礦\n----------\n");
				}else {
					s.earnMoney();
					Emerald.setText(""+p.getEmerald());
					moodLbl.setText(s.getMoodName());
					int discount = 0;
					if(villageHero.isSelected()) {
						if(s.getMood()>0) {
							discount=-4;
						}else {
							discount=-1;
						}
					}else {
						if(s.getMood()>0) {
							discount=-3;
						}else {
							discount=0;
						}
					}
					setDiscount(itemPrice,sellList,discount);
				}
			}
		});
		gift.setFont(new Font("新細明體", Font.PLAIN, 14));
		gift.setBounds(302, 114, 87, 49);
		contentPane.add(gift);
		
		//建立列印按鈕 點擊將buyList輸出
		JButton print = new JButton("列印");
		print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					buyList.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		print.setFont(new Font("新細明體", Font.PLAIN, 14));
		print.setBounds(421, 227, 90, 46);
		contentPane.add(print);	
		
		//建立退出交易按鈕 點擊關閉視窗
		JButton exit = new JButton("退出交易");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("新細明體", Font.PLAIN, 14));
		exit.setBounds(421, 171, 90, 46);
		contentPane.add(exit);
		
		JButton clean = new JButton("清除");
		clean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				status.setText("事件紀錄\n----------\n");
			}
		});
		clean.setFont(new Font("新細明體", Font.PLAIN, 14));
		clean.setBounds(302, 227, 90, 46);
		contentPane.add(clean);

	}
	
	//設定折扣後價錢
	void setDiscount(JLabel[] itemPrice, String[][] sellList,int discount){
		for(int i=0;i<itemPrice.length;i++){
			int afterDiscount = (Integer.parseInt(sellList[i][1])+discount);
			if(afterDiscount>1)
				itemPrice[i].setText(""+afterDiscount);
			else
				itemPrice[i].setText("1");
		}
	}
}
