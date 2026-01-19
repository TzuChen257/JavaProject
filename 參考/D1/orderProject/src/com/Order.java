package com;

public class Order {
	private String name;
	private int pendant;    
	private int walllamp;   
	private int floorlamp;  
	private double sum;
	private boolean member;
	public Order(String name, int pendant, int walllamp, int floorlamp, boolean member) {
		super();
		this.name = name;
		this.pendant = pendant;
		this.walllamp = walllamp;
		this.floorlamp = floorlamp;
		this.member = member;
		sum=pendant*10999+walllamp*7999+floorlamp*5999;
		if(member) sum=sum*0.9;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPendant() {
		return pendant;
	}
	public void setPendant(int pendant) {
		this.pendant = pendant;
	}
	public int getWalllamp() {
		return walllamp;
	}
	public void setWalllamp(int walllamp) {
		this.walllamp = walllamp;
	}
	public int getFloorlamp() {
		return floorlamp;
	}
	public void setFloorlamp(int floorlamp) {
		this.floorlamp = floorlamp;
	}
	public boolean isMember() {
		return member;
	}
	public void setMember(boolean member) {
		this.member = member;
	}
	public double getSum() {
		return sum;
	}
	
	

}