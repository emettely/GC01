package exercise5_5;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Four {

	private JFrame frame;
	private JLabel label;
	private static int framex;
	private static int framey;
	private int mousepressX;
	private int mousepressY;
	private int radioPressX;
	private int radioPressY;
	private String obj = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Four window = new Four();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Four() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JButton button = new JButton("Drag this button");
		button.setPreferredSize(new Dimension(50,50));


		button.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int x = button.getLocation().x;
				int y = button.getLocation().y;

				button.setLocation(x+e.getX()-mousepressX, y+e.getY()-mousepressY);
				
				String obj = "button";
				JLabel lblOutput = new JLabel("OUTPUT:" + obj);
				frame.getContentPane().add(lblOutput, BorderLayout.SOUTH);
				
				System.out.println(obj);


			}
		});
		
		frame.getContentPane().add(button, BorderLayout.EAST);
		
		

		
		final JLabel label = new JLabel("Drag this label");
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int labelx= label.getLocation().x+e.getX()-mousepressX;
				int labely= label.getLocation().y+e.getY()-mousepressY;
				label.setLocation(labelx, labely);	
				System.out.println("co-ordinates of the movement:"+ ""+labelx+""+labely);
				
				String obj = "label";
				JLabel lblOutput = new JLabel("OUTPUT:" + obj);
				frame.getContentPane().add(lblOutput, BorderLayout.SOUTH);
				System.out.println(obj);

			}
		});
		
		label.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent em){
				mousepressX= em.getX();
				mousepressY= em.getY();
			}
			
		});
		
		frame.getContentPane().add(label, BorderLayout.WEST);
//		JLabel lblOutput = new JLabel("OUTPUT:" + obj);
//		frame.getContentPane().add(lblOutput, BorderLayout.SOUTH);
	}

	
	private void setobj(String obj){
		this.obj=obj;
	}

}
