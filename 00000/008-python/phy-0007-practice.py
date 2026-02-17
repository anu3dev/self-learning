'''
For Loop in Python
'''

# Iterating through string
for ch in "hello":
    print(ch)

# Iterating through list
for num in [1,2,3]:
    print(num)

# Using join()
l = ["A","n","u"]
result = "".join(l)
print(result)




'''
creating a class and calling
'''

def main():
    a = 10
    b = 20
    print("a = %d, b = %d", a, b)
    a = 100
    b = 200
    print("a = %d, b = %d", a, b)

if __name__ == "__main__":
    main()




# program

x = 10

if x > 10:
    print(x/0)
else:
    print(x/1)
# output is -> 10.0



# program
a = 100
b = 100
c = 50

print(id(a), id(b), id(c))
# output is -> 140704112082952 140704112082952 140704112081352

print(type(a), type(b), type(c))
# output is -> <class 'int'> <class 'int'> <class 'int'>




'''
check if a string is a palindrome
'''

def isPalindrome(str):
    tempStr = str
    reverseStr = ""

    for ch in str:
        reverseStr = ch + reverseStr

    if tempStr == reverseStr:
        print("palindrome")
    else:
        print("not palindrome")

isPalindrome("seema")
isPalindrome("madam")
isPalindrome("racecar")
isPalindrome("anurag")