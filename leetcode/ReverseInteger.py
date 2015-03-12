class Solution:
    # @return an integer
    def reverse(self, x):
        x=''.join(str(x))
        result=[]
        if x[0]=='-':
            result.append(x[0])
            result[1:]=x[len(x)-1:0:-1]
        else:
            result=x[len(x)-1::-1]
        result=int(''.join(result))
        #The question assumes that if return value >= 2^31 or <= -2^31, then return 0...
        #But actually, python can easily handle such integer range
        if result>=2**31 or result<=-2**31:
            return 0
        return result