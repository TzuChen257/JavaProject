package controller;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.ui.UITheme;

import model.User;

/**
 * 每日第一次登入顯示 7 日簽到進度。
 */
public class CheckinUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public CheckinUI(User user) {
        setTitle("每日簽到");
        setAlwaysOnTop(true);
        setBounds(100, 100, 360, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(UITheme.BG);
        contentPane.setBorder(new EmptyBorder(16, 16, 16, 16));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("簽到成功 +1 分");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(UITheme.FONT_TITLE);
        title.setBounds(10, 10, 324, 28);
        title.setForeground(UITheme.PRIMARY_DARK);
        contentPane.add(title);

        JLabel sub = new JLabel("本週已簽到 " + user.getCheckin_count() + " / 7 天");
        sub.setHorizontalAlignment(SwingConstants.CENTER);
        sub.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        sub.setBounds(10, 40, 324, 22);
        contentPane.add(sub);

        int signed = user.getCheckin_count();
        int x = 18, y = 78, w = 42, h = 42, gap = 6;

        for (int i = 1; i <= 7; i++) {
            JLabel day = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            day.setBounds(x + (i - 1) * (w + gap), y, w, h);
            day.setOpaque(true);
            day.setFont(UITheme.FONT_SUBTITLE);
            if (i <= signed) {
                day.setBackground(UITheme.PRIMARY);
                day.setForeground(Color.WHITE);
            } else {
                day.setBackground(UITheme.HOVER);
                day.setForeground(UITheme.PRIMARY_DARK);
            }
            contentPane.add(day);
        }

        JLabel tip = new JLabel("（關閉此視窗即可繼續遊戲）", SwingConstants.CENTER);
        tip.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        tip.setBounds(10, 132, 324, 18);
        tip.setForeground(UITheme.MUTED);
        contentPane.add(tip);
    }
}
