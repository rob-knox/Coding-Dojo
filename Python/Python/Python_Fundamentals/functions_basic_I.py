# 10/15 Correct

def a():
    return 5
print(a())  
# 5 / Correct

def a():
    return 5
print(a()+a())
# 10 / Correct

def a():
    return 5
    return 10
print(a())     
# 5 / Correct

def a():
    return 5
    print(10)
print(a())  
#5 / Correct

def a():
    print(5)
x = a()
print(x) 
# undefined // Incorrect: returned 5, none

def a(b,c):
    print(b+c)
print(a(1,2) + a(2,3))
# undefined // Type error kinda correct

def a(b,c):
    return str(b)+str(c)
print(a(2,5))
# 25 // Correct

def a():
    b = 100
    print(b)
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(a())  
# 10 // Incorrect

def a(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(a(2,3))
print(a(5,3))
print(a(2,3) + a(5,3))
# 7, 14, 21 // Correct

def a(b,c):
    return b+c
    return 10
print(a(3,5))     
# 8 // Correct

b = 500
print(b)
def a():
    b = 300
    print(b)
print(b)
a()
print(b) 
# 500, 500, 300, 500 // Correct

b = 500
print(b)
def a():
    b = 300
    print(b)
    return b
print(b)
a()
print(b)
# 500, 500, 300, 300, 500 // Incorrect. Returned 500, 500, 300, 500

b = 500
print(b)
def a():
    b = 300
    print(b)
    return b
print(b)
b=a()
print(b)
# 500, 500, 300, 500 // Incorrect. Returned 500, 500, 300, 300

def a():
    print(1)
    b()
    print(2)
def b():
    print(3)
a()
# 1, 3, 2 // Correct

def a():
    print(1)
    x = b()
    print(x)
    return 10
def b():
    print(3)
    return 5
y = a()
print(y)
# 10, 1, 5, 10 // Incorrect. Returned 1, 3, 5, 10