# Minesweeper（踩地雷）- Java MVC/DAO + MySQL

此專案為踩地雷遊戲系統，使用 **Java 8**、**Swing** 製作桌面介面，並以 **MVC + DAO Pattern** 連接 **MySQL**，紀錄玩家闖關結果與排行資料。

## 功能特色

- 會員系統：註冊 / 登入 / 登出
- 每日簽到：每日首次登入顯示簽到進度，並給予積分
- 等級制度：依積分/等級解鎖（依專案設定）
- 遊戲三種關卡
  - Easy
  - Advanced
  - Hard
- 排行榜（Top10 + 自己）
  - 全玩家等級排行
  - 闖關時間排行（依關卡）
  - 會顯示 Top10，若自己不在榜上仍會額外顯示並高亮標示 (You)
- 匯出 Excel
  - 匯出個人三關卡紀錄
  - 匯出全玩家三關卡排行
  - 欄寬已自動調整，確保資料完整顯示

## 專案架構（簡述）

```
src/main/java
├─ controller          // Swing UI（視窗）
├─ controller/gameLevel// 三關卡 UI
├─ controller/rank     // 排行榜 UI
├─ dao                 // DAO 介面與實作
├─ model               // Entity / DTO
├─ service             // 商業邏輯（Service）
└─ util                // 工具、TableModel、Ranking、UITheme
```

## 執行環境

- Java 8
- MySQL 5.7 / 8.x
- IDE：Eclipse + WindowBuilder（推薦）
- Maven（若使用 IDE 自動匯入依賴）

## 資料庫設定

1. 建立 MySQL 資料庫（名稱依專案內設定）
2. 匯入提供的 SQL（若專案內有 `*.sql`）
3. 修改 DB 連線設定（例如 `config` 或 `dao`/`util` 相關設定檔）

> 若你有使用自己的 DB 帳密，請記得同步修改連線資訊。

## Demo 操作流程

1. 啟動 `LoginUI`
2. 登入後會顯示每日簽到（每日首次登入）
3. 進入主選單選擇關卡開始遊戲
4. 遊戲結束後會寫入 result 紀錄
5. 透過「排行榜」查看 Top10 + 自己（You 高亮）
6. 在結果排行榜可匯出 Excel 報表
---

如需調整關卡設定（xMax/yMax/bombNum）或等級門檻，可參考 `util/gameSettings` 與 `controller/gameLevel` 相關檔案。
