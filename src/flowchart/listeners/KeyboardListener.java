package flowchart.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JOptionPane;

import flowchart.io.FlowChartIO;
import flowchart.main.Main;

public class KeyboardListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(e.isControlDown())
			{
				Main.chooser.showSaveDialog(Main.frame);
				File file = Main.chooser.getSelectedFile();
				FlowChartIO.saveBubbleDiagram(file);
				JOptionPane.showMessageDialog(Main.frame, "Saved!");
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_O)
		{
			if(e.isControlDown())
			{
				Main.chooser.showOpenDialog(Main.frame);
				File file = Main.chooser.getSelectedFile();
				FlowChartIO.openSchematic(file);
			}
		}
	}

}
