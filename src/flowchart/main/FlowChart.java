package flowchart.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import flowchart.items.Arrow;
import flowchart.items.Bubble;

public class FlowChart extends JPanel{
	
	List<Bubble> bubbles = new ArrayList<Bubble>();

	private static final long serialVersionUID = 2224674100961003494L;

	public FlowChart()
	{
		super();
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		drawBubbles((Graphics2D)g);
	}
	
	public void drawBubbles(Graphics g)
	{
		for(Bubble bubble : bubbles)
		{
			for(Arrow arrow : bubble.getArrows())
			{
				g.drawLine(arrow.getStart().x,arrow.getStart().y,arrow.getEnd().x,arrow.getEnd().y);
			}
		}
	}

}
