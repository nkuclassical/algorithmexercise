class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        while len(B)>0:
            if len(A)>0:
                for i in range(len(A)):
                    if B[0]<A[i]:
                        A.insert(i,B[0])
                        B.remove(B[0])
                if len(B)>0 and B[0]>=A[len(A)-1]:
                    A+=B
                    B=[]
            else:
                A+=B
                B=[]