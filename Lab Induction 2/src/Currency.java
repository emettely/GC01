/* 2. Write a currency program that enables you to
 * put in a value and based on different rates shows several currency at the same time.
 * Yen USD GBP EUR
 */
import java.util.Scanner;
/*1. try writing a conversion program that has a class with several methods to convert between a number of different measurements.
Metres, yards, inches, cm, astronomical unit*/

public class Currency {

	public static void main(String[] args) {

		Scanner read = new Scanner (System.in);
		//tell what class it is
		double Conv2GBP = 0;
		
// {} = definition
// [] = define size

		String [] currency = {"GBP", "Yen", "Dollar", "Euro"};
		double [] rate = new double [] {1, 177.80, 1.63, 1.28};
		double [] result = new double [4];
		
		//print out
		System.out.println("What is the number?");

		//read with Scanner, prompt input
		double input = read.nextDouble();   //access function
		read.nextLine();



		//store unit
		System.out.println("What is the unit? (Pick from GBP, Yen, Dollar, Euro)");
		String unit = read.nextLine();
		
		//convert input to GBP using unit
		//storing answers here in main
		if (unit.equals(currency[0])) {
			Conv2GBP = input;
		} else if (unit.equals(currency[1])) {
			Conv2GBP = convertytg(input, rate);
		} else if (unit.equals(currency[2])) {
			Conv2GBP = convertdtg(input, rate);
		} else if (unit.equals(currency[3])) {
			Conv2GBP = convertetg(input, rate);
		}


		//store into arrays
		result [0] = Conv2GBP;
		result [1] = convertgty(Conv2GBP, rate);
		result [2] = convertgtd(Conv2GBP, rate);
		result [3] = convertgte(Conv2GBP, rate);
		// pass numbers so they can be used in the same line
		for (int i = 0; i <= 3; i++){
		//print out everything except for original input
			if (unit != currency[i]) {
				System.out.printf( "\n" + currency[i] + " " + "%.2f", result[i]);
			}
		}
		
		

	}// end main
	
	
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
	
	
	//from GBP to whatever units
	
	
	public static double convertgty(double gbp, double rate[]){
		double yen = gbp*rate[1];
		return yen;
	}
	public static double convertgtd(double gbp, double rate[]){
		double dollar = gbp*rate[2];
		return dollar;
	}
	public static double convertgte(double gbp, double rate[]){
		double euro = gbp*rate[3];
		return euro;
	}

	
} // end class

