import java.util.Scanner;


public class Exercise3 {

	/**
	 * 1. Loop trough the array and assign a number to each element.
	 * Let the first element numbers[0] = 1;.
	 * Then, each subsequent element i should be double the previous element i-1.
	 */
	public static void main(String[] args) {
		// size of array
		
		float numbers [] = new float [20];
		numbers [0] = 1;
		double [] mean = new double [20];
		mean [0] = numbers [0];
		mean [8] = numbers [8];
		
		System.out.println("give me a number!");
		Scanner read = new Scanner (System.in);
		int input = read.nextInt();

			for (int i = 1; i < 8; i++){
			numbers [i] = 2*(numbers[i-1]);
			//System.out.println(numbers[i]);
			}
		
			for (int i = 1; i < 8; i++){
			mean[i] = (numbers[i+1]+numbers[i-1])/2;
			//System.out.println(mean[i]);
			}
		
		System.out.println(numbers[input]);
		System.out.println(mean[input]);
			
	}
	/*
	 * create another array that stores mean values of neighboring elements in
	 numbers. That is the element with index i in array means should contain
	the mean of i-1 and i+1 from numbers. At the edges (the First and the
	last elements) just store the first and the last elements of the previous
	array.
	 */

}
