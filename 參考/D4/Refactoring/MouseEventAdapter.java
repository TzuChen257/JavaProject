package main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventAdapter extends MouseAdapter
{

	Runnable clickEvent;
	public MouseEventAdapter(Runnable clickEvent)
	{
		this.clickEvent = clickEvent;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		clickEvent.run();
	}
}
