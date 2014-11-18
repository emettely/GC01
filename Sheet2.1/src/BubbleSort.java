import java.util.Scanner;

//Psuedocode
//1. Compare A[0] and A[1] .
//2. If A[0]>A[1] then Swap A[0] and A[1].
//3. Take next A[1] and A[2].
//4. Compare these values.
//5. If A[1]>A[2] then swap A[1] and A[2].
//1. Keep going for all
//2. Finally compare A[n-1] and A[n].
//3. Now repeat all over again, until no swaps happen.


//You will need to make use of nested for-loop.
//Write you bubblesort algorithm as a separate method from the main (why?).
//Test your input with two sets of input you initialise when declaring your array.
//1. A = {84, 69, 76, 86, 94, 91};
//2. A = {65, 0, -24, -58, 124, 0, 35};


public class BubbleSort {

	public static void bubbleSort (int [] numbers){ // for swap [i]
		int smaller;
		for (int i = 0; i < numbers.length; i++){ // go through all the array
			for (int j = 0; j < numbers.length - 1; j++){ // go through all the values without out of bounds
				if (numbers[j] > numbers[j + 1]){ // if the initial value is bigger than next value,
					smaller = numbers[j + 1]; // store smallest value
					numbers [j + 1] = numbers [i]; // moves bigger value to next index
					numbers[i] = smaller;
				}
			}
		}
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
	}

	public static void main (String[]args){

		System.out.println("what do you want to sort?");
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String[] numbers = line.split(", "); //{84, 69, 76, 86, 94, 91}
		int [] n = new int [numbers.length]; //n array length is the same as many splits
		for (int i = 0; i < numbers.length; i++){ // go through all indexes and
			n[i] = Integer.parseInt(numbers[i]); //convert string to numbers
		}

		bubbleSort(n);

	}	
}
