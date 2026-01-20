package com.model;

import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ---------------------------------------------------------
// Aggregate Root: 報價單主檔
// ---------------------------------------------------------
public class QuotationELife {
    private final List<QuotationItem> items; // 使用 final 確保 List 引用不被替換
    private String brand;
    private String customerName;
    private String note;
    private OffsetDateTime date;

    public QuotationELife(String brand, String customerName) {
        this.brand = Validate.notBlank(brand, "品牌名稱不得為空");
        this.customerName = Validate.notBlank(customerName, "客戶名稱不得為空");
        this.items = new ArrayList<>();
        this.date = OffsetDateTime.now();
    }

    // --- 商業邏輯方法 ---

    /**
     * 新增報價項目 (封裝 List 的修改操作)
     */
    public void addItem(QuotationItem item) {
        Validate.notNull(item, "報價項目不得為空");
        this.items.add(item);
    }

    /**
     * 移除報價項目
     */
    public void removeItem(QuotationItem item) {
        this.items.remove(item);
    }

    /**
     * 計算總價 (唯讀屬性)
     * 利用多型，自動呼叫各子類別正確的 getSubTotal()
     */
    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(QuotationItem::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // --- Getters & Setters ---

    /**
     * 回傳不可修改的 List，防止外部直接操作內部集合
     */
    public List<QuotationItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = Validate.notBlank(brand, "品牌名稱不得為空");
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = Validate.notBlank(customerName, "客戶名稱不得為空");
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = Validate.notNull(date, "日期不得為 null");
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        if (note != null) {
            Validate.inclusiveBetween(0, 500, note.length(), "備註長度限制為 500 字");
        }
        this.note = note;
    }
}

// ---------------------------------------------------------
// Abstract Base Class: 報價項目 (抽象層)
// ---------------------------------------------------------
abstract class QuotationItem {
    protected String description;
    protected BigDecimal price;

    public QuotationItem(String description, BigDecimal price) {
        this.description = Validate.notBlank(description, "描述不得為空");
        this.price = Validate.notNull(price, "價格不得為 null");
        Validate.isTrue(price.compareTo(BigDecimal.ZERO) >= 0, "價格不得小於 0");
    }

    // 定義抽象方法，強迫子類別實作自己的計價邏輯
    public abstract BigDecimal getSubTotal();

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

// ---------------------------------------------------------
// Subclass 1: 窗型 (對應原本的 'W') - 有數量概念
// ---------------------------------------------------------
class ProductItem extends QuotationItem {
    private int quantity;

    public ProductItem(String description, BigDecimal price, Integer quantity) {
        super(description, price);
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        // 若輸入 null 則預設為 1，或視需求拋出異常
        int q = (quantity != null) ? quantity : 1;
        Validate.isTrue(q >= 0, "商品數量不得小於 0");
        this.quantity = q;
    }

    @Override
    public BigDecimal getSubTotal() {
        return this.price.multiply(BigDecimal.valueOf(quantity));
    }
}

// ---------------------------------------------------------
// Subclass 2: 分離式 (對應原本的 'S') - 單一價格
// ---------------------------------------------------------
class ServiceItem extends QuotationItem {

    public ServiceItem(String description, BigDecimal price) {
        super(description, price);
    }

    @Override
    public BigDecimal getSubTotal() {
        // 服務類通常沒有數量概念，直接回傳單價
        return this.price;
    }
}