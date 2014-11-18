/*
Exercise: modify this code to become a method,
with a for loop to make it produce the 6 winning lottery numbers
this week.

*/
import java.util.Random;

public class GenerateLotteryfail {
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
			boolean flag = false;
			temp[i] = aRandom.nextInt(49) + 1;
			System.out.println("TEMP" + temp[i]);
			while (failTest == true){
				for (int j = 0; j < i; j++){
					if (temp[i] == temp[j]){
						temp[i] = aRandom.nextInt(49) + 1; //change
						flag = true;
						System.out.println("LOOP");
					}
				}
				if (!flag){
					failTest = false;
				}
			}
		}
		for (int i = 0; i < 6; i++){
			System.out.println(temp[i]);
		}
	}
}
