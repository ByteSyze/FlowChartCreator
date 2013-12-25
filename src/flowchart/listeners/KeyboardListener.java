package flowchart.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import flowchart.io.FlowChartIO;

public class KeyboardListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(e.isControlDown())
			{
				FlowChartIO.saveBubbleDiagram("bubbles");
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_O)
		{
			if(e.isControlDown())
			{
				FlowChartIO.openSchematic();
			}
		}
	}

}
