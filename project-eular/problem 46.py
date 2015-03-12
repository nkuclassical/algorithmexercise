import math
def isprime(n):
    count=2
    for count in range(2,int(math.sqrt(n))+1):
        if n%count==0:return False
    return True
def isoddcomposite(n):
    if not isprime(n): return True
    else: return False
num=9
while True:
    if isoddcomposite(num):
        prime=1
        for j in range(1,1+int(math.sqrt(num/2))):
            if isprime(num-2*(j**2)):
                prime=num-2*(j**2)
                break
        if prime==1:
            print num
            break
    num+=2    