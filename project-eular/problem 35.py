def is_prime(n):
    for i in range(2, int (n**0.5)+1):
        if n%i==0:
            return False
    return True
print sum(1 for i in range(3,1000000+1,2) if all((is_prime(int((str(i))[j:]+(str(i))[:j]))) for j in range(len(str(i)))))+1    