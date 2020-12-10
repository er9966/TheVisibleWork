// Justina Gao && Joia Zhang
// CSE 143 Final Project

/******************************************************************************************
Unsucessful attempt using only 14x knowledge (Currently does not work)

Description: Class that can extract the words on a website and put it into a txt file

Algorithm
   - extract keep list from html source code -> text file
   - delete non word stuff from txt file
   - result is a cleaned up txt file that only has the words of the website and no html code
   
"Keep List"
<h2>
<p>
<ul>
<title>
******************************************************************************************/
import java.io.*;
import java.util.*;

public class WebToTxt {
   //===Fields===
   Scanner input;
   PrintStream output;
   List<String> keepList;
   List<String> deleteList;
   
   //===Constructor(s)===
   public WebToTxt(Scanner input, PrintStream output, List<String> keepList, List<String> deleteList) {
      this.input = input;
      this.output = output;
      this.keepList = keepList;
      this.deleteList = deleteList;
   }
      
   //===Methods===
   // takes in a txt file of html source code
   // returns the name of a new cleaned up file, that contains
   // only the words on that website (no html code)
   private String extractWords() {
      cleanRound1;
      cleanRound2;
   }
   
   // writes text within symbols of the "keep list" into output
   private void cleanRound1() {
      while(input.hasNext()) {
         String line = input.nextLine();
         for(String s : keepList) {
            if(line.contains("<" + s + ">") {
               // write line into result file
               // write lines until </s> is found
               int startingIndex = line.indexOf("<" + s + ">") + "<" + s + ">".length();
               if(!line.contains("</" + s + ">")) {
                  // have not reached the end of this text
                  output.println(line.substring(startingIndex);
               } else {
                  // find the </s> part
                  int endingIndex = line.indexOf("</" + s + ">");
                  output.println(line.substring(startingIndex, endingIndex);
               }
            }
         } // end for
      } // end while
   }
   
   // deletes html code from the output file
   private void cleanRound1() {
      while(input.hasNext()) {
         String line = input.nextLine();
         for(String s : deleteList) {
            if(line.contains(s)) {
               // delete until the end of the html code to delte
            }
         }
      } // end while
   }

   public static void main(String[] args) {
      // retrieve file with the html source code
      Scanner console = new Scanner(System.in);
      System.out.println("Enter file name of website's html source code: ");
      String sourceCode = console.next();
      
      // set up input and output
      Scanner input = new Scanner(new File(sourceCode);
      PrintStream output = new PrintStream(new File(sourceCode.getName() + "WordsOnly.txt");
      
      // extract the words from the file (remove html code)
      WebToTxt processor = new WebToTxt(input);
      // call method
   } 
}
