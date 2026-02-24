package util.gameSettings;

import javax.swing.JButton;

public class BombButton extends JButton{
	//f
	private boolean isFlag=false;
	//m
	public boolean isFlag() {
		return isFlag;
	}
	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
}