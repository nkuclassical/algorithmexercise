class Solution:
    # @param A a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        low=0
        for i in range(len(A)):
            if i+2<len(A) and A[i]==A[i+2]:
                continue
            else:
                A[low]=A[i]
                low+=1
        return len(A[:low])