Max=1
def ispan(num):
    l=[]
    for i in range(1,10):
        l+=list(str(num*i))
        if len(l)>=9:
            m=list(int(i) for i in l)
            if sorted(m)==range(1,10):
                return int(''.join(l))
            else:
                return 0
for i in range(2,10000):
    Max=max(ispan(i),Max)
print Max