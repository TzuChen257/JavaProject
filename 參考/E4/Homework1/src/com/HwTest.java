package com;

public class HwTest {

	public static void main(String[] args) {
		HwModel t2 = new HwModel(
                "Amy",
                "2000/01/01",
                "0988-111-222",
                false,         // 非舊生
                "B1",
                false,         // 單科
                true,  false,  true,  false
        );

        System.out.println("===== 測試 2 =====");
        System.out.println(t2.getDetail());
        System.out.println("預期總價：2900");
        System.out.println("------------------");

	}

}
