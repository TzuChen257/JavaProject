
package util.ui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 表格列高亮：用於標示自己（You）
 */
public class HighlightRowRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    private final String myUsername;
    private final int usernameCol;

    public HighlightRowRenderer(String myUsername, int usernameCol) {
        this.myUsername = myUsername;
        this.usernameCol = usernameCol;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // 顯示 (You)
        if (column == usernameCol && myUsername != null && myUsername.equals(String.valueOf(value))) {
            setText(String.valueOf(value) + " (You)");
        }

        String username = "";
        try {
            Object v = table.getValueAt(row, usernameCol);
            username = (v == null) ? "" : String.valueOf(v);
        } catch (Exception ignore) {}

        if (isSelected) {
            c.setBackground(UITheme.PRIMARY);
            c.setForeground(java.awt.Color.WHITE);
            return c;
        }

        if (myUsername != null && !myUsername.isEmpty() && myUsername.equals(username)) {
            c.setBackground(UITheme.HIGHLIGHT);
            c.setForeground(UITheme.TEXT);
        } else {
            c.setBackground(UITheme.CARD);
            c.setForeground(UITheme.TEXT);
        }
        return c;
    }
}
