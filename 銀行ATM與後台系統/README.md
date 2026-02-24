# 欣新銀行 ATM 與後台管理系統

## 📌 專案簡介
本專案為 Java + Maven 開發之模擬銀行 ATM 與後台管理系統，
整體風格參考國泰世華線上銀行介面，採用穩重藍色系呈現。

功能包含：
- 使用者登入 / 轉帳 / 查詢餘額
- 管理員帳戶管理
- 交易紀錄管理
- 檔案資料儲存

---

## 🚀 系統環境需求
- Java 8 以上
- Maven 3.x
- Windows / macOS / Linux

---

## 📂 專案結構
```
hw2_bank/
 ├─ Hw2/
 │  ├─ src/main/java/
 │  ├─ pom.xml
 │  └─ account.txt / admin.txt / Detail.txt
 ├─ hw2.sql
 └─ 欣新銀行ATM與後台系統.jar
```

---

## ⚙️ 建置與執行

### 方式一：使用 Maven
```bash
cd Hw2
mvn clean package
java -jar target/hw2-1.0.jar
```

### 方式二：直接執行 JAR
```bash
java -jar 欣新銀行ATM與後台系統.jar
```

---

## 🛠 系統功能

### 使用者端
- 登入驗證
- 查詢餘額
- 存提款
- 轉帳功能
- 修改密碼

### 管理員端
- 新增帳戶
- 刪除帳戶
- 修改資料
- 查詢交易紀錄

---

## 📊 資料管理
系統使用文字檔儲存資料：
- account.txt：使用者資料
- admin.txt：管理員資料
- Detail.txt：交易紀錄

---

## ✅ 程式優化說明
已優化項目：
- DAO / Service 分層結構
- 統一例外處理
- 資源關閉優化
- 命名一致化
- 輸入驗證補強

---

## 📄 授權
本專案僅供教學與學術使用。
