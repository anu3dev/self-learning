'''
The word "polymorphism" means "many forms", and in programming it refers to methods/functions/operators with the same name that can be executed on many objects or classes.
'''

# polymorphism
myStr = "Hello World!"
print(len(myStr))

mytuple = ("apple", "banana", "cherry")
print(len(mytuple))

thisdict = { "brand": "Ford", "model": "Mustang", "year": 1964 }
print(len(thisdict))


# polymorphism
class Car:
  def __init__(self, brand, model):
    self.brand = brand
    self.model = model

  def move(self):
    print("Drive!")

class Boat:
  def __init__(self, brand, model):
    self.brand = brand
    self.model = model

  def move(self):
    print("Sail!")

class Plane:
  def __init__(self, brand, model):
    self.brand = brand
    self.model = model

  def move(self):
    print("Fly!")

car = Car("Ford", "Mustang")       #Create a Car object
boat = Boat("Ibiza", "Touring 20") #Create a Boat object
plane = Plane("Boeing", "747")     #Create a Plane object

car.move() 
boat.move()
plane.move()


# polymorphism
class Vehicle:
  def __init__(self, brand, model):
    self.brand = brand
    self.model = model

  def move(self):
    print("Move!")

class Car(Vehicle):
  pass

class Boat(Vehicle):
  def move(self):
    print("Sail!")

class Plane(Vehicle):
  def move(self):
    print("Fly!")

car1 = Car("Ford", "Mustang")       #Create a Car object
boat1 = Boat("Ibiza", "Touring 20") #Create a Boat object
plane1 = Plane("Boeing", "747")     #Create a Plane object

for x in (car1, boat1, plane1):
  print(x.brand, x.model)
  x.move()