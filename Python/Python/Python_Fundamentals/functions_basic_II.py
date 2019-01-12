# Countdown
def countdown(num):
    newArr = []
    for i in range(num, -1, -1):
        newArr.append(i)
    return newArr
print(countdown(5))

# Print and Return
def printAndReturn(arr):
    print(arr[0])
    return arr[1]
print(printAndReturn([1,2]))

# First Plus Length
def firstPlusLength(arr):
    sum = arr[0] + len(arr)
    return sum
print(firstPlusLength([1, 2, 3, 4]))

# Values Greater than Second
def valuesGreaterThanSecond(arr):
    newArr = []
    howMany = 0
    for i in arr:
        if len(arr) > 1:
            if i > arr[1]:
                newArr.append(i)
                howMany += 1
        else:
            return False
    print(howMany)
    return newArr
print(valuesGreaterThanSecond([1,2,6,15]))

# This Length, That Value
def thisLengthThatValue(size, value):
    arr = []
    for i in range(0, size):
        arr.append(value)
    return arr
print(thisLengthThatValue(4, 7))