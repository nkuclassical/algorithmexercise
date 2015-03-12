class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        a,b='0b'+a,'0b'+b
        a,b=int(a,2),int(b,2)
        return str(bin(a+b))[2:]
num=Solution()
print num.addBinary('11','1')
