import math
def isprime(num):
    count=2
    while count<=math.sqrt(num):
        if num%count==0:
            return False
        count+=1
    return True
i,mulitiply=1,1
while mulitiply<=10**6:
    i+=1
    if isprime(i):
        mulitiply*=i
print mulitiply/i