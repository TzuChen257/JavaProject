package Homework;

public class Villager {
	private String name;
	private int level , exp ,health;
	private int mood; // 心情值 0 = 普通 ,-1 = 生氣 ,1 = 高興

	Villager(){
		exp = 0;
		level = 1;
		health = 10;
		mood = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getLevelName() {
		if(exp>=0 && exp<20) {
			if(exp<10)
				setLevel(1);
			else
				setLevel(2);
			return "新手";
		}else if (exp>=20 && exp<40) {
			if(exp<30)
				setLevel(3);
			else
				setLevel(4);
			return "學徒";
		}else if (exp>=40 && exp<60) {
			if(exp<50)
				setLevel(5);
			else
				setLevel(6);
			return "老手";
		}else if (exp>=60 && exp<80) {
			if(exp<70)
				setLevel(7);
			else
				setLevel(8);
			return "專家";
		}else {
			setLevel(9);
			return "大師";
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	public String getExp() {
		switch(getLevel()) {
			case 1:
				return exp+"/10";
			case 2:
				return exp+"/20";
			case 3:
				return exp+"/30";
			case 4:
				return exp+"/40";
			case 5:
				return exp+"/50";
			case 6:
				return exp+"/60";
			case 7:
				return exp+"/70";
			case 8:
				return exp+"/80";
			case 9:
				return "Max/Max";
			default:
				return "error/error";
		
		}
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void addExp(String exp) {
		this.exp+=Integer.parseInt(exp);
	}


	public String getMoodName() {
		if (mood<0)
			return "生氣";
		else if(mood >0)
			return "開心";
		else
			return "平靜";
	}

	public int getMood() {
		return mood;
	}

	public void setMood(int mood) {
		this.mood = mood;
	}
	
	public void earnMoney() {
		if (mood<0)
			setMood(0);
		else
			setMood(1);
	}


	public String getHealth() {
		return ""+health;
	}

	public String attack() {
		if (mood>0)
			setMood(0);
		else
			setMood(-1);
		
		if(health>1) {
			health--;
			return "";
		}else {
			health=0;
			return "dead";
		}
	}
	

	
	
}
