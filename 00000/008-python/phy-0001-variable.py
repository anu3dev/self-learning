'''
Python has no command for declaring a variable. A variable is created the moment you first 
assign a value to it. Variables do not need to be declared with any particular type, and 
can even change type after they have been set.
'''

x = 100
print("value of x is : ", x, "and type is : ", type(x))
x = "seema"
print("value of x is : ", x, "and type is : ", type(x))



'''
Rules for Python variables:

A variable name must start with a letter or the underscore character
A variable name cannot start with a number
A variable name can only contain alpha-numeric characters and underscores (A-z, 0-9, and _ )
Variable names are case-sensitive (age, Age and AGE are three different variables)
A variable name cannot be any of the Python keywords.
'''



'''
Naming in Python

Must start with letter or _
Cannot start with number
Case sensitive
Cannot use keywords
'''

# valid variables
myvar = "John"
my_var = "John"
_my_var = "John"
myVar = "John"
MYVAR = "John"
myvar2 = "John"

# many Values to Multiple Variables
p, q, r = "Orange", "Banana", "Cherry"
print(p)
print(q)
print(r)

# one Value to Multiple Variables
m = n = o = "Orange"
print(m)
print(n)
print(o)

# unpack a Collection
fruits = ["apple", "banana", "cherry"]
j, k, l = fruits
print(j)
print(k)
print(l)

# global variable
globalVar1 = "awesome"

def globalVarExample1():
  print("Python is " + globalVar1)

globalVarExample1()



# data types

d1 = "hellow world"
print(type(d1)) # str

d2 = 20
print(type(d2)) # int

d3 = 20.5
print(type(d3)) # float

d4 = 1j
print(type(d4)) # complex

d5 = ["apple", "banana", "cherry"]
print(type(d5)) # list

d6 = ("apple", "banana", "cherry")
print(type(d6)) # tuple

d7 = range(6)
print(type(d7)) # range

d8 = {"name" : "John", "age" : 36}
print(type(d8)) # dict

d9 = {"apple", "banana", "cherry"}
print(type(d9)) # set

d10 = frozenset({"apple", "banana", "cherry"})
print(type(d10)) # frozenset

d11 = True
print(type(d11)) # bool

d12 = b"Hello"
print(type(d12)) # bytes

d13 = bytearray(5)
print(type(d13)) # bytearray

d14 = memoryview(bytes(5))
print(type(d14)) # memoryview

d15 = None
print(type(d15)) # NoneType



# type Casting

tc1 = int(1)   # x will be 1
tc2 = int(2.8) # y will be 2
tc3 = int("3") # z will be 3

tc4 = float(1)     # x will be 1.0
tc5 = float(2.8)   # y will be 2.8
tc6 = float("3")   # z will be 3.0
tc7 = float("4.2") # w will be 4.2

tc8 = str("s1") # x will be 's1'
tc9 = str(2)    # y will be '2'
tc10 = str(3.0)  # z will be '3.0'