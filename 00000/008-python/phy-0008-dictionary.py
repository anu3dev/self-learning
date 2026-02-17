'''
dictionary holds values in key value pair.
dictionary is mutable but key is im-mutable
keys can be int or str
'''


dic1 = {"name" : "John", "age" : 36}
print(type(dic1)) 

dic2 = {1: 'hello', 2: 3}
dic2[2] = 'world'
print(dic2)
dic2[3] = 'kiwi & cherry'
print(dic2)

print(dic2.keys())
print(dic2.values())
print(dic2.items())


passage = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
print(passage.count('is'))

# create a dictionary which will have unique str value as key and value will be count, don't use count
listWord = passage.lower().split(" ")   # convert all in lower case and create a list with all values 

dic3 = {}

for word in listWord:
    if word not in dic3:
        dic3[word] = 1
    else:
        dic3[word] = dic3[word] + 1

print(dic3)