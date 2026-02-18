'''
OP stands for Object-Oriented Programming.
Python is an object-oriented language, allowing you to structure your code using classes and objects for better organization and reusability.

Classes and objects are the two core concepts in object-oriented programming.
A class defines what an object should look like, and an object is created based on that class. 

For example:
Class       ->      Objects
Fruit       ->      Apple, Banana, Mango
Car         ->      Volvo, Audi, Toyota
'''

# class and object example
class MyClass:
  x = 5

p1 = MyClass()
print(p1.x)



'''
__init__() is like a constructor in other languages

All classes have a built-in method called __init__(), which is always executed when the class is being initiated.

The __init__() method is used to assign values to object properties, or to perform operations that are necessary when the object is being created.

Default value can be also assigned in __init__()
'''

# class and object example
class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

person1 = Person("kiwi", 1)
print(person1.name, person1.age)

person2 = Person("cherry", 1)
print(person2.name, person2.age)



'''
The self parameter is a reference to the current instance of the class. It is used to access properties and methods that belong to the class.
'''

class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

  def greet(self):
    print("Hello, my name is " + self.name)

person3 = Person("anu3rag@gmail.com", 32)
person3.greet()