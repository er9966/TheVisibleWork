# Justina Gao && Joia Zhang
# CSE 143 Final Project
# This program is created by modifying getOneSourceCode.py
# The goal is to use line-based processing for a .txt containing
# urls and to obtain the source code of these urls
# However, this code doesn't work because of SSL certification error :(
# Shoutout to Sanjana, Nalu, and Joanie for helping us <3

import urllib.request, urllib.parse, urllib.error
fhand = open("exampleLinks.txt", "r")
for line in fhand:
   webUrl = urllib.request.urlopen(line)
   # read the data from the URL and print it
   data = webUrl.read()
   print(data)
fhand.close()
 
