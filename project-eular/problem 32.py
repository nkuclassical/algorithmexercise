import math
def ispan(a,b,c):
    d=list(str(a)+str(b)+str(c))
    d=list(int(i) for i in d)
    if sorted(d)==range(1,10):
        return True
    else:
        return False
sum=0
for i in range(1000,10000):
    for j in range(2,int(math.sqrt(i))):
        if i%j==0:
            if ispan(i,j,i/j):
                print "%d * %d = %d"%(j,i/j,i)
                sum+=i
                break
print sum