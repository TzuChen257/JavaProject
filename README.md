# JavaProject（Java 實作作品集）

這個 Repo 收錄我的 Java 實作專案，涵蓋 **GUI（Swing/WindowBuilder）**、**MVC/DAO 分層**、**MySQL/JDBC**、以及 **POIs報表匯出（Excel）** 等常見商業開發能力。

---

## 專案總覽（Projects）

### 1) 愛讀公共圖書館｜Library Management System
📁 資料夾：**圖書館館藏管理系統**  
🔗 專案連結：https://github.com/TzuChen257/JavaProject/tree/main/%E5%9C%96%E6%9B%B8%E9%A4%A8%E9%A4%A8%E8%97%8F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%B5%B1

**技術亮點**
- Java 8 + Swing（WindowBuilder 友善）+ Maven + MySQL
- **雙角色系統**：讀者端 / 館員後台（權限與功能完整分流）
- **UITheme 統一主題** + icon button 規格化（尺寸、底色、易讀性）

**核心功能**
- 讀者端：館藏瀏覽（每頁 10 筆可翻頁）、搜尋（書名/作者/ISBN/分類）、借閱/預約、借閱紀錄與歸還申請、個人信箱（未讀提醒）、讀書心得（送審）、公開心得牆
- 借閱流程以 `books.state` 控制按鈕與操作：
  - `0` 可借閱（只顯示借閱）
  - `1` 借出中（只顯示預約）
  - `2` 歸還待審核（只顯示預約）
  - `3` 毀損/遺失（讀者端不顯示/不可操作，後台可查）
- 館員後台：Excel 批次匯入/單筆新增、書籍查詢（全部/非閒置中）、讀者資料管理、歸還待核可（完好/毀損/遺失）、心得核可/發佈、Excel 報表輸出

---

### 2) 欣新銀行｜ATM 與後台管理系統
📁 資料夾：**銀行ATM與後台系統**  
🔗 專案連結：https://github.com/TzuChen257/JavaProject/tree/main/%E9%8A%80%E8%A1%8CATM%E8%88%87%E5%BE%8C%E5%8F%B0%E7%B3%BB%E7%B5%B1

**技術亮點**
- Java + Maven，採 **DAO / Service 分層**、統一例外處理、輸入驗證、資源關閉優化
- 介面風格穩重藍色系

**核心功能**
- 使用者端：登入、查詢餘額、存提款、轉帳、修改密碼、列印/查詢個人交易明細
- 管理員端：新增帳戶、刪除帳戶、修改資料、查詢交易紀錄
- 資料儲存：以文字檔維護（如 account/admin/交易明細）

---

### 3) Minesweeper（踩地雷）｜Java MVC/DAO + MySQL
📁 資料夾：**踩地雷**  
🔗 專案連結：https://github.com/TzuChen257/JavaProject/tree/main/%E8%B8%A9%E5%9C%B0%E9%9B%B7

**技術亮點**
- Java 8 + Swing 應用
- **MVC + DAO Pattern** 串接 **MySQL**，可記錄玩家闖關結果與排行
- 報表支援 **匯出 Excel**（個人/全員/各關卡排行）

**核心功能**
- 會員系統：註冊 / 登入 / 登出
- 每日簽到：每日首次登入顯示進度並給予積分
- 等級制度：依積分/等級解鎖（可調門檻）
- 三種關卡：Easy / Advanced / Hard
- 排行榜：Top10 + 自己（不在榜上也會額外顯示並標示 You）
- 匯出 Excel：個人三關卡紀錄、全玩家三關卡排行
- UI/表格：欄寬自動調整，確保資料可讀性

---

### 4) 火鍋店｜內用/外用點餐系統（Java GUI）
📁 資料夾：**火鍋店內外用點餐系統**  
🔗 專案連結：https://github.com/TzuChen257/JavaProject/tree/main/%E7%81%AB%E9%8D%8B%E5%BA%97%E5%85%A7%E5%A4%96%E7%94%A8%E9%BB%9E%E9%A4%90%E7%B3%BB%E7%B5%B1

**技術亮點**
- Java GUI（Swing）為主的桌面點餐流程實作

**核心功能**
- 內用/外用流程分流
- 菜單選擇 → 加入清單 → 訂單結算（可擴充：備註、折扣、發票/收據）
- 適合展示：GUI 互動設計、資料結構整理、事件驅動處理（ActionListener）
