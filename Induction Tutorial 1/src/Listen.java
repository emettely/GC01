import java.util.Scanner;


public class Listen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner small = new Scanner (System.in);
		/*Scanner - class is like creating a building/ blue print...
		name is house, new thing is a new object whatever is in the bracket is the difference*/
		System.out.println("What is your name?");
		
		//save user's input in a String variable called 'name'
		String name = small.nextLine();
		
		System.out.println("What is your last name?");
		
		String name1 = small.nextLine();
		//print welcome message on screen including the saved input
		System.out.println("Hello! I thought that your name might be "+ name + " " + name1 +"!");
		

	}

}
