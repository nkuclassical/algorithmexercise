#I can hardly prove the alogrithm, I just get the automatic coefficients from http://www.alpertron.com.ar/QUAD.HTM
x,y,p,q,k,r,s,l=15,21,3,2,-2,4,3,-3
while y<10**12:
    x1=p*x+q*y+k
    y1=r*x+s*y+l
    x,y=x1,y1
print x