package util.gameSettings;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class BombResources {
	//匯入圖片
	public static ImageIcon getBottomImage(String bottomName)
	{
		URL imgURL=BombResources.class.getResource("/icons/bottom_"+bottomName+".png");
		ImageIcon originalIcon=new ImageIcon(imgURL);
		Image scaledImage=originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon finalIcon=new ImageIcon(scaledImage);
		return finalIcon;
	}
	public static ImageIcon getBottomImage(int arroundBombNum)
	{
		URL imgURL=BombResources.class.getResource("/icons/bottom_"+arroundBombNum+".png");
		ImageIcon originalIcon=new ImageIcon(imgURL);
		Image scaledImage=originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon finalIcon=new ImageIcon(scaledImage);
		return finalIcon;
	}
	public static ImageIcon getButtonImage(String buttonName)
	{
		URL imgURL=BombResources.class.getResource("/icons/button_"+buttonName+".png");
		ImageIcon originalIcon=new ImageIcon(imgURL);
		Image scaledImage=originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon finalIcon=new ImageIcon(scaledImage);
		return finalIcon;
	}
	public static ImageIcon getBackgroundImage(String picName)
	{
		URL imgURL=BombResources.class.getResource("/icons/"+picName+".png");
		ImageIcon originalIcon=new ImageIcon(imgURL);
		Image scaledImage=originalIcon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon finalIcon=new ImageIcon(scaledImage);
		return finalIcon;
	}
	public static ImageIcon getResultImage(String picName)
	{
		URL imgURL=BombResources.class.getResource("/icons/"+picName+".png");
		ImageIcon originalIcon=new ImageIcon(imgURL);
		Image scaledImage=originalIcon.getImage().getScaledInstance(270, 270, Image.SCALE_SMOOTH);
		ImageIcon finalIcon=new ImageIcon(scaledImage);
		return finalIcon;
	}
	//匯入影音
	public static void playSound(String fileName)
	{
		new Thread(()->{
			URL url=BombResources.class.getResource("/sounds/" + fileName + ".wav");
            if (url==null) return;
			try {
				AudioInputStream audioInput=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} catch (UnsupportedAudioFileException e) {
				System.out.println("Input階段檔案格式無法支援");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Input階段資料輸入有誤");
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				System.out.println("clip階段無法輸出");
				e.printStackTrace();
			}
		}).start();
	}
	//匯入字體
	public static Font getDigitalFont(String fontStyle,float size)
	{
		Font digitalFont=null;
		try {
			InputStream input=BombResources.class.getResourceAsStream("/fonts/"+fontStyle+".TTF");
			digitalFont=Font.createFont(Font.TRUETYPE_FONT, input);
			//註冊字體
			/*
			GraphicsEnvironment enviromment=GraphicsEnvironment.getLocalGraphicsEnvironment();
			enviromment.registerFont(digitalFont);
			*/
			return digitalFont.deriveFont(size);
		} catch (FontFormatException|IOException e) {
			e.printStackTrace();
			return new Font("Arial", Font.BOLD, (int)size);
		}		
	}
}