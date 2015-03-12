class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        a=[]
        for i in range(numRows+1):
            tem=[]
            if i==0:
                tem.append(1)
                a.append(tem)
            else:
                for j in range(i+1):
                    if j==0:
                        tem.append(1)
                    elif j==i:
                        tem.append(1)
                    else:
                        tem.append(a[i-1][j-1]+a[i-1][j])
                a.append(tem)
        return a[numRows]