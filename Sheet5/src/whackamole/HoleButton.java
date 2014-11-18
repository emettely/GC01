package whackamole;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class HoleButton extends JButton{
	
	private ImageIcon Hole, Mole;
	private byte value = 0;
	private int next1 = 0;
	private int next2 = 0;
	

	public HoleButton(){
		Hole = new ImageIcon(this.getClass().getResource("hole.png"));
		rescaleImage(Hole);
	
	}


	// when action occurs while drawing is a mole, increment score
//	public void actionPerformed(ActionEvent e){
//		while(value==1){
//			score++;
//		}
//	}

	public void rescaleImage(ImageIcon test){

		int scale = 6; // 6 times smaller
		int width = test.getIconWidth();
		int newWidth = width / scale;
		setIcon(new ImageIcon(test.getImage().getScaledInstance
				(newWidth, -1, java.awt.Image.SCALE_SMOOTH)));

	}
	
//


}
