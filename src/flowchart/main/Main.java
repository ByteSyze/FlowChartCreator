package flowchart.main;

import javax.swing.JFrame;

public class Main {
	
	public static FlowChart flowChart = new FlowChart();
	
	public static void main(String[] args)
	{
		
		JFrame f = new JFrame("Bubble Diagram");
		f.add(flowChart);
		f.setSize(1280,720);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

}
