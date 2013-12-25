package flowchart.items;

public class Arrow {
	
	Bubble start;
	Bubble end;
	
	String text;
	
	public Arrow(Bubble start, Bubble end)
	{
		this.start = start;
		this.end = end;
	}
	
	public Arrow(Bubble start, Bubble end, String text)
	{
		this.start = start;
		this.end = end;
		this.text = text;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setText(String text)
	{
		this.text = text;
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
