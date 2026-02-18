# generate numbers in the range 50 to 100, divisib;e by 3 and 5.

print([num for num in range(50, 101) if num % 3 == 0 and num % 5 == 0])



# create a dictionary like {50 : "Even", 51 : "Odd}
print({num : "Even" if num % 2 == 0 else "Odd" for num in range(50, 61)})



# colors = ["red", "blue", "green"]
# size = ["S", "M", "L"]
# output shpould be = [('red', 'S'), ('red', 'M'), ('red', 'L'), ('blue', 'S'), ('blue', 'M'), ('blue', 'L'), ('green', 'S'), ('green', 'M'), ('green', 'L')]

colors = ["red", "blue", "green"]
sizes = ["S", "M", "L"]
print([(color, size) for color in colors for size in sizes])



# create like ((1, 'one'), (2, 'two'), (3, 'three'))
print(tuple(zip((1, 2, 3, 4), ("one", "two", "three"))))



# flatten an array
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print([num for row in matrix for num in row])


# [("A", "a", 1), ("QUICK", "quick", 5).........,("DOG", "dog", 3)]
st = "A quick brown fox jumps over a lazy dog"
print([(word.upper(), word.lower(), len(word))for word in st.split()])