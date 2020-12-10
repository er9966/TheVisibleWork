# Justina Gao && Joia Zhang
# CSE 143 Final Project


# This program reads the data (html source code) from the URL and print it to a file 
# Sources used  :
# https://www.guru99.com/accessing-internet-data-with-python.html
# https://www.guru99.com/reading-and-writing-files-in-python.html


import urllib2

def main():
   f = open("DiversitySourceCode.txt", "w+")
   # open a connection to a URL using urllib2
   webUrl = urllib2.urlopen("https://www.washington.edu/diversity/")
  
   # read the data from the URL and print it
   data = webUrl.read()
   f.write(data)
   f.close()
 
if __name__ == "__main__":
  main()
