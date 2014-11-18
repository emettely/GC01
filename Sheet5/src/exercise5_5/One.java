package exercise5_5;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class One extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea right;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					One frame = new One();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public One() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textField = new JTextField();
		contentPane.add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		//textField.getDocument().addDocumentListener(new listen());
		//textField.getDocument().putProperty("name", "Text Field");
		
		textField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

				right.setText(textField.getText());
				/*try {
					FileWriter filewriter = new FileWriter("test.txt");
					BufferedWriter writer = new BufferedWriter(filewriter);
					writer.write(test);
					writer.close();

				} catch (IOException ex) {
					System.out.println("error of writing");
				}

				try {
					FileReader filereader = new FileReader("test.txt");
					BufferedReader reader = new BufferedReader(filereader);



					String line = null;


					while((line = reader.readLine()) != null){
						System.out.println(line);

					}
					reader.close();


				} catch (IOException ex) {
					System.out.println("error of reading");
				}*/

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub



			}


		});
		
		right = new JTextArea();
		contentPane.add(right, BorderLayout.CENTER);
		
		
		//getDocument().addDocumentListener(new listen());
		//right.getDocument().putProperty("name", "Text Area");
		
		}
		
//
//			@Override
//			public void keyTyped(KeyEvent ke) {
//				// TODO Auto-generated method stub
//
//
//
//				try {
//					FileReader filereader = new FileReader("test.txt");
//					BufferedReader reader = new BufferedReader(filereader);
//
//					String line = null;
//
//					while((line = reader.readLine()) != null){
//						//???????????????????????
//						String test = textField.getText();
//						JLabel right = new JLabel(setText(test));
//						//
//					}
//					reader.close();
//
//
//				} catch (IOException ex) {
//					System.out.println("error of reading");
//				}
//
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub




//			}
//
//
//		});


}
