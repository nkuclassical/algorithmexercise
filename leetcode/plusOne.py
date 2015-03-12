class Solution:
    def plusOne(self,digits):
        tem=[]
        for i in digits:
            tem.append(str(i))
        tem=str(int(''.join(tem))+1)
        digits=[]
        for i in range(len(tem)):
            digits.append(tem[i])
        return digits