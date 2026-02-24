package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * 以 ISO week (週一為一週起始) 計算本週識別碼，供 7 日簽到以週為單位重置。
 */
public class UserWeekTool {
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /** @return 例如：2026-W08 */
    public static String weekKey(String yyyyMMddSlash) {
        LocalDate d = LocalDate.parse(yyyyMMddSlash, DATE_FMT);
        WeekFields wf = WeekFields.ISO;
        int week = d.get(wf.weekOfWeekBasedYear());
        int year = d.get(wf.weekBasedYear());
        return String.format("%d-W%02d", year, week);
    }
}
