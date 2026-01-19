package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Utils
{
	public static void startTimer(int milliseconds, Runnable timerEvent)
	{
		Timer timer = new Timer(milliseconds, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				timerEvent.run();
			}
		});
		
		timer.start();
	}
}
