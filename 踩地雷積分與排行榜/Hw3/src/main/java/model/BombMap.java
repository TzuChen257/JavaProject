package model;

import javax.swing.ImageIcon;

import util.gameSettings.BombButton;
import util.gameSettings.BombResources;

public class BombMap {
	//test main
	public static void main(String[] args) {
		
	}
	//f
	private int x;//橫向座標
	private int y;//縱向座標
	private int surroundBomb=0;//-1)bomb 0)nothing 1-8)num
	private boolean isBomb=false;
	private ImageIcon image;//圖示 0)nothing 1-8)num 9)bump
	private BombButton button=new BombButton();
	//c
	public BombMap(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		button.setIcon(BombResources.getButtonImage("white"));
	}
	//m
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSurroundBomb() {
		return surroundBomb;
	}
	public void setSurroundBomb(int surroundBomb) {
		this.surroundBomb = surroundBomb;
	}
	public boolean isBomb() {
		return isBomb;
	}
	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public BombButton getButton() {
		return button;
	}
	public void setButton(BombButton button) {
		this.button = button;
	}
}