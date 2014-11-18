import java.text.DecimalFormat;
import java.util.Scanner;

//Write a method that let the user to input a number (integer)
//your program will test whether or not the integer value is a prime number or not.
//check if the user has input an integer, if not, give out some warning and round the number to the nearest integer.
//write the method to test the prime number (isPrime) as a separate method from the main, and the method should return a boolean value
//Hints:
//o a prime number is one that has no exact divisors except for 1 and the number itself
//o 0 and 1 are not treated as prime
//o Use a for-loop to test the remainder of all the numbers in between.
public class PrimeInt {

	public static boolean isPrime(double number){
		if (number <= 1){
			return false;
		} else {
			for (int i = 2; i<number-1;i++){
				if (number%i == 0){
					return false;
				}
			}
		}
		return true;
	}

	public static void main (String[]args){
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###");



		System.out.println("input number");
		double number = input.nextDouble();
		try {
			if (number < 2);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Please put a valid number.");
			
		}

		boolean isValid = isPrime(number); 
		if (isValid == false){
			System.out.println(df.format(number)+" is not a prime number!");
		}else{
			System.out.println(df.format(number)+" is a prime number");
		}

	}


}
