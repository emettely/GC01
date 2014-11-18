package exercise5_5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

/*
 * Write a mouselistener (and mousemotionlistener) for making parts of a GUI clickable
 * and then draggable, e.g. with Jbuttons, Jlabels (with ImageIcons), JRadioButtons, JComboBoxes.
 * Output coordinates of the movement and name of each selected item on a Jlabel at the bottom of the Jframe.
 */
public class Fourtest extends JFrame implements MouseMotionListener, MouseListener {
	private JButton buttons = new JButton();
	private JLabel label = new JLabel();
	private JRadioButton radio = new JRadioButton();
	private JComboBox box = new JComboBox();
	private ImageIcon image = new ImageIcon();

	private volatile int draggedAtX, draggedAtY;




	public void initialise(){
		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);


		final JButton buttons = new JButton("Hi");

		buttons.setPreferredSize(new Dimension(30,30));
		buttons.addMouseListener(this);
		buttons.addMouseMotionListener(this);
		frame.getContentPane().add(buttons,"Center");

		final JLabel label = new JLabel("Drag this label");
		label.addMouseMotionListener(this);
		label.addMouseListener(this);
		frame.getContentPane().add(label,"East");


		JLabel lblOutput = new JLabel("OUTPUT:" + this);
		getContentPane().add(lblOutput, BorderLayout.SOUTH);



		setVisible(true);
	}


	public static void main (String [] args){
		Fourtest run = new Fourtest();
		run.initialise();
	}



	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println(e);




	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		draggedAtX = e.getX();
		draggedAtY = e.getY();
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int labelx= label.getLocation().x+e.getX()-draggedAtX;
		int labely= label.getLocation().y+e.getY()-draggedAtY;
		label.setLocation(labelx, labely);	
		System.out.println("co-ordinates of the movement:"+ ""+labelx+""+labely);

	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
