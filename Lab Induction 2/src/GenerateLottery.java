/*
Exercise: modify this code to become a method,
with a for loop to make it produce the 6 winning lottery numbers
this week.

*/
import java.util.Random;

public class GenerateLottery {
	public static void main(String[] args) {
	Random aRandom = new Random();
	sixTimes(aRandom);  //passed object handle
	}
	
	public static void sixTimes(Random aRandom){
		//print a random number between 1 and 49 
		System.out.println("Lottery Numbers");
		boolean failTest = true;
		int [] temp = new int [6];   //array declarations
		temp[0] = aRandom.nextInt(49) + 1;
		
		for (int i = 1; i < 6; i++){
			temp[i] = aRandom.nextInt(49) + 1;
			while (failTest == true){
				for (int j = 0; j < i; j++){
					if (temp[i] == temp[j]){
						temp[i] = aRandom.nextInt(49) + 1; // try a new number because it already exists
            j = 0; // check from the beginning
					}
				}
					failTest = false; // set false to exit the while loop, no numbers are duplicates
			}
      failTest = true; // reset so that while loop checks again for duplicates
		}
    // print the 6 lottery numbers, no of which are duplicates
		for (int i = 0; i < 6; i++){
			System.out.println(temp[i]);
		}
	}
}
