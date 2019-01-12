# Basic
for i in range(0, 151):
    print(i)

# Multiples of Five
for i in range(5, 1000005):
    if i % 5 == 0:
        print(i)

# Counting, the Dojo Way
for i in range(1, 105):
    if i % 5 == 0:
        print("Coding")
    else:
        print("Dojo")

# Whoa. That Sucker's Huge
sum = 0
for i in range(0, 500000):
    if i % 2 != 0:
        sum += i   
print(sum)

# Countdown by Fours
for i in range(2018, 0, -1):
    if i % 4 == 0:
        print(i)

# Flexible Countdown
lowNum = 2
highNum = 9
mult = 3
for i in range(lowNum, highNum):
    if (i % mult == 0):
        print(i)

lowNum = 3
highNum = 6
mult = 9
for i in range(lowNum, highNum):
    if (i % mult == 0):
        print(i)
