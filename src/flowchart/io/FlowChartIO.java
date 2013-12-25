package flowchart.io;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import flowchart.items.Arrow;
import flowchart.items.Bubble;
import flowchart.main.Main;

public class FlowChartIO {
	
	/**Creates an image containing the initial schematic image as well as
	 * colored bubbles, based on their specified colors.*/
	public static BufferedImage makeBubbleImage()
	{

		BufferedImage output = new BufferedImage(2048, 2048, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)output.getGraphics();

		g.setColor(Color.BLACK);		
		Main.flowChart.drawBubbles(g);
		
		return output;
	}
	
	public static void saveImage(BufferedImage image, String outputName)
	{
		try {
			ImageIO.write(image, "png", new File(outputName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveBubbleDiagram(String outputName)
	{
		try {
			PrintWriter writer = new PrintWriter("bubbles"+".bd");
			
			writer.println("Bubbles:");
			for(Bubble bubble : Main.flowChart.getBubbles())
			{
				Point loc = bubble.getLocation();
				writer.println("bubble:"+bubble.getId()+":"+loc.x+":"+loc.y+":"+bubble.getRadius()+":"+bubble.getText());
			}
			
			for(Bubble bubble : Main.flowChart.getBubbles())
			{
				for(Arrow arrow : bubble.getArrows())
				{
					writer.println("arrow:"+arrow.getStart().getId()+":"+arrow.getEnd().getId());
				}
			}
			
			writer.println("end");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openSchematic()
	{
		try {
			FileReader reader = new FileReader("bubbles.bd");
			BufferedReader bReader = new BufferedReader(reader);
			
			String currentLine;
			
			//A list to hold all bubbles read from file
			List<Bubble> bubbles = new ArrayList<Bubble>();
			//Current bubble being built from file
			Bubble currentBubble = null;
			
			
			//All schematic files should have "end" as their last line, hence this should
			//loop until the end of file.
			while((currentLine = bReader.readLine()) != null)
			{
				if(currentLine.startsWith("bubble"))
				{
					if(currentBubble != null) bubbles.add(currentBubble);

					currentLine = currentLine.substring(currentLine.indexOf(":")+1);
					int id = Integer.parseInt(currentLine.substring(0, currentLine.indexOf(":")));
					
					currentLine = currentLine.substring(currentLine.indexOf(":")+1);
					int x = Integer.parseInt(currentLine.substring(0, currentLine.indexOf(":")));

					currentLine = currentLine.substring(currentLine.indexOf(":")+1);
					int y = Integer.parseInt(currentLine.substring(0, currentLine.indexOf(":")));

					currentLine = currentLine.substring(currentLine.indexOf(":")+1);
					int radius = Integer.parseInt(currentLine.substring(0, currentLine.indexOf(":")));
					
					String text = currentLine.substring(currentLine.indexOf(":")+1);
					
					currentBubble = new Bubble(id,x,y,radius,text);
				}
				else if(currentLine.startsWith("arrow"))
				{
					bubbles.add(currentBubble);
					Main.flowChart.setBubbles(bubbles);					

					currentLine = currentLine.substring(currentLine.indexOf(":")+1);
					int id1 = Integer.parseInt(currentLine.substring(0, currentLine.indexOf(":")));
					currentLine = currentLine.substring(currentLine.indexOf(":")+1);
					int id2 = Integer.parseInt(currentLine);	
					
					Main.flowChart.getBubbleById(id1).addArrowTo(Main.flowChart.getBubbleById(id2));
					
				}
				
			}
			Main.flowChart.repaint();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
