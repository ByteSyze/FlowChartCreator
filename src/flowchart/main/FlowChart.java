package flowchart.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import flowchart.items.Arrow;
import flowchart.items.Bubble;
import flowchart.listeners.MouseListener;

public class FlowChart extends JPanel{
	
	List<Bubble> bubbles = new ArrayList<Bubble>();

	private static final long serialVersionUID = 2224674100961003494L;
	
	Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	FontMetrics metrics;
	
	MouseListener listener = new MouseListener();

	public FlowChart()
	{
		super();
		
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		
		/*Bubble bub1 = new Bubble(Bubble.BUBBLE_COUNT,100,100,50,"Test123");
		Bubble bub2 = new Bubble(Bubble.BUBBLE_COUNT,200,50,50,"Beep");
		Bubble bub3 = new Bubble(Bubble.BUBBLE_COUNT,300,300,50,"Bubble3");
		
		bub1.addArrowTo(bub2);
		bub1.addArrowTo(bub3);
		bubbles.add(bub1);
		bubbles.add(bub2);
		bubbles.add(bub3);*/
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawBubbles(g2d);
		
	}
	
	public void drawBubbles(Graphics g)
	{
		for(Bubble bubble : bubbles)
		{
			for(Arrow arrow : bubble.getArrows())
			{
				if(arrow.getStart() == bubble)
					g.drawLine(arrow.getStart().getLocation().x+bubble.getRadius()/2,arrow.getStart().getLocation().y+bubble.getRadius()/2,arrow.getEnd().getLocation().x+bubble.getRadius()/2,arrow.getEnd().getLocation().y+bubble.getRadius()/2);
			}
			
			g.setFont(font);
			metrics = g.getFontMetrics();
			
			g.setColor(Color.WHITE);
			g.fillOval(bubble.getLocation().x, bubble.getLocation().y, bubble.getRadius(), bubble.getRadius());
			
			if(bubble.isSelected())
				g.setColor(Color.BLUE);
			else
				g.setColor(Color.BLACK);
			
			g.drawOval(bubble.getLocation().x, bubble.getLocation().y, bubble.getRadius(), bubble.getRadius());
			g.drawString(bubble.getText(), bubble.getLocation().x-(metrics.stringWidth(bubble.getText())/2)+(bubble.getRadius()/2), bubble.getLocation().y+(int)(metrics.getHeight()*2));
		}
	}
	
	public List<Bubble> getBubbles()
	{
		return bubbles;
	}
	
	public void setBubbles(List<Bubble> bubbles)
	{
		this.bubbles = bubbles;
	}
	
	public Bubble getBubbleAt(int x, int y)
	{
		for(Bubble bubble : bubbles)
		{
			if(bubble.contains(x, y))
			{
				return bubble;
			}
		}
		return null;
	}
	
	public Bubble getMovingBubble()
	{
		for(Bubble bubble : bubbles)
		{
			if(bubble.isMoving())
			{
				return bubble;
			}
		}
		return null;
	}
	
	public Bubble getBubbleById(int id)
	{
		for(Bubble bubble : bubbles)
		{
			if(bubble.getId() == id)
			{
				return bubble;
			}
		}
		return null;
	}
	
	public List<Bubble> getSelectedBubbles()
	{
		List<Bubble> selected = new ArrayList<Bubble>();
		for(Bubble bubble : bubbles)
		{
			if(bubble.isSelected())
			{
				selected.add(bubble);
			}
		}
		return selected;
	}
	
	public void removeBubble(Bubble bubble)
	{
		for(Arrow arrow : bubble.getArrows())
		{
			arrow.getStart().removeArrow(arrow);
			arrow.getEnd().removeArrow(arrow);
		}
		this.bubbles.remove(bubble);
	}
	
	public void removeBubbles(List<Bubble> bubbles)
	{
		for(Bubble bubble : bubbles)
		{
			removeBubble(bubble);
		}
	}

}
