# code execution process
x = 100             # 1 - Global variable created.

def funone():       # 2 - Function is defined, not executed.
    x = 10          # 4 - Local variable x created inside funone.
    def funtwo():   # 5 - Inner function is defined (not executed yet).
        x = 1       # 7 - New local variable x created inside funtwo.
        print(x)    # 8 - Because it prints funtwo's local x.
    funtwo()        # 6 - Now inner function runs.
    print(x)        # 9 - print x

funone()            # 3 - Now function execution starts.
print(x)            # 10 - print(x)



# lambda function




# while loop