class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if len(A)==0:
            return 0
        else:
            p1=0
            for i in range(len(A)):
                if A[p1]==A[i]:
                    continue
                else:
                    p1+=1
                    A[p1]=A[i]
            return p1+1