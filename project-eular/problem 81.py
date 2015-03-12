f=open("problem 81_matrix.txt",'r')
l=[map(int,row.split(',')) for row in f.readlines()]
for i in range(1,len(l[0])):
    l[0][i]+=l[0][i-1]
for i in range(1,len(l)):
    l[i][0]+=l[i-1][0]
    for j in range(1,len(l[i])):
        l[i][j]+=min(l[i][j-1],l[i-1][j])
print l[len(l)-1][len(l[len(l)-1])-1]