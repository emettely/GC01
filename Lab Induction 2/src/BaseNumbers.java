import java.util.Scanner;





public class BaseNumbers {
	
    public static void main(String a[]){
        Scanner read = new Scanner (System.in);
        System.out.println("Enter a base 10 number:");
        int inputd = read.nextInt();
        System.out.println("Enter a base number:");
        int base = read.nextInt();
        baseConvert(inputd,base);
    }
    //call functions, variables within are temporary
    
    public static void baseConvert(int number, int nb){
        int index = 0;
        int cellcount = 0;
        int temp = number;
        while(temp > 0){
            index = temp%nb; // assignmentOperator error, needs to store value
            temp = temp/nb;
            cellcount++;
        }
    	int binary[] = new int[cellcount];
    	
    	index = 0;//reset value of index
    	
        while(number > 0){
            binary[index++] = number%nb;
            number = number/nb;
        }
        System.out.println("Your number in base " + nb + ":");
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }
 
}