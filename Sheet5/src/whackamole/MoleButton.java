package whackamole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MoleButton extends JButton implements ActionListener {


	private ImageIcon Hole, Mole;
	private byte value = 0;
	private static int score = 0;
	
	
	public ImageIcon getMole(){
		return Mole;
	}

	
	
	
	public MoleButton(){

		Mole = new ImageIcon(this.getClass().getResource("mole.jpg"));
		rescaleImage(Mole);
		
		this.addActionListener(this);
	}


	
	//when action occurs while drawing is a mole, increment score
	public void actionPerformed(ActionEvent e){
		while(value==1){
			score++;
		}
	}
	
	public static int getScore(){
		return score;
	}

	public void rescaleImage(ImageIcon test){

		int scale = 5; // 5 times smaller
		int width = test.getIconWidth();
		int newWidth = width / scale;
		setIcon(new ImageIcon(test.getImage().getScaledInstance
				(newWidth, -1, java.awt.Image.SCALE_SMOOTH)));

	}


}
