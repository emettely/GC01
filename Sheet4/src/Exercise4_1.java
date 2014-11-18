import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class Exercise4_1 {





	public static void main(String[]args){
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> oddNum = new ArrayList<Integer>();
		Random rand = new Random();
		int sum = 0;


		//		Create an ArrayList aList to store 100 random integer values (range 0-10).
		
		for (int i=0; i<100; i++){
			int randomNum = rand.nextInt(11);
			aList.add(randomNum);
		}
		System.out.println(aList);
		
		//		Take all the even numbers in aList and calculate the sum of the numbers.
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i) % 2 == 0) {
				sum = sum + aList.get(i);
			}
		}
		System.out.println(sum);

		//		Remove all the odd elements in aList. Add them back to the end of the List.
		for (Iterator<Integer> iterator = aList.iterator(); iterator.hasNext();) {
			Integer number = iterator.next();
			if (number % 2 == 1) {
				oddNum.add(number);
				iterator.remove();
			}

		}
		System.out.println(aList);
		aList.addAll(oddNum);
		System.out.println(aList);
		int[] newArray = new int[aList.size()];
		
		//		Create an Array of integers out of the new aList.
		for (int i = 0; i < aList.size(); i++){
			//newArray = new int[aList.size()];
			newArray[i] = aList.get(i);
			//System.out.println((newArray[i]));
		}
		System.out.print(Arrays.toString(newArray));

		
//		Integer[]numbers = (Integer[]) aList.toArray();

	}




	//		Use Arrays.toString to print out the values of the array.


}

