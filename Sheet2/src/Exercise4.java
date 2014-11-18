import java.util.Scanner;


public class Exercise4 {
/*
 * 
 */
	public static void main(String[]args) {
		
	final String [] UNITS = {"B", "KB", "MB", "GB"};
	
	//final makes a variable unchangeable
	Scanner read = new Scanner(System.in);

	System.out.println("Input Bytes");
	double input = read.nextDouble();
	
	
	//loop through divide by 1024 each time
			
	
	for (int i = 0; i < 4; i++){
		double number = input;
		number = number/(Math.pow(1024, i));
		System.out.println(number + UNITS[i]);
		
		
	}
	
	//byte divide by 5 and with modulo
	//So for every iteration you need to keep track of the current size in the
	//current unit and the remainder, which you will use to calculate the decimal
	//place.
	/*
	 * http://stackoverflow.com/questions/13539871/converting-kb-to-mb-gb-tb-dynamicaly
	 * public String size(int size){
	 * String hrSize = "";
     * int k = size;
     * double m = size/1024;
     * double g = size/1048576;
     * double t = size/1073741824;
     * 
     * DecimalFormat dec = new DecimalFormat("0.00");
     * if (k>0) {
     * hrSize = dec.format(k).concat("KB");
     * }
     * if (m>0) {
     * hrSize = dec.format(m).concat("MB");
     * }
     * if (g>0) {
     * hrSize = dec.format(g).concat("GB");
     * }
     * if (t>0)
     * hrSize = dec.format(t).concat("TB");
     * return hrSize;
     * }
	 */
	}
	
}