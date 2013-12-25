package flowchart.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import flowchart.items.Bubble;
import flowchart.main.Main;

public class MouseListener extends MouseAdapter{
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		Bubble bubble = Main.flowChart.getBubbleAt(e.getX(), e.getY());
		
		if(bubble != null)
		{
			bubble.setMoving(true);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
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

}
