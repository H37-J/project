import sys
import mod1
with open('test.txt') as f:
    print(f.read())
    print(f.readline())

mod1.test(2, 5)

year = 2016
event = 'Referendum'
print(f'Results of the {year} {event}')

print('{0} and {1}'.format('spam', 'eggs'))
