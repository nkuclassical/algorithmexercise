class Solution:
    # @param s, a string
    # @return a boolean
    def isNumber(self, s):
        try:
            if s.startswith('.') and s[1]>='0' and s[1]<='9':
                s='0'+s
            float(s)
            return True
        except:
            return False