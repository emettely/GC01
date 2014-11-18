package filehandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Exercise 5.3: File Handling*
//Create a blogging application with a GUI that enables you to generate the blog entries, with time and 
//date, and stores it into a HTML file.

//When the program runs, it should check if the file exists, hence, show the last blog written by the 
//user, and show the current file before enabling you to make new entries.



public class Handlefile {

	public Handlefile(String title, String input, String time) {
		// TODO Auto-generated method stub

		try{

			FileWriter filewrite = new FileWriter("Blog.html");
			BufferedWriter writer = new BufferedWriter(filewrite);
			writer.write(title + "\n" + input + "\n" + time);
			writer.close();


		} catch (IOException ex) {
			System.out.println("Couldn't write blog!");
			ex.printStackTrace();
		}

	}

	public void Readfile (){

		try{
			File preFile = new File("Blog.html");
			FileReader filereader = new FileReader(preFile);
			BufferedReader reader = new BufferedReader(filereader);

			String line = null;

			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();



		} catch (IOException ex) {
			System.out.println("Couldn't write blog!");
			ex.printStackTrace();
		}

	}

}
