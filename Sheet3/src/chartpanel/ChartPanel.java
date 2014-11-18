package chartpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChartPanel extends JPanel {
	  private double[] values;
	  private String[] names;

	public ChartPanel(double[] v, String[] n) {
	 names = n;
	 values = v;

	}

	@Override
	public void paintComponent (Graphics g){
		//clear the screen
		super.paintComponent(g);
//bar chart drawing code here
		
		Dimension d = getSize();
		int height = d.height;
		int width = d.width;

		int barWidth = width / values.length;
		int maxValue = max(values)+2;//(int) values[2];
		int scale = height/maxValue;
		int space = 50;

		// Fonts
		Font labelFont = new Font("ComicSans", Font.PLAIN, 15);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
//
//		int name = labelFontMetrics.getHeight();

		g.setFont(labelFont);


		//for every value, find XY

		for (int i = 0; i < values.length; i++) {
			
			//where it starts (X,Y)
			int X = i * barWidth + space/2;
			int Y = (int) (height*-values[0]/(maxValue));
			
			//length of the rectangle
			int length = (int) (values[i] * scale);

			//if value is greater than 0, find Y
			if (values[i] >= 0)
				Y = Y + (int) ((maxValue - values[i]) * scale);
			else {
				Y = Y + (int) (maxValue * scale);
				length = -length;
			}

			//set colours and draw
			  g.setColor(Color.red);
			  g.fillRect(X, Y, barWidth - space, length);
			  g.setColor(Color.black);
			  g.drawRect(X, Y, barWidth - space, length);

			  //font
			  int labelWidth = labelFontMetrics.stringWidth(names[i]);
			  int x = i * barWidth + (barWidth - labelWidth) / 2;
			  int y = height - labelFontMetrics.getDescent();
			  g.drawString(names[i], x, y);

			 }
			
	}

	private int max(double[] values2) {
		int max =0;
		for(double d : values2){
			if(d>max) max=(int) d;
		}


		return max;
	}
	

}
