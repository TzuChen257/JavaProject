package com;

public class work1 {
	 
	private int au;
	private int pt;
	private int ag;
	private double sum;
	public work1(int au, int pt, int ag ,boolean 會員) {
		super();
		this.au = au;
		this.pt = pt;
		this.ag = ag;
		sum =au*15000+pt*7000+ag*1600;
		if(會員) sum=sum*0.95;
		
		
		
	}
	
	
	public int getAu() {
		return au;
	}
	public void setAu(int au) {
		this.au = au;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public int getAg() {
		return ag;
	}
	public void setAg(int ag) {
		this.ag = ag;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
}
