package flowchart.main;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import flowchart.listeners.KeyboardListener;

public class Main {
	
	public static FlowChart flowChart = new FlowChart();
	public static JFrame frame;
	
	public static JFileChooser chooser = new JFileChooser();
	
	public static void main(String[] args)
	{
		
		frame = new JFrame("Bubble Diagram");
		frame.addKeyListener(new KeyboardListener());
		frame.add(flowChart);
		frame.setSize(1280,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
