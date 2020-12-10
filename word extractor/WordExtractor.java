// Justina Gao && Joia Zhang
// CSE 143 Final Project
************
/*************************************************************************************************
Successful attempt using Jsoup

Description: Class that can extract the words on a website and put it into a txt file

Resources
https://aboullaite.me/jsoup-html-parser-tutorial-examples/
https://stackoverflow.com/questions/12943734/jsoup-strip-all-formatting-and-link-tags-keep-text-only
**************************************************************************************************/
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.*;
import java.util.*;

public class WordExtractor {
   //===Fields===
   String html;
   String outputName;
   
   //===Constructor(s)===
   // constructor that takes in name of a file containing html
   // source code as well as the name of a file to write the words to
   public WordExtractor(String fileName, String outputName) throws FileNotFoundException{
      this.html = htmlFromFile(fileName);
      this.outputName = outputName;
   }
   
   //===Methods===
   // takes in name of a file containing html source code
   // returns the source code as a String
   private String htmlFromFile(String fileName) throws FileNotFoundException {
      Scanner input = new Scanner(new File(fileName));
      // combine the html source code into a string
      String html = "";
      while(input.hasNext()) {
         String line = input.nextLine();
         html += line;
      }
      return html;
   }
   
   // parses and writes the words in a website to the 
   // provided file name
   public void write(String outputName) throws FileNotFoundException{
      PrintStream output = new PrintStream(outputName);
      Document doc = Jsoup.parse(html); // from resource
      output.println(doc.text()); // from resource
   }
   
   public static void main(String[] args) throws FileNotFoundException{
      WordExtractor a = new WordExtractor("file1.txt", "output1.txt");
      a.write("output1.txt");
   }
}
