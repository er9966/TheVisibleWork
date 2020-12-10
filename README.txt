USER GUIDE
Justina Gao, Joia Zhang 
Group 198
CSE 143 Final Project

Before you proceed, we want to say that  
Although we have limited coding experience, 
we enjoyed every second of this project and learning new things. 
We hope you’ll enjoy it as well!

In short, our project is an interactive search engine comprised of diversity 
and equity resources, as well as work, at the University of Washington. 
Our hope is that this search engine can direct students and staff to helpful 
resources provided by the University, highlight the diversity & equity 
work that doesn't always make the headlines, but makes a longlasting impact,
as well as shed light on the many more efforts we still need to actualize.

Video Tutorial of our project: https://www.loom.com/share/3bdfbc2b5e384ede8e8cd7c6cc320089

Our program can be broken down into 3 major components: Web-Scraping, Search Engine, and Graphic User Interface (GUI)
Below is a guide on how to use each of the 3 components, and how these components work together. 

Note: Our project is not fully working yet. Our main focus was the web-scraping, as this
      was the new part introduced to what would otherwise be the same as the homework assignment.

(Only working code is listed below)


Web-Scraping
--------------------------------------------------------------------------------
Our version of webscraping involves a series of programs that
work together to produce a list of documents that can be indexed in 
the inverted index. They are as follows:

    linkExtractor.java: takes in a html source code file and a set of 
                        none-empty Strings used as word filters, extracts all the links contain 
                        those words from the source code file and print to console, 
                        also saves the result to a file you name :)

    linkExtractorMain.java: Interactive program that asks you for 
                            a html source code file input, also asks you for keywords 
                            you would like to see in the links (for example, if you input “diversity edu” , 
                            all the extracted links will contain these keywords) 
    
    getOneSourceCode.py: takes in one url link, produces a .txt file containing the html source code of the url

    WordExtractor.java: You can create an instance of the class by passing in 1) String name of file
                        containing html source code and 2) name of output file to write
                        the words inside the htmls code to

                        The spicy, main event of this class is its write method.
                        write takes in the name of the output file that you would like
                        to write the website's words into. 
               
Search Engine
--------------------------------------------------------------------------------
Does not work yet, we intend to write this in Python

Graphic User Interface (GUI)
--------------------------------------------------------------------------------
When you run this html code on Ed, you can actually see the webpage with a search bar on it… :)
(it doesn’t work but it looks cool). 
Make sure you copy and the website url and open it on a browser:)  

Ideal (but incomplete) result that we're working towards:
Type in your search query, and a list of relevant documents will appear.
You may apply additional search filters such as campus: Seattle, Tacoma, Bothell
or sort the search results by date.

How the Components Work Together
--------------------------------------------------------------------------------

Our program does not work completely, but we intend to continue working on our project 
over the winter break because we've developed a slightly unhealthy attatchment to it.

We see the components of the program working together in the following way:
Web-Scraping--------------------------------------------------------------->Search Engine---->GUI---------------------*    
url--->.txt list of associated urls--->.txt source code--->extract words--->inverted index--->searchable on GUI website

1) give a root url to getOneSourceCode.py to produce a .txt file containing the source code of that website
   (unfortunately, this program is not interactive, so you have to manually change the website)

2) input the html source code .txt file and keywords of your choice for linkExtractor.java 
   to produce a .txt file containing a list of urls appeared on the html source code.

3) (Attempted but did not work)pass this .txt list of links to getSourceCode.py, which will produce 
   a .txt file of the url's source code

4) pass names of html source code files created in 3) into wordExtractor.java which will parse the source code to return a
   .txt file of only words shown on the url's webpage (so removes html code and keeps the word on the webpage)

5) (Have not gotten here yet. We plan on re-write our search engine code in Python so we can publish it :))
  add words from 4) to inverted index and connect this to our GUI website
