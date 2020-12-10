// Justina Gao && Joia Zhang
// CSE 143 Final Project


// Welcome to the link extractor class :) This is the first part
// of our search engine project. This program helps us decided which websites
// to index for our search engine.

// What is it?
   // Given a .txt file in main, the link extractor class is able to 
   // extract all the website links out of the given .txt file.
// What features does it have?
   // .print allows you to print out all the links to console
   // .export allows you to export all the links to "link.txt" file 
   // You can also add some word filters. The program will only extract
   // the links contain those given keywords.

import java.io.*;
import java.util.*;
public class linkExtractor {
   
    private Set<String> urlFound; 
    private Scanner input;        
    private String[] wordFilter;
    // Length for a link anchor tag 
    public static final int ANCHOR_TAG_LENGTH = 6; 
      

   // Constructor for link extractor
   // Parameters:
   // @input - a Scanner .txt file to process
   // @keywords - an array of words to look for in links  
    public linkExtractor(Scanner input, String[] keywords) {
        this.urlFound = new HashSet<String>();
        this.input = input;
        this.wordFilter = keywords;
    }
    
   // Prints out the links   
    public void print() {
        process();
        for(String url : urlFound){
            System.out.println(url);
        }
    }
    
    public void export() throws FileNotFoundException {
        // only process if the procee method has not been called
        if (urlFound.isEmpty()) {
            process();    
        }
        
        Scanner console = new Scanner(System.in);
        System.out.print("output file name? ");
        String outputName = console.next();
        
        PrintStream output = new PrintStream(new File(outputName));
        for (String url : urlFound){
            output.println(url);
        }
        
    }

   // extracts the links    
    public void process() {     
         while (input.hasNextLine()){
            String currentLine = input.nextLine();
            if(currentLine.contains("href")) {
                process(currentLine);
            }
        }
    }
   
   // extracts the links
   // Parameter:
   // @line: current line of String in the .txt file to process
    private void process(String line) {
        int startingIndex = line.indexOf("href=") + ANCHOR_TAG_LENGTH;
        int endingIndex = line.indexOf("\"", startingIndex);
        // only proceeds if startingIndex is less than ending Index
        if(startingIndex < endingIndex) {
            String link = line.substring(startingIndex, endingIndex);
            // make sure the link contains all keywords before adding it to result set
            boolean isFound = containKeywords(link);
            if(isFound){
                urlFound.add(link);
            }
        }
    }
 
   // Checks if the link contains all keywords
   // Parameter:
   // @link: String of the url link
   // IMPORTANT NOTE: This format is found on the public source:
   // https://www.baeldung.com/string-contains-multiple-words
   // Only variable names have been modified.     
    private boolean containKeywords(String link) {
        boolean isFound = true;
        for(String word : wordFilter) {
            if (!link.contains(word)) {
                isFound = false;
                break;
            }
        }
        return isFound;
    }
    
    

}


