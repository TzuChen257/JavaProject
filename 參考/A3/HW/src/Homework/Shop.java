package Homework;

import java.util.Random;

public class Shop extends Villager {
    private String[][] sellList =new String[7][];
	
    private String[][] items= new String[][] {
		//物品名稱 物品售價 交易exp 商品可購買數
		{"書櫃","9","2","9"},
		{"燈籠","1","5","4"},
		{"玻璃x4","1","10","10"},
		{"羅盤","4","15","2"},
		{"時鐘","5","15","2"},
		{"命名牌","20","30","5"},
		{"彩蛋-\"你渴望財富嗎?\"","1","200","1"}
	};
	
	
	private String[] books = new String[]{
		"附魔書-\"鋒利\"",
		"附魔書-\"火焰保護\"",
		"附魔書-\"尖刺\"",
		"附魔書-\"無限\"",
		"附魔書-\"不死剋星\"",
		"附魔書-\"節肢剋星\"",
		"附魔書-\"擊退\"",
		"附魔書-\"綁定詛咒\"",
		"附魔書-\"親水性\"",
		"附魔書-\"掠奪\"",
		"附魔書-\"冰霜行者\"",
		"附魔書-\"爆炸保護\"",
		"附魔書-\"燃燒\"",
		"附魔書-\"火焰\"",
		"附魔書-\"輕盈\"",
		"附魔書-\"強力\"",
		"附魔書-\"深海漫遊\"",
		"附魔書-\"水中呼吸\"",
		"附魔書-\"消失詛咒\"",
		"附魔書-\"幸運\"",
	};
	private int[] booksMaxlevel = new int[] {
		5,4,3,1,5,5,2,1,1,3,2,4,2,1,4,5,3,3,1,3	
	};
	
	
	
    Shop(){
        super();
        setSellList();
    }

    public void setSellList() {
        sellList =new String[7][];
    	for(int i=0 ; i<sellList.length;i++) {
    		if (sellList[i] == null) {
    			Random rand = new Random();
    			if(rand.nextInt(2) == 0) {
        			sellList[i]=items[i];
        		}else {
        			sellList[i]=addBook();
        		}    			
    		}
    	}
    }
    
    public String[][] getSellList(){
        return sellList;
    }
    
	public String[] addBook() {
		Random rand = new Random();
		int bookCode =rand.nextInt(books.length);
        //價格計算 2+附魔等級×3 ~ 6+附魔等級×13
		int base = rand.nextInt(5)+2;
		int rate = rand.nextInt(11)+3;
		String book=books[bookCode];
		int bookPrice=0;
		switch(rand.nextInt(booksMaxlevel[bookCode])+1) {
		case 1:
			book+=" I";
			bookPrice = (base+1*rate) >64 ? 64: base+1*rate;
			break;
		case 2:
			book+=" II";
			bookPrice = (base+2*rate) >64 ? 64: base+2*rate;
			break;
		case 3:
			book+=" III";
			bookPrice = (base+3*rate) >64 ? 64: base+3*rate;
			break;
		case 4:
			book+=" IV";
			bookPrice = (base+4*rate) >64 ? 64: base+4*rate;
			break;
		case 5:
			book+=" V";
			bookPrice = (base+5*rate) >64 ? 64: base+5*rate;
			break;
		}
		String i[]={book,""+bookPrice,"15","4"};
		return i;
	}
	
}