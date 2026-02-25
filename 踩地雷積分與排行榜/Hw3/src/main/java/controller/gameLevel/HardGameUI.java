package controller.gameLevel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.GameTopUI;
import controller.RuleUI;
import controller.rank.ResultRankUI;
import model.BombMap;
import model.Result;
import model.User;
import service.ResultServiceImpl;
import util.Tool;
import util.gameSettings.BombButton;
import util.gameSettings.BombMapTool;
import util.gameSettings.BombResources;
import util.gameSettings.GameControl;

public class HardGameUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user=(User) Tool.readObject("User");
	
	/**timeSettings**/
	private int timePass=0;
	private boolean isTimeStart=false;
	private boolean isGameover=false;
	private Timer gameTimer;
	
	//給method呼叫用所以拉出來外面宣告的變數
	private JLabel unKnowBomb,alarm,resultPic;
	private JLayeredPane layeredPane;
	private JPanel panel_1;
	private MouseAdapter timeStart;
	
	//Hard初始設定的包含(不同levelUI要調整的部分)：30*16，bomb99
	private int xMax=30;
	private int yMax=16;
	private int bombNum=99;
	private int gameLevel=3;
	private GameControl<HardGameUI> control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HardGameUI frame = new HardGameUI();
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
	public HardGameUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setJMenuBar(buildMenu());
		
		//圖層上下設定
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 920, 566);
		contentPane.add(layeredPane);
		
		//1)時間與炸彈個數計算放最下面
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 900, 57);
		layeredPane.add(panel_2, JLayeredPane.DEFAULT_LAYER);
		panel_2.setLayout(null);
		
		unKnowBomb = new JLabel("");
		unKnowBomb.setHorizontalAlignment(SwingConstants.RIGHT);
		unKnowBomb.setFont(BombResources.getDigitalFont("DS-DIGIB", 40f));
		unKnowBomb.setBounds(170, 10, 50, 37);
		panel_2.add(unKnowBomb);
		
		JLabel bombIcon = new JLabel(BombResources.getBackgroundImage("bomb"));
		bombIcon.setBounds(127, 10, 50, 37);
		panel_2.add(bombIcon);
		
		alarm = new JLabel("00:00");
		alarm.setHorizontalAlignment(SwingConstants.RIGHT);
		alarm.setFont(BombResources.getDigitalFont("DS-DIGIB", 40f));
		alarm.setBounds(711, 14, 89, 29);
		panel_2.add(alarm);
		
		JLabel clockIcon = new JLabel(BombResources.getBackgroundImage("alarm"));
		clockIcon.setBounds(635, 10, 50, 37);
		panel_2.add(clockIcon);
		
		//2)result改成最上面
		resultPic = new JLabel("");
		resultPic.setBounds((920-300)/2,500-320,300, 300);
		layeredPane.add(resultPic, JLayeredPane.DRAG_LAYER);
		
		/**timeSettings**/
		gameTimer=new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timePass++;
				int min=timePass/60;
				int sec=timePass%60;
				alarm.setText(String.format("%02d:%02d", min, sec));
			}
		});
		
		timeStart=new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!isTimeStart)
				{
					gameTimer.start();
					isTimeStart=true;
				}
			}
		};
		
		//GridLayout放button&button settings
		GridLayout grid=new GridLayout(yMax,xMax,1,1);
		BombMap[] newGame=BombMapTool.newMapSet(xMax,yMax,bombNum);
		//初始設定
		GameControl.bomb=bombNum;
		GameControl.flag=0;
		GameControl.buttonLast=xMax*yMax;
		
		unKnowBomb.setText(Integer.toString(GameControl.bomb));
		
		//3)button也放最下層
		panel_1 = new JPanel();
		panel_1.setBounds(10, 77, xMax*30, yMax*30);
		panel_1.setLayout(grid);
		panel_1.setBackground(Color.GRAY);
		layeredPane.add(panel_1, JLayeredPane.DEFAULT_LAYER);
		
		control=new GameControl<HardGameUI>(this,newGame);//遊戲初始化設定
		gridSetting(newGame);//面板與按紐置入
		
		Tool.saveLevel(gameLevel);
	}
	//所有button設定
	private void gridSetting(BombMap[] newGame)
	{
		Arrays.asList(newGame).stream().forEach(m->{
			JPanel panel_b = new JPanel();
			panel_b.setLayout(null);
			BombButton b=m.getButton();
			b.setBounds(0, 0, 30, 30);
			JLabel l=new JLabel(m.getImage());
			l.setBounds(0, 0, 30, 30);
			panel_b.add(b);
			panel_b.add(l);
			b.addMouseListener(timeStart);
			panel_1.add(panel_b);
			b.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(isGameover) return;//遊戲結束就不跑
					
					if(SwingUtilities.isLeftMouseButton(e))
					{
						if(!b.isFlag())
						{
							b.setVisible(false);
							GameControl.buttonLast--;
							if(m.isBomb())
							{
								gameOver("lose");
							}
							else
							{
								if(m.getSurroundBomb()==0)//如果是空白就開附近全部
								{
									//呼叫無限打開的方法
									control.revealEmpty(m);
								}
							}
						}
					}
					else if(SwingUtilities.isRightMouseButton(e))
					{
						if(b.isFlag())
						{
							b.setIcon(BombResources.getButtonImage("white"));
							b.setFlag(false);
							GameControl.flag--;
							int lastUpdate=GameControl.bomb-GameControl.flag;
							unKnowBomb.setText(Integer.toString(lastUpdate));							
						}
						else if(!(b.isFlag())&&GameControl.bomb>GameControl.flag)
						{
							b.setIcon(BombResources.getButtonImage("flag"));
							b.setFlag(true);
							GameControl.flag++;
							int lastUpdate=GameControl.bomb-GameControl.flag;
							unKnowBomb.setText(Integer.toString(lastUpdate));
						}
					}
					//無論如何的最後判斷
					if(control.iswin())
					{
						gameOver("win");
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					if(isGameover) return;//遊戲結束就不跑
				}
			});
		});//每一個button放在面板上
	}
	//reset
	private void resetGame()
	{
		//時間
		gameTimer.stop();
		timePass=0;
		isTimeStart=false;
		alarm.setText("00:00");
		//結果設定歸零
		isGameover=false;
		resultPic.setIcon(null);
		//遊戲初始值
		BombMap[] resetedGame=BombMapTool.newMapSet(xMax,yMax,bombNum);
		control=new GameControl<HardGameUI>(this,resetedGame);//遊戲初始化設定
		//確認該放哪
		GameControl.bomb=bombNum;
		GameControl.flag=0;
		GameControl.buttonLast=xMax*yMax;
		panel_1.removeAll();
		gridSetting(resetedGame);	
	}
	//遊戲結果
	private void gameOver(String type)//win or over(image引數)
	{
		isGameover=true;
		gameTimer.stop();
		
		if(type.equals("lose"))
		{
			BombResources.playSound(type);
			control.showAllBomb();
			Timer delayShow1=new Timer(2000,e1->{
				resultPic.setIcon(BombResources.getResultImage(type));
			});
			delayShow1.setRepeats(false);//執行一次
			delayShow1.start();
			Timer delayShow2=new Timer(5000,e1->{
				int respond=JOptionPane.showConfirmDialog(null,"是否重新挑戰","確認",JOptionPane.OK_CANCEL_OPTION);
				if(respond==JOptionPane.OK_OPTION) new HardGameUI().setVisible(true);
				else new GameTopUI().setVisible(true);
				dispose();
			});
			delayShow2.setRepeats(false);//執行一次
			delayShow2.start();
		}
		else//win
		{
			resultPic.setIcon(BombResources.getResultImage(type));
			if(!user.getUsername().equals("Guest"))
			{
				Result r=new Result(user.getUsername(),alarm.getText(),gameLevel);
				new ResultServiceImpl().newResult(r);
				BombResources.playSound(type);
			}
			Timer delayShow=new Timer(5000,e1->{
				new ResultRankUI().setVisible(true);
				dispose();
			});
			delayShow.setRepeats(false);//執行一次
			delayShow.start();
		}
	}
	//功能
	private JMenuBar buildMenu() {
		//主功能
		JMenuBar mbar=new JMenuBar();
		JMenu menu=new JMenu("選項(M)");
		menu.setMnemonic(KeyEvent.VK_M);
		mbar.add(menu);
		//項目
		JMenuItem item=new JMenuItem("說明(C)",KeyEvent.VK_C);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//時間暫停(停止再叫換的thread)
				new RuleUI().setVisible(true);
			}
		});
		menu.add(item);
		item=new JMenuItem("重新開始(N)",KeyEvent.VK_N);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		menu.add(item);
		item=new JMenuItem("排行榜(R)",KeyEvent.VK_R);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isTimeStart)
				{
					gameTimer.stop();
					int respond=JOptionPane.showConfirmDialog(null,"未完成的遊戲進度無法儲存，是否離開","警告",JOptionPane.OK_CANCEL_OPTION);
					if(respond==JOptionPane.OK_OPTION)
					{
						new ResultRankUI().setVisible(true);
						dispose();
					}
					else
					{
						gameTimer.start();
					}
				}
				else
				{
					new ResultRankUI().setVisible(true);
					dispose();
				}
			}
		});
		menu.add(item);
		item=new JMenuItem("回首頁(T)",KeyEvent.VK_T);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isTimeStart)
				{
					gameTimer.stop();
					int respond=JOptionPane.showConfirmDialog(null,"未完成的遊戲進度無法儲存，是否離開","警告",JOptionPane.OK_CANCEL_OPTION);
					if(respond==JOptionPane.OK_OPTION)
					{
						new GameTopUI().setVisible(true);
						dispose();
					}
					else
					{
						gameTimer.start();
					}
				}
				else
				{
					new GameTopUI().setVisible(true);
					dispose();
				}
			}
		});
		menu.add(item);
		return mbar;
	}
}
