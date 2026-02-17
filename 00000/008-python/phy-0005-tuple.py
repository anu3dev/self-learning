'''
list is mutable and tuple is im-mutable.
Tuple can hold objects of different types.
Tuple supports backward and forward indexing.
only count and index method will be supported with tuple
'''

tup1 = (1, 2, 3)
print(type(tup1))

tup2 = (1, 2, 'kiwi', ['cherry', 'seema', 5], ('anurag', 7))
print(len(tup2))

tup3 = (1, 2, 3)
print(tup3[1])
tup3[1] = 7    
print(tup3[1])   # error because tuple is im-mutable.


a = 100
b = "anurag"
c = [1]
d = (1) # this will be treated as int
e = (1, 2) # this is tuple

print(type(a), type(b), type(c), type(d), type(e))

tup4 = (1, 2, 3, 1, 7, 3)
print(tup4.count(1))