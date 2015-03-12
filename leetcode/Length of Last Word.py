class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        if len(s)==0:
            return 0
        ls=s.split()
        for i in range(len(ls)-1,-1,-1):
            if ls[i].isalpha():
                return len(ls[i])
        return 0