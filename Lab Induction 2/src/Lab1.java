import java.util.Scanner;
/*1. try writing a conversion program that has a class with several methods to convert between a number of different measurements.
Metres, yards, inches, cm, astronomical unit*/

public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read = new Scanner (System.in);
		//tell what class it is
		double Conv2Miles = 0;
		double answer = 0;
		
		System.out.println("What is the number?");
		//read with Scanner, prompt input
		double input = read.nextDouble();//access function
		read.nextLine();
		//store unit
		System.out.println("What is the unit?");
		String unit = read.nextLine();
		
		//store new value
		System.out.println("What do you want to convert it to?");
		String output = read.nextLine();
		
		
		
		// WHY DOES THIS: if (unit=="km") NOT WORK???
		if ("km".equals(unit)){
			Conv2Miles = convertktm(input);
		} else if ("in".equals(unit)) {
			Conv2Miles = convertitm(input);
	    } else if ("yards".equals(unit)) {
	    	Conv2Miles = convertytm(input);
	    } else if ("cm".equals(unit)) {
	    	Conv2Miles = convertctm(input);
	    } else if ("au".equals(unit)) {
	    	Conv2Miles = convertatm(input);
	    } else if ("miles".equals(unit)){
	    	Conv2Miles = input;
	    }
		
		
		//System.out.printf("%.6f", Conv2Miles);
		if ("km".equals(output)){
			answer = convertmtk(Conv2Miles);
		} else if ("in".equals(output)) {
			answer = convertmti(Conv2Miles);
	    } else if ("yards".equals(output)) {
	    	answer = convertmty(Conv2Miles);
	    } else if ("cm".equals(output)) {
	    	answer = convertmtc(Conv2Miles);
	    } else if ("au".equals(output)) {
	    	answer = convertmta(Conv2Miles);
	    } else if ("miles".equals(output)) {
	    	answer = Conv2Miles;
	    }
		System.out.printf("%.10f", answer);
		System.out.print(" " + output);
		
	} // end main
	
	
	//miles from everything else
	
	public static double convertktm(double km){
		double miles = km*1.61;
		return miles;
	}
	public static double convertytm(double yards){
		double miles = yards/1760;
		return miles;
	}
	public static double convertitm(double in){
		double miles = in/63360;
		return miles;
	}
	public static double convertatm(double au){
		double miles = au*92955807.3;
		return miles;
	}
	public static double convertctm (double cm){
		double miles = cm/(6.2137 * Math.pow(10, -6));
		return miles;
	}
	
	
	//from miles to whatever units
	
	
	public static double convertmtk(double miles){
		double km = miles*1.6;
		return km;
	}
	public static double convertmty(double miles){
		double yards = miles*1760;
		return yards;
	}
	public static double convertmti(double miles){
		double in = miles*63360;
		return in;
	}
	public static double convertmta(double miles){
		double au = miles/92955807.3;
		return au;
	}
	public static double convertmtc(double miles){
		double cm = miles*(6.2137 * Math.pow(10,-6));
		return cm;
	}
	
} // end class

	
