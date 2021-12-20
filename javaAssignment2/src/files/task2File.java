package files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
 

public class task2File {

	public static void main(String[] args) {
		try {
		 String path = "C:\\JavaLearnings\\javaAssignment2\\src\\files\\RishavFile.txt";
		    
	     Integer lines;
		 String s = Files.readString(Paths.get(path));
	     Path file  = Paths.get("C:\\\\JavaLearnings\\\\javaAssignment2\\\\src\\\\files\\\\RishavFile.txt");
	     long count = Files.lines(file).count();
	     
		 
		 System.out.println(s);
		 
		 System.out.println("total Lines in file are: " + count);
		}
		catch (IOException e){
			e.printStackTrace();
		}
 	}
}
