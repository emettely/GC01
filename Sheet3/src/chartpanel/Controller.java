package chartpanel;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Controller {


	public static void main (String[] args) throws Exception{
		// run asynchronously
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize (new Dimension(400,300));
		
		double [] values = new double[3];
		String [] names = new String[3];
		
		values[0] = 1;
		names[0] = "Item 1";
		values[1] = 7;
		names[1] = "Item 2";		
		values[2] = 4;
		names[2] = "Item 3";
		
		
		
		frame.getContentPane().add(new ChartPanel(values,names));
		frame.add(new ChartPanel(values, names));//knows it exists
		frame.setVisible(true);
	}
}