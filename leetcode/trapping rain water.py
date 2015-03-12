class Solution:
    # @param A, a list of integers
    # @return an integer
    def trap(self, A):
        leftmax,rightmax,maxL,maxR,sum=[],[],0,0,0
        for i in range(len(A)):
            if A[i]>maxL:
                maxL=A[i]
            leftmax.append(maxL)
            if A[len(A)-1-i]>maxR:
                maxR=A[len(A)-1-i]
            rightmax.append(maxR)
        for i in range(len(A)):
            sum+=min(leftmax[i],rightmax[len(A)-i-1])-A[i]
        return sum