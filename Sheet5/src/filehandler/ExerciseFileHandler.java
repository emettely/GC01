package filehandler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseFileHandler extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField title;
	private JLabel currentTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseFileHandler frame = new ExerciseFileHandler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// ==============end main================

	/**
	 * Create the frame.
	 */
	public ExerciseFileHandler() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// =============time=============
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat timeDisplay = new SimpleDateFormat("dd/MM/yyyy" +" " + "HH:mm");
		final String strrn = timeDisplay.format(rightNow.getTime());
		contentPane.setLayout(null);
		currentTime = new JLabel();
		currentTime.setBounds(234, 12, 118, 16);
		contentPane.add(currentTime);
		currentTime.setText(strrn);
		//============end time=============

		// ===========entry field================
		title = new JTextField();
		title.setBounds(9, 6, 213, 28);
		contentPane.add(title);
		title.setText("Title");
		title.setColumns(10);

		textField = new JTextField();
		textField.setBounds(9, 40, 343, 226);
		contentPane.add(textField);
		textField.setColumns(10);
		// ==========end field============

		JButton submit = new JButton("submit");
		submit.setBounds(356, 140, 88, 29);
		submit.addActionListener(new ActionListener(){

			//========action==========
			public void actionPerformed(ActionEvent save) {
				String inputTitle = title.getText();
				String inputText = textField.getText();
				String inputTime = strrn;
				
				Handlefile saveasHTML = new Handlefile(inputTitle, inputText, inputTime);
				saveasHTML.Readfile();
				




			} //=========close actionevent=========
		});//=========end Action listener==========

		contentPane.add(submit);
	}//=========end exhandler=========


}// ==========end class===========

