package com.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.model.QuotationTableModel;
import com.service.QuotationService; // 假設您之前的 Service 改回 ServiceItem，若用 QuotationService 請自行替換
import com.repository.CatalogRepository; // 修改為正確的 package

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class QuotationFrame extends JFrame {

    private JTextField txtBrand, txtCustomer;
    // private JTextField txtDate; // 移除舊的
    private DatePicker datePicker; // 改用 DatePicker
    private JLabel lblClock, lblTotal;
    private JRadioButton rbSplit, rbWindow;
    private JComboBox<String> comboCategories;
    private JPanel checkBoxesPanel;
    private JTable table;
    private QuotationTableModel tableModel;
    private JTextArea txtNote;

    public QuotationFrame() {
        setTitle("E-Life 冷氣安裝報價系統");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        initClock();
        updateCategoryCombo();
    }

    private void initUI() {
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(createNorthPanel(), BorderLayout.NORTH);
        getContentPane().add(createCenterPanel(), BorderLayout.CENTER);
        getContentPane().add(createSouthPanel(), BorderLayout.SOUTH);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("基本資訊"));

        panel.add(new JLabel("  安裝廠牌:"));
        txtBrand = new JTextField();
        panel.add(txtBrand);

        panel.add(new JLabel("  客戶名稱:"));
        txtCustomer = new JTextField();
        panel.add(txtCustomer);

        panel.add(new JLabel("  報價日期:"));
        
        // --- DatePicker 設定 ---
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd"); // 設定日期格式
        dateSettings.setAllowKeyboardEditing(false); // 禁止手動輸入，只能用選的
        
        datePicker = new DatePicker(dateSettings);
        datePicker.setDateToToday(); // 預設為今天
        
        panel.add(datePicker); 
        // ---------------------

        panel.add(new JLabel("  現在時間:"));
        lblClock = new JLabel();
        lblClock.setForeground(Color.BLUE);
        panel.add(lblClock);

        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbSplit = new JRadioButton(CatalogRepository.TYPE_SPLIT, true);
        rbWindow = new JRadioButton(CatalogRepository.TYPE_WINDOW);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSplit); bg.add(rbWindow);
        typePanel.add(rbSplit); typePanel.add(rbWindow);
        
        rbSplit.addActionListener(e -> updateCategoryCombo());
        rbWindow.addActionListener(e -> updateCategoryCombo());

        comboCategories = new JComboBox<>();
        comboCategories.addActionListener(e -> updateCheckBoxes());
        
        JPanel topBox = new JPanel(new BorderLayout());
        topBox.add(typePanel, BorderLayout.NORTH);
        topBox.add(comboCategories, BorderLayout.CENTER);
        panel.add(topBox, BorderLayout.NORTH);

        checkBoxesPanel = new JPanel();
        checkBoxesPanel.setLayout(new BoxLayout(checkBoxesPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(checkBoxesPanel);
        scrollPane.setPreferredSize(new Dimension(0, 150));
        scrollPane.setBorder(BorderFactory.createTitledBorder("施工細項 (勾選後點擊新增)"));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton btnAdd = new JButton("新增選中項目");
        JButton btnDiscount = new JButton("手動折讓/折扣");
        btnAdd.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        btnDiscount.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        
        btnAdd.addActionListener(e -> handleAddItems());
        btnDiscount.addActionListener(e -> handleDiscount());
        
        btnPanel.add(btnAdd);
        btnPanel.add(btnDiscount);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setPreferredSize(new Dimension(0, 450));

        tableModel = new QuotationTableModel(this::updateTotalLabel);
        table = new JTable(tableModel);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("微軟正黑體", Font.BOLD, 14));
        
        JScrollPane tableScroll = new JScrollPane(table);
        
        txtNote = new JTextArea(4, 20);
        txtNote.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        txtNote.setLineWrap(true);
        JScrollPane noteScroll = new JScrollPane(txtNote);
        noteScroll.setBorder(BorderFactory.createTitledBorder("報價備註"));

        JPanel centerContainer = new JPanel(new BorderLayout(0, 5));
        centerContainer.add(tableScroll, BorderLayout.CENTER);
        centerContainer.add(noteScroll, BorderLayout.SOUTH);

        JPanel footerObj = new JPanel(new BorderLayout());
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton btnDel = new JButton("刪除列");
        JButton btnClear = new JButton("全部清除");
        JButton btnPrint = new JButton("列印報價單");
        JButton btnExit = new JButton("關閉視窗");

        btnDel.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                tableModel.removeRow(row);
                updateTotalLabel();
            } else {
                JOptionPane.showMessageDialog(this, "請先選擇要刪除的列");
            }
        });
        
        btnClear.addActionListener(e -> {
            if(JOptionPane.showConfirmDialog(this, "確定要清除所有資料嗎？") == JOptionPane.YES_OPTION){
                tableModel.setRowCount(0);
                txtNote.setText("");
                updateTotalLabel();
            }
        });
        
        btnPrint.addActionListener(e -> printQuotation());
        btnExit.addActionListener(e -> System.exit(0));

        btns.add(btnDel); btns.add(btnClear); btns.add(btnPrint); btns.add(btnExit);

        lblTotal = new JLabel("總計金額：NT$ 0  ", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        lblTotal.setForeground(Color.RED);

        footerObj.add(btns, BorderLayout.WEST);
        footerObj.add(lblTotal, BorderLayout.EAST);

        panel.add(centerContainer, BorderLayout.CENTER);
        panel.add(footerObj, BorderLayout.SOUTH);
        
        return panel;
    }

    private void updateCategoryCombo() {
        comboCategories.removeAllItems();
        String currentType = rbSplit.isSelected() ? CatalogRepository.TYPE_SPLIT : CatalogRepository.TYPE_WINDOW;
        for (String cat : CatalogRepository.getMajorCategories(currentType)) {
            comboCategories.addItem(cat);
        }
        updateCheckBoxes();
    }

    private void updateCheckBoxes() {
        checkBoxesPanel.removeAll();
        String currentType = rbSplit.isSelected() ? CatalogRepository.TYPE_SPLIT : CatalogRepository.TYPE_WINDOW;
        String category = (String) comboCategories.getSelectedItem();
        
        if (category != null) {
            List<QuotationService> items = CatalogRepository.getItems(currentType, category);
            for (QuotationService item : items) {
                JCheckBox cb = new JCheckBox(item.toString());
                cb.putClientProperty("itemData", item); 
                checkBoxesPanel.add(cb);
            }
        }
        checkBoxesPanel.revalidate();
        checkBoxesPanel.repaint();
    }

    private void handleAddItems() {
        if (txtBrand.getText().trim().isEmpty() || txtCustomer.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "請先輸入安裝廠牌與客戶名稱");
            return;
        }

        String category = (String) comboCategories.getSelectedItem();
        boolean hasAdded = false;

        for (Component comp : checkBoxesPanel.getComponents()) {
            if (comp instanceof JCheckBox) {
                JCheckBox cb = (JCheckBox) comp;
                if (cb.isSelected()) {
                	QuotationService item = (QuotationService) cb.getClientProperty("itemData");
                    processAddItem(category, item);
                    cb.setSelected(false);
                    hasAdded = true;
                }
            }
        }
        
        if (!hasAdded) {
            JOptionPane.showMessageDialog(this, "請至少勾選一個項目");
        }
    }

    private void processAddItem(String category, QuotationService item) {
        String qtyStr = JOptionPane.showInputDialog(this, "項目: " + item.getDescription() + "\n請輸入數量:", "1");
        if (qtyStr == null) return;
        String priceStr = JOptionPane.showInputDialog(this, "確認單價:", String.valueOf(item.getDefaultPrice()));
        if (priceStr == null) return;

        try {
            int qty = Integer.parseInt(qtyStr);
            int price = Integer.parseInt(priceStr);
            tableModel.addServiceRow(category, item.getDescription(), qty, price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "輸入格式錯誤");
        }
    }
    
    private void handleDiscount() {
        // ... (折讓邏輯保持不變) ...
         String[] opts = {"手動減價 (金額)", "全單打折 (折數)"};
        int type = JOptionPane.showOptionDialog(this, "請選擇折扣方式", "折扣設定", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
        
        if (type == 0) { // 減價金額
            String val = JOptionPane.showInputDialog(this, "輸入減價金額 (請輸入負數，例如 -500):", "-");
            if (val != null) {
                try {
                    BigDecimal amount = new BigDecimal(val);
                    tableModel.addDiscountRow("手動折讓", amount);
                } catch(Exception e) {}
            }
        } else if (type == 1) { // 全單打折
            String rateStr = JOptionPane.showInputDialog(this, "輸入折數 (例如 0.9 代表九折):", "0.9");
            if (rateStr != null) {
                try {
                    BigDecimal rate = new BigDecimal(rateStr);
                    BigDecimal currentTotal = tableModel.calculateTotal();
                    BigDecimal discountAmt = currentTotal.multiply(rate.subtract(BigDecimal.ONE))
                            .setScale(0, BigDecimal.ROUND_HALF_UP);
                    tableModel.addDiscountRow("全單打折 (" + rateStr + ")", discountAmt);
                } catch(Exception e) {}
            }
        }
    }

    private void updateTotalLabel() {
        BigDecimal total = tableModel.calculateTotal();
        lblTotal.setText("總計金額：NT$ " + total.toPlainString() + "  ");
    }

    private void initClock() {
        Timer timer = new Timer(1000, e -> {
            lblClock.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        });
        timer.start();
    }
    
    private void printQuotation() {
        try {
            // 從 DatePicker 取得選擇的日期字串
            String dateText = datePicker.getText(); 
            
            MessageFormat header = new MessageFormat("報價單 - 客戶: " + txtCustomer.getText() + " (" + dateText + ")");
            MessageFormat footer = new MessageFormat("備註: " + txtNote.getText() + " | 第 {0} 頁");
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "列印失敗: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) {}
        SwingUtilities.invokeLater(() -> new QuotationFrame().setVisible(true));
    }
}