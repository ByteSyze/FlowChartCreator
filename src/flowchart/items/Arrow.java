package flowchart.items;

public class Arrow {
	
	Bubble start;
	Bubble end;
	
	public Arrow(Bubble start, Bubble end)
	{
		this.start = start;
		this.end = end;
	}
	
	public Bubble getStart()
	{
		return start;
	}
	
	public Bubble getEnd()
	{
		return end;
	}

}
