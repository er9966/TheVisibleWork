// Justina Gao && Joia Zhang
// CSE 143 Final Project

// This is the interactive main method :)
import java.io.*;
import java.util.*;
public class linkExtractorMain {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      System.out.println("Welcome to the link extractor!");
      System.out.println("Please enter the html source code file you would like to extract: ");
      System.out.println("(If you're not sure, try enter 'DiversitySourceCode.txt') ");
      String inputFile = console.next();
      File f = new File(inputFile);
      if (!f.exists()) {
         System.out.println("The file doesn't exist! ");
      } else {
         System.out.println("Enter the keywords you wish to see in the links (seperated by space) ");
         System.out.println("(If you're not sure, try enter 'diversity edu') ");
         String keywords = console.next();
         String[] wordFilter = keywords.split("\\s+");
         linkExtractor a = new linkExtractor(new Scanner(f), wordFilter);
         a.export();
         a.print(); 
      }
      System.out.println("Done!");


    }
}
