p,h=166,143
while p*(3*p-1)/2!=h*(2*h-1):
    if p*(3*p-1)/2>h*(2*h-1):
        h+=1
    else:
        p+=1
print h*(2*h-1)