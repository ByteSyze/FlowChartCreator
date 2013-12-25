package flowchart.items;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Bubble {
	
	public static int BUBBLE_COUNT = 0;
	
	int id;
	
	private List<Arrow> arrows = new ArrayList<Arrow>();
	
	int radius; // Radius of the bubble
	String text; // The text this bubble holds
	
	boolean loop = false; // A state where the bubble will loop if it is meant to stay in this state for any reason
	String loopText;
	
	Point location;
	
	boolean moving = false;
	
	public Bubble(int id, int x, int y, int radius, String text)
	{
		this.id = id;
		BUBBLE_COUNT++;
		
		location = new Point(x,y);
		
		this.radius = radius;
		this.text = text;
	}
	
	public void addArrow(Arrow arrow)
	{
		arrows.add(arrow);
	}
	
	public void addArrowTo(Bubble bubble)
	{
		arrows.add(new Arrow(this,bubble));
	}
	
	public List<Arrow> getArrows()
	{
		return arrows;
	}
	
	public Point getLocation()
	{
		return location;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public String getText()
	{
		return text;
	}
	
	public boolean contains(int x, int y)
	{
		if(location.x+radius >= x && location.x-radius <= x)
		{
			if(location.y+radius >= y && location.y-radius <= y)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isMoving()
	{
		return moving;
	}
	
	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}
	
	public void setLocation(int x, int y)
	{
		location = new Point(x,y);
	}
	
	public int getId()
	{
		return id;
	}

}
