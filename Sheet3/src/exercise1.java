import java.util.Scanner;


public class exercise1 {
	
	public static boolean isEven (int number){
		boolean isEven = (number % 2 == 0) ? true : false; // inlined syntax
		return isEven;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("is number even?");
		int read = input.nextInt();
		if(isEven(read)){
			System.out.println("even");
		}else{
			System.out.println("not even");
		}
		
	}

}
