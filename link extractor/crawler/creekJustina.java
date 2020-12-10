import org.jsoup.Jsoup;             // Jsoup for web crawling
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException; // try--catch
import java.util.HashSet;

// my goal:
// https://mkyong.com/java/jsoup-basic-web-crawler-example/ by Marilena
/*  1. Identify the root webpage and get all links from that page
    2. Use Jsoup to access each URl and parse 
    3. Keep URL in a set, make sure no duplicate     
*/
// You give a URL and word to search for
// spider will go to that web page and collect:
// all words
// all URL
// If given wrod isn't found, it will go to the next page and repeat

// All the things we need to do:
//1. retrieve a web page from a website (call it a document)
// 2. collect all the links
// 3. collect all the words
// 4. see if the word we're looking for is contained in the list of words
// 5. move on to the next link

// to avoid ending up back at beginning, add few more things:
// <1> keep track of pages we've already visited
// <2> put a limit on the number of pages to search so 
// it doesn't run forever
import java.util.*;
public class Spider {
 
    // max number of pages we want
    private static final int MAX_PAGES_TO_SEARCH = 10;
    // keep track of pages we already visted
    // Why set: so there's no repeat
    private Set<String> pagesVisited;
    
    // task left to do
    // Why list: storing a bunch of URLs
    // When spider visits a page, it collects
    // all the URLs on that page, we append them to this list
    // List allow us to add an entry to the end or beginning, Set cannot
    private List<String> pagesToVisit;
    
    // constructor for initialization. We said good style
    public Spider() {
        pagesVisited = new HashSet<String>();
        pagesToVisit = new LinkedList<String>();
    }
    
    // check URL
    // author used doWhile, check with TA to see if this works
    private String nextUrl() { 
        
        String nextUrl = this.pagesToVisit.remove(0);
        
        // if pagesVisited doesn't contain this Url
        // add it to the set and 
        // return it
        if(!this.pagesVisited.contains(nextUrl)) {
            this.pagesVisited.add(nextUrl);
            return nextUrl;
        } else {
            // if pagesVisited contains this url
            // move on to the next one
            return nextUrl();
        }
        
        /*String nextUrl;
        do {
            // get the first entry from pagesToVisit
            nextUrl = this.pagesToVisit.remove(0);
        } while(this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl; */

    }
    
    
    
    

}

