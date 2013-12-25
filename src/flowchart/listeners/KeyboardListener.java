package flowchart.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
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
				int option = Main.chooser.showSaveDialog(Main.frame);
				if(option == JFileChooser.APPROVE_OPTION)
				{
					File file = Main.chooser.getSelectedFile();
					FlowChartIO.saveBubbleDiagram(file);
					JOptionPane.showMessageDialog(Main.frame, "Saved!");
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_O)
		{
			if(e.isControlDown())
			{
				int option = Main.chooser.showOpenDialog(Main.frame);
				if(option == JFileChooser.APPROVE_OPTION)
				{
					File file = Main.chooser.getSelectedFile();
					FlowChartIO.openSchematic(file);
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			Main.flowChart.removeBubbles(Main.flowChart.getSelectedBubbles());
			Main.flowChart.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			if(e.isControlDown())
			{
				Main.flowChart.addBubble();
				Main.flowChart.repaint();
			}
			else if(e.isShiftDown())
			{
				int size = Main.flowChart.getSelectedBubbles().size();
				if(size > 0)
				{
					for(int i = 0; i < size; i++)
					{
						if(i%2==0)
						{
							Main.flowChart.getSelectedBubbles().get(i).addArrowTo
								(Main.flowChart.getSelectedBubbles().get(i+1));
						}
					}
				}
				Main.flowChart.repaint();
			}
		}
	}

}
