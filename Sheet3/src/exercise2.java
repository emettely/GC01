//import java.util.ArrayList;
public class exercise2 {

	public static void remElement(String [] arr, String [] newArr, int r){		
		for (int i=0; i<arr.length; i++){
			if(i > r){ // avoid changing the increment of the loop
				newArr[i-1] = arr[i];
			} else {
				newArr[i] = arr[i];
			}
		}
	}//end remElement

	public static void main(String[]args){
		//		ArrayList phrase = new ArrayList();
		//copy r+1 to r
		String[]arr = {"The ", "quick ", "brown ", "fox ", "jumps ",
				"over ","the ", "lazy ", "dog."};
		int r = 3;
		String[] newArr = new String[arr.length-1];

		remElement(arr, newArr, r);
		for (int i=0; i<newArr.length; i++){
			System.out.print(newArr[i]);
			//System.out.print(i);
		}

	}//end main

} // end class
