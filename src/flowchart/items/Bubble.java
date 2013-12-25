package flowchart.items;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Bubble {
	
	private List<Arrow> arrows = new ArrayList<Arrow>();
	
	int radius; // Radius of the bubble
	String text; // The text this bubble holds
	
	boolean loop; // A state where the bubble will loop if it is meant to stay in this state for any reason
	String loopText;
	
	Point location;
	
	public Bubble(int x, int y, int radius, String text)
	{
		location = new Point(x,y);
		
		this.radius = radius;
		this.text = text;
	}
	
	public void addArrow(Arrow arrow)
	{
		arrows.add(arrow);
	}
	
	public List<Arrow> getArrows()
	{
		return arrows;
	}
	

}
