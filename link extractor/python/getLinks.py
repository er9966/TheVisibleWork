# Justina Gao && Joia Zhang
# CSE 143 Final Project

# Note - this code must run in Python 2.x and you must download
# http://www.pythonlearn.com/code/BeautifulSoup.py
# Into the same folder as this program

# All credits to Professor Charls Severance's class Python for Everyone
# https://github.com/csev/py4e/blob/master/code/urllinks.py
# We modified this program 


import urllib
from BeautifulSoup import *

url = "https://www.washington.edu/diversity/"
html = urllib.urlopen(url).read()
soup = BeautifulSoup(html)

# Retrieve all of the anchor tags
tags = soup('a')
for tag in tags:
    print tag.get('href', None)
