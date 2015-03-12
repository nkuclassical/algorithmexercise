import math
prime=[]
def isprime(num):
    count=2
    while count<=math.sqrt(num):
        if num%count==0:
            return False
        count+=1
    return True
def produceprime():
    for i in range(1488,10000):
        if isprime(i):
            prime.append(i)
def Sort(i):
    return int(''.join(sorted(str(i))))
def do():
    produceprime()
    for i in range(len(prime)-2):
        for j in range(i+1,len(prime)-1):
            tem=2*prime[j]-prime[i]
            if Sort(prime[i])==Sort(prime[j]) and Sort(prime[i])==Sort(tem) and (tem in prime):
                    return str(prime[i])+str(prime[j])+str(tem)
    return -1
print do()