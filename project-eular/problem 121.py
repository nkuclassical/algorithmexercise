import math
limit,sum,l=15,0,[1]
for i in range(limit):
    l.append(0)
    for j in range(i+2)[i+1:0:-1]:
        l[j]+=l[j-1]*(i+1)
for i in range(int(limit/2)+limit%2):
    sum+=l[i]
print math.factorial(limit+1)/sum