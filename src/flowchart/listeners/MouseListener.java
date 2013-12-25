package flowchart.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import flowchart.items.Bubble;
import flowchart.main.Main;

public class MouseListener extends MouseAdapter{
	
	public static int x;
	public static int y;
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		Bubble bubble = Main.flowChart.getBubbleAt(e.getX(), e.getY());
		
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			if(e.isShiftDown())
			{
				if(bubble.isSelected())
				{
					bubble.setSelected(false);
				}
				else
					bubble.setSelected(true);
			}
			else
			{
				Main.flowChart.setSelectedBubble(bubble);
			}
			Main.flowChart.repaint();
		}
		
		if(bubble != null)
		{
			bubble.setMoving(true);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		
		Bubble bubble = Main.flowChart.getMovingBubble();
		
		if(bubble != null)
		{
			if(e.isControlDown())
			{
				bubble.setLocation(e.getX()-bubble.getRadius()/2, e.getY()-bubble.getRadius()/2);
				Main.flowChart.repaint();
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		Bubble bubble = Main.flowChart.getMovingBubble();
		
		if(bubble != null)
		{
			bubble.setMoving(false);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
	}

}
