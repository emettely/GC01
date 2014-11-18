package currency;


public class CurrencyConverter {
	
//    private String className;
    private double classRate;
	private double classCTGBP;

	public CurrencyConverter (double rate, double conv2gbp) {

//		String className = name;
		double classRate = rate;
		double classCTGBP = conv2gbp;

		System.out.println("Constructor");
		System.out.println("Inside constructor " + classCTGBP +"\t"+ classRate);
	}

	public double convert (double classCTGBP, double classRate) {
		double result = classCTGBP*classRate;
		System.out.println("result is : " + result);
		System.out.println("divide " + classCTGBP + "\t" + classRate);
		return result;
	}

	

} // end class

