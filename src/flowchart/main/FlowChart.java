package flowchart.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

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
		drawBubbles(g);
	}
	
	public void drawBubbles(Graphics g)
	{
		for(Bubble bubble : bubbles)
		{
			
		}
	}

}
