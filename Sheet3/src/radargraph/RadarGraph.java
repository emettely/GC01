package radargraph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;



public class RadarGraph extends JPanel {
	private static boolean fixed = false;
	static double[][] data_x;
	static double[][] data_y;
	
	public RadarGraph(){
		setBackground(Color.white);
	}

	@Override
	public void paintComponent (Graphics g){
		//clear the screen
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawWeb(g2d);
	}

	public static void setData(){
		data_x = new double[3][5];
		data_y = new double[3][5];

		for (int i =0;i<3;i++){
			for (int j =0;j<5;j++){
				double rNum = Math.random();
				data_x[i][j]=rNum;
				data_y[i][j]=rNum;
			}
		}
		System.out.println("data set");
		fixed=true;
	}


	private void drawWeb(Graphics2D g2d){
		if(!fixed) setData(); 
		int centreX = this.getWidth() / 2;
		int centreY = this.getHeight() / 2;
		double armLength = centreY*.9;
		double angle = (Math.PI*2)/5;
		double [] arms = new double[] {0, angle, angle*2, angle*3, angle*4};
		int endX = 0;
		int endY = 0;


		//create matrix and draw random pictures
		int matrix_x[][] = new int[3][5];
		int matrix_y[][] = new int[3][5];
		for(int i =0; i<3; i++){
			for(int j=0; j < arms.length; j++){
				matrix_x[i][j] = centreX+(int)((armLength*data_x[i][j])*Math.cos(arms[j]+1.5*Math.PI));
				matrix_y[i][j] = centreY+(int)((armLength*data_y[i][j])*Math.sin(arms[j]+1.5*Math.PI));
			}
		}
		g2d.setColor(Color.CYAN);
		g2d.fillPolygon((matrix_x[0]), (matrix_y[0]), 5);


		g2d.setColor(Color.magenta);
		g2d.fillPolygon((matrix_x[1]), (matrix_y[1]), 5);


		g2d.setColor(Color.yellow);
		g2d.fillPolygon((matrix_x[2]), (matrix_y[2]), 5);


		//for (int draw=0; draw<3; draw++){
		//g2d.drawLine(centreX, centreY, matrix[draw][], );
		//}

		// create 5 arms
		for (int i=0; i<arms.length; i++){
			g2d.setColor(Color.black);
			endX = (int)(armLength*Math.cos(angle*i-0.5*Math.PI)+centreX);
			endY = (int)(armLength*Math.sin(angle*i-0.5*Math.PI)+centreY);
			g2d.drawLine(centreX, centreY, endX, endY);


		}

		//draw from new point to end point for 1 shape
		for (int i = 0; i<11; i++){
			int [] endX1 = new int[5];
			int [] endY1 = new int[5];
			for (int j = 0; j<5; j++){
				endX1 [j] = (int)(armLength/10*i*Math.cos(arms[j]-0.5*Math.PI)+centreX);
				endY1 [j] = (int)(armLength/10*i*Math.sin(arms[j]-0.5*Math.PI)+centreY);
			} //drawing from point to point
			for(int k = 0; k  < 5; k++) {
				if (k==4){
					g2d.drawLine(endX1[k], endY1[k], endX1[k-4], endY1[k-4]);
				}else{
					g2d.drawLine(endX1[k], endY1[k], endX1[k+1], endY1[k+1]);
				}
			}
		}

	}

}



