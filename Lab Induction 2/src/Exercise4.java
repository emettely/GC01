import java.util.Scanner;

/*
 * Lab exercise – nested for loop and methods
4. Website designers use tables when formatting HTML layout.

	•Write a program that takes two values from keyboard via main,
	and passes it to a method that outputs respective HTML table.
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 * trs rows
 * td - columns
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
 */
public class Exercise4 {
	public static void main(String[]args){
		
		Scanner read = new Scanner (System.in);
		
		
		 System.out.println("What is the number of rows?");
		 int rows = read.nextInt();
		  
		 System.out.println("What is the number of columns?");
		 int cols = read.nextInt();
		 
		 //one loop deals with tr = columns, the other with td =
		 System.out.println("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		 
		 for (int i = 0; i < rows; i++){
			 System.out.println("<tr>");
			 for (int j = 0; j < cols; j++){
				 System.out.println("<td>&nbsp;</td>");
			 }
			 System.out.println("</tr>");
		 }
		 System.out.println("</table>");
		 


	}

}
