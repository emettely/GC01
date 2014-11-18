package whackamole;

//Danny
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Whackamole extends JFrame implements Runnable //implements MouseListener
, MouseListener
{
	private Thread thread;
	private static Container contentPane = new JPanel();
	private static JFrame frame = new JFrame();
	private static JButton[][] buttonHole = new JButton [4][4];
	private static JButton[][] buttonMole = new JButton [4][4];
	private volatile Thread timer;
	private static Graphics g;
	private int next1;
	private int next2;
	private  int mcX;
	private  int mcY;
	private  int points = 0;

	/**
	 * Create the frame.
	 */
	public Whackamole() {

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	//random method
	public void randomize() {
		Random rand = new Random();
		next1 = 100*(Math.round(rand.nextInt(400)/100));
		next2 = 100*(Math.round(rand.nextInt(400)/100));
		System.out.println("next1: " + next1);
		System.out.println("next2: " + next2);
	}

	public void mouseClicked(MouseEvent arg0) {
		mcX = arg0.getLocationOnScreen().x;
		mcY = arg0.getLocationOnScreen().y;
		System.out.println("mouse (" + mcX + "," + mcY + ")");
		if (mcX < next1 + 100 && mcX > next1 && mcY < next2 + 100 && mcY > next2 ){
			points++;
		}

	}


	public static void main(String[] args) throws IOException {

		//for(int tenGames=0; tenGames<10; tenGames++){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,420);
		frame.setResizable(false);
		contentPane = frame.getContentPane();
		contentPane.setBackground(Color.white);

		frame.setVisible(true);

		Whackamole game = new Whackamole();
		game.thread = new Thread(game);
		game.thread.start();
		frame.addMouseListener(game);
	}
	//}


	public void run() {

		JOptionPane.showMessageDialog(null, "Welcome to Whack A Mole,"
				+ " click the moles as they appear.... good luck");

		g = frame.getContentPane().getGraphics();
		g.drawLine(100, 0, 100, 400);
		g.drawLine(200, 0, 200, 400);
		g.drawLine(300, 0, 300, 400);

		g.drawLine(0, 100, 400, 100);
		g.drawLine(0, 200, 400, 200);
		g.drawLine(0, 300, 400, 300);


		//setHoles
		g.setColor(Color.BLACK);

		for(int x=0; x<4; x++){
			for(int y = 0; y<4; y++){
				g.fillOval((100*x), (100*y), 100, 100);
			}
		}       


		for (int i = 0; i < 10; i++){
			g.setColor(Color.BLUE);
			randomize();
			g.fillOval(next1, next2, 100, 100);
			//g.drawImage(image, 0, 0, getWidth() - 1, getHeight() - 1, 0, 0, image.getWidth() - 1, image.getHeight() - 1, this);
			try {
				Thread.sleep(1000-(50*i));
				g.setColor(Color.BLACK);
				g.fillOval(next1, next2, 100, 100);

			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "YOU HAD " + points + " points");

		g.setColor(Color.BLACK);

		for(int x=0; x<4; x++){
			for(int y = 0; y<4; y++){
				g.fillOval((100*x), (100*y), 100, 100);
			}
		}       

	}
}

//
//
//import java.awt.Color;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//import java.awt.GridLayout;
//import java.util.Random;
//
//public class Whackamole extends JFrame implements Runnable //implements MouseListener
//{
//
//	private static JPanel contentPane = new JPanel();
//	private static JFrame frame = new JFrame();
//	private static JButton[][] button = new JButton [4][4];
//	private volatile Thread timer;
//
//	/**
//	 * Create the frame.
//	 */
//	public Whackamole() {
//
//
//
//	}
//
//
//	//set all the button to HOLES
//	public static void setHole(){
//		for(int i=0; i<4;i++){
//			for (int j=0; j<4; j++){
//				button[i][j]=new HoleButton();
//				contentPane.add(button[i][j]);
//			}
//		}
//	}
//
//	//set the random to MOLE
//	public static void setMole(){
//		int row = randomize();
//		int column = randomize();
//		button[row][column]= new MoleButton();
//		contentPane.add(button[row][column]);
//	}
//
//	//random method
//	private static int randomize() {
//		Random rand = new Random();
//		int next1 =0;
//		return next1 = rand.nextInt(4);
//	}
//
//
//
//
//
//
//
//
//
//
//	/**
//	 * Launch the application.
//	 */
//	private void generateThread() {
//		timer = new Thread(this);
//	}
//
//	public static void main(String[] args) {
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(400,400);
//
//
//		frame.setResizable(false);
//
//		contentPane.setBackground(Color.white);
//		contentPane.setLayout(new GridLayout(4, 4));
//		frame.setContentPane(contentPane);
//		setHole();
//
//	}
//
//
//	public void run() {
//		Thread me = Thread.currentThread();
//		while(timer==me){
//			JOptionPane.showMessageDialog(null, "Welcome to Whack A Mole,"
//					+ " click the moles as they appear.... good luck");
//			Whackamole game = new Whackamole();
//			game.setVisible(true);
//			timer.start();
//
//
//			for(int index = 0; index < 25; index++){
//				setMole();
//				setHole();
//				try {
//
//					Thread.sleep(1000);
//
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		JOptionPane.showMessageDialog(null, "YOU HAD " + MoleButton.getScore() + " points");
//	}
//
//}
//
//
//
