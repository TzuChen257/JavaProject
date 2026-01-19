package com;

public class HwModel
{
	// fields:
	// 基本資料
    private String name;    
    private String birthday;
    private String mobileNumber;
    private boolean member;  
    
    //方案
    private String level;
    private boolean combo;
    
    //單科 
    private boolean listen;
    private boolean speak;
    private boolean read;
    private boolean write;
    private String errorMsg = "";
    
    //結果
    private int sum; 
    
    

	//constructor
    public HwModel(String name, String birthday, String mobileNumber, boolean member, String level, boolean combo,
			boolean listen, boolean speak, boolean read, boolean write) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.mobileNumber = mobileNumber;
		this.member = member;
		this.level = level;
		this.combo = combo;
		this.listen = listen;
		this.speak = speak;
		this.read = read;
		this.write = write;
		
		calculate(); 
	}

	//get set
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
		calculate();
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
		calculate();
	}

	public boolean isCombo() {
		return combo;
	}

	public void setCombo(boolean combo) {
		this.combo = combo;
		calculate();
	}

	public boolean isListen() {
		return listen;
	}

	public void setListen(boolean listen) {
		this.listen = listen;
		calculate();
	}

	public boolean isSpeak() {
		return speak;
	}

	public void setSpeak(boolean speak) {
		this.speak = speak;
		calculate();
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
		calculate();
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
		calculate();
	}


	public int getSum() {
		return sum;
	} 
	
	public String getErrorMsg() {
	    return errorMsg;
	}
    
	
	
	//method
	private void calculate() {
	    // 每次重算先清掉舊錯誤
	    errorMsg = "";

	    int sum = 0;
	    int price = 0;
	    int count = 0;

	    // 原價目表（依 level 決定 price）
	    if ("A1".equals(level) || "A2".equals(level)) {
	        if (combo) price = 4000;
	        else price = 1200;

	    } else if ("B1".equals(level) || "B2".equals(level)) {
	        if (combo) price = 5000;
	        else price = 1450;

	    } else if ("C1".equals(level) || "C2".equals(level)) {
	        if (combo) price = 6000;
	        else price = 1700;

	    } 

	    // 總價
	    if (combo) {
	        sum = price;

	        // 舊生優惠：只有全科 95 折
	        if (member) {
	            sum = (int)(sum * 0.95);
	        }

	    } else {
	        // 單科：計算選了幾科
	        if (listen) count++;
	        if (speak)  count++;
	        if (read)   count++;
	        if (write)  count++;

	        // 單科最多 3 科
	        if (count > 3) {
	            this.sum = 0;
	            this.errorMsg = "單科最多選 3 科，若要4科請選全科";
	            return;
	        }

	        // 也可以加：至少要選 1 科（可選）
	        if (count == 0) {
	            this.sum = 0;
	            this.errorMsg = "請至少選擇 1 科";
	            return;
	        }

	        sum = count * price;
	    }

	    this.sum = sum;
	}
	
	
	public String getDetail() {
	    String planText = combo ? "全科" : "單科";

	    String subjectText = "";
	    if (!combo) {
	        if (listen) subjectText += "聽、";
	        if (speak)  subjectText += "說、";
	        if (read)   subjectText += "讀、";
	        if (write)  subjectText += "寫、";
	    }
	    
	    if (!subjectText.isEmpty()) { //移除最後的頓號
	        subjectText = subjectText.substring(0, subjectText.length() - 1);
	    }

	    String s = "";
	    /*s += "[姓名]：" + name + "\t\t[等級]：" + level + "\n";
	    s += "[生日]：" + birthday + "\t\t[舊生]：" + (member ? "是" : "否") + "\n";
	    s += "[手機]：" + mobileNumber + "\t\t[方案]：" + planText + "\n";*/
	    
	    s += "[等級]：" + level + "\t\t[姓名]：" + name + "\n";
	    s += "[舊生]：" + (member ? "是" : "否") + "\t\t[生日]：" + birthday + "\n";
	    s += "[方案]：" + planText + "\t\t[手機]：" + mobileNumber + "\n";

	    if (!combo) {
	        s += "[科目]：" + subjectText + "\n";
	    }

	    //s += "========================================\n";
	    s += "[總價]：" + sum + " 元\n";

	    return s;
	}

		
		
		

}
