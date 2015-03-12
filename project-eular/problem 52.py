def samedigit(a,b):
    l,m=sorted(list(str(a))),sorted(list(str(b)))
    if l==m:
        return True
    else:
        return False

i=1
while True:
    i+=1
    for j in range(1,7):
        if not samedigit(i,i*j):
            break
    else:
        print i
        break