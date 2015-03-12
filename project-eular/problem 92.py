def go(num):
    while True:
        sum=0
        for i in str(num):
            sum+=int(i)**2
        if sum==1:
            return sum
        elif sum==89:
            return sum
        else:
            num=sum

count=0
for i in range(1,10000000):
    if go(i)==89:
        count+=1
print count