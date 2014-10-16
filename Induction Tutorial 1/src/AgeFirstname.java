import java.util.Scanner;


public class AgeFirstname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//read age
		System.out.println("What is your age?");
		Scanner inputage = new Scanner(System.in);
		
		//change string to integer
		String age = inputage.nextLine();
		int age1 = Integer.parseInt(age);
		
		//read name
		System.out.println("What is your name?");
		String name = inputage.nextLine();
		
		if (age1 < 15){
		
		//while age is bigger than 0, print one and increment
		while (age1 > 0){
			age1--;
			System.out.println(name);
			}
		} else {
			//store name length in len
			int len = name.length();
			//store name length as arrays in alpha
			char[] th = new char[len];
			int ar = 0;
			//LOOP! new integer value alpha is last letter of name
			//until i is to 0 (first letter) count down
			for(int i = len - 1; i >= 0; i--){
				//count up and store characters in name from last to beginning using i
				th[ar++] = name.charAt(i);
			}
			System.out.println(th);
			}
			
	}
}