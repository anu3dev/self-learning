'''
Set stores non-duplicate items.
set is an iterable onject
Set doesn't support indexing
Sets are mutable but elements of a set should be immutables
Order won't be fixed
'''

se1 = {1, 2, 3}
print(type(se1))
# print(len(se1[0]))  # error as set doesn't suppport indexing
print(len(se1))

se2 = {7}
se2.add(8)
se2.add(11)
print(len(se2))

se3 = {1, 2, 3, 4}
se4 = {1, 4}
print(se4.issubset(se3))


import random
list1 = [random.randrange(90, 100) for y in range(20)] # created random number
print(list1)
se4 = list(set(list1)) # creating set and it will automatically remove suplicates
print(se4)


# need to go deep in set methods like difference, symetric difference, union etc.