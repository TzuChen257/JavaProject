package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;

import model.Rank;
import model.Result;
import model.User;
import util.tableModel.ResultRankTableModel;
import util.Tool;
import util.gameSettings.Ranking;
import util.ui.UITheme;
import util.ui.HighlightRowRenderer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProfileUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private User user = (User) Tool.readObject("User");

    public ProfileUI() {
        setTitle("個人資訊與紀錄");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 434, 414);

        contentPane = new JPanel();
        contentPane.setBackground(UITheme.BG);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setJMenuBar(buildMenu());

        JLabel title = new JLabel("個人資訊", SwingConstants.LEFT);
        title.setFont(UITheme.FONT_TITLE);
        title.setForeground(UITheme.PRIMARY_DARK);
        title.setBounds(10, 10, 200, 28);
        contentPane.add(title);

        JLabel name = new JLabel("使用者：" + user.getUsername());
        name.setFont(UITheme.FONT_BODY);
        name.setBounds(10, 44, 220, 22);
        contentPane.add(name);

        JLabel level = new JLabel("等級：" + user.getLevel() + " / 10");
        level.setFont(UITheme.FONT_BODY);
        level.setBounds(10, 66, 220, 22);
        contentPane.add(level);

        JLabel score = new JLabel("積分：" + user.getScore());
        score.setFont(UITheme.FONT_BODY);
        score.setBounds(175, 66, 220, 22);
        contentPane.add(score);

        JLabel checkin = new JLabel("本週簽到：" + user.getCheckin_count() + " / 7");
        checkin.setFont(UITheme.FONT_BODY);
        checkin.setBounds(175, 44, 220, 22);
        contentPane.add(checkin);

        JLabel hint = new JLabel("Easy +5 / Advanced +30 / Hard +100；每日簽到 +1", SwingConstants.RIGHT);
        hint.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        hint.setForeground(UITheme.MUTED);
        hint.setBounds(99, 16, 311, 22);
        contentPane.add(hint);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(10, 98, 400, 206);
        contentPane.add(tabs);

        tabs.add("Easy", buildTablePanel(1));
        tabs.add("Advanced", buildTablePanel(2));
        tabs.add("Hard", buildTablePanel(3));
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 305, 400, 39);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton myResult = new JButton("印出個人紀錄");
		myResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File file = chooseExcelFile();
					if (file == null) return;
					new Ranking().exportUserByLevelToFile(user.getUsername(), file.getAbsolutePath());
					JOptionPane.showMessageDialog(null, "已匯出 Excel：\n" + file.getAbsolutePath());
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "匯出失敗：" + ex.getMessage());
				}
			}
		});
		myResult.setBounds(126, 10, 140, 28);
		UITheme.applyPrimaryButton(myResult);
		panel.add(myResult);
    }

    private JPanel buildTablePanel(int level) {
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);

        List<Rank<Result>> data = Ranking.userRecord(user.getUsername(), level);
        JTable table = new JTable(new ResultRankTableModel(data));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn c0=table.getColumnModel().getColumn(0);
		c0.setPreferredWidth(50);
		TableColumn c1=table.getColumnModel().getColumn(1);
		c1.setPreferredWidth(100);
		TableColumn c2=table.getColumnModel().getColumn(2);
		c2.setPreferredWidth(100);
		TableColumn c3=table.getColumnModel().getColumn(3);
		c3.setPreferredWidth(150);
        UITheme.styleTableBasic(table);
        table.setDefaultRenderer(Object.class, new HighlightRowRenderer(user.getUsername(), 1));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 474, 177);
        p.add(sp);

        return p;
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

    private JMenuBar buildMenu() {
        JMenuBar mbar = new JMenuBar();
        JMenu menu = new JMenu("選項(M)");
        menu.setMnemonic(KeyEvent.VK_M);
        mbar.add(menu);

        JMenuItem item = new JMenuItem("回首頁(T)", KeyEvent.VK_T);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameTopUI().setVisible(true);
                dispose();
            }
        });
        menu.add(item);

        item = new JMenuItem("離開(X)", KeyEvent.VK_X);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(item);

        return mbar;
    }
}
