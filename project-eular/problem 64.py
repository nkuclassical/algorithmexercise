#relative algorithm refers to http://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
import math
result=0
for i in range(2,10001):
    qs=int(math.sqrt(i))
    if qs*qs==i:
        continue
    m=0
    d=1
    tem=0
    a=qs
    while True:
        m=d*a-m
        d=(i-m**2)/d
        a=int((qs+m)/d)
        tem+=1
        if a==qs*2:
            break
    if tem%2==1:
        result+=1
print result