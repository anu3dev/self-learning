# basically means if a condition made then come out of loop, don't go further.

seq1 = [1, 3, 5, 4, 9, 11, 13]

for num in seq1:
    if num % 2 == 0:
        print("1st : ", num, " is even")
        # break
    else:
        print("1st : ", num, " is odd")

print("")

for num in seq1:
    if num % 2 == 0:
        print("2nd : ", num, " is even")
        break
    else:
        print("2nd : ", num, " is odd")



seq2 = [1, 3, 5, 4, 9, 11, 13]
# get a list of square of every item

seqwithSquare1 = []
for num in seq2:
    seqwithSquare1.append(num**2)
print(seqwithSquare1)

seqwithSquare2 = [num**2 for num in seq2]
print(seqwithSquare2)




listItem1 = list(range(10))
print(listItem1) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

listItem2 = list(range(1, 10))
print(listItem2) # [1, 2, 3, 4, 5, 6, 7, 8, 9]

listItem3 = list(range(0, 10, 2))
print(listItem3) # [0, 2, 4, 6, 8]