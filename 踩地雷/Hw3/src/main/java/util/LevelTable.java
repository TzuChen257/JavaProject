package util;

/**
 * 等級表（Level Table）
 * 
 * 以「總積分」對照等級門檻。你可以依遊戲設計自由調整門檻分數。
 * 
 * 規則：
 * - level 1 以上、最高 10 等
 * - 只要 score >= threshold[level] 就能到達該 level
 */
public final class LevelTable {

    // index 0 未使用；threshold[1] = level1 的門檻（通常 0）
    // 下面給一組「越後面升等越難」的示範門檻，可自行調整
    private static final int[] THRESHOLD = new int[] {
        0,
        0,    // Lv1
        100,  // Lv2
        250,  // Lv3
        450,  // Lv4
        700,  // Lv5
        1000, // Lv6
        1350, // Lv7
        1750, // Lv8
        2200, // Lv9
        2700  // Lv10
    };

    private LevelTable() {}

    public static int maxLevel() {
        return THRESHOLD.length - 1;
    }

    public static int calcLevel(int score) {
        int lvl = 1;
        for (int i = maxLevel(); i >= 1; i--) {
            if (score >= THRESHOLD[i]) {
                lvl = i;
                break;
            }
        }
        return lvl;
    }
}
