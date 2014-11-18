import java.util.Arrays;


public class HelloWorld {


	//constant static and final
	//private means access limited: good practice to have
	//methods should be public
	
	//variables declared in class are called class variables
	
	private static int h = 0;


	public HelloWorld() {
		int h = 18;
		}

	//this is associated to class - implicit parameters.

	public int setter(int x){
		h = x;
		return h;
	}
	
	
	
	public int getter(){
		return this.h;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		int a = 2;
		double b = 2.0;
		boolean c = a==b;
		System.out.println(c);
		int [] annoy = {23,23,23,23,23};
		int [] what = new int [5];
		
		System.out.println(Arrays.toString(annoy));
		
		switch (a){
		case 1: System.out.println(a); break;
		case 2: System.out.println(b); break;
		default: System.out.println("leave"); break;
		}
		
		//strings or enum or int are allowed in switch cases.
//		switch (b){
//		case 1: System.out.println(); break;
//		}
		
		
		

	}

}
