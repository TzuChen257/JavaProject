package Homework;

public class Player {
	private long Emerald;
	
	Player(){
		Emerald = 128;
	}
	
	public String getEmerald() {
		return ""+Emerald;
	}

	public void setEmerald(int emerald) {
		Emerald = emerald;
	}
	
	public void mine() {
		Emerald++;
	}

	public void pay(String price) {
		Emerald-=Integer.parseInt(price);
	}
	
	public String gift() {
		if(Emerald==0){
			return "broked";
		}
		Emerald--;
		return "";
	}
	
}
