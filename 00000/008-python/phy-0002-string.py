'''
string
'''

# Strings are Arrays
sa1 = "Hello, World!"
print(sa1[1])

for sa2 in "banana":
  print(sa2)

sa3 = "Hello, World!"
print(len(sa3))

sa4Str = "The best things in life are free!"
if "free" in sa4Str:
  print("Yes, 'free' is present.")

# Slicing Strings
str1 = "Hello, World!"
print(str1[2:5])

str2 = "Hello, World!"
print(str2[:5])

str3 = "Hello, World!"
print(str3[2:])

# Modify Strings
sm1 = "Hello, World!"
print(sm1.upper())

sm2 = "Hello, World!"
print(sm2.lower())

# string methods
sm3 = " Hello, World! "
print(sm3.strip()) # returns "Hello, World!"

sm4 = "Hello, World!"
print(sm4.replace("H", "J"))

sm5 = "Hello, World!"
print(sm5.split(",")) # returns ['Hello', ' World!']

sm6 = "Hello"
sm7 = "World"
sm8 = sm6 + sm7
print(sm8)

sm9 = "Hello"
sm10 = "World"
sm11 = sm9 + " " + sm10
print(sm11)



'''
String Methods – Strings are IMMUTABLE.
'''

s = "hello"
new_s = s.upper()
print(new_s, s)         # HELLO hello

print(s.lower())
print(s.upper())
print(s.strip())
print(s.replace("h","k"))
print(s.split(","))