class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if len(s)==0:return True
        low,high=0,len(s)-1
        while low<high:
            while not (s[low].isdigit() or s[low].isalpha()) and low<high:
                low+=1
            while not (s[high].isdigit() or s[high].isalpha()) and high>low:
                high-=1
            if s[low].lower()!=s[high].lower():
                return False
            else:
                low,high=low+1,high-1
        return True