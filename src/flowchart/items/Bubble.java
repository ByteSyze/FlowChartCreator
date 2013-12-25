package flowchart.items;

public class Bubble {
	
	int radius; // Radius of the bubble
	String text; // The text this bubble holds
	
	boolean loop; // A state where the bubble will loop if it is meant to stay in this state for any reason
	String loopText;
	
	public Bubble(int radius, String text)
	{
		this.radius = radius;
		this.text = text;
	}
	

}
