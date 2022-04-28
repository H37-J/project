from collections import deque as d

arr = ['orange', 'apple', 'pear', 'banana', 'kiwi', 'apple', 'banana']

print(arr.count('apple'))
print(arr.index('banana'))
print(arr.index('banana', 4))

arr.reverse()
print(arr)
arr.append('test')
arr.sort()
print(arr)
print(arr.pop())


queue = d(["eric", "john", "mi"])
queue.append("test")
print(queue.popleft())

[(x, y) for x in [1, 2, 3] for y in [3, 1, 4] if x != y]

print([(x, y) for x in [1, 2, 3] for y in [3, 1, 4] if x != y])


vec = [-4, -2, 2]

print([x * 2 for x in vec])
print([abs(x) for x in vec])
print([(x, x*2) for x in range(6)])

matrix = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
]

print([[row[i] for row in matrix] for i in range(4)])

a = [-1, 1]
del a[0]
print(a)
a[0:1]

# SET
basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}  # 중복 자동제거
print(basket)
print('orange' in basket)  # 포함 여부 확인

set_a = set('abracadabra')
print(set_a)

set_aa = {x for x in 'abracadabra' if x not in 'abc'}
print(set_aa)

tel = {'jack': 1, "john": 2}
tel['hjk'] = 3
print(tel)

del tel['hjk']
tel_list = list(tel)
sorted(tel_list)
print(tel_list)
print('hjk' not in tel_list)

map = {'a': 1, 'b': 2}
for k, v in map.items():
    print(k, v)

for i in reversed(range(1, 10, 2)):
    print(i)

for i in sorted(set(['apple', 'apple'])):
    print(i)

str, str2, str3 = '', 'test', 'test2'
str4 = str or str2 or str3
print(str4)
