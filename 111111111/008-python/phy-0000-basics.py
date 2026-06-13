# print a statement
print("Hello, World!")


# python version check
import sys
print(sys.version)      


# python dummy code
if 5 > 2:
  print("Five is greater than two!")


'''
Python execution steps

Source Code (.py file)
Python compiles it to Bytecode (.pyc)
Bytecode runs on Python Virtual Machine (PVM)

👉 Python is interpreted at runtime, but internally it compiles to bytecode first.
'''

print("1 - hello")



'''
Python is Object Oriented Language - Everything in Python is an object.
'''

x = 10
print(type(x))
# output -> <class 'int'> -> Even int is an object.

class Person:
    def __init__(self, name):
        self.name = name

p = Person("Anurag")

# Supports: Encapsulation, Inheritance, Polymorphism



'''
Useful Function

like help etc.
'''

help("keywords")
help(str)
help(print)