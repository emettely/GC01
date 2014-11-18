import java.awt.SystemTray;
import java.util.Scanner;


public class Exercise2 {

	/**
	 * @param args
	 *subtract() multiply() divide()
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Simple calculator. Please choose an operation:");
		System.out.println("\n" + "1. Add" + "\n" + "2. Substract" + "\n" + "3. Multiply"  + "\n" + "4. Divide" + "\n" + "5. Factorial" + "\n" + "6. Exit");
	/*Now take an input from the user, and if a number 1–4 is given ask the
	user to input two numbers and call appropriate function with them as
	arguments. Then display the result and finish the program.
	*/
		Scanner read = new Scanner(System.in);
		int ope = 0;
		double first = 0;
		double second =0;
		double answer = 0;
		long factnum = 0;
		ope = read.nextInt();
		
		
		if (ope == 5) {
			System.out.println("What is the number?");
			factnum = read.nextLong();
			answer = factorial(factnum);
		} else if (ope != 6) {
			
			//read input and store
			System.out.println("First number:");
			first = read.nextInt();
			System.out.println("Second number:");
			second = read.nextInt();
			
			if (ope == 1) {
				answer = add(first,second);
			} else if (ope == 2) {
				answer = subtract(first, second);
			} else if (ope == 3) {
				answer = multiply(first, second);
			} else if (ope == 4) {
				answer = divide(first, second);
			}

			System.out.println(answer);
		}
			
	
			
		
		if (ope == 6){
		System.exit(0);
		}
		
		/*
		 * 5. calculating a factorial of a number.
		 * There is more than one way of writing this,
		 * but we will use recursion.
		 * Try find materials online that explain what recursion is.
		 * Hint: In order to understand recursion,
		 * one must first understand recursion. famous quote, unknown author?
		 */
	}
	public static double add(double first, double second){
		double answer = first + second;
		return answer;
	}
	public static double subtract(double first, double second){
		double answer = first - second;
		return answer;
	}
	
	public static double multiply(double first, double second){
		double answer = first * second;
		return answer;
	}
	
	public static double divide(double first, double second){
		double answer = first / second;
		return answer;
	}
	
	public static double factorial(long factnum){
		//this needs to loop
		long store =1;
		while (factnum > 0){
			
			store = store*factnum;
			factnum--;
		}
		System.out.println(store);
		return store;
	}
	
	

}
