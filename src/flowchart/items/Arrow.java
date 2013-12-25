package flowchart.items;

import java.awt.Point;

public class Arrow {
	
	Point startPoint;
	Point endPoint;
	
	
	public Arrow(int x1, int y1, int x2, int y2)
	{
		startPoint = new Point(x1,y1);
		endPoint = new Point(x2,y2);
	}
	
	public Arrow(Point start, Point end)
	{
		startPoint = start;
		endPoint = end;
	}
	
	public Arrow(Bubble start, Bubble end)
	{
		startPoint = start.location;
		endPoint = end.location;
	}
	
	public Point getStart()
	{
		return startPoint;
	}
	
	public Point getEnd()
	{
		return endPoint;
	}

}
