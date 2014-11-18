package exercise5_5;


//Write an itemlistener for a JComboBox with several items.
//You can simply output the text to a jOptionPane messagebox to say it was selected.
//Note that jComboBoxes have indices, as
//they are array-like in holding data together
//(so first value is at myjComboInstance.getSelectedIndex(0); )
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Two extends JFrame {

	private JComboBox comboBox;
	private JOptionPane messagebox;
	private JFrame frame;
	private JPanel contentPane;
	private String[] whatEver = {"Himalayas", "In the wild", "Ilpoyo", "Grilllllllit"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Two running = new Two();
		running.go();
	}

	public void go(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		final JComboBox comboBox = new JComboBox(whatEver);
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null){

					String contents = comboBox.getSelectedItem().toString();
					System.out.println(contents);
					messagebox.showMessageDialog(null, contents);
					
				}
	

			}

		});
		contentPane.add(comboBox, BorderLayout.CENTER);


		setVisible(true);

	}

}
