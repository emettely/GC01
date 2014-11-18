package exercise5_5;

/*
 * Write a focuslistener that as you enter any jComponent (jbutton or jlabel etc)
 * it will update a jLabel with a message.
 */
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Three {


	public static void main(String[] a) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField textField = new JTextField("Which one are you going to talk to??");
		final JLabel label = new JLabel();
		textField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				label.setText("Hey it's me!");
			}

			public void focusLost(FocusEvent e) {
				label.setText("Over HERE!");
			}


		});

		frame.add(textField,"North");
		frame.add(label,"Center");
		frame.add(new JTextField(),"South");
		frame.setSize(300, 200);
		frame.setVisible(true);
	}


}
