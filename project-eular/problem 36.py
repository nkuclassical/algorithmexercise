def ispalin(num):
    for i in range(len(num)/2):
        if i!=len(num)-i-1 and num[i]!=num[len(num)-i-1]:
            return False
    return True
s=[]
for i in range(1000000):
    if ispalin(str(i)) and ispalin(bin(i)[2:]):
        s.append(i)
print sum(s)