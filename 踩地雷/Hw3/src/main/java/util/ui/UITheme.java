
package util.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * UI 主題：胡桃 Kurumi (#947A6D)
 */
public final class UITheme {
    private UITheme() {}

    // NipponColors - Kurumi: #947A6D
    public static final Color PRIMARY = new Color(0x94, 0x7A, 0x6D);
    public static final Color PRIMARY_DARK = new Color(0x6B, 0x57, 0x4F);
    public static final Color BG = new Color(0xFB, 0xF8, 0xF6);
    public static final Color CARD = Color.WHITE;
    public static final Color TEXT = new Color(0x2B, 0x2B, 0x2B);
    public static final Color MUTED = new Color(0x6B, 0x72, 0x80);
    public static final Color BORDER = new Color(0xE7, 0xE1, 0xDE);
    public static final Color HOVER = new Color(0xF2, 0xEA, 0xE6);
    public static final Color HIGHLIGHT = new Color(0xEE, 0xE2, 0xDB);

    public static final Font FONT_TITLE = new Font("微軟正黑體", Font.BOLD, 18);
    public static final Font FONT_SUBTITLE = new Font("微軟正黑體", Font.BOLD, 14);
    public static final Font FONT_BODY = new Font("微軟正黑體", Font.PLAIN, 13);

    public static void applyCard(JComponent c) {
        c.setBackground(CARD);
        c.setForeground(TEXT);
        c.setBorder(new EmptyBorder(12, 12, 12, 12));
    }

    public static void applyTitle(JLabel label, String text) {
        label.setText(text);
        label.setFont(FONT_TITLE);
        label.setForeground(PRIMARY_DARK);
    }

    public static void applyPrimaryButton(JButton b) {
        b.setBackground(PRIMARY);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setFont(FONT_SUBTITLE);
    }

    public static void applySecondaryButton(JButton b) {
        b.setBackground(HOVER);
        b.setForeground(PRIMARY_DARK);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setFont(FONT_SUBTITLE);
    }

    public static void styleTableBasic(JTable table) {
        table.setRowHeight(26);
        table.setFont(FONT_BODY);
        table.getTableHeader().setFont(FONT_SUBTITLE);
        table.getTableHeader().setBackground(HOVER);
        table.getTableHeader().setForeground(PRIMARY_DARK);
        table.setGridColor(BORDER);
        table.setShowVerticalLines(false);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, center);
    }
}
