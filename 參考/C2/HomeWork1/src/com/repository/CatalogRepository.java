package com.repository;

import java.util.*;

import com.service.QuotationService;

public class CatalogRepository {
    // 儲存結構: 類型 (分離/窗型) -> 大項目名稱 -> 細項列表
    private static final Map<String, Map<String, List<QuotationService>>> DATA = new HashMap<>();

    public static final String TYPE_SPLIT = "分離式冷氣施工項目/收費";
    public static final String TYPE_WINDOW = "窗型、直立式冷氣施工項目/收費";

    static {
        initSplitData();
        initWindowData();
    }

    private static void initSplitData() {
        // 使用 LinkedHashMap 保持選單顯示順序
        Map<String, List<QuotationService>> categories = new LinkedHashMap<>();

        categories.put("1.拆舊機費用", Arrays.asList(
            new QuotationService("舊機為標準安裝(含陽台內側有安裝架)者", 1000),
            new QuotationService("拆舊機移運至安裝地則須另加運費(不安裝)", 350),
            new QuotationService("舊機非標準安裝則須另加(危險施工另計)", 600),
            new QuotationService("需單獨施工者，另行議價", 0)
        ));

        categories.put("2.室外機加遮雨棚", Arrays.asList(
            new QuotationService("室外機加遮雨棚", 1200),
            new QuotationService("單獨施工者", 1800)
        ));

        categories.put("3.排水器", Arrays.asList(
            new QuotationService("一般型(含安裝)", 1600),
            new QuotationService("靜音型", 2000)
        ));

        categories.put("4.加裝安裝架", Arrays.asList(
            new QuotationService("不鏽鋼組合架小組", 3000),
            new QuotationService("不鏽鋼組合架大組", 3500),
            new QuotationService("鍍鋅豪華組合架小組", 1000),
            new QuotationService("鍍鋅豪華組合架中組", 1200),
            new QuotationService("鍍鋅豪華組合架大組(現場另議)", 0),
            new QuotationService("室外機落地腳架", 800)
        ));

        categories.put("5.排水管加長", Arrays.asList(
            new QuotationService("4分透明管每一層", 100),
            new QuotationService("配PC管另議", 0)
        ));

        categories.put("6.電源線/控制線延長", Arrays.asList(
            new QuotationService("規格2.0mm /公尺", 60),
            new QuotationService("規格3.5mm /公尺", 75),
            new QuotationService("規格5.5mm /公尺", 90),
            new QuotationService("其他線徑另議", 0)
        ));

        categories.put("7.冷媒銅管延長", Arrays.asList(
            new QuotationService("2分3分 /公尺", 400),
            new QuotationService("2分4分 /公尺", 500),
            new QuotationService("2分5分 /公尺", 550),
            new QuotationService("3分5分 /公尺", 600),
            new QuotationService("延用舊管洗管", 3000)
        ));

        categories.put("8.鑽牆孔", Arrays.asList(
            new QuotationService("牆厚度25公分內 /孔", 800),
            new QuotationService("牆厚度40公分內 /孔", 1000),
            new QuotationService("木板牆3分板以上", 300)
        ));

        categories.put("9.更換插座,開關", Arrays.asList(
            new QuotationService("插頭", 200),
            new QuotationService("冷氣插座 /個", 200),
            new QuotationService("無熔絲開關 30A /個", 500)
        ));

        categories.put("10.超過10米補充冷媒", Arrays.asList(
            new QuotationService("R22冷媒 /台", 600),
            new QuotationService("R410/R32冷媒 /台", 1200)
        ));

        categories.put("11.危險施工費", Arrays.asList(
            new QuotationService("安裝架底部於外牆超過 30 公分(現場計價)", 0),
            new QuotationService("高空作業作業者(現場另行議價)", 0)
        ));

        categories.put("12.修飾壓管條", Arrays.asList(
            new QuotationService("冷媒管壓管條 (8CM) /公尺", 330),
            new QuotationService("冷媒管壓條彎頭 (8CM) /顆", 275)
        ));

        categories.put("13.分離式移機", Arrays.asList(
            new QuotationService("只拆舊機，不廢棄", 1000),
            new QuotationService("原地移機/同層拆裝機 (需加裝機費)", 1000),
            new QuotationService("基本宅配費(非同址)", 350)
        ));

        DATA.put(TYPE_SPLIT, categories);
    }

    private static void initWindowData() {
        Map<String, List<QuotationService>> categories = new LinkedHashMap<>();

        categories.put("1.拆舊機費", Arrays.asList(
            new QuotationService("拆舊機工資", 300),
            new QuotationService("同意舊機由安裝人員處理(免收)", 0),
            new QuotationService("拆舊機移至安裝地加收運費", 300)
        ));

        categories.put("2.排水管加長", Arrays.asList(
            new QuotationService("4分透明管每一層樓加 (配PC管另議)", 100)
        ));

        categories.put("3.特殊施工(懸吊)", Arrays.asList(
            new QuotationService("追加特殊施工(懸吊)費用 /台", 1000)
        ));

        categories.put("4.移舊機", Arrays.asList(
            new QuotationService("只拆舊機，不廢棄", 300),
            new QuotationService("原地移機/同層拆裝機 (需加裝機費)", 300),
            new QuotationService("基本宅配費(非同址)", 300)
        ));

        categories.put("5.遮雨棚", Arrays.asList(
            new QuotationService("隨機施工者 /個", 1200),
            new QuotationService("單獨施工者 /個", 1800)
        ));

        categories.put("6.配線延長", Arrays.asList(
            new QuotationService("規格 2.0mm /公尺", 60),
            new QuotationService("規格 3.5mm /公尺", 75),
            new QuotationService("規格 5.5mm /公尺", 90)
        ));

        categories.put("7.改鋁窗", Arrays.asList(
            new QuotationService("原窗戶修改者 /式", 3000),
            new QuotationService("落地窗(另議)", 0)
        ));

        categories.put("8.剪鐵窗", Arrays.asList(
            new QuotationService("一般鐵窗 /式", 300),
            new QuotationService("實心 /式", 600),
            new QuotationService("不銹鋼 /式", 600)
        ));

        categories.put("9.更換插座,開關", Arrays.asList(
            new QuotationService("插頭", 200),
            new QuotationService("冷氣插座 /個", 200),
            new QuotationService("無熔絲開關 30A /個", 500)
        ));

        categories.put("10.配舊機安裝架", Arrays.asList(
            new QuotationService("一般窗型 /台", 400),
            new QuotationService("直立式 /台", 2200)
        ));

        categories.put("11.冷媒填充", Arrays.asList(
            new QuotationService("R22 /台", 1800),
            new QuotationService("R32 /台", 2500),
            new QuotationService("R410 /台", 2500)
        ));

        categories.put("12.其他施工", Arrays.asList(
            new QuotationService("加程費用每15公里", 150),
            new QuotationService("割玻璃", 200),
            new QuotationService("需切牆者 /孔", 5000),
            new QuotationService("封板每 90CM平方", 120)
        ));

        DATA.put(TYPE_WINDOW, categories);
    }

    public static Set<String> getMajorCategories(String type) {
        return DATA.getOrDefault(type, Collections.emptyMap()).keySet();
    }

    public static List<QuotationService> getItems(String type, String category) {
        return DATA.getOrDefault(type, Collections.emptyMap()).getOrDefault(category, new ArrayList<>());
    }
}
