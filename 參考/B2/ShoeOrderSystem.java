package com2;

public class ShoeOrderSystem {
	
	//fields
	private String name;
	private int nikeJordan=0;
	private int nikeTiempo=0;
	private int nikeAir=0;
	private int nikeACG=0;
	private int nikeMind=0;
	private boolean taxIncluded;
	private double sum;
	
	
	//constructors
	ShoeOrderSystem(String name, int nikeJordan, int nikeTiempo, int nikeAir, int nikeACG, int nikeMind, boolean taxIncluded)
	{
		this.name=name;
		this.nikeJordan=nikeJordan;
		this.nikeTiempo=nikeTiempo;
		this.nikeAir=nikeAir;
		this.nikeACG=nikeACG;
		this.nikeMind=nikeMind;
		this.taxIncluded=taxIncluded;
		sum = (nikeJordan*7200+nikeTiempo*6080+nikeAir*3800+nikeACG*4000+nikeMind*4500);
		if(taxIncluded) sum=sum*1.05;
				
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNikeJordan() {
		return nikeJordan;
	}


	public void setNikeJordan(int nikeJordan) {
		this.nikeJordan = nikeJordan;
	}


	public int getNikeTiempo() {
		return nikeTiempo;
	}


	public void setNikeTiempo(int nikeTiempo) {
		this.nikeTiempo = nikeTiempo;
	}


	public int getNikeAir() {
		return nikeAir;
	}


	public void setNikeAir(int nikeAir) {
		this.nikeAir = nikeAir;
	}


	public int getNikeACG() {
		return nikeACG;
	}


	public void setNikeACG(int nikeACG) {
		this.nikeACG = nikeACG;
	}


	public int getNikeMind() {
		return nikeMind;
	}


	public void setNikeMind(int nikeMind) {
		this.nikeMind = nikeMind;
	}


	public boolean isTaxIncluded() {
		return taxIncluded;
	}


	public void setTaxIncluded(boolean taxIncluded) {
		this.taxIncluded = taxIncluded;
	}


	public double getSum() {
		return sum;
	}
	
	
	
	
	

}
