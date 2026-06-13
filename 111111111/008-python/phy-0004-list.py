'''
basics of list
'''

# Lists are used to store multiple items in a single variable.
mylist1 = ["apple", "banana", "cherry"]

# print a list
print(mylist1)

# print using for loop
for x in mylist1:
    print(x)

# get item with index from list
print(mylist1[0])

# get length of list
print(len(mylist1))

# Lists can have duplicate items
mylist2 = ["apple", "banana", "cherry", "cherry"]

# Lists can have multiple type items
mylist3 = ["apple", "banana", "cherry", "cherry", 9, 5, False]

# print type
print(type(mylist3))



'''
append a list
'''

# append an item - add item to last
mylist4 = ["apple", "banana", "cherry"]
mylist4.append("kiwi")
print(mylist4)



'''
insert item to list
'''

# insert an item - add at any index
mylist5 = ["apple", "banana", "cherry"]
mylist5.insert(0, "kiwi")
print(mylist5)

mylist6 = ["apple", "banana", "cherry"]
mylist6.insert(2, "kiwi")
print(mylist6)

# need to check how will it work
mylist7 = ["apple", "banana", "cherry"]
mylist7.insert(-1, "kiwi")
print(mylist7)



'''
delete item from list
'''

# delete last item using pop
mylist10 = ["mango", "pineapple", "papaya"]
mylist10.pop()
print(mylist10)

# delete can be done using pop with index as well
mylist11 = ["mango", "pineapple", "papaya"]
mylist11.pop(1)
print(mylist11)

# delete any specific item
mylist12 = ["mango", "pineapple", "papaya"]
mylist12.remove("papaya")
print(mylist12)



'''
extend an array
'''

# merge two array
mylist8 = ["apple", "banana", "cherry"]
mylist9 = ["mango", "pineapple", "papaya"]
mylist8.extend(mylist9)
print(mylist8)

# join
mylist21 = ["a", "b", "c"]
mylist22 = [1, 2, 3]

mylist23 = mylist21 + mylist22
print(mylist23)



'''
few opther operations
'''

# reverse a list
mylist13 = ["mango", "pineapple", "papaya"]
mylist13.reverse()
print(mylist13)

# count item
mylist14 = ["mango", "pineapple", "papaya"]
print(mylist14.count("mango"))

# sort
mylist15 = ["mango", "pineapple", "papaya"]
mylist15.sort()
print(mylist15)

# sort with method
mylist16 = ["banana", "Orange", "Kiwi", "cherry"]
mylist16.sort(key = str.lower)
print(mylist16)

# copy
mylist17 = ["apple", "banana", "cherry"]
mylist18 = mylist17.copy()

# using copy, new list is being created with new refrence so only the other one will have "seema"
mylist18.append("seema")
print(mylist17, mylist18)

# copy - another way
mylist19 = ["apple", "banana", "cherry"]
mylist20 = list(mylist19)

# using copy, new list is being created with new refrence so only the other one will have "seema"
mylist20.append("seema")
print(mylist19, mylist20)



'''
shallow copy and deep copy
'''

# shallow copy - copy does only outer level copy 
mylist21 = [[1, 2], [3, 4]]
mylist22 = mylist21.copy()

# Modify inner list
mylist22[0][0] = 100

print("mylist21:", mylist21, "mylist22:", mylist22)

# deep copy - using deepcopy() - copies deep
import copy
mylist23 = [[1, 2], [3, 4]]
mylist24 = copy.deepcopy(mylist23)

# Modify inner list
mylist24[0][0] = 100

print("mylist23:", mylist23, "mylist24:", mylist24)



'''
Iterator in Python – next()

Iterator = object that can be iterated one value at a time.
'''

l = [1,2,3]
it = iter(l)

print(next(it))  # 1
print(next(it))  # 2
print(next(it))  # 3