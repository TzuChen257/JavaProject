package com.model;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.math.BigDecimal;

public class QuotationTableModel extends DefaultTableModel {
    private static final String[] COLUMNS = {"大項目", "施工細節說明", "數量", "單價", "小計"};
    private final Runnable onDataChanged;
    
    // 防止遞迴更新的旗標 (避免 setValueAt -> listener -> setValueAt 的無窮迴圈)
    private boolean isUpdating = false;

    public QuotationTableModel(Runnable onDataChanged) {
        super(COLUMNS, 0);
        this.onDataChanged = onDataChanged;
        
        // 監聽表格變更
        this.addTableModelListener(e -> {
            // 如果正在進行內部更新，則忽略這次事件，避免無窮迴圈
            if (isUpdating) return;

            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                // 只有當「數量」(col 2) 或 「單價」(col 3) 被編輯時才處理
                if (row >= 0 && (col == 2 || col == 3)) {
                    recalculateRow(row);
                }
            }
        });
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // 鎖定除了數量(2)和單價(3)以外的欄位
        return column == 2 || column == 3;
    }

    public void addServiceRow(String category, String desc, int qty, int price) {
        BigDecimal sub = BigDecimal.valueOf((long) qty * price);
        super.addRow(new Object[]{category, desc, qty, price, sub});
        onDataChanged.run(); 
    }
    
    public void addDiscountRow(String desc, BigDecimal amount) {
         super.addRow(new Object[]{"折扣", desc, 1, amount, amount});
         onDataChanged.run(); 
    }

    /**
     * 核心邏輯：驗證輸入、格式化數字、重新計算小計
     */
    private void recalculateRow(int row) {
        // 開啟鎖定，防止此方法內的 setValueAt 再次觸發監聽器
        isUpdating = true; 
        
        try {
            // 0. 判斷是否為「折扣」項目
            Object categoryObj = getValueAt(row, 0);
            String category = (categoryObj != null) ? categoryObj.toString() : "";
            boolean isDiscount = "折扣".equals(category);

            // --- 1. 處理數量 (Column 2) ---
            // 規則：必須是整數、去除前導零、不可為負數 (數量通常保持為正整數，負號由單價體現)
            Object qtyObj = getValueAt(row, 2);
            int finalQty = 0;
            
            if (qtyObj != null) {
                try {
                    String qtyStr = qtyObj.toString().trim();
                    // 先解析為 Double 再轉 Int，以防止使用者輸入 2.0 報錯
                    finalQty = (int) Double.parseDouble(qtyStr);
                    
                    // 規則：數量維持正整數 (即使是折扣，我們也通常說是 1 個折扣，單價為 -500)
                    if (finalQty < 0) finalQty = Math.abs(finalQty);
                    
                } catch (NumberFormatException e) {
                    finalQty = 0; // 輸入非數字時歸零
                }
            }
            // 強制寫回表格 (去除前導零)
            setValueAt(finalQty, row, 2);


            // --- 2. 處理單價 (Column 3) ---
            // 規則：去除前導零。若為一般項目不可為負；若為折扣項目可為負。
            Object priceObj = getValueAt(row, 3);
            BigDecimal finalPrice = BigDecimal.ZERO;

            if (priceObj != null) {
                try {
                    String priceStr = priceObj.toString().trim();
                    finalPrice = new BigDecimal(priceStr);

                    // --- 關鍵修改 ---
                    if (!isDiscount) {
                        // 如果 "不是" 折扣項目，才強制轉為正數
                        if (finalPrice.compareTo(BigDecimal.ZERO) < 0) {
                            finalPrice = finalPrice.abs();
                        }
                    }
                    // 如果是折扣項目，則允許負數，不做 abs() 處理
                    
                } catch (Exception e) {
                    finalPrice = BigDecimal.ZERO;
                }
            }
            
            // 格式化價格顯示 (去除前導零、科學記號)
            String formattedPrice = finalPrice.stripTrailingZeros().toPlainString();
            setValueAt(formattedPrice, row, 3);


            // --- 3. 計算小計 (Column 4) ---
            BigDecimal subtotal = finalPrice.multiply(BigDecimal.valueOf(finalQty));
            setValueAt(subtotal.stripTrailingZeros().toPlainString(), row, 4);

            // --- 4. 通知外部更新總金額 ---
            SwingUtilities.invokeLater(onDataChanged);

        } finally {
            // 關閉鎖定
            isUpdating = false;
        }
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < getRowCount(); i++) {
            Object val = getValueAt(i, 4);
            if (val != null) {
                try {
                    total = total.add(new BigDecimal(val.toString()));
                } catch (Exception e) {
                    // 忽略無效數值
                }
            }
        }
        return total;
    }
}