a=2
b=3
for i in range(2,100):
    if i%3==2:
        a=(i+1)/3*2*b+a
    else:
        a=b+a
    a,b=b,a
sum=0
for i in str(b):
    sum+=int(i)
print sum
