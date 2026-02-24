package controller.rank;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import controller.GameTopUI;
import model.User;
import util.Tool;
import util.gameSettings.Ranking;
import util.tableModel.UserRankTableModel;
import util.ui.UITheme;
import util.ui.HighlightRowRenderer;

public class UserRankUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user=(User) Tool.readObject("User");
	private JTable table;
	private String username=((User)Tool.readObject("User")).getUsername();
	private UserRankTableModel tableModel=new UserRankTableModel(Ranking.userTopAndThis(username, 10));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRankUI frame = new UserRankUI();
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
	public UserRankUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 241);
		contentPane = new JPanel();
		contentPane.setBackground(UITheme.BG);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		/********setting********/
		
		JLabel topic = new JLabel("");
		topic.setBounds(10, 10, 243, 30);
		contentPane.add(topic);
		topic.setFont(UITheme.FONT_TITLE);
		topic.setForeground(UITheme.PRIMARY_DARK);
		topic.setHorizontalAlignment(SwingConstants.CENTER);
		topic.setText(tableModel.topic);
		//new table
		table=new JTable();
		table.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 243, 121);
		contentPane.add(scrollPane);
		UITheme.styleTableBasic(table);
		// 高亮自己（You）
		table.setDefaultRenderer(Object.class, new HighlightRowRenderer(username, 1));
		//設定欄寬
		TableColumn c0=table.getColumnModel().getColumn(0);
		TableColumn c1=table.getColumnModel().getColumn(1);
		TableColumn c2=table.getColumnModel().getColumn(2);
		
		setJMenuBar(buildMenu());
		c0.setPreferredWidth(5);
		c1.setPreferredWidth(30);
		c2.setPreferredWidth(30);

	}

	public JMenuBar buildMenu() {
		//主功能
		JMenuBar mbar=new JMenuBar();
		JMenu menu=new JMenu("選項(M)");
		menu.setMnemonic(KeyEvent.VK_M);
		mbar.add(menu);
		//項目
		JMenuItem item=new JMenuItem("回首頁(T)",KeyEvent.VK_T);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameTopUI().setVisible(true);
				dispose();
			}
		});
		menu.add(item);
		item=new JMenuItem("離開(X)",KeyEvent.VK_X);
		item.addActionListener(e->System.exit(0));
		menu.add(item);
		return mbar;
	}
}
