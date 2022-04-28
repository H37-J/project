
test = "python"
test[0]
print(test[0])

print(test[0:2])

print("J"+test[1:])

# 길이
print(len(test))


# List
arr = [1, 2, 3, 4]
print(len(arr))
print(arr[1])
print(arr[-1])

arr1 = ['a', 'b', 'c']
arr2 = [1, 2, 3]
x = [arr1, arr2]
print(x)
print(x[0][1])

a, b = 0, 1
while a < 10:
    print(a, end=",")
    a, b = b, a+b
