

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.StyleConstants.ColorConstants;


public class Frame extends JFrame implements Runnable, MouseListener {
    private Thread thread;
    private static JFrame frame = new JFrame();
    private static Graphics g;
    private static Container c = new Container();
    private  int mcX;
    private  int mcY;
    private  int points =0;
    private  int bcX;
    private  int bcY;
    
    public Frame(){

    }
    
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    public void randomize(){
        Random rand = new Random();
        bcX = rand.nextInt(300);
        bcY = rand.nextInt(300);
    }

    
    public void mouseClicked(MouseEvent arg0) {
        mcX = arg0.getLocationOnScreen().x;
        mcY = arg0.getLocationOnScreen().y;
        System.out.println("mouse (" + mcX + "," + mcY + ")");
        if (mcX < bcX + 80 && mcX > bcX && mcY < bcY + 80 && mcY > bcY ){
                points++;
        }
        
    }
    public void run() {
		JOptionPane.showMessageDialog(null, "Welcome to Whack A Mole, click the red dots as they appear.... good luck");
        for (int i = 0; i < 25; i++){
        g = frame.getContentPane().getGraphics();
        g.setColor(Color.RED);
        randomize();
        System.out.println("ball(" + bcX + "," + bcY + ")");
        g.fillOval(bcX, bcY, 40, 40);
        try {
            Thread.sleep(1000);
            g.setColor(Color.WHITE);
            g.fillOval(bcX, bcY, 40, 40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        JOptionPane.showMessageDialog(null, "YOU HAD " + points + " points");
      	
        
    }
    
    public static void main(String[] args){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        c = frame.getContentPane();
        c.setBackground(Color.white);
        frame.setVisible(true);
        Frame game = new Frame();
        game.thread = new Thread(game);
        game.thread.start();
        frame.addMouseListener(game);
    }
}