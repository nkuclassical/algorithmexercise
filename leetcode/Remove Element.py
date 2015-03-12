class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        if A==[]:
            return 0
        i=A.count(elem)
        for j in range(i):
            A.remove(elem)
        return len(A)