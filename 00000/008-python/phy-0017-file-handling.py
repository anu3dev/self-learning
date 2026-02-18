'''
File handling is an important part of any web application.
Python has several functions for creating, reading, updating, and deleting files.
'''

# delete a file
import os
os.remove("008-python/helper/demofile1.txt")

# creating a file
open("008-python/helper/demofile1.txt", "x")

# reading a file
f = open("008-python/helper/demofile1.txt")
print(f.read())

# writting a file
with open("008-python/helper/demofile1.txt", "a") as f:
  f.write("Now the file has more content!")

# open and read the file after the appending:
with open("008-python/helper/demofile1.txt") as f:
  print(f.read())


# check if file exist or not
import os
if os.path.exists("008-python/helper/demofile2.txt"):
  os.remove("008-python/helper/demofile2.txt")
else:
  print("The file does not exist")


# delete a folder - you can only remove empty folder
import os
os.rmdir("008-python/a")