class Solution:
    # @return a list of integers
    def grayCode(self, n):
        if n<=0:
            return [0]
        tem= self.grayCode(n-1)#Gray Code feature
        result=tem[:]#Don't simply use result=tem, since result will be the referrence of tem, thus Line 12 will trap in infinite loop
        add=1<<(n-1)
        for i in range(len(tem)):
            result.append(add+tem[len(tem)-1-i])
            
        return result