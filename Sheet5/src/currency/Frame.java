package currency;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField fromInput;
	private JTextField toInput;
	final static String [] currencyMenu = new String [] {"GBP", "JPY", "USD", "EUR"};
	final static double [] rate = new double [] {1, 177.80, 1.63, 1.28};


	//	private final Action action = new SwingAction();

	/**
	 * Create the frame.
	 */
	public Frame() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("133px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("134px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("133px"),},
				new RowSpec[] {
				RowSpec.decode("21px"),
				RowSpec.decode("236px"),}));

		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		contentPane.add(lblCurrencyConverter, "2, 1, fill, fill");

		JSplitPane inputSplit = new JSplitPane();
		inputSplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(inputSplit, "2, 2, fill, center");

		fromInput = new JTextField();
		fromInput.setText("Amount of money");
		inputSplit.setLeftComponent(fromInput);
		fromInput.setColumns(10);

		toInput = new JTextField();
		inputSplit.setRightComponent(toInput);
		toInput.setColumns(10);

		JSplitPane convertMenu = new JSplitPane();
		convertMenu.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(convertMenu, "4, 2, fill, center");


		final JComboBox toCurrency = new JComboBox();
		toCurrency.setModel(new DefaultComboBoxModel(currencyMenu));
		convertMenu.setRightComponent(toCurrency);

		final JComboBox fromCurrency = new JComboBox();
		fromCurrency.setModel(new DefaultComboBoxModel(currencyMenu));
		convertMenu.setLeftComponent(fromCurrency);

		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {

			// ======== action =========

			public void actionPerformed(ActionEvent e) {
				double input = Double.parseDouble(fromInput.getText());
				int fromIndex = fromCurrency.getSelectedIndex();
				int toIndex = toCurrency.getSelectedIndex();
				double Conv2GBP = 0;


				//====if unit name is equal to no. then rate to convert to GBP is stored here=====

				switch (fromIndex){
				case 0: Conv2GBP = input;
				break;
				case 1: Conv2GBP = convertytg(input, rate); // knows which rate to use
				break;
				case 2: Conv2GBP = convertdtg(input, rate);
				break;
				case 3: Conv2GBP = convertetg(input, rate);
				break;
				}

				System.out.println("what case? input, ft,Conv2   " +"    " + input + "   " + fromIndex +"   " + Conv2GBP + rate);

				//passing on information to use in CurrencyConverter in other java

					CurrencyConverter end = new CurrencyConverter(rate[toIndex], Conv2GBP);
					
					double fin = end.convert(Conv2GBP, rate[toIndex]);
					System.out.println(fin);
					
					
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					df.format(fin);
					
					String strfin = Double.toString(fin);
					toInput.setText(strfin);
					


			}
		});
		contentPane.add(btnConvert, "6, 2");

	}

	//GBP from everything else

	public static double convertytg(double yen, double rate[]){
		double gbp = yen/rate[1];
		return gbp;
	}
	public static double convertdtg(double dollar, double rate[]){
		double gbp = dollar/rate[2];
		return gbp;
	}
	public static double convertetg(double euro, double rate[]){
		double gbp = euro/rate[3];
		return gbp;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});



	}
}
