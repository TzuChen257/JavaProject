package util.gameSettings;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import model.BombMap;

public class GameControl<T extends JFrame>//給任何level使用
{
	//f
	private T ui_bylevel;
	private BombMap[] newGame;
	public static int bomb;
	public static int flag;
	public static int buttonLast;
	//c
	public GameControl(T ui_bylevel, BombMap[] newGame) {
		super();
		this.ui_bylevel = ui_bylevel;
		this.newGame = newGame;
	}
	//m
	public T getUi_bylevel() {
		return ui_bylevel;
	}

	public void setUi_bylevel(T ui_bylevel) {
		this.ui_bylevel = ui_bylevel;
	}

	public BombMap[] getNewGame() {
		return newGame;
	}

	public void setNewGame(BombMap[] newGame) {
		this.newGame = newGame;
	}
	//method自設
	//空白鍵無限叫自己的遞迴
	public void revealEmpty(BombMap m)
	{
		//cost所有八個打開
		List<BombMap> arround=BombMapTool.arroundBomps(m.getX(), m.getY(), newGame);
		for(BombMap bArround:arround)
		{
			BombButton b0=bArround.getButton();
			if(b0.isVisible()&&!b0.isFlag())//未打開也非旗子
			{
				b0.setVisible(false);
				buttonLast--;
				if(bArround.getSurroundBomb()==0)
				{
					revealEmpty(bArround);
				}
			}
		}
	}
	//顯示所有地雷
	public void showAllBomb()
	{
		Arrays.stream(newGame).forEach(box->{
			if(box.isBomb())
			{
				box.getButton().setVisible(false);
			}
		});
	}
	//確認是否贏
	public boolean iswin()
	{
		return buttonLast==bomb;
	}
}