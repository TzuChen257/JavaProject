package controller.rank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import controller.GameTopUI;
import util.tableModel.ResultRankTableModel;
import model.User;
import util.Tool;
import util.gameSettings.Ranking;
import util.ui.UITheme;
import util.ui.HighlightRowRenderer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultRankUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user=(User) Tool.readObject("User");
	private JTable table;
	private String username=((User)Tool.readObject("User")).getUsername();
	private ResultRankTableModel tableModel;
	private int level=Tool.readLevel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultRankUI frame = new ResultRankUI();
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
	public ResultRankUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 430);
		contentPane = new JPanel();
		contentPane.setBackground(UITheme.BG);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UITheme.CARD);
		panel.setBounds(10, 10, 446, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel topic = new JLabel("");
		topic.setFont(UITheme.FONT_TITLE);
		topic.setForeground(UITheme.PRIMARY_DARK);
		topic.setHorizontalAlignment(SwingConstants.CENTER);
		topic.setBounds(78, 10, 280, 30);
		panel.add(topic);
		
		/********setting********/
		//new table&topic
		tableModel=new ResultRankTableModel(Ranking.resultRankAndThis(username, level, 10));
		switch(level)
		{
			case 1:
				ResultRankTableModel.topic="簡單模式 排名";
				break;
			case 2:
				ResultRankTableModel.topic="進階模式 排名";
				break;
			case 3:
				ResultRankTableModel.topic="困難模式 排名";
				break;
			default:
				ResultRankTableModel.topic="排名";
		}
		
		table=new JTable();
		table.setModel(tableModel);
		topic.setText(tableModel.topic);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 54, 426, 220);
		panel.add(scrollPane);
		UITheme.styleTableBasic(table);
		// 高亮自己（You）
		table.setDefaultRenderer(Object.class, new HighlightRowRenderer(username, 1));
		
		setJMenuBar(buildMenu());
		//設定欄寬
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn c0=table.getColumnModel().getColumn(0);
		c0.setPreferredWidth(50);
		TableColumn c1=table.getColumnModel().getColumn(1);
		c1.setPreferredWidth(100);
		TableColumn c2=table.getColumnModel().getColumn(2);
		c2.setPreferredWidth(100);
		TableColumn c3=table.getColumnModel().getColumn(3);
		c3.setPreferredWidth(150);
		
		/******event*****/
		
		JButton allResult = new JButton("印出所有結果");
		allResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		allResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File file = chooseExcelFile();
					if (file == null) return;
					new Ranking().exportAllByLevelToFile(file.getAbsolutePath());
					JOptionPane.showMessageDialog(null, "已匯出 Excel：\n" + file.getAbsolutePath());
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "匯出失敗：" + ex.getMessage());
				}
			}
		});
		allResult.setBounds(144, 294, 140, 28);
		UITheme.applySecondaryButton(allResult);
		allResult.setForeground(UITheme.PRIMARY_DARK);
		panel.add(allResult);
	}

	private File chooseExcelFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("選擇 Excel 儲存位置");
		chooser.setFileFilter(new FileNameExtensionFilter("Excel 97-2003 (*.xls)", "xls"));
		chooser.setSelectedFile(new File("rank_report.xls"));
		int result = chooser.showSaveDialog(this);
		if (result != JFileChooser.APPROVE_OPTION) return null;
		File f = chooser.getSelectedFile();
		// 自動補副檔名
		if (!f.getName().toLowerCase().endsWith(".xls")) {
			f = new File(f.getParentFile(), f.getName() + ".xls");
		}
		return f;
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
